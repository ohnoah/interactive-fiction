import static org.junit.Assert.*;


import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ConditionEvaluationVisitorTest {

   @Rule
   public ExpectedException exceptionRule = ExpectedException.none();

   private Boolean produceResult(KnowledgeBase kb, String expression) throws KnowledgeException {
      return kb.conditionFails(expression);
   }


   // No Knowledge Base Tests
   @Test
   public void loneStringFailedParseException() throws KnowledgeException {
      String expression = "\"Hello world. I'm John Doe ? and this should fail\"";
      exceptionRule.expect(ParseCancellationException.class);
      exceptionRule.expectMessage("line 1:50 no viable alternative at input '\"Hello world. I'm John Doe ? and this should fail\"'");
      KnowledgeBase kb = new KnowledgeBase();
      produceResult(kb, expression);
   }


   @Test
   public void loneDoubleFailedParseException() throws KnowledgeException {
      String expression = "123.4567";
      exceptionRule.expect(ParseCancellationException.class);
      exceptionRule.expectMessage("line 1:8 no viable alternative at input '123.4567'");
      KnowledgeBase kb = new KnowledgeBase();
      produceResult(kb, expression);
   }

   @Test
   public void loneTrueSuccess() throws KnowledgeException {
      String expression = "TRUE";
      KnowledgeBase kb = new KnowledgeBase();
      Boolean result = produceResult(kb, expression);
      assertTrue(result);
   }

   @Test
   public void loneFalseSuccess() throws KnowledgeException {
      String expression = "FALSE";
      KnowledgeBase kb = new KnowledgeBase();
      Boolean result = produceResult(kb, expression);
      assertFalse(result);
   }

   @Test
   public void bracketedBoolEqualExpression() throws KnowledgeException {
      String expression = "(1.0 IN [])=FALSE";
      KnowledgeBase kb = new KnowledgeBase();
      Boolean result = produceResult(kb, expression);
      assertTrue(result);
   }

   @Test
   public void bracketedBoolEqualNotExpression() throws KnowledgeException {
      String expression = "(1.0 IN [])=(NOT TRUE)";
      KnowledgeBase kb = new KnowledgeBase();
      Boolean result = produceResult(kb, expression);
      assertTrue(result);
   }

   @Test
   public void notTrueIsFalse() throws KnowledgeException {
      String expression = "NOT TRUE = FALSE";
      KnowledgeBase kb = new KnowledgeBase();
      Boolean result = produceResult(kb, expression);
      assertTrue(result);
   }

   @Test
   public void simpleAndSuccess() throws KnowledgeException {
      String expression = "TRUE AND FALSE";
      KnowledgeBase kb = new KnowledgeBase();
      Boolean result = produceResult(kb, expression);
      assertFalse(result);
   }

   @Test
   public void compositeOrAndSuccess() throws KnowledgeException {
      String expression = "(TRUE OR FALSE) AND (TRUE)";
      KnowledgeBase kb = new KnowledgeBase();
      Boolean result = produceResult(kb, expression);
      assertTrue(result);
   }

   @Test
   public void compositeIdentifierOrAndSuccess() throws KnowledgeException {
      String expression = "(_test::banna OR TRUE) AND (TRUE)";
      KnowledgeBase kb = new KnowledgeBase();
      SpecificFrame s = new SpecificFrame("test");
      s.updateFiller("banna", false);
      kb.addSpecificFrame(s);
      Boolean result = produceResult(kb, expression);
      assertTrue(result);
   }


   @Test
   public void stringInequalitySuccess() throws KnowledgeException {
      String expression = "\"aaa!!!\" > \"bbbAAA\"";
      KnowledgeBase kb = new KnowledgeBase();
      Boolean result = produceResult(kb, expression);
      assertFalse(result);
   }

   @Test
   public void stringInequalityEqualSuccess() throws KnowledgeException {
      String expression = "\"abc\" <= \"abc\"";
      KnowledgeBase kb = new KnowledgeBase();
      Boolean result = produceResult(kb, expression);
      assertTrue(result);
   }

   @Test
   public void stringInequalitySymmetry() throws KnowledgeException {
      String expression = "\"aaa!!!\" >= \"bbbAAA\"";
      String expressionSwapped = "\"bbbAAA\" <= \"aaa!!!\"";
      KnowledgeBase kb = new KnowledgeBase();
      Boolean result = produceResult(kb, expression);
      Boolean resultSwapped = produceResult(kb, expressionSwapped);
      assertEquals(result, resultSwapped);
   }

   @Test
   public void stringStrictInequalitySymmetry() throws KnowledgeException {
      String expression = "\"!?.\" >= \"okok\"";
      String expressionSwapped = "\"okok\" <= \"!?.\"";
      KnowledgeBase kb = new KnowledgeBase();
      Boolean result = produceResult(kb, expression);
      Boolean resultSwapped = produceResult(kb, expressionSwapped);
      assertEquals(result, resultSwapped);
   }

   @Test
   public void stringEqualitySuccess() throws KnowledgeException {
      String expression = "\"hello, world\" = \"hello, world\"";
      KnowledgeBase kb = new KnowledgeBase();
      Boolean result = produceResult(kb, expression);
      assertTrue(result);
   }

   @Test
   public void doubleInequalitySuccess() throws KnowledgeException {
      String expression = "3.14 >= 2.189";
      KnowledgeBase kb = new KnowledgeBase();
      Boolean result = produceResult(kb, expression);
      assertTrue(result);
   }

   @Test
   public void doubleInequalityNegativeSuccess() throws KnowledgeException {
      String expression = "-0.5 < -1.1";
      KnowledgeBase kb = new KnowledgeBase();
      Boolean result = produceResult(kb, expression);
      assertFalse(result);
   }

   @Test
   public void doubleInequalityEqualSuccess() throws KnowledgeException {
      String expression = "0.512 >= 0.512";
      KnowledgeBase kb = new KnowledgeBase();
      Boolean result = produceResult(kb, expression);
      assertTrue(result);
   }

   @Test
   public void doubleInequalityIntegerSuccess() throws KnowledgeException {
      String expression = "123.12 < 123";
      KnowledgeBase kb = new KnowledgeBase();
      Boolean result = produceResult(kb, expression);
      assertFalse(result);
   }

   @Test
   public void doubleEqualitySuccess() throws KnowledgeException {
      String expression = "3.1416 = 3.1416";
      KnowledgeBase kb = new KnowledgeBase();
      Boolean result = produceResult(kb, expression);
      assertTrue(result);
   }

   @Test
   public void stringListEqualitySuccess() throws KnowledgeException {
      String expression = "[\"first string,\", \"second string!\", \"THIRD STRING.\"] = [\"first string,\", \"second string!\", \"THIRD STRING.\"]";
      KnowledgeBase kb = new KnowledgeBase();
      Boolean result = produceResult(kb, expression);
      assertTrue(result);
   }

   @Test
   public void doubleListEqualitySuccess() throws KnowledgeException {
      String expression = "([123.123, 3.1416, 1, 10.9] = [123.123, 3.1416, 1.0, 10.9])";
      KnowledgeBase kb = new KnowledgeBase();
      Boolean result = produceResult(kb, expression);
      assertTrue(result);
   }

   @Test
   public void doubleListEqualityFail() throws KnowledgeException {
      String expression = "[123.123, 3.141592, 1, 10.9] = [123.123, 3.1416, 1.0, 10.9]";
      KnowledgeBase kb = new KnowledgeBase();
      Boolean result = produceResult(kb, expression);
      assertFalse(result);
   }

   @Test
   public void doubleListInSuccess() throws KnowledgeException {
      String expression = "(123.123 IN [123.123, 3.1416, 1.0, 10.9])";
      String expression2 = "3.1416 IN [123.123, 3.1416, 1.0, 10.9]";
      String expression3 = "1 IN [123.123, 3.1416, 1.0, 10.9]";
      String expression4 = "10.9 IN [123.123, 3.1416, 1.0, 10.9]";
      KnowledgeBase kb = new KnowledgeBase();
      Boolean result = produceResult(kb, expression);
      Boolean result2 = produceResult(kb, expression2);
      Boolean result3 = produceResult(kb, expression3);
      Boolean result4 = produceResult(kb, expression4);
      assertTrue(result && result2 && result3 && result4);
   }

   @Test
   public void stringListInSuccess() throws KnowledgeException {
      String expression = "\"first string\" IN [\"first string\", \"Second string!\", \"Third, string?\"]";
      String expression2 = "\"Second string!\" IN [\"first string\", \"Second string!\", \"Third, string?\"]";
      String expression3 = "\"Third, string?\" IN [\"first string\", \"Second string!\", \"Third, string?\"]";
      KnowledgeBase kb = new KnowledgeBase();
      Boolean result = produceResult(kb, expression);
      Boolean result2 = produceResult(kb, expression2);
      Boolean result3 = produceResult(kb, expression3);
      assertTrue(result && result2 && result3);
   }

   @Test
   public void emptyListEqualEmptyListSuccess() throws KnowledgeException {
      String expression = "[] = []";
      KnowledgeBase kb = new KnowledgeBase();
      Boolean result = produceResult(kb, expression);
      assertTrue(result);
   }

   @Test
   public void stringListInEmptyFails() throws KnowledgeException {
      String expression = "\"first string\" IN []";
      KnowledgeBase kb = new KnowledgeBase();
      Boolean result = produceResult(kb, expression);
      assertFalse(result);
   }

   @Test
   public void doubleListInEmptyFails() throws KnowledgeException {
      String expression = "1.0 IN []";
      KnowledgeBase kb = new KnowledgeBase();
      Boolean result = produceResult(kb, expression);
      assertFalse(result);
   }

   // Interactions with KnowledgeBase
   @Test
   public void failedUnderscoreIdentifierThrowsException() throws KnowledgeException {
      String expression = "_test::test IN  [] ";
      KnowledgeBase kb = new KnowledgeBase();

      exceptionRule.expect(KnowledgeException.class);
      exceptionRule.expectMessage("Error when parsing expression \"_test::test IN  [] \". Frame: test doesn't exist");
      Boolean result = produceResult(kb, expression);
   }


   @Test
   public void failedIdentifierThrowsException() throws KnowledgeException {
      String expression = "test1::banana";
      KnowledgeBase kb = new KnowledgeBase();

      exceptionRule.expect(KnowledgeException.class);
      exceptionRule.expectMessage("Error when parsing expression \"test1::banana\". Frame: test1 doesn't exist");
      Boolean result = produceResult(kb, expression);
   }

   @Test
   public void missingSlotThrowsException() throws KnowledgeException {
      String expression = "(Test491::Apple)";
      KnowledgeBase kb = new KnowledgeBase();
      kb.addSpecificFrame(new SpecificFrame("Test491"));

      exceptionRule.expect(KnowledgeException.class);
      exceptionRule.expectMessage("Error when parsing expression \"(Test491::Apple)\". Slot: Apple on Frame: SpecificFrame{id='Test491'} is missing.");
      Boolean result = produceResult(kb, expression);
   }

   @Test
   public void wrongTypeIdentifierStringThrowsException() throws KnowledgeException {
      String expression = "Test91::Ural1 = \"banana\"";
      KnowledgeBase kb = new KnowledgeBase();

      SpecificFrame s = new SpecificFrame("Test91");
      s.updateFiller("Ural1", true);
      kb.addSpecificFrame(s);

      exceptionRule.expect(KnowledgeException.class);
      exceptionRule.expectMessage("Error when parsing expression \"Test91::Ural1 = \"banana\"\". Couldn't cast the result of query for frame: Test91, slot: Ural1 - true - to String");
      Boolean result = produceResult(kb, expression);
   }

   @Test
   public void wrongTypeIdentifierDoubleThrowsException() throws KnowledgeException {
      String expression = "Test92::Ural12 >= 4.0";
      KnowledgeBase kb = new KnowledgeBase();

      SpecificFrame s = new SpecificFrame("Test92");
      s.updateFiller("Ural12", "hello");
      SpecificFrame s2 = new SpecificFrame("Test92");
      s2.updateFiller("Ural123", 4.5);
      kb.addSpecificFrame(s);

      exceptionRule.expect(KnowledgeException.class);
      exceptionRule.expectMessage("Error when parsing expression \"Test92::Ural12 >= 4.0\". Couldn't cast the result of query for frame: Test92, slot: Ural12 - hello - to Double");
      Boolean result = produceResult(kb, expression);
   }


   @Test
   public void identifierStringExpressionSuccess() throws KnowledgeException {
      String expression = "Test932::Ural1234 = \"hello\"";
      KnowledgeBase kb = new KnowledgeBase();

      SpecificFrame s = new SpecificFrame("Test932");
      s.updateFiller("Ural1234", "hello");
      SpecificFrame s2 = new SpecificFrame("Test92");
      s2.updateFiller("Ural123", 4.5);
      kb.addSpecificFrame(s);

      Boolean result = produceResult(kb, expression);
      assertTrue(result);
   }

   @Test
   public void identifierBooleanExpressionSuccess() throws KnowledgeException {
      String expression = "Test9324::Ural123456";
      KnowledgeBase kb = new KnowledgeBase();

      SpecificFrame s = new SpecificFrame("Test9324");
      s.updateFiller("Ural12345", "hello");
      s.updateFiller("Ural123456", false);
      SpecificFrame s2 = new SpecificFrame("Test92");
      s2.updateFiller("Ural123456", true);
      kb.addSpecificFrame(s);

      Boolean result = produceResult(kb, expression);
      assertFalse(result);
   }

   @Test
   public void identifierDoubleExpressionSuccess() throws KnowledgeException {
      String expression = "Test93245::Ural1234567 > 3.01";
      KnowledgeBase kb = new KnowledgeBase();

      SpecificFrame s = new SpecificFrame("Test93245");
      s.updateFiller("Ural12345", "hello");
      s.updateFiller("Ural1234567", 4.0);
      SpecificFrame s2 = new SpecificFrame("Test92");
      s2.updateFiller("Ural123456", -1);
      kb.addSpecificFrame(s);

      Boolean result = produceResult(kb, expression);
      assertTrue(result);
   }


}