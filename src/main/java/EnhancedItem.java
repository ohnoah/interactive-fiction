import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

public class EnhancedItem extends Item {
   private static final long serialVersionUID = -3502337522334177363L;
   private List<String> adjectives;
   private List<String> synonyms;

   public EnhancedItem(@NotNull String name) {
      super(name);
   }

   public EnhancedItem(@NotNull String name, List<String> defaultAdjectives, List<String> synonyms) {
      super(name);
      this.adjectives = new ArrayList<>();
      this.adjectives.addAll(defaultAdjectives);
      this.synonyms = new ArrayList<>();
      this.synonyms.addAll(synonyms);
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      if (!super.equals(o)) {
         return false;
      }
      EnhancedItem that = (EnhancedItem) o;
      return adjectives.equals(that.adjectives) &&
          synonyms.equals(that.synonyms);
   }

   @Override
   public int hashCode() {
      return Objects.hash(super.hashCode(), adjectives, synonyms);
   }
}
