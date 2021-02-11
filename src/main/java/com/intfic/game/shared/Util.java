package com.intfic.game.shared;

import java.util.Collection;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class Util {
   public static <T, S> Map<S, T> collectionToMap(Collection<T> collection, Function<T, S> fn){
      return collection.stream().collect(Collectors.toMap(fn, value -> value));
   }
   public static <T, S> Map<S, T> streamToMap(Stream<T> collection, Function<T, S> fn){
      return collection.collect(Collectors.toMap(fn, value -> value));
   }
}
