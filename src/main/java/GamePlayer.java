import com.nlp.FailedParseException;
import com.shared.ActionFormat;
import com.shared.InstantiatedGameAction;
import com.shared.Item;
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
   private NLPEngine nlpEngine = new EnhancedNLPEngine();
   private GameEngine gameEngine = null;


   private JTextField input;
   private JTextArea history;

   private void initializeJFrame(ActionMap actionMap){
      InputMap keyMap = new ComponentInputMap(input);
      keyMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
      keyMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_BACK_SPACE, 0), "backspace");

      SwingUtilities.replaceUIActionMap(input, actionMap);
      SwingUtilities.replaceUIInputMap(input, JComponent.WHEN_IN_FOCUSED_WINDOW, keyMap);
      input.setEditable(true);
      history.setText("Please enter the file-name of the game you wish to play \n>");

      setSize(600, 600);
      setLocation(100, 100);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);
      center();
   }

   public GamePlayer() {
      super(progname);
      JPanel mainPanel = new JPanel();
      mainPanel.setLayout(new BorderLayout());
      this.getContentPane().add(mainPanel);

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

      mainPanel.add(areaScrollPane, BorderLayout.CENTER);
      mainPanel.add(input, BorderLayout.SOUTH);

      ActionMap actionMap = new ActionMapUIResource();

      actionMap.put("enter", new AbstractAction() {
         @Override
         public void actionPerformed(ActionEvent e) {
            String cmd = input.getText().trim();
            String sofar = history.getText();
            if(gameEngine != null) {
               writeToTerminal(cmd, sofar, processCmd(cmd));
            }
            else{
               if(isReadableFile(cmd)){
                  try {
                     FileInputStream fileIn = new FileInputStream(cmd);
                     ObjectInputStream in = new ObjectInputStream(fileIn);
                     gameEngine = (GameEngine) in.readObject();
                     in.close();
                     fileIn.close();
                     history.setText("> ");
                     input.setText("");
                  } catch (IOException i) {
                     writeToTerminal(cmd, sofar, "Something went wrong when opening the file. Try again.");
                     i.printStackTrace();
                  } catch (ClassNotFoundException c) {
                     writeToTerminal(cmd, sofar, "Couldn't find the GameEngine class.");
                     c.printStackTrace();
                  }
               }
               else{
                  writeToTerminal(cmd, sofar, "That isn't a valid readable file in your file system. Try again.");
               }
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

   private String processCmd(String cmd) {
      if(cmd.equals("quit")){
         System.exit(0);
      }
      List<ActionFormat> possibleGameActions = gameEngine.getPossibleActionFormats();
      Set<Item> possibleItems = gameEngine.possibleItems();
      InstantiatedGameAction gameAction = null;
      try {
         gameAction = nlpEngine.parse(cmd, possibleGameActions, possibleItems);
      } catch (FailedParseException e) {
         return e.getMessage();
      }
      String gameMessage = gameEngine.progressStory(gameAction);

      return gameMessage;
   }

   public static void main(final String[] args) {
      Runnable runner = GamePlayer::new;
      EventQueue.invokeLater(runner);
   }

}
