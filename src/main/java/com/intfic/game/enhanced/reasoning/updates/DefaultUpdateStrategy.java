package com.intfic.game.enhanced.reasoning.updates;

import com.intfic.game.enhanced.EnhancedGameEngine;
import com.intfic.game.enhanced.FileErrorHandler;
import com.intfic.game.enhanced.reasoning.KnowledgeBase;
import com.intfic.game.enhanced.reasoning.error.KnowledgeException;
import com.intfic.game.enhanced.reasoning.error.MissingKnowledgeException;
import com.intfic.game.shared.Item;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.jetbrains.annotations.NotNull;

public class DefaultUpdateStrategy implements UpdateStrategy, Serializable {


   @Override
   public void updateKnowledgeBase(@NotNull EnhancedGameEngine enhancedGameEngine, @NotNull KnowledgeUpdate knowledgeUpdate) {
      KnowledgeBase knowledgeBase = enhancedGameEngine.getKnowledgeBase();
      try {
         knowledgeBase.update(knowledgeUpdate);
      }
      catch (KnowledgeException | MissingKnowledgeException e) {
         FileErrorHandler.printExceptionToLog(e);
         return;
      }
      if (knowledgeBase.frameNameEquals(knowledgeUpdate.getFrameToUpdate(), "world") &&
          knowledgeBase.frameNameEquals(knowledgeUpdate.getSlotToUpdate(), "room")) {
         updateRoomWithKnowledgeUpdate(enhancedGameEngine, knowledgeUpdate);
      }


      if (knowledgeBase.frameNameEquals(knowledgeUpdate.getFrameToUpdate(), "world") &&
          knowledgeBase.frameNameEquals(knowledgeUpdate.getSlotToUpdate(), "inventory")) {
         updateInventoryWithKnowledgeUpdate(enhancedGameEngine, knowledgeUpdate);
      }

      if (knowledgeBase.frameNameEquals(knowledgeUpdate.getFrameToUpdate(), "world") &&
          knowledgeBase.frameNameEquals(knowledgeUpdate.getSlotToUpdate(), "items")) {
         updateItemsWithKnowledgeUpdate(enhancedGameEngine, knowledgeUpdate);
      }
   }

   private void updateRoomWithKnowledgeUpdate(@NotNull EnhancedGameEngine enhancedGameEngine, @NotNull KnowledgeUpdate knowledgeUpdate) {
      KnowledgeBase knowledgeBase = enhancedGameEngine.getKnowledgeBase();
      if (!knowledgeUpdate.getUpdateType().equals(UpdateType.SET)) {
         FileErrorHandler.printToErrorLog("Treating non-setting as setting because this is current room");
      }

      Object moveTo;
      try {
         moveTo = knowledgeBase.rhsValueFromKnowledgeUpdate(knowledgeUpdate);
      }
      catch (MissingKnowledgeException | KnowledgeException e) {
         FileErrorHandler.printExceptionToLog(e);
         FileErrorHandler.printToErrorLog("Failed to move room");
         return;
      }
      if (moveTo instanceof String) {
         boolean success = enhancedGameEngine.moveRoom((String) moveTo);
         if (!success) {
            FileErrorHandler.printToErrorLog("updateKnowledgeBase call for " + knowledgeUpdate.toString() +
                " failed due to non-existent room name");
         }
      }
      else {
         FileErrorHandler.printToErrorLog("updateKnowledgeBase call for " + knowledgeUpdate.toString() +
             " failed due to wrong type in room");
      }
   }

