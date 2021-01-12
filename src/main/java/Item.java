import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import org.jetbrains.annotations.NotNull;

public class Item implements Serializable {
   private static final long serialVersionUID = -2769417686782978456L;
   private String name;
   // Both of these should be sets
   private Set<String> adjectives;
   private Set<String> synonyms;


   public Item(@NotNull String name) {
      this.name = name;
      synonyms = new HashSet<>();
      adjectives = new HashSet<>();
   }

   @Override
   public String toString() {
      return String.format("[%s] %s", String.join(",", adjectives), name);
   }

   public Item(@NotNull String name, @NotNull Set<String> defaultAdjectives) {
      this.name = name;
      this.adjectives = new HashSet<>();
      this.adjectives.addAll(defaultAdjectives);
      this.synonyms = new HashSet<>();
   }

   public Item(@NotNull String name, @NotNull Set<String> defaultAdjectives, @NotNull Set<String> synonyms) {
      this.name = name;
      this.adjectives = new HashSet<>(defaultAdjectives);
      this.synonyms = new HashSet<>(synonyms);
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      Item item = (Item) o;
      return getName().equals(item.getName());
   }

   @Override
   public int hashCode() {
      return Objects.hash(getName());
   }

   public Set<String> getAdjectives() {
      return new HashSet<>(adjectives);
   }

   public void setAdjectives(Set<String> adjectives) {
      this.adjectives = new HashSet<>();
      this.adjectives.addAll(adjectives);
   }

   public Set<String> getSynonyms() {
      return new HashSet<>(synonyms);
   }

   public void setSynonyms(List<String> synonyms) {
      this.synonyms = new HashSet<>(synonyms);
   }


   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

}
