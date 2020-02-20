package rs.java.lang;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IntArrayToStrArray {
	
	public static void main(String[] args) {
		int[] intArr = {3,6,8,2,4,7};
		
		List<String> strArr = Arrays.stream(intArr).mapToObj(String::valueOf).collect(Collectors.toList());
		
		System.out.println(strArr.size());
		strArr.add("9");
		System.out.println(strArr.size());
	}

}
