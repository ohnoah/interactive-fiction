import static org.junit.Assert.*;


import com.intfic.game.basic.BasicCondition;
import com.intfic.game.basic.BasicGameEngine;
import com.intfic.game.basic.BasicGameDesignAction;
import com.intfic.game.enhanced.EnhancedGameEngine;
import com.intfic.game.enhanced.reasoning.error.KnowledgeException;
import com.intfic.game.enhanced.reasoning.error.MissingKnowledgeException;
import com.intfic.game.enhanced.reasoning.wrappers.Condition;
import com.intfic.game.enhanced.reasoning.wrappers.Justification;
import com.intfic.game.shared.ActionFormat;
import com.intfic.game.shared.InstantiatedGameAction;
import com.intfic.game.shared.Item;
import com.intfic.game.shared.Room;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.Test;

public class BasicGameEngineTest {


   public static BasicGameEngine oneRoomOneAction() {
      Room room = new Room("place1");
      List<Item> place1Items = TestUtil.stringsToItemsInRoomNoAdj(Set.of("apple", "banana", "orange"));
      room.setItems(place1Items);

      BasicGameEngine basicGameEngine = new BasicGameEngine();
      basicGameEngine.addRoom(room);
      basicGameEngine.setCurrentRoom(room);


      ActionFormat actionFormat = new ActionFormat("eat");
      // Create key for action
      InstantiatedGameAction instantiatedGameAction = new InstantiatedGameAction(actionFormat, List.of(List.of(TestUtil.findItem(place1Items, "apple"))));
      // Create value for action
      List<BasicCondition> preCond = createPreconds("room", "place1", "PLACE 1 FAIL");
/*      Map<String, String> preCond = new HashMap<>();
      preCond.put("room", "place1");*/
      Map<String, String> postCond = new HashMap<>();
      postCond.put("random-state", "very-good");
      postCond.put("superset-state", "very-not-good");
      BasicGameDesignAction basicGameDesignAction = new BasicGameDesignAction(preCond, "You did action 1", postCond);
      // Put in maps
      basicGameEngine.addAction(room, instantiatedGameAction, basicGameDesignAction);

      return basicGameEngine;
   }

   private static List<BasicCondition> createPreconds(String... strings) {
      String key = "";
      String desVal = "";
      String errorMsg = "";
      List<BasicCondition> conditions = new ArrayList<>();
      if (strings.length % 3 != 0) {
         throw new RuntimeException("PRECONDITION STRING NOT DIVISIBLE BY 3");
      }
      for (int i = 0; i < strings.length; i++) {
         if (i % 3 == 0) {
            key = strings[i];
         }
         else if (i % 3 == 1) {
            desVal = strings[i];
         }
         else {
            errorMsg = strings[i];
            conditions.add(new BasicCondition(key, desVal, errorMsg));
         }
      }
      conditions.add(new BasicCondition(key, desVal, errorMsg));
      return conditions;
   }

