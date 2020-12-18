import java.util.List;
import org.jetbrains.annotations.NotNull;

public class EnhancedGameEngine extends GameEngine{
   private static final long serialVersionUID = -4373751472843245010L;
   @Override
   public List<String> possibleItemNames() {
      return null;
   }

   @Override
   public String progressStory(InstantiatedGameAction gameAction) {
      return null;
   }

   @Override
   public Room getCurrentRoom() {
      return null;
   }

   @Override
   public void setCurrentRoom(Room currentRoom) {

   }

   @Override
   public void addRoom(@NotNull Room room) {

   }

   @Override
   public void addAction(@NotNull Room roomForAction, @NotNull InstantiatedGameAction triggeringAction, @NotNull GameDesignAction effectAction) {

   }

   @Override
   public int getNumRooms() {
      return 0;
   }

   @Override
   public List<Room> findRoom(String roomName) {
      return null;
   }
}
