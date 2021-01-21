package com.intfic.game.enhanced;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileErrorHandler {
   public static boolean firstError = true;
   private static String errorLogHeader = "\n" + DateTimeFormatter.ofPattern("yyyyMMdd-HH:mm").format(LocalDateTime.now()) + "\n";
   private static String errorLogFName = "error-log.txt";

   private static File loadFile() throws IOException {
      System.err.println("----------Writing error to log-----------");
      System.err.println("-----------------------------------------");
      System.err.println("-----------------------------------------");
      System.err.println("-----------------------------------------");
      File file = new File(errorLogFName);
      file.createNewFile();
      if (firstError) {
         Files.write(file.toPath(), errorLogHeader.getBytes(), StandardOpenOption.APPEND);
      }
      firstError = false;
      return file;
   }

   public static void printExceptionToLog(Exception e) {
      try {
         File file = loadFile();
         FileWriter fw = new FileWriter(file, true);
         PrintWriter pw = new PrintWriter(fw);
         e.printStackTrace(pw);
         Files.write(file.toPath(), (e.getMessage() + "\n").getBytes(), StandardOpenOption.APPEND);
      } catch (IOException openException) {
         System.err.println("Couldn't write to error");
         e.printStackTrace();
         openException.printStackTrace();
      }
   }


   public static void printToErrorLog(String s) {
      try {
         File file = loadFile();
         Files.write(file.toPath(), (s + "\n").getBytes(), StandardOpenOption.APPEND);
      } catch (IOException e) {
         System.err.println("Couldn't write to error");
         System.err.println(s);
         e.printStackTrace();
      }
   }

}
