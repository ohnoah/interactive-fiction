import static org.junit.Assert.*;


import com.intfic.nlp.BasicNLPEngine;
import com.intfic.nlp.FailedParseException;
import com.intfic.game.shared.ActionFormat;
import com.intfic.game.shared.InstantiatedGameAction;
import java.util.ArrayList;
import java.util.List;
import net.sf.extjwnl.JWNLException;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class BasicNLPEngineTest {
   private static BasicNLPEngine basicNLPEngine;

   @BeforeClass
   public static void setUp() throws Exception {
      System.out.println("Setting it up!");
      basicNLPEngine = new BasicNLPEngine();
   }

   // Test helpers
   @Test
   public void findVerbFindsUnaryEat() throws JWNLException, FailedParseException {
      assertEquals("eat", basicNLPEngine.findVerb("eat pizza"));
   }

   @Test
   public void findNounsFindsUnaryNoun() throws JWNLException, FailedParseException {
      ActionFormat actionFormat = new ActionFormat("open", null);
      List<String> doorArr = List.of("door");
      assertEquals(doorArr, basicNLPEngine.findNouns("open door", actionFormat));
   }

   @Test
   public void findNounsFindsUnarySpaceNoun() throws JWNLException, FailedParseException {
      ActionFormat actionFormat = new ActionFormat("open", null);
      List<String> doorArr = List.of("door");
      assertEquals(doorArr, basicNLPEngine.findNouns("open big door", actionFormat));
   }

   @Test
   public void findNounsFindsUnaryDefiniteNoun() throws JWNLException, FailedParseException {
      ActionFormat actionFormat = new ActionFormat("examine", null);
      List<String> breadArr = List.of("bread");
      assertEquals(breadArr, basicNLPEngine.findNouns("examine the bread", actionFormat));
   }

   @Test
   public void findNounsFindsTernaryNouns() throws JWNLException, FailedParseException {
      ActionFormat actionFormat = new ActionFormat("throw", "throw ([\\w\\s]+) in ([\\w\\s]+)$");
      List<String> keyBoxArr = List.of("ball", "container");
      assertEquals(keyBoxArr, basicNLPEngine.findNouns("throw ball in container", actionFormat));
   }

   @Test
   public void findNounsFindsTernaryDefiniteNouns() throws JWNLException, FailedParseException {
      ActionFormat actionFormat = new ActionFormat("put", "put ([\\w\\s]+) in ([\\w\\s]+)$");
      List<String> keyBoxArr = List.of("key", "box");
      assertEquals(keyBoxArr, basicNLPEngine.findNouns("put the key in the box", actionFormat));
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
      InstantiatedGameAction instantiatedGameAction = basicNLPEngine.parse("eat steak", possibleActionFormats, null);

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
      InstantiatedGameAction instantiatedGameAction = basicNLPEngine.parse(String.format("%s %s", verb, noun), possibleActionFormats, null);
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
      InstantiatedGameAction instantiatedGameAction = basicNLPEngine.parse(String.format("%s the %s", verb, noun), possibleActionFormats, null);
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
      InstantiatedGameAction instantiatedGameAction = basicNLPEngine.parse(String.format("%s the big %s", verb, noun), possibleActionFormats, null);
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
      InstantiatedGameAction instantiatedGameAction = basicNLPEngine.parse(String.format("%s the %s with grace", verb, noun), possibleActionFormats, null);
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
      InstantiatedGameAction instantiatedGameAction = basicNLPEngine.parse(String.format("%s the %s with grace", verb, noun), possibleActionFormats, null);
      List<String> wantedArr = List.of(noun);
      List<String> outArguments = instantiatedGameAction.getArguments();
      assertEquals(wantedArr, outArguments);
   }
   // TODO: Add ternary test
}