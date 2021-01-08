import static org.junit.Assert.*;


import org.junit.Test;

public class KnowledgeUpdateTest {

   @Test
   public void stringConstructorUpdateTypeSet() throws KnowledgeException {
      KnowledgeUpdate knowledgeUpdate = new KnowledgeUpdate("_test1::Banana = 4.0");
      assertEquals(UpdateType.SET, knowledgeUpdate.getUpdateType());
   }

   @Test
   public void stringConstructorUpdateTypeMultiply() throws KnowledgeException {
      KnowledgeUpdate knowledgeUpdate = new KnowledgeUpdate("_test1::Banana *= _pizzaa::Pie1");
      assertEquals(UpdateType.MULTIPLY, knowledgeUpdate.getUpdateType());
   }

   @Test
   public void stringConstructorUpdateTypeAdd() throws KnowledgeException {
      KnowledgeUpdate knowledgeUpdate = new KnowledgeUpdate("_test1::Banana += -4.0");
      assertEquals(UpdateType.ADD, knowledgeUpdate.getUpdateType());
   }

   @Test
   public void stringConstructorUpdateTypeSubtract() throws KnowledgeException {
      KnowledgeUpdate knowledgeUpdate = new KnowledgeUpdate("test1::Banana -= _test2::Apple");
      assertEquals(UpdateType.SUBTRACT, knowledgeUpdate.getUpdateType());
   }

   @Test
   public void stringConstructorConstantDoubleValue() throws KnowledgeException {
      KnowledgeUpdate knowledgeUpdate = new KnowledgeUpdate("_test1::Banana = 4.0");
      assertEquals(4.0, knowledgeUpdate.getUpdateConstant());
   }

   @Test
   public void stringConstructorConstantStringValue() throws KnowledgeException {
      KnowledgeUpdate knowledgeUpdate = new KnowledgeUpdate("test1::Banana = \"hello, world!\"");
      assertEquals("hello, world!", knowledgeUpdate.getUpdateConstant());
   }

   @Test
   public void stringConstructorConstantDoubleSuccess() throws KnowledgeException {
      KnowledgeUpdate knowledgeUpdate = new KnowledgeUpdate("_test1::Banana = 4.0");
      KnowledgeUpdate knowledgeUpdate1 = new KnowledgeUpdate(UpdateType.SET, "test1", "Banana", "4.0");
      assertEquals(knowledgeUpdate, knowledgeUpdate1);
   }

   @Test
   public void stringConstructorConstantStringSuccess() throws KnowledgeException {
      KnowledgeUpdate knowledgeUpdate = new KnowledgeUpdate("_test1::Banana = \"hello, world!\"");
      KnowledgeUpdate knowledgeUpdate1 = new KnowledgeUpdate(UpdateType.SET, "test1", "Banana", "\"hello, world!\"");
      assertEquals(knowledgeUpdate, knowledgeUpdate1);
   }

}