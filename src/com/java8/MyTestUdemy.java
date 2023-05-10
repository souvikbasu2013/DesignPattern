package com.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MyTestUdemy {
	
	public static void main(String[] args) {

		//printAllNumbersInListStructured(List.of(12,9,13,4,6,2,4,12,15));	
		//printAllCourse(List.of("Spring","Spring Boot","Microservice","AWS","Docker","Kubernates","JPA Spring"));
		//printRepeatedWordsCount(List.of("A","AB","XW","PQ","XW","AB","MN","AB","G","A","A","A"));
		//printFlatMapExample();
		
	}

	private static void printAllCourse(List<String> courses) {
		// TODO Auto-generated method stub
		courses.stream().filter(course -> course.contains("Spring")).forEach(System.out::println);
		courses.stream().filter(course -> course.length()>=4).forEach(System.out::println);
	}

	private static void printAllNumbersInListStructured(List<Integer> numbers) {
		// TODO Auto-generated method stub
		//Square of even numbers
		numbers.stream().filter(num -> (num%2==0)).map(num -> num*num).forEach(System.out::println);
	}
	
	private static void printRepeatedWordsCount(List<String> words) {
		
	Map<String, Long> result = words.stream().filter(s -> Collections.frequency(words,s) > 1).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
	System.out.println(result);
	}
	
	private static void printFlatMapExample() {
		List<String> firstName = Arrays.asList("Amal","Kunal","Ravi");
		List<String> middleName = Arrays.asList("Kumar","Arun","Sankar");
		List<String> lastName = Arrays.asList("Roy","Varma","Tripathi");
		
		List<List<String>> fullName = new ArrayList<List<String>>();
		fullName.add(firstName);
		fullName.add(middleName);
		fullName.add(lastName);
		
		System.out.println(fullName.stream().flatMap(lst -> lst.stream()).collect(Collectors.joining(",")));
		
		
	}

}
