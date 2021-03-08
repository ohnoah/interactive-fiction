package com.intfic.game.enhanced.reasoning.updates;

import com.intfic.game.enhanced.reasoning.KnowledgeBase;
import com.intfic.game.enhanced.reasoning.KnowledgeRegex;
import com.intfic.game.enhanced.reasoning.visitors.TypeConvertVisitor;
import com.intfic.game.enhanced.reasoning.VisitorHelper;
import com.intfic.game.enhanced.reasoning.error.KnowledgeException;
import java.io.Serializable;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class KnowledgeUpdate implements Serializable {

   private static final long serialVersionUID = -2764187795027231102L;
   private UpdateType updateType;

   public void setFrameToUpdate(String frameToUpdate) {
      this.frameToUpdate = frameToUpdate;
   }

   public void setSlotToUpdate(String slotToUpdate) {
      this.slotToUpdate = slotToUpdate;
   }

   public void setForeignFrame(String foreignFrame) {
      this.foreignFrame = KnowledgeBase.stripExclamationMark(foreignFrame);
   }

   public void setForeignSlot(String foreignSlot) {
      this.foreignSlot = foreignSlot;
   }


   public enum SettingType {
      CONSTANT,
      KNOWLEDGE,
      FRAME
   }

   private SettingType settingType;

   // LEFT SIDE OF ASSIGNMENT
   private String frameToUpdate;
   private String slotToUpdate;
   // RIGHT SIDE OF ASSIGNMENT
   private String foreignFrame;
   private String foreignSlot;


   private Object updateConstant;

   private static TypeConvertVisitor typeConvertVisitor = new TypeConvertVisitor();

   private static Object typeConvert(String expression) {
      return VisitorHelper.typeConvert(typeConvertVisitor, expression);
   }

   public void setUpdateConstant(Object updateConstant) {
      this.updateConstant = updateConstant;
   }
   public UpdateType getUpdateType() {
      return updateType;
   }


   public SettingType getSettingType() {
      return settingType;
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
      return Pattern.matches(
<<<<<<< HEAD
          String.format("%s|%s|%s|%s|TRUE|FALSE|true|false",
=======
          String.format("%s|%s|%s|%s|TRUE|FALSE",
>>>>>>> e1294131b4990c04471c8d8454121ab033af946e
              KnowledgeRegex.STRING_EXPR, KnowledgeRegex.NUMBER_EXPR, KnowledgeRegex.NUMBER_LIST_EXPR, KnowledgeRegex.STRING_LIST_EXPR),
          secondOperand);
   }

   private void setSettingProperties(String updateValue) {
      if (isConstant(updateValue)) {
         this.settingType = SettingType.CONSTANT;
         updateConstant = typeConvert(updateValue);
      }
      else {
         if (Pattern.matches(KnowledgeRegex.FRAME_NAME_EXPR, updateValue)) {
            this.settingType = SettingType.FRAME;
            foreignFrame = updateValue;
         }
         else if (Pattern.matches(KnowledgeRegex.KNOWLEDGE_EXPR, updateValue)) {
            this.settingType = SettingType.KNOWLEDGE;
            String[] knowledgeParts = updateValue.split("::");
            foreignFrame = knowledgeParts[0];
            foreignSlot = knowledgeParts[1];
         }
      }
   }

   // TODO: Reformat to use objects
   public KnowledgeUpdate(UpdateType updateType, String frameToUpdate, String slotToUpdate, String updateValue) {
      this.updateType = updateType;
      this.frameToUpdate = frameToUpdate;
      this.slotToUpdate = slotToUpdate;
      setSettingProperties(updateValue);
   }

   // TODO: Reformat to use objects
   public KnowledgeUpdate(KnowledgeUpdate knowledgeUpdate) {
      this.updateType = knowledgeUpdate.getUpdateType();
      this.frameToUpdate = knowledgeUpdate.getFrameToUpdate();
      this.slotToUpdate = knowledgeUpdate.getSlotToUpdate();
      this.settingType = knowledgeUpdate.getSettingType();
      if(knowledgeUpdate.getSettingType() == SettingType.CONSTANT){
         this.updateConstant = knowledgeUpdate.getUpdateConstant();
      }
      else if(knowledgeUpdate.getSettingType() == SettingType.FRAME){
         this.foreignFrame = knowledgeUpdate.getForeignFrame();
      }
      else{
         this.foreignFrame = knowledgeUpdate.getForeignFrame();
         this.foreignSlot = knowledgeUpdate.getForeignSlot();
      }
   }


   public KnowledgeUpdate(String expr) throws KnowledgeException {
      String knowledgeExpr = KnowledgeRegex.KNOWLEDGE_EXPR;
      String largeCaptureKnowledgeExpr = KnowledgeRegex.LARGE_CAPTURE_KNOWLEDGE_EXPR;
      String setTypeExpr = KnowledgeRegex.SET_TYPE_EXPR;
      String numberExpr = KnowledgeRegex.NUMBER_EXPR;
      String stringExpr = KnowledgeRegex.STRING_EXPR;
      String stringListExpr = KnowledgeRegex.STRING_LIST_EXPR;
      String numberListExpr = KnowledgeRegex.NUMBER_LIST_EXPR;
      String frameNameExpr = KnowledgeRegex.FRAME_NAME_EXPR;

      Pattern variable = Pattern.compile(String.format("^%s %s (%s|%s)$", knowledgeExpr, setTypeExpr, largeCaptureKnowledgeExpr, frameNameExpr));
      Matcher variableMatcher = variable.matcher(expr);
      String stringUpdateType;
      String secondKnowledge;
      if (variableMatcher.matches()) {
         this.frameToUpdate = variableMatcher.group(1);
         this.slotToUpdate = variableMatcher.group(2);
         stringUpdateType = variableMatcher.group(3);
         secondKnowledge = variableMatcher.group(4);
      }
      else {
         Pattern constant = Pattern.compile(
<<<<<<< HEAD
             String.format("^%s %s (%s|%s|%s|%s|TRUE|FALSE|true|false)$", knowledgeExpr, setTypeExpr, numberExpr, stringExpr, stringListExpr, numberListExpr)
=======
             String.format("^%s %s (%s|%s|%s|%s|TRUE|FALSE)$", knowledgeExpr, setTypeExpr, numberExpr, stringExpr, stringListExpr, numberListExpr)
>>>>>>> e1294131b4990c04471c8d8454121ab033af946e
         );
         Matcher constantMatcher = constant.matcher(expr);
         if (constantMatcher.matches()) {
            this.frameToUpdate = constantMatcher.group(1);
            this.slotToUpdate = constantMatcher.group(2);
            stringUpdateType = constantMatcher.group(3);
            secondKnowledge = constantMatcher.group(4);
         }
         else {
            // NOTE. Only alphanumeric chars in KnowledgeExpr
            throw new KnowledgeException("KnowledgeUpdate doesn't follow the setting syntax: " + expr + " .");
         }
      }
      setSettingProperties(secondKnowledge);

      switch (stringUpdateType) {
         case ":=":
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
            throw new KnowledgeException("Wrong UPDATEtype");
      }
   }

   @Override
   public String toString() {
      return "com.interactivefiction.game.enhanced.reasoning.updates.KnowledgeUpdate{" +
          "updateType=" + updateType +
          ", settingType=" + settingType +
          ", frameToUpdate='" + frameToUpdate + '\'' +
          ", slotToUpdate='" + slotToUpdate + '\'' +
          ", foreignFrame='" + foreignFrame + '\'' +
          ", foreignSlot='" + foreignSlot + '\'' +
          ", updateConstant=" + updateConstant +
          '}';
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
      return getUpdateType() == that.getUpdateType() &&
          getSettingType() == that.getSettingType() &&
          getFrameToUpdate().equals(that.getFrameToUpdate()) &&
          getSlotToUpdate().equals(that.getSlotToUpdate()) &&
          Objects.equals(getForeignFrame(), that.getForeignFrame()) &&
          Objects.equals(getForeignSlot(), that.getForeignSlot()) &&
          Objects.equals(getUpdateConstant(), that.getUpdateConstant());
   }

   @Override
   public int hashCode() {
      return Objects.hash(getUpdateType(), getSettingType(), getFrameToUpdate(), getSlotToUpdate(), getForeignFrame(), getForeignSlot(), getUpdateConstant());
   }
}
