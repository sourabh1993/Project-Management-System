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
import com.adobe.dao.mem.EmployeeDaoMemImpl;
import com.adobe.entity.Employee;

@Path("/employees")
public class EmployeeService {
	private EmployeeDao employeeDao = new EmployeeDaoMemImpl();
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response addEmployee(Employee employee) {
		employeeDao.addEmployee(employee);
		return Response.ok().entity("Employee added").build();
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Employee> getProjects() {
		return employeeDao.getEmployee();
	}
	
}
