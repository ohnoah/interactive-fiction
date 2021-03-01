package com.intfic.game.basic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BasicGameDesignAction implements Serializable {
   private static final long serialVersionUID = -4706216167250700984L;

   /*private Map<String, String> preconditions;*/
   private List<BasicCondition> preconditions;
   private String successMessage;
   private Map<String, String> updateState;



   public BasicGameDesignAction(/*Map<String, String> */ List<BasicCondition> preconditions, String successMessage, Map<String, String> updateState) {
      this.preconditions = preconditions;
      this.successMessage = successMessage;
      this.updateState = updateState;
   }



   public BasicGameDesignAction() {

   }


   public /*Map<String, String> */ List<BasicCondition> getPreconditions() {
      return preconditions;
   }

/*   public void setPreconditions(Map<String, String> preconditions) {
      this.preconditions = new HashMap<>();
      this.preconditions.putAll(preconditions);
   }*/

   public void setPreconditions(List<BasicCondition> preconditions) {
      this.preconditions = new ArrayList<>(preconditions);
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
