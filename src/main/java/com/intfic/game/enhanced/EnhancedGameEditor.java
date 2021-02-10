package com.intfic.game.enhanced;

import com.intfic.game.enhanced.reasoning.wrappers.Condition;
import com.intfic.game.enhanced.reasoning.frames.GenericFrame;
import com.intfic.game.enhanced.reasoning.wrappers.Justification;
import com.intfic.game.enhanced.reasoning.KnowledgeBase;
import com.intfic.game.enhanced.reasoning.KnowledgeRegex;
import com.intfic.game.enhanced.reasoning.updates.KnowledgeUpdate;
import com.intfic.game.enhanced.reasoning.frames.SpecificFrame;
import com.intfic.game.enhanced.reasoning.visitors.TypeConvertVisitor;
import com.intfic.game.enhanced.reasoning.VisitorHelper;
import com.intfic.game.enhanced.reasoning.error.KnowledgeException;
import com.intfic.game.shared.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.plaf.ActionMapUIResource;
import net.sf.extjwnl.JWNLException;
import net.sf.extjwnl.data.IndexWord;
import net.sf.extjwnl.data.POS;
import net.sf.extjwnl.data.Synset;
import net.sf.extjwnl.data.Word;
import net.sf.extjwnl.dictionary.Dictionary;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.jetbrains.annotations.NotNull;

/**
 * com.interactivefiction.BasicGameEditor
 *
 * @author Stefan Wagner, Noah Ohrner
 * @date Mi 25. Apr 17:27:19 CEST 2012, 17 Nov 2020
 * (c) GPLv3
 */
public class EnhancedGameEditor extends JFrame {
   private static final String programName = "IF ENHANCED EDITOR";
   private EnhancedGameEngine gameEngine = new EnhancedGameEngine();
   private KnowledgeBase knowledgeBase = this.gameEngine.getKnowledgeBase();
   private boolean saved = false;


   private EnhancedGameEditState enhancedGameEditState = EnhancedGameEditState.OPEN;
   // Game Editing State variables to store progress
   private Room roomToAdd;
   private Room roomForAction;
   private InstantiatedGameAction instantiatedGameAction;
   private EnhancedGameDesignAction effectAction;
   private List<ActionFormat> actionFormats;
   // Enhanced
   private List<SpecificFrame> specificFrames;
   private SpecificFrame child;
   private GenericFrame parent;
   private List<GenericFrame> genericFrames;


   private JTextField input;
   private JTextArea history;
   private Item synonymItem;

   public int getNumEdits() {
      return numEdits;
   }

   private int numEdits = 0;


