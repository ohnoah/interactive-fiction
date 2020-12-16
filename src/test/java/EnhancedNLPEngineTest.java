import static org.junit.Assert.*;


import edu.stanford.nlp.pipeline.CoreDocument;
import java.util.ArrayList;
import java.util.List;
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
      assertEquals(doorArr, enhancedNLPEngine.findNouns(document, actionFormat));
   }

   @Test
   public void findNounsFindsUnaryDefiniteNoun() throws JWNLException, FailedParseException {
      ActionFormat actionFormat = new ActionFormat("examine", null);
      List<String> breadArr = List.of("bread");
      CoreDocument document = coreDocumentFromText("examine the bread");
      assertEquals(breadArr, enhancedNLPEngine.findNouns(document, actionFormat));
   }

   @Test
   public void findNounsFindsTernaryNouns() throws JWNLException, FailedParseException {
      ActionFormat actionFormat = new ActionFormat("throw", "throw ([\\w\\s]+) in ([\\w\\s]+)$");
      List<String> keyBoxArr = List.of("ball", "container");
      CoreDocument document = coreDocumentFromText("throw ball in container");
      assertEquals(keyBoxArr, enhancedNLPEngine.findNouns(document, actionFormat));
   }

   @Test
   public void findNounsFindsTernaryDefiniteNouns() throws JWNLException, FailedParseException {
      ActionFormat actionFormat = new ActionFormat("put", "put ([\\w\\s]+) in ([\\w\\s]+)$");
      List<String> keyBoxArr = List.of("key", "box");
      CoreDocument document = coreDocumentFromText("put the key in the box");
      assertEquals(keyBoxArr, enhancedNLPEngine.findNouns(document, actionFormat));
   }

   @Rule
   public ExpectedException exceptionRule = ExpectedException.none();

   @Test
   public void whenNoMatchingGameVerbThrowFailedParseException() throws FailedParseException {
      exceptionRule.expect(FailedParseException.class);
      exceptionRule.expectMessage("No matching game verb");
      List<ActionFormat> possibleActionFormats = new ArrayList<ActionFormat>();
      possibleActionFormats.add(new ActionFormat("ski", null));
      possibleActionFormats.add(new ActionFormat("fly", null));
      InstantiatedGameAction instantiatedGameAction = enhancedNLPEngine.parse(String.format("eat steak"), possibleActionFormats, null);

   }
   // TODO: Check other exceptions here

   @Test
   public void parseVerbSimpleTwoWords() throws FailedParseException {
      // take dog
      List<ActionFormat> possibleActionFormats = new ArrayList<ActionFormat>();
      String verb = "take";
      String noun = "dog";
      possibleActionFormats.add(new ActionFormat(verb, null));
      possibleActionFormats.add(new ActionFormat("fly", null));
      InstantiatedGameAction instantiatedGameAction = enhancedNLPEngine.parse(String.format("%s %s", verb, noun), possibleActionFormats, null);
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
      InstantiatedGameAction instantiatedGameAction = enhancedNLPEngine.parse(String.format("%s the %s", verb, noun), possibleActionFormats, null);
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
      possibleActionFormats.add(new ActionFormat(verb, null));
      InstantiatedGameAction instantiatedGameAction = enhancedNLPEngine.parse(String.format("%s the %s with grace", verb, noun), possibleActionFormats, null);
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
      possibleActionFormats.add(new ActionFormat(verb, null));
      InstantiatedGameAction instantiatedGameAction = enhancedNLPEngine.parse(String.format("%s the %s with grace", verb, noun), possibleActionFormats, null);
      List<String> wantedArr = List.of(noun);
      List<String> outArguments = instantiatedGameAction.getArguments();
      assertEquals(wantedArr, outArguments);
   }
}

