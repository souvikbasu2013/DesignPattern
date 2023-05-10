package com.java8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
class TestEmployee {
	private String name;
	private String city;
	private Integer id;
}
public class Interview {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		List<TestEmployee> empList = new ArrayList<TestEmployee>();
		empList.add(new TestEmployee("Arun", "Hydrabad", 1));
		empList.add(new TestEmployee("Mahesh", "Noida", 2));
		empList.add(new TestEmployee("Vijay", "Pune", 3));
		empList.add(new TestEmployee("Laxman", "Kolkata", 4));
		empList.add(new TestEmployee("Kamal", "Kolkata", 5));
		
		//list number of employee in the each city
		Map<String,Long> finalMap = empList.stream().collect(Collectors.groupingBy(TestEmployee::getCity,Collectors.counting()));
		System.out.println(finalMap);
		//list employee name in the each city
		Map<String,List<TestEmployee>> nameMap = empList.stream().collect(Collectors.groupingBy(TestEmployee::getCity));
		nameMap.keySet().forEach(city -> nameMap.get(city).forEach(emp -> System.out.println(emp.getName()+ ":"+emp.getCity())));
	}

}
