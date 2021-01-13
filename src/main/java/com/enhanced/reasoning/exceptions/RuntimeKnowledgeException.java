package com.enhanced.reasoning.exceptions;

public class RuntimeKnowledgeException extends RuntimeException{
   public RuntimeKnowledgeException() {
      super();
   }

   public RuntimeKnowledgeException(String message) {
      super(message);
   }

   public RuntimeKnowledgeException(String message, Throwable cause) {
      super(message, cause);
   }

}
