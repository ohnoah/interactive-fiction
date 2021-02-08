package com.intfic.nlp;

import com.intfic.game.basic.BasicGameEngine;
import com.intfic.game.shared.ActionFormat;
import com.intfic.game.shared.InstantiatedGameAction;
import com.intfic.game.shared.Item;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.CoreSentence;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.trees.Constituent;
import edu.stanford.nlp.trees.LabeledScoredConstituentFactory;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.trees.TreeCoreAnnotations;
import edu.stanford.nlp.util.Pair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.jetbrains.annotations.NotNull;

public class EnhancedNLPEngine {

   private static StanfordCoreNLP pipeline;


   private static List<Pair<Integer, Integer>> vpIndices(Tree tree) {
      Set<Constituent> treeConstituents = tree.constituents(new LabeledScoredConstituentFactory());
      List<Pair<Integer, Integer>> vps = new ArrayList<>();
      List<Constituent> vpsConstituent = new ArrayList<>();
      outer:
      for (Constituent constituent : treeConstituents) {
         if (constituent.label() != null &&
             (constituent.label().toString().equals("VP"))) {
            for (int j = 0; j < vpsConstituent.size(); j++) {
               Constituent c = vpsConstituent.get(j);
               if (c != null && c.contains(constituent)) {
                  vpsConstituent.set(j, null);
                  vps.set(j, null);
               }
               else if (c != null && constituent.contains(c)) {
                  continue outer;
               }
            }
            //System.err.println("found constituent: " + constituent.toString());
            vps.add(new Pair<>(constituent.start(), constituent.end()));
            vpsConstituent.add(constituent);
            //System.err.println(tree.getLeaves().subList(constituent.start(), constituent.end() + 1));
         }
      }
      vps = vps.stream().filter(x -> !Objects.isNull(x)).collect(Collectors.toList());
      return vps;
   }

   public static List<InstantiatedGameAction> parseMultiple(@NotNull String rawCommand, @NotNull List<ActionFormat> possibleActionFormats, Set<Item> possibleItems) throws FailedParseException {
      return null;
   }

   public static List<InstantiatedGameAction> parse(@NotNull String rawCommand, @NotNull List<ActionFormat> possibleActionFormats, Set<Item> possibleItems) throws FailedParseException {
/*
      // Get current size of heap in bytes
      long heapSize = Runtime.getRuntime().totalMemory();
      System.out.println(heapSize);

      // Get maximum size of heap in bytes. The heap cannot grow beyond this size.// Any attempt will result in an OutOfMemoryException.
      long heapMaxSize = Runtime.getRuntime().maxMemory();
      System.out.println(heapMaxSize);
*/

/*      Properties props = new Properties();
      props.setProperty("annotators", "tokenize,ssplit,pos,lemma,ner,parse");
      // use faster shift reduce parser
      //props.setProperty("parse.model", "edu/stanford/nlp/models/srparser/englishSR.ser.gz");
      props.setProperty("parse.maxlen", "100");
      // set up Stanford CoreNLP pipeline
      StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
      // build annotation for a review
      Annotation annotation =
          new Annotation("turn on the television");
      // annotate
      pipeline.annotate(annotation);
      // get tree
      Tree tree =
          annotation.get(CoreAnnotations.SentencesAnnotation.class).get(0).get(TreeCoreAnnotations.TreeAnnotation.class);


      System.out.println(tree);
      Set<Constituent> treeConstituents = tree.constituents(new LabeledScoredConstituentFactory());
      for (Constituent constituent : treeConstituents) {
         if (constituent.label() != null &&
             (constituent.label().toString().equals("VP") || constituent.label().toString().equals("NP"))) {
            System.err.println("found constituent: "+constituent.toString());
            System.err.println(tree.getLeaves().subList(constituent.start(), constituent.end()+1));
         }*/
      /*      }*/

      CoreDocument document = generateCoreDocumentFromString(rawCommand); //lemma stuff

      Tree tree =
          document.annotation().get(CoreAnnotations.SentencesAnnotation.class).get(0).get(TreeCoreAnnotations.TreeAnnotation.class);
      System.out.println(tree);
      List<Pair<Integer, Integer>> vps = vpIndices(tree);
      System.out.println(vps);

      // TODO: Check that no negations occur between vpIndices

      List<InstantiatedGameAction> commands = new ArrayList<>();
      for (Pair<Integer, Integer> vpStartEnd : vps) {
         // display tokens
         int start = vpStartEnd.first;
         int end = vpStartEnd.second;
         // TODO: Restructure these to use CoreDocument but indices of interest
         String verb = findVerb(document, start, end);
         ActionFormat actionFormat = findMatchingGameVerb(verb, possibleActionFormats);

         List<String> nouns = new ArrayList<>();
         List<Set<String>> adjectives = new ArrayList<>();
         findNounsAndAdjectives(document, start, end, actionFormat, nouns, adjectives);

         //TODO: do the wordnet stuff here for nouns
         List<String> gameItemNames = findMatchingGameItemNames(nouns, adjectives, possibleItems);


         InstantiatedGameAction command = new InstantiatedGameAction(actionFormat, gameItemNames);
         commands.add(command);
      }
      for (CoreLabel tok : document.tokens()) {
         System.out.println(String.format("%s\t%s", tok.word(), tok.tag()));
      }
      System.out.println(document.corefChains());
      // Use that to look for a VB and a NN and populate a Command
      // just look for the possible commands using WordNet otherwise return Error
      // enhanced engine can be more informative if a supplementary word happens
      // FAIL flag if command is fake
      return commands;
   }

