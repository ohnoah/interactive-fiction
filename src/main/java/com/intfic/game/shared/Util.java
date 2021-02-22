package com.intfic.game.shared;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class Util {
   public static <T, S> Map<S, T> collectionToMap(Collection<T> collection, Function<T, S> fn){
      return collection.stream().collect(Collectors.toMap(fn, value -> value));
   }

   public static <T, S> Map<S, List<T>> collectionToMapList(Collection<T> collection, Function<T, S> fn){
      Map<S, List<T>> map = new HashMap<>();
      for(T t : collection){
         S key = fn.apply(t);
         if(map.containsKey(key)){
            map.get(key).add(t);
         }
         else{
            List<T> list = new ArrayList<>();
            list.add(t);
            map.put(key, list);
         }
      }
      return map;
   }

   public static <T, S> Map<S, T> streamToMap(Stream<T> collection, Function<T, S> fn){
      return collection.collect(Collectors.toMap(fn, value -> value));
   }
   public static String formatDuration(Duration duration) {
      long seconds = duration.getSeconds();
      long absSeconds = Math.abs(seconds);
      String positive = String.format(
          "%d:%02d:%02d",
          absSeconds / 3600,
          (absSeconds % 3600) / 60,
          absSeconds % 60);
      return seconds < 0 ? "-" + positive : positive;
   }
}
