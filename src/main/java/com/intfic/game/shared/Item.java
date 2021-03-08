package com.intfic.game.shared;

import com.intfic.game.enhanced.EnhancedGameEngine;
import java.io.Serializable;
import java.util.ArrayList;
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


   private Room originalRoom;


   private String id;
   private static char SEPARATOR = '_';

   public Room getOriginalRoom() {
      return originalRoom;
   }

   public void setOriginalRoom(Room originalRoom) {
      this.originalRoom = originalRoom;
   }

   public static String roomId(@NotNull String roomName) {
      return roomName.replaceAll(" ", String.valueOf(SEPARATOR)).toLowerCase();
   }

   public String idGenerator(@NotNull String roomName, @NotNull List<Item> currentItems) {
      long count = EnhancedGameEngine.numberOfItemsWithName(currentItems, this.name);

      return (roomId(roomName) + "." +
          this.name.replaceAll(" ", String.valueOf(SEPARATOR)) +
          (count != 1 ? SEPARATOR + "" + count : "")).toLowerCase();
   }

   public Item(@NotNull String name) {
      this.name = name;
      setParentRoom(GameEngine.unassignedItemRoom, new ArrayList<>(GameEngine.unassignedItemRoom.getItems().values()));
      synonyms = new HashSet<>();
      adjectives = new HashSet<>();
   }


   public Item(@NotNull String name, @NotNull Set<String> defaultAdjectives) {
      this.name = name;
      setParentRoom(GameEngine.unassignedItemRoom, new ArrayList<>(GameEngine.unassignedItemRoom.getItems().values()));
      setAdjectives(defaultAdjectives);
      this.synonyms = new HashSet<>();
   }

   public Item(@NotNull String name, @NotNull Set<String> defaultAdjectives, @NotNull Set<String> synonyms) {
      this.name = name;
      setParentRoom(GameEngine.unassignedItemRoom, new ArrayList<>(GameEngine.unassignedItemRoom.getItems().values()));
      setAdjectives(defaultAdjectives);
      setSynonyms(synonyms);
   }

   @Override
   public String toString() {
      return String.format("[%s] %s from room: %s", String.join(",", adjectives), name, originalRoom != null ? originalRoom.getName() : "");
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
      return getName().equals(item.getName()) &&
          getAdjectives().equals(item.getAdjectives()) &&
          getOriginalRoom().equals(item.getOriginalRoom());
   }

   @Override
   public int hashCode() {
      return Objects.hash(getName(), getAdjectives(), getOriginalRoom());
   }

/*   @Override
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
   }*/

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

   public void setParentRoom(@NotNull Room newRoom, @NotNull List<Item> currentItems) {
      if (this.parentRoom == null || this.parentRoom.equals(EnhancedGameEngine.unassignedItemRoom)) {
         this.id = idGenerator(newRoom.getName(), currentItems);
         setOriginalRoom(newRoom);
      }
      this.parentRoom = newRoom;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public void addSynonyms(List<String> splitList) {
      synonyms.addAll(splitList);
   }
}
