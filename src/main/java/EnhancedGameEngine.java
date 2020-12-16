import java.util.List;

public class EnhancedGameEngine extends GameEngine{

   @Override
   public List<ActionFormat> possibleActionFormats() {
      // very common
      ActionFormat examine = new ActionFormat("examine", null);
      ActionFormat push = new ActionFormat("push", null);
      ActionFormat take = new ActionFormat("take", null);
      ActionFormat pull = new ActionFormat("pull", null);
      ActionFormat drop = new ActionFormat("drop", null);
      ActionFormat turn = new ActionFormat("turn", null);
      ActionFormat open = new ActionFormat("open", null);
      ActionFormat feel = new ActionFormat("feel", null);
      ActionFormat putIn = new ActionFormat("put","put ([\\w\\s]+) in ([\\w\\s]+)$");
      ActionFormat putOn = new ActionFormat("put","put ([\\w\\s]+) on ([\\w\\s]+)$");
      // you could also try
      ActionFormat eat = new ActionFormat("eat", null);
      ActionFormat climb = new ActionFormat("climb", null);
      ActionFormat drink = new ActionFormat("drink", null);
      ActionFormat wave = new ActionFormat("wave", null);
      ActionFormat fill = new ActionFormat("fill", null);
      ActionFormat wear = new ActionFormat("wear", null);
      ActionFormat smell = new ActionFormat("smell", null);
      ActionFormat listenTo = new ActionFormat("listen","listen to ([\\w\\s]+)$");
      ActionFormat breakIt = new ActionFormat("break",null);
      ActionFormat burn = new ActionFormat("burn",null);
      ActionFormat enter = new ActionFormat("enter",null);
      ActionFormat search = new ActionFormat("search",null);
      ActionFormat unlockWith = new ActionFormat("unlock","unlock ([\\w\\s]+) with ([\\w\\s]+)$");

      return List.of(examine, push, take, pull, drop, turn, open, feel, putIn,
          putOn, eat, climb, drink, wave, fill, wear, smell, listenTo, breakIt, burn, enter, search, unlockWith);
   }

   @Override
   public List<String> possibleItemNames() {
      return null;
   }

   @Override
   public String progressStory(InstantiatedGameAction gameAction) {
      return null;
   }
}
