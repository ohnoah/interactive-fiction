package com.intfic.nlp;

import com.intfic.game.shared.ActionFormat;
import com.intfic.game.shared.InstantiatedGameAction;
import com.intfic.game.shared.Item;
import com.intfic.game.shared.Util;
import edu.stanford.nlp.util.Pair;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import net.sf.extjwnl.JWNLException;
import net.sf.extjwnl.dictionary.Dictionary;
import net.sf.extjwnl.data.IndexWord;
import net.sf.extjwnl.data.POS;


public class BasicNLPEngine {

   public static List<InstantiatedGameAction> parse(String rawCommand, List<ActionFormat> possibleActionFormats, Set<Item> possibleItems, Pair<Set<String>, String> it) throws FailedParseException {
      return BasicNLPEngine.parse(rawCommand, possibleActionFormats, possibleItems);
   }

   public static List<InstantiatedGameAction> parse(String rawCommand, List<ActionFormat> possibleActionFormats, Set<Item> possibleItems) throws FailedParseException {
      // TODO: Fail if more than one sentence or there is an and in the sentence

      // display tokens
      String verb = null;
      try {
         verb = findVerb(rawCommand);
      }
      catch (JWNLException e) {
         e.printStackTrace();
      }
      ActionFormat actionFormat = findMatchingGameVerb(verb, possibleActionFormats);

      List<String> nouns = new ArrayList<>();
      List<Set<String>> adjectives = new ArrayList<>();
      try {
         findNounsAndAdjectives(rawCommand, actionFormat, nouns, adjectives, possibleItems.stream().map(Item::getName).collect(Collectors.toSet()));
      }
      catch (JWNLException e) {
         throw new FailedParseException("Dictionary error on the back end. Try again.");
      }
      List<Item> gameItemNames = BasicNLPEngine.findMatchingGameItems(nouns, adjectives, possibleItems);

      InstantiatedGameAction command = new InstantiatedGameAction(actionFormat, gameItemNames); // Changed from nouns to gameItemNames
      // Use that to look for a VB and a NN and populate a Command
      // just look for the possible commands using WordNet otherwise return Error
      // enhanced engine can be more informative if a supplementary word happens
      // FAIL flag if command is fake


      return Collections.singletonList(command);
   }


   private static String appendFirstNounAndAdjectives(Set<String> adjectives, String stringToSearch,
                                                      ActionFormat actionToTake, Set<String> possibleItemNames) throws JWNLException, FailedParseException {
      Dictionary d = null;
      d = Dictionary.getDefaultResourceInstance();
      String[] splitWords = Arrays.stream(stringToSearch.split(" ")).map(s -> s.replaceAll("[.,!]", "")).toArray(String[]::new);
      IndexWord iwNoun = null;
      String noun;
      if (splitWords.length > 0) {
         noun = splitWords[splitWords.length - 1];
         iwNoun = d.lookupIndexWord(POS.NOUN, noun);
         if (iwNoun == null) {
            throw new FailedParseException("Expected last word to be a noun but was: " + noun);
         }
      }
      else {
         throw new FailedParseException("Empty string encountered when looking for noun and adjectives");
      }
      for (int i = splitWords.length - 2; i >= 0; i--) {
         String word = splitWords[i];
         if (word.equals(actionToTake.getVerb())) { // to block e.g. "open" to be classified as a noun
            return noun;
         }
/*         IndexWord iwNoun = null;
         iwNoun = d.lookupIndexWord(POS.NOUN, word);
         if (iwNoun != null) {
*//*            String lemma = iwNoun.getLemma();
            nouns.add(lemma.trim());*//*
            nouns.add(word.trim());
            adjectives.add(currentAdjectives);
            break;
         }*/
         // not a noun
         IndexWord iwAdj = null;
         iwAdj = d.lookupIndexWord(POS.ADJECTIVE, word);
         if (iwAdj != null) {
            adjectives.add(word.trim());
         }
      }
      return noun;
   }

   public static void findNounsAndAdjectives(String rawCommand, ActionFormat actionToTake,
                                             List<String> nouns, List<Set<String>> adjectives, Set<String> possibleItemNames) throws JWNLException, FailedParseException {
      // Either do a regex match for PUT IN
      if (actionToTake.isTernary()) {
         Pattern p = Pattern.compile(actionToTake.getRegExpr());
         Matcher m = p.matcher(rawCommand);
         boolean doesMatch = m.matches();
         if (doesMatch) {
            for (int i = 1; i <= m.groupCount(); i++) {
               String matchingGroup = m.group(i);
               Set<String> currentAdjectives = new HashSet<>();
               String noun = appendFirstNounAndAdjectives(currentAdjectives, matchingGroup, actionToTake, possibleItemNames);
               nouns.add(noun);
               adjectives.add(currentAdjectives);
            }
         }
         else {
            throw new FailedParseException("Argument structure after the verb was wrong.");
         }
      }
      // Or just find the noun if its a unary
      else {
         Set<String> currentAdjectives = new HashSet<>();
         String noun = appendFirstNounAndAdjectives(currentAdjectives, rawCommand, actionToTake);
         nouns.add(noun);
         adjectives.add(currentAdjectives);
         if (nouns.size() != 1) { // no nullary operator allowed
            throw new FailedParseException("Expected 1 noun as argument but got " + nouns.size() + ".");
         }
      }
   }

   // This fails for e.g. TURN it ON, TURN the box
   public static ActionFormat findMatchingGameVerb(String verb, List<ActionFormat> possibleActionFormats) throws FailedParseException {
      // Word net in here
      for (ActionFormat af : possibleActionFormats) {
         if (af.getVerb().equals(verb)) {
            return af;
         }
      }
      throw new FailedParseException("No action corresponds to the verb: " + verb);
   }

   public static String findVerb(String rawCommand) throws JWNLException, FailedParseException {
      Dictionary d = null;
      d = Dictionary.getDefaultResourceInstance();
      String[] splitWords = rawCommand.split(" ");
      for (String word : splitWords) {
         IndexWord iw = null;
         iw = d.lookupIndexWord(POS.VERB, word);
         if (iw == null) { // not a verb
            continue;
         }
         else {
            return iw.getLemma().trim();
         }
      }
      throw new FailedParseException("No verb supplied");
   }

   public static void main(String[] args) {
/*
      System.out.println("HELLO");
      try {
         Dictionary d = Dictionary.getDefaultResourceInstance();
*/
/*         IndexWord iw = d.lookupIndexWord(POS.VERB, "LISTEN TO");
         System.out.println(iw.getKey());
         System.out.println(iw.getLemma());*//*

      }
      catch (JWNLException e) {
         System.out.println("SDSD");
         e.printStackTrace();
      }
      Pattern p = Pattern.compile("PUT ([\\w\\s]+) IN ([\\w\\s]+)$");
      Matcher m = p.matcher("PUT the balloon IN the narnia");
      boolean doesMatch = m.matches();
      System.out.println(m.group(1));
      System.out.println(m.group(2));
*/



/*      com.interactivefiction.BasicNLPEngine basicNLPEngine = new com.interactivefiction.BasicNLPEngine();
      com.interactivefiction.game.shared.InstantiatedGameAction command = basicNLPEngine.parse("put it in the box",null);*/
   }

   public static List<Item> findMatchingGameItems(List<String> nouns, List<Set<String>> adjectives, Set<Item> gameItems) throws FailedParseException {
      return NLPEngine.findMatchingGameItems(nouns, adjectives, gameItems);
   }
}
