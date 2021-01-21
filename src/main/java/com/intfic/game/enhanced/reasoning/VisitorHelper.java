package com.intfic.game.enhanced.reasoning;

import com.intfic.game.enhanced.reasoning.error.*;
import com.intfic.game.enhanced.parser.SimpleBooleanLexer;
import com.intfic.game.enhanced.parser.SimpleBooleanParser;
import com.intfic.game.enhanced.reasoning.visitors.ConditionEvaluationVisitor;
import com.intfic.game.enhanced.reasoning.visitors.TypeConvertVisitor;
import com.intfic.game.enhanced.typeconverter.ConstantsLexer;
import com.intfic.game.enhanced.typeconverter.ConstantsParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class VisitorHelper {
   public static Object typeConvert(TypeConvertVisitor typeConvertVisitor, String expression) {
      ConstantsLexer lexer = new ConstantsLexer(CharStreams.fromString(expression));
      lexer.removeErrorListeners();
      lexer.addErrorListener(ThrowingErrorListener.INSTANCE);
      ConstantsParser parser = new ConstantsParser(new CommonTokenStream(lexer));
      parser.removeErrorListeners();
      parser.addErrorListener(ThrowingErrorListener.INSTANCE);
      return typeConvertVisitor.visit(parser.typeconvert());
   }

   public static Boolean evaluateCondition(ConditionEvaluationVisitor conditionEvaluationVisitor, String expression) throws KnowledgeException, MissingKnowledgeException {
      SimpleBooleanLexer lexer = new SimpleBooleanLexer(CharStreams.fromString(expression));
      lexer.removeErrorListeners();
      lexer.addErrorListener(ThrowingErrorListener.INSTANCE);
      SimpleBooleanParser parser = new SimpleBooleanParser(new CommonTokenStream(lexer));
      parser.removeErrorListeners();
      parser.addErrorListener(ThrowingErrorListener.INSTANCE);

      try {
         return (Boolean) conditionEvaluationVisitor.visit(parser.parse());
      } catch (RuntimeKnowledgeException e) {
         throw new KnowledgeException("Error when parsing expression \"" + expression + "\". " + e.getMessage(), e);
      }
      catch (RuntimeMissingException e){
         throw new MissingKnowledgeException("Error when parsing expression \"" + expression + "\". " + e.getMessage(), e, e.getMissingString());
      }
   }
}
