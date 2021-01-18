package com.enhanced.reasoning;

import com.enhanced.reasoning.exceptions.MissingKnowledgeException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

public class SpecificFrame implements Serializable {

   private String id;
   private Map<String, Object> slots;
   private List<GenericFrame> parents;

   public SpecificFrame(@NotNull String id) {
      this.id = id;
      this.slots = new HashMap<>();
      this.parents = new ArrayList<>();
   }

   public SpecificFrame(@NotNull String id, @NotNull Map<String, Object> slots, @NotNull List<GenericFrame> parents) {
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

   public Map<String, Object> getSlots() {
      return new HashMap<>(slots);
   }

   public Object getFiller(String slotName) throws MissingKnowledgeException {
      if (slots.containsKey(slotName)) {
         // TODO: DO type inference here and return as the right type
         return slots.get(slotName);
      }
      else {
         String missingString = String.format("Item: %s doesn't have a \"%s\".", this.getId(), slotName);
         throw new MissingKnowledgeException(missingString, missingString);
      }
   }

   public void setSlots(Map<String, Object> slots) {
      this.slots = new HashMap<>(slots);
   }

   public void updateFiller(@NotNull String slotName, @NotNull Object filler) {
      slots.put(slotName, filler);
   }


   // Whatever is in the slots map takes precedence over inheritance that is added
   public void addParent(@NotNull GenericFrame parent) {
      for (Map.Entry<String, Object> entry : parent.getSlots().entrySet()) {
         String slotName = entry.getKey();
         Object filler = entry.getValue();
         if (!slots.containsKey(slotName)) {
            updateFiller(slotName, filler);
         }
      }
      parents.add(parent);
   }

   @Override
   public String toString() {
      return "SpecificFrame{" +
          "id='" + id + '\'' +
          ", slots=" + slots +
          ", parents=" + parents +
          '}';
   }
}