   //TODO: with wordnet synonyms
   // TODO: Throw FailedParseException if item not in this room is given
   // Returns a list of synonym-replaced String item names for "nouns" corresponding in-game items
   // If fails, throw a com.interactivefiction.nlp.FailedParseException. This can be either because adjectives don't match
   // or because there are no in-game items with that name.
   // TODO: To support multiple same-name items, need to change this to longest match and potentially return errors
   public static List<String> findMatchingGameItemNames(List<String> nouns, List<Set<String>> adjectives,
                                                        Set<Item> possibleItems) throws FailedParseException {
      List<String> matchingGameItemNames = new ArrayList<>();
      nounLoop:
      for (int i = 0; i < nouns.size(); i++) {
         String noun = nouns.get(i);
         for (Item item : possibleItems) {
            String itemName = item.getName();
            if (itemName.equals(noun)) {
               if (adjectivesMatch(adjectives.get(i), item.getAdjectives())) {
                  matchingGameItemNames.add(itemName);
                  continue nounLoop;
               }
               else {
                  String missingItems = adjectives.get(i).stream()
                      .filter(s -> !item.getAdjectives().contains(s)).sorted().collect(Collectors.joining(","));
                  throw new FailedParseException(String.format("There is no %s %s in your environment.", missingItems, noun));
               }
            }
         }
         for (Item item : possibleItems) {
            if (item.getSynonyms().contains(noun)) {
               if (adjectivesMatch(adjectives.get(i), item.getAdjectives())) {
                  matchingGameItemNames.add(item.getName());
                  continue nounLoop;
               }
               else {
                  String missingItems = adjectives.get(i).stream()
                      .filter(s -> !item.getAdjectives().contains(s)).sorted().collect(Collectors.joining(","));
                  throw new FailedParseException(String.format("There is no %s %s in your environment.", missingItems, noun));
               }
            }
         }
         throw new FailedParseException(String.format("There is no %s in your environment.", noun));
      }
      return matchingGameItemNames;
   }

   private static boolean adjectivesMatch(Set<String> userAdjectives, Set<String> itemAdjectives) {
      return itemAdjectives.containsAll(userAdjectives);
   }

