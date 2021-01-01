public class KnowledgeRegex {


   // TODO: Test these

   public static String knowledgeExpr;
   public static String setTypeExpr;
   public static String numberExpr;
   public static String stringExpr;
   static {
      knowledgeExpr = "[_]? [a-zA-Z0-9]* [:] [:] [a-zA-Z0-9]*";
      numberExpr = "'-'? [0-9]+ ( '.' [0-9]+ )? ";
      stringExpr = "[\"] [a-zA-Z_0-9]* [\"]";


      setTypeExpr = "(=|\\+=|-=|\\*=|/=)";
   }

}
