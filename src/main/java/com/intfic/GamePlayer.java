package com.intfic;

import com.intfic.game.shared.GameEngine;
import com.intfic.game.shared.Util;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

/**
 * com.interactivefiction.BasicGamePlayer
 *
 * @author Stefan Wagner, Noah Ohrner
 * @date Mi 25. Apr 17:27:19 CEST 2012, 17 Nov 2020
 * (c) GPLv3
 */

public abstract class GamePlayer extends JFrame implements Serializable {
   List<String> questionBreakpoints;
   int currentQuestionBreakPoint = 0;

   boolean breakpointHit(GameEngine gameEngine) {
      if (questionBreakpoints != null) {
         if (currentQuestionBreakPoint < questionBreakpoints.size()) {
            String booleanKeyWorld = questionBreakpoints.get(currentQuestionBreakPoint);
            boolean accepted = gameEngine.getWorldBoolean(booleanKeyWorld);
            if (accepted) {
               currentQuestionBreakPoint++;
            }
            return accepted;
         }
      }
      return false;
   }


   /* private GameEngine gameEngine = null;*/
   /*private Pair<Set<String>, String> it;*/


   Map<String, String> stringStatistics;
   Map<String, Integer> integerStatistics;
   JTextField input;
   JTextArea history;
   List<String> commands = new ArrayList<>();
   List<String> transcript = new ArrayList<>();
   List<String> questionTranscript = new ArrayList<>();
   final String QUESTION_FILE_NAME = "questions.txt";
   final String QUESTION_BREAKPOINT_FILE_NAME = "question-breakpoints.txt";
   final String ANSWER_OPTIONS_FILE_NAME = "options.txt";
   List<String> questions;
   int currentQuestionIndex = 0;
   int currentCommandIndex = 1;
   int questionFreq = 5;
   int questionsInRow = 2;
   int questionsAsked = 0;
   String answerOptions;
   LocalDateTime startTime;
   DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("d-M-HH-mm-ss");

   String getNextQuestion() {
      return currentQuestionIndex < questions.size() ? questions.get(currentQuestionIndex++) : null;
   }

   void writeStatisticsAndTranscriptToFile() {
      try {
         File fullTranscript = new File(String.format("game-transcript-%s.txt", startTime.format(dateTimeFormatter)));
         File questions = new File(String.format("question-transcript-%s.txt", startTime.format(dateTimeFormatter)));
         fullTranscript.createNewFile();
         questions.createNewFile();
         Files.write(fullTranscript.toPath(), transcript, StandardOpenOption.APPEND);
/*         for (String line : transcript) {
            Files.write(file.toPath(), line.getBytes(), StandardOpenOption.APPEND);
         }*/

         Files.write(questions.toPath(), questionTranscript, StandardOpenOption.APPEND);
         transcript.clear();
         questionTranscript.clear();
         Files.write(fullTranscript.toPath(), ("STRING-STATISTICS:" + stringStatistics.toString() + "\n").getBytes(), StandardOpenOption.APPEND);
         Files.write(fullTranscript.toPath(), ("INTEGER-STATISTICS:" + integerStatistics.toString() + "\n").getBytes(), StandardOpenOption.APPEND);
      }
      catch (IOException e) {
         e.printStackTrace();
      }
   }

   public void addToTranscript(String s) {
      transcript.add(s);
   }

   public void addToQuestionTranscript(String s) {
      questionTranscript.add(s);
   }

   public String getStringStatistic(String key) {
      return stringStatistics.get(key);
   }

   public int getIntStatistics(String key) {
      return integerStatistics.getOrDefault(key, 0);
   }

   void incrementField(String key) {
      this.integerStatistics.put(key, 1 + this.integerStatistics.getOrDefault(key, 0));
   }

   void updateStatistics(String cmd) {
      String numCommands = "numCommands";
      incrementField(numCommands);
      commands.add(cmd);
   }

   void addTimeToTranscript() {
      Duration between = Duration.between(startTime, LocalDateTime.now());
      addToTranscript("-!-!- " + Util.formatDuration(between));
   }

