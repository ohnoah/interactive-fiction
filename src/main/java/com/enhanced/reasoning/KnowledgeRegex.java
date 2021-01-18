package com.enhanced.reasoning;

import java.io.Serializable;

public class KnowledgeRegex implements Serializable {


   private static final long serialVersionUID = 1218079511357784575L;
   // TODO: Test these

   public static String knowledgeExpr;
   public static String setTypeExpr;
   public static String numberExpr;
   public static String stringExpr;
   public static String frameNameExpr;
   public static String stringListExpr;
   public static String numberListExpr;
   public static String largeCaptureKnowledgeExpr;
   public static String loneFrameNameExpr;
   static {
      frameNameExpr = "_?([a-zA-Z0-9-]+)";
      loneFrameNameExpr = "_([a-zA-Z0-9-]+)(?!::)";
      knowledgeExpr = "_?([a-zA-Z0-9-]+)::([a-zA-Z0-9]+)";
      largeCaptureKnowledgeExpr = "_?([a-zA-Z0-9-]+::[a-zA-Z0-9]+)";
      numberExpr = "-?[0-9]+(?:\\.[0-9]+)?";
      stringExpr = "\"[\\s\\w\\p{Punct}]*\"";
      stringListExpr = "\\[(?:" + stringExpr + "(?:, " + stringExpr   + ")*)?\\]";
      numberListExpr = "\\[(?:" + numberExpr + "(?:, " + numberExpr   + ")*)?\\]";


      setTypeExpr = "(:=|\\+=|-=|\\*=|/=)";
   }

}
