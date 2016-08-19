package com.adobe.dao.mem;

import java.util.ArrayList;
import java.util.List;

import com.adobe.dao.EmployeeDao;
import com.adobe.entity.Employee;

public class EmployeeDaoMemImpl implements EmployeeDao {
	
	private static  List<Employee> employees = new ArrayList<Employee>();

	@Override
	public void addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		employees.add(employee);
	}
	
	public List<Employee> getEmployees(){
		return employees;
	}
	
}
