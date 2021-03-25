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
      Item apple = new Item("apple", Set.of("sour", "green"), Set.of("green fruit"));
      Item apple2 = new Item("apple");
      Item banana = new Item("apple", Set.of(), Set.of("plantain"));

      Room room = new Room("first room");
      room.setItems(List.of(apple, apple2, banana));

      // initial item knowledge
      // apple knowledge
      enhancedGameEngine.updateKnowledgeBaseMultiple(
          new KnowledgeUpdate("apple::randomTrait9 := \"happy\""),
          new KnowledgeUpdate("first_room.apple::preliminary := 4.0")
      );
      // banana knowledge
      enhancedGameEngine.updateKnowledgeBaseMultiple(
          new KnowledgeUpdate("banana::randomTrait9 := \"happy\"")
      );


      Condition appleMass = new Condition("apple::mass > 4.0", "The mass is not right. It is apple::mass");
      Condition itemsCond = new Condition("world::items IS []", "The inventory is nto right. It is world::items");
      KnowledgeUpdate appleNewMass = new KnowledgeUpdate("world::applesCollected := 5.0");
      KnowledgeUpdate appleNewVolume = new KnowledgeUpdate("apple::mass := 3.0");

      EnhancedGameDesignAction putActionOne = new EnhancedGameDesignAction(
          List.of(appleMass, itemsCond,
              new Condition("apple::isContainer",
                  "The apple is not a container. It is apple::isContainer"),
              new Condition("world::inventory IS []",
                  "The inventory is not empty")),
          "You succeeded. world::randomState is random state.",
          List.of(appleNewMass, appleNewVolume, new KnowledgeUpdate("apple::isContainer := true"),
              new KnowledgeUpdate("world::randomState := 4.0"))
      );
      EnhancedGameDesignAction examineTwo = new EnhancedGameDesignAction(
          List.of(appleMass),
          "The apple is green and juicy. It is banana::randomTrait9",
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

      GenericFrame gf = new GenericFrame("fruit");
      gf.addSlot("fruitiness", "4.0");
      gf.addSlot("elasticity", "high");
      enhancedGameEngine.addParent("first_room.apple", "fruit");
      enhancedGameEngine.addParent("first_room.apple", "container");
      enhancedGameEngine.addParent("first_room.banana", "fruit");

   }

   @Test
   public void compileTestGrammar() throws IOException {
      EnhancedGameEngine enhancedGameEngine = GameCompiler.compile(Path.of("test-grammar.txt"));
      System.out.println(enhancedGameEngine);
      assertTrue(enhancedGameEngine.globalItems().containsKey("first_room.apple"));
   }
}