package rs.java.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetExamp {

  public static void main(String[] args) {
    List<String> a = Arrays.asList("4,7,2,4,3,5".split(","));
    Set<String> set = new HashSet<>(a);
    set.addAll(Arrays.asList("4,7,3,5,1".split(",")));
    System.out.println(set);
    System.out.println(String.join(",",set));
    
    String s = "4,7,2,4,3,5" + "," + "4,7,3,5,1,6";
    
  }
}
