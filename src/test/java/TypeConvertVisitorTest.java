import static org.junit.Assert.*;


import java.util.List;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TypeConvertVisitorTest {

   public Object produceResult(String expression) {
      TypeConvertVisitor typeConvertVisitor = new TypeConvertVisitor();
      return VisitorFactory.typeConvert(typeConvertVisitor, expression);
   }

   @Test
   public void validStringListSucceeds() {
      String expression = "[\"hello\", \"\", \"this is great\", \"A bird. fly\n" +
          " across ! the empty nest-\", \"great-fun\"]";

      List<String> desiredResult = List.of("hello", "", "this is great", "A bird. fly\n across ! the empty nest-", "great-fun");
      List<String> result = (List<String>) produceResult(expression);
      assertEquals(desiredResult, result);
   }

   @Test
   public void validDoubleListSucceeds() {
      String expression = "[0, 0.123123, 125.125, 697123.123456789]";

      List<Double> desiredResult = List.of(0.0, 0.123123, 125.125, 697123.123456789);
      List<Double> result = (List<Double>) produceResult(expression);
      assertEquals(desiredResult, result);
   }

   @Rule
   public ExpectedException exceptionRule = ExpectedException.none();
   @Test
   public void mixedListFails() {
      String expression = "[\"hi\", 0.123123, \"125.125\", 697123.123456789]";

      exceptionRule.expect(ParseCancellationException.class);
      exceptionRule.expectMessage("line 1:7 mismatched input '0.123123' expecting STRING");
      produceResult(expression);
   }

   @Test
   public void validDecimalDoubleSucceeds() {
      String expression = "3.14159652";

      Double desiredResult = 3.14159652;
      Double result = (Double) produceResult(expression);
      assertEquals(desiredResult, result);
   }

   @Test
   public void validIntegerDoubleSucceeds() {
      String expression = "12358123";

      Double desiredResult = 12358123.0;
      Double result = (Double) produceResult(expression);
      assertEquals(desiredResult, result);
   }

   @Test
   public void validTrueBooleanSucceeds() {
      String expression = "TRUE";

      Boolean desiredResult = true;
      Boolean result = (Boolean) produceResult(expression);
      assertEquals(desiredResult, result);
   }
   @Test
   public void validFalseBooleanSucceeds() {
      String expression = "FALSE";

      Boolean desiredResult = false;
      Boolean result = (Boolean) produceResult(expression);
      assertEquals(desiredResult, result);
   }

   @Test
   public void validEmptyStringSucceeds() {
      String expression = "\"\"";

      String desiredResult = "";
      String result = (String) produceResult(expression);
      assertEquals(desiredResult, result);
   }

   @Test
   public void validStringSucceeds() {
      String expression = "\"Hi. My name is John Doe and I'm arriving here from the !?\"";

      String desiredResult = "Hi. My name is John Doe and I'm arriving here from the !?";
      String result = (String) produceResult(expression);
      assertEquals(desiredResult, result);
   }

}