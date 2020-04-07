package rs.java.lang;

import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

public class StringOperations {

  public static void main(String[] args) {
    String separator = "\\";
    String value = "a\\Main\\text.txt";
    value = StringUtils.remove(value, "\\" + "Main");
    String[] arrValues = value.split("\\\\");
    for(String s: arrValues) {
      System.out.println(s);
    }
  }
}
