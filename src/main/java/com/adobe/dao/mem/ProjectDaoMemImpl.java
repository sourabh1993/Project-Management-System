package com.adobe.dao.mem;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.glassfish.jersey.message.filtering.SelectableEntityFilteringFeature;

import com.adobe.dao.ProjectDao;
import com.adobe.entity.Employee;
import com.adobe.entity.Project;

public class ProjectDaoMemImpl implements ProjectDao{
	
	private static List<Project> projects = new ArrayList<>();

	@Override
	public void addProject(Project project) {
		// TODO Auto-generated method stub
		projects.add(project);
	}

	@Override
	public void assignProjectManager(int projId, int mgrId) {
		// TODO Auto-generated method stub
		Project project=null;
		Employee manager=null;
		
		Iterator<Project> iterator = projects.iterator();
		
		while(iterator.hasNext()){
			Project project2 = iterator.next();
			if(project2.getProjectId() == projId){
				project = project2;
			}
		}
		
		Iterator<Employee> iterator2 = EmployeeDaoMemImpl.getEmployees().iterator();
		
		while(iterator2.hasNext()){
			Employee employee = iterator2.next();
			if(employee.getId() == mgrId && employee.getDesignation().equals("Manager")){
				manager = employee;
			}
		}
		
		if(manager!=null){
			project.setManager(manager);
		}
	}

	@Override
	public void addEmployee(int projId, int empId) {
		// TODO Auto-generated method stub
		Project project=null;
		Employee employee=null;
		
		Iterator<Project> iterator = projects.iterator();
		
		while(iterator.hasNext()){
			Project project2 = iterator.next();
			if(project2.getProjectId() == projId){
				project = project2;
			}
		}
		
		Iterator<Employee> iterator2 = EmployeeDaoMemImpl.getEmployees().iterator();
		
		while(iterator2.hasNext()){
			Employee employee2 = iterator2.next();
			if(employee2.getId() == empId && !employee2.getDesignation().equals("Manager")){
				employee = employee2;
			}
		}
		
		if(employee!= null){
			List<Employee> staff=project.getStaff();
			staff.add(employee);
			project.setStaff(staff);
		}
		
	}

	@Override
	public List<Project> listProjects() {
		// TODO Auto-generated method stub
		return projects;
	}
	
}
