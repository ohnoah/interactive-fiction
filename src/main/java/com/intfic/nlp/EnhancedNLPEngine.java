package com.intfic.nlp;

import com.intfic.game.basic.BasicGameEngine;
import com.intfic.game.shared.ActionFormat;
import com.intfic.game.shared.InstantiatedGameAction;
import com.intfic.game.shared.Item;
import edu.stanford.nlp.coref.CorefCoreAnnotations;
import edu.stanford.nlp.coref.data.CorefChain;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.trees.Constituent;
import edu.stanford.nlp.trees.LabeledScoredConstituentFactory;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.trees.TreeCoreAnnotations;
import edu.stanford.nlp.util.Pair;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.jetbrains.annotations.NotNull;

public class EnhancedNLPEngine {

   private static StanfordCoreNLP pipeline;


   private static void npVpIndices(Tree tree, List<Pair<Integer, Integer>> vps, List<Pair<Integer, Integer>> nps) {
      Set<Constituent> treeConstituents = tree.constituents(new LabeledScoredConstituentFactory());
      List<Constituent> vpsConstituent = new ArrayList<>();
      List<Constituent> npsConstituent = new ArrayList<>();
      outer:
      for (Constituent constituent : treeConstituents) {
         if (constituent.label() != null &&
             (constituent.label().toString().equals("VP") || (constituent.label().toString().equals("NP")))) {
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
            if (constituent.label().toString().equals("VP")) {
               vps.add(new Pair<>(constituent.start(), constituent.end()));
               vpsConstituent.add(constituent);
            }
            else if (constituent.label().toString().equals("NP")) {
               nps.add(new Pair<>(constituent.start(), constituent.end()));
               npsConstituent.add(constituent);
            }
            //System.err.println(tree.getLeaves().subList(constituent.start(), constituent.end() + 1));
         }
      }
      boolean status = true;
      while (status) {
         status = vps.remove(null);
      }
      status = true;
      while (status) {
         status = nps.remove(null);
      }
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
      List<Pair<Integer, Integer>> vps = new ArrayList<>();
      List<Pair<Integer, Integer>> nps = new ArrayList<>();
      npVpIndices(tree, vps, nps);
      Comparator<Pair<Integer, Integer>> pairComparator = (o1, o2) -> {
         if (o1 == null && o2 == null) {
            return 0;
         }
         else if (o1 == null && o2 != null) {
            return -1;
         }
         else if (o1 != null && o2 == null) {
            return 1;
         }
         if (o1.first.compareTo(o2.first) > 0) {
            return 1;
         }
         else if (o1.first.compareTo(o2.first) < 0) {
            return -1;
         }
         else {
            return o1.second.compareTo(o2.second);
         }
      };
      vps.sort(pairComparator);
      nps.sort(pairComparator);
      // TODO: NP indices
      System.out.println(vps);
      System.out.println(nps);

      // TODO: Check that no negations occur between vpIndices or that a separatae sentence

      Map<Integer, CorefChain> corefChainMap = document.corefChains();
      Map<Pair<Integer, Integer>, Pair<Integer, Integer>> representativeCorefCluster = new HashMap<>();
      for (Map.Entry<Integer, CorefChain> entry : corefChainMap.entrySet()) {
         CorefChain c = entry.getValue();
         List<CorefChain.CorefMention> corefMentions = c.getMentionsInTextualOrder();
         Pair<Integer, Integer> representing = new Pair<>(corefMentions.get(0).startIndex, corefMentions.get(0).endIndex);
         for (CorefChain.CorefMention mention : c.getMentionsInTextualOrder()) {
            Pair<Integer, Integer> mentionIndices = new Pair<>(mention.startIndex, mention.endIndex);
            if (!representing.equals(mentionIndices)) {
               representativeCorefCluster.put(mentionIndices, representing);
               break;
            }
         }
      }


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
/*         if(equalNouns.containsKey(vpStartEnd)){
            nouns = equalNouns.get(vpStartEnd);
            adjectives = equalAdjectives.get(vpStartEnd);
         }*/
         findNounsAndAdjectives(document, start, end, nps, actionFormat, nouns, adjectives, representativeCorefCluster);

         //TODO: do the wordnet stuff here for nouns
         List<String> gameItemNames = findMatchingGameItemNames(nouns, adjectives, possibleItems);


         InstantiatedGameAction command = new InstantiatedGameAction(actionFormat, gameItemNames);
         commands.add(command);
      }
      for (CoreLabel tok : document.tokens()) {
         String tagCoref = tagWithCoref(tok);
         System.out.println(String.format("%s\t%s(%s)", tok.word(), tok.tag(), tagCoref.equals(tok.tag()) ? "-" : tagCoref));
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

   private static boolean isAdjective(String tag) {
      return tag.equals("JJ") || tag.equals("JJR") || tag.equals("JJS");
   }

   private static String nounsAndAdjectivesInNP(CoreDocument document, Pair<Integer, Integer> np,
                                                Set<String> adjectives, Map<Pair<Integer, Integer>, Pair<Set<String>, String>> corefCache,
                                                Map<Pair<Integer, Integer>, Pair<Integer, Integer>> corefRepresentative) throws FailedParseException {


      if (corefRepresentative.containsKey(np)) {
         Pair<Integer, Integer> representativeNp = corefRepresentative.get(np);
         Pair<Set<String>, String> adjAndNouns = corefCache.get(representativeNp);
         adjectives.addAll(adjAndNouns.first);
         return adjAndNouns.second;
      }
      List<CoreLabel> tokens = document.tokens();
      for (int i = np.first; i <= np.second; i++) {
         CoreLabel tok = tokens.get(i);
         String tag = tok.tag();
         System.out.println(tag);
         if (isAdjective(tag)) {
            adjectives.add(tok.word());
         }
         if (isNoun(tag)) {
            String noun = tok.word();
            corefCache.put(np, new Pair<>(adjectives, noun));
            return noun;
         }
      }

      throw new FailedParseException(String.format("Couldn't find any item in words: %s",
          tokens.subList(np.first, np.second + 1).stream().map(CoreLabel::word).collect(Collectors.joining(" "))));
   }

   // TODO: Rule out put the box in the box
   public static void findNounsAndAdjectives(CoreDocument document, int start, int end,
                                             List<Pair<Integer, Integer>> nps,
                                             ActionFormat actionToTake, List<String> nouns,
                                             List<Set<String>> adjectives, Map<Pair<Integer, Integer>, Pair<Integer, Integer>> corefRepresentative) throws FailedParseException {
      // TODO: Both cases should match against possibleActionNames with Wordnet
      // Word net in here
      // Either do a regex match for PUT IN
      Map<Pair<Integer, Integer>, Pair<Set<String>, String>> corefCache = new HashMap<>();

      List<Pair<Integer, Integer>> npsInVP = nps.stream().filter(np -> start <= np.first && np.second <= end).collect(Collectors.toList());
      if (npsInVP.size() != actionToTake.getDegree()) {
         throw new FailedParseException(String.format("Expected %d arguments for verb %s but got %d",
             actionToTake.getDegree(), actionToTake.getVerb(), npsInVP.size()));
      }

      if (actionToTake.isTernary()) {
         Pattern p = Pattern.compile(actionToTake.getRegExpr());
         List<CoreLabel> tokens = document.tokens();
         List<String> matchedStrings = tokens.subList(start, end + 1).stream().map(CoreLabel::value).collect(Collectors.toList());

         Matcher m = p.matcher(String.join(" ", matchedStrings));
         boolean doesMatch = m.matches();
         if (doesMatch) {
            int offset = tokens.get(start).beginPosition();
            for (int i = 1; i <= m.groupCount(); i++) {
               String matchingGroup = m.group(i);
               Pair<Integer, Integer> np = npsInVP.get(i - 1);
               int npStartCharIndex = tokens.get(np.first).beginPosition() - offset;
               int npEndCharIndex = tokens.get(np.second).endPosition() - offset;
               int matcherStart = m.start(i);
               int matcherEnd = m.end(i);
               if (npStartCharIndex != matcherStart || npEndCharIndex != matcherEnd) {
                  throw new FailedParseException(String.format("Non-noun phrase specified in the %d:th slot of verb %s", i, actionToTake.getVerb()));
               }
               appendMatchingGroupNoun(nouns, adjectives, document, np, corefCache, corefRepresentative);
            }
         }
         else {
            throw new FailedParseException(String.format("Argument structure after the verb %s was wrong.", actionToTake.getVerb()));
         }
      }
      // Or just find the noun
      else {
         String noun;
         Set<String> currentAdjectives = new HashSet<>();
         List<CoreLabel> tokens = document.tokens();
         Pair<Integer, Integer> np = nps.get(0);
         noun = nounsAndAdjectivesInNP(document, np, currentAdjectives, corefCache, corefRepresentative);
         nouns.add(noun);
         adjectives.add(currentAdjectives);
/*         for (int i = np.first; i <= np.second; i++) {
            CoreLabel tok = tokens.get(i);
            String tag = tok.tag();
            System.out.println(tag);
            if (isAdjective(tag)) {
               currentAdjectives.add(tok.word());
            }
            if (isNoun(tag)) {
               adjectives.add(currentAdjectives);
               noun = tok.word();
               nouns.add(noun);
               break;
            }
         }*/
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

   private static String tagWithCoref(CoreLabel tok) {
/*      for (Map.Entry<Integer, CorefChain> c : corefchains.entrySet()) {
         CorefChain val = c.getValue();
         System.out.println(val.getChainID());
         System.out.println(val.getMentionMap());
         System.out.println(val.getMentionsInTextualOrder());
         System.out.println(val.getRepresentativeMention());
         CorefChain.CorefMention mention =

      }*/
      return tok.tag();
   }

   // TODO: How does this work if there is a "-" in the sentence
   private static void appendMatchingGroupNoun(List<String> nouns, List<Set<String>> adjectives,
                                               CoreDocument document, Pair<Integer, Integer> np,
                                               Map<Pair<Integer, Integer>, Pair<Set<String>, String>> corefCache,
                                               Map<Pair<Integer, Integer>, Pair<Integer, Integer>> corefRepresentative) throws FailedParseException {
      /*      CoreDocument matchingDoc = generateCoreDocumentFromString(matchingGroup);*/
      /*      CoreDocument matchingDoc = generateCoreDocumentFromString(matchingGroup);*/
/*      int index = Collections.indexOfSubList(document.tokens().stream().map(x -> removeNumberTag(x.toString())).collect(Collectors.toList()),
          matchingDoc.tokens().stream().map(x -> removeNumberTag(x.toString())).collect(Collectors.toList()));*/

/*      int firstTokenIndex = np.first;
      int lastCharPos = document.tokens().get(np.second).endPosition();
      int offset = document.tokens().get(np.first).beginPosition();
*//*     for (int i = npStart; i <= npEnd; i++) {
         CoreLabel tok = document.tokens().get(i);
         if (tok.beginPosition() - offset == start) {
            firstTokenIndex = i;
         }
      }

      if (firstTokenIndex == -1) {
         System.err.println(document.tokens());
         System.err.println(matchingGroup);
         throw new FailedParseException("Incorrect usage of the verb: " + actionToTake.getVerb());
      }*//*

      String noun;
      Set<String> currentAdjectives = new HashSet<>();
      int tokenIndex = firstTokenIndex;
      CoreLabel tok = document.tokens().get(tokenIndex);
      while (tok.endPosition() - offset <= lastCharPos) {
         tok = document.tokens().get(tokenIndex);
         String tag = tagWithCoref(tok);
         if (isAdjective(tag)) {
            currentAdjectives.add(tok.word());
         }
         if (isNoun(tag)) {
            adjectives.add(currentAdjectives);
            noun = tok.word();
            nouns.add(noun);
            return;
         }
         tokenIndex++;
      }*/
      Set<String> currentAdjectives = new HashSet<>();
      String noun = nounsAndAdjectivesInNP(document, np, currentAdjectives, corefCache, corefRepresentative);
      nouns.add(noun);
      adjectives.add(currentAdjectives);

      //throw new FailedParseException(String.format("Couldn't find any item in words: %s", matchingGroup));
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
         String tag = tagWithCoref(tok);
         if (tag.equals("VB") || tag.equals("VBN") || tag.equals("VBG") || tag.equals("VBP") || tag.equals("VBZ")) {
            verb = tok.word();
            if (i != document.tokens().size() - 1) {
               CoreLabel nextToken = document.tokens().get(i + 1);
               if (tagWithCoref(nextToken).equals("RP")) {
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
             .parse("put the box in the key and eat the key",
                 new BasicGameEngine().getPossibleActionFormats(), Set.of(new Item("key"), new Item("box"))).get(0);
         InstantiatedGameAction command3 = EnhancedNLPEngine
             .parse("put the donkey in the box and eat it. eat box.",
                 new BasicGameEngine().getPossibleActionFormats(), Set.of(new Item("key"), new Item("donkey"), new Item("box"))).get(0);
         InstantiatedGameAction command4 = EnhancedNLPEngine
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
