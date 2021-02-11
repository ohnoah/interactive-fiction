package com.intfic.game.shared;

import com.intfic.game.enhanced.EnhancedGameEngine;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import org.jetbrains.annotations.NotNull;

public class Item implements Serializable {
   private static final long serialVersionUID = -2769417686782978456L;
   private String name;
   // Both of these should be sets
   private Set<String> adjectives;
   private Set<String> synonyms;

   private Room parentRoom;


   private String id;
   private static char SEPARATOR = '_';


   public String idGenerator(@NotNull String roomName, @NotNull Collection<Item> currentItems) {
      long count = EnhancedGameEngine.numberOfItemsWithName(currentItems, this.name);

      return (roomName.replaceAll(" ", String.valueOf(SEPARATOR)) + "." +
          this.name.replaceAll(" ", String.valueOf(SEPARATOR)) +
          (count != 1 ? SEPARATOR + count : "")).toLowerCase();
   }

   public Item(@NotNull String name) {
      this.name = name;
      setParentRoom(EnhancedGameEngine.unassignedItemRoom, EnhancedGameEngine.unassignedItemRoom.getItems().values());
      synonyms = new HashSet<>();
      adjectives = new HashSet<>();
   }


   public Item(@NotNull String name, @NotNull Set<String> defaultAdjectives) {
      this.name = name;
      setParentRoom(EnhancedGameEngine.unassignedItemRoom, EnhancedGameEngine.unassignedItemRoom.getItems().values());
      setAdjectives(defaultAdjectives);
      this.synonyms = new HashSet<>();
   }

   public Item(@NotNull String name, @NotNull Set<String> defaultAdjectives, @NotNull Set<String> synonyms) {
      this.name = name;
      setParentRoom(EnhancedGameEngine.unassignedItemRoom, EnhancedGameEngine.unassignedItemRoom.getItems().values());
      setAdjectives(defaultAdjectives);
      setSynonyms(synonyms);
   }

   @Override
   public String toString() {
      return String.format("[%s] %s", String.join(",", adjectives), id);
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
      return getID().equals(item.getID());
   }

   @Override
   public int hashCode() {
      return Objects.hash(getID());
   }

   public Set<String> getAdjectives() {
      return adjectives;
   }

   public void setAdjectives(Set<String> adjectives) {
      this.adjectives = new HashSet<>(adjectives);
   }

   public String getID() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }

   public Set<String> getSynonyms() {
      return synonyms;
   }

   public void setSynonyms(Set<String> synonyms) {
      this.synonyms = new HashSet<>(synonyms);
   }

   public Room getParentRoom() {
      return parentRoom;
   }

   public void setParentRoom(@NotNull Room originalRoom, @NotNull Collection<Item> currentItems) {
      if (this.parentRoom == null || this.parentRoom.equals(EnhancedGameEngine.unassignedItemRoom)) {
         this.id = idGenerator(originalRoom.getName(), currentItems);
      }
      this.parentRoom = originalRoom;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

}
