import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BasicGameEngine extends GameEngine {
   private Map<String, String> worldState;
   // room name maps
   private Map<Room, Map<InstantiatedGameAction, GameDesignAction>> designerActions;
   private List<Room> worldRooms;

   public void setCurrentRoom(Room currentRoom) {
      this.currentRoom = currentRoom;
      this.worldState.put("room", currentRoom.getName());
   }

   private Room currentRoom;

   public BasicGameEngine() {
      super();
      worldState = new HashMap<>();
      designerActions = new HashMap<>();
      worldRooms = new ArrayList<>();
      currentRoom = null;
   }

   public BasicGameEngine(@NotNull List<Room> rooms, @NotNull  Room startRoom, @NotNull Map<Room, Map<InstantiatedGameAction, GameDesignAction>> allowedActions) {
      super();
      this.worldRooms = rooms;
      this.designerActions = allowedActions;
      this.worldRooms.forEach(x -> designerActions.putIfAbsent(x, new HashMap<InstantiatedGameAction, GameDesignAction>()));
      this.worldState = new HashMap<>();
      setCurrentRoom(startRoom);
   }

   // TODO: This should probably use exceptions
   public void addRoom(@NotNull Room room){
      if(!worldRooms.contains(room)){
         worldRooms.add(room);
         designerActions.putIfAbsent(room, new HashMap<>());
      }
   }

   public void addAction(@NotNull Room roomForAction, @NotNull InstantiatedGameAction triggeringAction, @NotNull GameDesignAction effectAction) {
      Map<InstantiatedGameAction, GameDesignAction> actionsInRoom = designerActions.getOrDefault(roomForAction, new HashMap<>());
      actionsInRoom.put(triggeringAction, effectAction);
   }

   @Override
   public int getNumRooms() {
      return worldRooms.size();
   }

   @Override
   public List<Room> findRoom(String roomName) {
      return worldRooms.stream()
          .filter(room -> roomName.equals(room.getName()))
          .collect(Collectors.toList());
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
            return false;
         }
      }
      return true;
   }

   // set after effects

   // move room


   @Override
   public String progressStory(InstantiatedGameAction gameAction) {

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
      worldState.putAll(updateState);
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

   protected String getActionMessage(Room currentRoom, InstantiatedGameAction gameAction) {
      Map<InstantiatedGameAction, GameDesignAction> gameDesignActions = designerActions.get(currentRoom);
      return gameDesignActions.get(gameAction).getMessage();
   }

   public Room getCurrentRoom() {
      return this.currentRoom;
   }

   protected void getPreconditionedState(GameDesignAction designAction, Map<String, String> globalStateCondition) {
      globalStateCondition.putAll(designAction.getPreconditions());
   }

   protected GameDesignAction getGameDesignAction(InstantiatedGameAction gameAction, Room currentRoom) {
      if (designerActions.containsKey(currentRoom)) {
         Map<InstantiatedGameAction, GameDesignAction> gameDesignActions = designerActions.get(currentRoom);
         if (gameDesignActions.containsKey(gameAction)) {
            return gameDesignActions.get(gameAction);
         }
      }
      return null;
   }
}
