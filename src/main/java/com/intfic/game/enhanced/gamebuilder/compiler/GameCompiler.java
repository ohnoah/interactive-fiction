package com.intfic.game.enhanced.gamebuilder.compiler;

import com.intfic.game.enhanced.EnhancedGameEngine;
import com.intfic.game.enhanced.gamebuilder.generated.GameGrammarLexer;
import com.intfic.game.enhanced.gamebuilder.generated.GameGrammarParser;
import com.intfic.game.enhanced.reasoning.error.ThrowingErrorListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class GameCompiler {

   public static EnhancedGameEngine compile(String gameFile) {
      GameFileVisitor gameFileVisitor = new GameFileVisitor();
      GameGrammarLexer lexer = new GameGrammarLexer(CharStreams.fromString(gameFile));
      lexer.removeErrorListeners();
      lexer.addErrorListener(ThrowingErrorListener.INSTANCE);
      GameGrammarParser parser = new GameGrammarParser(new CommonTokenStream(lexer));
      parser.removeErrorListeners();
      parser.addErrorListener(ThrowingErrorListener.INSTANCE);
      return gameFileVisitor.visitGame(parser.game());
   }

   public static EnhancedGameEngine compile(Path gameFile) throws IOException {
      String fileContents = Files.readString(gameFile);
      EnhancedGameEngine gameEngine =  compile(fileContents);
      FileOutputStream fileOut =
          new FileOutputStream(gameFile.toString().replace(".txt", ".ser"));
      ObjectOutputStream out = new ObjectOutputStream(fileOut);
      out.writeObject(gameEngine);
      out.close();
      fileOut.close();
      return gameEngine;
   }

}