   private void initializeJFrame(ActionMap actionMap) {
      InputMap keyMap = input.getInputMap();
      input.getActionMap().put("enter", actionMap.get("enter"));
      keyMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");

      input.setEditable(true);
      history.setText("Welcome to the enhanced IF game editor \n> ");
      setSize(600, 600);
      setLocation(100, 100);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);
      center();
   }

   public EnhancedGameEditor() {
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

   private Condition stringToCondition(String s) {
      String[] parts = s.split("\\|");
      if (parts.length != 2) {
         return null;
      }
      String booleanExpr = parts[0];
      String failureMessage = parts[1];
      return new Condition(booleanExpr, failureMessage);
   }

   private KnowledgeUpdate stringToKnowledgeUpdate(String raw) {
      try {
         return new KnowledgeUpdate(raw);
      }
      catch (KnowledgeException e) {
         return null;
      }
   }

   private Map<String, String> stringToMap(String cmd) throws IndexOutOfBoundsException {
      List<String> splitByComma = Arrays.asList(cmd.split(","));
      Map<String, String> splitMap = null;
      if (!cmd.equals("")) {
         splitMap = splitByComma.stream()
             .map(s -> s.split("="))
             .collect(Collectors.toMap(split -> split[0], split -> split[1]));
      }
      else {
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
      specificFrames = null;
      genericFrames = null;
      child = null;
      parent = null;
   }

   private static <T> boolean hasDuplicate(Iterable<T> all) {
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

   private static Justification validNames(List<String> names) {
      for (String name : names) {
         name = name.replace(' ', '-');
         if (!(name.length() > 0 && name.charAt(0) != '_' && !name.contains("-") && !name.contains(" ") && Pattern.matches(KnowledgeRegex.FRAME_NAME_EXPR, name))) {
            return new Justification(false, String.format("%s is not a valid name. It should only contain letters and numbers", name.replace('-', ' ')));
         }
      }
      return new Justification(true, "");
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

   private List<String> editGame(String cmd, String sofar) {
      this.numEdits++;
      String output = null;
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
         case "load":
            output = "Select a text file with commands to build a new game.";
            enhancedGameEditState = EnhancedGameEditState.LOAD;
            break;
         case "clear":
            output = "Cleared your status.";
            gameEngine = new EnhancedGameEngine();
            resetAdditions();
            break;
         case "list":
            output = gameEngine.getPossibleActionFormats().stream()
                .map(ActionFormat::getVerb).collect(Collectors.joining(","));
            break;
         case "list items":
            if (roomForAction != null) {
               output = roomForAction.getItems().stream().map(Item::toString).collect(Collectors.joining(","));
            }
            else {
               output = String.join("\n", gameEngine.globalItems().keySet());
            }
            break;
         case "print knowledge":
            output = knowledgeBase.toString();
            break;
         case "start message":
            output = "What start message do you want the player to see when they start a new game?";
            enhancedGameEditState = EnhancedGameEditState.START_MESSAGE;
            break;
         case "stop":
            output = "";
            resetAdditions();
            enhancedGameEditState = EnhancedGameEditState.OPEN;
            break;
         default:
            switch (enhancedGameEditState) {
               case OPEN:
                  switch (cmd) {
                     case "add room":
                        output = "What should the room be called?";
                        enhancedGameEditState = EnhancedGameEditState.ROOM_NAME;
                        break;
                     case "add action":
                        output = "In what room?";
                        enhancedGameEditState = EnhancedGameEditState.ACTION_ROOM;
                        break;
                     case "save":
                        output = "Saving your game. What file-name do you want it to have?";
                        enhancedGameEditState = EnhancedGameEditState.SAVE_FILENAME;
                        break;
                     case "edit knowledge":
                        output = String.format("%s is the state of your current KnowledgeBase. " +
                            "Type \"fillers\" to update SpecificFrame values or \"parents\" " +
                            "to update and inherit with Generic Frames", knowledgeBase.toString());
                        enhancedGameEditState = EnhancedGameEditState.EDIT_KNOWLEDGE;
                        break;
                     case "add synonyms":
                        Map<String, Item> globalItems = gameEngine.globalItems();
                        StringBuilder outBuilder = new StringBuilder();
                        for (String key : globalItems.keySet()) {
                           outBuilder.append(String.format("%s \n", key));
                        }
                        output = outBuilder.toString();
                        output += "Type the id of the item you want to add synonyms for.";
                        enhancedGameEditState = EnhancedGameEditState.ITEM_SYNONYMS;
                        break;
                     case "new action":
                        output = "What new action do you want to add? Specify the verb and any regex by a comma e.g. \"fly, MYREGEX\". If you wan't a unary action, simply type the verb.";
                        enhancedGameEditState = EnhancedGameEditState.ACTIONFORMAT;
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
                  }
                  catch (IOException i) {
                     i.printStackTrace();
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
                        enhancedGameEditState = EnhancedGameEditState.OPEN;
                        while (myReader.hasNextLine()) {
                           String line = myReader.nextLine().trim();
                           String runningSofar = history.getText();
                           res = editGame(line, runningSofar);
                           writeToTerminal(res.get(0), res.get(1), res.get(2));
                        }
                        myReader.close();
                        enhancedGameEditState = EnhancedGameEditState.OPEN;
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
                  output = String.format("Setting your start message %s", cmd);
                  enhancedGameEditState = EnhancedGameEditState.OPEN;
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
                        enhancedGameEditState = EnhancedGameEditState.OPEN;
                        output = String.format("Adding verb %s with regex %s as a nullary/ternary action format", verbRegex[0], verbRegex[1]);
                     }
                  }
                  else {
                     ActionFormat af = new ActionFormat(cmd);
                     gameEngine.addActionFormat(af);
                     output = String.format("Adding unary action format %s.", cmd);
                     enhancedGameEditState = EnhancedGameEditState.OPEN;
                  }
                  break;
               case ROOM_NAME:
                  List<Room> matchingRooms = gameEngine.findRoom(cmd);
                  if (matchingRooms.size() > 0) {
                     output = "There is already a room by that name. Try again.";
                     enhancedGameEditState = EnhancedGameEditState.OPEN;
                  }
                  else if (cmd.length() == 0) {
                     output = "Please enter a name with more than one character";
                  }
                  else {
                     roomToAdd = new Room(cmd);
                     output = String.format("Adding room %s. What items do you want to add? " +
                         "Enter this as a comma-separated list with adjectives space-separated in square brackets" +
                         " i.e. \"bear [furry big brown], bread [fluffy], pizza\".", cmd);
                     enhancedGameEditState = EnhancedGameEditState.ROOM_ITEMS;
                  }
                  break;
               case ROOM_ITEMS:
                  //List<String> splitItems = splitByCommaAndTrim(cmd);
                  List<String> names = new ArrayList<>();
                  List<Set<String>> adjectives = new ArrayList<>();
                  boolean validText = itemNamesAndAdjectives(cmd, names, adjectives);
                  Justification j = validNames(names);

                  if (validText) {
                     if (hasDuplicate(names)) {
                        output = "Items can not have the same name. Try again.";
                     }
                     else if (!j.isAccepted()) {
                        output = j.getReasoning();
                     }
                     else if (names.contains("world")) {
                        output = "The word \"world\" is reserved";
                     }
                     else {
                        Set<Item> items = new HashSet<>();
                        for (int i = 0; i < names.size(); i++) {
                           Item item = new Item(names.get(i), adjectives.get(i));
                           items.add(item);
                        }
                        roomToAdd.setItems(items);
                        gameEngine.addRoom(roomToAdd);
                        output = String.format("Great. Added a room called \"%s\" with items \"%s\". " +
                                "Remember to add volumes using the \"edit knowledge -> fillers\" command for them to work properly with implemented behaviour."
                            , roomToAdd.getName(), String.join(",", names));
                        if (gameEngine.getNumRooms() == 1) {
                           gameEngine.setCurrentRoom(roomToAdd);
                           output += " I've set this as the starting room as well.";
                        }
                        resetAdditions();
                        enhancedGameEditState = EnhancedGameEditState.OPEN;
                     }
                  }
                  else {
                     output = "Invalid specification. Try to use the form " +
                         "\"name1 [adj1 adj2 ... adjn]\" for each item or just \"name2\" without" +
                         "adjectives. Remember, item names don't contain spaces";
                  }
                  break;
               case ITEM_SYNONYMS:
                  Map<String, Item> globalItems = gameEngine.globalItems();
                  if (globalItems.containsKey(cmd)) {
                     // WORDNET
                     this.synonymItem = globalItems.get(cmd);
                     try {
                        Dictionary d = Dictionary.getDefaultResourceInstance();
                        IndexWord iw = d.getIndexWord(POS.NOUN, this.synonymItem.getName());
                        if (iw == null) {
                           output = "Couldn't load dictionary entry for " + this.synonymItem.getName() + ". Type some synonyms you want anyway.";
                        }
                        else {
                           List<Synset> synsets = iw.getSenses();
                           StringBuilder outputBuilder = new StringBuilder();
                           for (Synset synset : synsets) {
                              outputBuilder.append(synset.getWords().stream().map(Word::getLemma).collect(Collectors.joining(","))).append("\n");
                           }
                           output = "---- \n " + outputBuilder.toString() + "---- \n";
                           output += String.format(" are some suggested synonyms for %s. " +
                               "Type those that you want and any more synonyms you wish as a comma-separated list.", this.synonymItem.getName());
                        }
                     }
                     catch (JWNLException e) {
                        output = "Couldn't load dictionary " + e.getMessage() + ". Type some synonyms you want anyway.";
                     }
                     enhancedGameEditState = EnhancedGameEditState.ITEM_SYNONYMS_SPECIFIED;
                  }
                  else {
                     output = "That's not a valid item ID. Try again.";
                  }
                  break;
               case ITEM_SYNONYMS_SPECIFIED:
                  if (cmd.equals("")) {
                     output = "Invalid synonyms comma-separated list. Try again";
                  }
                  else {
                     List<String> splitList = splitByCommaAndTrim(cmd);
                     this.synonymItem.getSynonyms().addAll(splitList);
                     output = "Added synonyms " + String.join("|", splitList) + " to the item " + this.synonymItem.getName();
                     enhancedGameEditState = EnhancedGameEditState.OPEN;
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
                     enhancedGameEditState = EnhancedGameEditState.ACTION_TRIGGER;
                  }
                  break;
               case ACTION_TRIGGER:
                  actionFormats = gameEngine.findAction(cmd);
                  if (actionFormats.size() > 1) {
                     output = "There are multiple actions with that trigger word but different " +
                         "sentence structures. Enter the index of the one you meant.";
                     output += "\n";
                     StringBuilder outBuilder = new StringBuilder(output);
                     for (int i = 0; i < actionFormats.size(); i++) {
                        outBuilder.append(String.format("(%d) %s \n", i, actionFormats.get(i).getRegExpr()));
                     }
                     output = outBuilder.toString();
                     enhancedGameEditState = EnhancedGameEditState.ACTION_TRIGGER_CLARIFY;
                  }
                  else if (actionFormats.size() == 1) {
                     ActionFormat actionFormat = actionFormats.get(0);
                     instantiatedGameAction = new InstantiatedGameAction(actionFormat);
                     output = "Enter the item IDs that this action should act upon as a " +
                         "comma-separated list e.g. \"apple,banana,pear\". To list them write \"list items\"";
                     actionFormats = null;
                     enhancedGameEditState = EnhancedGameEditState.ACTION_ARGS;
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
                        enhancedGameEditState = EnhancedGameEditState.ACTION_ARGS;
                     }
                  }
                  catch (NumberFormatException e) {
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
                  }
                  else {
                     boolean validItems = roomForAction.isValidItemIdentifierList(splitArgs);
                     if (validItems) {
                        Map<String, Item> roomItems = roomForAction.getItems();
                        instantiatedGameAction.setArguments(splitArgs.stream().map(roomItems::get).collect(Collectors.toList()));
                        output = "Enter the preconditions on the knowledge base (and failure explanations) for this action as a comma-separated list of conditions of the form " +
                            "e.g. \"world::numDoors = 4|The number of doors isn't 4, it's world::numDoors\".";
                        enhancedGameEditState = EnhancedGameEditState.ACTION_PRE;
                     }
                     else {
                        output = "One or more of those items is not in the room. Try again.";
                     }
                  }
                  break;
               case ACTION_PRE:
                  try {
                     effectAction = new EnhancedGameDesignAction();
                     List<Condition> preConds;
                     if (cmd.equals("")) {
                        preConds = new ArrayList<>();
                        effectAction.setPreconditions(preConds);
                        output = "Enter the updates to the knowledgebase as comma-separated KnowledgeUpdate strings" +
                            "e.g. \"world::numDoors += 1, box::contains = [\"apple\"]\".";
                        enhancedGameEditState = EnhancedGameEditState.ACTION_POST;
                     }
                     else {
                        List<String> splitPreconds = splitByCommaAndTrim(cmd);
                        preConds = splitPreconds.stream().map(this::stringToCondition).collect(Collectors.toList());
                        int indexNull = preConds.indexOf(null);
                        if (indexNull != -1) {
                           output = String.format("Invalid condition \"%s\". Remember the pipe symbol and error message.", splitPreconds.get(indexNull));
                        }
                        else {
                           effectAction.setPreconditions(preConds);
                           output = "Enter the updates to the knowledgebase as comma-separated KnowledgeUpdate strings" +
                               "e.g. \"world::numDoors += 1, box::contains = [\"apple\"]\".";
                           enhancedGameEditState = EnhancedGameEditState.ACTION_POST;
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
                     // TODO: accept empty string
                     List<String> splitPostconds = splitByCommaAndTrim(cmd);
                     List<KnowledgeUpdate> postConds = splitPostconds.stream().map(this::stringToKnowledgeUpdate).collect(Collectors.toList());
                     int indexNull = postConds.indexOf(null);
                     if (indexNull != -1) {
                        output = String.format("Invalid KnowledgeUpdate string \"%s\"", splitPostconds.get(indexNull));
                     }
                     else {
                        effectAction.setUpdateState(postConds);
                        output = "Enter the message to display to the user after taking this action.";
                        enhancedGameEditState = EnhancedGameEditState.ACTION_MSG;
                     }
                  }
                  catch (IndexOutOfBoundsException e) {
                     output = "Malformed string. Remember to separate each KnowledgeUpdate" +
                         " by a \",\"";
                  }
                  break;
               case ACTION_MSG:
                  effectAction.setMessage(cmd);
                  gameEngine.addAction(roomForAction, instantiatedGameAction, effectAction);
                  resetAdditions();
                  output = "Great. Adding your new action to the game";
                  enhancedGameEditState = EnhancedGameEditState.OPEN;
                  break;
               case EDIT_KNOWLEDGE:
                  if (cmd.equals("fillers")) {
                     output = "Update the fillers of the current SpecificFrames " + knowledgeBase.getSpecificFrames().values().toString() +
                         " with a comma-separated list of Knowledge Update strings in the form \"frame::slot OP VAL\"";
                     enhancedGameEditState = EnhancedGameEditState.FILLERS;
                  }
                  else if (cmd.equals("parents")) {
                     specificFrames = new ArrayList<>(knowledgeBase.getSpecificFrames().values());
                     StringBuilder outputBuilder = new StringBuilder();
                     for (int i = 0; i < specificFrames.size(); i++) {
                        outputBuilder.append(String.format("(%d) %s \n", i, specificFrames.get(i).getId()));
                     }
                     output = outputBuilder.toString();
                     output += "are the current Specific Frames. Enter the name of the one you wish to add a parent to";
                     enhancedGameEditState = EnhancedGameEditState.PARENTS_CHILD;
                  }
                  else {
                     output = "Invalid choice. Enter \"parents\" or \"fillers\"";
                  }
                  break;
               case FILLERS:
                  List<String> knowledgeUpdates = splitByCommaAndTrim(cmd);
                  StringBuilder outputBuilder = new StringBuilder();
                  for (String s : knowledgeUpdates) {
                     try {
                        KnowledgeUpdate knowledgeUpdate = new KnowledgeUpdate(s);
                        gameEngine.updateKnowledgeBaseMultiple(knowledgeUpdate);
                     }
                     catch (KnowledgeException e) {
                        outputBuilder.append(String.format("Didn't complete update \"%s\" because it has an invalid form %s.\n", s, e.getMessage()));
                     }
                  }
                  output = outputBuilder.toString();
                  output += "Type \"edit knowledge\" again if you want to continue updating or use other commands to continue building the game";
                  enhancedGameEditState = EnhancedGameEditState.OPEN;
                  break;
               case PARENTS_CHILD:
                  child = findSpecificFrameByName(specificFrames, cmd);
                  if (child == null) {
                     output = "That is not a valid name. Enter the id of one of the items you have created that were listed above.";
                  }
                  else {
                     StringBuilder outBuilder = new StringBuilder();
                     genericFrames = new ArrayList<>(knowledgeBase.getGenericFrames().values());
                     for (int i = 0; i < genericFrames.size(); i++) {
                        outBuilder.append(String.format("(%d) %s \n", i, genericFrames.get(i).getId()));
                     }
                     output = outBuilder.toString();
                     output += "are your current generic frames. Enter \"new\" " +
                         "if you wish to create a new parent or the name of a current Generic Frame if you wish to add one as the parent of " + child.getId();
                     enhancedGameEditState = EnhancedGameEditState.PARENTS_PARENT;
                  }
                  break;
               case PARENTS_PARENT:
                  if (cmd.equals("new")) {
                     output = "Time to create a new Generic Frame. Type the id/name of the Generic Frame first. Remember, this needs to be unique.";
                     enhancedGameEditState = EnhancedGameEditState.PARENTS_NEW_NAME;
                  }
                  else {
                     parent = findGenericFrameByName(genericFrames, cmd);
                     if (parent == null) {
                        output = "That is not a valid name. Enter the id of one of the Generic Frames you have created that were listed above or \"new\".";
                     }
                     else {
                        child.addParent(parent);
                        output = String.format("Added Generic Frame %s as a parent of %s", parent.getId(), child.getId());
                        resetAdditions();
                        enhancedGameEditState = EnhancedGameEditState.OPEN;
                     }
                  }
                  break;
               case PARENTS_NEW_NAME:
                  if (knowledgeBase.getGenericFrames().getOrDefault(cmd, null) != null) {
                     output = "That Generic Frame name already exists. Try again.";
                  }
                  else {
                     parent = new GenericFrame(cmd);
                     enhancedGameEditState = EnhancedGameEditState.PARENTS_NEW_SLOTS;
                  }
                  break;
               case PARENTS_NEW_SLOTS:
                  try {
                     Map<String, String> slotMap = stringToMap(cmd);
                     TypeConvertVisitor typeConvertVisitor = new TypeConvertVisitor();
                     for (Map.Entry<String, String> entry : slotMap.entrySet()) {
                        String slot = entry.getKey();
                        String filler = entry.getValue();
                        Object objFiller = VisitorHelper.typeConvert(typeConvertVisitor, filler);
                        parent.addSlot(slot, objFiller);
                     }
                     knowledgeBase.addGenericFrame(parent);
                     child.addParent(parent);
                     output = String.format("Added the new Generic Frame %s as a parent of %s", parent.getId(), child.getId());
                     resetAdditions();
                     enhancedGameEditState = EnhancedGameEditState.OPEN;
                  }
                  catch (IndexOutOfBoundsException e) {
                     output = "Malformed string. Remember to separate each slot and filler pair" +
                         " by a \",\" and the slot and the filler by a \"=\" with no excess spaces";
                  }
                  catch (ParseCancellationException e) {
                     output = "Malformed filler value for string " + e.getMessage()
                         + ". Fillers can only be strings, numbers and lists of strings or numbers";
                  }
                  break;
               default:
                  output = "Invalid game-developing state. Consult the game developer.";
                  break;
            }
      }

      return List.of(cmd, sofar, output);

   }

   private GenericFrame findGenericFrameByName(@NotNull List<GenericFrame> frames, String name) {
      return frames.stream().filter(f -> f.getId().equals(name)).findAny().orElse(null);
   }

   private SpecificFrame findSpecificFrameByName(@NotNull List<SpecificFrame> frames, String name) {
      return frames.stream().filter(f -> f.getId().equals(name)).findAny().orElse(null);
   }

   private void center() {
      Toolkit tk = Toolkit.getDefaultToolkit();
      Dimension screen = tk.getScreenSize();
      Dimension d = getSize();
      setLocation((screen.width - d.width) / 2, (screen.height - d.height) / 2);
   }

   public static void main(final String[] args) {
      Runnable runner = EnhancedGameEditor::new;
      EventQueue.invokeLater(runner);
   }
}
