package com.enhanced.reasoning;

import java.io.Serializable;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

public class Justification implements Serializable {
   private boolean accepted;
   private String reasoning;


   public Justification(boolean accepted, @NotNull String reasoning) {
      this.accepted = accepted;
      this.reasoning = reasoning;
   }


   public boolean isAccepted() {
      return accepted;
   }

   public String getReasoning() {
      return reasoning;
   }
   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      Justification that = (Justification) o;
      return accepted == that.accepted &&
          reasoning.equals(that.reasoning);
   }

   @Override
   public int hashCode() {
      return Objects.hash(accepted, reasoning);
   }
}