   public static BasicGameEngine twoRoomTwoActions() {
      Room room = new Room("place1");
      List<Item> room1Items =
          TestUtil.stringsToItemsInRoomNoAdj(Set.of("apple", "banana", "orange"));
      room.setItems(room1Items);

      Room room2 = new Room("room2");
      List<Item> room2Items = TestUtil.stringsToItemsInRoomNoAdj(Set.of("elephant"));
      room2.setItems(room2Items);

      BasicGameEngine basicGameEngine = new BasicGameEngine();
      basicGameEngine.addRoom(room);
      basicGameEngine.addRoom(room2);
      basicGameEngine.setCurrentRoom(room);
      // Create key for action
      InstantiatedGameAction instantiatedGameAction1 = new InstantiatedGameAction(new ActionFormat("open"),
          List.of(List.of(TestUtil.findItem(room1Items, "banana"))));
      // Create value for action
/*      Map<String, String> preCond = new HashMap<>();
      preCond.put("room", "place1");*/
      List<BasicCondition> preCond = createPreconds("room", "place1", "PLACE 1 FAIl");
      Map<String, String> postCond = new HashMap<>();
      postCond.put("room", "room2");
      postCond.put("state", "random");
      postCond.put("errorMessage", "You can't do that, dummy.");
      BasicGameDesignAction basicGameDesignAction1 = new BasicGameDesignAction(preCond, "You did action 1", postCond);
      // Put in maps


      // Create key for action
      InstantiatedGameAction eatAction = new InstantiatedGameAction(
          new ActionFormat("eat"), List.of(List.of(TestUtil.findItem(room2Items, "elephant"))));
      // Create value for action
/*      Map<String, String> eatPrecond = new HashMap<>();
      eatPrecond.put("room", "room2");*/
      List<BasicCondition> eatPrecond = createPreconds("room", "room2", "ROOM 2 FAIL");
      BasicGameDesignAction designEat = new BasicGameDesignAction(eatPrecond,
          "You did action 2", new HashMap<>());

      InstantiatedGameAction enterAction = new InstantiatedGameAction(
          new ActionFormat("enter"), List.of(List.of(TestUtil.findItem(room1Items, "banana"))));
      // Create value for action
/*      Map<String, String> enterPrecond = new HashMap<>();
      enterPrecond.put("random", "randomina");*/
      List<BasicCondition> enterPrecond = createPreconds("random", "randomina", "RANDOMINA FAIL");
      BasicGameDesignAction designEnter = new BasicGameDesignAction(enterPrecond,
          "You did action 3", new HashMap<>());


      basicGameEngine.addAction(room, instantiatedGameAction1, basicGameDesignAction1);
      basicGameEngine.addAction(room2, eatAction, designEat);
      basicGameEngine.addAction(room, enterAction, designEnter);
      return basicGameEngine;


   }

   @Test
   public void errorMessageChangesAppropriately() {
      BasicGameEngine basicGameEngine = twoRoomTwoActions();
      ActionFormat burnActionFormat = basicGameEngine.findAction("burn").get(0);
      InstantiatedGameAction burnGameAction = new InstantiatedGameAction(burnActionFormat, List.of(List.of(TestUtil.findPossibleItemFromNoun(basicGameEngine, "banana"))));
      Justification justificationOpen = basicGameEngine.progressStory(burnGameAction);

      assertEquals("You can't do that.", justificationOpen.getReasoning());
      assertFalse(justificationOpen.isAccepted());

      ActionFormat openActionFormat = basicGameEngine.findAction("open").get(0);
      InstantiatedGameAction openGameAction = new InstantiatedGameAction(openActionFormat,
          List.of(List.of(TestUtil.findPossibleItemFromNoun(basicGameEngine, "banana"))));
      basicGameEngine.progressStory(openGameAction);

      ActionFormat climbActionFormat = new ActionFormat("climb");
      InstantiatedGameAction climbAction = new InstantiatedGameAction(climbActionFormat,
          List.of(List.of(TestUtil.findPossibleItemFromNoun(basicGameEngine, "elephant"))));

      Justification justificationClimb = basicGameEngine.progressStory(climbAction);

      assertEquals("You can't do that, dummy.", justificationClimb.getReasoning());
      assertFalse(justificationClimb.isAccepted());
   }

   @Test
   public void designedErrorMessage() {
      BasicGameEngine basicGameEngine = twoRoomTwoActions();
      ActionFormat enterAF = basicGameEngine.findAction("enter").get(0);
      InstantiatedGameAction enterAction = new InstantiatedGameAction(enterAF,
          List.of(List.of(TestUtil.findPossibleItemFromNoun(basicGameEngine, "banana"))));
      Justification justEnter = basicGameEngine.progressStory(enterAction);

      assertFalse(justEnter.isAccepted());
      assertEquals("RANDOMINA FAIL", justEnter.getReasoning());
   }


   @Test
   public void basicGameConditionEquals() {
      BasicCondition c1 = new BasicCondition("banana", "true", "False");
      BasicCondition c2 = new BasicCondition("banana", "true", "False");
      assertEquals(c1, c2);
      assertEquals(c1, c1);
   }


