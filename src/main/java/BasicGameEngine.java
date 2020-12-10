import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BasicGameEngine extends GameEngine {
   private Map<String, String> worldState;
   // room name maps
   private Map<Room, Map<ConcreteGameAction, GameDesignAction>> designerActions;
   private List<Room> worldRooms;
   private Room currentRoom;



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
      ActionFormat putIn = new ActionFormat("put","put ([\\w\\s]+) in ([\\w\\s]+)$");
      ActionFormat putOn = new ActionFormat("put","put ([\\w\\s]+) on ([\\w\\s]+)$");
      // you could also try
      ActionFormat eat = new ActionFormat("eat", null);
      ActionFormat climb = new ActionFormat("climb", null);
      ActionFormat drink = new ActionFormat("drink", null);
      ActionFormat wave = new ActionFormat("wave", null);
      ActionFormat fill = new ActionFormat("fill", null);
      ActionFormat wear = new ActionFormat("wear", null);
      ActionFormat smell = new ActionFormat("smell", null);
      ActionFormat listenTo = new ActionFormat("listen","listen to ([\\w\\s]+)$");
      ActionFormat breakIt = new ActionFormat("break",null);
      ActionFormat burn = new ActionFormat("burn",null);
      ActionFormat enter = new ActionFormat("enter",null);
      ActionFormat search = new ActionFormat("search",null);
      ActionFormat unlockWith = new ActionFormat("unlock","unlock ([\\w\\s]+) with ([\\w\\s]+)$");

      return List.of(examine, push, take, pull, drop, turn, open, feel, putIn,
          putOn, eat, climb, drink, wave, fill, wear, smell, listenTo, breakIt, burn, enter, search, unlockWith);
   }

   @Override
   public List<String> possibleItemNames() {
      return null;
      //return getCurrentRoom().getItems();
   }
   private boolean validatePrecondition(ConcreteGameAction gameAction, Map<String, String> wantedGlobalState){
      for(Map.Entry<String, String> entry : wantedGlobalState.entrySet()){
         String key = entry.getKey();
         String wantedValue = entry.getValue();
         if(!worldState.containsKey(key) || !worldState.get(key).equals(wantedValue)){
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
      Map<String, String> wantedGlobalState = null;
      String preconditionMessage = getPreconditionedState(gameAction, currentRoom, wantedGlobalState);
      if(preconditionMessage != null){
         return preconditionMessage;
      }
      boolean preCondSatisfied = validatePrecondition(gameAction, wantedGlobalState);
      if(!preCondSatisfied) {
         return "You can't do that yet";
      }
      updateWorldState(currentRoom, gameAction);

      String message = getActionMessage(currentRoom, gameAction);
      return message;

   }

   private void updateWorldState(Room currentRoom, ConcreteGameAction gameAction) {
      Map<ConcreteGameAction, GameDesignAction> gameDesignActions = designerActions.get(currentRoom);
      Map<String, String> updateState = gameDesignActions.get(gameAction).getUpdateState();
      // TODO: Consider more advanced post coonditions for enhanced engine
      worldState.putAll(updateState);
      if(updateState.containsKey("room")){
         moveRoom(updateState.get("room"));
      }
   }

   private void moveRoom(String roomName) {
      List<Room> matched = worldRooms.stream()
          .filter(room -> roomName.equals(room.getName()))
          .collect(Collectors.toList());
      if(matched.size() == 1){
         currentRoom = matched.get(0);
      }
      else{
         System.err.println("Invalid room. Contact system administrator.");
      }

   }

   private String getActionMessage(Room currentRoom, ConcreteGameAction gameAction ) {
      Map<ConcreteGameAction, GameDesignAction> gameDesignActions = designerActions.get(currentRoom);
      return gameDesignActions.get(gameAction).getMessage();
   }
   private Room getCurrentRoom() {


      return this.currentRoom;
   }

   private String getPreconditionedState(ConcreteGameAction gameAction, Room currentRoom, Map<String, String> globalStateCondition) {
      if(designerActions.containsKey(currentRoom)) {
         Map<ConcreteGameAction, GameDesignAction> gameDesignActions = designerActions.get(currentRoom);
         if(gameDesignActions.containsKey(gameAction)){
            globalStateCondition.putAll(gameDesignActions.get(gameAction).getPreconditions());
            return null;
         }
         else{
            return "You can't do that right now.";
         }
      }
      return "You are in a faulty room. Consult the game developer.";
   }
}
