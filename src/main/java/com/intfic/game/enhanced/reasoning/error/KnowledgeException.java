package com.intfic.game.enhanced.reasoning.error;

public class KnowledgeException extends Exception {
   public KnowledgeException(String message, Throwable cause) {
      super(message, cause);
   }

   public KnowledgeException(String s) {
      super(s);
   }
}
