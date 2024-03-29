import static org.junit.Assert.*;


import com.intfic.game.enhanced.EnhancedGameEngine;
import com.intfic.game.shared.Item;
import com.intfic.game.shared.Util;
import com.intfic.nlp.BasicParser;
import com.intfic.nlp.FailedParseException;
import com.intfic.game.shared.ActionFormat;
import com.intfic.game.shared.InstantiatedGameAction;
import edu.stanford.nlp.util.Pair;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import net.sf.extjwnl.JWNLException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class BasicParserTest {

   @Rule
   public ExpectedException exceptionRule = ExpectedException.none();

   // Test helpers
   @Test
   public void findVerbFindsUnaryEat() throws FailedParseException, JWNLException {
      assertEquals("eat", BasicParser.findVerb("eat pizza"));
   }


   @Test
   public void findNounsFindsUnaryNoun() throws FailedParseException, JWNLException {
      ActionFormat actionFormat = new ActionFormat("open", null);
      List<String> doorArr = List.of("door");
      List<String> nouns = new ArrayList<>();
      List<Set<String>> adjectives = new ArrayList<>();
      List<Pair<Integer, Integer>> nps = List.of(new Pair<>(1, 1));
      BasicParser.findNounsAndAdjectives("open door", actionFormat, nouns, adjectives, new HashSet<>());
      assertEquals(doorArr, nouns);
   }

   @Test
   public void findNounsWithNoValidNounFails() throws FailedParseException, JWNLException {
      exceptionRule.expect(FailedParseException.class);
      exceptionRule.expectMessage("Expected last word to be a noun but was: eat");
      ActionFormat actionFormat = new ActionFormat("examine", null);
      List<String> doorArr = List.of("door");
      List<String> nouns = new ArrayList<>();
      List<Set<String>> adjectives = new ArrayList<>();
      List<Pair<Integer, Integer>> nps = List.of(new Pair<>(1, 1));
      BasicParser.findNounsAndAdjectives("examine eat", actionFormat, nouns, adjectives, new HashSet<>());
   }


/*
   @Test
   public void findNounsItSuceeds() throws FailedParseException {
      ActionFormat actionFormat = new ActionFormat("examine", null);
      List<String> doorArr = List.of("door");
      CoreDocument document = coreDocumentFromText("examine it.");
      List<String> nouns = new ArrayList<>();
      List<Set<String>> adjectives = new ArrayList<>();
      List<Pair<Integer, Integer>> nps = List.of(new Pair<>(1, 1));
      BasicParser.findNounsAndAdjectives(document.sentences().get(0), 0, 1, nps, actionFormat, nouns, adjectives, new HashMap<>(), new HashMap<>(), new Pair<>(new HashSet<>(), "door"));
      assertEquals(doorArr, nouns);
      assertEquals(0, adjectives.size());
   }
*/


   private void findNounsAndAdjectivesTest(String rawCommand, ActionFormat actionFormat, List<String> nouns, List<Set<String>> adjectives) throws JWNLException, FailedParseException {
      BasicParser.findNounsAndAdjectives(rawCommand, actionFormat, nouns, adjectives, new HashSet<>());
   }

   @Test
   public void findNounsFindsUnaryDefiniteNoun() throws FailedParseException, JWNLException {
      ActionFormat actionFormat = new ActionFormat("examine");
      List<String> breadArr = List.of("bread");
      List<String> nouns = new ArrayList<>();
      List<Set<String>> adjectives = new ArrayList<>();
      String rawCommand = "examine the bread";
      findNounsAndAdjectivesTest(rawCommand, actionFormat, nouns, adjectives);
      assertEquals(breadArr, nouns);
   }

   @Test
   public void findNounsFindsTernaryNouns() throws FailedParseException, JWNLException {
      ActionFormat actionFormat = new ActionFormat("throw", "throw ([\\w\\s]+) in ([\\w\\s]+)$");
      List<String> keyBoxArr = List.of("ball", "container");
      List<String> nouns = new ArrayList<>();
      List<Set<String>> adjectives = new ArrayList<>();
      findNounsAndAdjectivesTest("throw ball in container", actionFormat, nouns, adjectives);
      assertEquals(keyBoxArr, nouns);
   }

   @Test
   public void findNounsFindsTernaryDefiniteNouns() throws FailedParseException, JWNLException {
      ActionFormat actionFormat = new ActionFormat("put", "put ([\\w\\s]+) in ([\\w\\s]+)$");
      List<String> keyBoxArr = List.of("key", "box");
      List<String> nouns = new ArrayList<>();
      List<Set<String>> adjectives = new ArrayList<>();
      findNounsAndAdjectivesTest("put the key in the box", actionFormat, nouns, adjectives);
      assertEquals(keyBoxArr, nouns);
   }

   @Test
   public void findNounsFindsUnarySingleAdjective() throws FailedParseException, JWNLException {
      ActionFormat actionFormat = new ActionFormat("examine", null);
      List<Set<String>> deliciousArr = List.of(Set.of("delicious"));
      List<String> nouns = new ArrayList<>();
      List<Set<String>> adjectives = new ArrayList<>();
      findNounsAndAdjectivesTest("examine the delicious bread", actionFormat, nouns, adjectives);
      assertEquals(deliciousArr, adjectives);
   }

   @Test
   public void findNounsFindsUnaryMultipleAdjectives() throws FailedParseException, JWNLException {
      ActionFormat actionFormat = new ActionFormat("examine", null);
      List<Set<String>> deliciousArr = List.of(Set.of("delicious", "yellow"));
      List<String> nouns = new ArrayList<>();
      List<Set<String>> adjectives = new ArrayList<>();
      findNounsAndAdjectivesTest("examine the delicious and yellow loaf.", actionFormat, nouns, adjectives);
      assertEquals(deliciousArr, adjectives);
   }

   @Test
   public void findNounsFindsTernarySingleAdjective() throws FailedParseException, JWNLException {
      ActionFormat actionFormat = new ActionFormat("put", "put ([\\w\\s]+) in ([\\w\\s]+)$");
      List<Set<String>> redBlackArr = List.of(Set.of("red"), Set.of("black"));
      List<String> nouns = new ArrayList<>();
      List<Set<String>> adjectives = new ArrayList<>();
      findNounsAndAdjectivesTest("put the red key in the black box", actionFormat, nouns, adjectives);
      assertEquals(List.of("key", "box"), nouns);
      assertEquals(redBlackArr, adjectives);
   }

   @Test
   public void findNounsFindsTernaryMultipleAdjectives() throws FailedParseException, JWNLException {
      ActionFormat actionFormat = new ActionFormat("put", "put ([\\w\\s]+) in ([\\w\\s]+)$");
      List<Set<String>> multiAdjArr = List.of(Set.of("larger", "red"), Set.of("cute", "blue"));
      List<String> nouns = new ArrayList<>();
      List<Set<String>> adjectives = new ArrayList<>();
      findNounsAndAdjectivesTest("put the larger red key in the cute blue box", actionFormat, nouns, adjectives);
      assertEquals(multiAdjArr, adjectives);
   }


   @Test
   public void whenNoMatchingGameVerbThrowFailedParseException() throws FailedParseException {
      exceptionRule.expect(FailedParseException.class);
      exceptionRule.expectMessage("No action corresponds to the verb: eat");
      List<ActionFormat> possibleActionFormats = new ArrayList<>();
      possibleActionFormats.add(new ActionFormat("ski", null));
      possibleActionFormats.add(new ActionFormat("fly", null));
      InstantiatedGameAction instantiatedGameAction = BasicParser.parse("eat steak", possibleActionFormats, new HashSet<>()).get(0);

   }
   // TODO: Check other exceptions here




   @Test
   public void parseVerbSimpleTwoWords() throws FailedParseException {
      // take dog
      List<ActionFormat> possibleActionFormats = new ArrayList<ActionFormat>();
      String verb = "take";
      String noun = "dog";
      Item dog = TestUtil.roomItem(noun);
      possibleActionFormats.add(new ActionFormat(verb, null));
      possibleActionFormats.add(new ActionFormat("fly", null));
      List<InstantiatedGameAction> instantiatedGameActions =
          BasicParser.parse(String.format("%s the %s", verb, noun), possibleActionFormats, Set.of(dog));
      assertEquals(1, instantiatedGameActions.size());
      InstantiatedGameAction instantiatedGameAction = instantiatedGameActions.get(0);
      ActionFormat abstractAF = instantiatedGameAction.getAbstractActionFormat();
      String outVerb = abstractAF.getVerb();
      assertEquals(verb, outVerb);
   }

/*   @Test
   public void parseItDogSucceeds() throws FailedParseException {
      // take dog
      List<ActionFormat> possibleActionFormats = new ArrayList<ActionFormat>();
      String verb = "take";
      String noun = "it";
      Item dog = new Item("dog", Set.of("fluffy", "hairy"));
      possibleActionFormats.add(new ActionFormat(verb, null));
      possibleActionFormats.add(new ActionFormat("fly", null));
      List<InstantiatedGameAction> instantiatedGameActions =
          BasicParser.parse(String.format("%s %s", verb, noun), possibleActionFormats, Set.of(dog), new Pair<>(dog.getAdjectives(), dog.getName()));
      assertEquals(1, instantiatedGameActions.size());
      InstantiatedGameAction instantiatedGameAction = instantiatedGameActions.get(0);
      ActionFormat abstractAF = instantiatedGameAction.getAbstractActionFormat();
      String outVerb = abstractAF.getVerb();
      assertEquals(verb, outVerb);
      assertEquals(dog, instantiatedGameAction.getArguments().get(0));
   }*/

   @Test
   public void parseItOtherActionSucceeds() throws FailedParseException {
      // take dog
      List<ActionFormat> possibleActionFormats = new ArrayList<ActionFormat>();
      String verb = "take";
      String noun = "dog";
      Item dog = TestUtil.roomItem("dog", Set.of("fluffy", "hairy"));
      possibleActionFormats.add(new ActionFormat(verb, null));
      possibleActionFormats.add(new ActionFormat("fly", null));
      List<InstantiatedGameAction> instantiatedGameActions =
          BasicParser.parse(String.format("%s the fluffy %s", verb, noun), possibleActionFormats, Set.of(dog, TestUtil.roomItem("door")));
      assertEquals(1, instantiatedGameActions.size());
      InstantiatedGameAction instantiatedGameAction = instantiatedGameActions.get(0);
      ActionFormat abstractAF = instantiatedGameAction.getAbstractActionFormat();
      String outVerb = abstractAF.getVerb();
      assertEquals(verb, outVerb);
      assertEquals(dog, Util.flatten(instantiatedGameAction.getPotentialArguments()).get(0));
   }

   @Test
   public void parseListenToRegex() throws FailedParseException {
      // take dog
      List<ActionFormat> possibleActionFormats = new ArrayList<ActionFormat>();
      String verb = "listen";
      String noun = "dog";
      Item dog = TestUtil.roomItem("dog");
      possibleActionFormats.add(new ActionFormat("listen", "listen to ([\\w\\s]+)$"));
      possibleActionFormats.add(new ActionFormat("fly", null));
      List<InstantiatedGameAction> instantiatedGameActions =
          BasicParser.parse(String.format("%s to the %s", verb, noun), possibleActionFormats, Set.of(dog));
      assertEquals(1, instantiatedGameActions.size());
      InstantiatedGameAction instantiatedGameAction = instantiatedGameActions.get(0);
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
      Item door = TestUtil.roomItem(noun);
      possibleActionFormats.add(new ActionFormat(verb, null));
      List<InstantiatedGameAction> instantiatedGameActions =
          BasicParser.parse(String.format("%s the %s", verb, noun), possibleActionFormats, Set.of(door));
      assertEquals(1, instantiatedGameActions.size());
      InstantiatedGameAction instantiatedGameAction = instantiatedGameActions.get(0);
      List<Item> wantedArr = List.of(door);
      List<Item> outArguments = Util.flatten(instantiatedGameAction.getPotentialArguments());
      assertEquals(wantedArr, outArguments);
   }

   private void printHeapSize() {
      // Get current size of heap in bytes
      long heapSize = Runtime.getRuntime().totalMemory();
      System.out.println(heapSize);

      // Get maximum size of heap in bytes. The heap cannot grow beyond this size.// Any attempt will result in an OutOfMemoryException.
      long heapMaxSize = Runtime.getRuntime().maxMemory();
      System.out.println(heapMaxSize);
   }

   @Test
   public void parsePutSpaceNoun() throws FailedParseException {
      // open the door
      List<ActionFormat> possibleActionFormats = new ArrayList<>();
      String verb = "put";
      String noun1 = "pen";
      String noun2 = "box";
      Item pen = TestUtil.roomItem("pen");
      Item smallBox = TestUtil.roomItem("box");
      possibleActionFormats.add((new EnhancedGameEngine()).findAction("put").get(0));

      printHeapSize();

      List<InstantiatedGameAction> instantiatedGameActions =
          BasicParser.parse(String.format("%s the %s in the %s", verb, noun1, noun2), possibleActionFormats, Set.of(pen, smallBox));
      assertEquals(1, instantiatedGameActions.size());
      InstantiatedGameAction instantiatedGameAction = instantiatedGameActions.get(0);
      List<Item> wantedArr = List.of(pen, smallBox);
      List<Item> outArguments = Util.flatten(instantiatedGameAction.getPotentialArguments());
      assertEquals(wantedArr, outArguments);
   }

/*   @Test
   public void parseItActionVerb() throws FailedParseException {
      // Maybe destroy the cave with grace
      List<ActionFormat> possibleActionFormats = new ArrayList<ActionFormat>();
      String verb = "destroy";
      String noun = "cave";
      Item cave = TestUtil.roomItem("cave");
      possibleActionFormats.add(new ActionFormat(verb, null));
      List<InstantiatedGameAction> instantiatedGameActions =
          BasicParser.parse(String.format("%s it", verb), possibleActionFormats, Set.of(cave));
      assertEquals(1, instantiatedGameActions.size());
      InstantiatedGameAction instantiatedGameAction = instantiatedGameActions.get(0);
      ActionFormat abstractAF = instantiatedGameAction.getAbstractActionFormat();
      String outVerb = abstractAF.getVerb();
      assertEquals(verb, outVerb);
   }*/

   @Test
   public void parseVerbSimpleWithExtraStuffAfter() throws FailedParseException {
      // Maybe destroy the cave with grace
      List<ActionFormat> possibleActionFormats = new ArrayList<ActionFormat>();
      String verb = "destroy";
      String noun = "cave";
      Item cave = TestUtil.roomItem(noun);
      possibleActionFormats.add(new ActionFormat(verb, null));
      List<InstantiatedGameAction> instantiatedGameActions =
          BasicParser.parse(String.format("%s the %s", verb, noun), possibleActionFormats, Set.of(cave));
      assertEquals(1, instantiatedGameActions.size());
      InstantiatedGameAction instantiatedGameAction = instantiatedGameActions.get(0);
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
      Item cave = TestUtil.roomItem(noun);
      possibleActionFormats.add(new ActionFormat(verb, null));
      List<InstantiatedGameAction> instantiatedGameActions =
          BasicParser.parse(String.format("%s the %s", verb, noun), possibleActionFormats, Set.of(cave));
      assertEquals(1, instantiatedGameActions.size());
      List<Item> wantedArr = List.of(cave);
      InstantiatedGameAction instantiatedGameAction = instantiatedGameActions.get(0);
      List<Item> outArguments = Util.flatten(instantiatedGameAction.getPotentialArguments());
      assertEquals(wantedArr, outArguments);
   }







   // TODO: Test findMatchingGameItemNames
   @Test
   public void findMatchingGameItemNamesNoSynonyms() throws FailedParseException {
      List<String> nouns = List.of("bear", "panda", "owl");
      List<Set<String>> adjectives = List.of(Set.of("furry", "kind"), Set.of(), Set.of("funny"));
      Item bear = TestUtil.roomItem("bear", Set.of("furry", "kind", "hilarious", "funny"));
      Item panda = TestUtil.roomItem("panda");
      Item owl = TestUtil.roomItem("owl", Set.of("funny", "boring", "interesting"));
      Set<Item> gameItems = Set.of(
          bear, panda, owl
      );
      List<Item> foundItemNames = Util.flatten(BasicParser.findMatchingGameItems(nouns, adjectives, gameItems));
      assertEquals(List.of(bear, panda, owl),foundItemNames);

   }

   // TODO: Test findMatchingGameItemNames
   @Test
   public void findMatchingGameItemNamesFailsTooManyAdjectives() throws FailedParseException {
      exceptionRule.expect(FailedParseException.class);
      exceptionRule.expectMessage("I couldn't find a funny,orange,yellow grizzly bear in your environment.");
      List<String> nouns = List.of("bear", "panda", "grizzly bear");
      List<Set<String>> adjectives = List.of(Set.of("furry", "kind"), Set.of(), Set.of("funny", "orange", "yellow"));
      Set<Item> gameItems = Set.of(
          TestUtil.roomItem("bear", Set.of("furry", "kind", "hilarious", "funny")),
          TestUtil.roomItem("panda"),
          TestUtil.roomItem("grizzly bear", Set.of("funny", "boring", "interesting"))
      );
      List<Item> foundItemNames = Util.flatten(BasicParser.findMatchingGameItems(nouns, adjectives, gameItems));
   }

   // TODO: Test findMatchingGameItemNames
   @Test
   public void findMatchingGameItemNamesFailsWrongNoun() throws FailedParseException {
      exceptionRule.expect(FailedParseException.class);
      exceptionRule.expectMessage("I couldn't find paparrazi in your environment.");
      List<String> nouns = List.of("paparrazi", "panda", "grizzly bear");
      List<Set<String>> adjectives = List.of(Set.of("furry", "kind"), Set.of(), Set.of("funny"));
      Set<Item> gameItems = Set.of(
          TestUtil.roomItem("kangaroo", Set.of("furry", "kind", "hilarious", "funny")),
          TestUtil.roomItem("panda"),
          TestUtil.roomItem("grizzly bear", Set.of("funny", "boring", "interesting"))
      );
      List<Item> foundItemNames = Util.flatten(BasicParser.findMatchingGameItems(nouns, adjectives, gameItems));
   }


   // TODO: Test failing with adjectives etc



/*   @BeforeClass
   public static void setUp() throws Exception {
      System.out.println("Setting it up!");
   }

   // Test helpers
   @Test
   public void findVerbFindsUnaryEat() throws JWNLException, FailedParseException {
      assertEquals("eat", BasicParser.findVerb("eat pizza"));
   }

   @Test
   public void findNounsFindsUnaryNoun() throws JWNLException, FailedParseException {
      ActionFormat actionFormat = new ActionFormat("open", null);
      List<String> doorArr = List.of("door");
      assertEquals(doorArr, BasicParser.findNounsAndAdjectives("open door", actionFormat));
   }

   @Test
   public void findNounsFindsUnarySpaceNoun() throws JWNLException, FailedParseException {
      ActionFormat actionFormat = new ActionFormat("open", null);
      List<String> doorArr = List.of("door");
      assertEquals(doorArr, BasicParser.findNounsAndAdjectives("open big door", actionFormat));
   }

   @Test
   public void findNounsFindsUnaryDefiniteNoun() throws JWNLException, FailedParseException {
      ActionFormat actionFormat = new ActionFormat("examine", null);
      List<String> breadArr = List.of("bread");
      assertEquals(breadArr, BasicParser.findNounsAndAdjectives("examine the bread", actionFormat));
   }

   @Test
   public void findNounsFindsTernaryNouns() throws JWNLException, FailedParseException {
      ActionFormat actionFormat = new ActionFormat("throw", "throw ([\\w\\s]+) in ([\\w\\s]+)$");
      List<String> keyBoxArr = List.of("ball", "container");
      assertEquals(keyBoxArr, BasicParser.findNounsAndAdjectives("throw ball in container", actionFormat));
   }

   @Test
   public void findNounsFindsTernaryDefiniteNouns() throws JWNLException, FailedParseException {
      ActionFormat actionFormat = new ActionFormat("put", "put ([\\w\\s]+) in ([\\w\\s]+)$");
      List<String> keyBoxArr = List.of("key", "box");
      assertEquals(keyBoxArr, BasicParser.findNounsAndAdjectives("put the key in the box", actionFormat));
   }

   @Rule
   public ExpectedException exceptionRule = ExpectedException.none();

   @Test
   public void whenNoMatchingGameVerbThrowFailedParseException() throws FailedParseException {
      exceptionRule.expect(FailedParseException.class);
      exceptionRule.expectMessage("No matching game verb");
      List<ActionFormat> possibleActionFormats = new ArrayList<>();
      possibleActionFormats.add(new ActionFormat("ski", null));
      possibleActionFormats.add(new ActionFormat("fly", null));
      InstantiatedGameAction instantiatedGameAction = BasicParser.parse("eat steak", possibleActionFormats, null).get(0);

   }
   // TODO: Check other exceptions here

   @Test
   public void parseVerbSimpleTwoWords() throws FailedParseException {
      // take dog
      List<ActionFormat> possibleActionFormats = new ArrayList<>();
      String verb = "take";
      String noun = "dog";
      possibleActionFormats.add(new ActionFormat(verb, null));
      possibleActionFormats.add(new ActionFormat("fly", null));
      InstantiatedGameAction instantiatedGameAction = BasicParser.parse(String.format("%s %s", verb, noun), possibleActionFormats, null).get(0);
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
      possibleActionFormats.add(new ActionFormat(verb, null));
      InstantiatedGameAction instantiatedGameAction = BasicParser.parse(String.format("%s the %s", verb, noun), possibleActionFormats, null).get(0);
      List<String> wantedArr = List.of(noun);
      List<String> outArguments = instantiatedGameAction.getArguments();
      assertEquals(wantedArr, outArguments);
   }

   @Test
   public void parseNounWithSpace() throws FailedParseException {
      // open the door
      List<ActionFormat> possibleActionFormats = new ArrayList<>();
      String verb = "open";
      String noun = "door";
      possibleActionFormats.add(new ActionFormat(verb, null));
      InstantiatedGameAction instantiatedGameAction = BasicParser.parse(String.format("%s the big %s", verb, noun), possibleActionFormats, null).get(0);
      List<String> wantedArr = List.of(noun);
      List<String> outArguments = instantiatedGameAction.getArguments();
      assertEquals(wantedArr, outArguments);
   }

   @Test
   public void parseVerbSimpleWithExtraStuffAfter() throws FailedParseException {
      // Maybe destroy the cave with grace
      List<ActionFormat> possibleActionFormats = new ArrayList<>();
      String verb = "destroy";
      String noun = "cave";
      possibleActionFormats.add(new ActionFormat(verb, null));
      InstantiatedGameAction instantiatedGameAction = BasicParser.parse(String.format("%s the %s with grace", verb, noun), possibleActionFormats, null).get(0);
      ActionFormat abstractAF = instantiatedGameAction.getAbstractActionFormat();
      String outVerb = abstractAF.getVerb();
      assertEquals(verb, outVerb);
   }

   @Test
   public void parseNounSimpleWithExtraStuffAfter() throws FailedParseException {
      // Maybe destroy the cave with grace
      List<ActionFormat> possibleActionFormats = new ArrayList<>();
      String verb = "destroy";
      String noun = "cave";
      possibleActionFormats.add(new ActionFormat(verb, null));
      InstantiatedGameAction instantiatedGameAction = BasicParser.parse(String.format("%s the %s with grace", verb, noun), possibleActionFormats, null).get(0);
      List<String> wantedArr = List.of(noun);
      List<String> outArguments = instantiatedGameAction.getArguments();
      assertEquals(wantedArr, outArguments);
   }
   // TODO: Add ternary test*/
}