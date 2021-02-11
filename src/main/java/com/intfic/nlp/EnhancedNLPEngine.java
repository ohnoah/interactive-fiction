package com.intfic.nlp;

import com.intfic.game.shared.ActionFormat;
import com.intfic.game.shared.InstantiatedGameAction;
import com.intfic.game.shared.Item;
import edu.stanford.nlp.coref.data.CorefChain;
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
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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


   private static Map<Pair<Integer, Integer>, Pair<Integer, Integer>> corefRepresentative(Map<Integer, CorefChain> corefChainMap) {
      System.out.println(corefChainMap);
      Map<Pair<Integer, Integer>, Pair<Integer, Integer>> corefRepresentative = new HashMap<>();
      for (Map.Entry<Integer, CorefChain> entry : corefChainMap.entrySet()) {
         CorefChain c = entry.getValue();
         List<CorefChain.CorefMention> corefMentions = c.getMentionsInTextualOrder();
         Pair<Integer, Integer> representing = new Pair<>(corefMentions.get(0).startIndex - 1, corefMentions.get(0).endIndex - 2);
         for (CorefChain.CorefMention mention : corefMentions) {
            Pair<Integer, Integer> mentionIndices = new Pair<>(mention.startIndex - 1, mention.endIndex - 2);
            // Don't add self-references or forward references
            if (representing.compareTo(mentionIndices) < 0) {
               corefRepresentative.put(mentionIndices, representing);
            }
         }
      }
      return corefRepresentative;
   }

   public static List<InstantiatedGameAction> parse(@NotNull String rawCommand, @NotNull List<ActionFormat> possibleActionFormats, Set<Item> possibleItems) throws FailedParseException {
      return parse(rawCommand, possibleActionFormats, possibleItems, null);
   }

   public static List<InstantiatedGameAction> parse(@NotNull String rawCommand, @NotNull List<ActionFormat> possibleActionFormats, Set<Item> possibleItems, Pair<Set<String>, String> it) throws FailedParseException {

      CoreDocument document = generateCoreDocumentFromString(rawCommand); //lemma stuff

      Comparator<Pair<Integer, Integer>> pairComparator = Pair::compareTo;

      Map<Pair<Integer, Integer>, Pair<Set<String>, String>> corefCache = new HashMap<>();
      Map<Integer, CorefChain> corefChainMap = document.corefChains();
      System.out.println(corefChainMap);
      Map<Pair<Integer, Integer>, Pair<Integer, Integer>> corefRepresentative = corefRepresentative(corefChainMap);


      List<InstantiatedGameAction> commands = new ArrayList<>();
      List<CoreSentence> sentences = document.sentences();
      boolean firstCommand = true;
      for (int sentIndex = 0; sentIndex < sentences.size(); sentIndex++) {
         CoreSentence sentence = sentences.get(sentIndex);
         Tree tree =
             document.annotation().get(CoreAnnotations.SentencesAnnotation.class).get(sentIndex).get(TreeCoreAnnotations.TreeAnnotation.class);
         System.out.println(tree);
         List<Pair<Integer, Integer>> vps = new ArrayList<>();
         List<Pair<Integer, Integer>> nps = new ArrayList<>();
         // TODO: Seems like this can be replaced with sentence.verbPhraseTrees.start/end
         npVpIndices(tree, vps, nps);

         vps.sort(pairComparator);
         nps.sort(pairComparator);
         System.out.println(vps);
         System.out.println(nps);
         if (it != null && sentIndex == 0 && nps.size() > 0) {
            Pair<Integer, Integer> firstNP = nps.get(0);
            if (firstNP.second - firstNP.first == 0) {
               CoreLabel firstTokenNP = sentence.tokens().get(firstNP.first);
               if (firstTokenNP.tag().equals("PRP") && firstTokenNP.word().toLowerCase().equals("it")) {
                  corefCache.put(firstNP, it);
                  corefRepresentative.put(firstNP, firstNP);
               }
            }
         }

         // TODO: Check that no negations occur between vpIndices or that a separatae sentence

         for (Pair<Integer, Integer> vpStartEnd : vps) {
            // display tokens
            int start = vpStartEnd.first;
            int end = vpStartEnd.second;
            String verb = findVerb(sentence, start, end);
            ActionFormat actionFormat = findMatchingGameVerb(verb, possibleActionFormats);

            List<String> nouns = new ArrayList<>();
            List<Set<String>> adjectives = new ArrayList<>();
            List<Pair<Integer, Integer>> npsInVP = nps.stream().filter(np -> start <= np.first && np.second <= end).collect(Collectors.toList());
            Pair<Set<String>, String> itToSet = firstCommand ? new Pair<>(new HashSet<>(), "") : null;
            findNounsAndAdjectives(sentence, start, end, npsInVP, actionFormat, nouns, adjectives, corefCache, corefRepresentative, itToSet);

            //TODO: do the wordnet stuff here for nouns
            List<Item> gameItemNames = EnhancedNLPEngine.findMatchingGameItemNames(nouns, adjectives, possibleItems);


            InstantiatedGameAction command = new InstantiatedGameAction(actionFormat, gameItemNames);
            if (firstCommand) {
               command.setIt(itToSet);
               firstCommand = false;
            }
            commands.add(command);
         }
      }
      for (CoreLabel tok : document.tokens()) {
         String tagCoref = tag(tok);
         System.out.println(String.format("%s\t%s(%s)", tok.word(), tok.tag(), tagCoref.equals(tok.tag()) ? "-" : tagCoref));
      }
      System.out.println(document.corefChains());
      // Use that to look for a VB and a NN and populate a Command
      // just look for the possible commands using WordNet otherwise return Error
      // enhanced engine can be more informative if a supplementary word happens
      // FAIL flag if command is fake
      return commands;
   }





   private static boolean isAdjective(String tag) {
      return tag.equals("JJ") || tag.equals("JJR") || tag.equals("JJS");
   }

   private static String nounsAndAdjectivesInNP(CoreSentence sentence, Pair<Integer, Integer> np,
                                                Set<String> adjectives, Map<Pair<Integer, Integer>, Pair<Set<String>, String>> corefCache,
                                                Map<Pair<Integer, Integer>, Pair<Integer, Integer>> corefRepresentative) throws FailedParseException {


      if (corefRepresentative.containsKey(np)) {
         Pair<Integer, Integer> representativeNp = corefRepresentative.get(np);
         Pair<Set<String>, String> adjAndNouns = corefCache.get(representativeNp);
         adjectives.addAll(adjAndNouns.first);
         return adjAndNouns.second;
      }
      List<CoreLabel> tokens = sentence.tokens();
      for (int i = np.first; i <= np.second; i++) {
         CoreLabel tok = tokens.get(i);
         String tag = tok.tag();
         System.out.println(tag);
         if (isAdjective(tag)) {
            adjectives.add(tok.word());
         }
         if (isNoun(tag)) {
            String noun = tok.word();
            if (corefRepresentative.containsValue(np)) {
               corefCache.put(np, new Pair<>(adjectives, noun));
            }
            return noun;
         }
      }

      throw new FailedParseException(String.format("Couldn't find any item in words: %s",
          tokens.subList(np.first, np.second + 1).stream().map(CoreLabel::word).collect(Collectors.joining(" "))));
   }

   public static void findNounsAndAdjectives(CoreSentence sentence, int vpStart, int vpEnd,
                                             List<Pair<Integer, Integer>> npsInVP,
                                             ActionFormat actionToTake, List<String> nouns,
                                             List<Set<String>> adjectives, Map<Pair<Integer, Integer>, Pair<Set<String>, String>> corefCache,
                                             Map<Pair<Integer, Integer>, Pair<Integer, Integer>> corefRepresentative) throws FailedParseException {
      findNounsAndAdjectives(sentence, vpStart, vpEnd, npsInVP, actionToTake, nouns, adjectives, corefCache, corefRepresentative, null);
   }

   // TODO: Both cases should match against possibleActionNames with Wordnet
   // TODO: Rule out put the box in the box
   public static void findNounsAndAdjectives(CoreSentence sentence, int vpStart, int vpEnd,
                                             List<Pair<Integer, Integer>> npsInVP,
                                             ActionFormat actionToTake, List<String> nouns,
                                             List<Set<String>> adjectives, Map<Pair<Integer, Integer>, Pair<Set<String>, String>> corefCache,
                                             Map<Pair<Integer, Integer>, Pair<Integer, Integer>> corefRepresentative, Pair<Set<String>, String> itToSet) throws FailedParseException {
      // TODO: Both cases should match against possibleActionNames with Wordnet
      // Word net in here
      // Either do a regex match for PUT IN

      if (npsInVP.size() != actionToTake.getDegree()) {
         throw new FailedParseException(String.format("Expected %d arguments for verb %s but got %d",
             actionToTake.getDegree(), actionToTake.getVerb(), npsInVP.size()));
      }

      if (actionToTake.isTernary()) {
         Pattern p = Pattern.compile(actionToTake.getRegExpr());
         List<CoreLabel> tokens = sentence.tokens();
         List<String> matchedVPStrings = tokens.subList(vpStart, vpEnd + 1).stream().map(CoreLabel::value).collect(Collectors.toList());

         Matcher m = p.matcher(String.join(" ", matchedVPStrings));
         boolean doesMatch = m.matches();
         if (doesMatch) {
            int offset = tokens.get(vpStart).beginPosition();
            // This code simply checks that the NP next in line is the next matching group to avoid mathching groups being non-NP
            for (int i = 1; i <= m.groupCount(); i++) {
               //String matchingGroup = m.group(i);
               Pair<Integer, Integer> np = npsInVP.get(i - 1);
               int npStartCharIndex = tokens.get(np.first).beginPosition() - offset;
               int npEndCharIndex = tokens.get(np.second).endPosition() - offset;
               int matcherStart = m.start(i);
               int matcherEnd = m.end(i);
               if (npStartCharIndex != matcherStart || npEndCharIndex != matcherEnd) {
                  throw new FailedParseException(String.format("Non-noun phrase specified in the %d:th slot of verb %s", i, actionToTake.getVerb()));
               }
               /*appendMatchingGroupNoun(nouns, adjectives, sentence, np, corefCache, corefRepresentative, it);*/
               Set<String> currentAdjectives = new HashSet<>();
               String noun = nounsAndAdjectivesInNP(sentence, np, currentAdjectives, corefCache, corefRepresentative);
               nouns.add(noun);
               adjectives.add(currentAdjectives);
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
         Pair<Integer, Integer> np = npsInVP.get(0);
         noun = nounsAndAdjectivesInNP(sentence, np, currentAdjectives, corefCache, corefRepresentative);
         if (itToSet != null) {
            itToSet.setFirst(currentAdjectives);
            itToSet.setSecond(noun);
         }
         nouns.add(noun);
         adjectives.add(currentAdjectives);
      }
   }

   private static boolean isNoun(String tag) {
      return tag.equals("NN") || tag.equals("NNS") || tag.equals("NNP") || tag.equals("NNPS");
   }

   private static String tag(CoreLabel tok) {
      return tok.tag();
   }

   // TODO: How does this work if there is a "-" in the sentence
   private static void appendMatchingGroupNoun(List<String> nouns, List<Set<String>> adjectives,
                                               CoreSentence sentence, Pair<Integer, Integer> np,
                                               Map<Pair<Integer, Integer>, Pair<Set<String>, String>> corefCache,
                                               Map<Pair<Integer, Integer>, Pair<Integer, Integer>> corefRepresentative) throws FailedParseException {
      Set<String> currentAdjectives = new HashSet<>();
      String noun = nounsAndAdjectivesInNP(sentence, np, currentAdjectives, corefCache, corefRepresentative);
      nouns.add(noun);
      adjectives.add(currentAdjectives);
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
   public static String findVerb(CoreSentence sentence, int start, int end) throws FailedParseException {
      String verb;
      for (int i = start; i <= end; i++) {
         CoreLabel tok = sentence.tokens().get(i);
         String tag = tag(tok);
         if (tag.equals("VB") || tag.equals("VBN") || tag.equals("VBG") || tag.equals("VBP") || tag.equals("VBZ")) {
            verb = tok.word();
            if (i != sentence.tokens().size() - 1) {
               CoreLabel nextToken = sentence.tokens().get(i + 1);
               if (tag(nextToken).equals("RP")) {
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
/*      try {
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
      }*/
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

   public static List<Item> findMatchingGameItemNames(List<String> nouns, List<Set<String>> adjectives, Set<Item> gameItems) throws FailedParseException {
      return NLPEngine.findMatchingGameItems(nouns, adjectives, gameItems);
   }
}
