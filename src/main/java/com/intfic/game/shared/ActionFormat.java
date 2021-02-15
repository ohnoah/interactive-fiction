package com.intfic.game.shared;

import java.io.Serializable;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ActionFormat implements Serializable {
   /* private static final long serialVersionUID = -7020054998734425443L;*/
   private String verb;
   private String regExpr;


   public ActionFormat(String verb) {
      this.verb = verb;
   }

   public ActionFormat(String verb, String regExpr) {
      this.verb = verb;
      this.regExpr = regExpr;
   }

   // TODO: Generalize
   public int getDegree() {
      if (regExpr == null) {
         return 1;
      }
      else {
         return (int) regExpr.chars().filter(c -> c == '(').count();
      }

   }

   public boolean isTernary() {
      return regExpr != null;
   }

   public String getVerb() {
      return verb;
   }

   public void setVerb(String verb) {
      this.verb = verb;
   }

   public String getRegExpr() {
      return regExpr;
   }

   public void setRegExpr(String regExpr) {
      this.regExpr = regExpr;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      ActionFormat that = (ActionFormat) o;
      return getVerb().equals(that.getVerb()) &&
          Objects.equals(getRegExpr(), that.getRegExpr());
   }

   @Override
   public int hashCode() {
      return Objects.hash(getVerb(), getRegExpr());
   }

   @Override
   public String toString() {
      if (regExpr != null) {
         Pattern p = Pattern.compile("([(](?!\\?\\:)[\\w\\p{Punct}]*)[)]");
         AtomicInteger filler = new AtomicInteger();
         Matcher m = p.matcher(regExpr);
         return m.replaceAll(match -> "[" + filler.getAndIncrement() + "]");
      }
      else{
         return this.getVerb() + " [0]";
      }
   }
}