   // TODO: Rule out put the box in the box
   public static void findNounsAndAdjectives(CoreDocument document, int start, int end, ActionFormat actionToTake, List<String> nouns, List<Set<String>> adjectives) throws FailedParseException {
      // TODO: Both cases should match against possibleActionNames with Wordnet
      // Word net in here
      // Either do a regex match for PUT IN
      if (actionToTake.isTernary()) {
         Pattern p = Pattern.compile(actionToTake.getRegExpr());
         List<String> matchedStrings = document.tokens().subList(start, end + 1).stream().map(CoreLabel::value).collect(Collectors.toList());

         Matcher m = p.matcher(String.join(" ", matchedStrings));
         boolean doesMatch = m.matches();
         if (doesMatch) {
            for (int i = 1; i <= m.groupCount(); i++) {
               String matchingGroup = m.group(i);
               appendMatchingGroupNoun(nouns, adjectives, document, matchingGroup, actionToTake, start, end, m.start(i), m.end(i));
            }
         }
         else {
            throw new FailedParseException(String.format("Argument structure after the %s was wrong.", actionToTake.getVerb()));
         }
      }
      // Or just find the noun
      else {
         String noun;
         Set<String> currentAdjectives = new HashSet<>();
         List<CoreLabel> tokens = document.tokens();
         for (int i = start; i <= end; i++) {
            CoreLabel tok = tokens.get(i);
            String tag = tok.tag();
            System.err.println(tag);
            if (tag.equals("JJ") || tag.equals("JJR") || tag.equals("JJS")) {
               currentAdjectives.add(tok.word());
            }
            if (isNoun(tag)) {
               adjectives.add(currentAdjectives);
               noun = tok.word();
               nouns.add(noun);
               break;
            }
         }
         if (nouns.size() == 0) {
            throw new FailedParseException("No noun specified");
         }
      }
   }

   private static String removeNumberTag(String s) {
      int i = s.indexOf("-");
      if (i == -1) {
         return s;
      }
      else {
         return s.substring(0, i);
      }
   }

   private static boolean isNoun(String tag) {
      return tag.equals("NN") || tag.equals("NNS") || tag.equals("NNP") || tag.equals("NNPS");
   }

   // TODO: How does this work if there is a "-" in the sentence
   private static void appendMatchingGroupNoun(List<String> nouns, List<Set<String>> adjectives,
                                               CoreDocument document, String matchingGroup,
                                               ActionFormat actionToTake, int tokenStart, int tokenEnd, int start, int end) throws FailedParseException {
      /*      CoreDocument matchingDoc = generateCoreDocumentFromString(matchingGroup);*/
      /*      CoreDocument matchingDoc = generateCoreDocumentFromString(matchingGroup);*/
/*      int index = Collections.indexOfSubList(document.tokens().stream().map(x -> removeNumberTag(x.toString())).collect(Collectors.toList()),
          matchingDoc.tokens().stream().map(x -> removeNumberTag(x.toString())).collect(Collectors.toList()));*/

      int firstTokenIndex = -1;
      int offset = document.tokens().get(tokenStart).beginPosition();
      for (int i = tokenStart; i <= tokenEnd; i++) {
         CoreLabel tok = document.tokens().get(i);
         if (tok.beginPosition() - offset == start) {
            firstTokenIndex = i;
         }
      }

      if (firstTokenIndex == -1) {
         System.err.println(document.tokens());
         System.err.println(matchingGroup);
         throw new FailedParseException("Incorrect usage of the verb: " + actionToTake.getVerb());
      }

      String noun;
      Set<String> currentAdjectives = new HashSet<>();
      int tokenIndex = firstTokenIndex;
      CoreLabel tok = document.tokens().get(tokenIndex);
      while (tok.endPosition() - offset <= end) {
         tok = document.tokens().get(tokenIndex);
         String tag = tok.tag();
         if (tag.equals("JJ") || tag.equals("JJR") || tag.equals("JJS")) {
            currentAdjectives.add(tok.word());
         }
         if (isNoun(tag)) {
            adjectives.add(currentAdjectives);
            noun = tok.word();
            nouns.add(noun);
            return;
         }
         tokenIndex++;
      }

      throw new FailedParseException(String.format("Couldn't find any item in words: %s", matchingGroup));
   }

   // This fails for e.g. TURN it ON, TURN the box
   private static ActionFormat findMatchingGameVerb(String verb, List<ActionFormat> possibleActionFormats) throws FailedParseException {
      // TODO: ADD Word net in here
      for (ActionFormat af : possibleActionFormats) {
         if (af.getVerb().equals(verb)) {
            return af;
         }
      }
      throw new FailedParseException(String.format("No action corresponds to the verb: %s", verb));
   }

