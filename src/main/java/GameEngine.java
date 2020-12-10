import java.util.List;

public abstract class GameEngine{
  public abstract List<ActionFormat> possibleActionFormats();

  public abstract List<String> possibleItemNames();

  public abstract String progressStory(ConcreteGameAction gameAction);
}
