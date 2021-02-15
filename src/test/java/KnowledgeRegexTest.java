import static org.junit.Assert.*;


import com.intfic.game.basic.BasicGameEngine;
import com.intfic.game.enhanced.reasoning.KnowledgeRegex;
import com.intfic.game.shared.ActionFormat;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.Test;

public class KnowledgeRegexTest {

   private List<String> matchingGroups(Matcher m) {
      return IntStream.range(1, m.groupCount() + 1).mapToObj(m::group).collect(Collectors.toList());
   }

   private String identifierToken = "!";

   @Test
   public void testKnowledgeSyntaxMatches() {
      String frame = "frame";
      String slot = "slot";
      String test = frame + "::" + slot;
      String knowledgeExpr = KnowledgeRegex.KNOWLEDGE_EXPR;

      assertTrue(Pattern.matches(knowledgeExpr, test));
   }

   @SuppressWarnings("AssertWithSideEffects")
   @Test
   public void testKnowledgeSyntaxContents() {
      String frame = "frame";
      String slot = "slot";
      String test = frame + "::" + slot;
      String knowledgeExpr = KnowledgeRegex.KNOWLEDGE_EXPR;
      System.out.println(knowledgeExpr);
      List<String> expectedList = List.of(frame, slot);

      Pattern p = Pattern.compile(knowledgeExpr);
      Matcher m = p.matcher(test);

      assert (m.matches());
      assertEquals(expectedList, matchingGroups(m));
   }


   @Test
   public void testKnowledgeSyntaxUnderscoreMatches() {
      String frame = "frame01";
      String slot = "sl12o2t";
      String test = identifierToken + frame + "::" + slot;
      String knowledgeExpr = KnowledgeRegex.KNOWLEDGE_EXPR;

      assertTrue(Pattern.matches(knowledgeExpr, test));
   }

   @SuppressWarnings("AssertWithSideEffects")
   @Test
   public void testKnowledgeSyntaxUnderscoreContents() {
      String frame = "frame01";
      String slot = "sl12o2t";
      String test = identifierToken + frame + "::" + slot;
      String knowledgeExpr = KnowledgeRegex.KNOWLEDGE_EXPR;
      List<String> expectedList = List.of(frame, slot);

      Pattern p = Pattern.compile(knowledgeExpr);
      Matcher m = p.matcher(test);

      assert (m.matches());
      assertEquals(expectedList, matchingGroups(m));
   }

   @Test
   public void testJustFrameDoesntMatchKnowledge() {
      String frame = "_frame";
      String knowledgeExpr = KnowledgeRegex.KNOWLEDGE_EXPR;

      assertFalse(Pattern.matches(knowledgeExpr, frame));
   }

   @Test
   public void testFrameAndColonsDontMatchKnowledge() {
      String frame = "_frame";
      String test = frame + "::";
      String knowledgeExpr = KnowledgeRegex.KNOWLEDGE_EXPR;

      assertFalse(Pattern.matches(knowledgeExpr, test));
   }


   @Test
   public void testFrameMatches() {
      String frame = "frame01";
      String frameExpr = KnowledgeRegex.FRAME_NAME_EXPR;

      assertTrue(Pattern.matches(frameExpr, frame));
   }

   @Test
   public void testIntegerNumberMatches() {
      String number = "469";
      String numberExpr = KnowledgeRegex.NUMBER_EXPR;

      assertTrue(Pattern.matches(numberExpr, number));
   }

   @Test
   public void testDecimalNumberMatches() {
      String number = "1859.134913";
      String numberExpr = KnowledgeRegex.NUMBER_EXPR;

      assertTrue(Pattern.matches(numberExpr, number));
   }

   @Test
   public void testStartingDotDoesntMatch() {
      String number = ".213";
      String numberExpr = KnowledgeRegex.NUMBER_EXPR;

      assertFalse(Pattern.matches(numberExpr, number));
   }

   @Test
   public void testEmptyStringMatches() {
      String string = "\"\"";
      String stringExpr = KnowledgeRegex.STRING_EXPR;

      assertTrue(Pattern.matches(stringExpr, string));
   }

   @Test
   public void testFilledStringMatches() {
      String string = "\" I love pizza. Do you like it? I am also empty-minded and funny. My age is 20. \"";
      String stringExpr = KnowledgeRegex.STRING_EXPR;

      assertTrue(Pattern.matches(stringExpr, string));
   }

   @Test
   public void testEmptyStringList() {
      String string = "[]";
      String stringListExpr = KnowledgeRegex.STRING_LIST_EXPR;

      assertTrue(Pattern.matches(stringListExpr, string));
   }

   @Test
   public void testOneItemStringList() {
      String string = "[\"banana!\"]";
      String stringListExpr = KnowledgeRegex.STRING_LIST_EXPR;

      assertTrue(Pattern.matches(stringListExpr, string));
   }

   @Test
   public void testThreeItemStringList() {
      String string = "[\"banana!\", \"?!.\", \"pizza amd bamama\"]";
      String stringListExpr = KnowledgeRegex.STRING_LIST_EXPR;

      assertTrue(Pattern.matches(stringListExpr, string));
   }

   @Test
   public void testStringListDoesntMatchDoubleList() {
      String string = "[4.0, 1, 6]";
      String stringListExpr = KnowledgeRegex.STRING_LIST_EXPR;

      assertFalse(Pattern.matches(stringListExpr, string));
   }

   @Test
   public void testStringListDoesntMatchString() {
      String string = "\"banana\"";
      String stringListExpr = KnowledgeRegex.STRING_LIST_EXPR;

      assertFalse(Pattern.matches(stringListExpr, string));
   }

   @Test
   public void testEmptyNumberList() {
      String string = "[]";
      String numberListExpr = KnowledgeRegex.NUMBER_LIST_EXPR;

      assertTrue(Pattern.matches(numberListExpr, string));
   }

   @Test
   public void testSingleNumberList() {
      String string = "[1.042134]";
      String numberListExpr = KnowledgeRegex.NUMBER_LIST_EXPR;

      assertTrue(Pattern.matches(numberListExpr, string));
   }

   @Test
   public void testTripleNumberList() {
      String string = "[1.042134, 1, 21039123]";
      String numberListExpr = KnowledgeRegex.NUMBER_LIST_EXPR;

      assertTrue(Pattern.matches(numberListExpr, string));
   }

   @Test
   public void testNumberListNoMatchDouble() {
      String string = "1.04213";
      String numberListExpr = KnowledgeRegex.NUMBER_LIST_EXPR;

      assertFalse(Pattern.matches(numberListExpr, string));
   }

   @Test
   public void frameNameExpr() {
      String string = "_Banan1";
      String frameNameExpr = KnowledgeRegex.FRAME_NAME_EXPR;

      assertTrue(Pattern.matches(frameNameExpr, string));
   }

   @Test
   public void actionFormatToStringPut() {
      ActionFormat a = (new BasicGameEngine()).findAction("put").get(0);
      assertEquals("put [0] in [1]", a.toString());
   }

   @Test
   public void actionFormatToStringOpen() {
      ActionFormat a = (new BasicGameEngine()).findAction("open").get(0);
      assertEquals("open [0]", a.toString());
   }

   @Test
   public void actionFormatToStringListen() {
      ActionFormat a = (new BasicGameEngine()).findAction("listen").get(0);
      assertEquals("listen to [0]", a.toString());
   }


}