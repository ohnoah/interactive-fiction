import com.basic.BasicGameDesignAction;
import com.basic.BasicGameEditState;
import com.shared.ActionFormat;
import com.shared.InstantiatedGameAction;
import com.shared.Item;
import com.shared.Room;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
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
 * BasicGameEditor
 *
 * @author Stefan Wagner, Noah Ohrner
 * @date Mi 25. Apr 17:27:19 CEST 2012, 17 Nov 2020
 * (c) GPLv3
 */
public class BasicGameEditor extends JFrame {
   private static final String programName = "IF Basic Game Editor";
   private BasicGameEngine gameEngine = new BasicGameEngine();
   private boolean saved = false;


   private BasicGameEditState basicGameEditState = BasicGameEditState.OPEN;
   // Game Editing State variables to store progress
   private Room roomToAdd;
   private Room roomForAction;
   private InstantiatedGameAction instantiatedGameAction;
   private BasicGameDesignAction effectAction;
   private List<ActionFormat> actionFormats;


   private JTextField input;
   private JTextArea history;


   private void initializeJFrame(ActionMap actionMap) {
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
      center();
   }

   public BasicGameEditor() {
      super(programName);
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

      //mainpanel.add(history, BorderLayout.CENTER);
      mainpanel.add(areaScrollPane, BorderLayout.CENTER);
      mainpanel.add(input, BorderLayout.SOUTH);

      ActionMap actionMap = new ActionMapUIResource();

      actionMap.put("enter", new AbstractAction() {
         @Override
         public void actionPerformed(ActionEvent e) {
            String cmd = input.getText().trim();
            String sofar = history.getText();
            // TODO: If game editing mode, process numbered CLI
            // Maybe use a variable indicating initialized progress
/*            if (playingGame) {
               writeToTerminal(cmd, sofar, processCmd(cmd));
            } else {*/
            editGame(cmd, sofar);
            /*            }*/
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

   private void writeToTerminal(String cmd, String sofar, String result) {
      history.setText(sofar + cmd + "\n" + result + "\n> ");
      input.setText("");
   }

   private List<String> splitByCommaAndTrim(String raw) {
      return Arrays.asList(raw.split(",")).stream().map(s -> s.trim()).collect(Collectors.toList());
   }

   private Map<String, String> stringToMap(String cmd) throws IndexOutOfBoundsException {
      List<String> splitByComma = Arrays.asList(cmd.split(","));
      Map<String, String> splitMap = null;
      if (!cmd.equals("")) {
         splitMap = splitByComma.stream()
             .map(s -> s.split("="))
             .collect(Collectors.toMap(split -> split[0], split -> split[1]));
      } else {
         splitMap = new HashMap<>();
      }
      return splitMap;
   }

   private void resetAdditions() {
      roomToAdd = null;
      instantiatedGameAction = null;
      roomForAction = null;
      effectAction = null;
      actionFormats = null;
   }

   public static <T> boolean hasDuplicate(Iterable<T> all) {
      Set<T> set = new HashSet<T>();
      // Set#add returns false if the set does not change, which
      // indicates that a duplicate element has been added.
      for (T each : all) {
         if (!set.add(each)) {
            return true;
         }
      }
      return false;
   }

   public boolean itemNamesAndAdjectives(String cmd, List<String> names, List<Set<String>> adjectives) {
      List<String> clauses = splitByCommaAndTrim(cmd);
      for (String clause : clauses) {
         if (clause.contains("[") || clause.contains("]")) {
            Pattern p = Pattern.compile("([\\w\\s]+) \\[([\\w\\s]+)\\]$");
            Matcher m = p.matcher(clause);
            boolean doesMatch = m.matches();
            if (doesMatch) {
               String name = m.group(1);
               String adjectiveSlots = m.group(2);
               names.add(name);
               adjectives.add(Arrays.asList(adjectiveSlots.split(" ")).stream()
                   .map(String::trim).collect(Collectors.toSet()));
            } else {
               return false;
            }
         } else {
            names.add(clause);
            adjectives.add(new HashSet<>());
         }
      }
      return true;
   }

   // TODO: The behaviour here will depend on the implementation of GameEngine
   // TODO: Current idea just extend com.basic.BasicGameDesignAction and check instanceof in switch
   private void editGame(String cmd, String sofar) {
      String output = null;
      switch (cmd) {
         case "quit":
            if (!saved) {
               output = "Warning: you have not saved your progress. If you still want to quit type quit again.";
               saved = true;
            } else {
               System.exit(0);
            }
            break;
         case "list":
            output = gameEngine.getPossibleActionFormats().stream()
                .map(ActionFormat::getVerb).collect(Collectors.joining(","));
            break;
         case "list items":
            if (roomForAction != null) {
               output = roomForAction.getItems().stream().map(Item::toString).collect(Collectors.joining(","));
            } else {
               output = "No room has been selected for adding an action to";
            }
            break;
         case "stop":
            output = "";
            resetAdditions();
            basicGameEditState = BasicGameEditState.OPEN;
            break;
         default:
            switch (basicGameEditState) {
               case OPEN:
                  switch (cmd) {
                     case "add room":
                        output = "What should the room be called?";
                        basicGameEditState = BasicGameEditState.ROOM_NAME;
                        break;
                     case "add action":
                        output = "In what room?";
                        basicGameEditState = BasicGameEditState.ACTION_ROOM;
                        break;
                     case "save":
                        output = "Saving your game. What file-name do you want it to have?";
                        basicGameEditState = BasicGameEditState.SAVE_FILENAME;
                        break;
                     default:
                        output = "That isn't a recognized command";
                        break;
                  }
                  break;
               case SAVE_FILENAME:
                  String fileName = cmd.length() > 0 ? cmd : "your-latest-game.ser";
                  fileName = fileName.endsWith(".ser") ? fileName : fileName + ".ser";
                  try {
                     FileOutputStream fileOut =
                         new FileOutputStream(fileName);
                     ObjectOutputStream out = new ObjectOutputStream(fileOut);
                     out.writeObject(gameEngine);
                     out.close();
                     fileOut.close();
                     output = String.format("Saved your game to disk with name: %s.", fileName);
                     saved = true;
                  } catch (IOException i) {
                     i.printStackTrace();
                  }
                  break;
               case ROOM_NAME:
                  List<Room> matchingRooms = gameEngine.findRoom(cmd);
                  if (matchingRooms.size() > 0) {
                     output = "There is already a room by that name. Try again.";
                     basicGameEditState = BasicGameEditState.OPEN;
                  } else if (cmd.length() == 0) {
                     output = "Please enter a name with more than one character";
                  } else {
                     roomToAdd = new Room(cmd);
                     output = String.format("Adding room %s. What items do you want to add? " +
                         "Enter this as a comma-separated list with adjectives space-separated in square brackets" +
                         " i.e. \"bear [furry big brown], bread [fluffy], pizza\".", cmd);
                     basicGameEditState = BasicGameEditState.ROOM_ITEMS;
                  }
                  break;
               case ROOM_ITEMS:
                  //List<String> splitItems = splitByCommaAndTrim(cmd);
                  List<String> names = new ArrayList<>();
                  List<Set<String>> adjectives = new ArrayList<>();
                  boolean validText = itemNamesAndAdjectives(cmd, names, adjectives);

                  if (validText) {
                     if (hasDuplicate(names)) {
                        output = "Items can not have the same name. Try again.";
                     } else if (names.contains("world")) {
                        output = "The word \"world\" is reserved";
                     } else {
                        Set<Item> items = new HashSet<>();
                        for (int i = 0; i < names.size(); i++) {
                           Item item = new Item(names.get(i), adjectives.get(i));
                           items.add(item);
                        }
                        roomToAdd.setItems(items);
                        gameEngine.addRoom(roomToAdd);
                        output = String.format("Great. Added a room called \"%s\" with items \"%s\"."
                            , roomToAdd.getName(), names.stream()
                                .collect(Collectors.joining(",")));
                        if (gameEngine.getNumRooms() == 1) {
                           gameEngine.setCurrentRoom(roomToAdd);
                           output += " I've set this as the starting room as well.";
                        }
                        resetAdditions();
                        basicGameEditState = BasicGameEditState.OPEN;
                     }
                  } else {
                     output = "Invalid specification. Try to use the form " +
                         "\"name1 [adj1 adj2 ... adjn]\" for each item or just \"name2\" without" +
                         "adjectives";
                  }
                  break;
               case ACTION_ROOM:
                  List<Room> matchedRooms = gameEngine.findRoom(cmd);
                  if (matchedRooms.size() < 1) {
                     output = "Couldn't find a room with that name. Try again or add it " +
                         "using \"add room\" after writing \"stop\".";
                  } else {
                     roomForAction = matchedRooms.get(0);
                     output = "With what trigger word? Enter this as a verb e.g. \"open\". " +
                         "To see a list of the possible trigger words type \"list\" ";
                     basicGameEditState = BasicGameEditState.ACTION_TRIGGER;
                  }
                  break;
               case ACTION_TRIGGER:
                  actionFormats = gameEngine.findAction(cmd);
                  if (actionFormats.size() > 1) {
                     output = "There are multiple actions with that trigger word but different " +
                         "sentence structures. Enter the index of the one you meant.";
                     output += "\n";
                     for (int i = 0; i < actionFormats.size(); i++) {
                        output += String.format("(%d) %s \n", i, actionFormats.get(i).getRegExpr());
                     }
                     basicGameEditState = BasicGameEditState.ACTION_TRIGGER_CLARIFY;
                  } else if (actionFormats.size() == 1) {
                     ActionFormat actionFormat = actionFormats.get(0);
                     instantiatedGameAction = new InstantiatedGameAction(actionFormat);
                     output = "Enter the items that this action should act upon as a " +
                         "comma-separated list e.g. \"apple,banana,pear\".";
                     actionFormats = null;
                     basicGameEditState = BasicGameEditState.ACTION_ARGS;
                  } else {
                     output = "Couldn't find a trigger word with that name. To see a list of " +
                         "the possible trigger words type \"list\"";
                  }
                  break;
               case ACTION_TRIGGER_CLARIFY:
                  try {
                     int index = Integer.parseInt(cmd);
                     if (index >= actionFormats.size() || index < 0) {
                        output = "That index was not one of the ones displayed.";
                     } else {
                        ActionFormat actionFormat = actionFormats.get(index);
                        instantiatedGameAction = new InstantiatedGameAction(actionFormat);
                        output = "Enter the items that this action should act upon as a " +
                            "comma-separated list e.g. \"apple,banana,pear\".";
                        actionFormats = null;
                        basicGameEditState = BasicGameEditState.ACTION_ARGS;
                     }
                  } catch (NumberFormatException e) {
                     output = "Non-integer entered to choose among the above options.";
                  }
                  break;
               case ACTION_ARGS:
                  List<String> splitArgs = splitByCommaAndTrim(cmd);
                  int numArgs = instantiatedGameAction.getAbstractActionFormat().getDegree();
                  int givenArgs = cmd.equals("") ? 0 : splitArgs.size();
                  if (givenArgs != numArgs) {
                     output = String.format("Incorrect argument list. You need to enter " +
                         "exactly %d argument(s).", numArgs);
                  } else {
                     boolean validItems = roomForAction.validItems(splitArgs);
                     if (validItems) {
                        instantiatedGameAction.setArguments(splitArgs);
                        output = "Enter the preconditions on the global state for this action " +
                            "e.g. \"room=First room,player=yellow\".";
                        basicGameEditState = BasicGameEditState.ACTION_PRE;
                     } else {
                        output = "One or more of those items is not in the room. Try again.";
                     }
                  }
                  break;
               case ACTION_PRE:
                  try {
                     effectAction = new BasicGameDesignAction();
                     Map<String, String> splitPreconds = stringToMap(cmd);
                     effectAction.setPreconditions(splitPreconds);
                     output = "Enter the effect on the global state for this action " +
                         "e.g. \"room=room2,player=red\".";
                     basicGameEditState = BasicGameEditState.ACTION_POST;
                  } catch (IndexOutOfBoundsException e) {
                     output = "Malformed string. Remember to separate each key of the world state" +
                         " by a \",\" and the key and the value by a \"=\" with no excess spaces";
                  }
                  break;
               case ACTION_POST:
                  try {
                     Map<String, String> splitPostconds = stringToMap(cmd);
                     effectAction.setUpdateState(splitPostconds);
                     output = "Enter the message to display to the user after taking this action.";
                     basicGameEditState = BasicGameEditState.ACTION_MSG;
                  } catch (IndexOutOfBoundsException e) {
                     output = "Malformed string. Remember to separate each key of the world state" +
                         " by a \",\" and the key and the value by a \"=\" with no excess spaces";
                  }
                  break;
               case ACTION_MSG:
                  effectAction.setMessage(cmd);
                  gameEngine.addAction(roomForAction, instantiatedGameAction, effectAction);
                  resetAdditions();
                  output = "Great. Adding your new action to the game";
                  basicGameEditState = BasicGameEditState.OPEN;
                  break;
               default:
                  output = "Invalid game-developing state. Consult the game developer.";
                  break;
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

/*
   public String processCmd(String cmd) {
      List<com.shared.ActionFormat> possibleGameActions = gameEngine.getPossibleActionFormats();
      List<com.shared.Item> possibleItems = gameEngine.possibleItems();
      com.shared.InstantiatedGameAction gameAction = null;
      try {
         gameAction = nlpEngine.parse(cmd, possibleGameActions, possibleItems);
      } catch (com.nlp.FailedParseException e) {
         return e.getMessage();
      }
      String gameMessage = gameEngine.progressStory(gameAction);

      return gameMessage;
   }
*/

   public static void main(final String[] args) {
      Runnable runner = BasicGameEditor::new;
      EventQueue.invokeLater(runner);
   }
}
