import static org.junit.Assert.*;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.Test;

public class EnhancedGameEngineTest {
   private static EnhancedGameEngine oneRoomOneAction() {
      Room room = new Room("place1");
      room.setItemsNoAdjectives(List.of("apple", "banana", "orange"));

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
      try {
         knowledgeUpdates.add(new KnowledgeUpdate("world::randomState := \"very-good\""));
         knowledgeUpdates.add(new KnowledgeUpdate("world::numActions := 0"));
         knowledgeUpdates.add(new KnowledgeUpdate("world::supersetState := \"very-not-good\""));
      } catch (KnowledgeException e) {
         e.printStackTrace();
         return null;
      }
      EnhancedGameDesignAction enhancedGameDesignAction = new EnhancedGameDesignAction(conditions, "You did action 1 in enhanced.", knowledgeUpdates);
      // Put in maps
      enhancedGameEngine.addAction(room, instantiatedGameAction, enhancedGameDesignAction);

      return enhancedGameEngine;
   }

   private static EnhancedGameEngine twoRoomTwoActions() {
      Room room = new Room("place1");
      room.setItemsNoAdjectives(List.of("apple", "banana", "orange"));
      Room room2 = new Room("room2");
      room2.setItemsNoAdjectives(List.of("elephant"));

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
      try {
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
      } catch (KnowledgeException e) {
         e.printStackTrace();
         return null;
      }

      EnhancedGameDesignAction enhancedGameDesignAction1 =
          new EnhancedGameDesignAction(conditions1, "You did action 1.", knowledgeUpdates1);
      EnhancedGameDesignAction enhancedGameDesignAction2 =
          new EnhancedGameDesignAction(conditions2, "You did action 2 number world::numActions.", knowledgeUpdates2);

      enhancedGameEngine.addAction(room, instantiatedGameAction1, enhancedGameDesignAction1);
      enhancedGameEngine.addAction(room2, instantiatedGameAction2, enhancedGameDesignAction2);
      return enhancedGameEngine;

   }

   @Test
   public void possibleItemNamesWorks() {
      EnhancedGameEngine enhancedGameEngine = oneRoomOneAction();
      Set<Item> items = enhancedGameEngine.possibleItems();
      Set<String> itemNames = items.stream().map(Item::getName).collect(Collectors.toSet());
      assertEquals(Set.of("apple", "banana", "orange"), itemNames);
   }

   @Test
   public void messageAfterProgressStory() {
      EnhancedGameEngine enhancedGameEngine = oneRoomOneAction();
      ActionFormat actionFormat = new ActionFormat("eat");
      InstantiatedGameAction instantiatedGameAction = new InstantiatedGameAction(actionFormat, List.of("apple"));
      String message = enhancedGameEngine.progressStory(instantiatedGameAction);
      assertEquals("You did action 1 in enhanced.", message);
   }

   @Test
   public void validateConditionAfterProgressStory() throws KnowledgeException, MissingKnowledgeException {
      EnhancedGameEngine enhancedGameEngine = oneRoomOneAction();
      ActionFormat actionFormat = new ActionFormat("eat");
      InstantiatedGameAction instantiatedGameAction = new InstantiatedGameAction(actionFormat, List.of("apple"));
      enhancedGameEngine.progressStory(instantiatedGameAction);
      String postCondition = "world::randomState = \"very-good\" AND room=\"place1\"";
      boolean validPrecond = enhancedGameEngine.conditionSucceeds(postCondition);
      assertTrue(validPrecond);
   }

   @Test
   public void messagesProgressStoryTwoRoomsTwoActions() {
      EnhancedGameEngine enhancedGameEngine = twoRoomTwoActions();
      ActionFormat openActionFormat = new ActionFormat("open");
      InstantiatedGameAction openGameAction = new InstantiatedGameAction(openActionFormat, List.of("banana"));
      String messageOpen = enhancedGameEngine.progressStory(openGameAction);

      ActionFormat eatActionFormat = new ActionFormat("eat");
      InstantiatedGameAction eatGameAction = new InstantiatedGameAction(eatActionFormat, List.of("elephant"));

      String messageEat = enhancedGameEngine.progressStory(eatGameAction);

      assertEquals(List.of("You did action 1.", "You did action 2 number 1."), List.of(messageOpen, messageEat));
   }

   @Test
   public void numActionsProgressStoryTwoRoomsTwoActions() throws KnowledgeException, MissingKnowledgeException {
      EnhancedGameEngine enhancedGameEngine = twoRoomTwoActions();
      ActionFormat openActionFormat = new ActionFormat("open");
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
      ActionFormat openActionFormat = new ActionFormat("open");
      InstantiatedGameAction openGameAction = new InstantiatedGameAction(openActionFormat, List.of("banana"));
      enhancedGameEngine.progressStory(openGameAction);

      ActionFormat eatActionFormat = new ActionFormat("eat");
      InstantiatedGameAction eatGameAction = new InstantiatedGameAction(eatActionFormat, List.of("elephant"));

      enhancedGameEngine.progressStory(eatGameAction);

      String postCondition = "world::randomList = [\"banana\"]";
      boolean validPrecond = enhancedGameEngine.conditionSucceeds(postCondition);
      assertTrue(validPrecond);
   }

   @Test
   public void numberListProgressStoryTwoRoomsTwoActions() throws KnowledgeException, MissingKnowledgeException {
      EnhancedGameEngine enhancedGameEngine = twoRoomTwoActions();
      ActionFormat openActionFormat = new ActionFormat("open");
      InstantiatedGameAction openGameAction = new InstantiatedGameAction(openActionFormat, List.of("banana"));
      enhancedGameEngine.progressStory(openGameAction);

      ActionFormat eatActionFormat = new ActionFormat("eat");
      InstantiatedGameAction eatGameAction = new InstantiatedGameAction(eatActionFormat, List.of("elephant"));

      enhancedGameEngine.progressStory(eatGameAction);

      String postCondition = "world::numberList = [3.14, 3.142, 1.0]";
      boolean validPrecond = enhancedGameEngine.conditionSucceeds(postCondition);
      assertTrue(validPrecond);
   }

}