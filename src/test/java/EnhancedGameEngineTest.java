import static org.junit.Assert.*;


import com.enhanced.EnhancedGameDesignAction;
import com.enhanced.reasoning.Condition;
import com.enhanced.reasoning.Justification;
import com.enhanced.reasoning.KnowledgeUpdate;
import com.enhanced.reasoning.exceptions.KnowledgeException;
import com.enhanced.reasoning.exceptions.MissingKnowledgeException;
import com.shared.ActionFormat;
import com.shared.InstantiatedGameAction;
import com.shared.Item;
import com.shared.Room;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.Test;

public class EnhancedGameEngineTest {
   private static EnhancedGameEngine oneRoomOneAction() throws KnowledgeException {
      Room room = new Room("place1");
      room.setItemsNoAdjectives(Set.of("apple", "banana", "orange"));

      EnhancedGameEngine enhancedGameEngine = new EnhancedGameEngine();
      enhancedGameEngine.addRoom(room);
      enhancedGameEngine.setCurrentRoom(room);


      ActionFormat actionFormat = new ActionFormat("eat");
      // Create key for action
      InstantiatedGameAction instantiatedGameAction = new InstantiatedGameAction(actionFormat, List.of("apple"));
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
      room.setItemsNoAdjectives(Set.of("apple", "banana", "orange"));
      Room room2 = new Room("room2");
      room2.setItemsNoAdjectives(Set.of("elephant"));

      EnhancedGameEngine enhancedGameEngine = new EnhancedGameEngine();
      enhancedGameEngine.addRoom(room);
      enhancedGameEngine.addRoom(room2);
      enhancedGameEngine.setCurrentRoom(room);
      // Create key for action
      InstantiatedGameAction instantiatedGameAction1 = new InstantiatedGameAction(new ActionFormat("open"), List.of("banana"));
      // Create value for action
      List<Condition> conditions1 = new ArrayList<>();
      conditions1.add(new Condition("world::room = \"place1\"", "You are not in place1 yet, you are in world::room"));
      List<KnowledgeUpdate> knowledgeUpdates1 = new ArrayList<>();

      InstantiatedGameAction instantiatedGameAction2 = new InstantiatedGameAction(new ActionFormat("eat"), List.of("elephant"));
      List<Condition> conditions2 = new ArrayList<>();
      List<KnowledgeUpdate> knowledgeUpdates2 = new ArrayList<>();
      // Create key for action
      knowledgeUpdates1.add(new KnowledgeUpdate("world::room := \"room2\""));
      knowledgeUpdates1.add(new KnowledgeUpdate("world::state := \"random\""));
      knowledgeUpdates1.add(new KnowledgeUpdate("world::numActions := 0"));
      knowledgeUpdates1.add(new KnowledgeUpdate("world::randomList := []"));
      knowledgeUpdates1.add(new KnowledgeUpdate("world::numberList := [3.14, 3.142]"));

      // Create value for action
      conditions2.add(new Condition("world::room = \"room2\"", "100% you are not in room2 yet, you are in world::room"));
      knowledgeUpdates2.add(new KnowledgeUpdate("world::numActions += 1"));
      knowledgeUpdates2.add(new KnowledgeUpdate("world::randomList += \"banana\""));
      knowledgeUpdates2.add(new KnowledgeUpdate("world::numberList += world::numActions"));
      knowledgeUpdates2.add(new KnowledgeUpdate("world::numberList -= 3.142"));

      EnhancedGameDesignAction enhancedGameDesignAction1 =
          new EnhancedGameDesignAction(conditions1, "You did action 1.", knowledgeUpdates1);
      EnhancedGameDesignAction enhancedGameDesignAction2 =
          new EnhancedGameDesignAction(conditions2, "You did action 2 number world::numActions.", knowledgeUpdates2);

      enhancedGameEngine.addAction(room, instantiatedGameAction1, enhancedGameDesignAction1);
      enhancedGameEngine.addAction(room2, instantiatedGameAction2, enhancedGameDesignAction2);
      return enhancedGameEngine;

   }


