package com.enhanced.reasoning;

import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

public class GenericFrame {

   private String id;


   private Map<String, Object> slots;

   public GenericFrame(@NotNull String id) {
      this.id = id;
      this.slots = new HashMap<>();
   }

   public void addSlots(Map<String, Object> slots) {
      this.slots.putAll(slots);
   }

   public String getId() {
      return id;
   }

   public Map<String, Object> getSlots() {
      return new HashMap<>(slots);
   }

}
