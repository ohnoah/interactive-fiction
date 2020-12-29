import static org.junit.Assert.*;


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

   private static EnhancedNLPEngine enhancedNLPEngine;

   @BeforeClass
   public static void setUp() throws Exception {
      System.out.println("Setting it up!");
      enhancedNLPEngine = new EnhancedNLPEngine();
   }

   @Rule
   public ExpectedException exceptionRule = ExpectedException.none();
   // Test helpers
   @Test
   public void findVerbFindsUnaryEat() throws JWNLException, FailedParseException {
      CoreDocument document = coreDocumentFromText("eat pizza");
      assertEquals("eat", enhancedNLPEngine.findVerb(document));
   }

   public CoreDocument coreDocumentFromText(String rawCommand) {
      return enhancedNLPEngine.generateCoreDocumentFromString(rawCommand, "tokenize,ssplit,pos");

   }

   @Test
   public void findNounsFindsUnaryNoun() throws JWNLException, FailedParseException {
      ActionFormat actionFormat = new ActionFormat("open", null);
      List<String> doorArr = List.of("door");
      CoreDocument document = coreDocumentFromText("open door");
      List<String> nouns = new ArrayList<>();
      List<Set<String>> adjectives = new ArrayList<>();
      enhancedNLPEngine.findNounsAndAdjectives(document, actionFormat, nouns, adjectives);
      assertEquals(doorArr, nouns);
   }

   @Test
   public void findNounsFindsUnaryDefiniteNoun() throws JWNLException, FailedParseException {
      ActionFormat actionFormat = new ActionFormat("examine", null);
      List<String> breadArr = List.of("bread");
      CoreDocument document = coreDocumentFromText("examine the bread");
      List<String> nouns = new ArrayList<>();
      List<Set<String>> adjectives = new ArrayList<>();
      enhancedNLPEngine.findNounsAndAdjectives(document, actionFormat, nouns, adjectives);
      assertEquals(breadArr, nouns);
   }

   @Test
   public void findNounsFindsTernaryNouns() throws JWNLException, FailedParseException {
      ActionFormat actionFormat = new ActionFormat("throw", "throw ([\\w\\s]+) in ([\\w\\s]+)$");
      List<String> keyBoxArr = List.of("ball", "container");
      CoreDocument document = coreDocumentFromText("throw ball in container");
      List<String> nouns = new ArrayList<>();
      List<Set<String>> adjectives = new ArrayList<>();
      enhancedNLPEngine.findNounsAndAdjectives(document, actionFormat, nouns, adjectives);
      assertEquals(keyBoxArr, nouns);
   }

   @Test
   public void findNounsFindsTernaryDefiniteNouns() throws JWNLException, FailedParseException {
      ActionFormat actionFormat = new ActionFormat("put", "put ([\\w\\s]+) in ([\\w\\s]+)$");
      List<String> keyBoxArr = List.of("key", "box");
      CoreDocument document = coreDocumentFromText("put the key in the box");
      List<String> nouns = new ArrayList<>();
      List<Set<String>> adjectives = new ArrayList<>();
      enhancedNLPEngine.findNounsAndAdjectives(document, actionFormat, nouns, adjectives);
      assertEquals(nouns, keyBoxArr);
   }

   @Test
   public void findNounsFindsUnarySingleAdjective() throws JWNLException, FailedParseException {
      ActionFormat actionFormat = new ActionFormat("examine", null);
      List<Set<String>> deliciousArr = List.of(Set.of("delicious"));
      CoreDocument document = coreDocumentFromText("examine the delicious bread");
      List<String> nouns = new ArrayList<>();
      List<Set<String>> adjectives = new ArrayList<>();
      enhancedNLPEngine.findNounsAndAdjectives(document, actionFormat, nouns, adjectives);
      assertEquals(adjectives, deliciousArr);
   }

   @Test
   public void findNounsFindsUnaryMultipleAdjectives() throws JWNLException, FailedParseException {
      ActionFormat actionFormat = new ActionFormat("examine", null);
      List<Set<String>> deliciousArr = List.of(Set.of("delicious", "yellow"));
      CoreDocument document = coreDocumentFromText("examine the delicious and yellow bread");
      List<String> nouns = new ArrayList<>();
      List<Set<String>> adjectives = new ArrayList<>();
      enhancedNLPEngine.findNounsAndAdjectives(document, actionFormat, nouns, adjectives);
      assertEquals(adjectives, deliciousArr);
   }

   @Test
   public void findNounsFindsTernarySingleAdjective() throws JWNLException, FailedParseException {
      ActionFormat actionFormat = new ActionFormat("put", "put ([\\w\\s]+) in ([\\w\\s]+)$");
      List<Set<String>> redBlackArr = List.of(Set.of("red"), Set.of("black"));
      CoreDocument document = coreDocumentFromText("put the red key in the black box");
      List<String> nouns = new ArrayList<>();
      List<Set<String>> adjectives = new ArrayList<>();
      enhancedNLPEngine.findNounsAndAdjectives(document, actionFormat, nouns, adjectives);
      assertEquals(adjectives, redBlackArr);
   }

   @Test
   public void findNounsFindsTernaryMultipleAdjectives() throws JWNLException, FailedParseException {
      ActionFormat actionFormat = new ActionFormat("put", "put ([\\w\\s]+) in ([\\w\\s]+)$");
      List<Set<String>> multiAdjArr = List.of(Set.of("larger", "red"), Set.of("cutest", "blue"));
      CoreDocument document = coreDocumentFromText("put the larger red key in the cutest blue box");
      List<String> nouns = new ArrayList<>();
      List<Set<String>> adjectives = new ArrayList<>();
      enhancedNLPEngine.findNounsAndAdjectives(document, actionFormat, nouns, adjectives);
      assertEquals(multiAdjArr, adjectives);
   }



   @Test
   public void whenNoMatchingGameVerbThrowFailedParseException() throws FailedParseException {
      exceptionRule.expect(FailedParseException.class);
      exceptionRule.expectMessage("No matching game verb");
      List<ActionFormat> possibleActionFormats = new ArrayList<ActionFormat>();
      possibleActionFormats.add(new ActionFormat("ski", null));
      possibleActionFormats.add(new ActionFormat("fly", null));
      InstantiatedGameAction instantiatedGameAction = enhancedNLPEngine.parse(String.format("eat steak"), possibleActionFormats, new HashSet<>());

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
          enhancedNLPEngine.parse(String.format("%s the %s with grace", verb, noun), possibleActionFormats, Set.of(dog));
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
          enhancedNLPEngine.parse(String.format("%s the %s with grace", verb, noun), possibleActionFormats, Set.of(door));
      List<String> wantedArr = List.of(noun);
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
          enhancedNLPEngine.parse(String.format("%s the %s with grace", verb, noun), possibleActionFormats, Set.of(cave));
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
          enhancedNLPEngine.parse(String.format("%s the %s with grace", verb, noun), possibleActionFormats, Set.of(cave));
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
      List<String> foundItemNames = enhancedNLPEngine.findMatchingGameItemNames(nouns, adjectives, gameItems);

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
      List<String> foundItemNames = enhancedNLPEngine.findMatchingGameItemNames(nouns, adjectives, gameItems);
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
      List<String> foundItemNames = enhancedNLPEngine.findMatchingGameItemNames(nouns, adjectives, gameItems);
   }

   // TODO: Test failing with adjectives etc

}

