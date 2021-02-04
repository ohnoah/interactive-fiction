import static org.junit.Assert.*;


import com.intfic.game.enhanced.EnhancedGameEngine;
import com.intfic.nlp.EnhancedNLPEngine;
import com.intfic.nlp.FailedParseException;
import com.intfic.game.shared.ActionFormat;
import com.intfic.game.shared.InstantiatedGameAction;
import com.intfic.game.shared.Item;
import edu.stanford.nlp.pipeline.CoreDocument;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import net.sf.extjwnl.JWNLException;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class EnhancedNLPEngineTest {

   @BeforeClass
   public static void setUp() throws Exception {
      System.out.println("Setting it up!");
      List<ActionFormat> possibleActionFormats = new ArrayList<ActionFormat>();
      String verb = "open";
      String noun = "door";
      Item door = new Item("door");
      possibleActionFormats.add(new ActionFormat(verb, null));
      InstantiatedGameAction instantiatedGameAction =
       EnhancedNLPEngine.parse(String.format("%s the %s with grace", verb, noun), possibleActionFormats, Set.of(door));
   }

   @Rule
   public ExpectedException exceptionRule = ExpectedException.none();
   // Test helpers
   @Test
   public void findVerbFindsUnaryEat() throws JWNLException, FailedParseException {
      CoreDocument document = coreDocumentFromText("eat pizza");
      assertEquals("eat", EnhancedNLPEngine.findVerb(document));
   }

   public CoreDocument coreDocumentFromText(String rawCommand) {
      return EnhancedNLPEngine.generateCoreDocumentFromString(rawCommand);
   }

   @Test
   public void findNounsFindsUnaryNoun() throws JWNLException, FailedParseException {
      ActionFormat actionFormat = new ActionFormat("open", null);
      List<String> doorArr = List.of("door");
      CoreDocument document = coreDocumentFromText("open door");
      List<String> nouns = new ArrayList<>();
      List<Set<String>> adjectives = new ArrayList<>();
      EnhancedNLPEngine.findNounsAndAdjectives(document, actionFormat, nouns, adjectives);
      assertEquals(doorArr, nouns);
   }

   @Test
   public void findNounsFindsUnaryDefiniteNoun() throws JWNLException, FailedParseException {
      ActionFormat actionFormat = new ActionFormat("examine");
      List<String> breadArr = List.of("bread");
      CoreDocument document = coreDocumentFromText("examine the bread");
      List<String> nouns = new ArrayList<>();
      List<Set<String>> adjectives = new ArrayList<>();
      EnhancedNLPEngine.findNounsAndAdjectives(document, actionFormat, nouns, adjectives);
      assertEquals(breadArr, nouns);
   }

   @Test
   public void findNounsFindsTernaryNouns() throws JWNLException, FailedParseException {
      ActionFormat actionFormat = new ActionFormat("throw", "throw ([\\w\\s]+) in ([\\w\\s]+)$");
      List<String> keyBoxArr = List.of("ball", "container");
      CoreDocument document = coreDocumentFromText("throw ball in container");
      List<String> nouns = new ArrayList<>();
      List<Set<String>> adjectives = new ArrayList<>();
      EnhancedNLPEngine.findNounsAndAdjectives(document, actionFormat, nouns, adjectives);
      assertEquals(keyBoxArr, nouns);
   }

   @Test
   public void findNounsFindsTernaryDefiniteNouns() throws JWNLException, FailedParseException {
      ActionFormat actionFormat = new ActionFormat("put", "put ([\\w\\s]+) in ([\\w\\s]+)$");
      List<String> keyBoxArr = List.of("key", "box");
      CoreDocument document = coreDocumentFromText("put the key in the box");
      List<String> nouns = new ArrayList<>();
      List<Set<String>> adjectives = new ArrayList<>();
      EnhancedNLPEngine.findNounsAndAdjectives(document, actionFormat, nouns, adjectives);
      assertEquals(nouns, keyBoxArr);
   }

   @Test
   public void findNounsFindsUnarySingleAdjective() throws JWNLException, FailedParseException {
      ActionFormat actionFormat = new ActionFormat("examine", null);
      List<Set<String>> deliciousArr = List.of(Set.of("delicious"));
      CoreDocument document = coreDocumentFromText("examine the delicious bread");
      List<String> nouns = new ArrayList<>();
      List<Set<String>> adjectives = new ArrayList<>();
      EnhancedNLPEngine.findNounsAndAdjectives(document, actionFormat, nouns, adjectives);
      assertEquals(adjectives, deliciousArr);
   }

   @Test
   public void findNounsFindsUnaryMultipleAdjectives() throws JWNLException, FailedParseException {
      ActionFormat actionFormat = new ActionFormat("examine", null);
      List<Set<String>> deliciousArr = List.of(Set.of("delicious", "yellow"));
      CoreDocument document = coreDocumentFromText("examine the delicious and yellow bread.");
      List<String> nouns = new ArrayList<>();
      List<Set<String>> adjectives = new ArrayList<>();
      EnhancedNLPEngine.findNounsAndAdjectives(document, actionFormat, nouns, adjectives);
      assertEquals(adjectives, deliciousArr);
   }

   @Test
   public void findNounsFindsTernarySingleAdjective() throws JWNLException, FailedParseException {
      ActionFormat actionFormat = new ActionFormat("put", "put ([\\w\\s]+) in ([\\w\\s]+)$");
      List<Set<String>> redBlackArr = List.of(Set.of("red"), Set.of("black"));
      CoreDocument document = coreDocumentFromText("put the red key in the black box");
      List<String> nouns = new ArrayList<>();
      List<Set<String>> adjectives = new ArrayList<>();
      EnhancedNLPEngine.findNounsAndAdjectives(document, actionFormat, nouns, adjectives);
      assertEquals(adjectives, redBlackArr);
   }

   @Test
   public void findNounsFindsTernaryMultipleAdjectives() throws JWNLException, FailedParseException {
      ActionFormat actionFormat = new ActionFormat("put", "put ([\\w\\s]+) in ([\\w\\s]+)$");
      List<Set<String>> multiAdjArr = List.of(Set.of("larger", "red"), Set.of("cutest", "blue"));
      CoreDocument document = coreDocumentFromText("put the larger red key in the cutest blue box");
      List<String> nouns = new ArrayList<>();
      List<Set<String>> adjectives = new ArrayList<>();
      EnhancedNLPEngine.findNounsAndAdjectives(document, actionFormat, nouns, adjectives);
      assertEquals(multiAdjArr, adjectives);
   }



   @Test
   public void whenNoMatchingGameVerbThrowFailedParseException() throws FailedParseException {
      exceptionRule.expect(FailedParseException.class);
      exceptionRule.expectMessage("No action corresponds to the verb: eat");
      List<ActionFormat> possibleActionFormats = new ArrayList<ActionFormat>();
      possibleActionFormats.add(new ActionFormat("ski", null));
      possibleActionFormats.add(new ActionFormat("fly", null));
      InstantiatedGameAction instantiatedGameAction = EnhancedNLPEngine.parse(String.format("eat steak"), possibleActionFormats, new HashSet<>());

   }
   // TODO: Check other exceptions here

   @Test
   public void parseVerbSimpleTwoWords() throws FailedParseException {
      // take dog
      List<ActionFormat> possibleActionFormats = new ArrayList<ActionFormat>();
      String verb = "take";
      String noun = "dog";
      Item dog = new Item("dog");
      possibleActionFormats.add(new ActionFormat(verb, null));
      possibleActionFormats.add(new ActionFormat("fly", null));
      InstantiatedGameAction instantiatedGameAction =
          EnhancedNLPEngine.parse(String.format("%s the %s with grace", verb, noun), possibleActionFormats, Set.of(dog));
      ActionFormat abstractAF = instantiatedGameAction.getAbstractActionFormat();
      String outVerb = abstractAF.getVerb();
      assertEquals(verb, outVerb);
   }
   @Test
   public void parseListenToRegex() throws FailedParseException {
      // take dog
      List<ActionFormat> possibleActionFormats = new ArrayList<ActionFormat>();
      String verb = "listen";
      String noun = "dog";
      Item dog = new Item("dog");
      possibleActionFormats.add(new ActionFormat("listen", "listen to ([\\w\\s]+)$"));
      possibleActionFormats.add(new ActionFormat("fly", null));
      InstantiatedGameAction instantiatedGameAction =
          EnhancedNLPEngine.parse(String.format("%s to the %s", verb, noun), possibleActionFormats, Set.of(dog));
      ActionFormat abstractAF = instantiatedGameAction.getAbstractActionFormat();
      String outVerb = abstractAF.getVerb();
      assertEquals(verb, outVerb);
   }

   @Test
   public void parseNounWithDefiniteArticle() throws FailedParseException {
      // open the door
      List<ActionFormat> possibleActionFormats = new ArrayList<ActionFormat>();
      String verb = "open";
      String noun = "door";
      Item door = new Item("door");
      possibleActionFormats.add(new ActionFormat(verb, null));
      InstantiatedGameAction instantiatedGameAction =
          EnhancedNLPEngine.parse(String.format("%s the %s with grace", verb, noun), possibleActionFormats, Set.of(door));
      List<String> wantedArr = List.of(noun);
      List<String> outArguments = instantiatedGameAction.getArguments();
      assertEquals(wantedArr, outArguments);
   }


   @Test
   public void parsePutSpaceNoun() throws FailedParseException {
      // open the door
      List<ActionFormat> possibleActionFormats = new ArrayList<>();
      String verb = "put";
      String noun1 = "pen";
      String noun2 = "box";
      Item pen = new Item("pen");
      Item smallBox = new Item("box");
      possibleActionFormats.add((new EnhancedGameEngine()).findAction("put").get(0));
      // Get current size of heap in bytes
      long heapSize = Runtime.getRuntime().totalMemory();
      System.out.println(heapSize);

      // Get maximum size of heap in bytes. The heap cannot grow beyond this size.// Any attempt will result in an OutOfMemoryException.
      long heapMaxSize = Runtime.getRuntime().maxMemory();
      System.out.println(heapMaxSize);
      InstantiatedGameAction instantiatedGameAction =
          EnhancedNLPEngine.parse(String.format("%s the %s in the %s", verb, noun1, noun2), possibleActionFormats, Set.of(pen, smallBox));
      List<String> wantedArr = List.of(noun1, noun2);
      List<String> outArguments = instantiatedGameAction.getArguments();
      assertEquals(wantedArr, outArguments);
   }

   @Test
   public void parseVerbSimpleWithExtraStuffAfter() throws FailedParseException {
      // Maybe destroy the cave with grace
      List<ActionFormat> possibleActionFormats = new ArrayList<ActionFormat>();
      String verb = "destroy";
      String noun = "cave";
      Item cave = new Item("cave");
      possibleActionFormats.add(new ActionFormat(verb, null));
      InstantiatedGameAction instantiatedGameAction =
          EnhancedNLPEngine.parse(String.format("%s the %s with grace", verb, noun), possibleActionFormats, Set.of(cave));
      ActionFormat abstractAF = instantiatedGameAction.getAbstractActionFormat();
      String outVerb = abstractAF.getVerb();
      assertEquals(verb, outVerb);
   }

   @Test
   public void parseNounSimpleWithExtraStuffAfter() throws FailedParseException {
      // Maybe destroy the cave with grace
      List<ActionFormat> possibleActionFormats = new ArrayList<ActionFormat>();
      String verb = "destroy";
      String noun = "cave";
      Item cave = new Item("cave");
      possibleActionFormats.add(new ActionFormat(verb, null));
      InstantiatedGameAction instantiatedGameAction =
          EnhancedNLPEngine.parse(String.format("%s the %s with grace", verb, noun), possibleActionFormats, Set.of(cave));
      List<String> wantedArr = List.of(noun);
      List<String> outArguments = instantiatedGameAction.getArguments();
      assertEquals(wantedArr, outArguments);
   }

   // TODO: Test findMatchingGameItemNames
   @Test
   public void findMatchingGameItemNamesNoSynonyms() throws FailedParseException {
      List<String> nouns = List.of("bear", "panda", "grizzly bear");
      List<Set<String>> adjectives = List.of(Set.of("furry", "kind"), Set.of(), Set.of("funny"));
      Set<Item> gameItems = Set.of(
          new Item("bear", Set.of("furry", "kind", "hilarious", "funny")),
          new Item("panda"),
          new Item("grizzly bear", Set.of("funny", "boring", "interesting"))
      );
      List<String> foundItemNames = EnhancedNLPEngine.findMatchingGameItemNames(nouns, adjectives, gameItems);

      assertEquals(List.of("bear", "panda", "grizzly bear"), foundItemNames);
   }

   // TODO: Test findMatchingGameItemNames
   @Test
   public void findMatchingGameItemNamesFailsTooManyAdjectives() throws FailedParseException {
      exceptionRule.expect(FailedParseException.class);
      exceptionRule.expectMessage("There is no orange,yellow grizzly bear in your environment.");
      List<String> nouns = List.of("bear", "panda", "grizzly bear");
      List<Set<String>> adjectives = List.of(Set.of("furry", "kind"), Set.of(), Set.of("funny", "orange", "yellow"));
      Set<Item> gameItems = Set.of(
          new Item("bear", Set.of("furry", "kind", "hilarious", "funny")),
          new Item("panda"),
          new Item("grizzly bear", Set.of("funny", "boring", "interesting"))
      );
      List<String> foundItemNames = EnhancedNLPEngine.findMatchingGameItemNames(nouns, adjectives, gameItems);
   }

   // TODO: Test findMatchingGameItemNames
   @Test
   public void findMatchingGameItemNamesFailsWrongNoun() throws FailedParseException {
      exceptionRule.expect(FailedParseException.class);
      exceptionRule.expectMessage("There is no paparrazi in your environment.");
      List<String> nouns = List.of("paparrazi", "panda", "grizzly bear");
      List<Set<String>> adjectives = List.of(Set.of("furry", "kind"), Set.of(), Set.of("funny"));
      Set<Item> gameItems = Set.of(
          new Item("kangaroo", Set.of("furry", "kind", "hilarious", "funny")),
          new Item("panda"),
          new Item("grizzly bear", Set.of("funny", "boring", "interesting"))
      );
      List<String> foundItemNames = EnhancedNLPEngine.findMatchingGameItemNames(nouns, adjectives, gameItems);
   }

   // TODO: Test failing with adjectives etc

}

