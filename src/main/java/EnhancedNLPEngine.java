import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.trees.Constituent;
import edu.stanford.nlp.trees.LabeledScoredConstituentFactory;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.trees.TreeCoreAnnotations;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.jetbrains.annotations.NotNull;

public class EnhancedNLPEngine extends NLPEngine {

   @Override
   public InstantiatedGameAction parse(@NotNull String rawCommand, @NotNull List<ActionFormat> possibleActionFormats, Set<Item> possibleItems) throws FailedParseException {

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

      CoreDocument document = generateCoreDocumentFromString(rawCommand, "tokenize,ssplit,pos"); //lemma stuff

      // display tokens
      String verb = null;
      verb = findVerb(document);
      ActionFormat actionFormat = findMatchingGameVerb(verb, possibleActionFormats);

      List<String> nouns = new ArrayList<>();
      List<Set<String>> adjectives = new ArrayList<>();
      if (actionFormat == null) {
         // I DONT UNDERSTAND THAT
         throw new FailedParseException(String.format("Can't understand the verb: %s", verb));
      } else {
         findNounsAndAdjectives(document, actionFormat, nouns, adjectives);
      }

      //TODO: do the wordnet stuff here for nouns
      List<String> gameItemNames = findMatchingGameItemNames(nouns, adjectives, possibleItems);


      InstantiatedGameAction command = new InstantiatedGameAction(actionFormat, gameItemNames);
      for (CoreLabel tok : document.tokens()) {
         System.out.println(String.format("%s\t%s", tok.word(), tok.tag()));
      }
      // Use that to look for a VB and a NN and populate a Command
      // just look for the possible commands using WordNet otherwise return Error
      // enhanced engine can be more informative if a supplementary word happens
      // FAIL flag if command is fake


      return command;
   }

   //TODO: with wordnet synonyms
   // TODO: Throw FailedParseException if item not in this room is given
   // Returns a list of synonym-replaced String item names for "nouns" corresponding in-game items
   // If fails, throw a FailedParseException. This can be either because adjectives don't match
   // or because there are no in-game items with that name.
   protected List<String> findMatchingGameItemNames(List<String> nouns, List<Set<String>> adjectives,
                                                    Set<Item> possibleItems) throws FailedParseException {
      List<String> matchingGameItemNames = new ArrayList<>();
      nounLoop:
      for (int i = 0; i<nouns.size(); i++) {
         String noun = nouns.get(i);
         for (Item item : possibleItems) {
            String itemName = item.getName();
            if (itemName.equals(noun)) {
               if (adjectivesMatch(adjectives.get(i), item.getAdjectives())) {
                  matchingGameItemNames.add(itemName);
                  continue nounLoop;
               } else {
                  String missingItems = adjectives.get(i).stream()
                      .filter(s -> !item.getAdjectives().contains(s)).collect(Collectors.joining(","));
                  throw new FailedParseException(String.format("There is no %s %s in your environment.", missingItems, noun));
               }
            }
         }
         for (Item item : possibleItems) {
            if (item.getSynonyms().contains(noun)) {
               matchingGameItemNames.add(item.getName());
               continue nounLoop;
            }
         }
         throw new FailedParseException(String.format("There is no %s in your environment.", noun));
      }
      return matchingGameItemNames;
   }

   private boolean adjectivesMatch(Set<String> userAdjectives, Set<String> itemAdjectives) {
      return itemAdjectives.containsAll(userAdjectives);
   }

