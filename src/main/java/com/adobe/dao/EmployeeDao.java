package com.adobe.dao;

import java.util.List;

import com.adobe.entity.Employee;

public interface EmployeeDao {
	void addEmployee(Employee employee);
	List<Employee> getEmployee();
}
