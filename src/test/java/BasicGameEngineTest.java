import static org.junit.Assert.*;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.BeforeClass;
import org.junit.Test;

public class BasicGameEngineTest {
   public static BasicGameEngine oneRoomOneAction(){
      System.out.println("Setting it up --!");
      Room room = new Room("place1", List.of("apple", "banana", "orange"));
      List<Room> rooms = List.of(room);
      Map<Room, Map<ConcreteGameAction, GameDesignAction>> actions = new HashMap<>();
      Map<ConcreteGameAction, GameDesignAction> actionsInRoom = new HashMap<>();

      ActionFormat actionFormat = new ActionFormat("eat");
      ConcreteGameAction concreteGameAction = new ConcreteGameAction(actionFormat, List.of("apple"));
      Map<String, String> preCond = new HashMap<>();
      preCond.put("room", "place1");
      Map<String, String> postCond = new HashMap<>();
      postCond.put("random-state", "very-good");
      GameDesignAction gameDesignAction = new GameDesignAction(preCond, "You did action 1", postCond);

      actionsInRoom.put(concreteGameAction, gameDesignAction);
      return new BasicGameEngine(rooms, room, actions);

   }

   @Test
   public void possibleItemNamesWorks(){
      BasicGameEngine basicGameEngine = oneRoomOneAction();
      List<String> itemNames = basicGameEngine.possibleItemNames();
      assertEquals(List.of("apple", "banana", "orange"), itemNames);
   }

   @Test
   public void validatePreconditionAfterProgressStory(){
      BasicGameEngine basicGameEngine = oneRoomOneAction();
      ActionFormat actionFormat = new ActionFormat("eat");
      ConcreteGameAction concreteGameAction = new ConcreteGameAction(actionFormat, List.of("apple"));
      basicGameEngine.progressStory(concreteGameAction);
      Map<String, String> postState = new HashMap<>();
      postState.put("random-state", "very-good");
      postState.put("room", "place1");
      boolean validPrecond = basicGameEngine.validatePrecondition(postState);
      assert(validPrecond);
   }

}