package com.intfic.game.enhanced.reasoning.updates;

import com.intfic.game.enhanced.EnhancedGameEngine;
import org.jetbrains.annotations.NotNull;

public class DefaultUpdateStrategy implements UpdateStrategy {
/*   @Override*/
   public void updateKnowledgeBase(@NotNull EnhancedGameEngine enhancedGameEngine, @NotNull KnowledgeUpdate knowledgeUpdate) {
/*      try {
         knowledgeBase.update(knowledgeUpdate);
      }
      catch (KnowledgeException | MissingKnowledgeException e) {
         FileErrorHandler.printExceptionToLog(e);
         return;
      }
      if (knowledgeBase.frameNameEquals(knowledgeUpdate.getFrameToUpdate(), "world") &&
          knowledgeBase.frameNameEquals(knowledgeUpdate.getSlotToUpdate(), "room")) {
         updateRoomWithKnowledgeUpdate(knowledgeUpdate);
      }


      if (knowledgeBase.frameNameEquals(knowledgeUpdate.getFrameToUpdate(), "world") &&
          knowledgeBase.frameNameEquals(knowledgeUpdate.getSlotToUpdate(), "inventory")) {
         updateInventoryWithKnowledgeUpdate(knowledgeUpdate);
      }

      if (knowledgeBase.frameNameEquals(knowledgeUpdate.getFrameToUpdate(), "world") &&
          knowledgeBase.frameNameEquals(knowledgeUpdate.getSlotToUpdate(), "items")) {
         updateItemsWithKnowledgeUpdate(knowledgeUpdate);
      }*/
   }
}
