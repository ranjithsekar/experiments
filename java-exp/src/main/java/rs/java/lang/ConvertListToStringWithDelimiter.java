package rs.java.lang;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class ConvertListToStringWithDelimiter {

  public static void main(String[] args) {
    List<String> ids = new ArrayList<String>();
    ids.add("1");
    ids.add("2");
    ids.add("3");
    ids.add("4");

    System.out.println(StringUtils.join(ids, "/"));
  }
}
