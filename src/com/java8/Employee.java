package com.java8;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Employee {
	private Integer empId;
	private String empName;
	private Integer deptId;
	private Double salary;
	private String status;
	
}
