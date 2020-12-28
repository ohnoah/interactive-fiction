import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.ComponentInputMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.plaf.ActionMapUIResource;

/**
 * GamePlayer
 *
 * @author Stefan Wagner, Noah Ohrner
 * @date Mi 25. Apr 17:27:19 CEST 2012, 17 Nov 2020
 * (c) GPLv3
 */

public class GamePlayer extends JFrame {


   private static final String progname = "IF Game Player";
   private NLPEngine nlpEngine = new BasicNLPEngine();
   private GameEngine gameEngine = new BasicGameEngine();

   private boolean isLoaded = false;

   private JTextField input;
   private JTextArea history;

   public GamePlayer() {
      super(progname);
      JPanel mainpanel = new JPanel();
      mainpanel.setLayout(new BorderLayout());
      this.getContentPane().add(mainpanel);

      input = new JTextField(80);
      // TODO: Need to make this not-writeable
      history = new JTextArea();
      history.setEditable(false);
      history.setLineWrap(true);
      history.setWrapStyleWord(true);

      // TODO: Replace with IntelliJ Implementation
      JScrollPane areaScrollPane = new JScrollPane(history);
      areaScrollPane.setVerticalScrollBarPolicy(
          JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
      areaScrollPane.setPreferredSize(new Dimension(250, 250));

      mainpanel.add(areaScrollPane, BorderLayout.CENTER);
      mainpanel.add(input, BorderLayout.SOUTH);

      ActionMap actionMap = new ActionMapUIResource();

      actionMap.put("enter", new AbstractAction() {
         @Override
         public void actionPerformed(ActionEvent e) {
            String cmd = input.getText();
            String sofar = history.getText();
            if(isLoaded) {
               writeToTerminal(cmd, sofar, processCmd(cmd));
               history.setText(sofar + cmd + "\n" + processCmd(cmd) + "\n> ");
            }
            else{


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
      history.setText("Please enter the file-name of the game you wish to play \n >");

      setSize(600, 600);
      setLocation(100, 100);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);
      center();
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

   public String processCmd(String cmd) {
      List<ActionFormat> possibleGameActions = gameEngine.getPossibleActionFormats();
      List<String> possibleItemNames = gameEngine.possibleItemNames();
      InstantiatedGameAction gameAction = null;
      try {
         gameAction = nlpEngine.parse(cmd, possibleGameActions, possibleItemNames);
      } catch (FailedParseException e) {
         return e.getMessage();
      }
      String gameMessage = gameEngine.progressStory(gameAction);

      return gameMessage;
   }

   public static void main(final String[] args) {
      Runnable runner = new Runnable() {
         public void run() {
            new BasicGameEditor();
         }
      };
      EventQueue.invokeLater(runner);
   }

}
