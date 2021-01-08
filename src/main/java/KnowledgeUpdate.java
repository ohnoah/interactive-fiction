import java.io.Serializable;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class KnowledgeUpdate implements Serializable {
   private UpdateType updateType;
   private boolean isConstantUpdate;

   private Object updateConstant;
   private String frameToUpdate;
   private String slotToUpdate;
   private String foreignFrame;
   private String foreignSlot;
   private static TypeConvertVisitor typeConvertVisitor = new TypeConvertVisitor();

   private static Object typeConvert(String expression) {
      return VisitorFactory.typeConvert(typeConvertVisitor, expression);
   }

   public UpdateType getUpdateType() {
      return updateType;
   }


   public boolean isConstantUpdate() {
      return isConstantUpdate;
   }

   public Object getUpdateConstant() {
      return updateConstant;
   }

   public String getFrameToUpdate() {
      return frameToUpdate;
   }

   public String getSlotToUpdate() {
      return slotToUpdate;
   }

   public String getForeignFrame() {
      return foreignFrame;
   }

   public String getForeignSlot() {
      return foreignSlot;
   }

   private boolean isConstant(String secondOperand) {
      Pattern p = Pattern.compile(KnowledgeRegex.knowledgeExpr);
      Matcher m = p.matcher(secondOperand);
      return !m.matches();
   }

   private void setSettingProperties(String updateValue) {
      this.isConstantUpdate = isConstant(updateValue);
      if (isConstantUpdate) {
         updateConstant = typeConvert(updateValue);
      }
      else {
         String[] knowledgeParts = updateValue.split("::");
         foreignFrame = knowledgeParts[0];
         foreignSlot = knowledgeParts[1];
      }
   }

   // TODO: Reformat to use objects
   public KnowledgeUpdate(UpdateType updateType, String frameToUpdate, String slotToUpdate, String updateValue) {
      this.updateType = updateType;
      this.frameToUpdate = frameToUpdate;
      this.slotToUpdate = slotToUpdate;
      setSettingProperties(updateValue);
   }


   public KnowledgeUpdate(String expr) throws KnowledgeException {
      String knowledgeExpr = KnowledgeRegex.knowledgeExpr;
      String largeCaptureKnowledgeExpr = KnowledgeRegex.largeCaptureKnowledgeExpr;
      String setTypeExpr = KnowledgeRegex.setTypeExpr;
      String numberExpr = KnowledgeRegex.numberExpr;
      String stringExpr = KnowledgeRegex.stringExpr;

      Pattern variable = Pattern.compile(String.format("^%s %s %s$", knowledgeExpr, setTypeExpr, largeCaptureKnowledgeExpr));
      Matcher variableMatcher = variable.matcher(expr);
      String stringUpdateType;
      String secondKnowledge;
      if (variableMatcher.matches()) {
         this.isConstantUpdate = false;
         this.frameToUpdate = variableMatcher.group(1);
         this.slotToUpdate = variableMatcher.group(2);
         stringUpdateType = variableMatcher.group(3);
         secondKnowledge = variableMatcher.group(4);
      }
      else {
         Pattern constant = Pattern.compile(String.format("^%s %s (%s|%s)$", knowledgeExpr, setTypeExpr, numberExpr, stringExpr));
         Matcher constantMatcher = constant.matcher(expr);
         if (constantMatcher.matches()) {
            this.isConstantUpdate = true;
            this.frameToUpdate = constantMatcher.group(1);
            this.slotToUpdate = constantMatcher.group(2);
            stringUpdateType = constantMatcher.group(3);
            secondKnowledge = constantMatcher.group(4);
         }
         else {
            throw new KnowledgeException("Doesn't follow the setting syntax.");
         }
      }
      setSettingProperties(secondKnowledge);

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
         default:
            throw new KnowledgeException("Wrong setting type");
      }
   }


   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      KnowledgeUpdate that = (KnowledgeUpdate) o;
      return isConstantUpdate() == that.isConstantUpdate() &&
          getUpdateType() == that.getUpdateType() &&
          Objects.equals(getUpdateConstant(), that.getUpdateConstant()) &&
          getFrameToUpdate().equals(that.getFrameToUpdate()) &&
          getSlotToUpdate().equals(that.getSlotToUpdate()) &&
          Objects.equals(getForeignFrame(), that.getForeignFrame()) &&
          Objects.equals(getForeignSlot(), that.getForeignSlot());
   }

   @Override
   public int hashCode() {
      return Objects.hash(getUpdateType(), isConstantUpdate(), getUpdateConstant(), getFrameToUpdate(), getSlotToUpdate(), getForeignFrame(), getForeignSlot());
   }

   @Override
   public String toString() {
      return "KnowledgeUpdate{" +
          "updateType=" + updateType +
          ", isConstantUpdate=" + isConstantUpdate +
          ", updateConstant='" + updateConstant + '\'' +
          ", settingFrameID='" + frameToUpdate + '\'' +
          ", settingSlot='" + slotToUpdate + '\'' +
          ", updatingFrameID='" + foreignFrame + '\'' +
          ", updatingSlot='" + foreignSlot + '\'' +
          '}';
   }
}
