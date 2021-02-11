import com.intfic.game.shared.GameEngine;
import com.intfic.game.shared.Item;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

class TestUtil {


   static Set<Item> stringsToItemsInRoomNoAdj(Collection<String> strings){
      return (strings.stream().map(Item::new).collect(Collectors.toSet()));
   }

   static Item findItem(Collection<Item> items, String name){
      return items.stream().filter(item -> item.getName().equals(name)).findFirst().orElseThrow(RuntimeException::new);
   }

   static Item findPossibleItemFromNoun(GameEngine gameEngine, String name){
      return findItem(gameEngine.possibleItems(), name);
   }

   static Item roomItem(String noun){
      return new Item(noun);
   }

   static Item roomItem(String noun, Set<String> adjectives){
      return new Item(noun, adjectives);
   }
}
