import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ActionLogic {
   private KnowledgeBase knowledgeBase;
   private boolean valid;
   private String reasoning;
   private Map<ActionFormat, List<Condition>> conditionsMap;
   private Map<ActionFormat, String> successMessage;
   private Map<ActionFormat, List<KnowledgeUpdate>> knowledgeUpdateMap;

   public ActionLogic(InstantiatedGameAction gameAction, KnowledgeBase knowledgeBase) {
      this.knowledgeBase = knowledgeBase;

      ActionFormat putIn = new ActionFormat("put", "put ([\\w\\s]+) in ([\\w\\s]+)$");
      Condition putConditionIsContainer = new Condition("_arg2::isContainer",
          "You can't do that because _arg2 is not a container");
      Condition putConditionVolume = new Condition("_arg1::volume <= _arg2::volume",
          "_arg2 is not big enough to contain _arg1");
      // We can use knowledgeEngine constructs here
      successMessage.put(putIn, "You put the smaller _arg1 in _arg2");
      conditionsMap.put(putIn, List.of(putConditionIsContainer, putConditionVolume));
      // TODO: Create KnowledgeUpdate to subtract from the volume, add _arg1 to _arg2's contains
      // TODO: and add _arg2 to _arg2's inside field.


      ActionFormat remove = new ActionFormat("remove", "remove ([\\w\\s]+) from ([\\w\\s]+)$");

      checkLogic(gameAction);
   }

   private void fillConditionWithArgs(Condition condition, List<String> nouns) {
      String newBooleanExpr = replaceArgsWithNouns(condition.getBooleanExpr(), nouns);
      String newFailureMessage = replaceArgsWithNouns(condition.getFailureMessage(), nouns);
      condition.setBooleanExpr(newBooleanExpr);
      condition.setFailureMessage(newFailureMessage);
   }

   private String replaceArgsWithNouns(String s, List<String> nouns) {
      String newString = s;
      for (int i = 1; i <= nouns.size(); i++) {
         newString = newString.replaceAll("_arg" + i, nouns.get(i));
      }
      return newString;
   }

   // TODO: We are going to want the exact same logic for the GameDesignActiosn later
   // TODO: Maybe it's best to fill condition with concrete values here and pass that in to KB
   private void checkLogic(InstantiatedGameAction gameAction) {
      boolean valid = true;
      String reasoning = "";
      ActionFormat actionFormat = gameAction.getAbstractActionFormat();
      // If action is implemented
      List<String> nouns = gameAction.getArguments();
      if (conditionsMap.containsKey(actionFormat)) {
         List<Condition> conditions = conditionsMap.get(actionFormat);
         // TODO: Encapsulate this in a method that can be used in EnhancedGameDesignAction as well
         for (Condition condition : conditions) {
            // This will populate the errorMessage in Condition if fails
            fillConditionWithArgs(condition, nouns);
            try {
               if (!knowledgeBase.validateCondition(condition.getBooleanExpr())) {
                  valid = false;
                  reasoning = knowledgeBase.fillQueryString(condition.getFailureMessage());
                  break;
               }
            } catch (InvalidKnowledgeSyntaxException e) {
               valid = false;
               reasoning = "There was an error behind the scenes. Try performing another action.";
               e.printStackTrace();
            }
         }
         if (valid) {
            String populatedSuccessMessage = replaceArgsWithNouns(successMessage.get(actionFormat), nouns);
            reasoning = knowledgeBase.fillQueryString(populatedSuccessMessage);

            List<KnowledgeUpdate> knowledgeUpdates =
                knowledgeUpdateMap.getOrDefault(actionFormat, new ArrayList<>());
            for(KnowledgeUpdate knowledgeUpdate : knowledgeUpdates){
               knowledgeBase.update(knowledgeUpdate);
            }
         }
         // TODO: Encapsulate

      }
      this.valid = valid;
      this.reasoning = reasoning;
   }

   public boolean isValid() {
      return valid;
   }

   public String textReason() {
      return reasoning;
   }
}
