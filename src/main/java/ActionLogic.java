import java.util.List;

public class ActionLogic {
   private boolean valid = true;
   private String reasoning = "";
   private static List<ActionFormat> implementedActions = ;

   public ActionLogic(InstantiatedGameAction gameAction) {
      checkLogic(gameAction);
   }

   private void checkLogic(InstantiatedGameAction gameAction) {

   }

   public boolean isValid() {
      return valid;
   }

   public String textReason() {
      return reasoning;
   }
}
