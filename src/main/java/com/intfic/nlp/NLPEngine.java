package com.intfic.nlp;

import com.intfic.game.shared.Util;
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
   public static List<List<Item>> findMatchingGameItems(List<String> nouns, List<Set<String>> adjectives,
                                                        Set<Item> possibleItems) throws FailedParseException {
      List<List<Item>> matchingGameItems = new ArrayList<>();
      List<Item> currentItemsWithFreq = new ArrayList<>();
      boolean nounMatch = false;
      // First, look through the names and look for a match here
      nounLoop:
      for (int i = 0; i < nouns.size(); i++) {
         String noun = nouns.get(i);
         int numGivenAdjectives = adjectives.get(i).size();
         for (Item item : possibleItems) {
            String itemName = item.getName();
            if (itemName.equals(noun)) {
               nounMatch = true;
               long numMatchedAdjectives = adjectivesMatch(adjectives.get(i), item.getAdjectives());
               // This means we actually have a match that is longer or same as current best
               if (numMatchedAdjectives == numGivenAdjectives) {
                  currentItemsWithFreq.add(item);
                  /*matchingGameItems.add(item);*/
                  /*continue nounLoop;*/
               }
            }
         }
         // If none of them base names match, then we look into the synonyms
         if (currentItemsWithFreq.size() != 0) {
            matchingGameItems.add(currentItemsWithFreq);
            currentItemsWithFreq = new ArrayList<>();
            continue;
         }
         for (Item item : possibleItems) {
            if (item.getSynonyms().contains(noun.toLowerCase())) {
               nounMatch = true;
               long adjectiveMatch = adjectivesMatch(adjectives.get(i), item.getAdjectives());
               if (adjectiveMatch == numGivenAdjectives) {
                  currentItemsWithFreq.add(item);
                  /*matchingGameItems.add(item);
                  continue nounLoop;*/
               }
            }
         }
         if (currentItemsWithFreq.size() != 0) {
            matchingGameItems.add(currentItemsWithFreq);
            currentItemsWithFreq = new ArrayList<>();
            continue;
         }

         if (nounMatch) {
            throw new FailedParseException(String.format("I couldn't find a %s %s in your environment.",
                adjectives.get(i).stream().sorted().collect(Collectors.joining(",")), noun));
         }
         else {
            throw new FailedParseException(String.format("I couldn't find %s in your environment.", noun));
         }
      }
      return matchingGameItems;
   }

   private static long adjectivesMatch(Set<String> userAdjectives, Set<String> itemAdjectives) {
      return Util.containedSize(userAdjectives, itemAdjectives);
   }
}


// Examine, Push, Take, Pull Drop, Turn, Open, Feel, PUT __ IN __, PUT __ on __