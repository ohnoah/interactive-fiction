import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import org.jetbrains.annotations.NotNull;

// Note: Names of rooms must be unique and need to verify this in user code

public class Room implements Serializable {
   private static final long serialVersionUID = 7378519455619006377L;
   private String name;
   // TODO: In enhanced maybe items are more sophisticated
   private Set<Item> items;

   public Room(@NotNull String name){
      this.name = name;
   }

   public Room(String name, List<Item> items) {
      this.name = name;
      this.items = new HashSet<>();
      this.items.addAll(items);
   }

   public Set<Item> getItems() {
      Set<Item> al = new HashSet<>();
      al.addAll(items);
      return al;
   }

   public void setItems(Set<Item> items) {
      this.items = new HashSet<>();
      this.items.addAll(items);
   }
   public void setItemsNoAdjectives(List<String> items){
      this.items = items.stream().map(Item::new).collect(Collectors.toSet());
   }

   @Override
   public String toString() {
      return "Room{" +
          "name='" + name + '\'' +
          ", items=" + items +
          '}';
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

   public boolean validItems(List<String> items){
      return items.stream().allMatch(x -> this.items.contains(x));
   }
}
