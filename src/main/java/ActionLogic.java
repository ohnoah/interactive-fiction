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


      ActionFormat remove = new ActionFormat("remove", "remove ([\\w\\s]+) from ([\\w\\s]+)$");

      checkLogic(gameAction);
   }

   private void checkLogic(InstantiatedGameAction gameAction) {
      boolean valid = true;
      String reasoning = "";
      ActionFormat actionFormat = gameAction.getAbstractActionFormat();
      // If action is implemented
      if(conditionsMap.containsKey(actionFormat)){
         List<Condition> conditions = conditionsMap.get(actionFormat);
         for(Condition condition : conditions){
            // This will populate the errorMessage in Condition if fails
            // TODO: Validate condition should use replacePlaceholders on condition.failureMsg
            if(!knowledgeBase.validateCondition(condition, gameAction.getArguments())){
               valid = false;
               reasoning = condition.getFailureMessage();
               break;
            }
         }
         if(valid){
            reasoning = knowledgeBase.replacePlaceholders(successMessage.get(actionFormat));
         }

         List<KnowledgeUpdate> knowledgeUpdates =
             knowledgeUpdateMap.getOrDefault(actionFormat, new ArrayList<>());
         // TODO: Use a method on the knowledgeBase to update it. This method needs to understand
         // TODO: the engineering of the KnowledgeUpdate
         //
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
