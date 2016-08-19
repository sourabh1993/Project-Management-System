package com.adobe.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.adobe.dao.EmployeeDao;
import com.adobe.dao.FetchException;
import com.adobe.dao.PersistenceException;
import com.adobe.dao.jdbc.EmployeeDaoJdbcImpl;
import com.adobe.entity.Employee;

@Path("/employees")
public class EmployeeService {
	private EmployeeDao employeeDao = new EmployeeDaoJdbcImpl();
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response addEmployee(Employee employee) {
		try {
			employeeDao.addEmployee(employee);
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.serverError().entity("Employee could not be added").build();
		}
		return Response.ok().entity("Employee added").build();
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Employee> getProjects() {
		try {
			return employeeDao.getEmployees();
		} catch (FetchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
