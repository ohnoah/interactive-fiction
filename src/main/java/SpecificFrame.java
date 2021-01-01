import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

public class SpecificFrame {

   private String id;
   private Map<String, String> slots;
   private List<GenericFrame> parents;

   public SpecificFrame(@NotNull String id){
      this.id = id;
      this.slots = new HashMap<>();
      this.parents = new ArrayList<>();
   }

   public SpecificFrame(@NotNull String id, @NotNull Map<String, String> slots, @NotNull List<GenericFrame> parents) {
      this.id = id;
      this.slots = slots;
      for (GenericFrame parent : parents) {
         addParent(parent);
      }
   }


   public String getId() {
      return id;
   }

   public List<GenericFrame> getParents() {
      return new ArrayList<>(parents);
   }

   public Map<String, String> getSlots() {
      return new HashMap<>(slots);
   }

   public String getFiller(String slotName){
      return slots.get(slotName);
   }

   public void setSlots(Map<String, String> slots) {
      this.slots = new HashMap<>(slots);
   }

   public void updateFiller(@NotNull String slotName, String filler) {
      slots.put(slotName, filler);
   }


   // Whatever is in the slots map takes precedence over inheritance that is added
   public void addParent(@NotNull GenericFrame parent) {
      for (Map.Entry<String, String> entry : parent.getSlots().entrySet()) {
         String slotName = entry.getKey();
         String filler = entry.getValue();
         if (!slots.containsKey(slotName)) {
            updateFiller(slotName, filler);
         }
      }
      parents.add(parent);
   }
}
