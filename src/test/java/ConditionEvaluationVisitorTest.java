import static org.junit.Assert.*;


import com.enhanced.reasoning.KnowledgeBase;
import com.enhanced.reasoning.exceptions.KnowledgeException;
import com.enhanced.reasoning.exceptions.MissingKnowledgeException;
import com.enhanced.reasoning.SpecificFrame;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ConditionEvaluationVisitorTest {

   @Rule
   public ExpectedException exceptionRule = ExpectedException.none();

   private Boolean produceBooleanResult(KnowledgeBase kb, String expression) throws KnowledgeException, MissingKnowledgeException {
      return kb.conditionSucceeds(expression);
   }


   // No Knowledge Base Tests
   @Test
   public void loneStringFailedParseException() throws KnowledgeException, MissingKnowledgeException {
      String expression = "\"Hello world. I'm John Doe ? and this should fail\"";
      exceptionRule.expect(ParseCancellationException.class);
      exceptionRule.expectMessage("line 1:50 no viable alternative at input '\"Hello world. I'm John Doe ? and this should fail\"'");
      KnowledgeBase kb = new KnowledgeBase();
      produceBooleanResult(kb, expression);
   }


   @Test
   public void loneDoubleFailedParseException() throws KnowledgeException, MissingKnowledgeException {
      String expression = "123.4567";
      exceptionRule.expect(ParseCancellationException.class);
      exceptionRule.expectMessage("line 1:8 no viable alternative at input '123.4567'");
      KnowledgeBase kb = new KnowledgeBase();
      produceBooleanResult(kb, expression);
   }

   @Test
   public void loneTrueSuccess() throws KnowledgeException, MissingKnowledgeException {
      String expression = "TRUE";
      KnowledgeBase kb = new KnowledgeBase();
      Boolean result = produceBooleanResult(kb, expression);
      assertTrue(result);
   }

   @Test
   public void loneFalseSuccess() throws KnowledgeException, MissingKnowledgeException {
      String expression = "FALSE";
      KnowledgeBase kb = new KnowledgeBase();
      Boolean result = produceBooleanResult(kb, expression);
      assertFalse(result);
   }

   @Test
   public void bracketedBoolExpression() throws KnowledgeException, MissingKnowledgeException {
      String expression = "(1.0 IN [])";
      KnowledgeBase kb = new KnowledgeBase();
      Boolean result = produceBooleanResult(kb, expression);
      assertFalse(result);
   }

   @Test
   public void bracketedBoolEqualNotExpression() throws KnowledgeException, MissingKnowledgeException {
      String expression = "(1.0 IN []) OR (NOT TRUE)";
      KnowledgeBase kb = new KnowledgeBase();
      Boolean result = produceBooleanResult(kb, expression);
      assertFalse(result);
   }

   @Test
   public void notTrueIsFalse() throws KnowledgeException, MissingKnowledgeException {
      String expression = "NOT(NOT TRUE OR FALSE)";
      KnowledgeBase kb = new KnowledgeBase();
      Boolean result = produceBooleanResult(kb, expression);
      assertTrue(result);
   }

   @Test
   public void simpleAndSuccess() throws KnowledgeException, MissingKnowledgeException {
      String expression = "TRUE AND FALSE";
      KnowledgeBase kb = new KnowledgeBase();
      Boolean result = produceBooleanResult(kb, expression);
      assertFalse(result);
   }

   @Test
   public void compositeOrAndSuccess() throws KnowledgeException, MissingKnowledgeException {
      String expression = "(TRUE OR FALSE) AND (TRUE)";
      KnowledgeBase kb = new KnowledgeBase();
      Boolean result = produceBooleanResult(kb, expression);
      assertTrue(result);
   }

   @Test
   public void compositeIdentifierOrAndSuccess() throws KnowledgeException, MissingKnowledgeException {
      String expression = "(_test::banna OR TRUE) AND (TRUE)";
      KnowledgeBase kb = new KnowledgeBase();
      SpecificFrame s = new SpecificFrame("test");
      s.updateFiller("banna", false);
      kb.addSpecificFrame(s);
      Boolean result = produceBooleanResult(kb, expression);
      assertTrue(result);
   }

      @Test
   public void stringInequalitySuccess() throws KnowledgeException, MissingKnowledgeException {
      String expression = "\"aaa!!!\" > \"bbbAAA\"";
      KnowledgeBase kb = new KnowledgeBase();
      Boolean result = produceBooleanResult(kb, expression);
      assertFalse(result);
   }

   @Test
   public void stringInequalityEqualSuccess() throws KnowledgeException, MissingKnowledgeException {
      String expression = "\"abc\" <= \"abc\"";
      KnowledgeBase kb = new KnowledgeBase();
      Boolean result = produceBooleanResult(kb, expression);
      assertTrue(result);
   }

   @Test
   public void stringInequalitySymmetry() throws KnowledgeException, MissingKnowledgeException {
      String expression = "\"aaa!!!\" >= \"bbbAAA\"";
      String expressionSwapped = "\"bbbAAA\" <= \"aaa!!!\"";
      KnowledgeBase kb = new KnowledgeBase();
      Boolean result = produceBooleanResult(kb, expression);
      Boolean resultSwapped = produceBooleanResult(kb, expressionSwapped);
      assertEquals(result, resultSwapped);
   }

   @Test
   public void stringStrictInequalitySymmetry() throws KnowledgeException, MissingKnowledgeException {
      String expression = "\"!?.\" >= \"okok\"";
      String expressionSwapped = "\"okok\" <= \"!?.\"";
      KnowledgeBase kb = new KnowledgeBase();
      Boolean result = produceBooleanResult(kb, expression);
      Boolean resultSwapped = produceBooleanResult(kb, expressionSwapped);
      assertEquals(result, resultSwapped);
   }

   @Test
   public void stringEqualitySuccess() throws KnowledgeException, MissingKnowledgeException {
      String expression = "\"hello, world\" = \"hello, world\"";
      KnowledgeBase kb = new KnowledgeBase();
      Boolean result = produceBooleanResult(kb, expression);
      assertTrue(result);
   }

   @Test
   public void stringEqualityFail() throws KnowledgeException, MissingKnowledgeException {
      String expression = "\"hello, world\" = \"hello, world1\"";
      KnowledgeBase kb = new KnowledgeBase();
      Boolean result = produceBooleanResult(kb, expression);
      assertFalse(result);
   }

   @Test
   public void doubleInequalitySuccess() throws KnowledgeException, MissingKnowledgeException {
      String expression = "3.14 >= 2.189";
      KnowledgeBase kb = new KnowledgeBase();
      Boolean result = produceBooleanResult(kb, expression);
      assertTrue(result);
   }

   @Test
   public void doubleInequalityNegativeSuccess() throws KnowledgeException, MissingKnowledgeException {
      String expression = "-0.5 < -1.1";
      KnowledgeBase kb = new KnowledgeBase();
      Boolean result = produceBooleanResult(kb, expression);
      assertFalse(result);
   }

   @Test
   public void doubleInequalityEqualSuccess() throws KnowledgeException, MissingKnowledgeException {
      String expression = "0.512 >= 0.512";
      KnowledgeBase kb = new KnowledgeBase();
      Boolean result = produceBooleanResult(kb, expression);
      assertTrue(result);
   }

   @Test
   public void doubleInequalityIntegerSuccess() throws KnowledgeException, MissingKnowledgeException {
      String expression = "123.12 < 123";
      KnowledgeBase kb = new KnowledgeBase();
      Boolean result = produceBooleanResult(kb, expression);
      assertFalse(result);
   }

   @Test
   public void doubleEqualitySuccess() throws KnowledgeException, MissingKnowledgeException {
      String expression = "3.1416 = 3.1416";
      KnowledgeBase kb = new KnowledgeBase();
      Boolean result = produceBooleanResult(kb, expression);
      assertTrue(result);
   }

   @Test
   public void stringListEqualitySuccess() throws KnowledgeException, MissingKnowledgeException {
      String expression = "[\"first string,\", \"second string!\", \"THIRD STRING.\"] IS [\"first string,\", \"second string!\", \"THIRD STRING.\"]";
      KnowledgeBase kb = new KnowledgeBase();
      Boolean result = produceBooleanResult(kb, expression);
      assertTrue(result);
   }

   @Test
   public void doubleListEqualitySuccess() throws KnowledgeException, MissingKnowledgeException {
      String expression = "([123.123, 3.1416, 1, 10.9] IS [123.123, 3.1416, 1.0, 10.9])";
      KnowledgeBase kb = new KnowledgeBase();
      Boolean result = produceBooleanResult(kb, expression);
      assertTrue(result);
   }

   @Test
   public void doubleListEqualityFail() throws KnowledgeException, MissingKnowledgeException {
      String expression = "[123.123, 3.141592, 1, 10.9] IS [123.123, 3.1416, 1.0, 10.9]";
      KnowledgeBase kb = new KnowledgeBase();
      Boolean result = produceBooleanResult(kb, expression);
      assertFalse(result);
   }

   @Test
   public void doubleListInSuccess() throws KnowledgeException, MissingKnowledgeException {
      String expression = "(123.123 IN [123.123, 3.1416, 1.0, 10.9])";
      String expression2 = "3.1416 IN [123.123, 3.1416, 1.0, 10.9]";
      String expression3 = "1 IN [123.123, 3.1416, 1.0, 10.9]";
      String expression4 = "10.9 IN [123.123, 3.1416, 1.0, 10.9]";
      KnowledgeBase kb = new KnowledgeBase();
      Boolean result = produceBooleanResult(kb, expression);
      Boolean result2 = produceBooleanResult(kb, expression2);
      Boolean result3 = produceBooleanResult(kb, expression3);
      Boolean result4 = produceBooleanResult(kb, expression4);
      assertTrue(result && result2 && result3 && result4);
   }

   @Test
   public void stringListInSuccess() throws KnowledgeException, MissingKnowledgeException {
      String expression = "\"first string\" IN [\"first string\", \"Second string!\", \"Third, string?\"]";
      String expression2 = "\"Second string!\" IN [\"first string\", \"Second string!\", \"Third, string?\"]";
      String expression3 = "\"Third, string?\" IN [\"first string\", \"Second string!\", \"Third, string?\"]";
      KnowledgeBase kb = new KnowledgeBase();
      Boolean result = produceBooleanResult(kb, expression);
      Boolean result2 = produceBooleanResult(kb, expression2);
      Boolean result3 = produceBooleanResult(kb, expression3);
      assertTrue(result && result2 && result3);
   }

   @Test
   public void emptyListEqualEmptyListSuccess() throws KnowledgeException, MissingKnowledgeException {
      String expression = "[] IS []";
      KnowledgeBase kb = new KnowledgeBase();
      Boolean result = produceBooleanResult(kb, expression);
      assertTrue(result);
   }

   @Test
   public void stringListInEmptyFails() throws KnowledgeException, MissingKnowledgeException {
      String expression = "\"first string\" IN []";
      KnowledgeBase kb = new KnowledgeBase();
      Boolean result = produceBooleanResult(kb, expression);
      assertFalse(result);
   }

   @Test
   public void doubleListInEmptyFails() throws KnowledgeException, MissingKnowledgeException {
      String expression = "1.0 IN []";
      KnowledgeBase kb = new KnowledgeBase();
      Boolean result = produceBooleanResult(kb, expression);
      assertFalse(result);
   }

   // Interactions with com.enhanced.reasoning.KnowledgeBase
   @Test
   public void failedUnderscoreIdentifierThrowsException() throws KnowledgeException, MissingKnowledgeException {
      String expression = "_test::test IN  [] ";
      KnowledgeBase kb = new KnowledgeBase();

      exceptionRule.expect(KnowledgeException.class);
      exceptionRule.expectMessage("Error when parsing expression \"_test::test IN  [] \". Frame: test doesn't exist");
      Boolean result = produceBooleanResult(kb, expression);
   }


   @Test
   public void failedIdentifierThrowsException() throws KnowledgeException, MissingKnowledgeException {
      String expression = "test1::banana";
      KnowledgeBase kb = new KnowledgeBase();

      exceptionRule.expect(KnowledgeException.class);
      exceptionRule.expectMessage("Error when parsing expression \"test1::banana\". Frame: test1 doesn't exist");
      Boolean result = produceBooleanResult(kb, expression);
   }

   @Test
   public void missingSlotThrowsException() throws KnowledgeException, MissingKnowledgeException {
      String expression = "(Test491::Apple)";
      KnowledgeBase kb = new KnowledgeBase();
      kb.addSpecificFrame(new SpecificFrame("Test491"));

      exceptionRule.expect(MissingKnowledgeException.class);
      exceptionRule.expectMessage("Error when parsing expression \"(Test491::Apple)\". com.shared.Item: Test491 doesn't have a \"Apple\"");
      Boolean result = produceBooleanResult(kb, expression);
   }

   @Test
   public void wrongTypeIdentifierStringThrowsException() throws KnowledgeException, MissingKnowledgeException {
      String expression = "Test91::Ural1 = \"banana\"";
      KnowledgeBase kb = new KnowledgeBase();

      SpecificFrame s = new SpecificFrame("Test91");
      s.updateFiller("Ural1", true);
      kb.addSpecificFrame(s);

      exceptionRule.expect(KnowledgeException.class);
      exceptionRule.expectMessage("Error when parsing expression \"Test91::Ural1 = \"banana\"\". Couldn't cast the result of query for frame: Test91, slot: Ural1 - true - to String");
      Boolean result = produceBooleanResult(kb, expression);
   }

   @Test
   public void wrongTypeIdentifierDoubleThrowsException() throws KnowledgeException, MissingKnowledgeException {
      String expression = "Test92::Ural12 >= 4.0";
      KnowledgeBase kb = new KnowledgeBase();

      SpecificFrame s = new SpecificFrame("Test92");
      s.updateFiller("Ural12", "hello");
      SpecificFrame s2 = new SpecificFrame("Test92");
      s2.updateFiller("Ural123", 4.5);
      kb.addSpecificFrame(s);
      kb.addSpecificFrame(s2);

      exceptionRule.expect(KnowledgeException.class);
      exceptionRule.expectMessage("Error when parsing expression \"Test92::Ural12 >= 4.0\". Couldn't cast the result of query for frame: Test92, slot: Ural12 - hello - to Double");
      Boolean result = produceBooleanResult(kb, expression);
   }


   @Test
   public void identifierStringExpressionSuccess() throws KnowledgeException, MissingKnowledgeException {
      String expression = "Test932::Ural1234 = \"hello\"";
      KnowledgeBase kb = new KnowledgeBase();

      SpecificFrame s = new SpecificFrame("Test932");
      s.updateFiller("Ural1234", "hello");
      SpecificFrame s2 = new SpecificFrame("Test92");
      s2.updateFiller("Ural123", 4.5);
      kb.addSpecificFrame(s);
      kb.addSpecificFrame(s2);

      Boolean result = produceBooleanResult(kb, expression);
      assertTrue(result);
   }

   @Test
   public void identifierBooleanExpressionSuccess() throws KnowledgeException, MissingKnowledgeException {
      String expression = "Test9324::Ural123456";
      KnowledgeBase kb = new KnowledgeBase();

      SpecificFrame s = new SpecificFrame("Test9324");
      s.updateFiller("Ural12345", "hello");
      s.updateFiller("Ural123456", false);
      SpecificFrame s2 = new SpecificFrame("Test92");
      s2.updateFiller("Ural123456", true);
      kb.addSpecificFrame(s);
      kb.addSpecificFrame(s2);

      Boolean result = produceBooleanResult(kb, expression);
      assertFalse(result);
   }

   @Test
   public void identifierDoubleExpressionSuccess() throws KnowledgeException, MissingKnowledgeException {
      String expression = "Test93245::Ural1234567 > 3.01";
      KnowledgeBase kb = new KnowledgeBase();

      SpecificFrame s = new SpecificFrame("Test93245");
      s.updateFiller("Ural12345", "hello");
      s.updateFiller("Ural1234567", 4.0);
      SpecificFrame s2 = new SpecificFrame("Test92");
      s2.updateFiller("Ural123456", -1.012);
      kb.addSpecificFrame(s);
      kb.addSpecificFrame(s2);

      Boolean result = produceBooleanResult(kb, expression);
      assertTrue(result);
   }
   // TODO : TEST DOUBLE IDENTIFEIR THING MORE THOROUGHLY
   @Test
   public void twoIdentifierNonBoolComparatorDoubles() throws KnowledgeException, MissingKnowledgeException {
      String expression = "Test935::Ural17 > Test92::Banana";
      KnowledgeBase kb = new KnowledgeBase();

      SpecificFrame s = new SpecificFrame("Test935");
      s.updateFiller("Ural125", "hello");
      s.updateFiller("Ural17", 4.0);
      SpecificFrame s2 = new SpecificFrame("Test92");
      s2.updateFiller("Banana", -1.0);
      kb.addSpecificFrame(s);
      kb.addSpecificFrame(s2);

      Boolean result = produceBooleanResult(kb, expression);
      assertTrue(result);
   }

   @Test
   public void twoIdentifierNonBoolComparatorStrings() throws KnowledgeException, MissingKnowledgeException {
      String expression = "Test92::Banana < Test935::Ural ";
      KnowledgeBase kb = new KnowledgeBase();

      SpecificFrame s = new SpecificFrame("Test935");
      s.updateFiller("Ural", "hello");
      s.updateFiller("Ural17", 4.0);
      SpecificFrame s2 = new SpecificFrame("Test92");
      s2.updateFiller("Banana", "yes");
      kb.addSpecificFrame(s);
      kb.addSpecificFrame(s2);

      Boolean result = produceBooleanResult(kb, expression);
      assertFalse(result);
   }


}