import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

public class GenericFrame {

   private String id;


   private Map<String, String> slots;

   public GenericFrame(@NotNull String id) {
      this.id = id;
      this.slots = new HashMap<>();
   }

   public void addSlots(Map<String, String> slots) {
      this.slots.putAll(slots);
   }

   public String getId() {
      return id;
   }

   public Map<String, String> getSlots() {
      return new HashMap<>(slots);
   }

}
