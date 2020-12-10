import java.util.List;
import java.util.Objects;

public class ConcreteGameAction {
   private ActionFormat abstractActionFormat;
   private List<String> arguments;
   public ConcreteGameAction(ActionFormat actionFormat, List<String> nouns) {
      abstractActionFormat = actionFormat;
      arguments = nouns;
   }
   public ConcreteGameAction(ActionFormat actionFormat) {
      abstractActionFormat = actionFormat;
   }

   public ActionFormat getAbstractActionFormat() {
      return abstractActionFormat;
   }

   public void setAbstractActionFormat(ActionFormat abstractActionFormat) {
      this.abstractActionFormat = abstractActionFormat;
   }

   public List<String> getArguments() {
      return arguments;
   }

   public void setArguments(List<String> arguments) {
      this.arguments = arguments;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      ConcreteGameAction that = (ConcreteGameAction) o;
      return getAbstractActionFormat().equals(that.getAbstractActionFormat()) &&
          getArguments().equals(that.getArguments());
   }

   @Override
   public int hashCode() {
      return Objects.hash(getAbstractActionFormat(), getArguments());
   }

// Some form of enum with different possibilities and showing the slots it needs
}
