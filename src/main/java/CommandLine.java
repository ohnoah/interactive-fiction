import java.util.List;
import java.util.stream.Collectors;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.plaf.ActionMapUIResource;

/**
 * CommandLine
 *
 * @author Stefan Wagner, Noah Ohrner
 * @date Mi 25. Apr 17:27:19 CEST 2012, 17 Nov 2020
 * (c) GPLv3
 */
public class CommandLine extends JFrame {
   private static final String progname = "Interactive Fiction Engine";
   private boolean playingGame = false;
   private NLPEngine nlpEngine = new BasicNLPEngine();
   private GameEngine gameEngine = new BasicGameEngine();


   private GameEditState gameEditState = GameEditState.OPEN;
   private GameEditState prevGameEditState = null;
   // Game Editing State variables to store progress
   private Room roomToAdd;
   private Room roomForAction;
   private InstantiatedGameAction instantiatedGameAction;
   private GameEditState effectAction;


   private JTextField input;
   private JTextArea history;

   public CommandLine() {
      super(progname);
      JPanel mainpanel = new JPanel();
      mainpanel.setLayout(new BorderLayout());
      this.getContentPane().add(mainpanel);

      input = new JTextField(80);
      history = new JTextArea();
      history.setLineWrap(true);
      history.setWrapStyleWord(true);

      // TODO: Replace with IntelliJ Implementation
      JScrollPane areaScrollPane = new JScrollPane(history);
      areaScrollPane.setVerticalScrollBarPolicy(
          JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
      areaScrollPane.setPreferredSize(new Dimension(250, 250));

      //mainpanel.add(history, BorderLayout.CENTER);
      mainpanel.add(areaScrollPane, BorderLayout.CENTER);
      mainpanel.add(input, BorderLayout.SOUTH);

      ActionMap actionMap = new ActionMapUIResource();

      actionMap.put("enter", new AbstractAction() {
         @Override
         public void actionPerformed(ActionEvent e) {
            String cmd = input.getText();
            String sofar = history.getText();
            // TODO: If game editing mode, process numbered CLI
            // Maybe use a variable indicating initialized progress
            if(playingGame) {
               writeToTerminal(cmd, sofar, processCmd(cmd));
//               history.setText(sofar + cmd + "\n" + processCmd(cmd) + "\n> ");
            }
            else{
               editGame(cmd, sofar);
            }
         }
      });
      actionMap.put("backspace", new AbstractAction() {
         @Override
         public void actionPerformed(ActionEvent e) {
            String cmd = input.getText();
            if (cmd.length() > 0) {
               cmd = cmd.substring(0, cmd.length() - 1);
            }
            input.setText(cmd);
         }
      });
      InputMap keyMap = new ComponentInputMap(input);
      keyMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
      keyMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_BACK_SPACE, 0), "backspace");

      SwingUtilities.replaceUIActionMap(input, actionMap);
      SwingUtilities.replaceUIInputMap(input, JComponent.WHEN_IN_FOCUSED_WINDOW, keyMap);
      input.setEditable(true);
      history.setText(">");

      setSize(600, 600);
      setLocation(100, 100);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);
   }

   private void writeToTerminal(String cmd, String sofar, String result){
      history.setText(sofar + cmd + "\n" + result + "\n> ");
      input.setText("");
   }

   private void editGame(String cmd, String sofar) {
      cmd = cmd.trim();

      String output = null;
      switch(cmd){
         case "quit":
            output = "QUITTING";
            break;
         case "list":
            output = gameEngine.possibleActionFormats().stream()
                .map(ActionFormat::getVerb).collect(Collectors.joining(","));
            break;
         default:
            switch(gameEditState) {
               case OPEN:
                  System.out.println("Low level");
                  break;
               case ROOM_ITEMS:
                  System.out.println("Medium level");
                  break;
               case ACTION_TRIGGER:
                  System.out.println("High level");
                  break;
               case ACTION_TRIGGER_CLARIFY:
                  break;
               case ACTION_ARGS:
                  break;
               case ACTION_PRE:
                  break;
               case ACTION_POST:
                  break;
               case ACTION_MSG:
                  break;
               default:
                  output = "Invalid game-developing state. Consult the game developer.";
            }
      }


      writeToTerminal(cmd, sofar, output);

   }

   private void center() {
      Toolkit tk = Toolkit.getDefaultToolkit();
      Dimension screen = tk.getScreenSize();
      Dimension d = getSize();
      setLocation((screen.width - d.width) / 2, (screen.height - d.height) / 2);
   }

   public String processCmd(String cmd) {
      return cmd;
/*      List<ActionFormat> possibleGameActions = gameEngine.possibleActionFormats();
      List<String> possibleItemNames = gameEngine.possibleItemNames();
      InstantiatedGameAction gameAction = null;
      try {
         gameAction = nlpEngine.parse(cmd, possibleGameActions, possibleItemNames);
      } catch (FailedParseException e) {
         return e.getMessage();
      }
      String gameMessage = gameEngine.progressStory(gameAction);

      return gameMessage;*/
   }

   public static void main(final String[] args) {
      Runnable runner = new Runnable() {
         public void run() {
            new CommandLine();
         }
      };
      EventQueue.invokeLater(runner);
   }
}
