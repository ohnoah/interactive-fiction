import static org.junit.Assert.*;


import com.intfic.game.basic.BasicGameEngine;
import com.intfic.game.enhanced.EnhancedGameEngine;
import com.intfic.game.shared.Util;
import com.intfic.nlp.EnhancedParser;
import com.intfic.nlp.FailedParseException;
import com.intfic.game.shared.ActionFormat;
import com.intfic.game.shared.InstantiatedGameAction;
import com.intfic.game.shared.Item;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.util.Pair;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class EnhancedParserTest {

   @BeforeClass
   public static void setUp() throws Exception {
      System.out.println("Setting it up!");
      List<ActionFormat> possibleActionFormats = new ArrayList<>();
      String verb = "open";
      String noun = "door";
      Item door = TestUtil.roomItem("door");
      possibleActionFormats.add(new ActionFormat(verb, null));
      InstantiatedGameAction instantiatedGameAction =
          EnhancedParser.parse(String.format("%s the %s quickly", verb, noun), possibleActionFormats, Set.of(door)).get(0);
   }

   @Rule
   public ExpectedException exceptionRule = ExpectedException.none();

   // Test helpers
   @Test
   public void findVerbFindsUnaryEat() throws FailedParseException {
      CoreDocument document = coreDocumentFromText("eat pizza");
      assertEquals("eat", EnhancedParser.findVerb(document.sentences().get(0), 0, 1));
   }

   private CoreDocument coreDocumentFromText(String rawCommand) {
      return EnhancedParser.generateCoreDocumentFromString(rawCommand);
   }

   @Test
   public void findNounsFindsUnaryNoun() throws FailedParseException {
      ActionFormat actionFormat = new ActionFormat("open", null);
      List<String> doorArr = List.of("door");
      CoreDocument document = coreDocumentFromText("open door");
      List<String> nouns = new ArrayList<>();
      List<Set<String>> adjectives = new ArrayList<>();
      List<Pair<Integer, Integer>> nps = List.of(new Pair<>(1, 1));
      EnhancedParser.findNounsAndAdjectives(document.sentences().get(0), 0, 1, nps, actionFormat, nouns, adjectives, new HashMap<>(), new HashMap<>());
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
      EnhancedParser.findNounsAndAdjectives(document.sentences().get(0), 0, 1, nps, actionFormat, nouns, adjectives, new HashMap<>(), new HashMap<>());
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
      EnhancedParser.findNounsAndAdjectives(document.sentences().get(0), 0, 1, nps, actionFormat, nouns, adjectives, new HashMap<>(), new HashMap<>(), new Pair<>(new HashSet<>(), "door"));
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
      EnhancedParser.findNounsAndAdjectives(document.sentences().get(0), 0, 2, nps, actionFormat, nouns, adjectives, new HashMap<>(), new HashMap<>());
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
      EnhancedParser.findNounsAndAdjectives(document.sentences().get(0), 0, 3, nps, actionFormat, nouns, adjectives, new HashMap<>(), new HashMap<>());
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
      EnhancedParser.findNounsAndAdjectives(document.sentences().get(0), 0, 5, nps, actionFormat, nouns, adjectives, new HashMap<>(), new HashMap<>());
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
      EnhancedParser.findNounsAndAdjectives(document.sentences().get(0), 0, 3, nps, actionFormat, nouns, adjectives, new HashMap<>(), new HashMap<>());
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
      EnhancedParser.findNounsAndAdjectives(document.sentences().get(0), 0, 5, nps, actionFormat, nouns, adjectives, new HashMap<>(), new HashMap<>());
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
      EnhancedParser.findNounsAndAdjectives(document.sentences().get(0), 0, 7, nps, actionFormat, nouns, adjectives, new HashMap<>(), new HashMap<>());
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
      EnhancedParser.findNounsAndAdjectives(document.sentences().get(0), 0, 9, nps, actionFormat, nouns, adjectives, new HashMap<>(), new HashMap<>());
      assertEquals(multiAdjArr, adjectives);
   }


   @Test
   public void whenNoMatchingGameVerbThrowFailedParseException() throws FailedParseException {
      exceptionRule.expect(FailedParseException.class);
      exceptionRule.expectMessage("No action corresponds to the verb: eat");
      List<ActionFormat> possibleActionFormats = new ArrayList<>();
      possibleActionFormats.add(new ActionFormat("ski", null));
      possibleActionFormats.add(new ActionFormat("fly", null));
      InstantiatedGameAction instantiatedGameAction = EnhancedParser.parse("eat steak", possibleActionFormats, new HashSet<>()).get(0);

   }
   // TODO: Check other exceptions here


   @Test
   public void parseVerbSimpleTwoWords() throws FailedParseException {
      // take dog
      List<ActionFormat> possibleActionFormats = new ArrayList<ActionFormat>();
      String verb = "take";
      String noun = "dog";
      Item dog = TestUtil.roomItem("dog");
      possibleActionFormats.add(new ActionFormat(verb, null));
      possibleActionFormats.add(new ActionFormat("fly", null));
      List<InstantiatedGameAction> instantiatedGameActions =
          EnhancedParser.parse(String.format("%s the %s graciously", verb, noun), possibleActionFormats, Set.of(dog));
      assertEquals(1, instantiatedGameActions.size());
      InstantiatedGameAction instantiatedGameAction = instantiatedGameActions.get(0);
      ActionFormat abstractAF = instantiatedGameAction.getAbstractActionFormat();
      String outVerb = abstractAF.getVerb();
      assertEquals(verb, outVerb);
   }


   @Test
   public void parseLongMultipleWords() throws FailedParseException {
      // take dog
      List<ActionFormat> possibleActionFormats = new ArrayList<ActionFormat>();
      Item backOfRoom = TestUtil.roomItem("back of the room");
      ActionFormat go = new ActionFormat("go", "go to ([\\w\\s]+)$");
      possibleActionFormats.add(go);
      possibleActionFormats.add(new ActionFormat("fly", null));
      List<InstantiatedGameAction> instantiatedGameActions =
          EnhancedParser.parse("go to the back of the room", possibleActionFormats, Set.of(backOfRoom));
      assertEquals(1, instantiatedGameActions.size());
      InstantiatedGameAction instantiatedGameAction = instantiatedGameActions.get(0);
      ActionFormat abstractAF = instantiatedGameAction.getAbstractActionFormat();
      String outVerb = abstractAF.getVerb();
      assertEquals("go", outVerb);
   }

   @Test
   public void parseLongMultipleWordsDescriptorAfter() throws FailedParseException {
      exceptionRule.expect(FailedParseException.class);
      exceptionRule.expectMessage("Non-noun phrase specified in the 1:th slot of verb go");
      List<ActionFormat> possibleActionFormats = new ArrayList<ActionFormat>();
      Item backOfRoom = TestUtil.roomItem("back of the room");
      ActionFormat go = new ActionFormat("go", "go to ([\\w\\s]+)$");
      possibleActionFormats.add(go);
      possibleActionFormats.add(new ActionFormat("fly", null));
      List<InstantiatedGameAction> instantiatedGameActions =
          EnhancedParser.parse("go to the back of the room quickly", possibleActionFormats, Set.of(backOfRoom));
      assertEquals(1, instantiatedGameActions.size());
      InstantiatedGameAction instantiatedGameAction = instantiatedGameActions.get(0);
      ActionFormat abstractAF = instantiatedGameAction.getAbstractActionFormat();
      String outVerb = abstractAF.getVerb();
      assertEquals("go", outVerb);
   }

   @Test
   public void parseItDogSucceeds() throws FailedParseException {
      // take dog
      List<ActionFormat> possibleActionFormats = new ArrayList<ActionFormat>();
      String verb = "take";
      String noun = "it";
      Item dog = TestUtil.roomItem("dog", Set.of("fluffy", "hairy"));
      possibleActionFormats.add(new ActionFormat(verb, null));
      possibleActionFormats.add(new ActionFormat("fly", null));
      List<InstantiatedGameAction> instantiatedGameActions =
          EnhancedParser.parse(String.format("%s %s", verb, noun), possibleActionFormats, Set.of(dog), new Pair<>(dog.getAdjectives(), dog.getName()));
      assertEquals(1, instantiatedGameActions.size());
      InstantiatedGameAction instantiatedGameAction = instantiatedGameActions.get(0);
      ActionFormat abstractAF = instantiatedGameAction.getAbstractActionFormat();
      String outVerb = abstractAF.getVerb();
      assertEquals(verb, outVerb);
      assertEquals(dog, Util.flatten(instantiatedGameAction.getPotentialArguments()).get(0));
   }

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
          EnhancedParser.parse(String.format("%s the fluffy %s graciously", verb, noun), possibleActionFormats, Set.of(dog, TestUtil.roomItem("door")), new Pair<>(new HashSet<>(), "door"));
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
      List<ActionFormat> possibleActionFormats = new ArrayList<>();
      String verb = "listen";
      String noun = "dog";
      Item dog = TestUtil.roomItem("dog");
      possibleActionFormats.add(new ActionFormat("listen", "listen to ([\\w\\s]+)$"));
      possibleActionFormats.add(new ActionFormat("fly", null));
      List<InstantiatedGameAction> instantiatedGameActions =
          EnhancedParser.parse(String.format("%s to the %s", verb, noun), possibleActionFormats, Set.of(dog));
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
      Item door = TestUtil.roomItem("door");
      possibleActionFormats.add(new ActionFormat(verb, null));
      List<InstantiatedGameAction> instantiatedGameActions =
          EnhancedParser.parse(String.format("%s the %s slowly", verb, noun), possibleActionFormats, Set.of(door));
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
      Item pen = TestUtil.roomItem(noun1);
      Item smallBox = TestUtil.roomItem(noun2);
      possibleActionFormats.add((new EnhancedGameEngine()).findAction("put").get(0));

      printHeapSize();

      List<InstantiatedGameAction> instantiatedGameActions =
          EnhancedParser.parse(String.format("%s the %s in the %s", verb, noun1, noun2), possibleActionFormats, Set.of(pen, smallBox));
      assertEquals(1, instantiatedGameActions.size());
      InstantiatedGameAction instantiatedGameAction = instantiatedGameActions.get(0);
      List<Item> wantedArr = List.of(pen, smallBox);
      List<Item> outArguments = Util.flatten(instantiatedGameAction.getPotentialArguments());
      assertEquals(wantedArr, outArguments);
   }

   @Test
   public void parseItActionVerb() throws FailedParseException {
      // Maybe destroy the cave with grace
      List<ActionFormat> possibleActionFormats = new ArrayList<ActionFormat>();
      String verb = "destroy";
      String noun = "cave";
      Item cave = TestUtil.roomItem("cave");
      possibleActionFormats.add(new ActionFormat(verb, null));
      List<InstantiatedGameAction> instantiatedGameActions =
          EnhancedParser.parse(String.format("%s it quickly", verb), possibleActionFormats, Set.of(cave), new Pair<>(new HashSet<>(), "cave"));
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
      Item cave = TestUtil.roomItem("cave");
      possibleActionFormats.add(new ActionFormat(verb, null));
      List<InstantiatedGameAction> instantiatedGameActions =
          EnhancedParser.parse(String.format("%s the %s quickly", verb, noun), possibleActionFormats, Set.of(cave));
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
          EnhancedParser.parse(String.format("%s the %s ferociously", verb, noun), possibleActionFormats, Set.of(cave));
      assertEquals(1, instantiatedGameActions.size());
      List<Item> wantedArr = List.of(cave);
      InstantiatedGameAction instantiatedGameAction = instantiatedGameActions.get(0);
      List<Item> outArguments = Util.flatten(instantiatedGameAction.getPotentialArguments());
      assertEquals(wantedArr, outArguments);
   }

   @Test
   public void parseMultipleWordNoun() throws FailedParseException {
      // Maybe destroy the livingRoom
      List<ActionFormat> possibleActionFormats = new ArrayList<ActionFormat>();
      String verb = "destroy";
      String noun = "living room";
      Item livingRoom = TestUtil.roomItem(noun);
      possibleActionFormats.add(new ActionFormat(verb, null));
      List<InstantiatedGameAction> instantiatedGameActions =
          EnhancedParser.parse(String.format("%s the %s ferociously", verb, noun), possibleActionFormats, Set.of(livingRoom));
      assertEquals(1, instantiatedGameActions.size());
      List<Item> wantedArr = List.of(livingRoom);
      InstantiatedGameAction instantiatedGameAction = instantiatedGameActions.get(0);
      List<Item> outArguments = Util.flatten(instantiatedGameAction.getPotentialArguments());
      assertEquals(wantedArr, outArguments);
   }

   @Test
   public void parseThreeSentences() throws FailedParseException {
      List<InstantiatedGameAction> instantiatedGameActions =
          EnhancedParser.parse("eat the donkey. examine the key. open the box.",
              new BasicGameEngine().getPossibleActionFormats(), Set.of(TestUtil.roomItem("key"), TestUtil.roomItem("donkey"), TestUtil.roomItem("box")));
      List<Item> wantedArr1 = List.of(TestUtil.roomItem("donkey"));
      List<Item> wantedArr2 = List.of(TestUtil.roomItem("key"));
      List<Item> wantedArr3 = List.of(TestUtil.roomItem("box"));
      assertEquals(3, instantiatedGameActions.size());
      InstantiatedGameAction eatAction = instantiatedGameActions.get(0);
      List<Item> eatActionArguments = Util.flatten(eatAction.getPotentialArguments());
      InstantiatedGameAction examineAction = instantiatedGameActions.get(1);
      List<Item> examineActionArguments = Util.flatten(examineAction.getPotentialArguments());
      InstantiatedGameAction openAction = instantiatedGameActions.get(2);
      List<Item> openActionArguments = Util.flatten(openAction.getPotentialArguments());
      assertEquals(wantedArr1, eatActionArguments);
      assertEquals(wantedArr2, examineActionArguments);
      assertEquals(wantedArr3, openActionArguments);
   }


   @Test
   public void parseTwoActionsVerbsWithThen() throws FailedParseException {
      List<InstantiatedGameAction> instantiatedGameActions =
          EnhancedParser.parse("eat the donkey and then examine the key",
              new BasicGameEngine().getPossibleActionFormats(), Set.of(TestUtil.roomItem("key"), TestUtil.roomItem("donkey"), TestUtil.roomItem("box")));
      assertEquals(2, instantiatedGameActions.size());
      InstantiatedGameAction eatAction = instantiatedGameActions.get(0);
      InstantiatedGameAction examineAction = instantiatedGameActions.get(1);
      assertEquals("eat", eatAction.getAbstractActionFormat().getVerb());
      assertEquals("examine", examineAction.getAbstractActionFormat().getVerb());
   }

   @Test
   public void parseTwoActionsNounsWithThen() throws FailedParseException {
      Item key = TestUtil.roomItem("key");
      Item donkey = TestUtil.roomItem("donkey");
      Item box = TestUtil.roomItem("box");
      List<InstantiatedGameAction> instantiatedGameActions =
          EnhancedParser.parse("eat the donkey and then examine the key",
              new BasicGameEngine().getPossibleActionFormats(), Set.of(key, donkey, box));
      List<Item> wantedArr1 = List.of(donkey);
      List<Item> wantedArr2 = List.of(key);
      assertEquals(2, instantiatedGameActions.size());
      InstantiatedGameAction eatAction = instantiatedGameActions.get(0);
      List<Item> eatActionArguments = Util.flatten(eatAction.getPotentialArguments());
      InstantiatedGameAction examineAction = instantiatedGameActions.get(1);
      List<Item> examineActionArguments = Util.flatten(examineAction.getPotentialArguments());
      assertEquals(wantedArr1, eatActionArguments);
      assertEquals(wantedArr2, examineActionArguments);
   }


   @Test
   public void parseCorefVerbsOneSentenceThreeActions() throws FailedParseException {
      List<InstantiatedGameAction> instantiatedGameActions =
          EnhancedParser.parse("put the donkey in the box and eat it",
              new BasicGameEngine().getPossibleActionFormats(), Set.of(TestUtil.roomItem("key"), TestUtil.roomItem("donkey"), TestUtil.roomItem("box")));
      assertEquals(2, instantiatedGameActions.size());
      InstantiatedGameAction putAction = instantiatedGameActions.get(0);
      InstantiatedGameAction eatAction1 = instantiatedGameActions.get(1);
      assertEquals("put", putAction.getAbstractActionFormat().getVerb());
      assertEquals("eat", eatAction1.getAbstractActionFormat().getVerb());
   }

   @Test
   public void parseCorefNounsOneSentenceThreeActions() throws FailedParseException {
      Item key = TestUtil.roomItem("key");
      Item donkey = TestUtil.roomItem("donkey");
      Item box = TestUtil.roomItem("box");

      List<InstantiatedGameAction> instantiatedGameActions =
          EnhancedParser.parse("put the donkey in the box and eat it",
              new BasicGameEngine().getPossibleActionFormats(), Set.of(key, donkey, box));
      assertEquals(2, instantiatedGameActions.size());
      InstantiatedGameAction putAction = instantiatedGameActions.get(0);
      InstantiatedGameAction eatAction1 = instantiatedGameActions.get(1);
      assertEquals(List.of(donkey, box), Util.flatten(putAction.getPotentialArguments()));
      assertEquals(List.of(donkey), Util.flatten(eatAction1.getPotentialArguments()));
   }


   @Test
   public void parseCorefVerbsTwoSentencesThreeActions() throws FailedParseException {
      Item key = TestUtil.roomItem("key");
      Item donkey = TestUtil.roomItem("donkey");
      Item box = TestUtil.roomItem("box");
      List<InstantiatedGameAction> instantiatedGameActions =
          EnhancedParser.parse("put the donkey on the box and eat it. eat box.",
              new BasicGameEngine().getPossibleActionFormats(), Set.of(donkey, key, box));
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
      Item key = TestUtil.roomItem("key");
      Item donkey = TestUtil.roomItem("donkey");
      Item box = TestUtil.roomItem("box");
      List<InstantiatedGameAction> instantiatedGameActions =
          EnhancedParser.parse("put the donkey in the box and eat it. eat the box.",
              new BasicGameEngine().getPossibleActionFormats(), Set.of(key, donkey, box));
      List<Item> wantedArr1 = List.of(donkey, box);
      List<Item> wantedArr2 = List.of(donkey);
      List<Item> wantedArr3 = List.of(box);
      assertEquals(3, instantiatedGameActions.size());
      InstantiatedGameAction putAction = instantiatedGameActions.get(0);
      List<Item> putArguments = Util.flatten(putAction.getPotentialArguments());
      InstantiatedGameAction eatAction1 = instantiatedGameActions.get(1);
      List<Item> eatAction1Arguments = Util.flatten(eatAction1.getPotentialArguments());
      InstantiatedGameAction eatAction2 = instantiatedGameActions.get(2);
      List<Item> eatAction2Arguments = Util.flatten(eatAction2.getPotentialArguments());
      assertEquals(wantedArr1, putArguments);
      assertEquals(wantedArr2, eatAction1Arguments);
      assertEquals(wantedArr3, eatAction2Arguments);
   }

   @Test
   public void parseCorefVerbsTernarySingleSentenceThreeActions() throws FailedParseException {
      Item key = TestUtil.roomItem("key");
      Item horse = TestUtil.roomItem("horse");
      Item box = TestUtil.roomItem("box");
      List<InstantiatedGameAction> instantiatedGameActions =
          EnhancedParser.parse("put the horse in the box and drink it from the box and examine key.",
              new BasicGameEngine().getPossibleActionFormats(), Set.of(key, horse, box));
      assertEquals(3, instantiatedGameActions.size());
      InstantiatedGameAction putAction = instantiatedGameActions.get(0);
      InstantiatedGameAction eatAction = instantiatedGameActions.get(1);
      InstantiatedGameAction examineAction = instantiatedGameActions.get(2);
      assertEquals("put", putAction.getAbstractActionFormat().getVerb());
      assertEquals("drink", eatAction.getAbstractActionFormat().getVerb());
      assertEquals("examine", examineAction.getAbstractActionFormat().getVerb());
   }


   @Test
   public void findMatchingGameItemOneEditDistanceMultiple() throws FailedParseException {
      List<String> nouns = List.of("bea", "pande", "bearo");
      List<Set<String>> adjectives = List.of(Set.of("funny"), Set.of(), Set.of("funny"));
      Item bear = TestUtil.roomItem("bear", Set.of("furry", "kind", "hilarious", "funny"));
      Item panda = TestUtil.roomItem("panda");
      Item bear2 = TestUtil.roomItem("bear", Set.of("funny"));
      Set<Item> gameItems = Set.of(
          bear, panda, bear2
      );
      List<List<Item>> foundItemNames = EnhancedParser.findMatchingGameItemNames(nouns, adjectives, gameItems);
      assertEquals(List.of(bear, bear2), foundItemNames.get(0));
      assertEquals(List.of(panda), foundItemNames.get(1));
      assertEquals(List.of(bear, bear2), foundItemNames.get(2));

   }

   @Test
   public void findMatchingGameItemOneEditDistanceMultipleDifferent() throws FailedParseException {
      List<String> nouns = List.of("kear", "pande", "ear");
      List<Set<String>> adjectives = List.of(Set.of("funny"), Set.of(), Set.of("funny"));
      Item bear = TestUtil.roomItem("bear", Set.of("furry", "kind", "hilarious", "funny"));
      Item panda = TestUtil.roomItem("panda");
      Item pear = TestUtil.roomItem("pear", Set.of("funny"));
      Set<Item> gameItems = Set.of(
          bear, panda, pear
      );
      List<List<Item>> foundItemNames = EnhancedParser.findMatchingGameItemNames(nouns, adjectives, gameItems);
      assertEquals(List.of(bear, pear), foundItemNames.get(0).stream().sorted(Comparator.comparing(Item::getName)).collect(Collectors.toList()));
      assertEquals(List.of(panda), foundItemNames.get(1));
      assertEquals(List.of(bear, pear), foundItemNames.get(2).stream().sorted(Comparator.comparing(Item::getName)).collect(Collectors.toList()));

   }

   @Test
   public void findMatchingGameItemOneDistance() throws FailedParseException {
      List<String> nouns = List.of("beal", "pandaa", "olwa");
      List<Set<String>> adjectives = List.of(Set.of("furry", "kind"), Set.of(), Set.of("funny"));
      Item bear = TestUtil.roomItem("bear", Set.of("furry", "kind", "hilarious", "funny"));
      Item panda = TestUtil.roomItem("panda");
      Item owl = TestUtil.roomItem("owl", Set.of("funny", "boring", "interesting"));
      Set<Item> gameItems = Set.of(
          bear, panda, owl
      );
      List<Item> foundItemNames = Util.flatten(EnhancedParser.findMatchingGameItemNames(nouns, adjectives, gameItems));
      assertEquals(List.of(bear, panda, owl), foundItemNames);

   }

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
      List<Item> foundItemNames = Util.flatten(EnhancedParser.findMatchingGameItemNames(nouns, adjectives, gameItems));
      assertEquals(List.of(bear, panda, owl), foundItemNames);

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
      List<Item> foundItemNames = Util.flatten(EnhancedParser.findMatchingGameItemNames(nouns, adjectives, gameItems));
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
      List<Item> foundItemNames = Util.flatten(EnhancedParser.findMatchingGameItemNames(nouns, adjectives, gameItems));
   }


   // TODO: Test failing with adjectives etc

}

