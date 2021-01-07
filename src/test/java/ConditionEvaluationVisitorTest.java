import static org.junit.Assert.*;


import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ConditionEvaluationVisitorTest {

   @Rule
   public ExpectedException exceptionRule = ExpectedException.none();

   public Object produceResult(KnowledgeBase kb, String expression) throws KnowledgeException {
      ConditionEvaluationVisitor conditionEvaluationVisitor = new ConditionEvaluationVisitor(kb);
      return VisitorFactory.evaluateCondition(conditionEvaluationVisitor, expression);
   }

   // No Knowledge Base Tests
   @Test
   public void loneStringFailedParseException() throws KnowledgeException {
      String expression = "\"Hello world. I'm John Doe ? and this should fail\"";
      exceptionRule.expect(ParseCancellationException.class);
      exceptionRule.expectMessage("line 1:7 mismatched input 'Hello world. I'm John Doe ? and this should fail' expecting STRING");
      KnowledgeBase kb = new KnowledgeBase();
      produceResult(kb, expression);
   }

   // Interactions with KnowledgeBase
}