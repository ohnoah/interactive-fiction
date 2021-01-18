package com.enhanced.reasoning;

import com.enhanced.reasoning.exceptions.KnowledgeException;
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
      this.foreignFrame = KnowledgeBase.stripUnderscore(foreignFrame);
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
          String.format("%s|%s|%s|%s|TRUE|FALSE",
              KnowledgeRegex.stringExpr, KnowledgeRegex.numberExpr, KnowledgeRegex.numberListExpr, KnowledgeRegex.stringListExpr),
          secondOperand);
   }

   private void setSettingProperties(String updateValue) {
      if (isConstant(updateValue)) {
         this.settingType = SettingType.CONSTANT;
         updateConstant = typeConvert(updateValue);
      }
      else {
         if (Pattern.matches(KnowledgeRegex.frameNameExpr, updateValue)) {
            this.settingType = SettingType.FRAME;
            foreignFrame = updateValue;
         }
         else if (Pattern.matches(KnowledgeRegex.knowledgeExpr, updateValue)) {
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
      String knowledgeExpr = KnowledgeRegex.knowledgeExpr;
      String largeCaptureKnowledgeExpr = KnowledgeRegex.largeCaptureKnowledgeExpr;
      String setTypeExpr = KnowledgeRegex.setTypeExpr;
      String numberExpr = KnowledgeRegex.numberExpr;
      String stringExpr = KnowledgeRegex.stringExpr;
      String stringListExpr = KnowledgeRegex.stringListExpr;
      String numberListExpr = KnowledgeRegex.numberListExpr;
      String frameNameExpr = KnowledgeRegex.frameNameExpr;

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
             String.format("^%s %s (%s|%s|%s|%s|TRUE|FALSE)$", knowledgeExpr, setTypeExpr, numberExpr, stringExpr, stringListExpr, numberListExpr)
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
            throw new KnowledgeException("com.enhanced.reasoning.KnowledgeUpdate doesn't follow the setting syntax: " + expr + " .");
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
      return "com.enhanced.reasoning.KnowledgeUpdate{" +
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
