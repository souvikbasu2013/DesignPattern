package com.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Java8prog {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Employee> empList = new ArrayList<Employee>();
		
		empList.add(new Employee(101,"Souvik", 9001, 1000.00, "Active"));
		empList.add(new Employee(102,"Arun", 9002, 577.00, "Active"));
		empList.add(new Employee(103,"Suraj", 9003, 679.50, "Active"));
		empList.add(new Employee(104,"Minil", 9001, 970.00, "Inactive"));
		empList.add(new Employee(105,"Ankita", 9003, 1158.00, "Active"));
		empList.add(new Employee(106,"Pravin", 9001, 679.00, "Inactive"));
		empList.add(new Employee(107,"Rakesh", 9002, 980.00, "Active"));
		
		System.out.println("print all employee names in uppercase seperated by comma in the order of their salary");
		
		System.out.print(empList.stream().sorted((x,y) -> {
			if( x.getSalary() > y.getSalary()) return 1;
			else if ( x.getSalary() == y.getSalary()) return 0;
			else return -1;
			}).map(emp -> emp.getEmpName()).map(String::toUpperCase).collect(Collectors.joining(",")));
		System.out.println();
		System.out.println("print employee details working in each department");
		
		Map<Integer, List<Employee>> empListByDept = empList.stream().collect(Collectors.groupingBy(Employee::getDeptId));
		empListByDept.keySet().forEach(dept -> System.out.println("dept:"+dept + " "+empListByDept.get(dept)));
		
		System.out.println("print employee count working in each department");
		Map<Integer, Long> empCountByDept = empList.stream().collect(Collectors.groupingBy(Employee::getDeptId, Collectors.counting()));
		empCountByDept.keySet().forEach(dept -> System.out.println("dept:"+dept + " "+empCountByDept.get(dept)));
		
		System.out.println("print active/inactive employees in the collection");
		Map<Boolean, List<Employee>> empListByStatus = empList.stream().collect(Collectors.partitioningBy(emp -> emp.getStatus().equals("Active")));
		empListByStatus.keySet().forEach(status -> System.out.println("Status:"+status + " "+empListByStatus.get(status)));
		
		System.out.println("print Max/Min salary in the given collection");
		System.out.println("Max Salary: "+empList.stream().map(Employee::getSalary).max(Double::compare));
		System.out.println("Min Salary: "+empList.stream().map(Employee::getSalary).min(Double::compare));
		
		System.out.println("print Max salary of employee from each department");
		Map<Integer, Optional<Employee>> empListBySalDept = empList.stream().collect(Collectors.groupingBy(Employee::getDeptId,Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))));
		empListBySalDept.keySet().forEach(dept -> System.out.println("dept:"+dept + " "+empListBySalDept.get(dept)));
		
		System.out.println("print Sum of salary of all department");
		System.out.println("total Salary:"+empList.stream().collect(Collectors.summingDouble(Employee::getSalary)));
		
		System.out.println("print Sum of salary of each department");
		Map<Integer, Double> empSalByDept = empList.stream().collect(Collectors.groupingBy(Employee::getDeptId,Collectors.summingDouble(Employee::getSalary)));
		empSalByDept.keySet().forEach(dept -> System.out.println("dept: "+dept + " total Salary: "+empSalByDept.get(dept)));
		
		System.out.println("sort emp on basis of their salary in desc order");
		empList.stream().sorted((x,y) -> {
			if( x.getSalary() > y.getSalary()) return -1;
			else if ( x.getSalary() == y.getSalary()) return 0;
			else return 1;
		})/* .limit(3).skip(2) */.collect(Collectors.toList()).forEach(emp -> System.out.println(emp.getEmpName()+":"+emp.getSalary()));

		System.out.println("Highest salary and total salary");
		DoubleSummaryStatistics stat = empList.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
		System.out.println("Highest salary ->" + stat.getMax()+ " total salary -> "+ stat.getSum());
		
		
		/*
		 * String name = "souvikbasu"; Map<String, Long> charCount =
		 * Arrays.stream(name.split("")).collect(Collectors.groupingBy(Function.identity
		 * (),LinkedHashMap::new,Collectors.counting()));
		 * //charCount.keySet().forEach(null) System.out.println(charCount);
		 * charCount.keySet().stream().filter(x ->
		 * charCount.get(x)==1).forEach(System.out::print);
		 */
		
		String[] strArray = {"this","is","java","programming","language"};
		Map<String, List<String>> strArrayGrp = Arrays.stream(strArray).collect(Collectors.groupingBy(Function.identity()));
		//charCount.keySet().forEach(null)
		System.out.println(strArrayGrp);
		
		Arrays.stream(strArray).sorted((x,y) -> {
			return  y.length() - x.length();
		}).limit(1).findAny().ifPresent(word -> System.out.println(word+":"+word.length()));
	}

}
