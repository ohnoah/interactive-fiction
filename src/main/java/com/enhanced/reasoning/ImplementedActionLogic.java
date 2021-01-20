package com.enhanced.reasoning;

import com.enhanced.FileErrorHandler;
import com.enhanced.reasoning.exceptions.KnowledgeException;
import com.shared.ActionFormat;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImplementedActionLogic implements Serializable {


   private static final long serialVersionUID = 4575681666201867807L;
   // Initialize maps for implementedLogic
   public static Map<ActionFormat, List<Condition>> implementedConditionsMap;
   public static Map<ActionFormat, String> implementedSuccessMessageMap;
   public static Map<ActionFormat, List<KnowledgeUpdate>> implementedKnowledgeUpdateMap;
   public static List<GenericFrame> defaultGenericFrames;


   static {
      implementedConditionsMap = new HashMap<>();
      implementedSuccessMessageMap = new HashMap<>();
      implementedKnowledgeUpdateMap = new HashMap<>();

      /* PUT IN
      --------
       */
      {
         ActionFormat putIn = new ActionFormat("put", "put ([\\w\\s]+) in ([\\w\\s]+)$");
         Condition putConditionNotContained0 = new Condition("NOT _arg0::isContained",
             "The _arg0 is already inside of something.");
         Condition putConditionIsContainer = new Condition("_arg1::isContainer",
             "You can't do that because _arg1 is not a container.");
         Condition putConditionArg0SolidOrLiquid = new Condition("_arg0::state = \"solid\" OR _arg0::state = \"liquid\"",
             "You can't put the _arg0 anywhere because it's not solid or liquid.");
         Condition putConditionArg1SolidOrLiquid = new Condition("_arg1::state = \"solid\" OR _arg1::state = \"liquid\"",
             "You can't put _arg0 in _arg1 because _arg1 isn't solid or liquid.");
         Condition putConditionVolume = new Condition("_arg0::volume <= _arg1::internalVolume",
             "The _arg1 is not big enough to contain the _arg0.");
         Condition putConditionNotContained1 = new Condition("NOT _arg1::isContained",
             "You can't do that because _arg1 is inside of something.");
         Condition putConditionMass = new Condition("_world::liftingPower >= _arg0::mass",
             "The _arg0 is too heavy for you to put in the _arg1.");
         // We can use knowledgeEngine constructs here

         implementedSuccessMessageMap.put(putIn, "You put the _arg0 in the _arg1.");
         implementedConditionsMap.put(putIn, List.of(putConditionNotContained0,
             putConditionIsContainer, putConditionArg0SolidOrLiquid, putConditionArg1SolidOrLiquid,
             putConditionVolume, putConditionNotContained1, putConditionMass));
         try {
            KnowledgeUpdate putMinusVolume = new KnowledgeUpdate("_arg1::internalVolume -= _arg0::volume");
            KnowledgeUpdate putContains = new KnowledgeUpdate("_arg1::contains += _arg0");
            KnowledgeUpdate putContained = new KnowledgeUpdate("_arg0::isContained := TRUE");
            implementedKnowledgeUpdateMap.put(putIn, List.of(putMinusVolume, putContains, putContained));
         } catch (KnowledgeException e) {
            FileErrorHandler.printExceptionToLog(e);
         }
      }


   /* PUT ON
   --------
    */
      {
         ActionFormat putOn = new ActionFormat("put", "put ([\\w\\s]+) on ([\\w\\s]+)$");
         Condition putConditionNotContained = new Condition("NOT _arg0::isContained",
             "You can't put the _arg0 on _arg1 because _arg0 is inside of something.");
         Condition putConditionArg0SolidOrLiquid = new Condition("_arg0::state = \"solid\" OR _arg0::state = \"liquid\"",
             "You can't put the _arg0 anywhere because it's not solid or liquid.");
         Condition putConditionArg1Solid = new Condition("_arg0::state = \"solid\"",
             "You can't put _arg0 on the _arg1 because _arg1 is not solid.");
         Condition putConditionMass = new Condition("_world::liftingPower >= _arg0::mass",
             "The _arg0 is too heavy for you to put on the _arg1.");
         implementedConditionsMap.put(putOn, List.of(putConditionNotContained, putConditionArg0SolidOrLiquid, putConditionArg1Solid, putConditionMass));
         implementedSuccessMessageMap.put(putOn, "You put the _arg0 on the _arg1.");
      }

      /* REMOVE
      --------
       */

      {
         ActionFormat remove = new ActionFormat("remove", "remove ([\\w\\s]+) from ([\\w\\s]+)$");

         Condition removeConditionIsContained0 = new Condition("_arg0::isContained",
             "The _arg0 is not inside of anything.");
         Condition removeConditionSolid = new Condition("_arg0::state = \"solid\"",
             "You can't remove the _arg0 because it's not solid.");
         Condition removeConditionIsContained1 = new Condition("NOT _arg1::isContained",
             "The _arg1 is inside of something so you can't remove _arg0 from it.");
         Condition removeConditionIsContainer = new Condition("_arg1::isContainer",
             "The _arg0 is not inside of the _arg1 because _arg1 doesn't have things inside of it.");
         Condition removeConditionContains = new Condition("\"_arg0\" IN _arg1::contains",
             "The _arg0 is not inside of the _arg1");
         Condition removeConditionMass = new Condition("_world::liftingPower >= _arg0::mass",
             "The _arg0 is too heavy for you to remove from the _arg1.");

         implementedConditionsMap.put(remove, List.of(removeConditionIsContained0, removeConditionSolid, removeConditionIsContained1,
             removeConditionIsContainer, removeConditionContains, removeConditionMass));
         implementedSuccessMessageMap.put(remove, "You removed the _arg0 from the _arg1.");
         try {
            KnowledgeUpdate removePlusVolume = new KnowledgeUpdate("_arg1::internalVolume += _arg0::volume");
            KnowledgeUpdate removeContains = new KnowledgeUpdate("_arg1::contains -= _arg0");
            KnowledgeUpdate removeContained = new KnowledgeUpdate("_arg0::isContained := FALSE");
            implementedKnowledgeUpdateMap.put(remove, List.of(removePlusVolume, removeContains, removeContained));
         } catch (KnowledgeException e) {
            FileErrorHandler.printExceptionToLog(e);
         }
      }

       /* TRANSFER
      --------
       */
      {
         ActionFormat transfer = new ActionFormat("transfer", "transfer ([\\w\\s]+) from ([\\w\\s]+) (?:to|into) ([\\w\\s]+)$");
         Condition transferConditionIsContainer = new Condition("_arg2::isContainer",
             "You can't do that because _arg2 is not a container.");
         Condition transferConditionMass = new Condition("_world::liftingPower >= _arg0::mass",
             "The _arg0 is too heavy for you to transfer to the _arg2.");
         Condition transferConditionArg2SolidOrLiquid = new Condition("_arg2::state = \"solid\" OR _arg2::state = \"liquid\"",
             "You can't transfer _arg0 to _arg2 because _arg2 isn't solid or liquid.");
         Condition transferConditionNotContained2 = new Condition("NOT _arg2::isContained",
             "You can't do that because _arg2 is inside of something.");
         Condition transferConditionVolume = new Condition("_arg0::volume <= _arg2::internalVolume",
             "The _arg2 is not big enough to contain the _arg0.");
         // We can use knowledgeEngine constructs here

         implementedSuccessMessageMap.put(transfer, "You transfer the _arg0 from the _arg1 to the _arg2.");
         implementedConditionsMap.put(transfer, List.of(transferConditionIsContainer,
             transferConditionMass, transferConditionArg2SolidOrLiquid,
             transferConditionNotContained2, transferConditionVolume));
         try {
            KnowledgeUpdate transferContainsArg1 = new KnowledgeUpdate("_arg1::contains -= _arg0");
            KnowledgeUpdate transferContainsArg2 = new KnowledgeUpdate("_arg2::contains += _arg0");
            KnowledgeUpdate transferContained = new KnowledgeUpdate("_arg0::isContained := TRUE");
            KnowledgeUpdate transferAddVolume = new KnowledgeUpdate("_arg1::internalVolume += _arg0::volume");
            KnowledgeUpdate transferMinusVolume = new KnowledgeUpdate("_arg2::internalVolume -= _arg0::volume");
            implementedKnowledgeUpdateMap.put(transfer, List.of(transferAddVolume, transferContainsArg1, transferContainsArg2, transferContained, transferMinusVolume));
         } catch (KnowledgeException e) {
            FileErrorHandler.printExceptionToLog(e);
         }
      }


      /* TAKE
      --------
       */

      {
         ActionFormat take = new ActionFormat("take", null);
         Condition takeConditionTaken = new Condition("NOT (\"_arg0\" IN world::inventory)",
             "The _arg0 is already on your person.");
         Condition takeConditionSolid = new Condition("_arg0::state = \"solid\"",
             "You can't take the _arg0 because it's not solid.");
         Condition takeConditionIsTakeable = new Condition("_arg0::isTakeable",
             "You can't take the _arg0 right now.");
         Condition takeConditionNotContained = new Condition("NOT _arg0::isContained",
             "The _arg0 is inside of something else.");
         Condition takeConditionMass = new Condition("_world::liftingPower >= _arg0::mass",
             "The _arg0 is too heavy for you to carry.");
         implementedConditionsMap.put(take, List.of(takeConditionTaken, takeConditionSolid, takeConditionIsTakeable, takeConditionNotContained, takeConditionMass));
         implementedSuccessMessageMap.put(take, "You take the _arg0.");
         try {
            KnowledgeUpdate takeInventory = new KnowledgeUpdate("world::inventory += _arg0");
            implementedKnowledgeUpdateMap.put(take, List.of(takeInventory));
         } catch (KnowledgeException e) {
            FileErrorHandler.printExceptionToLog(e);
         }
      }


   /* PUSH
   --------
   */
      {
         ActionFormat push = new ActionFormat("push", null);
         Condition pushConditionSolid = new Condition("_arg0::state = \"solid\"",
             "You can't push the _arg0 because it's not solid.");
         Condition pushConditionNotContained = new Condition("NOT _arg0::isContained",
             "The _arg0 is inside of something else.");
         Condition pushConditionMass = new Condition("_world::liftingPower >= _arg0::mass",
             "The _arg0 is too heavy for you to push.");
         implementedConditionsMap.put(push, List.of(pushConditionSolid, pushConditionNotContained, pushConditionMass));
         implementedSuccessMessageMap.put(push, "You push the _arg0.");
      }
   /* PULL
   --------
   */
      {
         ActionFormat pull = new ActionFormat("pull", null);
         Condition pullConditionSolid = new Condition("_arg0::state = \"solid\"",
             "You can't pull the _arg0 because it's not solid.");
         Condition pullConditionNotContained = new Condition("NOT _arg0::isContained",
             "The _arg0 is inside of something else.");
         Condition pullConditionMass = new Condition("_world::liftingPower >= _arg0::mass",
             "The _arg0 is too heavy for you to pull.");
         implementedConditionsMap.put(pull, List.of(pullConditionSolid, pullConditionNotContained, pullConditionMass));
         implementedSuccessMessageMap.put(pull, "You pull the _arg0.");
      }

   /* DROP
   --------
    */
      {
         ActionFormat drop = new ActionFormat("drop", null);
         Condition dropConditionTaken = new Condition("\"_arg0\" IN world::inventory",
             "You can't drop the _arg0 because you haven't picked it up.");
         implementedConditionsMap.put(drop, List.of(dropConditionTaken));
         implementedSuccessMessageMap.put(drop, "You drop the _arg0 next to you.");
         try {
            KnowledgeUpdate dropInventory = new KnowledgeUpdate("world::inventory -= _arg0");
            implementedKnowledgeUpdateMap.put(drop, List.of(dropInventory));
         } catch (KnowledgeException e) {
            FileErrorHandler.printExceptionToLog(e);
         }
      }

   /* TURN
   --------
    */
      {
         ActionFormat turn = new ActionFormat("turn", null);
         Condition turnConditionNotContained = new Condition("NOT _arg0::isContained",
             "You can't turn the _arg0 because it is inside of something else.");
         Condition turnConditionSolid = new Condition("_arg0::state = \"solid\"",
             "You can't turn the _arg0 because it's not solid.");
         implementedConditionsMap.put(turn, List.of(turnConditionNotContained, turnConditionSolid));
         implementedSuccessMessageMap.put(turn, "You turn the _arg0.");
      }

   /* search
   --------
    */
      {
         ActionFormat search = new ActionFormat("search", null);
         Condition searchConditionNotContained = new Condition("NOT _arg0::isContained",
             "You can't search the _arg0 because it is inside of something else.");
         Condition searchConditionSolid = new Condition("_arg0::state = \"solid\"",
             "You can't search the _arg0 because it's not solid.");
         implementedConditionsMap.put(search, List.of(searchConditionNotContained, searchConditionSolid));
         implementedSuccessMessageMap.put(search, "You search the _arg0.");
      }

      /* examine
      --------
       */
      {
         ActionFormat examine = new ActionFormat("examine", null);
         Condition examineConditionNotContained = new Condition("NOT _arg0::isContained",
             "You can't examine the _arg0 because it is inside of something else.");
         implementedConditionsMap.put(examine, List.of(examineConditionNotContained));
         implementedSuccessMessageMap.put(examine, "You examine the _arg0.");
      }

      /* LISTEN TO
      --------
       */
      {
         ActionFormat listenTo = new ActionFormat("listen", "listen to ([\\w\\s]+)$");
         implementedConditionsMap.put(listenTo, List.of());
         implementedSuccessMessageMap.put(listenTo, "You listen to the _arg0.");
      }


   }

   static {
      GenericFrame nonContainer = new GenericFrame("nonContainer");
      GenericFrame container = new GenericFrame("container");
      GenericFrame massive = new GenericFrame("massive");
      GenericFrame voluminous = new GenericFrame("voluminous");
      GenericFrame takeable = new GenericFrame("takeable");
      GenericFrame edible = new GenericFrame("edible");
      GenericFrame drinkable = new GenericFrame("drinkable");
      // DEFAULT
      nonContainer.addSlots(Map.of("isContained", false,
          "isContainer", false,
          "state", "solid",
          "isTakeable", false,
          "isEdible", false,
          "isDrinkable", false
      ));
      container.addSlots(Map.of("isContained", false,
          "isContainer", true,
          "volume", 50.0,
          "internalVolume", 50.0,
          "contains", new ArrayList<>()
      ));
      massive.addSlot("mass", 50.0);
      voluminous.addSlot("volume", 50.0);
      takeable.addSlot("isTakeable", true);
      edible.addSlots(Map.of("isEdible", true));
      drinkable.addSlots(Map.of("isDrinkable", true));
      defaultGenericFrames = List.of(nonContainer, container, massive, voluminous, takeable, edible, drinkable);
   }

}
