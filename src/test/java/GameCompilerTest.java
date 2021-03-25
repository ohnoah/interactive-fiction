import static org.junit.Assert.*;


import com.intfic.game.enhanced.EnhancedGameDesignAction;
import com.intfic.game.enhanced.EnhancedGameEngine;
import com.intfic.game.enhanced.gamebuilder.compiler.GameCompiler;
import com.intfic.game.enhanced.reasoning.error.KnowledgeException;
import com.intfic.game.enhanced.reasoning.frames.GenericFrame;
import com.intfic.game.enhanced.reasoning.updates.KnowledgeUpdate;
import com.intfic.game.enhanced.reasoning.wrappers.Condition;
import com.intfic.game.shared.ActionFormat;
import com.intfic.game.shared.InstantiatedGameAction;
import com.intfic.game.shared.Item;
import com.intfic.game.shared.Room;
import gherkin.lexer.Kn;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.Test;

public class GameCompilerTest {

   private static EnhancedGameEngine makeTestGrammarEngine() throws KnowledgeException {
      EnhancedGameEngine enhancedGameEngine = new EnhancedGameEngine();
      Room room = new Room("first room");


      Item apple = new Item("apple", Set.of("sour", "green"), Set.of("green fruit"));
      Item apple2 = new Item("apple");
      Item banana = new Item("banana", Set.of(), Set.of("plantain"));
      Item orange = new Item("orange");

      room.setItems(List.of(apple, apple2, banana, orange));

      enhancedGameEngine.addRoom(room);
      enhancedGameEngine.setCurrentRoom(room);
      enhancedGameEngine.setStartMessage("Welcome to the first room");


      // initial item knowledge
      // apple knowledge
      enhancedGameEngine.updateKnowledgeBaseMultiple(
          new KnowledgeUpdate("first_room.apple::randomTrait9 := \"happy\""),
          new KnowledgeUpdate("first_room.apple::preliminary := 4.0")
      );
      // banana knowledge
      enhancedGameEngine.updateKnowledgeBaseMultiple(
          new KnowledgeUpdate("first_room.banana::randomTrait9 := \"happy\"")
      );

      enhancedGameEngine.addActionFormat(new ActionFormat("move"));
      enhancedGameEngine.addActionFormat(new ActionFormat("swim", "swim (([\\w\\s]+)) in ([\\w\\s]+)$"));

      Condition appleMass = new Condition("first_room.apple::mass > 4.0",
          "The mass is not right. It is first_room.apple::mass");
      Condition itemsCond = new Condition("world::items IS []",
          "The inventory is nto right. It is world::items");
      KnowledgeUpdate appleNewMass = new KnowledgeUpdate("world::applesCollected := 5.0");
      KnowledgeUpdate appleNewVolume = new KnowledgeUpdate("first_room.apple::mass := 3.0");

      EnhancedGameDesignAction putActionOne = new EnhancedGameDesignAction(
          List.of(appleMass, itemsCond,
              new Condition("first_room.apple::isContainer",
                  "The apple is not a container. It is first_room.apple::isContainer"),
              new Condition("world::inventory IS []",
                  "The inventory is not empty")),
          "You succeeded. world::randomState is random state",
          List.of(appleNewMass, appleNewVolume, new KnowledgeUpdate("first_room.apple::isContainer := true"),
              new KnowledgeUpdate("world::randomState := 4.0"))
      );
      EnhancedGameDesignAction examineTwo = new EnhancedGameDesignAction(
          List.of(appleMass),
          "The apple is green and juicy. It is first_room.banana::randomTrait9",
          List.of()
      );

      List<Item> argumentsPut = List.of(banana, apple);
      ActionFormat put0 = enhancedGameEngine.findAction("put").get(0);
      ActionFormat put1 = enhancedGameEngine.findAction("put").get(1);

      InstantiatedGameAction iPut1 = new InstantiatedGameAction(put0, argumentsPut, true);
      InstantiatedGameAction iPut2 = new InstantiatedGameAction(put1, argumentsPut, true);
      enhancedGameEngine.addAction(room, iPut1, putActionOne);
      enhancedGameEngine.addAction(room, iPut2, putActionOne);

      List<Item> argumentsExamine = List.of(banana);
      ActionFormat examine = enhancedGameEngine.findAction("examine").get(0);
      InstantiatedGameAction iExamine = new InstantiatedGameAction(examine, argumentsExamine, true);
      enhancedGameEngine.addAction(room, iExamine, examineTwo);

      List<Item> argumentsOpenEat = List.of(banana);
      ActionFormat eat = enhancedGameEngine.findAction("eat").get(0);
      ActionFormat open = enhancedGameEngine.findAction("open").get(0);

      InstantiatedGameAction iEat = new InstantiatedGameAction(eat, argumentsOpenEat, true);
      InstantiatedGameAction iOpen = new InstantiatedGameAction(open, argumentsOpenEat, true);
      enhancedGameEngine.addAction(room, iEat, putActionOne);
      enhancedGameEngine.addAction(room, iOpen, putActionOne);

      GenericFrame gf = new GenericFrame("fruit");
      gf.addSlot("fruitiness", 4.0);
      gf.addSlot("elasticity", "high");
      enhancedGameEngine.getKnowledgeBase().addGenericFrame(gf);
      enhancedGameEngine.addParent("first_room.apple", "fruit");
      enhancedGameEngine.addParent("first_room.apple", "container");
      enhancedGameEngine.addParent("first_room.banana", "fruit");


      enhancedGameEngine.updateKnowledgeBaseMultiple(
          new KnowledgeUpdate("first_room.banana::mass := 1000"),
          new KnowledgeUpdate("first_room.apple::name := \"apple\"")
      );

      return enhancedGameEngine;

   }

   @Test
   public void compileTestGrammar() throws IOException, KnowledgeException {
      EnhancedGameEngine txtEngine = GameCompiler.compile(Path.of("test-grammar.txt"));
      EnhancedGameEngine codeEngine = makeTestGrammarEngine();
      System.out.println(txtEngine);
      assertTrue(txtEngine.globalItems().containsKey("first_room.apple"));
      assertEquals(codeEngine, txtEngine);
   }
}