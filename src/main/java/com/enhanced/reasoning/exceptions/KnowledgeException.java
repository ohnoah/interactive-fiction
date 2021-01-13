package com.enhanced.reasoning.exceptions;

public class KnowledgeException extends Exception {
   public KnowledgeException(String message, Throwable cause) {
      super(message, cause);
   }

   public KnowledgeException(String s) {
      super(s);
   }
}
