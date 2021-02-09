package com.intfic;

import com.intfic.game.enhanced.EnhancedGameEngine;
import com.intfic.game.shared.GameEngine;
import com.intfic.game.enhanced.FileErrorHandler;
import com.intfic.game.enhanced.reasoning.wrappers.Justification;
import com.intfic.nlp.EnhancedNLPEngine;
import com.intfic.nlp.FailedParseException;
import com.intfic.game.shared.ActionFormat;
import com.intfic.game.shared.InstantiatedGameAction;
import com.intfic.game.shared.Item;
import edu.stanford.nlp.util.Pair;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.plaf.ActionMapUIResource;

/**
 * com.interactivefiction.GamePlayer
 *
 * @author Stefan Wagner, Noah Ohrner
 * @date Mi 25. Apr 17:27:19 CEST 2012, 17 Nov 2020
 * (c) GPLv3
 */

public class EnhancedGamePlayer extends GamePlayer {


   private static final String progname = "IF Game Player";
   private GameEngine gameEngine = null;
   private Pair<Set<String>, String> it;


   private void attemptToLoadGameEngine(String cmd, String sofar){
      try {
         FileInputStream fileIn = new FileInputStream(cmd);
         ObjectInputStream in = new ObjectInputStream(fileIn);
         gameEngine = (GameEngine) in.readObject();
         in.close();
         fileIn.close();
         String startMessage = gameEngine.getStartMessage() != null ? gameEngine.getStartMessage() : "";
         history.setText(startMessage + "\n" + "> ");
         input.setText("");
         FileErrorHandler.firstError = true;
      }
      catch (IOException i) {
         writeToTerminal(cmd, sofar, "Something went wrong when opening the file. Try again.");
         i.printStackTrace();
      }
      catch (ClassNotFoundException c) {
         writeToTerminal(cmd, sofar, "Couldn't find the GameEngine class.");
         c.printStackTrace();
      }
   }

   public EnhancedGamePlayer() {
      super(progname);
      prepareSwing();

      ActionMap actionMap = new ActionMapUIResource();
      actionMap.put("enter", new AbstractAction() {
         @Override
         public void actionPerformed(ActionEvent e) {
            String cmd = input.getText().trim();
            String sofar = history.getText();
            if (gameEngine != null) {
               writeToTerminal(cmd, sofar, processCmd(cmd));
            }
            else {
               if (isReadableFile(cmd)) {
                  attemptToLoadGameEngine(cmd, sofar);
               }
               else {
                  writeToTerminal(cmd, sofar, "That isn't a valid readable file in your file system. Try again.");
               }
            }
         }
      });

      initializeJFrame(actionMap);

   }

   private boolean isReadableFile(String cmd) {
      Path path = Paths.get(cmd);
      return Files.exists(path) && Files.isReadable(path);
   }

   private void writeToTerminal(String cmd, String sofar, String result) {
      history.setText(sofar + cmd + "\n" + result + "\n> ");
      input.setText("");
   }

   private void center() {
      Toolkit tk = Toolkit.getDefaultToolkit();
      Dimension screen = tk.getScreenSize();
      Dimension d = getSize();
      setLocation((screen.width - d.width) / 2, (screen.height - d.height) / 2);
   }

   @Override
   public String processCmd(String cmd) {
      if (cmd.equals("quit")) {
         System.exit(0);
      }
      List<ActionFormat> possibleGameActions = gameEngine.getPossibleActionFormats();
      Set<Item> possibleItems = gameEngine.possibleItems();
      List<InstantiatedGameAction> gameActions = null;

      try {
         gameActions = EnhancedNLPEngine.parse(cmd, possibleGameActions, possibleItems, it);
         it = gameActions.get(0).getIt();
      }
      catch (FailedParseException e) {
         return e.getMessage();
      }
      String gameMessage;
      if (gameActions.size() == 1) {
         InstantiatedGameAction gameAction = gameActions.get(0);
         Justification justification = gameEngine.progressStory(gameAction);
         gameMessage = justification.getReasoning();
      }
      else {
         StringBuilder gameMessageBuilder = new StringBuilder();
         for (InstantiatedGameAction gameAction : gameActions) {
            Justification justification = gameEngine.progressStory(gameAction);
            gameMessageBuilder.append(justification.getReasoning());
         }
         gameMessage = gameMessageBuilder.toString();
      }
      return gameMessage;

   }

   public static void main(final String[] args) {
      Runnable runner = EnhancedGamePlayer::new;
      EventQueue.invokeLater(runner);
   }

}
