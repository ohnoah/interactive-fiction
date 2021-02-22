package com.intfic;


import com.intfic.game.shared.GameEngine;
import com.intfic.game.enhanced.FileErrorHandler;
import com.intfic.game.enhanced.reasoning.wrappers.Justification;
import com.intfic.game.shared.Util;
import com.intfic.nlp.BasicNLPEngine;
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
import java.util.ArrayList;
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
   private boolean isClarifying;
   private List<Item> clarifiedArguments;
   private InstantiatedGameAction clarifyingAction;


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

   private void askQuestion() {
      if (questionsAsked < questionsInRow) {
         String question = getNextQuestion();
         if (question != null) {
            questionsAsked++;
            writeToTerminal("--------User study survey question interruption--------" + "\n" + question + "\n"/* + answerOptions*/, history.getText());
            isAskingQuestion = true;
            addToQuestionTranscript(question);
            /*addToQuestionTranscript(answerOptions);*/
         }
         else {
            isAskingQuestion = false;
            if (questionsAsked != 0) {
               writeToTerminal("\n Resuming game. \n" + "--------------", history.getText());
            }
            questionsAsked = 0;
            incrementField("numCommands");
            incrementField("acceptedCommands");
         }
      }
      else {
         isAskingQuestion = false;
         if (questionsAsked != 0) {
            writeToTerminal("\n Resuming game. \n" + "--------------", history.getText());
         }
         questionsAsked = 0;
         incrementField("numCommands");
         incrementField("acceptedCommands");
      }
   }

   private boolean validateQuestionAnswer(String answer) {
      answer = answer.trim();
      try {
         int intResponse = Integer.parseInt(answer);
         if (intResponse >= 0 && intResponse <= 10) {
            return true;
         }
      }
      catch (NumberFormatException ignored) {
      }
      return false;
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
                  if (validateQuestionAnswer(cmd)) {
                     answerQuestion(cmd);
                     askQuestion();
                  }
                  else {
                     writeToTerminal(cmd, history.getText(), "Invalid response. Write a number in the range 0 to 10 inclusive.");
                  }
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
                        BasicNLPEngine.parse("eat apple", gameEngine.getPossibleActionFormats(), gameEngine.possibleItems());
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
         if (currentQuestionIndex != questions.size()) {
            stringStatistics.put("errorCode", "You haven't answered all questions. Contact the administrator to ask what to do with the remaining questions");
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
/*      try {
         int i = Integer.parseInt(cmd);
         history.setTabSize(i);
         return "okay";
      }
      catch(NumberFormatException ignored){

      }*/
      updateStatistics(cmd);
      if (isClarifying) {
         return clarify(cmd);
      }

      List<ActionFormat> possibleGameActions = gameEngine.getPossibleActionFormats();
      Set<Item> possibleItems = gameEngine.possibleItems();
      List<InstantiatedGameAction> gameActions = null;

      try {
         gameActions = BasicNLPEngine.parse(cmd, possibleGameActions, possibleItems, it);
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
         if (!Util.isFlat(gameAction.getPotentialArguments())) {
            return needClarification(gameAction);
         }
         justification = gameEngine.progressStory(gameAction);
         gameMessage = justification.getReasoning();
      }
      else if (gameActions.size() == 0) {
         return "Error. No valid game verb specified.";
      }
      else {
         StringBuilder gameMessageBuilder = new StringBuilder();
         for (InstantiatedGameAction gameAction : gameActions) {
            if (!Util.isFlat(gameAction.getPotentialArguments())) {
               return needClarification(gameAction);
            }
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

   private String clarify(String cmd) {
      int nextClarify = clarifiedArguments.size();
      List<List<Item>> potentialArgs = clarifyingAction.getPotentialArguments();
      try {
         int i = Integer.parseInt(cmd);
         if (!(i >= 0 && i < potentialArgs.get(nextClarify).size())) {
            return "Input a number in the right range displayed above.";
         }
         clarifiedArguments.add(potentialArgs.get(nextClarify).get(i));
         nextClarify++;
      }
      catch (NumberFormatException e) {
         return "Input a valid number";
      }

      while (nextClarify < potentialArgs.size() && potentialArgs.get(nextClarify).size() == 1) {
         nextClarify++;
      }
      if (nextClarify == potentialArgs.size()) {
         clarifyingAction.setActualArguments(clarifiedArguments);
         String message = gameEngine.progressStory(clarifyingAction).getReasoning();
         clarifyingAction = null;
         clarifiedArguments.clear();
         isClarifying = false;
         return message;
      }
      else {
         return String.format("Couldn't uniquely identify argument number %d when taking action %s. Choose the one you meant by writing a number from the list below.\n %s"
             , nextClarify + 1, clarifyingAction.getAbstractActionFormat(), Util.selectionList(potentialArgs.get(nextClarify)));
      }

   }

   private String needClarification(InstantiatedGameAction gameAction) {
      this.isClarifying = true;
      this.clarifiedArguments = new ArrayList<>();
      this.clarifyingAction = gameAction;
      try {
         List<Item> first = gameAction.getPotentialArguments().stream().filter(l -> l.size() != 0).findFirst().
             orElseThrow(() -> new FailedParseException("Internal error when clarifying. Contact game admin."));
         return String.format("Couldn't uniquely identify the first arguments when taking action %s. Choose the one you meant by writing a number from the list below.\n %s"
             , gameAction.getAbstractActionFormat(), Util.selectionList(first));
      }
      catch (FailedParseException e) {
         return e.getMessage();
      }
   }

   public static void main(final String[] args) {
      Runnable runner = EnhancedGamePlayer::new;
      EventQueue.invokeLater(runner);
   }

}
