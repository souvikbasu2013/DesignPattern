package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AniInterview {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Remove null values from list...");
		
		List<String> removeNullString = new ArrayList<String>(Arrays.asList("A", null, "B", "C", null, null, "D","E"));
		//using java 8
		List<String> removeNullString1 = removeNullString.stream().filter(x-> (x !=null)).collect(Collectors.toList());
		System.out.println(removeNullString1);
		removeNullString.removeIf(x -> x==null);
		System.out.println(removeNullString);
		
		System.out.println("In a char array A -E is present. convert them to a string with +");
		Character[] arr = {'A','B','C','D','E'};
		System.out.println(Stream.of(arr).map(String::valueOf).collect(Collectors.joining("+")));
		
		System.out.println("In an array list your name is present as a char. Count the occurrence of each letter");
		
		ArrayList<Character> name = new ArrayList<Character>(Arrays.asList('S','O','U','V','I','K', 'B', 'A','S','U'));
		Map<Character, Long> letterCount = name.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(letterCount);
		
		System.out.println("remove duplicate values from a list");
		List<Integer> myList = Arrays.asList(6,4,7,89,65,3,67,89,60,91,95,100,50);
		myList.stream().distinct().forEach(x-> System.out.println(x));
		myList.stream().mapToInt(n ->n).max().ifPresent(x -> System.out.println("max in the list -"+x));
	}

}
