package rs.java.util;
import java.io.File;
import java.util.Scanner;

public class FileScanner {

  public static void main(String[] args) throws Exception {
    Scanner scanner = new Scanner(new File("test.txt"));
    int line=0;
    while (scanner.hasNext()) {
      String s = scanner.next();
      if (s.equalsIgnoreCase("Ranjith")) {
      }
    }
  }
}
