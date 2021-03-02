package com.intfic.game.shared;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class TransformGame {


   public static void main(String[] args) throws IOException {
      File file = new File("enhanced-game-REPLACED.txt");
      file.createNewFile();
      BufferedReader reader;
      try {
         reader = new BufferedReader(new FileReader("basic-game.txt"));
         String line = reader.readLine();
         boolean searching = true;
         int searchLine = 0;
         String newLine;
         while (line != null) {
            newLine = line;
            if(searching){
               if(line.matches("\\w*add action\\w*")){
                  searchLine = 4;
                  searching = false;
               }
            }
            else{
               if(searchLine > 0) {
                  searchLine--;
               }
               else{
                  if(!line.matches("%[\\w\\p{Punct}\\s]*") && line.contains("|")){
                     System.out.println(line);
                     List<String> splitList = Util.splitByCommaAndTrim(line);
                     splitList = splitList.stream().map(l -> "world::" +l ).collect(Collectors.toList());
                     newLine = String.join(",", splitList);
                     System.out.println(newLine);
                     searching = true;
                  }
               }
            }
            Files.write(file.toPath(), List.of(newLine), StandardOpenOption.APPEND);
            line = reader.readLine();
         }
         reader.close();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
}
