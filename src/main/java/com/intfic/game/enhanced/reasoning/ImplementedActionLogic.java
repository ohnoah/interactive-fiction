package com.intfic.game.enhanced.reasoning;

import com.intfic.game.enhanced.FileErrorHandler;
import com.intfic.game.enhanced.reasoning.error.KnowledgeException;
import com.intfic.game.enhanced.reasoning.frames.GenericFrame;
import com.intfic.game.enhanced.reasoning.wrappers.Condition;
import com.intfic.game.enhanced.reasoning.updates.KnowledgeUpdate;
import com.intfic.game.shared.ActionFormat;
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
   public static List<ActionFormat> defaultActionFormats;


   static {
      ActionFormat examine = new ActionFormat("examine");
      ActionFormat push = new ActionFormat("push");
      ActionFormat take = new ActionFormat("take");
      ActionFormat pull = new ActionFormat("pull");
      ActionFormat follow = new ActionFormat("follow");
      ActionFormat go = new ActionFormat("go", "go to ([\\w\\s]+)$");
      ActionFormat drop = new ActionFormat("drop");
      ActionFormat turnOn = new ActionFormat("turn", "turn ([\\w\\s]+) on$");
      ActionFormat turnOff = new ActionFormat("turn", "turn ([\\w\\s]+) off$");
      ActionFormat open = new ActionFormat("open");
      ActionFormat feel = new ActionFormat("feel");
      ActionFormat putIn = new ActionFormat("put", "put ([\\w\\s]+) in ([\\w\\s]+)$");
      ActionFormat putOn = new ActionFormat("put", "put ([\\w\\s]+) on ([\\w\\s]+)$");
      ActionFormat putOnSingle = new ActionFormat("put", "put on ([\\w\\s]+)$");
      // you could also try
      ActionFormat eat = new ActionFormat("eat");
      ActionFormat climb = new ActionFormat("climb");
      ActionFormat drink = new ActionFormat("drink", "drink ([\\w\\s]+) from ([\\w\\s]+)$");
      ActionFormat wave = new ActionFormat("wave");
      ActionFormat wear = new ActionFormat("wear");
      ActionFormat smell = new ActionFormat("smell");
      ActionFormat throwAt = new ActionFormat("throw", "throw ([\\w\\s]+) at ([\\w\\s]+)$");
      ActionFormat listenTo = new ActionFormat("listen", "listen to ([\\w\\s]+)$");
      ActionFormat breakIt = new ActionFormat("break");
      ActionFormat burn = new ActionFormat("burn");
      ActionFormat enter = new ActionFormat("enter");
      ActionFormat leave = new ActionFormat("leave");
      ActionFormat search = new ActionFormat("search");
      ActionFormat unlockWith = new ActionFormat("unlock", "unlock ([\\w\\s]+) with ([\\w\\s]+)$");
      // Noah's own
      ActionFormat remove = new ActionFormat("remove", "remove ([\\w\\s]+) from ([\\w\\s]+)$");
      ActionFormat transfer = new ActionFormat("transfer", "transfer ([\\w\\s]+) from ([\\w\\s]+) (?:to|into) ([\\w\\s]+)$");

      defaultActionFormats = List.of(examine, push, take, pull, follow, go, drop, turnOn, turnOff, open, feel, putIn,
          putOn, putOnSingle, eat, climb, drink, wave, /*fill,*/ wear, smell, throwAt, listenTo, breakIt, burn, enter, leave, search, unlockWith, remove, transfer);
      implementedConditionsMap = new HashMap<>();
      implementedSuccessMessageMap = new HashMap<>();
      implementedKnowledgeUpdateMap = new HashMap<>();

      /* PUT IN
      --------
       */
      {
         /*ActionFormat putIn = new ActionFormat("put", "put ([\\w\\s]+) in ([\\w\\s]+)$");*/
         Condition putConditionNotContained0 = new Condition("NOT !arg0::isContained",
             "The !arg0 is already inside of something.");
         Condition putConditionIsContainer = new Condition("!arg1::isContainer",
             "You can't do that because !arg1 is not a container.");
         Condition putConditionArg0SolidOrLiquid = new Condition("!arg0::state = \"solid\" OR !arg0::state = \"liquid\"",
             "You can't put the !arg0 anywhere because it's not solid or liquid.");
         Condition putConditionArg1SolidOrLiquid = new Condition("!arg1::state = \"solid\" OR !arg1::state = \"liquid\"",
             "You can't put !arg0 in !arg1 because !arg1 isn't solid or liquid.");
         Condition putConditionVolume = new Condition("!arg0::volume <= !arg1::internalVolume",
             "The !arg1 is not big enough to contain the !arg0.");
         Condition putConditionNotContained1 = new Condition("NOT !arg1::isContained",
             "You can't do that because !arg1 is inside of something.");
         Condition putConditionMass = new Condition("!world::liftingPower >= !arg0::mass",
             "The !arg0 is too heavy for you to put in the !arg1.");
         // We can use knowledgeEngine constructs here

         implementedSuccessMessageMap.put(putIn, "You put the !arg0 in the !arg1.");
         implementedConditionsMap.put(putIn, List.of(putConditionNotContained0,
             putConditionIsContainer, putConditionArg0SolidOrLiquid, putConditionArg1SolidOrLiquid,
             putConditionVolume, putConditionNotContained1, putConditionMass));
         try {
            KnowledgeUpdate putMinusVolume = new KnowledgeUpdate("!arg1::internalVolume -= !arg0::volume");
            KnowledgeUpdate putContains = new KnowledgeUpdate("!arg1::contains += !arg0");
            KnowledgeUpdate putContained = new KnowledgeUpdate("!arg0::isContained := TRUE");
            implementedKnowledgeUpdateMap.put(putIn, List.of(putMinusVolume, putContains, putContained));
         }
         catch (KnowledgeException e) {
            FileErrorHandler.printExceptionToLog(e);
         }
      }


   /* PUT ON
   --------
    */
      {
         /*ActionFormat putOn = new ActionFormat("put", "put ([\\w\\s]+) on ([\\w\\s]+)$");*/
         Condition putConditionNotContained = new Condition("NOT !arg0::isContained",
             "You can't put the !arg0 on !arg1 because !arg0 is inside of something.");
         Condition putConditionArg0SolidOrLiquid = new Condition("!arg0::state = \"solid\" OR !arg0::state = \"liquid\"",
             "You can't put the !arg0 anywhere because it's not solid or liquid.");
         Condition putConditionArg1Solid = new Condition("!arg0::state = \"solid\"",
             "You can't put !arg0 on the !arg1 because !arg1 is not solid.");
         Condition putConditionMass = new Condition("!world::liftingPower >= !arg0::mass",
             "The !arg0 is too heavy for you to put on the !arg1.");
         implementedConditionsMap.put(putOn, List.of(putConditionNotContained, putConditionArg0SolidOrLiquid, putConditionArg1Solid, putConditionMass));
         implementedSuccessMessageMap.put(putOn, "You put the !arg0 on the !arg1.");
      }

      /* REMOVE
      --------
       */

      {
         /*      ActionFormat remove = new ActionFormat("remove", "remove ([\\w\\s]+) from ([\\w\\s]+)$");*/

         Condition removeConditionIsContained0 = new Condition("!arg0::isContained",
             "The !arg0 is not inside of anything.");
         Condition removeConditionSolid = new Condition("!arg0::state = \"solid\"",
             "You can't remove the !arg0 because it's not solid.");
         Condition removeConditionIsContained1 = new Condition("NOT !arg1::isContained",
             "The !arg1 is inside of something so you can't remove !arg0 from it.");
         Condition removeConditionIsContainer = new Condition("!arg1::isContainer",
             "The !arg0 is not inside of the !arg1 because !arg1 doesn't have things inside of it.");
         Condition removeConditionContains = new Condition("\"!arg0\" IN !arg1::contains",
             "The !arg0 is not inside of the !arg1");
         Condition removeConditionMass = new Condition("!world::liftingPower >= !arg0::mass",
             "The !arg0 is too heavy for you to remove from the !arg1.");

         implementedConditionsMap.put(remove, List.of(removeConditionIsContained0, removeConditionSolid, removeConditionIsContained1,
             removeConditionIsContainer, removeConditionContains, removeConditionMass));
         implementedSuccessMessageMap.put(remove, "You removed the !arg0 from the !arg1.");
         try {
            KnowledgeUpdate removePlusVolume = new KnowledgeUpdate("!arg1::internalVolume += !arg0::volume");
            KnowledgeUpdate removeContains = new KnowledgeUpdate("!arg1::contains -= !arg0");
            KnowledgeUpdate removeContained = new KnowledgeUpdate("!arg0::isContained := FALSE");
            implementedKnowledgeUpdateMap.put(remove, List.of(removePlusVolume, removeContains, removeContained));
         }
         catch (KnowledgeException e) {
            FileErrorHandler.printExceptionToLog(e);
         }
      }

       /* TRANSFER
      --------
       */
      {
         /*ActionFormat transfer = new ActionFormat("transfer", "transfer ([\\w\\s]+) from ([\\w\\s]+) (?:to|into) ([\\w\\s]+)$");*/
         Condition transferConditionIsContainer = new Condition("!arg2::isContainer",
             "You can't do that because !arg2 is not a container.");
         Condition transferConditionMass = new Condition("!world::liftingPower >= !arg0::mass",
             "The !arg0 is too heavy for you to transfer to the !arg2.");
         Condition transferConditionArg2SolidOrLiquid = new Condition("!arg2::state = \"solid\" OR !arg2::state = \"liquid\"",
             "You can't transfer !arg0 to !arg2 because !arg2 isn't solid or liquid.");
         Condition transferConditionNotContained2 = new Condition("NOT !arg2::isContained",
             "You can't do that because !arg2 is inside of something.");
         Condition transferConditionVolume = new Condition("!arg0::volume <= !arg2::internalVolume",
             "The !arg2 is not big enough to contain the !arg0.");
         // We can use knowledgeEngine constructs here

         implementedSuccessMessageMap.put(transfer, "You transfer the !arg0 from the !arg1 to the !arg2.");
         implementedConditionsMap.put(transfer, List.of(transferConditionIsContainer,
             transferConditionMass, transferConditionArg2SolidOrLiquid,
             transferConditionNotContained2, transferConditionVolume));
         try {
            KnowledgeUpdate transferContainsArg1 = new KnowledgeUpdate("!arg1::contains -= !arg0");
            KnowledgeUpdate transferContainsArg2 = new KnowledgeUpdate("!arg2::contains += !arg0");
            KnowledgeUpdate transferContained = new KnowledgeUpdate("!arg0::isContained := TRUE");
            KnowledgeUpdate transferAddVolume = new KnowledgeUpdate("!arg1::internalVolume += !arg0::volume");
            KnowledgeUpdate transferMinusVolume = new KnowledgeUpdate("!arg2::internalVolume -= !arg0::volume");
            implementedKnowledgeUpdateMap.put(transfer, List.of(transferAddVolume, transferContainsArg1, transferContainsArg2, transferContained, transferMinusVolume));
         }
         catch (KnowledgeException e) {
            FileErrorHandler.printExceptionToLog(e);
         }
      }


      /* TAKE
      --------
       */

      {
         /*ActionFormat take = new ActionFormat("take", null);*/
         Condition takeConditionTaken = new Condition("NOT (\"!arg0\" IN world::inventory)",
             "The !arg0 is already on your person.");
         Condition takeConditionSolid = new Condition("!arg0::state = \"solid\"",
             "You can't take the !arg0 because it's not solid.");
         Condition takeConditionIsTakeable = new Condition("!arg0::isTakeable",
             "You can't take the !arg0 right now.");
         Condition takeConditionNotContained = new Condition("NOT !arg0::isContained",
             "The !arg0 is inside of something else.");
         Condition takeConditionMass = new Condition("!world::liftingPower >= !arg0::mass",
             "The !arg0 is too heavy for you to carry.");
         implementedConditionsMap.put(take, List.of(takeConditionTaken, takeConditionSolid, takeConditionIsTakeable, takeConditionNotContained, takeConditionMass));
         implementedSuccessMessageMap.put(take, "You take the !arg0.");
         try {
            KnowledgeUpdate takeInventory = new KnowledgeUpdate("world::inventory += !arg0");
            implementedKnowledgeUpdateMap.put(take, List.of(takeInventory));
         }
         catch (KnowledgeException e) {
            FileErrorHandler.printExceptionToLog(e);
         }
      }


   /* PUSH
   --------
   */
      {
         /*ActionFormat push = new ActionFormat("push", null);*/
         Condition pushConditionSolid = new Condition("!arg0::state = \"solid\"",
             "You can't push the !arg0 because it's not solid.");
         Condition pushConditionNotContained = new Condition("NOT !arg0::isContained",
             "The !arg0 is inside of something else.");
         Condition pushConditionMass = new Condition("!world::liftingPower >= !arg0::mass",
             "The !arg0 is too heavy for you to push.");
         implementedConditionsMap.put(push, List.of(pushConditionSolid, pushConditionNotContained, pushConditionMass));
         implementedSuccessMessageMap.put(push, "You push the !arg0.");
      }
   /* PULL
   --------
   */
      {
         /* ActionFormat pull = new ActionFormat("pull", null);*/
         Condition pullConditionSolid = new Condition("!arg0::state = \"solid\"",
             "You can't pull the !arg0 because it's not solid.");
         Condition pullConditionNotContained = new Condition("NOT !arg0::isContained",
             "The !arg0 is inside of something else.");
         Condition pullConditionMass = new Condition("!world::liftingPower >= !arg0::mass",
             "The !arg0 is too heavy for you to pull.");
         implementedConditionsMap.put(pull, List.of(pullConditionSolid, pullConditionNotContained, pullConditionMass));
         implementedSuccessMessageMap.put(pull, "You pull the !arg0.");
      }

   /* DROP
   --------
    */
      {
         /*ActionFormat drop = new ActionFormat("drop", null);*/
         Condition dropConditionTaken = new Condition("\"!arg0\" IN world::inventory",
             "You can't drop the !arg0 because you haven't picked it up.");
         implementedConditionsMap.put(drop, List.of(dropConditionTaken));
         implementedSuccessMessageMap.put(drop, "You drop the !arg0 next to you.");
         try {
            KnowledgeUpdate dropInventory = new KnowledgeUpdate("world::inventory -= !arg0");
            implementedKnowledgeUpdateMap.put(drop, List.of(dropInventory));
         }
         catch (KnowledgeException e) {
            FileErrorHandler.printExceptionToLog(e);
         }
      }

   /* TURN ON
   --------
    */
      {
         /*ActionFormat turn = new ActionFormat("turn", null);*/
         Condition turnConditionNotContained = new Condition("NOT !arg0::isContained",
             "You can't turn on the !arg0 because it is inside of something else.");
         Condition turnConditionSolid = new Condition("!arg0::state = \"solid\"",
             "You can't turn on the !arg0 because it's not solid.");
         implementedConditionsMap.put(turnOn, List.of(turnConditionNotContained, turnConditionSolid));
         implementedSuccessMessageMap.put(turnOn, "You turn on the !arg0.");
      }


         /* TURN OFF
   --------
    */
      {
         /*ActionFormat turn = new ActionFormat("turn", null);*/
         Condition turnConditionNotContained = new Condition("NOT !arg0::isContained",
             "You can't turn off the !arg0 because it is inside of something else.");
         Condition turnConditionSolid = new Condition("!arg0::state = \"solid\"",
             "You can't turn off the !arg0 because it's not solid.");
         implementedConditionsMap.put(turnOff, List.of(turnConditionNotContained, turnConditionSolid));
         implementedSuccessMessageMap.put(turnOff, "You turn off the !arg0.");
      }

   /* search
   --------
    */
      {
         /*ActionFormat search = new ActionFormat("search", null);*/
         Condition searchConditionNotContained = new Condition("NOT !arg0::isContained",
             "You can't search the !arg0 because it is inside of something else.");
         Condition searchConditionSolid = new Condition("!arg0::state = \"solid\"",
             "You can't search the !arg0 because it's not solid.");
         implementedConditionsMap.put(search, List.of(searchConditionNotContained, searchConditionSolid));
         implementedSuccessMessageMap.put(search, "You search the !arg0.");
      }

      /* examine
      --------
       */
      {
         /*ActionFormat examine = new ActionFormat("examine", null);*/
         Condition examineConditionNotContained = new Condition("NOT !arg0::isContained",
             "You can't examine the !arg0 because it is inside of something else.");
         implementedConditionsMap.put(examine, List.of(examineConditionNotContained));
         implementedSuccessMessageMap.put(examine, "You examine the !arg0.");
      }

      /* LISTEN TO
      --------
       */
      {
         /*ActionFormat listenTo = new ActionFormat("listen", "listen to ([\\w\\s]+)$");*/
         implementedConditionsMap.put(listenTo, List.of());
         implementedSuccessMessageMap.put(listenTo, "You listen to the !arg0.");
      }


      /* EAT
      --------
       */
      {
         /*ActionFormat eat = new ActionFormat("eat");*/
         Condition eatConditionEdible = new Condition("!arg0::isEdible",
             "You can't do that because the !arg0 is not edible.");
         Condition eatConditionNotContained = new Condition("NOT !arg0::isContained",
             "You can't eat the !arg0 because it is inside of something else.");
         implementedConditionsMap.put(eat, List.of(eatConditionEdible, eatConditionNotContained));
         implementedSuccessMessageMap.put(eat, "You eat up the !arg0. It tastes !arg0::taste.");
         try {
            KnowledgeUpdate deleteItem = new KnowledgeUpdate("world::items -= !arg0");
            implementedKnowledgeUpdateMap.put(eat, List.of(deleteItem));
         }
         catch (KnowledgeException e) {
            FileErrorHandler.printExceptionToLog(e);
         }
      }

      /* DRINK
      --------
       */
      {
         /*ActionFormat drink = new ActionFormat("drink", "drink ([\\w\\s]+) from ([\\w\\s]+)$");*/
         Condition drinkConditionNotContained = new Condition("NOT !arg1::isContained",
             "The !arg1 is inside of something so you can't drink the !arg0 from it.");
         Condition drinkInContainer = new Condition("!arg1::isContainer AND \"!arg0\" IN !arg1::contains",
             "You can't do that because the !arg0 is not in the !arg1.");
         Condition drinkConditionLiquid = new Condition("!arg0::state = \"liquid\"",
             "You can't drink the !arg0 because it's not liquid.");
         Condition drinkConditionDrinkable = new Condition("!arg0::isDrinkable",
             "You can't do that because the !arg0 is not drinkable.");
         implementedConditionsMap.put(drink, List.of(drinkConditionNotContained, drinkInContainer, drinkConditionLiquid, drinkConditionDrinkable));
         implementedSuccessMessageMap.put(drink, "You drink the !arg0. It tastes !arg0::taste.");
         try {
            KnowledgeUpdate deleteItem = new KnowledgeUpdate("world::items -= !arg0");
            implementedKnowledgeUpdateMap.put(drink, List.of(deleteItem));
         }
         catch (KnowledgeException e) {
            FileErrorHandler.printExceptionToLog(e);
         }
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
      edible.addSlots(Map.of("isEdible", true, "taste", "uninteresting"));
      drinkable.addSlots(Map.of("isDrinkable", true, "state", "liquid", "taste", "uninteresting", "volume", 50.0));
      defaultGenericFrames = List.of(nonContainer, container, massive, voluminous, takeable, edible, drinkable);
   }

}
