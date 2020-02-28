package rs.java.util.streams;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class StreamList {

  public static void main(String[] args) {
    final int chunkSize = 2;
    List<String> fruits = Arrays.asList("Apple", "Banana", "Custard Apple", "Grapes", "Orange", "Plums");
    System.out.println(fruits.stream().limit(3).collect(Collectors.toList()));
    final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

    final AtomicInteger counter = new AtomicInteger();
    final Collection<List<Integer>> result = numbers.stream()
        .collect(Collectors.groupingBy(it -> counter.getAndIncrement() / chunkSize)).values();

    System.out.println(result);
  }
}
