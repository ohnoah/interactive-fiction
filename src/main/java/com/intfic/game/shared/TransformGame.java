package com.intfic.game.shared;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class TransformGame {

   private static String appendWorld(String line) {
      if (line.matches("[\\w]*")) {
         return line;
      }
      List<String> splitList = Util.splitByCommaAndTrim(line);
      splitList = splitList.stream().map(l -> "world::" + l).collect(Collectors.toList());
      return String.join(",", splitList);
   }
   private static String makeString(String s){
      String[] parts = s.split("=");
      String secondPart = parts[1];
      if (!(parts[1].equals("true") || parts[1].equals("false") || parts[1].equals("TRUE") || parts[1].equals("FALSE"))) {
         secondPart = "\"" + secondPart + "\"";
      }
      return (parts[0] + " := " + secondPart);
   }

   private static String commentRegex = "%[\\w\\p{Punct}\\s]*";

   public static void main(String[] args) throws IOException {
      File file = new File("enhanced-game-REPLACED.txt");
      boolean result = Files.deleteIfExists(file.toPath());
      file.createNewFile();
      BufferedReader reader;
      try {
         reader = new BufferedReader(new FileReader("basic-game.txt"));
         String line = reader.readLine();
         boolean searching = true;
         int searchLine = 0;
         String newLine;
         while (line != null) {
/*            while (line != null && line.startsWith("!")) {
               Files.write(file.toPath(), List.of(line), StandardOpenOption.APPEND);
               line = reader.readLine();
            }*/
            newLine = line.replaceAll("NULL", "false");

            if(line.contains("|")){
               newLine = appendWorld(newLine);
            }
            else if(line.contains("=")){
               newLine = appendWorld(newLine);
               String[] commas = newLine.split(",");
               List<String> statements = new ArrayList<>();
               for(String s : commas) {
                  statements.add(makeString(s));
               }
               newLine = String.join(",", statements);
            }
/*            if (searching) {
               if (line.matches("\\w*add action\\w*")) {
                  searchLine = 4;
                  searching = false;
               }
            }
            else {
               if (searchLine > 0) {
                  searchLine--;
               }
               else {
                  if (!line.matches(commentRegex) && (line.contains("|") || line.equals(""))) {
                     System.out.println("PRECOND:" + line);
                     newLine = appendWorld(line);
                     System.out.println("PRECOND EDIT:" + newLine);

                     Files.write(file.toPath(), List.of(newLine), StandardOpenOption.APPEND);

                     // POST CONDS
                     line = reader.readLine();
                     while (line.startsWith("%") || !line.contains("=")) {
                        Files.write(file.toPath(), List.of(line), StandardOpenOption.APPEND);
                        line = reader.readLine();
                     }
                     System.out.println("POSTCOND: " + line);
                     newLine = appendWorld(line);
                     newLine = newLine.replaceAll("=", " := ");
                     newLine = appendWorld(line);
                     System.out.println("POSTCOND: " + newLine);


                     searching = true;

                  }
               }
            }*/
            Files.write(file.toPath(), List.of(newLine), StandardOpenOption.APPEND);
            line = reader.readLine();
         }
         reader.close();
      }
      catch (IOException e) {
         e.printStackTrace();
      }
   }
}
