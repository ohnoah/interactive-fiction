package com.intfic.game.enhanced.reasoning;

import java.io.Serializable;

public class KnowledgeRegex implements Serializable {


   private static final long serialVersionUID = 1218079511357784575L;
   // TODO: Test these

   public static String KNOWLEDGE_EXPR;
   public static String SET_TYPE_EXPR;
   public static String NUMBER_EXPR;
   public static String STRING_EXPR;
   public static String FRAME_NAME_EXPR;
   public static String STRING_LIST_EXPR;
   public static String NUMBER_LIST_EXPR;
   public static String LARGE_CAPTURE_KNOWLEDGE_EXPR;
   public static String LONE_FRAME_NAME_EXPR;

   static {
      // TODO: These need to be changed to only allow DOT In middle
      FRAME_NAME_EXPR = "!?([a-zA-Z0-9_.]+)";
      LONE_FRAME_NAME_EXPR = "!([a-zA-Z0-9_.]+)(?!::)";
      KNOWLEDGE_EXPR = "!?([a-zA-Z0-9_.]+)::([a-zA-Z0-9]+)";
      LARGE_CAPTURE_KNOWLEDGE_EXPR = "!?([a-zA-Z0-9_]+::[a-zA-Z0-9]+)";
      NUMBER_EXPR = "-?[0-9]+(?:\\.[0-9]+)?";
      STRING_EXPR = "\"[\\s\\w\\p{Punct}]*\"";
      STRING_LIST_EXPR = "\\[(?:" + STRING_EXPR + "(?:, " + STRING_EXPR + ")*)?\\]";
      NUMBER_LIST_EXPR = "\\[(?:" + NUMBER_EXPR + "(?:, " + NUMBER_EXPR + ")*)?\\]";


      SET_TYPE_EXPR = "(:=|\\+=|-=|\\*=|/=)";
   }

}
