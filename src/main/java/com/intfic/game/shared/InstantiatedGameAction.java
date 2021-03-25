package com.intfic.game.shared;

import edu.stanford.nlp.util.Pair;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class InstantiatedGameAction implements Serializable {
   private static final long serialVersionUID = 4004019328393742799L;
   private ActionFormat abstractActionFormat;
   private List<List<Item>> potentialArguments;

   public List<Item> getActualArguments() {
      return actualArguments;
   }

   public void setActualArguments(List<Item> actualArguments) {
      this.actualArguments = actualArguments;
   }

   private List<Item> actualArguments;


   private Pair<Set<String>, String> it;


   public InstantiatedGameAction(ActionFormat actionFormat, List<List<Item>> nouns) {
      setAbstractActionFormat(actionFormat);
      setPotentialArguments(nouns);
      if(Util.isFlat(nouns)){
         setActualArguments(Util.flatten(nouns));
      }
   }

   // Used for testing
   public InstantiatedGameAction(ActionFormat actionFormat, List<Item> nouns, boolean l) {
      setAbstractActionFormat(actionFormat);
      setActualArguments(nouns);
   }



   public Pair<Set<String>, String> getIt() {
      return it;
   }

   public void setIt(Pair<Set<String>, String> it) {
      this.it = it;
   }

   // TODO: Case-sensitivity
   public InstantiatedGameAction(ActionFormat actionFormat) {
      abstractActionFormat = actionFormat;
   }

   public ActionFormat getAbstractActionFormat() {
      return abstractActionFormat;
   }

   public void setAbstractActionFormat(ActionFormat abstractActionFormat) {
      this.abstractActionFormat = abstractActionFormat;
   }

   public List<List<Item>> getPotentialArguments() {
      return potentialArguments;
   }

   public void setPotentialArguments(List<List<Item>> potentialArguments) {
      this.potentialArguments = new ArrayList<>(potentialArguments);
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      InstantiatedGameAction that = (InstantiatedGameAction) o;
      return abstractActionFormat.equals(that.abstractActionFormat) && Objects.equals(actualArguments, that.actualArguments);
   }

   @Override
   public int hashCode() {
      return Objects.hash(abstractActionFormat, actualArguments);
   }

   @Override
   public String toString() {
      return "InstantiatedGameAction{" +
          "abstractActionFormat=" + abstractActionFormat +
          ", potentialArguments=" + potentialArguments +
          ", actualArguments=" + actualArguments +
          ", it=" + it +
          '}';
   }

   // Some form of enum with different possibilities and showing the slots it needs
}
