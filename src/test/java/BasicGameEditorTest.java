import static org.junit.Assert.*;


import com.intfic.game.basic.BasicGameEditor;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.junit.Test;

public class BasicGameEditorTest {

   @Test
   public void testNamesPlainString() {
      String test = "bear, bread, pizza, donkey";
      BasicGameEditor basicGameEditor = new BasicGameEditor();
      List<String> names = new ArrayList<>();
      List<Set<String>> adj = new ArrayList<>();
      basicGameEditor.itemNamesAndAdjectives(test, names, adj);
      assertEquals(names, List.of("bear", "bread","pizza", "donkey"));
   }
   @Test
   public void testValidMixedString() {
      String test = "bear [fuzzy brown pink], bread, pizza [tomato yellow], donkey [grey]";
      BasicGameEditor basicGameEditor = new BasicGameEditor();
      List<String> names = new ArrayList<>();
      List<Set<String>> adj = new ArrayList<>();
      boolean valid = basicGameEditor.itemNamesAndAdjectives(test, names, adj);
      assertTrue(valid);
   }
   @Test
   public void testNamesMixedString() {
      String test = "bear [fuzzy brown pink], bread, pizza [tomato yellow], donkey [grey]";
      BasicGameEditor basicGameEditor = new BasicGameEditor();
      List<String> names = new ArrayList<>();
      List<Set<String>> adj = new ArrayList<>();
      boolean valid = basicGameEditor.itemNamesAndAdjectives(test, names, adj);
      assertEquals(names, List.of("bear", "bread","pizza", "donkey"));
   }
   @Test
   public void testAdjMixedString() {
      String test = "bear [fuzzy brown pink], bread, pizza [tomato yellow], donkey [grey]";
      BasicGameEditor basicGameEditor = new BasicGameEditor();
      List<String> names = new ArrayList<>();
      List<Set<String>> adj = new ArrayList<>();
      boolean valid = basicGameEditor.itemNamesAndAdjectives(test, names, adj);
      assertEquals(List.of(Set.of("fuzzy", "brown", "pink"), Set.of(), Set.of("tomato", "yellow"), Set.of("grey")), adj);
   }
}