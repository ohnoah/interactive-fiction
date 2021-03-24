package com.intfic.game.enhanced.gamebuilder.compiler;

import static org.junit.Assert.*;


import com.intfic.game.enhanced.EnhancedGameEngine;
import java.io.IOException;
import java.nio.file.Path;
import org.junit.Test;

public class GameCompilerTest {

   @Test
   public void compileTestGrammar() throws IOException {
      EnhancedGameEngine enhancedGameEngine = GameCompiler.compile(Path.of("test-grammar.txt"));
      System.out.println(enhancedGameEngine);
      assertTrue(enhancedGameEngine.globalItems().containsKey("first_room.apple"));
   }
}