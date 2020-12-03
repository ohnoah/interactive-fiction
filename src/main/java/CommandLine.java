import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
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

   private JTextField input;
   private JTextArea history;

   public CommandLine() {
      super(progname);
      JPanel mainpanel = new JPanel();
      mainpanel.setLayout(new BorderLayout());
      this.getContentPane().add(mainpanel);

      input = new JTextField(80);
      history = new JTextArea();
      mainpanel.add(history, BorderLayout.CENTER);
      mainpanel.add(input, BorderLayout.SOUTH);

      ActionMap actionMap = new ActionMapUIResource();

      actionMap.put("enter", new AbstractAction() {
         @Override
         public void actionPerformed(ActionEvent e) {
            String cmd = input.getText();
            String sofar = history.getText();
            history.setText(sofar + cmd + "\n" + processCmd(cmd) + "\n> ");
            input.setText("");
         }
      });
      actionMap.put("backspace", new AbstractAction() {
         @Override
         public void actionPerformed(ActionEvent e) {
            String cmd = input.getText();
            System.out.println(cmd);
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

   private void center() {
      Toolkit tk = Toolkit.getDefaultToolkit();
      Dimension screen = tk.getScreenSize();
      Dimension d = getSize();
      setLocation((screen.width - d.width) / 2, (screen.height - d.height) / 2);
   }

   public static String processCmd(String cmd) {
      NLPEngine nlpEngine = new BasicNLPEngine();
      GameEngine gameEngine = new BasicGameEngine();
      List<ActionFormat> possibleGameActions = gameEngine.possibleGameActions();
      List<String> possibleItemNames = gameEngine.possibleItemNames();
      ConcreteGameAction gameAction = null;
      try {
         gameAction = nlpEngine.parse(cmd, possibleGameActions, possibleItemNames);
      } catch (FailedParseException e) {
         return e.getMessage();
      }
      String gameMessage = gameEngine.progressStory(gameAction);


      return cmd;
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
