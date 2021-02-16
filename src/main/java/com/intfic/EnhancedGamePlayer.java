package com.intfic;


import com.intfic.game.shared.GameEngine;
import com.intfic.game.enhanced.FileErrorHandler;
import com.intfic.game.enhanced.reasoning.wrappers.Justification;
import com.intfic.game.shared.Util;
import com.intfic.nlp.EnhancedNLPEngine;
import com.intfic.nlp.FailedParseException;
import com.intfic.game.shared.ActionFormat;
import com.intfic.game.shared.InstantiatedGameAction;
import com.intfic.game.shared.Item;
import edu.stanford.nlp.util.Pair;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.plaf.ActionMapUIResource;

/**
 * com.interactivefiction.GamePlayer
 *
 * @author Stefan Wagner, Noah Ohrner
 * @date Mi 25. Apr 17:27:19 CEST 2012, 17 Nov 2020
 * (c) GPLv3
 */

public class EnhancedGamePlayer extends GamePlayer implements Serializable {


   private static final String progname = "IF Game Player";
   private GameEngine gameEngine = null;
   private Pair<Set<String>, String> it;
   private boolean isAskingQuestion = false;
   private String lastResult;


   private void attemptToLoadGameEngine(String cmd, String sofar) {
      writeToTerminal("Trying to load game file. Please wait", sofar);
      try {
         FileInputStream fileIn = new FileInputStream(cmd);
         ObjectInputStream in = new ObjectInputStream(fileIn);
         gameEngine = (GameEngine) in.readObject();
         in.close();
         fileIn.close();
         String startMessage = gameEngine.getStartMessage() != null ? gameEngine.getStartMessage() : "";
         String questionMessage = (questions == null ? "WARNING: No questionarre questions loaded. Check that you have a questions.txt file in this folder" :
             "Expect to answer about " + questions.size() + " questions as you play today.") + "\n" + "--------------------" + "\n";
         history.setText(questionMessage + startMessage + "\n" + "> ");
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

   private void askQuestion(){
      if(questionsAsked < questionsInRow) {
         String question = getNextQuestion();
         if (question != null) {
            questionsAsked++;
            writeToTerminal("--------User study survey question interruption--------" + "\n" + question + "\n" + answerOptions, history.getText());
            isAskingQuestion = true;
            addToQuestionTranscript(question);
            addToQuestionTranscript(answerOptions);
         }
         else {
            isAskingQuestion = false;
            if(questionsAsked != 0) {
               writeToTerminal("\n Resuming game. \n" + "--------------", history.getText());
            }
            questionsAsked = 0;
            incrementField("numCommands");
            incrementField("acceptedCommands");
         }
      }
      else{
         isAskingQuestion = false;
         if(questionsAsked != 0) {
            writeToTerminal("\n Resuming game. \n" + "--------------", history.getText());
         }
         questionsAsked = 0;
         incrementField("numCommands");
         incrementField("acceptedCommands");
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
            if (gameEngine != null) {
               if (!isAskingQuestion) {
                  lastResult = processCmd(cmd);
                  writeToTerminal(cmd, history.getText(), lastResult);
                  boolean timeToAskQuestion = (questionBreakpoints != null && breakpointHit(gameEngine)) ||
                      (questionBreakpoints == null && getIntStatistics("acceptedCommands") % questionFreq == (questionFreq - 1));
                  if (timeToAskQuestion) {
                     askQuestion();
                  }
               }
               else {
                  // TODO: Implement questions
                  writeToTerminal(cmd, history.getText());
                  answerQuestion(cmd);
                  askQuestion();
               }
               if (getIntStatistics("numCommands") % 5 == 1) {
                  writeStatisticsAndTranscriptToFile();
               }

            }
            else {
               if (isReadableFile(cmd)) {
                  attemptToLoadGameEngine(cmd, history.getText());
                  if (gameEngine != null) {
                     try {
                        EnhancedNLPEngine.parse("eat apple", gameEngine.getPossibleActionFormats(), gameEngine.possibleItems());
                     }
                     catch (FailedParseException ignored) {
                     }
                  }
               }
               else {
                  writeToTerminal(cmd, history.getText(), "That isn't a valid readable file in your file system. Try again.");
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
      addTimeToTranscript();
      addToTranscript(cmd);
      addToTranscript(result);
      history.setText(sofar + cmd + "\n" + result + "\n> ");
      input.setText("");
   }

   private void writeToTerminal(String string, String sofar) {
      addTimeToTranscript();
      addToTranscript(string);
      history.setText(sofar + string + "\n> ");
      input.setText("");
   }

   private void center() {
      Toolkit tk = Toolkit.getDefaultToolkit();
      Dimension screen = tk.getScreenSize();
      Dimension d = getSize();
      setLocation((screen.width - d.width) / 2, (screen.height - d.height) / 2);
   }


   private void updateStatistics(Justification justification) {
      String acceptedCommands = "acceptedCommands";
      String deniedCommands = "deniedCommands";
      if (justification.isAccepted()) {
         incrementField(acceptedCommands);
      }
      else {
         incrementField(deniedCommands);
      }
   }


   @Override
   public String processCmd(String cmd) {
      if (cmd.equals("quit")) {
         if(currentQuestionIndex != questions.size()){
            stringStatistics.put("errorCode","You haven't answered all questions. Contact the administrator to ask what to do with the remaining questions");
         }
         writeStatisticsAndTranscriptToFile();
         System.exit(0);
      }
      if (cmd.trim().equals("")) {
         return "";
      }
      if (cmd.equals("help")) {
         return (gameEngine.getPossibleActionFormats().stream().map(ActionFormat::toString).collect(Collectors.joining(",")));
      }
      updateStatistics(cmd);
      List<ActionFormat> possibleGameActions = gameEngine.getPossibleActionFormats();
      Set<Item> possibleItems = gameEngine.possibleItems();
      List<InstantiatedGameAction> gameActions = null;

      try {
         gameActions = EnhancedNLPEngine.parse(cmd, possibleGameActions, possibleItems, it);
         if (gameActions.size() > 0) {
            it = gameActions.get(0).getIt();
         }
      }
      catch (FailedParseException e) {
         return e.getMessage();
      }
      Justification justification = null;
      String gameMessage;
      if (gameActions.size() == 1) {
         InstantiatedGameAction gameAction = gameActions.get(0);
         justification = gameEngine.progressStory(gameAction);
         gameMessage = justification.getReasoning();
      }
      else if (gameActions.size() == 0) {
         return "Error. No valid game verb specified.";
      }
      else {
         StringBuilder gameMessageBuilder = new StringBuilder();
         for (InstantiatedGameAction gameAction : gameActions) {
            justification = gameEngine.progressStory(gameAction);
            gameMessageBuilder.append(justification.getReasoning());
            if (!justification.isAccepted()) {
               break;
            }
         }
         gameMessage = gameMessageBuilder.toString();
      }
      updateStatistics(justification);
      return gameMessage;

   }

   public static void main(final String[] args) {
      Runnable runner = EnhancedGamePlayer::new;
      EventQueue.invokeLater(runner);
   }

}
