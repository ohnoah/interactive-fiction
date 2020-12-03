import java.util.List;
import java.util.Map;

public class BasicGameEngine extends GameEngine {
   Map<String, String> worldState;
   Map<String, Room> worldRooms;
   Entry<String, Room> currentRoomEntry;



   @Override
   public List<ActionFormat> possibleGameActions() {
      return null;
   }

   @Override
   public List<String> possibleItemNames() {
      return null;
   }

   @Override
   public String progressStory(ConcreteGameAction gameAction) {
      return null;
   }
}
