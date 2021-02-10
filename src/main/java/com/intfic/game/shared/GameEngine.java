package com.intfic.game.shared;

import com.intfic.game.enhanced.reasoning.wrappers.Justification;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.jetbrains.annotations.NotNull;

public abstract class GameEngine implements Serializable {

   private static final long serialVersionUID = 7868760665131884319L;
   private List<ActionFormat> possibleActionFormats;
   protected List<Room> worldRooms;
   private String startMessage;
   protected Room currentRoom;

   public String getStartMessage() {
      return startMessage;
   }

   public void setStartMessage(String startMessage) {
      this.startMessage = startMessage;
   }


   public Room getCurrentRoom() {
      return currentRoom;
   }


   public boolean moveRoom(String roomName) {
      List<Room> matched = findRoom(roomName);
      if (matched.size() >= 1) {
         currentRoom = matched.get(0);
         return true;
      }
      else {
         System.err.println("Invalid room. Contact system administrator.");
         return false;
      }

   }

   public List<Room> findRoom(String roomName) {
      return worldRooms.stream()
          .filter(room -> roomName.equals(room.getName()))
          .collect(Collectors.toList());
   }

   public int getNumRooms() {
      return worldRooms.size();
   }

   public final List<ActionFormat> getPossibleActionFormats() {
      return new ArrayList<>(this.possibleActionFormats);
   }

   public void addActionFormat(ActionFormat af) {
      this.possibleActionFormats.add(af);
   }

   public GameEngine() {
      this.worldRooms = new ArrayList<>();
      this.currentRoom = null;
      // very common
      ActionFormat examine = new ActionFormat("examine");
      ActionFormat push = new ActionFormat("push");
      ActionFormat take = new ActionFormat("take");
      ActionFormat pull = new ActionFormat("pull");
      ActionFormat drop = new ActionFormat("drop");
      ActionFormat turn = new ActionFormat("turn");
      ActionFormat open = new ActionFormat("open");
      ActionFormat feel = new ActionFormat("feel");
      ActionFormat putIn = new ActionFormat("put", "put ([\\w\\s]+) in ([\\w\\s]+)$");
      ActionFormat putOn = new ActionFormat("put", "put ([\\w\\s]+) on ([\\w\\s]+)$");
      // you could also try
      ActionFormat eat = new ActionFormat("eat");
      ActionFormat climb = new ActionFormat("climb");
      ActionFormat drink = new ActionFormat("drink", "drink ([\\w\\s]+) from ([\\w\\s]+)$");
      ActionFormat wave = new ActionFormat("wave");
      ActionFormat wear = new ActionFormat("wear");
      ActionFormat smell = new ActionFormat("smell");
      ActionFormat listenTo = new ActionFormat("listen", "listen to ([\\w\\s]+)$");
      ActionFormat breakIt = new ActionFormat("break");
      ActionFormat burn = new ActionFormat("burn");
      ActionFormat enter = new ActionFormat("enter");
      ActionFormat search = new ActionFormat("search");
      ActionFormat unlockWith = new ActionFormat("unlock", "unlock ([\\w\\s]+) with ([\\w\\s]+)$");
      // Noah's own
      ActionFormat remove = new ActionFormat("remove", "remove ([\\w\\s]+) from ([\\w\\s]+)$");
      ActionFormat transfer = new ActionFormat("transfer", "transfer ([\\w\\s]+) from ([\\w\\s]+) (?:to|into) ([\\w\\s]+)$");

      this.possibleActionFormats = List.of(examine, push, take, pull, drop, turn, open, feel, putIn,
          putOn, eat, climb, drink, wave, /*fill,*/ wear, smell, listenTo, breakIt, burn, enter, search, unlockWith, remove, transfer);
   }

   public abstract Set<Item> possibleItems();

   public Map<String, Item> globalItems() {
      return Util.streamToMap(worldRooms.stream().map(Room::getItems).flatMap(Collection::stream), Item::getID);
      /*return worldRooms.stream().map(Room::getItems).flatMap(Collection::stream).collect(Collectors.toMap(Item::getID, i -> i));*/
   }

   public abstract Justification progressStory(@NotNull InstantiatedGameAction gameAction);

   public List<ActionFormat> findAction(@NotNull String trigger) {
      return possibleActionFormats.stream()
          .filter(af -> trigger.equals(af.getVerb()))
          .collect(Collectors.toList());
   }

}
