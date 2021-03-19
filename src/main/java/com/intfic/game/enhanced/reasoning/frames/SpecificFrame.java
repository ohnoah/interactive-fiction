package com.intfic.game.enhanced.reasoning.frames;

import com.intfic.game.enhanced.reasoning.error.MissingKnowledgeException;
import com.intfic.game.shared.Util;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.collections.CollectionUtils;
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

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      SpecificFrame that = (SpecificFrame) o;
      return this.getId().equals(that.getId()) &&
          Util.objectMapEquals(this.getSlots(), that.getSlots()) &&
          CollectionUtils.isEqualCollection(this.getParents(), that.getParents());
   }

   @Override
   public int hashCode() {
      return Objects.hash(id, slots, parents);
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
         return slots.get(slotName);
      }
      else {
         String missingString = String.format("Item: %s doesn't have a \"%s\".", this.getId(), slotName);
         throw new MissingKnowledgeException(missingString, missingString);
      }
   }

   public Object getFiller(String slotName, Object def) throws MissingKnowledgeException {
      return slots.getOrDefault(slotName, def);
   }

   public void setSlots(Map<String, Object> slots) {
      this.slots = new HashMap<>(slots);
   }

   public void updateFiller(@NotNull String slotName, @NotNull Object filler) {
      if (filler instanceof List) { // List is the only mutable type we store and must take precautions here
         this.slots.put(slotName, new ArrayList<>((List) filler));
      }
      else {
         this.slots.put(slotName, filler);
      }
   }


   // WARNING: Whatever is in the slots map DOES NOT take precedence over inheritance that is added
   // WARNING: Precedence is given to the latest added parent
   public void addParent(@NotNull GenericFrame parent) {
      for (Map.Entry<String, Object> entry : parent.getSlots().entrySet()) {
         String slotName = entry.getKey();
         Object filler = entry.getValue();
         updateFiller(slotName, filler);
      }
      parents.remove(parent);
      parents.add(parent);
   }

   @Override
   public String toString() {
      return "SpecificFrame{" +
          " id='" + id + '\'' +
          ",\n slots=" + slots +
          '}';
   }
}
