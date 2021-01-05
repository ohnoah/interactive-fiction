import com.enhanced.typeconverter.ConstantsLexer;
import com.enhanced.typeconverter.ConstantsParser;
import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;


public class KnowledgeUpdate implements Serializable {
   private UpdateType updateType;
   private boolean isConstantUpdate;

   private Object updateConstant;
   private String settingFrameID;
   private String settingSlot;
   private String updatingFrameID;
   private String updatingSlot;
   private static TypeConvertVisitor typeConvertVisitor = new TypeConvertVisitor();

   private static Object typeConvert(String expression){

      ConstantsLexer lexer = new ConstantsLexer(CharStreams.fromString(expression));
      ConstantsParser parser = new ConstantsParser(new CommonTokenStream(lexer));
      return typeConvertVisitor.visit(parser.typeconvert());
   }

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

   public Object getUpdateConstant() {
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

   private boolean isConstant(String secondOperand) {
      Pattern p = Pattern.compile(KnowledgeRegex.knowledgeExpr);
      Matcher m = p.matcher(secondOperand);
      return !m.matches();
   }

   private void setSettingProperties(String updateValue) {
      this.isConstantUpdate = isConstant(updateValue);
      if (isConstantUpdate) {
         updateConstant = typeConvert(updateValue);
      } else {
         String[] knowledgeParts = updateValue.split("::");
         updatingFrameID = knowledgeParts[0];
         updatingSlot = knowledgeParts[1];
      }
   }

   public KnowledgeUpdate(UpdateType updateType, String updatingFrameID, String updatingSlot, String updateValue) {
      this.updateType = updateType;
      this.updatingFrameID = updatingFrameID;
      this.updatingSlot = updatingSlot;
      setSettingProperties(updateValue);
   }


   public KnowledgeUpdate(String expr) throws KnowledgeException {
      String knowledgeExpr = KnowledgeRegex.knowledgeExpr;
      String setTypeExpr = KnowledgeRegex.setTypeExpr;
      String numberExpr = KnowledgeRegex.numberExpr;
      String stringExpr = KnowledgeRegex.stringExpr;

      Pattern variable = Pattern.compile(String.format("^%s %s %s$", knowledgeExpr, setTypeExpr, knowledgeExpr));
      Matcher variableMatcher = variable.matcher(expr);
      String stringUpdateType;
      String firstKnowledge;
      String secondKnowledge;
      if (variableMatcher.matches()) {
         this.isConstantUpdate = false;
         firstKnowledge = variableMatcher.group(1);
         stringUpdateType = variableMatcher.group(2);
         secondKnowledge = variableMatcher.group(3);
         String[] splitUpdating = secondKnowledge.split("::");
         this.updatingFrameID = splitUpdating[0];
         this.updatingSlot = splitUpdating[1];
      } else {
         Pattern constant = Pattern.compile(String.format("^%s %s (%s|%s)$", knowledgeExpr, setTypeExpr, numberExpr, stringExpr));
         Matcher constantMatcher = constant.matcher(expr);
         if (constantMatcher.matches()) {
            this.isConstantUpdate = true;
            firstKnowledge = constantMatcher.group(1);
            stringUpdateType = constantMatcher.group(2);
            secondKnowledge = constantMatcher.group(3);
         } else {
            throw new KnowledgeException("Doesn't follow the setting syntax.");
         }
      }
      String[] splitSetting = firstKnowledge.split("::");
      this.settingFrameID = splitSetting[0];
      this.settingSlot = splitSetting[1];
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
         case "/=":
            updateType = UpdateType.DIVIDE;
            break;
         default:
            throw new KnowledgeException("Wrong setting type");
      }
   }
}