   @Test
   public void possibleItemNamesWorks() {
      BasicGameEngine basicGameEngine = oneRoomOneAction();
      Set<Item> items = basicGameEngine.possibleItems();
      Set<String> itemNames = items.stream().map(Item::getName).collect(Collectors.toSet());
      assertEquals(Set.of("apple", "banana", "orange"), itemNames);
   }

   @Test
   public void messageAfterProgressStory() {
      BasicGameEngine basicGameEngine = oneRoomOneAction();
      ActionFormat actionFormat = new ActionFormat("eat");
      InstantiatedGameAction instantiatedGameAction = new InstantiatedGameAction(actionFormat,
          List.of(List.of(TestUtil.findPossibleItemFromNoun(basicGameEngine, "apple"))));
      Justification justification = basicGameEngine.progressStory(instantiatedGameAction);
      String message = justification.getReasoning();
      assertEquals(message, "You did action 1");
      assertTrue(justification.isAccepted());
   }

   @Test
   public void validatePreconditionAfterProgressStory() {
      BasicGameEngine basicGameEngine = oneRoomOneAction();
      ActionFormat actionFormat = new ActionFormat("eat");
      InstantiatedGameAction instantiatedGameAction = new InstantiatedGameAction(actionFormat,
          List.of(List.of(TestUtil.findPossibleItemFromNoun(basicGameEngine, "apple"))));
      basicGameEngine.progressStory(instantiatedGameAction);
/*      Map<String, String> postState = new HashMap<>();
      postState.put("random-state", "very-good");
      postState.put("room", "place1");*/
      List<BasicCondition> postState = createPreconds("random-state", "very-good", "Very-GOOD FAIL", "room", "place1", "ROOM FAIL");
      Justification justification = basicGameEngine.validatePrecondition(postState);
      assertTrue(justification.isAccepted());
   }

   @Test
   public void messagesProgressStoryTwoRoomsTwoActions() {
      BasicGameEngine basicGameEngine = twoRoomTwoActions();
      ActionFormat openActionFormat = new ActionFormat("open");
      InstantiatedGameAction openGameAction = new InstantiatedGameAction(openActionFormat,
          List.of(List.of(TestUtil.findPossibleItemFromNoun(basicGameEngine, "banana"))));
      Justification justificationOpen = basicGameEngine.progressStory(openGameAction);
      String messageOpen = justificationOpen.getReasoning();

      ActionFormat eatActionFormat = new ActionFormat("eat");
      InstantiatedGameAction eatGameAction = new InstantiatedGameAction(eatActionFormat,
          List.of(List.of(TestUtil.findPossibleItemFromNoun(basicGameEngine, "elephant"))));

      Justification justificationEat = basicGameEngine.progressStory(eatGameAction);
      String messageEat = justificationEat.getReasoning();

      assertEquals(List.of("You did action 1", "You did action 2"), List.of(messageOpen, messageEat));
      assertTrue(justificationOpen.isAccepted());
      assertTrue(justificationEat.isAccepted());
   }


   @Test
   public void globalStateProgressStoryTwoRoomsTwoActions() {
      BasicGameEngine basicGameEngine = twoRoomTwoActions();
      ActionFormat openActionFormat = new ActionFormat("open");
      InstantiatedGameAction openGameAction = new InstantiatedGameAction(openActionFormat,
          List.of(List.of(TestUtil.findPossibleItemFromNoun(basicGameEngine, "banana"))));
      basicGameEngine.progressStory(openGameAction);

      ActionFormat eatActionFormat = new ActionFormat("eat");
      InstantiatedGameAction eatGameAction = new InstantiatedGameAction(eatActionFormat,
          List.of(List.of(TestUtil.findPossibleItemFromNoun(basicGameEngine, "elephant"))));

      basicGameEngine.progressStory(eatGameAction);

      /*Map<String, String> postState = new HashMap<>();
      postState.put("room", "room2");
      postState.put("state", "random");*/
      List<BasicCondition> postState = createPreconds("room", "room2", "ROOM FAIL", "state", "random", "STATE FAIL");
      Justification validPrecond = basicGameEngine.validatePrecondition(postState);
      assertTrue(validPrecond.isAccepted());
   }

}