   // TODO: Rule out put the box in the box
   protected void findNounsAndAdjectives(CoreDocument document, ActionFormat actionToTake, List<String> nouns, List<Set<String>> adjectives) throws FailedParseException {
      // TODO: Both cases should match against possibleActionNames with Wordnet
      // Word net in here
      // Either do a regex match for PUT IN
      if (actionToTake.isTernary()) {
         Pattern p = Pattern.compile(actionToTake.getRegExpr());
         Matcher m = p.matcher(document.text());
         boolean doesMatch = m.matches();
         if (doesMatch) {
            for (int i = 1; i <= m.groupCount(); i++) {
               String matchingGroup = m.group(i);
               appendMatchingGroupNoun(nouns, adjectives, document, matchingGroup, actionToTake);
            }
         } else {
            throw new FailedParseException("Argument structure after the verb was wrong.");
         }
      }
      // Or just find the noun
      else {
         String noun = null;
         Set<String> currentAdjectives = new HashSet<>();
         for (CoreLabel tok : document.tokens()) {
            String tag = tok.tag();
            System.err.println(tag);
            if (tag.equals("JJ") || tag.equals("JJR") || tag.equals("JJS")) {
               currentAdjectives.add(tok.word());
            }
            if (tag.equals("NN")) {
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

   protected String removeNumberTag(String s) {
      int i = s.indexOf("-");
      if (i == -1) {
         return s;
      } else {
         return s.substring(0, i);
      }
   }

   // TODO: How does this work if there is a "-" in the sentence
   protected void appendMatchingGroupNoun(List<String> nouns, List<Set<String>> adjectives, CoreDocument document, String matchingGroup, ActionFormat actionToTake) throws FailedParseException {
      CoreDocument matchingDoc = generateCoreDocumentFromString(matchingGroup, "tokenize");
      int index = Collections.indexOfSubList(document.tokens().stream().map(x -> removeNumberTag(x.toString())).collect(Collectors.toList()),
          matchingDoc.tokens().stream().map(x -> removeNumberTag(x.toString())).collect(Collectors.toList()));
      if (index == -1) {
         System.err.println(document.tokens());
         System.err.println(matchingDoc.tokens());
         throw new FailedParseException("Incorrect usage of the verb: " + actionToTake.getVerb());
      }
      String noun;
      Set<String> currentAdjectives = new HashSet<>();
      for (int i = index; i < index + matchingDoc.tokens().size(); i++) {
         CoreLabel tok = document.tokens().get(i);
         String tag = tok.tag();
         if (tag.equals("JJ") || tag.equals("JJR") || tag.equals("JJS")) {
            currentAdjectives.add(tok.word());
         }
         if (tag.equals("NN")) {
            adjectives.add(currentAdjectives);
            noun = tok.word();
            nouns.add(noun);
            return;
         }
      }
      throw new FailedParseException(String.format("Couldn't find any item in %s", matchingGroup));
   }

   // This fails for e.g. TURN it ON, TURN the box
   protected ActionFormat findMatchingGameVerb(String verb, List<ActionFormat> possibleActionFormats) throws FailedParseException {
      // TODO: ADD Word net in here
      for (ActionFormat af : possibleActionFormats) {
         if (af.getVerb().equals(verb)) {
            return af;
         }
      }
      throw new FailedParseException("No matching game verb");
   }

   // TODO: Think about ignoring everyhing after found
   protected String findVerb(CoreDocument document) throws FailedParseException {
      String verb = null;
      for (int i = 0; i < document.tokens().size(); i++) {
         CoreLabel tok = document.tokens().get(i);
         String tag = tok.tag();
         if (tag.equals("VB")) {
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
      throw new FailedParseException("Can't find a verb");
   }

   public static void main(String[] args) {
      // set up pipeline properties
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
            } else {
               System.out.println("FAIL");
            }
         }
      } else {
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

      EnhancedNLPEngine enhancedNLPEngine = new EnhancedNLPEngine();
      try {
         InstantiatedGameAction command = enhancedNLPEngine
             .parse("put the black key in the red key",
                 new BasicGameEngine().getPossibleActionFormats(), Set.of(new Item("key")));
      } catch (FailedParseException e) {
         e.printStackTrace();
      }
   }

   public CoreDocument generateCoreDocumentFromString(String rawCommand, String annotatorsProperty) {
      Properties props = new Properties();
      props.setProperty("annotators", "tokenize,ssplit,pos"); // TODO: ,lemma in props
      // build pipeline
      StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
      // create a document object
      CoreDocument document = pipeline.processToCoreDocument(rawCommand);
      return document;
   }
}
