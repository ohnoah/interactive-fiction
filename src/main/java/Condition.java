import java.util.Objects;

public class Condition {


   private String booleanExpr;
   private String failureMessage;

   public String getBooleanExpr() {
      return booleanExpr;
   }

   public void setBooleanExpr(String booleanExpr) {
      this.booleanExpr = booleanExpr;
   }

   public String getFailureMessage() {
      return failureMessage;
   }

   public void setFailureMessage(String failureMessage) {
      this.failureMessage = failureMessage;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      Condition condition = (Condition) o;
      return getBooleanExpr().equals(condition.getBooleanExpr()) &&
          getFailureMessage().equals(condition.getFailureMessage());
   }

   @Override
   public int hashCode() {
      return Objects.hash(getBooleanExpr(), getFailureMessage());
   }
}
