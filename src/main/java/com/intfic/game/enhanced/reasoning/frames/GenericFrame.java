package com.intfic.game.enhanced.reasoning.frames;

import com.intfic.game.shared.Util;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
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
          " id='" + id + '\'' +
          " ,\n slots=" + slots +
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
      GenericFrame that = (GenericFrame) o;
      Map<String, Object> thatSlots = that.getSlots();
      for(Map.Entry<String, Object> entry : this.slots.entrySet()){
         String key = entry.getKey();
         Object value = entry.getValue();
         if(!thatSlots.containsKey(key)){
            return false;
         }
         Object otherVal = that.slots.get(key);
         if(value instanceof Double && otherVal instanceof Double){
            return ((Double) value).equals((Double) otherVal);
         }
         else if(value instanceof Double && otherVal instanceof Double){

         }
         else if(value instanceof List && otherVal instanceof List){
            return ((List) value).equals((List) otherVal);
         }
      }
      return id.equals(that.id);
   }

   @Override
   public int hashCode() {
      return Objects.hash(id, slots);
   }
}
