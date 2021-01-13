import static org.junit.Assert.*;


import com.enhanced.reasoning.KnowledgeRegex;
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

   @Test
   public void testKnowledgeSyntaxMatches() {
      String frame = "frame";
      String slot = "slot";
      String test = frame + "::" + slot;
      String knowledgeExpr = KnowledgeRegex.knowledgeExpr;

      assertTrue(Pattern.matches(knowledgeExpr, test));
   }

   @SuppressWarnings("AssertWithSideEffects")
   @Test
   public void testKnowledgeSyntaxContents() {
      String frame = "frame";
      String slot = "slot";
      String test = frame + "::" + slot;
      String knowledgeExpr = KnowledgeRegex.knowledgeExpr;
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
      String test = "_" + frame + "::" + slot;
      String knowledgeExpr = KnowledgeRegex.knowledgeExpr;

      assertTrue(Pattern.matches(knowledgeExpr, test));
   }

   @SuppressWarnings("AssertWithSideEffects")
   @Test
   public void testKnowledgeSyntaxUnderscoreContents() {
      String frame = "frame01";
      String slot = "sl12o2t";
      String test = "_" + frame + "::" + slot;
      String knowledgeExpr = KnowledgeRegex.knowledgeExpr;
      List<String> expectedList = List.of(frame, slot);

      Pattern p = Pattern.compile(knowledgeExpr);
      Matcher m = p.matcher(test);

      assert (m.matches());
      assertEquals(expectedList, matchingGroups(m));
   }

   @Test
   public void testJustFrameDoesntMatchKnowledge() {
      String frame = "_frame";
      String knowledgeExpr = KnowledgeRegex.knowledgeExpr;

      assertFalse(Pattern.matches(knowledgeExpr, frame));
   }

   @Test
   public void testFrameAndColonsDontMatchKnowledge() {
      String frame = "_frame";
      String test = frame + "::";
      String knowledgeExpr = KnowledgeRegex.knowledgeExpr;

      assertFalse(Pattern.matches(knowledgeExpr, test));
   }


   @Test
   public void testFrameMatches() {
      String frame = "frame01";
      String frameExpr = KnowledgeRegex.frameNameExpr;

      assertTrue(Pattern.matches(frameExpr, frame));
   }

   @Test
   public void testIntegerNumberMatches() {
      String number = "469";
      String numberExpr = KnowledgeRegex.numberExpr;

      assertTrue(Pattern.matches(numberExpr, number));
   }

   @Test
   public void testDecimalNumberMatches() {
      String number = "1859.134913";
      String numberExpr = KnowledgeRegex.numberExpr;

      assertTrue(Pattern.matches(numberExpr, number));
   }

   @Test
   public void testStartingDotDoesntMatch() {
      String number = ".213";
      String numberExpr = KnowledgeRegex.numberExpr;

      assertFalse(Pattern.matches(numberExpr, number));
   }

   @Test
   public void testEmptyStringMatches() {
      String string = "\"\"";
      String stringExpr = KnowledgeRegex.stringExpr;

      assertTrue(Pattern.matches(stringExpr, string));
   }

   @Test
   public void testFilledStringMatches() {
      String string = "\" I love pizza. Do you like it? I am also empty-minded and funny. My age is 20. \"";
      String stringExpr = KnowledgeRegex.stringExpr;

      assertTrue(Pattern.matches(stringExpr, string));
   }

   @Test
   public void testEmptyStringList() {
      String string = "[]";
      String stringListExpr = KnowledgeRegex.stringListExpr;

      assertTrue(Pattern.matches(stringListExpr, string));
   }

   @Test
   public void testOneItemStringList() {
      String string = "[\"banana!\"]";
      String stringListExpr = KnowledgeRegex.stringListExpr;

      assertTrue(Pattern.matches(stringListExpr, string));
   }

   @Test
   public void testThreeItemStringList() {
      String string = "[\"banana!\", \"?!.\", \"pizza amd bamama\"]";
      String stringListExpr = KnowledgeRegex.stringListExpr;

      assertTrue(Pattern.matches(stringListExpr, string));
   }

   @Test
   public void testStringListDoesntMatchDoubleList() {
      String string = "[4.0, 1, 6]";
      String stringListExpr = KnowledgeRegex.stringListExpr;

      assertFalse(Pattern.matches(stringListExpr, string));
   }

   @Test
   public void testStringListDoesntMatchString() {
      String string = "\"banana\"";
      String stringListExpr = KnowledgeRegex.stringListExpr;

      assertFalse(Pattern.matches(stringListExpr, string));
   }

   @Test
   public void testEmptyNumberList() {
      String string = "[]";
      String numberListExpr = KnowledgeRegex.numberListExpr;

      assertTrue(Pattern.matches(numberListExpr, string));
   }

   @Test
   public void testSingleNumberList() {
      String string = "[1.042134]";
      String numberListExpr = KnowledgeRegex.numberListExpr;

      assertTrue(Pattern.matches(numberListExpr, string));
   }

   @Test
   public void testTripleNumberList() {
      String string = "[1.042134, 1, 21039123]";
      String numberListExpr = KnowledgeRegex.numberListExpr;

      assertTrue(Pattern.matches(numberListExpr, string));
   }

   @Test
   public void testNumberListNoMatchDouble() {
      String string = "1.04213";
      String numberListExpr = KnowledgeRegex.numberListExpr;

      assertFalse(Pattern.matches(numberListExpr, string));
   }

   @Test
   public void frameNameExpr() {
      String string = "_Banan1";
      String frameNameExpr = KnowledgeRegex.frameNameExpr;

      assertTrue(Pattern.matches(frameNameExpr, string));
   }


}