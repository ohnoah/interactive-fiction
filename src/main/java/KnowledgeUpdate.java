import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class KnowledgeUpdate implements Serializable {
   private UpdateType updateType;
   private boolean isConstantUpdate;

   public UpdateType getUpdateType() {
      return updateType;
   }

   @Override
   public String toString() {
      return "KnowledgeUpdate{" +
          "updateType=" + updateType +
          ", isConstantUpdate=" + isConstantUpdate +
          ", updateConstant='" + updateConstant + '\'' +
          ", settingFrameID='" + settingFrameID + '\'' +
          ", settingSlot='" + settingSlot + '\'' +
          ", updatingFrameID='" + updatingFrameID + '\'' +
          ", updatingSlot='" + updatingSlot + '\'' +
          '}';
   }

   public boolean isConstantUpdate() {
      return isConstantUpdate;
   }

   public String getUpdateConstant() {
      return updateConstant;
   }

   public String getSettingFrameID() {
      return settingFrameID;
   }

   public String getSettingSlot() {
      return settingSlot;
   }

   public String getUpdatingFrameID() {
      return updatingFrameID;
   }

   public String getUpdatingSlot() {
      return updatingSlot;
   }

   private String updateConstant;
   private String settingFrameID;
   private String settingSlot;
   private String updatingFrameID;
   private String updatingSlot;

   private boolean isConstant(String secondOperand) {
      Pattern p = Pattern.compile("[\\w]+::[\\w]+$");
      Matcher m = p.matcher(secondOperand);
      return !m.matches();
   }

   private void setSettingProperties(String updateValue) {
      this.isConstantUpdate = isConstant(updateValue);
      if (isConstantUpdate) {
         updateConstant = updateValue;
      }
      else{
         String[] knowledgeParts = updateValue.split("::");
         settingFrameID = knowledgeParts[0];
         settingSlot = knowledgeParts[1];
      }
   }

   public KnowledgeUpdate(UpdateType updateType, String updatingFrameID, String updatingSlot, String updateValue) {
      this.updateType = updateType;
      this.updatingFrameID = updatingFrameID;
      this.updatingSlot = updatingSlot;
      setSettingProperties(updateValue);
   }

   public KnowledgeUpdate(String expr) throws InvalidKnowledgeSyntaxException {
      String knowledgeExpr = "^([\\w]+::[\\w]+)";
      String setTypeExpr = "(=|\\+=|-=|\\*=|/=)";
      String numberExpr = "\\d*\\.?\\d+";
      String stringExpr = "\\w*";

      Pattern variable = Pattern.compile(String.format("^%s %s %s$", knowledgeExpr, setTypeExpr, knowledgeExpr));
      Matcher constantMatcher = variable.matcher(expr);
      String stringUpdateType = null;
      if (constantMatcher.matches()) {
         String firstKnowledge = constantMatcher.group(1);
         stringUpdateType = constantMatcher.group(2);
         String secondKnowledge = constantMatcher.group(3);
      } else {
         Pattern constant = Pattern.compile(String.format("^%s %s (%s|%s)$", knowledgeExpr, setTypeExpr, numberExpr, stringExpr));
         Matcher variableMatcher = variable.matcher(expr);
         if (variableMatcher.matches()) {
            this.isConstantUpdate = true;
            String firstKnowledge = constantMatcher.group(1);
            stringUpdateType = constantMatcher.group(2);
            String secondKnowledge = constantMatcher.group(3);
         } else {
            throw new InvalidKnowledgeSyntaxException("Doesn't follow the setting syntax.");
         }
      }

      switch (stringUpdateType) {
         case "=":
            updateType = UpdateType.SET;
            break;
         case "+=":
            updateType = UpdateType.ADD;
            break;
         case "-=":
            updateType = UpdateType.SUBTRACT;
            break;
         case "*=":
            updateType = UpdateType.MULTIPLY;
            break;
         case "/=":
            updateType = UpdateType.DIVIDE;
            break;
         default:
            throw new InvalidKnowledgeSyntaxException("Wrong setting type");
      }
   }
}
