import java.util.List;

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
   // Some form of enum with different possibilities and showing the slots it needs
}
