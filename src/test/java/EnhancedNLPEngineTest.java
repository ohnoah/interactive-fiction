import static org.junit.Assert.*;


import com.intfic.game.basic.BasicGameEngine;
import com.intfic.game.enhanced.EnhancedGameEngine;
import com.intfic.nlp.EnhancedNLPEngine;
import com.intfic.nlp.FailedParseException;
import com.intfic.game.shared.ActionFormat;
import com.intfic.game.shared.InstantiatedGameAction;
import com.intfic.game.shared.Item;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.util.Pair;
import java.util.ArrayList;
import java.util.HashMap;
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
          EnhancedNLPEngine.parse(String.format("%s the %s quickly", verb, noun), possibleActionFormats, Set.of(door)).get(0);
   }

   @Rule
   public ExpectedException exceptionRule = ExpectedException.none();

   // Test helpers
   @Test
   public void findVerbFindsUnaryEat() throws FailedParseException {
      CoreDocument document = coreDocumentFromText("eat pizza");
      assertEquals("eat", EnhancedNLPEngine.findVerb(document.sentences().get(0), 0, 1));
   }

   private CoreDocument coreDocumentFromText(String rawCommand) {
      return EnhancedNLPEngine.generateCoreDocumentFromString(rawCommand);
   }

   @Test
   public void findNounsFindsUnaryNoun() throws FailedParseException {
      ActionFormat actionFormat = new ActionFormat("open", null);
      List<String> doorArr = List.of("door");
      CoreDocument document = coreDocumentFromText("open door");
      List<String> nouns = new ArrayList<>();
      List<Set<String>> adjectives = new ArrayList<>();
      List<Pair<Integer, Integer>> nps = List.of(new Pair<>(1, 1));
      EnhancedNLPEngine.findNounsAndAdjectives(document.sentences().get(0), 0, 1, nps, actionFormat, nouns, adjectives, new HashMap<>(), new HashMap<>());
      assertEquals(doorArr, nouns);
   }

   @Test
   public void findNounsWithNoValidNounFails() throws FailedParseException {
      exceptionRule.expect(FailedParseException.class);
      exceptionRule.expectMessage("Couldn't find any item in words: it");
      ActionFormat actionFormat = new ActionFormat("examine", null);
      List<String> doorArr = List.of("door");
      CoreDocument document = coreDocumentFromText("examine it.");
      List<String> nouns = new ArrayList<>();
      List<Set<String>> adjectives = new ArrayList<>();
      List<Pair<Integer, Integer>> nps = List.of(new Pair<>(1, 1));
      EnhancedNLPEngine.findNounsAndAdjectives(document.sentences().get(0), 0, 1, nps, actionFormat, nouns, adjectives, new HashMap<>(), new HashMap<>());
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
      EnhancedNLPEngine.findNounsAndAdjectives(document.sentences().get(0), 0, 1, nps, actionFormat, nouns, adjectives, new HashMap<>(), new HashMap<>(), new Pair<>(new HashSet<>(), "door"));
      assertEquals(doorArr, nouns);
      assertEquals(0, adjectives.size());
   }
