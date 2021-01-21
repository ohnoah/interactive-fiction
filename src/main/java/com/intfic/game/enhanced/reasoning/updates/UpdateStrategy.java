package com.intfic.game.enhanced.reasoning.updates;

import com.intfic.game.enhanced.EnhancedGameEngine;
import org.jetbrains.annotations.NotNull;

public interface UpdateStrategy {
   void updateKnowledgeBase(@NotNull EnhancedGameEngine enhancedGameEngine, @NotNull KnowledgeUpdate knowledgeUpdate);

}
