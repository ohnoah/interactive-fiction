import static org.junit.Assert.*;


import com.intfic.game.enhanced.EnhancedGameEngine;
import com.intfic.game.enhanced.EnhancedGameDesignAction;
import com.intfic.game.enhanced.reasoning.wrappers.Condition;
import com.intfic.game.enhanced.reasoning.wrappers.Justification;
import com.intfic.game.enhanced.reasoning.updates.KnowledgeUpdate;
import com.intfic.game.enhanced.reasoning.error.KnowledgeException;
import com.intfic.game.enhanced.reasoning.error.MissingKnowledgeException;
import com.intfic.game.shared.ActionFormat;
import com.intfic.game.shared.InstantiatedGameAction;
import com.intfic.game.shared.Item;
import com.intfic.game.shared.Room;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.Test;

public class EnhancedGameEngineTest {
   private static EnhancedGameEngine oneRoomOneAction() throws KnowledgeException {
      Room room = new Room("place1");
      List<Item> place1Items = TestUtil.stringsToItemsInRoomNoAdj(Set.of("apple", "banana", "orange"));
      room.setItems(place1Items);

      EnhancedGameEngine enhancedGameEngine = new EnhancedGameEngine();
      enhancedGameEngine.addRoom(room);
      enhancedGameEngine.setCurrentRoom(room);


      ActionFormat actionFormat = new ActionFormat("feel");
      // Create key for action
      InstantiatedGameAction instantiatedGameAction = new InstantiatedGameAction(actionFormat,
          List.of(TestUtil.findItem(place1Items, "apple")), true);
      // Create value for action
      List<Condition> conditions = new ArrayList<>();
      conditions.add(new Condition("world::room = \"place1\"", "I believe you are not in place1 yet, you are in world::room."));
      List<KnowledgeUpdate> knowledgeUpdates = new ArrayList<>();
      knowledgeUpdates.add(new KnowledgeUpdate("world::randomState := \"very-good\""));
      knowledgeUpdates.add(new KnowledgeUpdate("world::numActions := 0"));
      knowledgeUpdates.add(new KnowledgeUpdate("world::supersetState := \"very-not-good\""));
      EnhancedGameDesignAction enhancedGameDesignAction = new EnhancedGameDesignAction(conditions, "You did action 1 in enhanced.", knowledgeUpdates);
      // Put in maps
      enhancedGameEngine.addAction(room, instantiatedGameAction, enhancedGameDesignAction);

      return enhancedGameEngine;
   }

   private static EnhancedGameEngine twoRoomTwoActions() throws KnowledgeException {
      Room room = new Room("place1");
      List<Item> room1Items = TestUtil.stringsToItemsInRoomNoAdj(Set.of("apple", "banana", "orange"));
      room.setItems(room1Items);
      Room room2 = new Room("room2");
      List<Item> room2Items = TestUtil.stringsToItemsInRoomNoAdj(Set.of("elephant"));
      room2.setItems(room2Items);

      EnhancedGameEngine enhancedGameEngine = new EnhancedGameEngine();
      enhancedGameEngine.updateKnowledgeBase(new KnowledgeUpdate("world::random := 3.0"));
      enhancedGameEngine.updateKnowledgeBase(new KnowledgeUpdate("banana::isTakeable := TRUE"));
      enhancedGameEngine.addRoom(room);
      enhancedGameEngine.addRoom(room2);
      enhancedGameEngine.setCurrentRoom(room);


      InstantiatedGameAction instantiatedGameAction1 = new InstantiatedGameAction(new ActionFormat("open"), List.of(TestUtil.findItem(room1Items, "banana")), true);
      List<Condition> conditions1 = new ArrayList<>();
      conditions1.add(new Condition("world::room = \"place1\"", "You are not in place1 yet, you are in world::room"));
      List<KnowledgeUpdate> knowledgeUpdates1 = new ArrayList<>();

      knowledgeUpdates1.add(new KnowledgeUpdate("world::room := \"room2\""));
      knowledgeUpdates1.add(new KnowledgeUpdate("world::state := \"random\""));
      knowledgeUpdates1.add(new KnowledgeUpdate("world::numActions := 0"));
      knowledgeUpdates1.add(new KnowledgeUpdate("world::randomList := []"));
      knowledgeUpdates1.add(new KnowledgeUpdate("world::numberList := [3.14, 3.142]"));
      knowledgeUpdates1.add(new KnowledgeUpdate("world::errorMessage := \"You can't do that, dummy.\""));


      InstantiatedGameAction instantiatedGameAction2 = new InstantiatedGameAction(new ActionFormat("feel"), List.of(TestUtil.findItem(room2Items, "elephant")), true);
      List<Condition> conditions2 = new ArrayList<>();
      List<KnowledgeUpdate> knowledgeUpdates2 = new ArrayList<>();
      conditions2.add(new Condition("world::room = \"room2\"", "100% you are not in room2 yet, you are in world::room"));
      knowledgeUpdates2.add(new KnowledgeUpdate("world::numActions += 1"));
      knowledgeUpdates2.add(new KnowledgeUpdate("world::randomList += \"banana\""));
      knowledgeUpdates2.add(new KnowledgeUpdate("world::numberList += world::numActions"));
      knowledgeUpdates2.add(new KnowledgeUpdate("world::numberList -= 3.142"));
      knowledgeUpdates2.add(new KnowledgeUpdate("world::errorMessage := \"You can't do that now.\""));

      EnhancedGameDesignAction enhancedGameDesignAction1 =
          new EnhancedGameDesignAction(conditions1, "You did action 1.", knowledgeUpdates1);
      EnhancedGameDesignAction enhancedGameDesignAction2 =
          new EnhancedGameDesignAction(conditions2, "You did action 2 number world::numActions.", knowledgeUpdates2);

      // testing not alloed action when implemented
      InstantiatedGameAction instantiatedGameAction3 = new InstantiatedGameAction(new ActionFormat("take"), List.of(TestUtil.findItem(room1Items, "banana")), true);
      // Create value for action
      List<Condition> conditions3 = new ArrayList<>();
      conditions3.add(new Condition("world::random = 4.0", "You are not yet world::random equal to 4.0."));
      List<KnowledgeUpdate> knowledgeUpdates3 = new ArrayList<>();
      EnhancedGameDesignAction enhancedGameDesignAction3 =
          new EnhancedGameDesignAction(conditions3, "You did action 3.", knowledgeUpdates3);

      enhancedGameEngine.addAction(room, instantiatedGameAction1, enhancedGameDesignAction1);
      enhancedGameEngine.addAction(room, instantiatedGameAction3, enhancedGameDesignAction3);
      enhancedGameEngine.addAction(room2, instantiatedGameAction2, enhancedGameDesignAction2);
      return enhancedGameEngine;

   }


   private static EnhancedGameEngine puttingNoDesignRoom() throws KnowledgeException {
      Room room = new Room("Putting Room");
      List<Item> room1Items = TestUtil.stringsToItemsInRoomNoAdj(Set.of("box", "pen", "apple", "ball"));
      room.setItems(room1Items);

      EnhancedGameEngine enhancedGameEngine = new EnhancedGameEngine();
      enhancedGameEngine.addRoom(room);
      enhancedGameEngine.setCurrentRoom(room);
      // TODO: Look at making defaults for this
      assertTrue(enhancedGameEngine.addParent("putting_room.box", "container"));
      // TAKEABLE
      assertTrue(enhancedGameEngine.addParent("putting_room.box", "takeable"));
      assertTrue(enhancedGameEngine.addParent("putting_room.apple", "takeable"));
      assertTrue(enhancedGameEngine.addParent("putting_room.ball", "takeable"));
      assertTrue(enhancedGameEngine.addParent("putting_room.pen", "takeable"));
      enhancedGameEngine.updateKnowledgeBaseMultiple(
          new KnowledgeUpdate("putting_room.box::internalVolume := 10"),
          new KnowledgeUpdate("putting_room.box::volume := 10"),
          new KnowledgeUpdate("putting_room.pen::volume := 1"),
          new KnowledgeUpdate("putting_room.ball::volume := 10"),
          new KnowledgeUpdate("putting_room.apple::volume := 5")
      );

      return enhancedGameEngine;
   }


