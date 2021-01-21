package com.intfic.game.enhanced.reasoning.frames;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

public class GenericFrame implements Serializable {

   private static final long serialVersionUID = -3480563600103315438L;
   private String id;


   private Map<String, Object> slots;

   public GenericFrame(@NotNull String id) {
      this.id = id;
      this.slots = new HashMap<>();
   }

   public void addSlots(Map<String, Object> slots) {
      for (Map.Entry<String, Object> entry : slots.entrySet()) {
         this.slots.put(entry.getKey(), entry.getValue());
      }
   }

   public void addSlot(String slot, Object filler) {
      this.slots.put(slot, filler);
   }

   public String getId() {
      return id;
   }

   public Map<String, Object> getSlots() {
      return new HashMap<>(slots);
   }

   @Override
   public String toString() {
      return "GenericFrame{" +
          "id='" + id + '\'' +
          ", slots=" + slots +
          '}';
   }
}
