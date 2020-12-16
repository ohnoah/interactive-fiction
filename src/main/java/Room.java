import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// Note: Names of rooms must be unique and need to verify this in user code

public class Room {
   private String name;
   // TODO: In enhanced maybe items are more sophisticated
   private List<String> items;

   public Room(String name){
      this.name = name;
   }

   public Room(String name, List<String> items) {
      this.name = name;
      this.items = new ArrayList<>();
      this.items.addAll(items);
   }

   public List<String> getItems() {
      List<String> al = new ArrayList<>();
      al.addAll(items);
      return al;
   }

   public void setItems(List<String> items) {
      this.items = new ArrayList<>();
      this.items.addAll(items);
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      Room room = (Room) o;
      return getName().equals(room.getName());
   }

   @Override
   public int hashCode() {
      return Objects.hash(getName());
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

}
