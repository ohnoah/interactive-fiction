package com.intfic.game.basic;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class BasicGameDesignAction implements Serializable {
   private static final long serialVersionUID = -4706216167250700984L;

   private Map<String, String> preconditions;
   private String successMessage;
   private Map<String, String> updateState;

   public String getFailureMessage() {
      return failureMessage;
   }

   public void setFailureMessage(String failureMessage) {
      this.failureMessage = failureMessage;
   }

   private String failureMessage;

   public BasicGameDesignAction(Map<String, String> preconditions, String successMessage, Map<String, String> updateState) {
      this.preconditions = preconditions;
      this.successMessage = successMessage;
      this.updateState = updateState;
      this.failureMessage = null;
   }


   public BasicGameDesignAction(Map<String, String> preconditions, String successMessage, String failureMessage, Map<String, String> updateState) {
      this.preconditions = preconditions;
      this.successMessage = successMessage;
      this.updateState = updateState;
      this.failureMessage = failureMessage;
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


   public String getSuccessMessage() {
      return successMessage;
   }

   public void setSuccessMessage(String successMessage) {
      this.successMessage = successMessage;
   }
}
