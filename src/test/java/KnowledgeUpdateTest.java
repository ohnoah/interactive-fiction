import static org.junit.Assert.*;


import java.util.List;
import org.junit.Test;

public class KnowledgeUpdateTest {

   @Test
   public void stringConstructorUpdateTypeSet() throws KnowledgeException {
      KnowledgeUpdate knowledgeUpdate = new KnowledgeUpdate("_test1::Banana := 4.0");
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
      KnowledgeUpdate knowledgeUpdate = new KnowledgeUpdate("_test1::Banana := 4.0");
      assertEquals(4.0, knowledgeUpdate.getUpdateConstant());
   }

   @Test
   public void stringConstructorConstantStringValue() throws KnowledgeException {
      KnowledgeUpdate knowledgeUpdate = new KnowledgeUpdate("test1::Banana := \"hello, world!\"");
      assertEquals("hello, world!", knowledgeUpdate.getUpdateConstant());
   }

   @Test
   public void stringConstructorConstantDoubleSuccess() throws KnowledgeException {
      KnowledgeUpdate knowledgeUpdate = new KnowledgeUpdate("_test1::Banana := 4.0");
      KnowledgeUpdate knowledgeUpdate1 = new KnowledgeUpdate(UpdateType.SET, "test1", "Banana", "4.0");
      assertEquals(knowledgeUpdate, knowledgeUpdate1);
   }

   @Test
   public void stringConstructorConstantStringSuccess() throws KnowledgeException {
      KnowledgeUpdate knowledgeUpdate = new KnowledgeUpdate("_test1::Banana := \"hello, world!\"");
      KnowledgeUpdate knowledgeUpdate1 = new KnowledgeUpdate(UpdateType.SET, "test1", "Banana", "\"hello, world!\"");
      assertEquals(knowledgeUpdate, knowledgeUpdate1);
   }


   @Test
   public void stringConstructorConstantStringListSuccess() throws KnowledgeException {
      KnowledgeUpdate knowledgeUpdate = new KnowledgeUpdate("_test51::BananaPhone := [\"hello, world!\"]");
      KnowledgeUpdate knowledgeUpdate1 = new KnowledgeUpdate(UpdateType.SET, "test51", "BananaPhone", "[\"hello, world!\"]");
      assertEquals(knowledgeUpdate, knowledgeUpdate1);
   }

   @Test
   public void stringConstructorConstantStringListIsConstant() throws KnowledgeException {
      KnowledgeUpdate knowledgeUpdate = new KnowledgeUpdate("_test51::BananaPhone := [\"hello, world!\"]");
      assertSame(knowledgeUpdate.getSettingType(), KnowledgeUpdate.SettingType.CONSTANT);
   }
   @Test
   public void stringConstructorFrameSettingType() throws KnowledgeException {
      KnowledgeUpdate knowledgeUpdate = new KnowledgeUpdate("_test51::BananaPhone := _test251");
      assertSame(knowledgeUpdate.getSettingType(), KnowledgeUpdate.SettingType.FRAME);
   }

   @Test
   public void stringConstructorKnowledgeSettingType() throws KnowledgeException {
      KnowledgeUpdate knowledgeUpdate = new KnowledgeUpdate("_test51::BananaPhone := _test251::pizza");
      assertSame(knowledgeUpdate.getSettingType(), KnowledgeUpdate.SettingType.KNOWLEDGE);
   }


   @Test
   public void stringConstructorConstantStringListValue() throws KnowledgeException {
      KnowledgeUpdate knowledgeUpdate = new KnowledgeUpdate("_test51::BananaPhone := [\"hello, world!\"]");
      assertEquals(List.of("hello, world!"), knowledgeUpdate.getUpdateConstant());
   }

   @Test
   public void stringConstructorConstantNumberListValue() throws KnowledgeException {
      KnowledgeUpdate knowledgeUpdate = new KnowledgeUpdate("_test51::BananaPhone := [4.0, 1.2312, 1213123]");
      assertEquals(List.of(4.0, 1.2312, 1213123.0), knowledgeUpdate.getUpdateConstant());
   }

   @Test
   public void stringConstructorConstantNumberSuccess() throws KnowledgeException {
      KnowledgeUpdate knowledgeUpdate = new KnowledgeUpdate("_test51::BananaPhone := [4.0, 1.2312, 1213123]");
      KnowledgeUpdate knowledgeUpdate1 = new KnowledgeUpdate(UpdateType.SET, "test51", "BananaPhone", "[4.0, 1.2312, 1213123]");
      assertEquals(knowledgeUpdate, knowledgeUpdate1);
   }

   @Test
   public void stringConstructorRemoveNumberFromList() throws KnowledgeException {
      KnowledgeUpdate knowledgeUpdate = new KnowledgeUpdate("_test51::BananaPhone -= 4.0");
      KnowledgeUpdate knowledgeUpdate1 = new KnowledgeUpdate(UpdateType.SUBTRACT, "test51", "BananaPhone", "4.0");
      assertEquals(knowledgeUpdate, knowledgeUpdate1);
   }

   @Test
   public void stringConstructorFrame() throws KnowledgeException {
      KnowledgeUpdate knowledgeUpdate = new KnowledgeUpdate("_test51::BananaPhone3 *= _test251");
      KnowledgeUpdate knowledgeUpdate1 = new KnowledgeUpdate(UpdateType.MULTIPLY, "test51", "BananaPhone3", "_test251");
      assertEquals(knowledgeUpdate, knowledgeUpdate1);
   }
}