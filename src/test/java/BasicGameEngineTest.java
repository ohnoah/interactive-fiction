import static org.junit.Assert.*;


import com.basic.BasicGameDesignAction;
import com.enhanced.reasoning.Justification;
import com.shared.ActionFormat;
import com.shared.InstantiatedGameAction;
import com.shared.Item;
import com.shared.Room;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.Test;

public class BasicGameEngineTest {

   public static BasicGameEngine oneRoomOneAction(){
      Room room = new Room("place1");
      room.setItemsNoAdjectives(Set.of("apple", "banana", "orange"));

      BasicGameEngine basicGameEngine = new BasicGameEngine();
      basicGameEngine.addRoom(room);
      basicGameEngine.setCurrentRoom(room);


      ActionFormat actionFormat = new ActionFormat("eat");
      // Create key for action
      InstantiatedGameAction instantiatedGameAction = new InstantiatedGameAction(actionFormat, List.of("apple"));
      // Create value for action
      Map<String, String> preCond = new HashMap<>();
      preCond.put("room", "place1");
      Map<String, String> postCond = new HashMap<>();
      postCond.put("random-state", "very-good");
      postCond.put("superset-state", "very-not-good");
      BasicGameDesignAction basicGameDesignAction = new BasicGameDesignAction(preCond, "You did action 1", postCond);
      // Put in maps
      basicGameEngine.addAction(room, instantiatedGameAction, basicGameDesignAction);

      return basicGameEngine;
   }

   public static BasicGameEngine twoRoomTwoActions(){
      Room room = new Room("place1");
      room.setItemsNoAdjectives(Set.of("apple", "banana", "orange"));
      Room room2 = new Room("room2");
      room2.setItemsNoAdjectives(Set.of("elephant"));

      BasicGameEngine basicGameEngine = new BasicGameEngine();
      basicGameEngine.addRoom(room);
      basicGameEngine.addRoom(room2);
      basicGameEngine.setCurrentRoom(room);
      // Create key for action
      InstantiatedGameAction instantiatedGameAction1 = new InstantiatedGameAction(new ActionFormat("open"), List.of("banana"));
      // Create value for action
      Map<String, String> preCond = new HashMap<>();
      preCond.put("room", "place1");
      Map<String, String> postCond = new HashMap<>();
      postCond.put("room", "room2");
      postCond.put("state", "random");
      BasicGameDesignAction basicGameDesignAction1 = new BasicGameDesignAction(preCond, "You did action 1", postCond);
      // Put in maps


      // Create key for action
      InstantiatedGameAction instantiatedGameAction2 = new InstantiatedGameAction(new ActionFormat("eat"), List.of("elephant"));
      // Create value for action
      Map<String, String> preCond2 = new HashMap<>();
      preCond2.put("room", "room2");
      BasicGameDesignAction basicGameDesignAction2 = new BasicGameDesignAction(preCond2, "You did action 2", new HashMap<>());

      basicGameEngine.addAction(room, instantiatedGameAction1, basicGameDesignAction1);
      basicGameEngine.addAction(room2, instantiatedGameAction2, basicGameDesignAction2);
      return basicGameEngine;


   }

   @Test
   public void possibleItemNamesWorks(){
      BasicGameEngine basicGameEngine = oneRoomOneAction();
      Set<Item> items = basicGameEngine.possibleItems();
      Set<String> itemNames = items.stream().map(Item::getName).collect(Collectors.toSet());
      assertEquals(Set.of("apple", "banana", "orange"), itemNames);
   }
   @Test
   public void messageAfterProgressStory(){
      BasicGameEngine basicGameEngine = oneRoomOneAction();
      ActionFormat actionFormat = new ActionFormat("eat");
      InstantiatedGameAction instantiatedGameAction = new InstantiatedGameAction(actionFormat, List.of("apple"));
      Justification justification = basicGameEngine.progressStory(instantiatedGameAction);
      String message = justification.getReasoning();
      assertEquals(message, "You did action 1");
      assertTrue(justification.isAccepted());
   }
   @Test
   public void validatePreconditionAfterProgressStory(){
      BasicGameEngine basicGameEngine = oneRoomOneAction();
      ActionFormat actionFormat = new ActionFormat("eat");
      InstantiatedGameAction instantiatedGameAction = new InstantiatedGameAction(actionFormat, List.of("apple"));
      basicGameEngine.progressStory(instantiatedGameAction);
      Map<String, String> postState = new HashMap<>();
      postState.put("random-state", "very-good");
      postState.put("room", "place1");
      boolean validPrecond = basicGameEngine.validatePrecondition(postState);
      assertTrue(validPrecond);
   }

   @Test
   public void messagesProgressStoryTwoRoomsTwoActions(){
      BasicGameEngine basicGameEngine = twoRoomTwoActions();
      ActionFormat openActionFormat = new ActionFormat("open");
      InstantiatedGameAction openGameAction = new InstantiatedGameAction(openActionFormat, List.of("banana"));
      Justification justificationOpen = basicGameEngine.progressStory(openGameAction);
      String messageOpen = justificationOpen.getReasoning();

      ActionFormat eatActionFormat = new ActionFormat("eat");
      InstantiatedGameAction eatGameAction = new InstantiatedGameAction(eatActionFormat, List.of("elephant"));

      Justification justificationEat = basicGameEngine.progressStory(eatGameAction);
      String messageEat = justificationEat.getReasoning();

      assertEquals(List.of("You did action 1", "You did action 2"), List.of(messageOpen, messageEat));
      assertTrue(justificationOpen.isAccepted()); assertTrue(justificationEat.isAccepted());
   }

   @Test
   public void globalStateProgressStoryTwoRoomsTwoActions(){
      BasicGameEngine basicGameEngine = twoRoomTwoActions();
      ActionFormat openActionFormat = new ActionFormat("open");
      InstantiatedGameAction openGameAction = new InstantiatedGameAction(openActionFormat, List.of("banana"));
      basicGameEngine.progressStory(openGameAction);

      ActionFormat eatActionFormat = new ActionFormat("eat");
      InstantiatedGameAction eatGameAction = new InstantiatedGameAction(eatActionFormat, List.of("elephant"));

      basicGameEngine.progressStory(eatGameAction);

      Map<String, String> postState = new HashMap<>();
      postState.put("room", "room2");
      postState.put("state", "random");
      boolean validPrecond = basicGameEngine.validatePrecondition(postState);
      assertTrue(validPrecond);
   }

}