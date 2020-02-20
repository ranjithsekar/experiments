package rs.java.util.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMap {

  public static void main(String[] args) {
    streamReverse();
  }

  public static void streamReverse() {
    List<Fruit> fruitsObj = Arrays.asList(new Fruit("Apple", 100), new Fruit("Banana", 200), new Fruit("Grapes", 300),
        new Fruit("Orange", 400));
    List<Fruit> fruitsObjUnOrdered = Arrays.asList(new Fruit("Apple", 100), new Fruit("Banana", 200),
        new Fruit("Orange", 400), new Fruit("Grapes", 300));

    String names = fruitsObj.stream().map(e -> e.getName()).collect(Collectors.joining("/"));
    System.out.println(names);
    String namesR = fruitsObj.stream().sorted(Comparator.comparing(Fruit::hashCode).reversed()).map(e -> e.getName())
        .collect(Collectors.joining("/"));
    System.out.println(namesR);
  }

  public static void exp2() {
    boolean contains = Stream.of(new String[] { "ti", "wr", "pn", "pd" }).anyMatch("wr"::equalsIgnoreCase);
    // System.out.println(contains);

    String[] str = new String[] { "name=ranjith" };
    Map<String, String> map = Stream.of(str).map(e -> e.split("=")).collect(Collectors.toMap(a -> a[0], a -> a[1]));
    map.forEach((k, v) -> System.out.println("key: " + k + " value:" + v));

  }

  public static void exp1() {

    List<String> fruits = Arrays.asList("Apple", "Orange", "Grapes", "Banana");

    List<Fruit> fruitsObj = Arrays.asList(new Fruit("Apple", 100), new Fruit("Orange", 200));

    List<String> modified = fruitsObj.stream().map(e -> e.getName()).collect(Collectors.toList());

    System.out.println(modified);

  }
}

class Fruit {
  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  private int price;

  public Fruit() {

  }

  public Fruit(String name, int price) {
    this.name = name;
    this.price = price;
  }
}
