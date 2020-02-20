package rs.java.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateParser {

  public static void main(String[] args) throws Exception {
    String input = "2019/12/09";
    Date inputDate = new SimpleDateFormat("MM/dd/yyyy").parse(input);
    System.out.println(inputDate);
    // DSate inputDatConv = new SimpleDateFormat("yyyy-MM-dd").format(inputDate);
    String feedDate = new SimpleDateFormat("yyyy/MM/dd").format(inputDate);

  }
}
