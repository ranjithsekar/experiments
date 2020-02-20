package rs.java.lang;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringUtilsCommons {

	public static void main(String[] args) {
		String st = "ab,ls,cd";
		System.out.println(Stream.of(st.split(",")).filter(e -> !e.equalsIgnoreCase("ls")).collect(Collectors.joining(",")));
	}
}