   // TODO: Think about ignoring everyhing after found
   public static String findVerb(CoreDocument document, int start, int end) throws FailedParseException {
      String verb;
      for (int i = start; i <= end; i++) {
         CoreLabel tok = document.tokens().get(i);
         String tag = tok.tag();
         if (tag.equals("VB") || tag.equals("VBN") || tag.equals("VBG") || tag.equals("VBP") || tag.equals("VBZ")) {
            verb = tok.word();
            if (i != document.tokens().size() - 1) {
               CoreLabel nextToken = document.tokens().get(i + 1);
               if (nextToken.tag().equals("RP")) {
                  verb += String.format(" %s", nextToken.word());
               }
            }
            return verb;
         }
      }
      throw new FailedParseException("Can't find a command verb in the input.");
   }

   public static void main(String[] args) {
/*      // set up pipeline properties
      Properties props = new Properties();
      props.setProperty("annotators", "tokenize,ssplit,pos,lemma,ner,parse");
      // use faster shift reduce parser
      //props.setProperty("parse.model", "edu/stanford/nlp/models/srparser/englishSR.ser.gz");
      props.setProperty("parse.maxlen", "100");
      // set up Stanford CoreNLP pipeline
      StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
      // build annotation for a review
      Annotation annotation =
          new Annotation("examine larger red key");
      // annotate
      pipeline.annotate(annotation);
      // get tree
      Tree tree =
          annotation.get(CoreAnnotations.SentencesAnnotation.class).get(0).get(TreeCoreAnnotations.TreeAnnotation.class);
      //annotation.get(2)
      List<Tree> rootChildren = tree.getChild(0).getChildrenAsList();
      if (rootChildren.size() == 1 && rootChildren.get(0).label().toString().equals("VP")) {
         List<Tree> childrenVP = rootChildren.get(0).getChildrenAsList();
         System.out.println(rootChildren.get(0).toString());
         for (Tree node : childrenVP) {
            System.out.println(node.label());
            if (node.label().toString().equals("VP")) {
               System.out.println("HELLO");
            }
            else {
               System.out.println("FAIL");
            }
         }
      }
      else {
         System.err.println("not 1 length");
      }


      System.out.println(tree);
      Set<Constituent> treeConstituents = tree.constituents(new LabeledScoredConstituentFactory());
      for (Constituent constituent : treeConstituents) {
         if (constituent.label() != null) {
            //(constituent.label().toString().equals("VP") || constituent.label().toString().equals("NP"))) {
            System.err.println("found constituent: " + constituent.toString());
            System.err.println(tree.getLeaves().subList(constituent.start(), constituent.end() + 1));
         }
      }
      */
      try {
         InstantiatedGameAction command = EnhancedNLPEngine
             .parse("put the key in the box",
                 new BasicGameEngine().getPossibleActionFormats(), Set.of(new Item("key"), new Item("box"))).get(0);
         InstantiatedGameAction command2 = EnhancedNLPEngine
             .parse("put the box in the key",
                 new BasicGameEngine().getPossibleActionFormats(), Set.of(new Item("key"), new Item("box"))).get(0);
         InstantiatedGameAction command3 = EnhancedNLPEngine
             .parse("put the donkey in the box and drink it from the box. eat box.",
                 new BasicGameEngine().getPossibleActionFormats(), Set.of(new Item("key"), new Item("donkey"), new Item("box"))).get(0);
      }
      catch (FailedParseException e) {
         e.printStackTrace();
      }
   }

   static {
      Properties props = new Properties();
      props.setProperty("annotators", "tokenize,ssplit,pos,lemma,ner,parse,depparse,coref");
      pipeline = new StanfordCoreNLP(props);
/*      Properties propsTokenizer = new Properties();
      props.setProperty("annotators", "tokenize");
      this.pipelineTokenizer = new StanfordCoreNLP(propsTokenizer);*/
   }


   public static CoreDocument generateCoreDocumentFromString(String rawCommand) {
      // build pipeline
      // create a document object
      CoreDocument document = pipeline.processToCoreDocument(rawCommand);
      return document;
   }
}
