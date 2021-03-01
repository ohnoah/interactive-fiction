package com.intfic.game.basic;

import java.io.Serializable;
import java.util.Objects;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class BasicCondition implements Serializable {
   private String key;
   private String desiredValue;
   private String errorMessage;

   public String getKey() {
      return key;
   }

   public String getDesiredValue() {
      return desiredValue;
   }

   public BasicCondition(@NotNull String key, @NotNull String desiredValue, @NotNull String errorMessage) {
      this.key = key;
      this.desiredValue = desiredValue;
      this.errorMessage = errorMessage;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      BasicCondition that = (BasicCondition) o;
      return key.equals(that.key) && desiredValue.equals(that.desiredValue) && errorMessage.equals(that.errorMessage);
   }

   @Override
   public int hashCode() {
      return Objects.hash(key, desiredValue, errorMessage);
   }

   public String getErrorMessage() {
      return errorMessage;
   }

}
