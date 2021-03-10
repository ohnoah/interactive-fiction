package com.intfic.game.basic;

import com.intfic.game.shared.ActionFormat;
import com.intfic.game.shared.InstantiatedGameAction;
import com.intfic.game.shared.Item;
import com.intfic.game.shared.Room;
import com.intfic.game.shared.Util;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
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
import net.sf.extjwnl.JWNLException;
import net.sf.extjwnl.data.IndexWord;
import net.sf.extjwnl.data.POS;
import net.sf.extjwnl.data.Synset;
import net.sf.extjwnl.data.Word;
import net.sf.extjwnl.dictionary.Dictionary;

/**
 * com.interactivefiction.BasicGameEditor
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
   private Item synonymItem;
   private ArrayList<String> synonymIds;


   private void initializeJFrame(ActionMap actionMap) {
      InputMap keyMap = input.getInputMap();
      input.getActionMap().put("enter", actionMap.get("enter"));
      keyMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
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
            List<String> res = editGame(cmd, sofar);
            String cmdRet = res.get(0);
            String sofarRet = res.get(1);
            String outputRet = res.get(2);
            writeToTerminal(cmdRet, sofarRet, outputRet);
/*            String cmd = input.getText().trim();
            String sofar = history.getText();*/
            // Maybe use a variable indicating initialized progress
            /*editGame(cmd, sofar);*/
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
      if (cmd.length() > 40) {
         history.setText(sofar + cmd + "\n \n" + result + "\n> ");
      }
      else {
         history.setText(sofar + cmd + "\n" + result + "\n> ");
      }
      input.setText("");
   }

   private List<String> splitByCommaAndTrim(String raw) {
      return splitByCommaAndTrim(raw, false);
   }

   private List<String> splitByCommaAndTrim(String raw, boolean lowerCase) {
      if (lowerCase) {
         return Arrays.stream(raw.split(",")).map(s -> s.trim().toLowerCase()).collect(Collectors.toList());
      }
      else {
         return Arrays.stream(raw.split(",")).map(s -> s.trim()).collect(Collectors.toList());
      }
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

   private BasicCondition stringToCondition(String s) {
      String[] parts = s.split("\\|");
      if (parts.length != 2) {
         return null;
      }
      String[] keyDesValue = parts[0].split("=");
      if (keyDesValue.length != 2) {
         return null;
      }

      String failureMessage = parts[1];
      return new BasicCondition(keyDesValue[0], keyDesValue[1], failureMessage);
   }


   public boolean itemNamesAndAdjectives(String cmd, List<String> names, List<Set<String>> adjectives) {
      List<String> clauses = Util.splitByCommaAndTrim(cmd, true);
      for (String clause : clauses) {
         if (clause.contains("[") || clause.contains("]")) {
            Pattern p = Pattern.compile("([\\w\\s]+) \\[([\\w\\s-]+)]$");
            Matcher m = p.matcher(clause);
            boolean doesMatch = m.matches();
            if (doesMatch) {
               String name = m.group(1);
               String adjectiveSlots = m.group(2);
               names.add(name);
               adjectives.add(Arrays.stream(adjectiveSlots.split(" "))
                   .map(String::trim).collect(Collectors.toSet()));
            }
            else {
               return false;
            }
         }
         else {
            names.add(clause);
            adjectives.add(new HashSet<>());
         }
      }
      return true;
   }

   // TODO: The behaviour here will depend on the implementation of com.interactivefiction.GameEngine
   // TODO: Current idea just extend com.interactivefiction.game.basic.BasicGameDesignAction and check instanceof in switch
   private List<String> editGame(String cmd, String sofar) {
      String output = null;
      cmd = cmd.replace("\\n", "\n");
      switch (cmd) {
         case "quit":
            if (!saved) {
               output = "Warning: you have not saved your progress. If you still want to quit type quit again.";
               saved = true;
            }
            else {
               System.exit(0);
            }
            break;
         case "clear":
            output = "Cleared your status.";
            basicGameEditState = BasicGameEditState.OPEN;
            gameEngine = new BasicGameEngine();
            resetAdditions();
            break;
         case "list":
            output = gameEngine.getPossibleActionFormats().stream()
                .map(ActionFormat::getVerb).collect(Collectors.joining(","));
            break;
         case "list items":
            if (roomForAction != null) {
               output = roomForAction.getItems().values().stream().map(Item::toString).collect(Collectors.joining(","));
            }
            else {
               output = String.join("\n", gameEngine.globalItems()
                   .keySet());
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
                     case "":
                        output = "";
                        break;
                     case "add room":
                        output = "What should the room be called?";
                        basicGameEditState = BasicGameEditState.ROOM_NAME;
                        break;
                     case "add action":
                        output = "In what room?";
                        basicGameEditState = BasicGameEditState.ACTION_ROOM;
                        break;
                     case "load":
                        output = "Select a text file with commands to build a new game.";
                        basicGameEditState = BasicGameEditState.LOAD;
                        break;
                     case "save":
                        output = "Saving your game. What file-name do you want it to have?";
                        basicGameEditState = BasicGameEditState.SAVE_FILENAME;
                        break;
                     case "start message":
                        output = "What start message do you want the player to see when they start a new game?";
                        basicGameEditState = BasicGameEditState.START_MESSAGE;
                        break;
                     case "add synonyms":
                        Map<String, Item> globalItems = gameEngine.globalItems();
                        StringBuilder outBuilder = new StringBuilder();
                        synonymIds = new ArrayList<>(globalItems.keySet());
                        int i = 0;
                        for (String key : synonymIds) {
                           outBuilder.append(String.format("(%d) %s \n", i++, key));
                        }
                        output = outBuilder.toString();
                        output += "Type the id of the item you want to add synonyms for.";
                        basicGameEditState = BasicGameEditState.ITEM_SYNONYMS;
                        break;
                     case "new action":
                        output = "What new action do you want to add? Specify the verb and any regex by a comma e.g. \"fly, MYREGEX\". If you wan't a unary action, simply type the verb.";
                        basicGameEditState = BasicGameEditState.ACTIONFORMAT;
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
                     basicGameEditState = BasicGameEditState.OPEN;
                  }
                  catch (IOException i) {
                     i.printStackTrace();
                     output = "Try again. IOEXception";
                  }
                  break;
               case LOAD:
                  if (cmd.length() > 0) {
                     String fn = cmd;
                     fn = fn.endsWith(".txt") ? fn : fn + ".txt";
                     List<String> res = List.of("load", ">", "");
                     try {
                        File myObj = new File(fn);
                        Scanner myReader = new Scanner(myObj);
                        basicGameEditState = BasicGameEditState.OPEN;
                        while (myReader.hasNextLine()) {
                           String line = myReader.nextLine().trim();
                           if (!((line.equals("") && basicGameEditState.equals(BasicGameEditState.OPEN)) || line.startsWith("#") || line.startsWith("%"))) {
                              String runningSofar = history.getText();
                              res = editGame(line, runningSofar);
                              writeToTerminal(res.get(0), res.get(1), res.get(2));
                           }
                        }
                        myReader.close();
                        return res;
                     }
                     catch (FileNotFoundException e) {
                        System.err.println("Couldn't open the load file");
                        e.printStackTrace();
                        output = "Try again. Invalid File name.";
                     }
                  }
                  else {
                     output = "Invalid file name";
                  }
                  break;
               case START_MESSAGE:
                  gameEngine.setStartMessage(cmd);
                  output = String.format("Setting your start message as: \n %s", cmd);
                  basicGameEditState = BasicGameEditState.OPEN;
                  break;
               case ACTIONFORMAT:
                  if (cmd.contains(",")) {
                     String[] verbRegex = cmd.split(",");
                     if (verbRegex.length != 2) {
                        output = "Too many comma in input. Only one comma is needed for a regex and verb";
                     }
                     else {
                        ActionFormat af = new ActionFormat(verbRegex[0], verbRegex[1]);
                        gameEngine.addActionFormat(af);
                        output = String.format("Adding verb %s with regex %s as a nullary/ternary action format", verbRegex[0], verbRegex[1]);
                        basicGameEditState = BasicGameEditState.OPEN;
                     }
                  }
                  else {
                     ActionFormat af = new ActionFormat(cmd);
                     gameEngine.addActionFormat(af);
                     output = String.format("Adding unary action format %s.", cmd);
                     basicGameEditState = BasicGameEditState.OPEN;
                  }
                  break;
               case ROOM_NAME:
                  List<Room> matchingRooms = gameEngine.findRoom(cmd);
                  if (matchingRooms.size() > 0) {
                     output = "There is already a room by that name. Try again.";
                     basicGameEditState = BasicGameEditState.OPEN;
                  }
                  else if (cmd.length() == 0) {
                     output = "Please enter a name with more than one character";
                  }
                  else {
                     roomToAdd = new Room(cmd);
                     output = String.format("Adding room %s. What items do you want to add? " +
                         "Enter this as a comma-separated list with adjectives space-separated in square brackets" +
                         " i.e. \"bear [furry big brown], bread [fluffy], pizza\".", cmd);
                     basicGameEditState = BasicGameEditState.ROOM_ITEMS;
                  }
                  break;
               case ROOM_ITEMS:
                  //List<String> splitItems = Util.splitByCommaAndTrim(cmd);
                  List<String> names = new ArrayList<>();
                  List<Set<String>> adjectives = new ArrayList<>();
                  boolean validText = itemNamesAndAdjectives(cmd, names, adjectives);

                  if (validText) {
                     if (names.contains("world")) {
                        output = "The word \"world\" is reserved";
                     }
                     else {
                        List<Item> items = new ArrayList<>();
                        for (int i = 0; i < names.size(); i++) {
                           Item item = new Item(names.get(i), adjectives.get(i));
                           if (!items.contains(item)) {
                              items.add(item);
                           }
                        }
                        roomToAdd.setItems(items);
                        gameEngine.addRoom(roomToAdd);
                        output = String.format("Great. Added a room called \"%s\" with items \"%s\"."
                            , roomToAdd.getName(), String.join(",", names));
                        if (gameEngine.getNumRooms() == 1) {
                           gameEngine.setCurrentRoom(roomToAdd);
                           output += " I've set this as the starting room as well.";
                        }
                        resetAdditions();
                        basicGameEditState = BasicGameEditState.OPEN;
                     }
                  }
                  else {
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
                  }
                  else {
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
                  }
                  else if (actionFormats.size() == 1) {
                     ActionFormat actionFormat = actionFormats.get(0);
                     instantiatedGameAction = new InstantiatedGameAction(actionFormat);
                     output = "Enter the items that this action should act upon as a " +
                         "comma-separated list e.g. \"apple,banana,pear\".";
                     actionFormats = null;
                     basicGameEditState = BasicGameEditState.ACTION_ARGS;
                  }
                  else {
                     output = "Couldn't find a trigger word with that name. To see a list of " +
                         "the possible trigger words type \"list\"";
                  }
                  break;
               case ACTION_TRIGGER_CLARIFY:
                  try {
                     int index = Integer.parseInt(cmd);
                     if (index >= actionFormats.size() || index < 0) {
                        output = "That index was not one of the ones displayed.";
                     }
                     else {
                        ActionFormat actionFormat = actionFormats.get(index);
                        instantiatedGameAction = new InstantiatedGameAction(actionFormat);
                        output = "Enter the items that this action should act upon as a " +
                            "comma-separated list e.g. \"apple,banana,pear\".";
                        actionFormats = null;
                        basicGameEditState = BasicGameEditState.ACTION_ARGS;
                     }
                  }
                  catch (NumberFormatException e) {
                     output = "Non-integer entered to choose among the above options.";
                  }
                  break;
               case ACTION_ARGS:
                  List<String> splitArgs;
                  if(cmd.matches("\\s*")){
                     splitArgs = new ArrayList<>();
                  }
                  else {
                     splitArgs = Util.splitByCommaAndTrim(cmd);
                  }
                  int numArgs = instantiatedGameAction.getAbstractActionFormat().getDegree();
                  int givenArgs = splitArgs.size();
                  if (givenArgs != numArgs) {
                     output = String.format("Incorrect argument list. You need to enter " +
                         "exactly %d argument(s).", numArgs);
                  }
                  else {
                     List<String> formattedItemNames = new ArrayList<>();
                     String roomPrefix = Item.roomId(roomForAction.getName());
                     for (String s : splitArgs) {
                        s = s.toLowerCase();
                        String formatted = !s.startsWith(roomPrefix) ? roomPrefix + "." + s : s;
                        formattedItemNames.add(formatted);
                     }
                     boolean validItems = roomForAction.isValidItemIdentifierList(formattedItemNames);
                     if (validItems) {
                        Map<String, Item> roomItems = roomForAction.getItems();
                        instantiatedGameAction.setActualArguments(formattedItemNames.stream().map(roomItems::get).collect(Collectors.toList()));
                        output = "Enter the preconditions on the global state for this action and error messages " +
                            "e.g. \"room=First room|Not in the right room,player=yellow|Player is not yellow.\".";
                        basicGameEditState = BasicGameEditState.ACTION_PRE;
                     }
                     else {
                        output = "One or more of those items is not in the room. Try again.";
                     }
                  }
                  break;
               case ACTION_PRE:
                  try {
                     effectAction = new BasicGameDesignAction();
                     List<BasicCondition> preConds;
                     // IF THE INPUT IS BLANK
                     if (cmd.matches("\\s*")) {
                        preConds = new ArrayList<>();
                        effectAction.setPreconditions(preConds);
                        output = "Enter the updates to the world state as a comma-separated set of equality statements \"key1=val1, banana=phone\"";
                        basicGameEditState = BasicGameEditState.ACTION_POST;
                     }
                     else {
                        List<String> splitPreconds = Util.splitByCommaAndTrim(cmd);
                        preConds = splitPreconds.stream().map(this::stringToCondition).collect(Collectors.toList());
                        int indexNull = preConds.indexOf(null);
                        if (indexNull != -1) {
                           output = String.format("Invalid condition \"%s\". Remember the pipe symbol and error message.", splitPreconds.get(indexNull));
                        }
                        else {
                           effectAction.setPreconditions(preConds);
                           output = "Enter the updates to the world state as a comma-separated set of equality statements \"key1=val1, banana=phone\"";
                           basicGameEditState = BasicGameEditState.ACTION_POST;
                        }
                     }

                  }
                  catch (IndexOutOfBoundsException e) {
                     output = "Malformed string. Remember to separate each condition string " +
                         " by a \",\"";
                  }
                  break;
               case ACTION_POST:
                  try {
                     Map<String, String> splitPostconds = Util.stringToMap(cmd);
                     effectAction.setUpdateState(splitPostconds);
                     output = "Enter the message to display to the user after taking this action.";
                     basicGameEditState = BasicGameEditState.ACTION_MSG;
                  }
                  catch (IndexOutOfBoundsException e) {
                     output = "Malformed string. Remember to separate each key of the world state" +
                         " by a \",\" and the key and the value by a \"=\" with no excess spaces";
                  }
                  break;
               case ACTION_MSG:
                  effectAction.setSuccessMessage(cmd);
                  gameEngine.addAction(roomForAction, instantiatedGameAction, effectAction);
                  basicGameEditState = BasicGameEditState.OPEN;
                  resetAdditions();
                  output = "Great. Adding your new action to the game";
                  break;
               case ITEM_SYNONYMS:
                  Map<String, Item> globalItems = gameEngine.globalItems();
                  // WORDNET

                  String itemId;
                  if (cmd.matches("(0|[1-9]\\d*)")) {
                     int j = Integer.parseInt(cmd);
                     if (j < synonymIds.size() && j >= 0) {
                        itemId = synonymIds.get(j);
                     }
                     else {
                        itemId = null;
                     }
                  }
                  else {
                     itemId = cmd;
                  }
                  if (globalItems.containsKey(itemId)) {
                     this.synonymItem = globalItems.get(itemId);
                     try {
                        Dictionary d = Dictionary.getDefaultResourceInstance();
                        IndexWord iw = d.lookupIndexWord(POS.NOUN, this.synonymItem.getName());
                        if (iw == null) {
                           output = "Couldn't load dictionary entry for " + this.synonymItem.getName() + ". Type some synonyms you want anyway.";
                        }
                        else {
                           List<Synset> synsets = iw.getSenses();
                           StringBuilder outputBuilder = new StringBuilder();
                           for (Synset synset : synsets) {
                              outputBuilder.append(synset.getWords().stream().
                                  map(w -> w.getLemma().equals(synonymItem.getName()) ? null : w.getLemma()).
                                  filter(s -> !Objects.isNull(s)).
                                  collect(Collectors.joining(","))).
                                  append("\n");
                           }
                           output = "---- \n " + outputBuilder.toString() + "---- \n";
                           output += String.format(" are some suggested synonyms for %s. " +
                               "Type those that you want and any more synonyms you wish as a comma-separated list.", this.synonymItem.getName());
                        }
                     }
                     catch (JWNLException e) {
                        output = "Couldn't load dictionary " + e.getMessage() + ". Type some synonyms you want anyway.";
                     }
                     basicGameEditState = BasicGameEditState.ITEM_SYNONYMS_SPECIFIED;
                  }
                  else {
                     output = "Invalid index specified or misspelled ID of item.";
                  }
                  break;
               case ITEM_SYNONYMS_SPECIFIED:
                  if (!cmd.matches("\\s*")) {
                     List<String> splitList = Util.splitByCommaAndTrim(cmd, true);
                     this.synonymItem.addSynonyms(splitList);
                     this.synonymItem.getParentRoom().addItem(this.synonymItem);
                     output = "Added synonyms " + String.join("|", splitList) + " to the item " + this.synonymItem.getName();
                  }
                  else {
                     output = "Not adding any synonyms";
                  }
                  basicGameEditState = BasicGameEditState.OPEN;
                  break;
               default:
                  output = "Invalid game-developing state. Consult the game developer.";
                  break;
            }
      }


      return List.of(cmd, sofar, output);
      /*      writeToTerminal(cmd, sofar, output);*/

   }

   private void center() {
      Toolkit tk = Toolkit.getDefaultToolkit();
      Dimension screen = tk.getScreenSize();
      Dimension d = getSize();
      setLocation((screen.width - d.width) / 2, (screen.height - d.height) / 2);
   }

/*
   public String processCmd(String cmd) {
      List<ActionFormat> possibleGameActions = gameEngine.getPossibleActionFormats();
      List<Item> possibleItems = gameEngine.possibleItems();
      InstantiatedGameAction gameAction = null;
      try {
         gameAction = nlpEngine.parse(cmd, possibleGameActions, possibleItems);
      } catch (FailedParseException e) {
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
