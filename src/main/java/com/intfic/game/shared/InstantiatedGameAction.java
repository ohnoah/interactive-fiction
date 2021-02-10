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
   private List<Item> arguments;


   private Pair<Set<String>, String> it;

   public InstantiatedGameAction(ActionFormat actionFormat, List<Item> nouns) {
      setAbstractActionFormat(actionFormat);
      setArguments(nouns);
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

   public List<Item> getArguments() {
      return arguments;
   }

   public void setArguments(List<Item> arguments) {
      this.arguments = new ArrayList<>(arguments);
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
      return getAbstractActionFormat().equals(that.getAbstractActionFormat()) &&
          getArguments().equals(that.getArguments());
   }

   @Override
   public int hashCode() {
      return Objects.hash(getAbstractActionFormat(), getArguments());
   }

// Some form of enum with different possibilities and showing the slots it needs
}
