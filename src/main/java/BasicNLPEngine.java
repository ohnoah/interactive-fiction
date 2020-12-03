import edu.stanford.nlp.ling.*;
import edu.stanford.nlp.pipeline.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.Action;
import net.sf.extjwnl.JWNLException;
import net.sf.extjwnl.dictionary.Dictionary;
import net.sf.extjwnl.data.IndexWord;
import net.sf.extjwnl.data.POS;

// TODO: Decisions being made
// Doesn't support overloading verb operator like TURN around and TURN
// Doesn't support multiple words like LISTEN TO
// Doesn't support nullary operators

public class BasicNLPEngine extends NLPEngine {

   @Override
   public ConcreteGameAction parse(String rawCommand, List<ActionFormat> possibleActionFormats, List<String> possibleItemNames) throws FailedParseException {
      // TODO: Fail if more than one sentence or there is an and in the sentence

      // display tokens
      String verb = null;
      try {
         verb = findVerb(rawCommand);
      } catch (JWNLException e) {
         e.printStackTrace();
      }
      ActionFormat actionFormat = findMatchingGameVerb(verb, possibleActionFormats);

      List<String> nouns = null;
      try {
         nouns = findNouns(rawCommand, actionFormat);
      } catch (JWNLException e) {
         e.printStackTrace();
      }
      ConcreteGameAction command = new ConcreteGameAction(actionFormat, nouns);
      // Use that to look for a VB and a NN and populate a Command
      // just look for the possible commands using WordNet otherwise return Error
      // enhanced engine can be more informative if a supplementary word happens
      // FAIL flag if command is fake


      return command;
   }

   private void appendFirstNoun(List<String> nouns, String stringToSearch, ActionFormat actionToTake) throws JWNLException {
      Dictionary d = null;
      d = Dictionary.getDefaultResourceInstance();
      String[] splitWords = stringToSearch.split(" ");
      for (String word : splitWords) {
         if (word.equals(actionToTake.getVerb())) { // to block e.g. "open" to be classified as a noun
            continue;
         }
         IndexWord iw = null;
         iw = d.getIndexWord(POS.NOUN, word);
         if (iw == null) { // not a noun
            continue;
         } else {
            String lemma = iw.getLemma();
            nouns.add(lemma.trim());
            break;
         }
      }
   }

   public List<String> findNouns(String rawCommand, ActionFormat actionToTake) throws JWNLException, FailedParseException {
      // Either do a regex match for PUT IN
      List<String> nouns = new ArrayList<>();
      if (actionToTake.isTernary()) {
         Pattern p = Pattern.compile(actionToTake.getRegExpr());
         Matcher m = p.matcher(rawCommand);
         boolean doesMatch = m.matches();
         if (doesMatch) {
            for (int i = 1; i <= m.groupCount(); i++) {
               String matchingGroup = m.group(i);
               appendFirstNoun(nouns, matchingGroup, actionToTake);
            }
         } else {
            throw new FailedParseException("Argument structure after the verb was wrong.");
         }
      }
      // Or just find the noun if its a unary
      else {
         appendFirstNoun(nouns, rawCommand, actionToTake);
         if (nouns.size() == 0) { // no nullary operator allowed
            throw new FailedParseException("No arguments given to the verb.");
         }
      }
      return nouns;
   }

   // This fails for e.g. TURN it ON, TURN the box
   public ActionFormat findMatchingGameVerb(String verb, List<ActionFormat> possibleActionFormats) throws FailedParseException {
      // Word net in here
      for (ActionFormat af : possibleActionFormats) {
         if (af.getVerb().equals(verb)) {
            return af;
         }
      }
      throw new FailedParseException("No matching game verb");
   }

   public String findVerb(String rawCommand) throws JWNLException, FailedParseException {
      Dictionary d = null;
      d = Dictionary.getDefaultResourceInstance();
      String[] splitWords = rawCommand.split(" ");
      for (String word : splitWords) {
         IndexWord iw = null;
         iw = d.getIndexWord(POS.VERB, word);
         if (iw == null) { // not a verb
            continue;
         } else {
            return iw.getLemma().trim();
         }
      }
      throw new FailedParseException("No verb supplied");
   }

   public static void main(String[] args) {
      System.out.println("HELLO");
      try {
         Dictionary d = Dictionary.getDefaultResourceInstance();
/*         IndexWord iw = d.getIndexWord(POS.VERB, "LISTEN TO");
         System.out.println(iw.getKey());
         System.out.println(iw.getLemma());*/
      } catch (JWNLException e) {
         System.out.println("SDSD");
         e.printStackTrace();
      }
      Pattern p = Pattern.compile("PUT ([\\w\\s]+) IN ([\\w\\s]+)$");
      Matcher m = p.matcher("PUT the balloon IN the narnia");
      boolean doesMatch = m.matches();
      System.out.println(m.group(1));
      System.out.println(m.group(2));



/*      BasicNLPEngine basicNLPEngine = new BasicNLPEngine();
      ConcreteGameAction command = basicNLPEngine.parse("put it in the box",null);*/
   }
}
