import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.jetbrains.annotations.NotNull;

public abstract class GameEngine{

  private List<ActionFormat> possibleActionFormats;

  public final List<ActionFormat> getPossibleActionFormats() {
    List<ActionFormat> actionFormats = new ArrayList<>();
    actionFormats.addAll(this.possibleActionFormats);
    return actionFormats;
  }
  public GameEngine() {
    // very common
    ActionFormat examine = new ActionFormat("examine", null);
    ActionFormat push = new ActionFormat("push", null);
    ActionFormat take = new ActionFormat("take", null);
    ActionFormat pull = new ActionFormat("pull", null);
    ActionFormat drop = new ActionFormat("drop", null);
    ActionFormat turn = new ActionFormat("turn", null);
    ActionFormat open = new ActionFormat("open", null);
    ActionFormat feel = new ActionFormat("feel", null);
    ActionFormat putIn = new ActionFormat("put", "put ([\\w\\s]+) in ([\\w\\s]+)$");
    ActionFormat putOn = new ActionFormat("put", "put ([\\w\\s]+) on ([\\w\\s]+)$");
    // you could also try
    ActionFormat eat = new ActionFormat("eat", null);
    ActionFormat climb = new ActionFormat("climb", null);
    ActionFormat drink = new ActionFormat("drink", null);
    ActionFormat wave = new ActionFormat("wave", null);
    ActionFormat fill = new ActionFormat("fill", null);
    ActionFormat wear = new ActionFormat("wear", null);
    ActionFormat smell = new ActionFormat("smell", null);
    ActionFormat listenTo = new ActionFormat("listen", "listen to ([\\w\\s]+)$");
    ActionFormat breakIt = new ActionFormat("break", null);
    ActionFormat burn = new ActionFormat("burn", null);
    ActionFormat enter = new ActionFormat("enter", null);
    ActionFormat search = new ActionFormat("search", null);
    ActionFormat unlockWith = new ActionFormat("unlock", "unlock ([\\w\\s]+) with ([\\w\\s]+)$");

    this.possibleActionFormats = List.of(examine, push, take, pull, drop, turn, open, feel, putIn,
        putOn, eat, climb, drink, wave, fill, wear, smell, listenTo, breakIt, burn, enter, search, unlockWith);
  }

  public abstract List<String> possibleItemNames();

  public abstract String progressStory(InstantiatedGameAction gameAction);

  public abstract Room getCurrentRoom();
  public abstract void setCurrentRoom(Room currentRoom);
    // TODO: This should probably use exceptions
  public abstract void addRoom(@NotNull Room room);

  public abstract void addAction(@NotNull Room roomForAction, @NotNull InstantiatedGameAction triggeringAction, @NotNull GameDesignAction effectAction);

  public abstract int getNumRooms();

  public abstract List<Room> findRoom(String roomName);


  public List<ActionFormat> findAction(String trigger){
    return possibleActionFormats.stream()
        .filter(af -> trigger.equals(af.getVerb()))
        .collect(Collectors.toList());
  }
}
