package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

class MyComparator implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		// TODO Auto-generated method stub
		return o2.getName().compareTo(o1.getName());
	}
	
}
class Employee {
	private String name;
	private Double salary;
	private Integer employeeId;
	private String department;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public Employee(String name, Double salary, Integer employeeId, String department) {
		super();
		this.name = name;
		this.salary = salary;
		this.employeeId = employeeId;
		this.department = department;
	}
	
	public int compareTo(Employee e) {
		return this.name.compareTo(e.name);
	}
	
	public Employee() {
		super();
	}
	
}
public class Test {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> myList = Arrays.asList(6,4,7,89,65,3,67,89,60,91,95,100,50);
		myList.stream().sorted(Comparator.reverseOrder()).limit(3).skip(2).findFirst().ifPresent(System.out::println);
		List<Employee> empList = new ArrayList();
		
		empList.add(new Employee("Souvik",19.5,999,"IT"));
		empList.add(new Employee("Sourav",19.0,900,"Finance"));
		empList.add(new Employee("Abir",15.5,911,"HR"));
		empList.add(new Employee("Pratik",21.0,555,"IT"));
		empList.add(new Employee("Mainak",14.3,944,"Finance"));
		empList.add(new Employee("Santu",17.6,222,"IT"));
		empList.add(new Employee("Santu",17.2,212,"HR"));
		System.out.println("-------------------------------");
		//sort the user by name
		System.out.println("sort the user by name -");
		/*
		 * Collections.sort(empList); 
		 * System.out.println("Using comparable -"+empList);
		 */
		/*
		 * Collections.sort(empList,new MyComparator());
		 * empList.stream().forEach(emp->System.out.println(emp.getName()));
		 */
		
		System.out.println("Finding employees whose salary > 19L");
		empList.stream().filter(x -> x.getSalary()>19).forEach(x -> System.out.println("Emp -"+ x.getName()));
		
		Comparator<Employee> com = Comparator.comparing(Employee::getName, (name1,name2) -> {
			return (name1.compareTo(name2));
		});
		Collections.sort(empList, com);
		empList.stream().forEach(emp->System.out.println(emp.getName()));
		
		
		empList.stream().sorted((emp1, emp2) ->{
				return (emp1.getName().compareTo(emp2.getName()));
		}).forEach(emp -> System.out.println("--"+emp.getName()));
		
		System.out.println("find the highest paid emp from each dept");
		
		Map<String,Optional<Employee>> empGroup1 = empList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))));		
		
		Set<String> keys = empGroup1.keySet();
		for(String dept : keys)
			empGroup1.get(dept).ifPresent(emp -> System.out.println(emp.getName() +"::"+emp.getDepartment()));
		
		Map<String, Employee> empGroup = empList.stream().collect(Collectors.groupingBy(Employee::getDepartment,
				Collectors.collectingAndThen(
						Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)), Optional::get )));
		empGroup.keySet().forEach(e -> System.out.println(e + ":" + empGroup.get(e).getName()));
		
		//sort in the order of salary
		empList.stream().sorted((e1,e2) -> {
			 if(e1.getSalary() > e2.getSalary())
				return -1;
				else if(e1.getSalary() == e2.getSalary())
					return 0;
				else return 1;
		}).forEach(emp -> System.out.println(emp.getName() + ":"+emp.getSalary()));
		
		//show top3 in the order of salary
		empList.stream().sorted((e1,e2) -> {
			 if(e1.getSalary() > e2.getSalary())
				return -1;
				else if(e1.getSalary() == e2.getSalary())
					return 0;
				else return 1;
		}).limit(3).forEach(emp -> System.out.println(emp.getName() + ":"+emp.getSalary()));
		
		// sum of salary
			Double totalSalary = empList.stream().collect(Collectors.summingDouble(Employee::getSalary));
				System.out.println("total Salary: "+totalSalary);
		// adding all strings together
				System.out.println(empList.stream().map( emp ->
						emp.getName().toUpperCase()).collect(Collectors.joining(" ")));
		
		// Highest paid employee
			empList.stream().collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))).ifPresent(emp -> System.out.println("Highest Paid Emp-"+emp.getName()+":"+emp.getSalary()));

		// 2nd Highest paid employee
			empList.stream().sorted((e1,e2) -> {
				 if(e1.getSalary() > e2.getSalary())
					return -1;
					else if(e1.getSalary() == e2.getSalary())
						return 0;
					else return 1;
			}).limit(2).skip(1).findFirst().ifPresent(emp -> System.out.println("2nd Highest Paid Emp-"+emp.getName()+":"+emp.getSalary()));
			
			
			
			//------------------------------------------
			//No of occurrence of words
			String input = "welcome to code decode and code decode welcome you";
			List<String> inputList = Arrays.asList(input.split(" "));
			Map<String,Long> inputMap = inputList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
			System.out.println(inputMap);
			
			// duplicate in list of integers
			List<Integer> myList2 = Arrays.asList(10,28,87,10,20,76,28,80);
			Set<Integer> uniqSet = new HashSet<Integer>();
			myList2.stream().filter(n -> !uniqSet.add(n)).forEach(System.out::println);
			
			// reverse,check only odd,max in the Integer list
			List<Integer> myList3 = Arrays.asList(10,28,87,10,20,76,28,80,90);
			myList3.stream().sorted((i1,i2) -> {
				return (i2-i1);
			}).forEach(System.out::println);
			
			Boolean evenPresent = myList3.stream().anyMatch(x -> (x%2)==0);
			System.out.println("even present-"+evenPresent);
			
			System.out.println("max -"+myList3.stream().sorted(Collections.reverseOrder()).limit(1).findFirst().get());
			System.out.println();
			myList3.stream().mapToInt(x ->x).max().ifPresent(e -> System.out.println("Max In the List " +e));
			
			String s = "THIS IS TEST";
			Map<Character, Long> charCountMap = new HashMap();
			List<Character> list = s.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
	        System.out.println("List of characters" +list);
	        //list.stream().forEach(c -> charCountMap.merge(c, 1, Integer::sum));
	        charCountMap = list.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
	        System.out.println(charCountMap);
	        
	        IFinterface finterface = (a,b) -> {
	        	return a*b;
	        };

	        System.out.println(finterface.multiply(4,5));
	        
	        String s1 = new String("abc");//.intern();
	        String s2 = "abc";
	        System.out.println(s1 == s2);
	}

}
