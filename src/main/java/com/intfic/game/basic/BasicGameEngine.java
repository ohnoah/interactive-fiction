package com.intfic.game.basic;

import com.intfic.game.shared.GameEngine;
import com.intfic.game.enhanced.reasoning.wrappers.Justification;
import com.intfic.game.shared.InstantiatedGameAction;
import com.intfic.game.shared.Item;
import com.intfic.game.shared.Room;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// TODO: Start message

public class BasicGameEngine extends GameEngine implements Serializable {
   private static final long serialVersionUID = 7326328040473434623L;
   private Map<String, String> worldState;
   // room name maps
   private Map<Room, Map<InstantiatedGameAction, BasicGameDesignAction>> designerActions;

   public void setCurrentRoom(Room currentRoom) {
      this.currentRoom = currentRoom;
      this.worldState.put("room", currentRoom.getName());
   }


   public BasicGameEngine() {
      super();
      worldState = new HashMap<>();
      designerActions = new HashMap<>();
   }

   public BasicGameEngine(@NotNull List<Room> rooms, @NotNull Room startRoom, @NotNull Map<Room, Map<InstantiatedGameAction, BasicGameDesignAction>> allowedActions) {
      super();
      this.worldRooms.addAll(rooms);
      this.designerActions = allowedActions;
      this.worldRooms.forEach(x -> designerActions.putIfAbsent(x, new HashMap<InstantiatedGameAction, BasicGameDesignAction>()));
      this.worldState = new HashMap<>();
      setCurrentRoom(startRoom);
   }

   // TODO: This should probably use exceptions
   public void addRoom(@NotNull Room room) {
      if (!worldRooms.contains(room)) {
         worldRooms.add(room);
         designerActions.putIfAbsent(room, new HashMap<>());
      }
   }

   public void addAction(@NotNull Room roomForAction, @NotNull InstantiatedGameAction triggeringAction, @NotNull BasicGameDesignAction effectAction) {
      Map<InstantiatedGameAction, BasicGameDesignAction> actionsInRoom = designerActions.getOrDefault(roomForAction, new HashMap<>());
      actionsInRoom.put(triggeringAction, effectAction);
   }


   @Override
   public boolean getWorldBoolean(String key) {
      return Boolean.parseBoolean(worldState.getOrDefault(key, "false"));
   }

   @Override
   public Set<Item> possibleItems() {
      return new HashSet<>(this.currentRoom.getItems().values());
   }

   public boolean validatePrecondition(Map<String, String> wantedGlobalState) {
      for (Map.Entry<String, String> entry : wantedGlobalState.entrySet()) {
         String key = entry.getKey();
         String wantedValue = entry.getValue();
         if (!worldState.containsKey(key) || !worldState.get(key).equals(wantedValue)) {
            return false;
         }
      }
      return true;
   }

   // set after effects

   // move room


   @Override
   public Justification progressStory(@NotNull InstantiatedGameAction gameAction) {

      Room currentRoom = getCurrentRoom();

      BasicGameDesignAction designAction = getGameDesignAction(gameAction, currentRoom);
      if (designAction == null) {
         return new Justification(false, "You can't do that right now");
      }
      Map<String, String> wantedGlobalState = new HashMap<>(designAction.getPreconditions());

      boolean preCondSatisfied = validatePrecondition(wantedGlobalState);
      if (!preCondSatisfied) {
         return new Justification(false, "You can't do that yet");
      }
      String message = designAction.getMessage();

      updateWorldState(designAction);

      return new Justification(true, message);

   }

   protected void updateWorldState(BasicGameDesignAction basicGameDesignAction) {
      Map<String, String> updateState = basicGameDesignAction.getUpdateState();
      // TODO: Consider more advanced post conditions for enhanced engine
      worldState.putAll(updateState);
      if (updateState.containsKey("room")) {
         moveRoom(updateState.get("room"));
      }
   }



   public Room getCurrentRoom() {
      return this.currentRoom;
   }

   protected void getPreconditionedState(BasicGameDesignAction designAction, Map<String, String> globalStateCondition) {
      globalStateCondition.putAll(designAction.getPreconditions());
   }

   protected BasicGameDesignAction getGameDesignAction(InstantiatedGameAction gameAction, Room currentRoom) {
      if (designerActions.containsKey(currentRoom)) {
         Map<InstantiatedGameAction, BasicGameDesignAction> gameDesignActions = designerActions.get(currentRoom);
         if (gameDesignActions.containsKey(gameAction)) {
            return gameDesignActions.get(gameAction);
         }
      }
      return null;
   }
}
