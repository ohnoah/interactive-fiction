import java.util.Objects;

public class ActionFormat {
   private String verb;
   private String regExpr;

   public ActionFormat(String verb, String regExpr){
      this.verb = verb;
      this.regExpr = regExpr;
   }

   public boolean isTernary(){
      return regExpr != null;
   }

   public String getVerb() {
      return verb;
   }

   public void setVerb(String verb) {
      this.verb = verb;
   }

   public String getRegExpr() {
      return regExpr;
   }

   public void setRegExpr(String regExpr) {
      this.regExpr = regExpr;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      ActionFormat that = (ActionFormat) o;
      return getVerb().equals(that.getVerb()) &&
          Objects.equals(getRegExpr(), that.getRegExpr());
   }

   @Override
   public int hashCode() {
      return Objects.hash(getVerb(), getRegExpr());
   }
}