   private EnhancedGameEngine takingPushingPullingRoom() throws KnowledgeException {
      EnhancedGameEngine enhancedGameEngine = new EnhancedGameEngine();

      Room room1 = new Room("Taking Room");
      List<Item> room1Items = TestUtil.stringsToItemsInRoomNoAdj(Set.of("box", "banana", "bottle", "coke", "bucket", "pen", "apple", "ball"));
      room1.setItems(room1Items);

      enhancedGameEngine.addRoom(room1);
      enhancedGameEngine.setCurrentRoom(room1);

      Room room2 = new Room("Other Room");
      List<Item> room2Items = TestUtil.stringsToItemsInRoomNoAdj(Set.of("mouse", "keys", "water"));
      room2.setItems(room2Items);
      enhancedGameEngine.addRoom(room2);

      {
         List<Condition> conditions = List.of(new Condition("TRUE", ""));
         String message = " Well done. You did it.";
         List<KnowledgeUpdate> knowledgeUpdates = List.of(new KnowledgeUpdate("world::random := TRUE"));

         EnhancedGameDesignAction enhancedGameDesignAction =
             new EnhancedGameDesignAction(conditions, message, knowledgeUpdates);
         InstantiatedGameAction instantiatedGameAction = new InstantiatedGameAction(new ActionFormat("take"), List.of(TestUtil.findItem(room1Items, "ball")), true);
         enhancedGameEngine.addAction(room1, instantiatedGameAction, enhancedGameDesignAction);
         InstantiatedGameAction instantiatedGameAction1 = new InstantiatedGameAction(new ActionFormat("push"), List.of(TestUtil.findItem(room1Items, "ball")), true);
         enhancedGameEngine.addAction(room1, instantiatedGameAction1, enhancedGameDesignAction);

         InstantiatedGameAction instantiatedGameAction2 = new InstantiatedGameAction(new ActionFormat("pull"), List.of(TestUtil.findItem(room1Items, "ball")), true);
         enhancedGameEngine.addAction(room1, instantiatedGameAction2, enhancedGameDesignAction);

         List<KnowledgeUpdate> moveRoomUpdate = List.of(new KnowledgeUpdate("world::room := \"Other Room\""));
         EnhancedGameDesignAction enhancedGameDesignActionMove =
             new EnhancedGameDesignAction(conditions, message, moveRoomUpdate);
         InstantiatedGameAction instantiatedGameAction3 = new InstantiatedGameAction(new ActionFormat("open"), List.of(TestUtil.findItem(room1Items, "ball")), true);
         enhancedGameEngine.addAction(room1, instantiatedGameAction3, enhancedGameDesignActionMove);
      }


      assertTrue(enhancedGameEngine.addParent("taking_room.box", "container"));
      assertTrue(enhancedGameEngine.addParent("taking_room.bucket", "container"));
      assertTrue(enhancedGameEngine.addParent("taking_room.pen", "takeable"));
      assertTrue(enhancedGameEngine.addParent("taking_room.ball", "takeable"));
      assertTrue(enhancedGameEngine.addParent("taking_room.apple", "takeable"));
      assertTrue(enhancedGameEngine.addParent("taking_room.bucket", "takeable"));
      assertTrue(enhancedGameEngine.addParent("taking_room.box", "takeable"));
      assertTrue(enhancedGameEngine.addParent("taking_room.banana", "edible"));
      assertTrue(enhancedGameEngine.addParent("taking_room.coke", "drinkable"));
      assertTrue(enhancedGameEngine.addParent("taking_room.bottle", "container"));

      assertTrue(enhancedGameEngine.addParent("other_room.mouse", "takeable"));
      assertTrue(enhancedGameEngine.addParent("other_room.keys", "takeable"));

      enhancedGameEngine.updateKnowledgeBaseMultiple(
          new KnowledgeUpdate("taking_room.bucket::internalVolume := 5"),
          new KnowledgeUpdate("taking_room.bucket::volume := 5"),
          new KnowledgeUpdate("taking_room.box::internalVolume := 10"),
          new KnowledgeUpdate("taking_room.box::volume := 10"),
          new KnowledgeUpdate("taking_room.pen::volume := 1"),
          new KnowledgeUpdate("taking_room.ball::volume := 10"),
          new KnowledgeUpdate("taking_room.apple::volume := 5"),
          new KnowledgeUpdate("taking_room.apple::mass := 10"),
          new KnowledgeUpdate("taking_room.pen::mass := 1"),
          new KnowledgeUpdate("taking_room.box::mass := 110"),
          new KnowledgeUpdate("taking_room.bucket::mass := 105"),
          new KnowledgeUpdate("taking_room.banana::taste := \"sweet\""),
          new KnowledgeUpdate("taking_room.coke::taste := \"refreshing\""),
          new KnowledgeUpdate("taking_room.bottle::contains += \"taking_room.coke\""),
          new KnowledgeUpdate("taking_room.bottle::internalVolume := 3.0"),
          new KnowledgeUpdate("taking_room.bottle::volume := 5.0"),
          new KnowledgeUpdate("taking_room.coke::isContained := TRUE"),
          new KnowledgeUpdate("taking_room.coke::volume := 2.0")
      );

      return enhancedGameEngine;
   }

   @Test
   public void possibleItemNamesWorks() throws KnowledgeException {
      EnhancedGameEngine enhancedGameEngine = oneRoomOneAction();
      Set<Item> items = enhancedGameEngine.possibleItems();
      Set<String> itemNames = items.stream().map(Item::getName).collect(Collectors.toSet());
      assertEquals(Set.of("apple", "banana", "orange"), itemNames);
   }

