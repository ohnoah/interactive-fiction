import static org.junit.Assert.*;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.Test;

public class EnhancedGameEngineTest {
   public static EnhancedGameEngine oneRoomOneAction(){
      Room room = new Room("place1");
      room.setItemsNoAdjectives(List.of("apple", "banana", "orange"));

      EnhancedGameEngine enhancedGameEngine = new EnhancedGameEngine();
      enhancedGameEngine.addRoom(room);
      enhancedGameEngine.setCurrentRoom(room);


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
      enhancedGameEngine.addAction(room, instantiatedGameAction, basicGameDesignAction);

      return enhancedGameEngine;
   }

   public static EnhancedGameEngine twoRoomTwoActions(){
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

      enhancedGameEngine.addAction(room, instantiatedGameAction1, basicGameDesignAction1);
      enhancedGameEngine.addAction(room2, instantiatedGameAction2, basicGameDesignAction2);
      return enhancedGameEngine;


   }

   @Test
   public void possibleItemNamesWorks(){
      EnhancedGameEngine enhancedGameEngine = oneRoomOneAction();
      Set<Item> items = enhancedGameEngine.possibleItems();
      Set<String> itemNames = items.stream().map(Item::getName).collect(Collectors.toSet());
      assertEquals(Set.of("apple", "banana", "orange"), itemNames);
   }
   @Test
   public void messageAfterProgressStory(){
      EnhancedGameEngine enhancedGameEngine = oneRoomOneAction();
      ActionFormat actionFormat = new ActionFormat("eat");
      InstantiatedGameAction instantiatedGameAction = new InstantiatedGameAction(actionFormat, List.of("apple"));
      String message = enhancedGameEngine.progressStory(instantiatedGameAction);
      assertEquals(message, "You did action 1");
   }
   @Test
   public void validatePreconditionAfterProgressStory(){
      EnhancedGameEngine enhancedGameEngine = oneRoomOneAction();
      ActionFormat actionFormat = new ActionFormat("eat");
      InstantiatedGameAction instantiatedGameAction = new InstantiatedGameAction(actionFormat, List.of("apple"));
      enhancedGameEngine.progressStory(instantiatedGameAction);
      Map<String, String> postState = new HashMap<>();
      postState.put("random-state", "very-good");
      postState.put("room", "place1");
      boolean validPrecond = enhancedGameEngine.validatePrecondition(postState);
      assertTrue(validPrecond);
   }

   @Test
   public void messagesProgressStoryTwoRoomsTwoActions(){
      EnhancedGameEngine enhancedGameEngine = twoRoomTwoActions();
      ActionFormat openActionFormat = new ActionFormat("open");
      InstantiatedGameAction openGameAction = new InstantiatedGameAction(openActionFormat, List.of("banana"));
      String messageOpen = enhancedGameEngine.progressStory(openGameAction);

      ActionFormat eatActionFormat = new ActionFormat("eat");
      InstantiatedGameAction eatGameAction = new InstantiatedGameAction(eatActionFormat, List.of("elephant"));

      String messageEat = enhancedGameEngine.progressStory(eatGameAction);

      assertEquals(List.of("You did action 1", "You did action 2"), List.of(messageOpen, messageEat));
   }

   @Test
   public void globalStateProgressStoryTwoRoomsTwoActions(){
      EnhancedGameEngine enhancedGameEngine = twoRoomTwoActions();
      ActionFormat openActionFormat = new ActionFormat("open");
      InstantiatedGameAction openGameAction = new InstantiatedGameAction(openActionFormat, List.of("banana"));
      enhancedGameEngine.progressStory(openGameAction);

      ActionFormat eatActionFormat = new ActionFormat("eat");
      InstantiatedGameAction eatGameAction = new InstantiatedGameAction(eatActionFormat, List.of("elephant"));

      enhancedGameEngine.progressStory(eatGameAction);

      Map<String, String> postState = new HashMap<>();
      postState.put("room", "room2");
      postState.put("state", "random");
      boolean validPrecond = enhancedGameEngine.validatePrecondition(postState);
      assertTrue(validPrecond);
   }

}