*/


   @Test
   public void findNounsFindsUnaryDefiniteNoun() throws FailedParseException {
      ActionFormat actionFormat = new ActionFormat("examine");
      List<String> breadArr = List.of("bread");
      CoreDocument document = coreDocumentFromText("examine the bread");
      List<String> nouns = new ArrayList<>();
      List<Set<String>> adjectives = new ArrayList<>();
      List<Pair<Integer, Integer>> nps = List.of(new Pair<>(1, 2));
      EnhancedNLPEngine.findNounsAndAdjectives(document.sentences().get(0), 0, 2, nps, actionFormat, nouns, adjectives, new HashMap<>(), new HashMap<>());
      assertEquals(breadArr, nouns);
   }

   @Test
   public void findNounsFindsTernaryNouns() throws FailedParseException {
      ActionFormat actionFormat = new ActionFormat("throw", "throw ([\\w\\s]+) in ([\\w\\s]+)$");
      List<String> keyBoxArr = List.of("ball", "container");
      CoreDocument document = coreDocumentFromText("throw ball in container");
      List<String> nouns = new ArrayList<>();
      List<Set<String>> adjectives = new ArrayList<>();
      List<Pair<Integer, Integer>> nps = List.of(new Pair<>(1, 1), new Pair<>(3, 3));
      EnhancedNLPEngine.findNounsAndAdjectives(document.sentences().get(0), 0, 3, nps, actionFormat, nouns, adjectives, new HashMap<>(), new HashMap<>());
      assertEquals(keyBoxArr, nouns);
   }

   @Test
   public void findNounsFindsTernaryDefiniteNouns() throws FailedParseException {
      ActionFormat actionFormat = new ActionFormat("put", "put ([\\w\\s]+) in ([\\w\\s]+)$");
      List<String> keyBoxArr = List.of("key", "box");
      CoreDocument document = coreDocumentFromText("put the key in the box");
      List<String> nouns = new ArrayList<>();
      List<Set<String>> adjectives = new ArrayList<>();
      List<Pair<Integer, Integer>> nps = List.of(new Pair<>(1, 2), new Pair<>(4, 5));
      EnhancedNLPEngine.findNounsAndAdjectives(document.sentences().get(0), 0, 5, nps, actionFormat, nouns, adjectives, new HashMap<>(), new HashMap<>());
      assertEquals(nouns, keyBoxArr);
   }

   @Test
   public void findNounsFindsUnarySingleAdjective() throws FailedParseException {
      ActionFormat actionFormat = new ActionFormat("examine", null);
      List<Set<String>> deliciousArr = List.of(Set.of("delicious"));
      CoreDocument document = coreDocumentFromText("examine the delicious bread, new HashMap<>()");
      List<String> nouns = new ArrayList<>();
      List<Set<String>> adjectives = new ArrayList<>();
      List<Pair<Integer, Integer>> nps = List.of(new Pair<>(1, 3));
      EnhancedNLPEngine.findNounsAndAdjectives(document.sentences().get(0), 0, 3, nps, actionFormat, nouns, adjectives, new HashMap<>(), new HashMap<>());
      assertEquals(adjectives, deliciousArr);
   }

   @Test
   public void findNounsFindsUnaryMultipleAdjectives() throws FailedParseException {
      ActionFormat actionFormat = new ActionFormat("examine", null);
      List<Set<String>> deliciousArr = List.of(Set.of("delicious", "yellow"));
      CoreDocument document = coreDocumentFromText("examine the delicious and yellow bread.");
      List<String> nouns = new ArrayList<>();
      List<Set<String>> adjectives = new ArrayList<>();
      List<Pair<Integer, Integer>> nps = List.of(new Pair<>(1, 5));
      EnhancedNLPEngine.findNounsAndAdjectives(document.sentences().get(0), 0, 5, nps, actionFormat, nouns, adjectives, new HashMap<>(), new HashMap<>());
      assertEquals(adjectives, deliciousArr);
   }

   @Test
   public void findNounsFindsTernarySingleAdjective() throws FailedParseException {
      ActionFormat actionFormat = new ActionFormat("put", "put ([\\w\\s]+) in ([\\w\\s]+)$");
      List<Set<String>> redBlackArr = List.of(Set.of("red"), Set.of("black"));
      CoreDocument document = coreDocumentFromText("put the red key in the black box");
      List<String> nouns = new ArrayList<>();
      List<Set<String>> adjectives = new ArrayList<>();
      List<Pair<Integer, Integer>> nps = List.of(new Pair<>(1, 3), new Pair<>(5, 7));
      EnhancedNLPEngine.findNounsAndAdjectives(document.sentences().get(0), 0, 7, nps, actionFormat, nouns, adjectives, new HashMap<>(), new HashMap<>());
      assertEquals(adjectives, redBlackArr);
   }

   @Test
   public void findNounsFindsTernaryMultipleAdjectives() throws FailedParseException {
      ActionFormat actionFormat = new ActionFormat("put", "put ([\\w\\s]+) in ([\\w\\s]+)$");
      List<Set<String>> multiAdjArr = List.of(Set.of("larger", "red"), Set.of("cutest", "blue"));
      CoreDocument document = coreDocumentFromText("put the larger red key in the cutest blue box");
      List<String> nouns = new ArrayList<>();
      List<Set<String>> adjectives = new ArrayList<>();
      List<Pair<Integer, Integer>> nps = List.of(new Pair<>(1, 4), new Pair<>(6, 9));
      EnhancedNLPEngine.findNounsAndAdjectives(document.sentences().get(0), 0, 9, nps, actionFormat, nouns, adjectives, new HashMap<>(), new HashMap<>());
      assertEquals(multiAdjArr, adjectives);
   }


   @Test
   public void whenNoMatchingGameVerbThrowFailedParseException() throws FailedParseException {
      exceptionRule.expect(FailedParseException.class);
      exceptionRule.expectMessage("No action corresponds to the verb: eat");
      List<ActionFormat> possibleActionFormats = new ArrayList<>();
      possibleActionFormats.add(new ActionFormat("ski", null));
      possibleActionFormats.add(new ActionFormat("fly", null));
      InstantiatedGameAction instantiatedGameAction = EnhancedNLPEngine.parse(String.format("eat steak"), possibleActionFormats, new HashSet<>()).get(0);

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
      List<InstantiatedGameAction> instantiatedGameActions =
          EnhancedNLPEngine.parse(String.format("%s the %s graciously", verb, noun), possibleActionFormats, Set.of(dog));
      assertEquals(1, instantiatedGameActions.size());
      InstantiatedGameAction instantiatedGameAction = instantiatedGameActions.get(0);
      ActionFormat abstractAF = instantiatedGameAction.getAbstractActionFormat();
      String outVerb = abstractAF.getVerb();
      assertEquals(verb, outVerb);
   }

   @Test
   public void parseItDogSucceeds() throws FailedParseException {
      // take dog
      List<ActionFormat> possibleActionFormats = new ArrayList<ActionFormat>();
      String verb = "take";
      String noun = "it";
      Item dog = new Item("dog", Set.of("fluffy", "hairy"));
      possibleActionFormats.add(new ActionFormat(verb, null));
      possibleActionFormats.add(new ActionFormat("fly", null));
      List<InstantiatedGameAction> instantiatedGameActions =
          EnhancedNLPEngine.parse(String.format("%s %s", verb, noun), possibleActionFormats, Set.of(dog), new Pair<>(dog.getAdjectives(), dog.getName()));
      assertEquals(1, instantiatedGameActions.size());
      InstantiatedGameAction instantiatedGameAction = instantiatedGameActions.get(0);
      ActionFormat abstractAF = instantiatedGameAction.getAbstractActionFormat();
      String outVerb = abstractAF.getVerb();
      assertEquals(verb, outVerb);
      assertEquals(dog.getName(), instantiatedGameAction.getArguments().get(0));
   }

   @Test
   public void parseItOtherActionSucceeds() throws FailedParseException {
      // take dog
      List<ActionFormat> possibleActionFormats = new ArrayList<ActionFormat>();
      String verb = "take";
      String noun = "dog";
      Item dog = new Item("dog", Set.of("fluffy", "hairy"));
      possibleActionFormats.add(new ActionFormat(verb, null));
      possibleActionFormats.add(new ActionFormat("fly", null));
      List<InstantiatedGameAction> instantiatedGameActions =
          EnhancedNLPEngine.parse(String.format("%s the fluffy %s graciously", verb, noun), possibleActionFormats, Set.of(dog, new Item("door")), new Pair<>(new HashSet<>(), "door"));
      assertEquals(1, instantiatedGameActions.size());
      InstantiatedGameAction instantiatedGameAction = instantiatedGameActions.get(0);
      ActionFormat abstractAF = instantiatedGameAction.getAbstractActionFormat();
      String outVerb = abstractAF.getVerb();
      assertEquals(verb, outVerb);
      assertEquals(dog.getName(), instantiatedGameAction.getArguments().get(0));
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
      List<InstantiatedGameAction> instantiatedGameActions =
          EnhancedNLPEngine.parse(String.format("%s to the %s", verb, noun), possibleActionFormats, Set.of(dog));
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
      Item door = new Item("door");
      possibleActionFormats.add(new ActionFormat(verb, null));
      List<InstantiatedGameAction> instantiatedGameActions =
          EnhancedNLPEngine.parse(String.format("%s the %s slowly", verb, noun), possibleActionFormats, Set.of(door));
      assertEquals(1, instantiatedGameActions.size());
      InstantiatedGameAction instantiatedGameAction = instantiatedGameActions.get(0);
      List<String> wantedArr = List.of(noun);
      List<String> outArguments = instantiatedGameAction.getArguments();
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
      Item pen = new Item("pen");
      Item smallBox = new Item("box");
      possibleActionFormats.add((new EnhancedGameEngine()).findAction("put").get(0));

      printHeapSize();

      List<InstantiatedGameAction> instantiatedGameActions =
          EnhancedNLPEngine.parse(String.format("%s the %s in the %s", verb, noun1, noun2), possibleActionFormats, Set.of(pen, smallBox));
      assertEquals(1, instantiatedGameActions.size());
      InstantiatedGameAction instantiatedGameAction = instantiatedGameActions.get(0);
      List<String> wantedArr = List.of(noun1, noun2);
      List<String> outArguments = instantiatedGameAction.getArguments();
      assertEquals(wantedArr, outArguments);
   }

   @Test
   public void parseItActionVerb() throws FailedParseException {
      // Maybe destroy the cave with grace
      List<ActionFormat> possibleActionFormats = new ArrayList<ActionFormat>();
      String verb = "destroy";
      String noun = "cave";
      Item cave = new Item("cave");
      possibleActionFormats.add(new ActionFormat(verb, null));
      List<InstantiatedGameAction> instantiatedGameActions =
          EnhancedNLPEngine.parse(String.format("%s it quickly", verb, noun), possibleActionFormats, Set.of(cave), new Pair<>(new HashSet<>(), "cave"));
      assertEquals(1, instantiatedGameActions.size());
      InstantiatedGameAction instantiatedGameAction = instantiatedGameActions.get(0);
      ActionFormat abstractAF = instantiatedGameAction.getAbstractActionFormat();
      String outVerb = abstractAF.getVerb();
      assertEquals(verb, outVerb);
   }

   @Test
   public void parseVerbSimpleWithExtraStuffAfter() throws FailedParseException {
      // Maybe destroy the cave with grace
      List<ActionFormat> possibleActionFormats = new ArrayList<ActionFormat>();
      String verb = "destroy";
      String noun = "cave";
      Item cave = new Item("cave");
      possibleActionFormats.add(new ActionFormat(verb, null));
      List<InstantiatedGameAction> instantiatedGameActions =
          EnhancedNLPEngine.parse(String.format("%s the %s quickly", verb, noun), possibleActionFormats, Set.of(cave));
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
      Item cave = new Item("cave");
      possibleActionFormats.add(new ActionFormat(verb, null));
      List<InstantiatedGameAction> instantiatedGameActions =
          EnhancedNLPEngine.parse(String.format("%s the %s ferociously", verb, noun), possibleActionFormats, Set.of(cave));
      assertEquals(1, instantiatedGameActions.size());
      List<String> wantedArr = List.of(noun);
      InstantiatedGameAction instantiatedGameAction = instantiatedGameActions.get(0);
      List<String> outArguments = instantiatedGameAction.getArguments();
      assertEquals(wantedArr, outArguments);
   }

   @Test
   public void parseThreeSentences() throws FailedParseException {
      List<InstantiatedGameAction> instantiatedGameActions =
          EnhancedNLPEngine.parse("eat the donkey. examine the key. open the box.",
              new BasicGameEngine().getPossibleActionFormats(), Set.of(new Item("key"), new Item("donkey"), new Item("box")));
      List<String> wantedArr1 = List.of("donkey");
      List<String> wantedArr2 = List.of("key");
      List<String> wantedArr3 = List.of("box");
      assertEquals(3, instantiatedGameActions.size());
      InstantiatedGameAction eatAction = instantiatedGameActions.get(0);
      List<String> eatActionArguments = eatAction.getArguments();
      InstantiatedGameAction examineAction = instantiatedGameActions.get(1);
      List<String> examineActionArguments = examineAction.getArguments();
      InstantiatedGameAction openAction = instantiatedGameActions.get(2);
      List<String> openActionArguments = openAction.getArguments();
      assertEquals(wantedArr1, eatActionArguments);
      assertEquals(wantedArr2, examineActionArguments);
      assertEquals(wantedArr3, openActionArguments);
   }


   @Test
   public void parseTwoActionsVerbsWithThen() throws FailedParseException {
      List<InstantiatedGameAction> instantiatedGameActions =
          EnhancedNLPEngine.parse("eat the donkey and then examine the key",
              new BasicGameEngine().getPossibleActionFormats(), Set.of(new Item("key"), new Item("donkey"), new Item("box")));
      assertEquals(2, instantiatedGameActions.size());
      InstantiatedGameAction eatAction = instantiatedGameActions.get(0);
      InstantiatedGameAction examineAction = instantiatedGameActions.get(1);
      assertEquals("eat", eatAction.getAbstractActionFormat().getVerb());
      assertEquals("examine", examineAction.getAbstractActionFormat().getVerb());
   }

   @Test
   public void parseTwoActionsNounsWithThen() throws FailedParseException {
      List<InstantiatedGameAction> instantiatedGameActions =
          EnhancedNLPEngine.parse("eat the donkey and then examine the key",
              new BasicGameEngine().getPossibleActionFormats(), Set.of(new Item("key"), new Item("donkey"), new Item("box")));
      List<String> wantedArr1 = List.of("donkey");
      List<String> wantedArr2 = List.of("key");
      assertEquals(2, instantiatedGameActions.size());
      InstantiatedGameAction eatAction = instantiatedGameActions.get(0);
      List<String> eatActionArguments = eatAction.getArguments();
      InstantiatedGameAction examineAction = instantiatedGameActions.get(1);
      List<String> examineActionArguments = examineAction.getArguments();
      assertEquals(wantedArr1, eatActionArguments);
      assertEquals(wantedArr2, examineActionArguments);
   }


   @Test
   public void parseCorefVerbsOneSentenceThreeActions() throws FailedParseException {
      List<InstantiatedGameAction> instantiatedGameActions =
          EnhancedNLPEngine.parse("put the donkey in the box and eat it",
              new BasicGameEngine().getPossibleActionFormats(), Set.of(new Item("key"), new Item("donkey"), new Item("box")));
      assertEquals(2, instantiatedGameActions.size());
      InstantiatedGameAction putAction = instantiatedGameActions.get(0);
      InstantiatedGameAction eatAction1 = instantiatedGameActions.get(1);
      assertEquals("put", putAction.getAbstractActionFormat().getVerb());
      assertEquals("eat", eatAction1.getAbstractActionFormat().getVerb());
   }

   @Test
   public void parseCorefNounsOneSentenceThreeActions() throws FailedParseException {
      List<InstantiatedGameAction> instantiatedGameActions =
          EnhancedNLPEngine.parse("put the donkey in the box and eat it",
              new BasicGameEngine().getPossibleActionFormats(), Set.of(new Item("key"), new Item("donkey"), new Item("box")));
      assertEquals(2, instantiatedGameActions.size());
      InstantiatedGameAction putAction = instantiatedGameActions.get(0);
      InstantiatedGameAction eatAction1 = instantiatedGameActions.get(1);
      assertEquals(List.of("donkey", "box"), putAction.getArguments());
      assertEquals(List.of("donkey"), eatAction1.getArguments());
   }


   @Test
   public void parseCorefVerbsTwoSentencesThreeActions() throws FailedParseException {
      List<InstantiatedGameAction> instantiatedGameActions =
          EnhancedNLPEngine.parse("put the donkey in the box and eat it. eat box.",
              new BasicGameEngine().getPossibleActionFormats(), Set.of(new Item("key"), new Item("donkey"), new Item("box")));
      assertEquals(3, instantiatedGameActions.size());
      InstantiatedGameAction putAction = instantiatedGameActions.get(0);
      InstantiatedGameAction eatAction1 = instantiatedGameActions.get(1);
      InstantiatedGameAction eatAction2 = instantiatedGameActions.get(2);
      assertEquals("put", putAction.getAbstractActionFormat().getVerb());
      assertEquals("eat", eatAction1.getAbstractActionFormat().getVerb());
      assertEquals("eat", eatAction2.getAbstractActionFormat().getVerb());
   }

   @Test
   public void parseCorefNounsTwoSentencesThreeActions() throws FailedParseException {
      List<InstantiatedGameAction> instantiatedGameActions =
          EnhancedNLPEngine.parse("put the donkey in the box and eat it. eat the box.",
              new BasicGameEngine().getPossibleActionFormats(), Set.of(new Item("key"), new Item("donkey"), new Item("box")));
      List<String> wantedArr1 = List.of("donkey", "box");
      List<String> wantedArr2 = List.of("donkey");
      List<String> wantedArr3 = List.of("box");
      assertEquals(3, instantiatedGameActions.size());
      InstantiatedGameAction putAction = instantiatedGameActions.get(0);
      List<String> putArguments = putAction.getArguments();
      InstantiatedGameAction eatAction1 = instantiatedGameActions.get(1);
      List<String> eatAction1Arguments = eatAction1.getArguments();
      InstantiatedGameAction eatAction2 = instantiatedGameActions.get(2);
      List<String> eatAction2Arguments = eatAction2.getArguments();
      assertEquals(wantedArr1, putArguments);
      assertEquals(wantedArr2, eatAction1Arguments);
      assertEquals(wantedArr3, eatAction2Arguments);
   }

   @Test
   public void parseCorefVerbsTernarySingleSentenceThreeActions() throws FailedParseException {
      List<InstantiatedGameAction> instantiatedGameActions =
          EnhancedNLPEngine.parse("put the horse in the box and drink it from the box and examine key.",
              new BasicGameEngine().getPossibleActionFormats(), Set.of(new Item("key"), new Item("horse"), new Item("box")));
      assertEquals(3, instantiatedGameActions.size());
      InstantiatedGameAction putAction = instantiatedGameActions.get(0);
      InstantiatedGameAction eatAction = instantiatedGameActions.get(1);
      InstantiatedGameAction examineAction = instantiatedGameActions.get(2);
      assertEquals("put", putAction.getAbstractActionFormat().getVerb());
      assertEquals("drink", eatAction.getAbstractActionFormat().getVerb());
      assertEquals("examine", examineAction.getAbstractActionFormat().getVerb());
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