   private void updateItemsWithKnowledgeUpdate(@NotNull EnhancedGameEngine enhancedGameEngine, @NotNull KnowledgeUpdate knowledgeUpdate) {
      KnowledgeBase knowledgeBase = enhancedGameEngine.getKnowledgeBase();
      Object itemIdentifier = null;
      try {
         itemIdentifier = knowledgeBase.rhsValueFromKnowledgeUpdate(knowledgeUpdate);
      }
      catch (MissingKnowledgeException | KnowledgeException e) {
         FileErrorHandler.printExceptionToLog(e);
         FileErrorHandler.printToErrorLog("Couldn't get update value from knowledge update when updating items");
         return;
      }

      Item itemInRoom;
      if (itemIdentifier instanceof String) {
         List<Item> containsItems = new ArrayList<>();
         try {
            Map<String, Item> globalItems = enhancedGameEngine.globalItems();
            containsItems = knowledgeBase.queryStringList((String) itemIdentifier, "contains")
                .stream().map(globalItems::get).collect(Collectors.toList());
         }
         catch (KnowledgeException e) {
            FileErrorHandler.printExceptionToLog(e);
            return;
         }
         catch (MissingKnowledgeException ignored) {
         }
         if (knowledgeUpdate.getUpdateType() == UpdateType.SUBTRACT) {
            String finalItemIdentifier = (String) itemIdentifier;
            // try to remove from room
            itemInRoom = enhancedGameEngine.getCurrentRoom().getItems().get(finalItemIdentifier);
            boolean validItem = enhancedGameEngine.getCurrentRoom().removeItem(itemInRoom);
            // try to remove from inventory
            Item returned = enhancedGameEngine.getInventoryItems().remove(itemIdentifier);
            if (returned == null && !validItem) {
               FileErrorHandler.printToErrorLog(itemIdentifier + " is an invalid item that was attempted to be removed from the world.");
               return;
            }
            knowledgeBase.removeSpecificFrame((String) itemIdentifier);
            for (Item i : containsItems) {
               if (i == null) {
                  FileErrorHandler.printToErrorLog("Bad item in contains list when removing from world.");
               }
               else {
                  enhancedGameEngine.removeItem(i); // Contained items can be anywhere
                  knowledgeBase.removeSpecificFrame(KnowledgeBase.getItemIdentifier(i));
               }
            }
         }
         else {
            FileErrorHandler.printToErrorLog("Wrong Update type when updating items for world " + knowledgeUpdate.toString());
         }
      }
      else {
         FileErrorHandler.printToErrorLog("updateKnowledgeBase call for " + knowledgeUpdate.toString() +
             " failed due to wrong type of item");
      }
   }

   private void updateInventoryWithKnowledgeUpdate(@NotNull EnhancedGameEngine enhancedGameEngine, @NotNull KnowledgeUpdate knowledgeUpdate) {
      KnowledgeBase knowledgeBase = enhancedGameEngine.getKnowledgeBase();
      Object itemIdentifier;
      try {
         itemIdentifier = knowledgeBase.rhsValueFromKnowledgeUpdate(knowledgeUpdate);
      }
      catch (KnowledgeException | MissingKnowledgeException e) {
         FileErrorHandler.printExceptionToLog(e);
         FileErrorHandler.printToErrorLog("Failed to add inventory or subtract");
         return;
      }
      Item itemInRoom;
      if (itemIdentifier instanceof String) {
         List<Item> containsItems = new ArrayList<>();
         try {
            Map<String, Item> globalItems = enhancedGameEngine.globalItems();
            containsItems = knowledgeBase.queryStringList((String) itemIdentifier, "contains")
                .stream().map(globalItems::get).collect(Collectors.toList());
         }
         catch (KnowledgeException e) {
            FileErrorHandler.printExceptionToLog(e);
         }
         catch (MissingKnowledgeException ignored) {
         }
         if (knowledgeUpdate.getUpdateType() == UpdateType.ADD) {
            itemInRoom = enhancedGameEngine.getCurrentRoom().getItems().get(itemIdentifier);
            /*            itemInRoom = enhancedGameEngine.getCurrentRoom().getItems().stream().filter(i -> i.getName().equals(itemIdentifier)).findAny().orElse(null);*/
            if (itemInRoom == null) {
               FileErrorHandler.printToErrorLog(itemIdentifier + " is an invalid item that was attempted to be added to inventory.");
               return;
            }
            enhancedGameEngine.addToInventory(itemInRoom);
            enhancedGameEngine.getCurrentRoom().removeItem(itemInRoom);
            for (Item i : containsItems) {
               if (i == null) {
                  FileErrorHandler.printToErrorLog("Bad item in contains list");
               }
               enhancedGameEngine.removeItem(i);
            }
         }
         else if (knowledgeUpdate.getUpdateType() == UpdateType.SUBTRACT) {
            Item returned = enhancedGameEngine.getInventoryItems().remove(itemIdentifier);
            for (Item i : containsItems) {
               if (i == null) {
                  FileErrorHandler.printToErrorLog("Bad item in contains list");
               }
               else {
                  enhancedGameEngine.getCurrentRoom().addItem(i);
               }
            }
            if (returned != null) {
               enhancedGameEngine.getCurrentRoom().addItem(returned);
            }
            else {
               FileErrorHandler.printToErrorLog("Tried to remove item not in inventory");
            }
         }
         else {
            FileErrorHandler.printToErrorLog("Wrong Update type when updating items for world");
         }
      }
      else {
         FileErrorHandler.printToErrorLog("updateKnowledgeBase call for " + knowledgeUpdate.toString() +
             " failed due to wrong type of item");
      }

   }

}
