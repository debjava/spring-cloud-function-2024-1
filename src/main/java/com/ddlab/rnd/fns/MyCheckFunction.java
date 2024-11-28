package com.ddlab.rnd.fns;

import java.util.function.Function;

import com.ddlab.rnd.entity.Employee;

public class MyCheckFunction implements Function<Employee,Employee> {

	@Override
	public Employee apply(Employee emp) {
		System.out.println("Employee received : "+emp);
		Employee ee = new Employee();
		ee.setId(11);
		ee.setName("DD");
		return ee;
	}
	

}
