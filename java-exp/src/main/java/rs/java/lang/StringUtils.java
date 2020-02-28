package rs.java.lang;

import java.util.Arrays;
import java.util.List;

public class StringUtils {

  public static void main(String[] args) {
    List<String> fruits = Arrays.asList("Apple", "Banana", "Custard Apple", "Grapes", "Orange", "Plums");
    System.out.println(String.join(" | ", fruits));
  }
}
