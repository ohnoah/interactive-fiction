public class KnowledgeRegex {


   // TODO: Test these

   public static String knowledgeExpr;
   public static String setTypeExpr;
   public static String numberExpr;
   public static String stringExpr;
   public static String frameNameExpr;
   static {
      frameNameExpr = "_?[a-zA-Z0-9]+";
      knowledgeExpr = "_?([a-zA-Z0-9]+)::([a-zA-Z0-9]+)";
      numberExpr = "-?[0-9]+(\\.[0-9]+)?";
      stringExpr = "\"[\\s\\w\\p{Punct}]*\"";


      setTypeExpr = "(=|\\+=|-=|\\*=|/=)";
   }

}
