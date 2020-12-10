import com.sun.istack.NotNull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BasicGameEngine extends GameEngine {
   private Map<String, String> worldState;
   // room name maps
   private Map<Room, Map<ConcreteGameAction, GameDesignAction>> designerActions;
   private List<Room> worldRooms;
   private Room currentRoom;

   public BasicGameEngine() {
      worldState = new HashMap<>();
      designerActions = new HashMap<>();
      worldRooms = new ArrayList<>();
      currentRoom = null;
   }

   public BasicGameEngine(@NotNull List<Room> rooms, @NotNull  Room startRoom, @NotNull Map<Room, Map<ConcreteGameAction, GameDesignAction>> allowedActions) {
      this.worldRooms = rooms;
      this.currentRoom = startRoom;
      this.designerActions = allowedActions;
      this.worldRooms.forEach(x -> designerActions.put(x, new HashMap<ConcreteGameAction, GameDesignAction>()));
      this.worldState = new HashMap<>();
      // TODO: keep this in sync
      this.worldState.put("room", startRoom.getName());
   }


   // Todo: might want empty constructor so we can pick from these
   @Override
   public List<ActionFormat> possibleActionFormats() {
      // very common
      ActionFormat examine = new ActionFormat("examine", null);
      ActionFormat push = new ActionFormat("push", null);
      ActionFormat take = new ActionFormat("take", null);
      ActionFormat pull = new ActionFormat("pull", null);
      ActionFormat drop = new ActionFormat("drop", null);
      ActionFormat turn = new ActionFormat("turn", null);
      ActionFormat open = new ActionFormat("open", null);
      ActionFormat feel = new ActionFormat("feel", null);
      ActionFormat putIn = new ActionFormat("put", "put ([\\w\\s]+) in ([\\w\\s]+)$");
      ActionFormat putOn = new ActionFormat("put", "put ([\\w\\s]+) on ([\\w\\s]+)$");
      // you could also try
      ActionFormat eat = new ActionFormat("eat", null);
      ActionFormat climb = new ActionFormat("climb", null);
      ActionFormat drink = new ActionFormat("drink", null);
      ActionFormat wave = new ActionFormat("wave", null);
      ActionFormat fill = new ActionFormat("fill", null);
      ActionFormat wear = new ActionFormat("wear", null);
      ActionFormat smell = new ActionFormat("smell", null);
      ActionFormat listenTo = new ActionFormat("listen", "listen to ([\\w\\s]+)$");
      ActionFormat breakIt = new ActionFormat("break", null);
      ActionFormat burn = new ActionFormat("burn", null);
      ActionFormat enter = new ActionFormat("enter", null);
      ActionFormat search = new ActionFormat("search", null);
      ActionFormat unlockWith = new ActionFormat("unlock", "unlock ([\\w\\s]+) with ([\\w\\s]+)$");

      return List.of(examine, push, take, pull, drop, turn, open, feel, putIn,
          putOn, eat, climb, drink, wave, fill, wear, smell, listenTo, breakIt, burn, enter, search, unlockWith);
   }

   @Override
   public List<String> possibleItemNames() {
      return this.currentRoom.getItems();
   }

   protected boolean validatePrecondition(Map<String, String> wantedGlobalState) {
      for (Map.Entry<String, String> entry : wantedGlobalState.entrySet()) {
         String key = entry.getKey();
         String wantedValue = entry.getValue();
         if (!worldState.containsKey(key) || !worldState.get(key).equals(wantedValue)) {
            System.err.println(key);
            System.err.println(worldState.get(key));
            return false;
         }
      }
      return true;
   }

   // set after effects

   // move room


   @Override
   public String progressStory(ConcreteGameAction gameAction) {

      Room currentRoom = getCurrentRoom();

      GameDesignAction designAction = getGameDesignAction(gameAction, currentRoom);
      if (designAction == null) {
         return "You can't do that right now";
      }
      Map<String, String> wantedGlobalState = new HashMap<>();
      wantedGlobalState.putAll(designAction.getPreconditions());

      boolean preCondSatisfied = validatePrecondition(wantedGlobalState);
      if (!preCondSatisfied) {
         return "You can't do that yet";
      }
      String message = designAction.getMessage();

      updateWorldState(designAction);

      return message;

   }

   protected void updateWorldState(GameDesignAction gameDesignAction) {
      Map<String, String> updateState = gameDesignAction.getUpdateState();
      // TODO: Consider more advanced post conditions for enhanced engine
      worldState.entrySet().forEach(System.out::println);
      worldState.putAll(updateState);
      worldState.entrySet().forEach(System.out::println);
      if (updateState.containsKey("room")) {
         moveRoom(updateState.get("room"));
      }
   }

   protected void moveRoom(String roomName) {
      List<Room> matched = worldRooms.stream()
          .filter(room -> roomName.equals(room.getName()))
          .collect(Collectors.toList());
      if (matched.size() == 1) {
         currentRoom = matched.get(0);
      } else {
         System.err.println("Invalid room. Contact system administrator.");
      }

   }

   protected String getActionMessage(Room currentRoom, ConcreteGameAction gameAction) {
      Map<ConcreteGameAction, GameDesignAction> gameDesignActions = designerActions.get(currentRoom);
      return gameDesignActions.get(gameAction).getMessage();
   }

   protected Room getCurrentRoom() {
      return this.currentRoom;
   }

   protected void getPreconditionedState(GameDesignAction designAction, Map<String, String> globalStateCondition) {
      globalStateCondition.putAll(designAction.getPreconditions());
   }

   protected GameDesignAction getGameDesignAction(ConcreteGameAction gameAction, Room currentRoom) {
      if (designerActions.containsKey(currentRoom)) {
         Map<ConcreteGameAction, GameDesignAction> gameDesignActions = designerActions.get(currentRoom);
         if (gameDesignActions.containsKey(gameAction)) {
            return gameDesignActions.get(gameAction);
         }
      }
      return null;
   }
}
