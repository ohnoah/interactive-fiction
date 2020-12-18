import java.io.Serializable;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

public class Item implements Serializable {
   private static final long serialVersionUID = 955696338515449495L;
   private String name;

   public Item(@NotNull String name) {
      this.name = name;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }
   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      Item item = (Item) o;
      return getName().equals(item.getName());
   }

   @Override
   public int hashCode() {
      return Objects.hash(getName());
   }
}