   @Test
   public void messageAfterProgressStory() throws KnowledgeException {
      EnhancedGameEngine enhancedGameEngine = oneRoomOneAction();
      ActionFormat actionFormat = enhancedGameEngine.findAction("feel").get(0);
      InstantiatedGameAction instantiatedGameAction = new InstantiatedGameAction(actionFormat, List.of(TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "apple")), true);
      Justification justification = enhancedGameEngine.progressStory(instantiatedGameAction);
      String message = justification.getReasoning();
      assertEquals("You did action 1 in enhanced.", message);
      assertTrue(justification.isAccepted());
   }

   @Test
   public void validateConditionAfterProgressStory() throws KnowledgeException, MissingKnowledgeException {
      EnhancedGameEngine enhancedGameEngine = oneRoomOneAction();
      ActionFormat actionFormat = enhancedGameEngine.findAction("feel").get(0);
      InstantiatedGameAction instantiatedGameAction = new InstantiatedGameAction(actionFormat, List.of(TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "apple")), true);
      enhancedGameEngine.progressStory(instantiatedGameAction);
      String postCondition = "world::randomState = \"very-good\" AND world::room=\"place1\"";
      boolean validPrecond = enhancedGameEngine.conditionSucceeds(postCondition);
      assertTrue(validPrecond);
   }

   @Test
   public void messagesProgressStoryTwoRoomsTwoActions() throws KnowledgeException {
      EnhancedGameEngine enhancedGameEngine = twoRoomTwoActions();
      ActionFormat openActionFormat = new ActionFormat("open");
      InstantiatedGameAction openGameAction = new InstantiatedGameAction(openActionFormat, List.of(TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "banana")), true);
      Justification justificationOpen = enhancedGameEngine.progressStory(openGameAction);
      String messageOpen = justificationOpen.getReasoning();

      ActionFormat eatActionFormat = enhancedGameEngine.findAction("feel").get(0);
      InstantiatedGameAction eatGameAction = new InstantiatedGameAction(eatActionFormat, List.of(TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "elephant")), true);

      Justification justificationEat = enhancedGameEngine.progressStory(eatGameAction);
      String messageEat = justificationEat.getReasoning();

      assertEquals(List.of("You did action 1.", "You did action 2 number 1."), List.of(messageOpen, messageEat));
      assertTrue(justificationOpen.isAccepted());
      assertTrue(justificationEat.isAccepted());
   }


   @Test
   public void notAllowedDesignedFailedEvenThoughImplemented() throws KnowledgeException, MissingKnowledgeException {
      EnhancedGameEngine enhancedGameEngine = twoRoomTwoActions();
      ActionFormat takeAF = new ActionFormat("take");
      InstantiatedGameAction openGameAction = new InstantiatedGameAction(takeAF, List.of(TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "banana")), true);
      Justification justTake = enhancedGameEngine.progressStory(openGameAction);
      String messageOpen = justTake.getReasoning();

      assertEquals(messageOpen, "You are not yet 3 equal to 4.0.");
      assertFalse(justTake.isAccepted());
      assertTrue(enhancedGameEngine.conditionSucceeds("world::inventory IS []"));
   }


   @Test
   public void numActionsProgressStoryTwoRoomsTwoActions() throws KnowledgeException, MissingKnowledgeException {
      EnhancedGameEngine enhancedGameEngine = twoRoomTwoActions();
      ActionFormat openActionFormat = enhancedGameEngine.findAction("open").get(0);
      InstantiatedGameAction openGameAction = new InstantiatedGameAction(openActionFormat, List.of(TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "banana")), true);
      enhancedGameEngine.progressStory(openGameAction);

      ActionFormat feelActionFormat = new ActionFormat("feel");
      InstantiatedGameAction feelGameAction = new InstantiatedGameAction(feelActionFormat, List.of(TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "elephant")), true);

      enhancedGameEngine.progressStory(feelGameAction);

      String postCondition = "world::numActions = 1";
      boolean validPrecond = enhancedGameEngine.conditionSucceeds(postCondition);
      assertTrue(validPrecond);
   }

   @Test
   public void errorMessageChangesAppropriately() throws KnowledgeException {
      EnhancedGameEngine enhancedGameEngine = twoRoomTwoActions();
      ActionFormat burnActionFormat = enhancedGameEngine.findAction("burn").get(0);
      InstantiatedGameAction burnGameAction = new InstantiatedGameAction(burnActionFormat, List.of(TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "banana")), true);
      Justification justificationOpen = enhancedGameEngine.progressStory(burnGameAction);

      assertEquals("You can't do that right now.", justificationOpen.getReasoning());


      ActionFormat openActionFormat = enhancedGameEngine.findAction("open").get(0);
      InstantiatedGameAction openGameAction = new InstantiatedGameAction(openActionFormat, List.of(TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "banana")), true);
      enhancedGameEngine.progressStory(openGameAction);

      ActionFormat climbActionFormat = new ActionFormat("climb");
      InstantiatedGameAction climbAction = new InstantiatedGameAction(climbActionFormat, List.of(TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "elephant")), true);

      Justification justificationClimb = enhancedGameEngine.progressStory(climbAction);

      assertEquals("You can't do that, dummy.", justificationClimb.getReasoning());

      ActionFormat feelActionFormat = new ActionFormat("feel");
      InstantiatedGameAction feelGameAction = new InstantiatedGameAction(feelActionFormat, List.of(TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "elephant")), true);

      enhancedGameEngine.progressStory(feelGameAction);


      Justification justificationClimb2 = enhancedGameEngine.progressStory(climbAction);

      assertEquals("You can't do that now.", justificationClimb2.getReasoning());
   }

   @Test
   public void randomListProgressStoryTwoRoomsTwoActions() throws KnowledgeException, MissingKnowledgeException {
      EnhancedGameEngine enhancedGameEngine = twoRoomTwoActions();
      ActionFormat openActionFormat = enhancedGameEngine.findAction("open").get(0);
      InstantiatedGameAction openGameAction = new InstantiatedGameAction(openActionFormat, List.of(TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "banana")), true);
      enhancedGameEngine.progressStory(openGameAction);

      ActionFormat eatActionFormat = new ActionFormat("feel");
      InstantiatedGameAction eatGameAction = new InstantiatedGameAction(eatActionFormat, List.of(TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "elephant")), true);

      enhancedGameEngine.progressStory(eatGameAction);

      String postCondition = "world::randomList IS [\"banana\"]";
      boolean validPrecond = enhancedGameEngine.conditionSucceeds(postCondition);
      assertTrue(validPrecond);
   }

   @Test
   public void numberListProgressStoryTwoRoomsTwoActions() throws KnowledgeException, MissingKnowledgeException {
      EnhancedGameEngine enhancedGameEngine = twoRoomTwoActions();
      ActionFormat openActionFormat = enhancedGameEngine.findAction("open").get(0);
      InstantiatedGameAction openGameAction = new InstantiatedGameAction(openActionFormat, List.of(TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "banana")), true);
      enhancedGameEngine.progressStory(openGameAction);

      ActionFormat eatActionFormat = new ActionFormat("feel");
      InstantiatedGameAction eatGameAction = new InstantiatedGameAction(eatActionFormat, List.of(TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "elephant")), true);

      enhancedGameEngine.progressStory(eatGameAction);

      String postCondition = "world::numberList IS [3.14, 1.0]";
      boolean validPrecond = enhancedGameEngine.conditionSucceeds(postCondition);
      assertTrue(validPrecond);
   }

   @Test
   public void puttingNoDesignMessage() throws KnowledgeException {
      EnhancedGameEngine enhancedGameEngine = puttingNoDesignRoom();
      ActionFormat puttingAf = enhancedGameEngine.findAction("put").get(0);
      InstantiatedGameAction openGameAction = new InstantiatedGameAction(puttingAf, List.of(TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "pen"), TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "box")), true);
      Justification justification = enhancedGameEngine.progressStory(openGameAction);
      String message = justification.getReasoning();
      assertEquals("You put the pen in the box. Nothing important happens.", message);
      assertTrue(justification.isAccepted());
   }

   @Test
   public void puttingNoDesignItemInContains() throws KnowledgeException, MissingKnowledgeException {
      EnhancedGameEngine enhancedGameEngine = puttingNoDesignRoom();
      ActionFormat puttingAf = enhancedGameEngine.findAction("put").get(0);
      InstantiatedGameAction openGameAction = new InstantiatedGameAction(puttingAf, List.of(TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "pen"), TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "box")), true);
      enhancedGameEngine.progressStory(openGameAction);

      String postCondition = "\"putting_room.pen\" IN putting_room.box::contains";
      boolean validPrecond = enhancedGameEngine.conditionSucceeds(postCondition);
      assertTrue(validPrecond);
   }

   @Test
   public void puttingNoDesignIsContained() throws KnowledgeException, MissingKnowledgeException {
      EnhancedGameEngine enhancedGameEngine = puttingNoDesignRoom();
      ActionFormat puttingAf = enhancedGameEngine.findAction("put").get(0);
      InstantiatedGameAction openGameAction = new InstantiatedGameAction(puttingAf, List.of(TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "pen"), TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "box")), true);
      enhancedGameEngine.progressStory(openGameAction);

      String postCondition = "putting_room.pen::isContained";
      boolean validPrecond = enhancedGameEngine.conditionSucceeds(postCondition);
      assertTrue(validPrecond);
   }

   @Test
   public void puttingNoDesignInternalVolume() throws KnowledgeException, MissingKnowledgeException {
      EnhancedGameEngine enhancedGameEngine = puttingNoDesignRoom();
      ActionFormat puttingAf = enhancedGameEngine.findAction("put").get(0);
      InstantiatedGameAction openGameAction = new InstantiatedGameAction(puttingAf, List.of(TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "pen"), TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "box")), true);
      enhancedGameEngine.progressStory(openGameAction);

      String postCondition = "putting_room.box::internalVolume = 9.0";
      boolean validPrecond = enhancedGameEngine.conditionSucceeds(postCondition);
      assertTrue(validPrecond);
   }

   @Test
   public void puttingContainedItemNoDesignMessage() throws KnowledgeException {
      EnhancedGameEngine enhancedGameEngine = puttingNoDesignRoom();
      ActionFormat puttingAf = enhancedGameEngine.findAction("put").get(0);
      InstantiatedGameAction openGameActionPen = new InstantiatedGameAction(puttingAf, List.of(TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "pen"), TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "box")), true);
      Justification justificationPen = enhancedGameEngine.progressStory(openGameActionPen);
      Justification justificationPen2 = enhancedGameEngine.progressStory(openGameActionPen);
      String messagePen = justificationPen.getReasoning();
      String messagePen2 = justificationPen2.getReasoning();
      assertEquals("You put the pen in the box. Nothing important happens.", messagePen);
      assertEquals("The pen is already inside of something.", messagePen2);
      assertTrue(justificationPen.isAccepted());
      assertFalse(justificationPen2.isAccepted());
   }

   @Test
   public void puttingSecondItemNoDesignMessage() throws KnowledgeException {
      EnhancedGameEngine enhancedGameEngine = puttingNoDesignRoom();
      ActionFormat puttingAf = enhancedGameEngine.findAction("put").get(0);
      ActionFormat puttingAf2 = enhancedGameEngine.findAction("put").get(0);
      InstantiatedGameAction openGameActionPen = new InstantiatedGameAction(puttingAf, List.of(TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "pen"), TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "box")), true);
      InstantiatedGameAction openGameActionApple = new InstantiatedGameAction(puttingAf2, List.of(TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "apple"), TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "box")), true);
      Justification justificationPen = enhancedGameEngine.progressStory(openGameActionPen);
      String messagePen = justificationPen.getReasoning();
      Justification justificationApple = enhancedGameEngine.progressStory(openGameActionApple);
      String messageApple = justificationApple.getReasoning();
      assertEquals("You put the pen in the box. Nothing important happens.", messagePen);
      assertEquals("You put the apple in the box. Nothing important happens.", messageApple);
      assertTrue(justificationPen.isAccepted());
      assertTrue(justificationApple.isAccepted());
   }

   @Test
   public void puttingSecondItemNoDesignInternalVolume() throws KnowledgeException, MissingKnowledgeException {
      EnhancedGameEngine enhancedGameEngine = puttingNoDesignRoom();
      ActionFormat puttingAf = enhancedGameEngine.findAction("put").get(0);
      ActionFormat puttingAf2 = enhancedGameEngine.findAction("put").get(0);
      InstantiatedGameAction openGameActionPen = new InstantiatedGameAction(puttingAf, List.of(TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "pen"), TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "box")), true);
      InstantiatedGameAction openGameActionApple = new InstantiatedGameAction(puttingAf2, List.of(TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "apple"), TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "box")), true);
      enhancedGameEngine.progressStory(openGameActionPen);
      enhancedGameEngine.progressStory(openGameActionApple);
      String postCondition = "putting_room.box::internalVolume = 4.0";
      boolean validPrecond = enhancedGameEngine.conditionSucceeds(postCondition);
      assertTrue(validPrecond);
   }

   @Test
   public void puttingSecondItemNoDesignContains() throws KnowledgeException, MissingKnowledgeException {
      EnhancedGameEngine enhancedGameEngine = puttingNoDesignRoom();
      ActionFormat puttingAf = enhancedGameEngine.findAction("put").get(0);
      ActionFormat puttingAf2 = enhancedGameEngine.findAction("put").get(0);
      InstantiatedGameAction openGameActionPen = new InstantiatedGameAction(puttingAf, List.of(TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "pen"), TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "box")), true);
      InstantiatedGameAction openGameActionApple = new InstantiatedGameAction(puttingAf2, List.of(TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "apple"), TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "box")), true);
      enhancedGameEngine.progressStory(openGameActionPen);
      enhancedGameEngine.progressStory(openGameActionApple);
      String postCondition = "\"putting_room.apple\" IN putting_room.box::contains AND \"putting_room.pen\" IN putting_room.box::contains";
      boolean validPrecond = enhancedGameEngine.conditionSucceeds(postCondition);
      assertTrue(validPrecond);
   }

   @Test
   public void puttingSecondItemNoDesignAppleIsContained() throws KnowledgeException, MissingKnowledgeException {
      EnhancedGameEngine enhancedGameEngine = puttingNoDesignRoom();
      ActionFormat puttingAf = enhancedGameEngine.findAction("put").get(0);
      ActionFormat puttingAf2 = enhancedGameEngine.findAction("put").get(0);
      InstantiatedGameAction openGameActionPen = new InstantiatedGameAction(puttingAf, List.of(TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "pen"), TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "box")), true);
      InstantiatedGameAction openGameActionApple = new InstantiatedGameAction(puttingAf2, List.of(TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "apple"), TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "box")), true);
      enhancedGameEngine.progressStory(openGameActionPen);
      enhancedGameEngine.progressStory(openGameActionApple);
      String postCondition = "putting_room.apple::isContained";
      boolean validPrecond = enhancedGameEngine.conditionSucceeds(postCondition);
      assertTrue(validPrecond);
   }

   @Test
   public void puttingThirdItemNoDesignTooBigMessage() throws KnowledgeException {
      EnhancedGameEngine enhancedGameEngine = puttingNoDesignRoom();
      ActionFormat puttingAf = enhancedGameEngine.findAction("put").get(0);
      InstantiatedGameAction openGameActionPen = new InstantiatedGameAction(puttingAf, List.of(TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "pen"), TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "box")), true);
      InstantiatedGameAction openGameActionApple = new InstantiatedGameAction(puttingAf, List.of(TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "apple"), TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "box")), true);
      InstantiatedGameAction openGameActionBall = new InstantiatedGameAction(puttingAf, List.of(TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "ball"), TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "box")), true);
      Justification justificationPen = enhancedGameEngine.progressStory(openGameActionPen);
      String messagePen = justificationPen.getReasoning();
      Justification justificationApple = enhancedGameEngine.progressStory(openGameActionApple);
      String messageApple = justificationApple.getReasoning();
      Justification justificationBall = enhancedGameEngine.progressStory(openGameActionBall);
      String messageBall = justificationBall.getReasoning();
      assertEquals("You put the pen in the box. Nothing important happens.", messagePen);
      assertEquals("You put the apple in the box. Nothing important happens.", messageApple);
      assertEquals("The box is not big enough to contain the ball.", messageBall);
      assertTrue(justificationPen.isAccepted());
      assertTrue(justificationApple.isAccepted());
      assertFalse(justificationBall.isAccepted());
   }

   @Test
   public void puttingThirdItemNoDesignTooBigIsContained() throws KnowledgeException, MissingKnowledgeException {
      EnhancedGameEngine enhancedGameEngine = puttingNoDesignRoom();
      ActionFormat puttingAf = enhancedGameEngine.findAction("put").get(0);
      InstantiatedGameAction putGameActionPen = new InstantiatedGameAction(puttingAf, List.of(TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "pen"), TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "box")), true);
      InstantiatedGameAction putGameActionApple = new InstantiatedGameAction(puttingAf, List.of(TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "apple"), TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "box")), true);
      InstantiatedGameAction putGameActionBall = new InstantiatedGameAction(puttingAf, List.of(TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "ball"), TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "box")), true);
      enhancedGameEngine.progressStory(putGameActionPen);
      enhancedGameEngine.progressStory(putGameActionApple);
      enhancedGameEngine.progressStory(putGameActionBall);
      String postCondition = "NOT putting_room.ball::isContained";
      boolean validPrecond = enhancedGameEngine.conditionSucceeds(postCondition);
      assertTrue(validPrecond);
   }

   @Test
   public void puttingThirdItemNoDesignTooBigInternalVolume() throws KnowledgeException, MissingKnowledgeException {
      EnhancedGameEngine enhancedGameEngine = puttingNoDesignRoom();
      ActionFormat puttingAf = enhancedGameEngine.findAction("put").get(0);
      InstantiatedGameAction openGameActionPen = new InstantiatedGameAction(puttingAf, List.of(TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "pen"), TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "box")), true);
      InstantiatedGameAction openGameActionApple = new InstantiatedGameAction(puttingAf, List.of(TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "apple"), TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "box")), true);
      InstantiatedGameAction openGameActionBall = new InstantiatedGameAction(puttingAf, List.of(TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "ball"), TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "box")), true);
      enhancedGameEngine.progressStory(openGameActionPen);
      enhancedGameEngine.progressStory(openGameActionApple);
      enhancedGameEngine.progressStory(openGameActionBall);
      String postCondition = "putting_room.box::internalVolume = 4.0";
      boolean validPrecond = enhancedGameEngine.conditionSucceeds(postCondition);
      assertTrue(validPrecond);
   }

   @Test
   public void puttingThirdItemNoDesignTooBigContains() throws KnowledgeException, MissingKnowledgeException {
      EnhancedGameEngine enhancedGameEngine = puttingNoDesignRoom();
      ActionFormat puttingAf = enhancedGameEngine.findAction("put").get(0);
      InstantiatedGameAction openGameActionPen = new InstantiatedGameAction(puttingAf, List.of(TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "pen"), TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "box")), true);
      InstantiatedGameAction openGameActionApple = new InstantiatedGameAction(puttingAf, List.of(TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "apple"), TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "box")), true);
      InstantiatedGameAction openGameActionBall = new InstantiatedGameAction(puttingAf, List.of(TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "ball"), TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "box")), true);
      enhancedGameEngine.progressStory(openGameActionPen);
      enhancedGameEngine.progressStory(openGameActionApple);
      enhancedGameEngine.progressStory(openGameActionBall);
      String postCondition = "[\"putting_room.pen\", \"putting_room.apple\"] IS putting_room.box::contains";
      boolean validPrecond = enhancedGameEngine.conditionSucceeds(postCondition);
      assertTrue(validPrecond);
   }


   @Test
   public void puttingRemovingNoDesignMessage() throws KnowledgeException {
      EnhancedGameEngine enhancedGameEngine = puttingNoDesignRoom();
      ActionFormat puttingAf = enhancedGameEngine.findAction("put").get(0);
      InstantiatedGameAction putGameAction = new InstantiatedGameAction(puttingAf, List.of(TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "pen"), TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "box")), true);
      ActionFormat removeAf = enhancedGameEngine.findAction("remove").get(0);
      InstantiatedGameAction removeGameAction = new InstantiatedGameAction(removeAf, List.of(TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "pen"), TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "box")), true);
      enhancedGameEngine.progressStory(putGameAction);
      Justification justification = enhancedGameEngine.progressStory(removeGameAction);
      String message = justification.getReasoning();
      assertEquals("You removed the pen from the box. Nothing important happens.", message);
      assertTrue(justification.isAccepted());
   }


   @Test
   public void puttingRemovingNoDesignCondition() throws KnowledgeException, MissingKnowledgeException {
      EnhancedGameEngine enhancedGameEngine = puttingNoDesignRoom();
      ActionFormat puttingAf = enhancedGameEngine.findAction("put").get(0);
      InstantiatedGameAction putGameAction = new InstantiatedGameAction(puttingAf, List.of(TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "pen"), TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "box")), true);
      ActionFormat removeAf = enhancedGameEngine.findAction("remove").get(0);
      InstantiatedGameAction removeGameAction = new InstantiatedGameAction(removeAf, List.of(TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "pen"), TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "box")), true);
      String putMessage = enhancedGameEngine.progressStory(putGameAction).getReasoning();
      String removeMessage = enhancedGameEngine.progressStory(removeGameAction).getReasoning();
      String postCondition = "putting_room.box::internalVolume = 10.0 AND putting_room.box::contains IS [] AND NOT putting_room.pen::isContained";
      boolean validPrecond = enhancedGameEngine.conditionSucceeds(postCondition);
      assertTrue(validPrecond);
   }

   @Test
   public void removingNoDesignMessage() throws KnowledgeException {
      EnhancedGameEngine enhancedGameEngine = puttingNoDesignRoom();
      ActionFormat removeAf = enhancedGameEngine.findAction("remove").get(0);
      InstantiatedGameAction removeGameAction = new InstantiatedGameAction(removeAf, List.of(TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "pen"),
          TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "box")), true);
      enhancedGameEngine.progressStory(removeGameAction);
      Justification justification = enhancedGameEngine.progressStory(removeGameAction);
      String message = justification.getReasoning();
      assertEquals("The pen is not inside of anything.", message);
      assertFalse(justification.isAccepted());
   }

   @Test
   public void takingTwice() throws KnowledgeException, MissingKnowledgeException {
      EnhancedGameEngine enhancedGameEngine = takingPushingPullingRoom();
      ActionFormat take = enhancedGameEngine.findAction("take").get(0);
      InstantiatedGameAction takeGameAction = new InstantiatedGameAction(take, List.of(TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "pen")), true);
      assert (enhancedGameEngine.conditionSucceeds("NOT \"taking_room.pen\" IN world::inventory"));
      enhancedGameEngine.progressStory(takeGameAction);
      assert (enhancedGameEngine.conditionSucceeds("\"taking_room.pen\" IN world::inventory"));

      Justification justification = enhancedGameEngine.progressStory(takeGameAction);
      String message = justification.getReasoning();
      assertEquals("The pen is already on your person.", message);
      assertFalse(justification.isAccepted());
   }

   @Test
   public void takingLightItem() throws KnowledgeException, MissingKnowledgeException {
      EnhancedGameEngine enhancedGameEngine = takingPushingPullingRoom();
      ActionFormat take = enhancedGameEngine.findAction("take").get(0);
      InstantiatedGameAction takeGameAction = new InstantiatedGameAction(take, List.of(TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "pen")), true);
      assert (enhancedGameEngine.conditionSucceeds("NOT \"taking_room.pen\" IN world::inventory"));

      Justification justification = enhancedGameEngine.progressStory(takeGameAction);
      String message = justification.getReasoning();
      assertEquals("You take the pen. Nothing important happens.", message);
      assertTrue(justification.isAccepted());
   }

   @Test
   public void takingDesignedItem() throws KnowledgeException {
      EnhancedGameEngine enhancedGameEngine = takingPushingPullingRoom();
      ActionFormat take = enhancedGameEngine.findAction("take").get(0);
      InstantiatedGameAction takeGameAction = new InstantiatedGameAction(take, List.of(TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "ball")), true);
      Justification justification = enhancedGameEngine.progressStory(takeGameAction);
      String message = justification.getReasoning();
      assertEquals("You take the ball. Well done. You did it.", message);
      assertTrue(justification.isAccepted());
   }

   @Test
   public void takingHeavyItem() throws KnowledgeException {
      EnhancedGameEngine enhancedGameEngine = takingPushingPullingRoom();
      ActionFormat take = enhancedGameEngine.findAction("take").get(0);
      InstantiatedGameAction takeGameAction = new InstantiatedGameAction(take, List.of(TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "box")), true);
      Justification justification = enhancedGameEngine.progressStory(takeGameAction);
      String message = justification.getReasoning();
      assertEquals("The box is too heavy for you to carry.", message);
      assertFalse(justification.isAccepted());
   }

   @Test
   public void takingMovingRoomsDropping() throws KnowledgeException, MissingKnowledgeException {
      EnhancedGameEngine enhancedGameEngine = takingPushingPullingRoom();
      ActionFormat take = enhancedGameEngine.findAction("take").get(0);
      Item ball = TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "ball");
      InstantiatedGameAction takeGameAction = new InstantiatedGameAction(take, List.of(ball), true);
      Justification justification = enhancedGameEngine.progressStory(takeGameAction);
      String message = justification.getReasoning();
      assertEquals("You take the ball. Well done. You did it.", message);
      assertFalse(enhancedGameEngine.findRoom("Taking Room").get(0).getItems().containsKey(ball.getID()));
      assertTrue(justification.isAccepted());

      ActionFormat open = enhancedGameEngine.findAction("open").get(0);
      InstantiatedGameAction moveRoomAction = new InstantiatedGameAction(open, List.of(TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "ball")), true);
      Justification justification2 = enhancedGameEngine.progressStory(moveRoomAction);
      String message2 = justification2.getReasoning();
      assertTrue(justification2.isAccepted());

      assertEquals("Well done. You did it.", message2);
      ActionFormat drop = enhancedGameEngine.findAction("drop").get(0);
      ball = TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "ball");
      InstantiatedGameAction dropAction = new InstantiatedGameAction(drop, List.of(ball), true);
      Justification justification3 = enhancedGameEngine.progressStory(dropAction);
      String message3 = justification3.getReasoning();
      assertTrue(justification3.isAccepted());

      assertEquals("You drop the ball next to you. Nothing important happens.", message3);
      assertFalse(enhancedGameEngine.findRoom("Taking Room").get(0).getItems().containsValue(ball));
      assertTrue(enhancedGameEngine.findRoom("Other Room").get(0).getItems().containsValue(ball));
      assertTrue(enhancedGameEngine.conditionSucceeds("NOT \"taking_room.ball\" IN world::inventory"));
   }

   @Test
   public void droppingItemThatYouDontHaveFails() throws KnowledgeException {
      EnhancedGameEngine enhancedGameEngine = takingPushingPullingRoom();
      ActionFormat drop = enhancedGameEngine.findAction("drop").get(0);
      InstantiatedGameAction dropAction = new InstantiatedGameAction(drop, List.of(TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "pen")), true);
      Justification justification = enhancedGameEngine.progressStory(dropAction);
      String message = justification.getReasoning();
      assertEquals("You can't drop the pen because you haven't picked it up.", message);
   }


   @Test
   public void pushingLightItem() throws KnowledgeException {
      EnhancedGameEngine enhancedGameEngine = takingPushingPullingRoom();
      ActionFormat push = enhancedGameEngine.findAction("push").get(0);
      InstantiatedGameAction pushGameAction = new InstantiatedGameAction(push, List.of(TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "pen")), true);
      enhancedGameEngine.progressStory(pushGameAction);
      Justification justification = enhancedGameEngine.progressStory(pushGameAction);
      String message = justification.getReasoning();
      assertEquals("You push the pen slightly but nothing interesting happens so you put it back.", message);
      assertTrue(justification.isAccepted());
   }

   @Test
   public void pushingHeavyItem() throws KnowledgeException {
      EnhancedGameEngine enhancedGameEngine = takingPushingPullingRoom();
      ActionFormat push = enhancedGameEngine.findAction("push").get(0);
      InstantiatedGameAction pushGameAction = new InstantiatedGameAction(push, List.of(TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "box")), true);
      enhancedGameEngine.progressStory(pushGameAction);
      Justification justification = enhancedGameEngine.progressStory(pushGameAction);
      String message = justification.getReasoning();
      assertEquals("The box is too heavy for you to push.", message);
      assertFalse(justification.isAccepted());
   }

   @Test
   public void pushingDesignedItem() throws KnowledgeException {
      EnhancedGameEngine enhancedGameEngine = takingPushingPullingRoom();
      ActionFormat push = enhancedGameEngine.findAction("push").get(0);
      InstantiatedGameAction pushGameAction = new InstantiatedGameAction(push, List.of(TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "ball")), true);
      enhancedGameEngine.progressStory(pushGameAction);
      Justification justification = enhancedGameEngine.progressStory(pushGameAction);
      String message = justification.getReasoning();
      assertEquals("You push the ball. Well done. You did it.", message);
      assertTrue(justification.isAccepted());
   }


   @Test
   public void pullLightItem() throws KnowledgeException {
      EnhancedGameEngine enhancedGameEngine = takingPushingPullingRoom();
      ActionFormat pull = enhancedGameEngine.findAction("pull").get(0);
      InstantiatedGameAction pullGameAction = new InstantiatedGameAction(pull, List.of(TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "pen")), true);
      enhancedGameEngine.progressStory(pullGameAction);
      Justification justification = enhancedGameEngine.progressStory(pullGameAction);
      String message = justification.getReasoning();
      assertEquals("You pull the pen slightly but nothing interesting happens so you put it back.", message);
      assertTrue(justification.isAccepted());
   }

   @Test
   public void pullHeavyItem() throws KnowledgeException {
      EnhancedGameEngine enhancedGameEngine = takingPushingPullingRoom();
      ActionFormat pull = enhancedGameEngine.findAction("pull").get(0);
      InstantiatedGameAction pullGameAction = new InstantiatedGameAction(pull, List.of(TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "box")), true);
      Justification justification = enhancedGameEngine.progressStory(pullGameAction);
      String message = justification.getReasoning();
      assertEquals("The box is too heavy for you to pull.", message);
      assertFalse(justification.isAccepted());
   }


   @Test
   public void pullDesignedItem() throws KnowledgeException {
      EnhancedGameEngine enhancedGameEngine = takingPushingPullingRoom();
      ActionFormat pull = enhancedGameEngine.findAction("pull").get(0);
      InstantiatedGameAction pullGameAction = new InstantiatedGameAction(pull, List.of(TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "ball")), true);
      Justification justification = enhancedGameEngine.progressStory(pullGameAction);
      String message = justification.getReasoning();
      assertEquals("You pull the ball. Well done. You did it.", message);
      assertTrue(justification.isAccepted());
   }


   @Test
   public void putInHeavyItem() throws KnowledgeException {
      EnhancedGameEngine enhancedGameEngine = takingPushingPullingRoom();
      ActionFormat putIn = enhancedGameEngine.findAction("put").get(0);
      InstantiatedGameAction putInGameAction = new InstantiatedGameAction(putIn, List.of(TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "bucket"), TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "box")), true);
      Justification justification = enhancedGameEngine.progressStory(putInGameAction);
      String message = justification.getReasoning();
      assertEquals("The bucket is too heavy for you to put in the box.", message);
      assertFalse(justification.isAccepted());
   }

   @Test
   public void putOnHeavyItem() throws KnowledgeException {
      EnhancedGameEngine enhancedGameEngine = takingPushingPullingRoom();
      ActionFormat putOn = enhancedGameEngine.findAction("put").get(1);
      InstantiatedGameAction putOnGameAction = new InstantiatedGameAction(putOn, List.of(TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "bucket"),
          TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "box")), true);
      Justification justification = enhancedGameEngine.progressStory(putOnGameAction);
      String message = justification.getReasoning();
      assertEquals("The bucket is too heavy for you to put on the box.", message);
      assertFalse(justification.isAccepted());
   }

   @Test
   public void turnItem() throws KnowledgeException {
      EnhancedGameEngine enhancedGameEngine = takingPushingPullingRoom();
      ActionFormat turn = enhancedGameEngine.findAction("turn").get(0);
      InstantiatedGameAction putOnGameAction = new InstantiatedGameAction(turn, List.of(TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "box")), true);
      Justification justification = enhancedGameEngine.progressStory(putOnGameAction);
      String message = justification.getReasoning();
      assertEquals("You turn on the box. Nothing important happens.", message);
      assertTrue(justification.isAccepted());
   }

   @Test
   public void cantTurnOnContainedItem() throws KnowledgeException {
      EnhancedGameEngine enhancedGameEngine = takingPushingPullingRoom();
      ActionFormat turn = enhancedGameEngine.findAction("turn").get(0);
      ActionFormat putIn = enhancedGameEngine.findAction("put").get(0);
      Item ball = TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "ball");
      InstantiatedGameAction putInGameAction = new InstantiatedGameAction(putIn, List.of(ball,
          TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "box")), true);
      InstantiatedGameAction turnGameAction = new InstantiatedGameAction(turn, List.of(ball), true);
      enhancedGameEngine.progressStory(putInGameAction);
      Justification justification2 = enhancedGameEngine.progressStory(turnGameAction);
      String message = justification2.getReasoning();
      assertEquals("You can't turn on the ball because it is inside of something else.", message);
      assertFalse(justification2.isAccepted());
   }

   @Test
   public void examineItem() throws KnowledgeException {
      EnhancedGameEngine enhancedGameEngine = takingPushingPullingRoom();
      ActionFormat examineAction = enhancedGameEngine.findAction("examine").get(0);
      InstantiatedGameAction examineGameAction = new InstantiatedGameAction(examineAction, List.of(TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "box")), true);
      Justification justification = enhancedGameEngine.progressStory(examineGameAction);
      String message = justification.getReasoning();
      assertEquals("You examine the box but find nothing of interest.", message);
      assertTrue(justification.isAccepted());
   }

   @Test
   public void cantExamineContainedItem() throws KnowledgeException {
      EnhancedGameEngine enhancedGameEngine = takingPushingPullingRoom();
      ActionFormat examine = enhancedGameEngine.findAction("examine").get(0);
      ActionFormat putIn = enhancedGameEngine.findAction("put").get(0);
      Item ball = TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "ball");
      InstantiatedGameAction putInGameAction = new InstantiatedGameAction(putIn, List.of(ball, TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "box")), true);
      InstantiatedGameAction turnGameAction = new InstantiatedGameAction(examine, List.of(ball), true);
      Justification justification1 = enhancedGameEngine.progressStory(putInGameAction);
      Justification justification2 = enhancedGameEngine.progressStory(turnGameAction);
      String message = justification2.getReasoning();
      assertEquals("You can't examine the ball because it is inside of something else.", message);
      assertFalse(justification2.isAccepted());
   }

   @Test
   public void searchItem() throws KnowledgeException {
      EnhancedGameEngine enhancedGameEngine = takingPushingPullingRoom();
      ActionFormat searchAction = enhancedGameEngine.findAction("search").get(0);
      InstantiatedGameAction searchGameAction = new InstantiatedGameAction(searchAction, List.of(TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "box")), true);
      Justification justification = enhancedGameEngine.progressStory(searchGameAction);
      String message = justification.getReasoning();
      assertEquals("You search the box but find nothing of interest.", message);
      assertTrue(justification.isAccepted());
   }

   @Test
   public void cantSearchContainedItem() throws KnowledgeException {
      EnhancedGameEngine enhancedGameEngine = takingPushingPullingRoom();
      ActionFormat search = enhancedGameEngine.findAction("search").get(0);
      ActionFormat putIn = enhancedGameEngine.findAction("put").get(0);
      Item ball = TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "ball");
      InstantiatedGameAction putInGameAction = new InstantiatedGameAction(putIn, List.of(ball, TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "box")), true);
      InstantiatedGameAction turnGameAction = new InstantiatedGameAction(search, List.of(ball), true);
      Justification justification1 = enhancedGameEngine.progressStory(putInGameAction);
      Justification justification2 = enhancedGameEngine.progressStory(turnGameAction);
      String message = justification2.getReasoning();
      assertEquals("You can't search the ball because it is inside of something else.", message);
      assertFalse(justification2.isAccepted());
   }

   @Test
   public void listenToItem() throws KnowledgeException {
      EnhancedGameEngine enhancedGameEngine = takingPushingPullingRoom();
      ActionFormat listen = enhancedGameEngine.findAction("listen").get(0);
      InstantiatedGameAction listenGameAction = new InstantiatedGameAction(listen, List.of(TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "box")), true);
      Justification justification = enhancedGameEngine.progressStory(listenGameAction);
      String message = justification.getReasoning();
      assertEquals("You listen to the box but hear nothing of interest.", message);
      assertTrue(justification.isAccepted());
   }

   // TODO: Test EAT, DRINK, TRANSFER

   @Test
   public void transferCokeToBucket() throws KnowledgeException {
      EnhancedGameEngine enhancedGameEngine = takingPushingPullingRoom();
      ActionFormat transfer = enhancedGameEngine.findAction("transfer").get(0);
      InstantiatedGameAction transferGameAction = new InstantiatedGameAction(transfer, List.of(TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "coke"),
          TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "bottle"),
          TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "bucket")), true);
      Justification justification = enhancedGameEngine.progressStory(transferGameAction);
      String message = justification.getReasoning();
      assertEquals("You transfer the coke from the bottle to the bucket. Nothing important happens.", message);
      assertTrue(justification.isAccepted());
   }

   //"box", "banana", "bottle", "coke", "bucket", "pen", "apple", "ball" - "TAKING ROOM"
   @Test
   public void transferCokeToBucketPostCondBottle() throws KnowledgeException, MissingKnowledgeException {
      EnhancedGameEngine enhancedGameEngine = takingPushingPullingRoom();
      ActionFormat transfer = enhancedGameEngine.findAction("transfer").get(0);
      InstantiatedGameAction transferGameAction = new InstantiatedGameAction(transfer, List.of(TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "coke"),
          TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "bottle"),
          TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "bucket")), true);
      Justification justification = enhancedGameEngine.progressStory(transferGameAction);
      String message = justification.getReasoning();
      assertEquals("You transfer the coke from the bottle to the bucket. Nothing important happens.", message);
      assertTrue(justification.isAccepted());
      String postConditionBottleVolume = "taking_room.bottle::internalVolume = 5.0";
      String postConditionBottleContains = " taking_room.bottle::contains IS []";
      boolean validPrecondBottleVolume = enhancedGameEngine.conditionSucceeds(postConditionBottleVolume);
      boolean validPrecondBottleContains = enhancedGameEngine.conditionSucceeds(postConditionBottleContains);
      assertTrue(validPrecondBottleVolume);
      assertTrue(validPrecondBottleContains);
   }

   @Test
   public void transferCokeToBucketPostCondBucket() throws KnowledgeException, MissingKnowledgeException {
      EnhancedGameEngine enhancedGameEngine = takingPushingPullingRoom();
      ActionFormat transfer = enhancedGameEngine.findAction("transfer").get(0);
      InstantiatedGameAction transferGameAction = new InstantiatedGameAction(transfer, List.of(TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "coke"),
          TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "bottle"), TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "bucket")), true);
      ;
      Justification justification = enhancedGameEngine.progressStory(transferGameAction);
      String message = justification.getReasoning();
      assertEquals("You transfer the coke from the bottle to the bucket. Nothing important happens.", message);
      assertTrue(justification.isAccepted());
      String postConditionBucketVolume = "taking_room.bucket::internalVolume = 3.0 ";
      String postConditionBucketContains = "taking_room.bucket::contains IS [\"taking_room.coke\"] AND taking_room.coke::isContained";
      boolean validPrecondBucketVolume = enhancedGameEngine.conditionSucceeds(postConditionBucketVolume);
      boolean validPrecondBucketContains = enhancedGameEngine.conditionSucceeds(postConditionBucketContains);
      assertTrue(validPrecondBucketVolume);
      assertTrue(validPrecondBucketContains);
   }


   @Test
   public void eatBanana() throws KnowledgeException {
      EnhancedGameEngine enhancedGameEngine = takingPushingPullingRoom();
      ActionFormat eat = enhancedGameEngine.findAction("eat").get(0);
      Item banana = TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "banana");
      InstantiatedGameAction eatGameAction = new InstantiatedGameAction(eat, List.of(banana), true);
      Justification justification = enhancedGameEngine.progressStory(eatGameAction);
      String message = justification.getReasoning();
      assertEquals("You eat the banana. It tastes sweet. Nothing important happens.", message);
      assertTrue(justification.isAccepted());
      assertFalse(enhancedGameEngine.findRoom("Taking Room").get(0).getItems().containsValue(banana));
   }

   @Test
   public void eatCokeFails() throws KnowledgeException {
      EnhancedGameEngine enhancedGameEngine = takingPushingPullingRoom();
      ActionFormat eat = enhancedGameEngine.findAction("eat").get(0);
      InstantiatedGameAction eatGameAction = new InstantiatedGameAction(eat, List.of(TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "coke")), true);
      Justification justification = enhancedGameEngine.progressStory(eatGameAction);
      String message = justification.getReasoning();
      assertEquals("You can't do that because the coke is not edible.", message);
      assertFalse(justification.isAccepted());
   }


   @Test
   public void drinkCoke() throws KnowledgeException {
      EnhancedGameEngine enhancedGameEngine = takingPushingPullingRoom();
      ActionFormat drink = enhancedGameEngine.findAction("drink").get(0);
      Item coke = TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "coke");
      InstantiatedGameAction drinkGameAction = new InstantiatedGameAction(drink, List.of(coke, TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "bottle")), true);
      Justification justification = enhancedGameEngine.progressStory(drinkGameAction);
      String message = justification.getReasoning();
      assertEquals("You drink the coke. It tastes refreshing. Nothing important happens.", message);
      assertTrue(justification.isAccepted());
      assertFalse(enhancedGameEngine.getCurrentRoom().getItems().containsValue(coke));
   }

   @Test
   public void transferCokeAfterDrinkFails() throws KnowledgeException {
      EnhancedGameEngine enhancedGameEngine = takingPushingPullingRoom();
      ActionFormat drink = enhancedGameEngine.findAction("drink").get(0);
      Item coke = TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "coke");

      InstantiatedGameAction drinkGameAction = new InstantiatedGameAction(drink, List.of(coke, TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "bottle")), true);
      enhancedGameEngine.progressStory(drinkGameAction);
      ActionFormat transfer = enhancedGameEngine.findAction("transfer").get(0);
      InstantiatedGameAction transferGameAction = new InstantiatedGameAction(transfer, List.of(coke,
          TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "bottle"), TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "bucket")), true);
      Justification justification = enhancedGameEngine.progressStory(transferGameAction);
      String message = justification.getReasoning();
      assertEquals("There is no coke in your environment.", message);
      assertFalse(justification.isAccepted());
   }

   @Test
   public void transferCokeBeforeDrinkDrinkingFails() throws KnowledgeException {
      EnhancedGameEngine enhancedGameEngine = takingPushingPullingRoom();
      ActionFormat transfer = enhancedGameEngine.findAction("transfer").get(0);
      InstantiatedGameAction transferGameAction = new InstantiatedGameAction(transfer, List.of(TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "coke"), TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "bottle"), TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "bucket")), true);
      enhancedGameEngine.progressStory(transferGameAction);
      ActionFormat drink = enhancedGameEngine.findAction("drink").get(0);
      InstantiatedGameAction drinkGameAction = new InstantiatedGameAction(drink, List.of(TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "coke"), TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "bottle")), true);
      Justification justification = enhancedGameEngine.progressStory(drinkGameAction);
      String message = justification.getReasoning();
      assertEquals("You can't do that because the coke is not in the bottle.", message);
      assertFalse(justification.isAccepted());
   }


   @Test
   public void drinkBananaFails() throws KnowledgeException {
      EnhancedGameEngine enhancedGameEngine = takingPushingPullingRoom();
      ActionFormat drink = enhancedGameEngine.findAction("drink").get(0);
      InstantiatedGameAction drinkGameAction = new InstantiatedGameAction(drink, List.of(TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "banana"), TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "bottle")), true);
      Justification justification = enhancedGameEngine.progressStory(drinkGameAction);
      String message = justification.getReasoning();
      assertEquals("You can't do that because the banana is not in the bottle.", message);
      assertFalse(justification.isAccepted());
   }

   @Test
   public void drinkPenInContainerFails() throws KnowledgeException {
      EnhancedGameEngine enhancedGameEngine = takingPushingPullingRoom();
      ActionFormat putIn = enhancedGameEngine.findAction("put").get(0);
      InstantiatedGameAction putInGameAction = new InstantiatedGameAction(putIn, List.of(TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "pen"),
          TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "box")), true);
      enhancedGameEngine.progressStory(putInGameAction);
      ActionFormat drink = enhancedGameEngine.findAction("drink").get(0);
      InstantiatedGameAction drinkGameAction = new InstantiatedGameAction(drink, List.of(TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "pen"),
          TestUtil.findPossibleItemFromNoun(enhancedGameEngine, "box")), true);
      Justification justification = enhancedGameEngine.progressStory(drinkGameAction);

      String message = justification.getReasoning();
      assertEquals("You can't drink the pen because it's not liquid.", message);
      assertFalse(justification.isAccepted());
   }
   // TODO: Test putting items in each other and moving them around

}