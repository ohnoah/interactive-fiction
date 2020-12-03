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
}
