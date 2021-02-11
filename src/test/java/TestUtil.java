import com.intfic.game.shared.GameEngine;
import com.intfic.game.shared.Item;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public class TestUtil {


   public static Set<Item> stringsToItemsNoAdj(Collection<String> strings){
      return (strings.stream().map(Item::new).collect(Collectors.toSet()));
   }

   public static Item findItem(Collection<Item> items, String name){
      return items.stream().filter(item -> item.getName().equals(name)).findFirst().orElseThrow(RuntimeException::new);
   }

   public static Item findPossibleItem(GameEngine gameEngine, String name){
      return findItem(gameEngine.possibleItems(), name);
   }
}
