package rs.java.lang;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExExample {

  public static void main(String[] args) {
    String regex = "^(.{5})(.{3})(.*)$";
    String input = "";
    Pattern patern = Pattern.compile(regex);
    Matcher m = patern.matcher(input);

    if (m.find()) System.out.println(m.group(1) + " " + m.group(2) + " " + m.group(3));
  }
}
