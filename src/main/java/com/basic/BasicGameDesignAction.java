package com.basic;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

// TODO: This is really a com.basic.BasicGameDesignAction and need to allow for ANTLR stuff with enhanced game engine
public class BasicGameDesignAction implements Serializable {
   private Map<String, String> preconditions;
   private String message;
   private Map<String, String> updateState;

   public BasicGameDesignAction(Map<String, String> preconditions, String message, Map<String, String> updateState) {
      this.preconditions = preconditions;
      this.message = message;
      this.updateState = updateState;
   }

   public BasicGameDesignAction() {

   }


   public Map<String, String> getPreconditions() {
      return preconditions;
   }

   public void setPreconditions(Map<String, String> preconditions) {
      this.preconditions = new HashMap<>();
      this.preconditions.putAll(preconditions);
   }

   public Map<String, String> getUpdateState() {
      return updateState;
   }

   public void setUpdateState(Map<String, String> updateState) {
      this.updateState = new HashMap<>();
      this.updateState.putAll(updateState);
   }


   public String getMessage() {
      return message;
   }

   public void setMessage(String message) {
      this.message = message;
   }
}