   void initializeJFrame(ActionMap actionMap) {

      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      addWindowListener(new java.awt.event.WindowAdapter() {
         public void windowClosed(java.awt.event.WindowEvent evt) {
            writeStatisticsAndTranscriptToFile();
         }
      });


      InputMap keyMap = input.getInputMap();
      input.getActionMap().put("enter", actionMap.get("enter"));
      /* InputMap keyMap = new ComponentInputMap(input);*/
      keyMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
      /*  keyMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_BACK_SPACE, 0), "backspace");*/
      input.getActionMap().put("up", new AbstractAction() {
         @Override
         public void actionPerformed(ActionEvent e) {
            if (commands == null || commands.size() == 0) {
               return;
            }
            currentCommandIndex = Math.min(commands.size(), currentCommandIndex + 1);
            input.setText(commands.get(commands.size() - (currentCommandIndex)));
         }
      });
      keyMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), "up");
      input.getActionMap().put("down", new AbstractAction() {
         @Override
         public void actionPerformed(ActionEvent e) {
            if (commands == null || commands.size() == 0) {
               return;
            }
            currentCommandIndex = Math.max(1, currentCommandIndex - 1);
            input.setText(commands.get(commands.size() - (currentCommandIndex)));
         }
      });
      keyMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "down");


      /*SwingUtilities.replaceUIActionMap(input, actionMap);*/
      /*   SwingUtilities.replaceUIInputMap(input, JComponent.WHEN_IN_FOCUSED_WINDOW, keyMap);*/
      input.setEditable(true);
      history.setText("Please enter the file-name of the game you wish to play. It may take up to 2 minutes to load the game. \n>");

      setSize(600, 600);
      setLocation(100, 100);
      setVisible(true);
      center();
   }

   void prepareSwing() {
      JPanel mainPanel = new JPanel();
      mainPanel.setLayout(new BorderLayout());
      this.getContentPane().add(mainPanel);

      input = new JTextField(80);
      System.out.println(this.input.getCaret());
      history = new JTextArea();
      history.setEditable(false);
      history.setLineWrap(true);
      history.setWrapStyleWord(true);

      // TODO: Replace with IntelliJ Implementation
      JScrollPane areaScrollPane = new JScrollPane(history);
      areaScrollPane.setVerticalScrollBarPolicy(
          JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
      areaScrollPane.setPreferredSize(new Dimension(250, 250));

      mainPanel.add(areaScrollPane, BorderLayout.CENTER);
      mainPanel.add(input, BorderLayout.SOUTH);
   }

   public GamePlayer(String progname) {
      super(progname);
      integerStatistics = new HashMap<>();
      stringStatistics = new HashMap<>();
      integerStatistics.put("numCommands", 0);
      startTime = LocalDateTime.now();
      try {
         questions = Files.readAllLines(Paths.get(QUESTION_FILE_NAME));
         questionBreakpoints = Files.readAllLines(Paths.get(QUESTION_BREAKPOINT_FILE_NAME));
         int minQuestionsInRow = (int) Math.ceil(((double) questions.size()) / ((double) questionBreakpoints.size()));
         questionsInRow = Math.max(minQuestionsInRow, questionsInRow);
         try {
            int freq = Math.abs(Integer.parseInt(questions.get(0)));
            questions.remove(0);
            questionFreq = Math.max(2, freq);
         }
         catch (NumberFormatException ignored) {
         }
      }
      catch (IOException e) {
         questions = null;
         questionBreakpoints = null;
         e.printStackTrace();
      }
      try {
         answerOptions = Files.readString(Paths.get(ANSWER_OPTIONS_FILE_NAME));
      }
      catch (IOException e) {
         answerOptions = null;
         e.printStackTrace();
      }

      prepareSwing();


/*      ActionMap actionMap = new ActionMapUIResource();
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
               else {
                  writeToTerminal(cmd, sofar, "That isn't a valid readable file in your file system. Try again.");
               }
            }
         }
      });

      initializeJFrame(actionMap);
      */


   }


   private void center() {
      Toolkit tk = Toolkit.getDefaultToolkit();
      Dimension screen = tk.getScreenSize();
      Dimension d = getSize();
      setLocation((screen.width - d.width) / 2, (screen.height - d.height) / 2);
   }


   void answerQuestion(String cmd) {
      addToQuestionTranscript(cmd);
   }

   public abstract String processCmd(String cmd);
/*   private String processCmd(String cmd) {
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
      if(gameActions.size() == 1) {
         InstantiatedGameAction gameAction = gameActions.get(0);
         Justification justification = gameEngine.progressStory(gameAction);
         gameMessage = justification.getReasoning();
      }
      else{
         StringBuilder gameMessageBuilder = new StringBuilder();
         for(InstantiatedGameAction gameAction : gameActions){
            Justification justification = gameEngine.progressStory(gameAction);
            gameMessageBuilder.append(justification.getReasoning());
         }
         gameMessage = gameMessageBuilder.toString();
      }
      return gameMessage;

   }*/

/*   public static void main(final String[] args) {
      Runnable runner = GamePlayer::new;
      EventQueue.invokeLater(runner);
   }*/

}