   private static EnhancedGameEngine puttingNoDesignRoom() throws KnowledgeException {
      Room room = new Room("Putting Room");
      room.setItemsNoAdjectives(Set.of("box", "pen", "apple", "ball"));

      EnhancedGameEngine enhancedGameEngine = new EnhancedGameEngine();
      enhancedGameEngine.addRoom(room);
      enhancedGameEngine.setCurrentRoom(room);
      // TODO: Look at making defaults for this
      enhancedGameEngine.addParent("box", "container");
      enhancedGameEngine.updateKnowledgeBase(
          new KnowledgeUpdate("box::internalVolume := 10"),
          new KnowledgeUpdate("box::volume := 10"),
          new KnowledgeUpdate("pen::volume := 1"),
          new KnowledgeUpdate("ball::volume := 10"),
          new KnowledgeUpdate("apple::volume := 5")
      );

      return enhancedGameEngine;
   }


   private EnhancedGameEngine takingPushingPullingRoom() throws KnowledgeException {
      EnhancedGameEngine enhancedGameEngine = new EnhancedGameEngine();

      Room room1 = new Room("Taking Room");
      room1.setItemsNoAdjectives(Set.of("box", "banana", "bucket", "pen", "apple", "ball"));

      enhancedGameEngine.addRoom(room1);
      enhancedGameEngine.setCurrentRoom(room1);

      Room room2 = new Room("Other Room");
      room2.setItemsNoAdjectives(Set.of("mouse", "keys", "water"));
      enhancedGameEngine.addRoom(room2);

      {
         List<Condition> conditions = List.of(new Condition("TRUE", ""));
         String message = " Well done. You did it.";
         List<KnowledgeUpdate> knowledgeUpdates = List.of(new KnowledgeUpdate("world::random := TRUE"));

         EnhancedGameDesignAction enhancedGameDesignAction =
             new EnhancedGameDesignAction(conditions, message, knowledgeUpdates);
         InstantiatedGameAction instantiatedGameAction = new InstantiatedGameAction(new ActionFormat("take"), List.of("ball"));
         enhancedGameEngine.addAction(room1, instantiatedGameAction, enhancedGameDesignAction);
         InstantiatedGameAction instantiatedGameAction1 = new InstantiatedGameAction(new ActionFormat("push"), List.of("ball"));
         enhancedGameEngine.addAction(room1, instantiatedGameAction1, enhancedGameDesignAction);

         InstantiatedGameAction instantiatedGameAction2 = new InstantiatedGameAction(new ActionFormat("pull"), List.of("ball"));
         enhancedGameEngine.addAction(room1, instantiatedGameAction2, enhancedGameDesignAction);

         List<KnowledgeUpdate> moveRoomUpdate = List.of(new KnowledgeUpdate("world::room := \"Other Room\""));
         EnhancedGameDesignAction enhancedGameDesignActionMove =
             new EnhancedGameDesignAction(conditions, message, moveRoomUpdate);
         InstantiatedGameAction instantiatedGameAction3 = new InstantiatedGameAction(new ActionFormat("open"), List.of("ball"));
         enhancedGameEngine.addAction(room1, instantiatedGameAction3, enhancedGameDesignActionMove);
      }


      boolean worked = enhancedGameEngine.addParent("box", "container");
      boolean worked1 = enhancedGameEngine.addParent("bucket", "container");
      boolean worked2 = enhancedGameEngine.addParent("pen", "takeable");
      boolean worked3 = enhancedGameEngine.addParent("ball", "takeable");
      boolean worked4 = enhancedGameEngine.addParent("apple", "takeable");
      boolean worked5 = enhancedGameEngine.addParent("box", "takeable");
      boolean worked6 = enhancedGameEngine.addParent("mouse", "takeable");
      boolean worked7 = enhancedGameEngine.addParent("keys", "takeable");
      boolean worked8 = enhancedGameEngine.addParent("banana", "edible");
      assert (worked && worked1 && worked2 && worked3 && worked4 && worked5 && worked6 && worked7);

      enhancedGameEngine.updateKnowledgeBase(
          new KnowledgeUpdate("bucket::internalVolume := 5"),
          new KnowledgeUpdate("bucket::volume := 5"),
          new KnowledgeUpdate("box::internalVolume := 10"),
          new KnowledgeUpdate("box::volume := 10"),
          new KnowledgeUpdate("pen::volume := 1"),
          new KnowledgeUpdate("ball::volume := 10"),
          new KnowledgeUpdate("apple::volume := 5"),
          new KnowledgeUpdate("apple::mass := 10"),
          new KnowledgeUpdate("pen::mass := 1"),
          new KnowledgeUpdate("box::mass := 110"),
          new KnowledgeUpdate("bucket::mass := 105")
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
      ActionFormat actionFormat = enhancedGameEngine.findAction("eat").get(0);
      InstantiatedGameAction instantiatedGameAction = new InstantiatedGameAction(actionFormat, List.of("apple"));
      Justification justification = enhancedGameEngine.progressStory(instantiatedGameAction);
      String message = justification.getReasoning();
      assertEquals("You did action 1 in enhanced.", message);
      assertTrue(justification.isAccepted());
   }

   @Test
   public void validateConditionAfterProgressStory() throws KnowledgeException, MissingKnowledgeException {
      EnhancedGameEngine enhancedGameEngine = oneRoomOneAction();
      ActionFormat actionFormat = enhancedGameEngine.findAction("eat").get(0);
      InstantiatedGameAction instantiatedGameAction = new InstantiatedGameAction(actionFormat, List.of("apple"));
      enhancedGameEngine.progressStory(instantiatedGameAction);
      String postCondition = "world::randomState = \"very-good\" AND world::room=\"place1\"";
      boolean validPrecond = enhancedGameEngine.conditionSucceeds(postCondition);
      assertTrue(validPrecond);
   }

   @Test
   public void messagesProgressStoryTwoRoomsTwoActions() throws KnowledgeException {
      EnhancedGameEngine enhancedGameEngine = twoRoomTwoActions();
      ActionFormat openActionFormat = new ActionFormat("open");
      InstantiatedGameAction openGameAction = new InstantiatedGameAction(openActionFormat, List.of("banana"));
      Justification justificationOpen = enhancedGameEngine.progressStory(openGameAction);
      String messageOpen = justificationOpen.getReasoning();

      ActionFormat eatActionFormat = enhancedGameEngine.findAction("eat").get(0);
      InstantiatedGameAction eatGameAction = new InstantiatedGameAction(eatActionFormat, List.of("elephant"));

      Justification justificationEat = enhancedGameEngine.progressStory(eatGameAction);
      String messageEat = justificationEat.getReasoning();

      assertEquals(List.of("You did action 1.", "You did action 2 number 1."), List.of(messageOpen, messageEat));
      assertTrue(justificationOpen.isAccepted());
      assertTrue(justificationEat.isAccepted());
   }

   @Test
   public void numActionsProgressStoryTwoRoomsTwoActions() throws KnowledgeException, MissingKnowledgeException {
      EnhancedGameEngine enhancedGameEngine = twoRoomTwoActions();
      ActionFormat openActionFormat = enhancedGameEngine.findAction("open").get(0);
      InstantiatedGameAction openGameAction = new InstantiatedGameAction(openActionFormat, List.of("banana"));
      enhancedGameEngine.progressStory(openGameAction);

      ActionFormat eatActionFormat = new ActionFormat("eat");
      InstantiatedGameAction eatGameAction = new InstantiatedGameAction(eatActionFormat, List.of("elephant"));

      enhancedGameEngine.progressStory(eatGameAction);

      String postCondition = "world::numActions = 1";
      boolean validPrecond = enhancedGameEngine.conditionSucceeds(postCondition);
      assertTrue(validPrecond);
   }

   @Test
   public void randomListProgressStoryTwoRoomsTwoActions() throws KnowledgeException, MissingKnowledgeException {
      EnhancedGameEngine enhancedGameEngine = twoRoomTwoActions();
      ActionFormat openActionFormat = enhancedGameEngine.findAction("open").get(0);
      InstantiatedGameAction openGameAction = new InstantiatedGameAction(openActionFormat, List.of("banana"));
      enhancedGameEngine.progressStory(openGameAction);

      ActionFormat eatActionFormat = new ActionFormat("eat");
      InstantiatedGameAction eatGameAction = new InstantiatedGameAction(eatActionFormat, List.of("elephant"));

      enhancedGameEngine.progressStory(eatGameAction);

      String postCondition = "world::randomList IS [\"banana\"]";
      boolean validPrecond = enhancedGameEngine.conditionSucceeds(postCondition);
      assertTrue(validPrecond);
   }

   @Test
   public void numberListProgressStoryTwoRoomsTwoActions() throws KnowledgeException, MissingKnowledgeException {
      EnhancedGameEngine enhancedGameEngine = twoRoomTwoActions();
      ActionFormat openActionFormat = enhancedGameEngine.findAction("open").get(0);
      InstantiatedGameAction openGameAction = new InstantiatedGameAction(openActionFormat, List.of("banana"));
      enhancedGameEngine.progressStory(openGameAction);

      ActionFormat eatActionFormat = new ActionFormat("eat");
      InstantiatedGameAction eatGameAction = new InstantiatedGameAction(eatActionFormat, List.of("elephant"));

      enhancedGameEngine.progressStory(eatGameAction);

      String postCondition = "world::numberList IS [3.14, 1.0]";
      boolean validPrecond = enhancedGameEngine.conditionSucceeds(postCondition);
      assertTrue(validPrecond);
   }

   @Test
   public void puttingNoDesignMessage() throws KnowledgeException {
      EnhancedGameEngine enhancedGameEngine = puttingNoDesignRoom();
      ActionFormat puttingAf = enhancedGameEngine.findAction("put").get(0);
      InstantiatedGameAction openGameAction = new InstantiatedGameAction(puttingAf, List.of("pen", "box"));
      Justification justification = enhancedGameEngine.progressStory(openGameAction);
      String message = justification.getReasoning();
      assertEquals("You put the pen in the box. Nothing important happens.", message);
      assertTrue(justification.isAccepted());
   }

   @Test
   public void puttingNoDesignItemInContains() throws KnowledgeException, MissingKnowledgeException {
      EnhancedGameEngine enhancedGameEngine = puttingNoDesignRoom();
      ActionFormat puttingAf = enhancedGameEngine.findAction("put").get(0);
      InstantiatedGameAction openGameAction = new InstantiatedGameAction(puttingAf, List.of("pen", "box"));
      enhancedGameEngine.progressStory(openGameAction);

      String postCondition = "\"pen\" IN box::contains";
      boolean validPrecond = enhancedGameEngine.conditionSucceeds(postCondition);
      assertTrue(validPrecond);
   }

   @Test
   public void puttingNoDesignIsContained() throws KnowledgeException, MissingKnowledgeException {
      EnhancedGameEngine enhancedGameEngine = puttingNoDesignRoom();
      ActionFormat puttingAf = enhancedGameEngine.findAction("put").get(0);
      InstantiatedGameAction openGameAction = new InstantiatedGameAction(puttingAf, List.of("pen", "box"));
      enhancedGameEngine.progressStory(openGameAction);

      String postCondition = "pen::isContained";
      boolean validPrecond = enhancedGameEngine.conditionSucceeds(postCondition);
      assertTrue(validPrecond);
   }

   @Test
   public void puttingNoDesignInternalVolume() throws KnowledgeException, MissingKnowledgeException {
      EnhancedGameEngine enhancedGameEngine = puttingNoDesignRoom();
      ActionFormat puttingAf = enhancedGameEngine.findAction("put").get(0);
      InstantiatedGameAction openGameAction = new InstantiatedGameAction(puttingAf, List.of("pen", "box"));
      enhancedGameEngine.progressStory(openGameAction);

      String postCondition = "box::internalVolume = 9.0";
      boolean validPrecond = enhancedGameEngine.conditionSucceeds(postCondition);
      assertTrue(validPrecond);
   }

   @Test
   public void puttingContainedItemNoDesignMessage() throws KnowledgeException {
      EnhancedGameEngine enhancedGameEngine = puttingNoDesignRoom();
      ActionFormat puttingAf = enhancedGameEngine.findAction("put").get(0);
      InstantiatedGameAction openGameActionPen = new InstantiatedGameAction(puttingAf, List.of("pen", "box"));
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
      InstantiatedGameAction openGameActionPen = new InstantiatedGameAction(puttingAf, List.of("pen", "box"));
      InstantiatedGameAction openGameActionApple = new InstantiatedGameAction(puttingAf2, List.of("apple", "box"));
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
      InstantiatedGameAction openGameActionPen = new InstantiatedGameAction(puttingAf, List.of("pen", "box"));
      InstantiatedGameAction openGameActionApple = new InstantiatedGameAction(puttingAf2, List.of("apple", "box"));
      enhancedGameEngine.progressStory(openGameActionPen);
      enhancedGameEngine.progressStory(openGameActionApple);
      String postCondition = "box::internalVolume = 4.0";
      boolean validPrecond = enhancedGameEngine.conditionSucceeds(postCondition);
      assertTrue(validPrecond);
   }

   @Test
   public void puttingSecondItemNoDesignContains() throws KnowledgeException, MissingKnowledgeException {
      EnhancedGameEngine enhancedGameEngine = puttingNoDesignRoom();
      ActionFormat puttingAf = enhancedGameEngine.findAction("put").get(0);
      ActionFormat puttingAf2 = enhancedGameEngine.findAction("put").get(0);
      InstantiatedGameAction openGameActionPen = new InstantiatedGameAction(puttingAf, List.of("pen", "box"));
      InstantiatedGameAction openGameActionApple = new InstantiatedGameAction(puttingAf2, List.of("apple", "box"));
      enhancedGameEngine.progressStory(openGameActionPen);
      enhancedGameEngine.progressStory(openGameActionApple);
      String postCondition = "\"apple\" IN box::contains AND \"pen\" IN box::contains";
      boolean validPrecond = enhancedGameEngine.conditionSucceeds(postCondition);
      assertTrue(validPrecond);
   }

   @Test
   public void puttingSecondItemNoDesignAppleIsContained() throws KnowledgeException, MissingKnowledgeException {
      EnhancedGameEngine enhancedGameEngine = puttingNoDesignRoom();
      ActionFormat puttingAf = enhancedGameEngine.findAction("put").get(0);
      ActionFormat puttingAf2 = enhancedGameEngine.findAction("put").get(0);
      InstantiatedGameAction openGameActionPen = new InstantiatedGameAction(puttingAf, List.of("pen", "box"));
      InstantiatedGameAction openGameActionApple = new InstantiatedGameAction(puttingAf2, List.of("apple", "box"));
      enhancedGameEngine.progressStory(openGameActionPen);
      enhancedGameEngine.progressStory(openGameActionApple);
      String postCondition = "apple::isContained";
      boolean validPrecond = enhancedGameEngine.conditionSucceeds(postCondition);
      assertTrue(validPrecond);
   }

   @Test
   public void puttingThirdItemNoDesignTooBigMessage() throws KnowledgeException {
      EnhancedGameEngine enhancedGameEngine = puttingNoDesignRoom();
      ActionFormat puttingAf = enhancedGameEngine.findAction("put").get(0);
      InstantiatedGameAction openGameActionPen = new InstantiatedGameAction(puttingAf, List.of("pen", "box"));
      InstantiatedGameAction openGameActionApple = new InstantiatedGameAction(puttingAf, List.of("apple", "box"));
      InstantiatedGameAction openGameActionBall = new InstantiatedGameAction(puttingAf, List.of("ball", "box"));
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
      InstantiatedGameAction putGameActionPen = new InstantiatedGameAction(puttingAf, List.of("pen", "box"));
      InstantiatedGameAction putGameActionApple = new InstantiatedGameAction(puttingAf, List.of("apple", "box"));
      InstantiatedGameAction putGameActionBall = new InstantiatedGameAction(puttingAf, List.of("ball", "box"));
      enhancedGameEngine.progressStory(putGameActionPen);
      enhancedGameEngine.progressStory(putGameActionApple);
      enhancedGameEngine.progressStory(putGameActionBall);
      String postCondition = "NOT ball::isContained";
      boolean validPrecond = enhancedGameEngine.conditionSucceeds(postCondition);
      assertTrue(validPrecond);
   }

   @Test
   public void puttingThirdItemNoDesignTooBigInternalVolume() throws KnowledgeException, MissingKnowledgeException {
      EnhancedGameEngine enhancedGameEngine = puttingNoDesignRoom();
      ActionFormat puttingAf = enhancedGameEngine.findAction("put").get(0);
      InstantiatedGameAction openGameActionPen = new InstantiatedGameAction(puttingAf, List.of("pen", "box"));
      InstantiatedGameAction openGameActionApple = new InstantiatedGameAction(puttingAf, List.of("apple", "box"));
      InstantiatedGameAction openGameActionBall = new InstantiatedGameAction(puttingAf, List.of("ball", "box"));
      enhancedGameEngine.progressStory(openGameActionPen);
      enhancedGameEngine.progressStory(openGameActionApple);
      enhancedGameEngine.progressStory(openGameActionBall);
      String postCondition = "box::internalVolume = 4.0";
      boolean validPrecond = enhancedGameEngine.conditionSucceeds(postCondition);
      assertTrue(validPrecond);
   }

   @Test
   public void puttingThirdItemNoDesignTooBigContains() throws KnowledgeException, MissingKnowledgeException {
      EnhancedGameEngine enhancedGameEngine = puttingNoDesignRoom();
      ActionFormat puttingAf = enhancedGameEngine.findAction("put").get(0);
      InstantiatedGameAction openGameActionPen = new InstantiatedGameAction(puttingAf, List.of("pen", "box"));
      InstantiatedGameAction openGameActionApple = new InstantiatedGameAction(puttingAf, List.of("apple", "box"));
      InstantiatedGameAction openGameActionBall = new InstantiatedGameAction(puttingAf, List.of("ball", "box"));
      enhancedGameEngine.progressStory(openGameActionPen);
      enhancedGameEngine.progressStory(openGameActionApple);
      enhancedGameEngine.progressStory(openGameActionBall);
      String postCondition = "[\"pen\", \"apple\"] IS box::contains";
      boolean validPrecond = enhancedGameEngine.conditionSucceeds(postCondition);
      assertTrue(validPrecond);
   }


   @Test
   public void puttingRemovingNoDesignMessage() throws KnowledgeException {
      EnhancedGameEngine enhancedGameEngine = puttingNoDesignRoom();
      ActionFormat puttingAf = enhancedGameEngine.findAction("put").get(0);
      InstantiatedGameAction putGameAction = new InstantiatedGameAction(puttingAf, List.of("pen", "box"));
      ActionFormat removeAf = enhancedGameEngine.findAction("remove").get(0);
      InstantiatedGameAction removeGameAction = new InstantiatedGameAction(removeAf, List.of("pen", "box"));
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
      InstantiatedGameAction putGameAction = new InstantiatedGameAction(puttingAf, List.of("pen", "box"));
      ActionFormat removeAf = enhancedGameEngine.findAction("remove").get(0);
      InstantiatedGameAction removeGameAction = new InstantiatedGameAction(removeAf, List.of("pen", "box"));
      String putMessage = enhancedGameEngine.progressStory(putGameAction).getReasoning();
      String removeMessage = enhancedGameEngine.progressStory(removeGameAction).getReasoning();
      String postCondition = "box::internalVolume = 10.0 AND box::contains IS [] AND NOT pen::isContained";
      boolean validPrecond = enhancedGameEngine.conditionSucceeds(postCondition);
      assertTrue(validPrecond);
   }

   @Test
   public void removingNoDesignMessage() throws KnowledgeException {
      EnhancedGameEngine enhancedGameEngine = puttingNoDesignRoom();
      ActionFormat removeAf = enhancedGameEngine.findAction("remove").get(0);
      InstantiatedGameAction removeGameAction = new InstantiatedGameAction(removeAf, List.of("pen", "box"));
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
      InstantiatedGameAction takeGameAction = new InstantiatedGameAction(take, List.of("pen"));
      assert (enhancedGameEngine.conditionSucceeds("NOT \"pen\" IN world::inventory"));
      enhancedGameEngine.progressStory(takeGameAction);
      assert (enhancedGameEngine.conditionSucceeds("\"pen\" IN world::inventory"));

      Justification justification = enhancedGameEngine.progressStory(takeGameAction);
      String message = justification.getReasoning();
      assertEquals("The pen is already on your person.", message);
      assertFalse(justification.isAccepted());
   }

   @Test
   public void takingLightItem() throws KnowledgeException, MissingKnowledgeException {
      EnhancedGameEngine enhancedGameEngine = takingPushingPullingRoom();
      ActionFormat take = enhancedGameEngine.findAction("take").get(0);
      InstantiatedGameAction takeGameAction = new InstantiatedGameAction(take, List.of("pen"));
      assert (enhancedGameEngine.conditionSucceeds("NOT \"pen\" IN world::inventory"));

      Justification justification = enhancedGameEngine.progressStory(takeGameAction);
      String message = justification.getReasoning();
      assertEquals("You take the pen. Nothing important happens.", message);
      assertTrue(justification.isAccepted());
   }

   @Test
   public void takingDesignedItem() throws KnowledgeException {
      EnhancedGameEngine enhancedGameEngine = takingPushingPullingRoom();
      ActionFormat take = enhancedGameEngine.findAction("take").get(0);
      InstantiatedGameAction takeGameAction = new InstantiatedGameAction(take, List.of("ball"));
      Justification justification = enhancedGameEngine.progressStory(takeGameAction);
      String message = justification.getReasoning();
      assertEquals("You take the ball. Well done. You did it.", message);
      assertTrue(justification.isAccepted());
   }

   @Test
   public void takingHeavyItem() throws KnowledgeException {
      EnhancedGameEngine enhancedGameEngine = takingPushingPullingRoom();
      ActionFormat take = enhancedGameEngine.findAction("take").get(0);
      InstantiatedGameAction takeGameAction = new InstantiatedGameAction(take, List.of("box"));
      Justification justification = enhancedGameEngine.progressStory(takeGameAction);
      String message = justification.getReasoning();
      assertEquals("The box is too heavy for you to carry.", message);
      assertFalse(justification.isAccepted());
   }

   @Test
   public void takingMovingRoomsDropping() throws KnowledgeException, MissingKnowledgeException {
      EnhancedGameEngine enhancedGameEngine = takingPushingPullingRoom();
      ActionFormat take = enhancedGameEngine.findAction("take").get(0);
      InstantiatedGameAction takeGameAction = new InstantiatedGameAction(take, List.of("ball"));
      Justification justification = enhancedGameEngine.progressStory(takeGameAction);
      String message = justification.getReasoning();
      assertEquals("You take the ball. Well done. You did it.", message);
      assertFalse(enhancedGameEngine.findRoom("Taking Room").get(0).getItems().contains(new Item("ball")));
      assertTrue(justification.isAccepted());

      ActionFormat open = enhancedGameEngine.findAction("open").get(0);
      InstantiatedGameAction moveRoomAction = new InstantiatedGameAction(open, List.of("ball"));
      Justification justification2 = enhancedGameEngine.progressStory(moveRoomAction);
      String message2 = justification2.getReasoning();
      assertTrue(justification2.isAccepted());

      assertEquals("Well done. You did it.", message2);
      ActionFormat drop = enhancedGameEngine.findAction("drop").get(0);
      InstantiatedGameAction dropAction = new InstantiatedGameAction(drop, List.of("ball"));
      Justification justification3 = enhancedGameEngine.progressStory(dropAction);
      String message3 = justification3.getReasoning();
      assertTrue(justification3.isAccepted());

      assertEquals("You drop the ball next to you. Nothing important happens.", message3);
      assertFalse(enhancedGameEngine.findRoom("Taking Room").get(0).getItems().contains(new Item("ball")));
      assertTrue(enhancedGameEngine.findRoom("Other Room").get(0).getItems().contains(new Item("ball")));
      assertTrue(enhancedGameEngine.conditionSucceeds("NOT \"ball\" IN world::inventory"));
   }

   @Test
   public void droppingItemThatYouDontHaveFails() throws KnowledgeException {
      EnhancedGameEngine enhancedGameEngine = takingPushingPullingRoom();
      ActionFormat drop = enhancedGameEngine.findAction("drop").get(0);
      InstantiatedGameAction dropAction = new InstantiatedGameAction(drop, List.of("pen"));
      Justification justification = enhancedGameEngine.progressStory(dropAction);
      String message = justification.getReasoning();
      assertEquals("You can't drop the pen because you haven't picked it up.", message);
   }


   @Test
   public void pushingLightItem() throws KnowledgeException {
      EnhancedGameEngine enhancedGameEngine = takingPushingPullingRoom();
      ActionFormat push = enhancedGameEngine.findAction("push").get(0);
      InstantiatedGameAction pushGameAction = new InstantiatedGameAction(push, List.of("pen"));
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
      InstantiatedGameAction pushGameAction = new InstantiatedGameAction(push, List.of("box"));
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
      InstantiatedGameAction pushGameAction = new InstantiatedGameAction(push, List.of("ball"));
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
      InstantiatedGameAction pullGameAction = new InstantiatedGameAction(pull, List.of("pen"));
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
      InstantiatedGameAction pullGameAction = new InstantiatedGameAction(pull, List.of("box"));
      Justification justification = enhancedGameEngine.progressStory(pullGameAction);
      String message = justification.getReasoning();
      assertEquals("The box is too heavy for you to pull.", message);
      assertFalse(justification.isAccepted());
   }


   @Test
   public void pullDesignedItem() throws KnowledgeException {
      EnhancedGameEngine enhancedGameEngine = takingPushingPullingRoom();
      ActionFormat pull = enhancedGameEngine.findAction("pull").get(0);
      InstantiatedGameAction pullGameAction = new InstantiatedGameAction(pull, List.of("ball"));
      Justification justification = enhancedGameEngine.progressStory(pullGameAction);
      String message = justification.getReasoning();
      assertEquals("You pull the ball. Well done. You did it.", message);
      assertTrue(justification.isAccepted());
   }


   @Test
   public void putInHeavyItem() throws KnowledgeException {
      EnhancedGameEngine enhancedGameEngine = takingPushingPullingRoom();
      ActionFormat putIn = enhancedGameEngine.findAction("put").get(0);
      InstantiatedGameAction putInGameAction = new InstantiatedGameAction(putIn, List.of("bucket", "box"));
      Justification justification = enhancedGameEngine.progressStory(putInGameAction);
      String message = justification.getReasoning();
      assertEquals("The bucket is too heavy for you to put in the box.", message);
      assertFalse(justification.isAccepted());
   }

   @Test
   public void putOnHeavyItem() throws KnowledgeException {
      EnhancedGameEngine enhancedGameEngine = takingPushingPullingRoom();
      ActionFormat putOn = enhancedGameEngine.findAction("put").get(1);
      InstantiatedGameAction putOnGameAction = new InstantiatedGameAction(putOn, List.of("bucket", "box"));
      Justification justification = enhancedGameEngine.progressStory(putOnGameAction);
      String message = justification.getReasoning();
      assertEquals("The bucket is too heavy for you to put on the box.", message);
      assertFalse(justification.isAccepted());
   }

   @Test
   public void turnItem() throws KnowledgeException {
      EnhancedGameEngine enhancedGameEngine = takingPushingPullingRoom();
      ActionFormat turn = enhancedGameEngine.findAction("turn").get(0);
      InstantiatedGameAction putOnGameAction = new InstantiatedGameAction(turn, List.of("box"));
      Justification justification = enhancedGameEngine.progressStory(putOnGameAction);
      String message = justification.getReasoning();
      assertEquals("You turn the box. Nothing important happens.", message);
      assertTrue(justification.isAccepted());
   }

   @Test
   public void cantTurnContainedItem() throws KnowledgeException {
      EnhancedGameEngine enhancedGameEngine = takingPushingPullingRoom();
      ActionFormat turn = enhancedGameEngine.findAction("turn").get(0);
      ActionFormat putIn = enhancedGameEngine.findAction("put").get(0);
      InstantiatedGameAction putInGameAction = new InstantiatedGameAction(putIn, List.of("ball", "box"));
      InstantiatedGameAction turnGameAction = new InstantiatedGameAction(turn, List.of("ball"));
      Justification justification1 = enhancedGameEngine.progressStory(putInGameAction);
      Justification justification2 = enhancedGameEngine.progressStory(turnGameAction);
      String message = justification2.getReasoning();
      assertEquals("You can't turn the ball because it is inside of something else.", message);
      assertFalse(justification2.isAccepted());
   }

   @Test
   public void examineItem() throws KnowledgeException {
      EnhancedGameEngine enhancedGameEngine = takingPushingPullingRoom();
      ActionFormat examineAction = enhancedGameEngine.findAction("examine").get(0);
      InstantiatedGameAction examineGameAction = new InstantiatedGameAction(examineAction, List.of("box"));
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
      InstantiatedGameAction putInGameAction = new InstantiatedGameAction(putIn, List.of("ball", "box"));
      InstantiatedGameAction turnGameAction = new InstantiatedGameAction(examine, List.of("ball"));
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
      InstantiatedGameAction searchGameAction = new InstantiatedGameAction(searchAction, List.of("box"));
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
      InstantiatedGameAction putInGameAction = new InstantiatedGameAction(putIn, List.of("ball", "box"));
      InstantiatedGameAction turnGameAction = new InstantiatedGameAction(search, List.of("ball"));
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
      InstantiatedGameAction listenGameAction = new InstantiatedGameAction(listen, List.of("box"));
      Justification justification = enhancedGameEngine.progressStory(listenGameAction);
      String message = justification.getReasoning();
      assertEquals("You listen to the box but hear nothing of interest.", message);
      assertTrue(justification.isAccepted());
   }

   // TODO: Test EAT, DRINK, TRANSFER

}