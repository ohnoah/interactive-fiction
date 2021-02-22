package com.intfic.nlp;

import com.intfic.nlp.FailedParseException;
import com.intfic.game.shared.ActionFormat;
import com.intfic.game.shared.InstantiatedGameAction;
import com.intfic.game.shared.Item;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class NLPEngine {
   /*public abstract InstantiatedGameAction parse(String rawCommand, List<ActionFormat> possibleActionFormats, Set<Item> possibleItems) throws FailedParseException;*/
   //TODO: with wordnet synonyms
   // TODO: Throw FailedParseException if item not in this room is given
   // Returns a list of synonym-replaced String item names for "nouns" corresponding in-game items
   // If fails, throw a com.interactivefiction.nlp.FailedParseException. This can be either because adjectives don't match
   // or because there are no in-game items with that name.
   // TODO: To support multiple same-name items, need to change this to longest match and return list of list
   public static List<Item> findMatchingGameItems(List<String> nouns, List<Set<String>> adjectives,
                                                  Set<Item> possibleItems) throws FailedParseException {
      List<Item> matchingGameItems = new ArrayList<>();
      nounLoop:
      for (int i = 0; i < nouns.size(); i++) {
         String noun = nouns.get(i);
         for (Item item : possibleItems) {
            String itemName = item.getName();
            if (itemName.equals(noun)) {
               if (adjectivesMatch(adjectives.get(i), item.getAdjectives())) {
                  matchingGameItems.add(item);
                  continue nounLoop;
               }
               else {
                  String missingItems = adjectives.get(i).stream()
                      .filter(s -> !item.getAdjectives().contains(s)).sorted().collect(Collectors.joining(","));
                  throw new FailedParseException(String.format("I couldn't find a %s %s in your environment.", missingItems, noun));
               }
            }
         }
         for (Item item : possibleItems) {
            if (item.getSynonyms().contains(noun)) {
               if (adjectivesMatch(adjectives.get(i), item.getAdjectives())) {
                  matchingGameItems.add(item);
                  continue nounLoop;
               }
               else {
                  String missingItems = adjectives.get(i).stream()
                      .filter(s -> !item.getAdjectives().contains(s)).sorted().collect(Collectors.joining(","));
                  throw new FailedParseException(String.format("I couldn't find a %s %s in your environment.", missingItems, noun));
               }
            }
         }
         throw new FailedParseException(String.format("There is no %s in your environment.", noun));
      }
      return matchingGameItems;
   }

   private static boolean adjectivesMatch(Set<String> userAdjectives, Set<String> itemAdjectives) {
      return itemAdjectives.containsAll(userAdjectives);
   }
}


// Examine, Push, Take, Pull Drop, Turn, Open, Feel, PUT __ IN __, PUT __ on __