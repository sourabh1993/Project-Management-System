package com.adobe.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import com.adobe.dao.PersistenceException;
import com.adobe.dao.ProjectDao;
import com.adobe.entity.Employee;
import com.adobe.entity.Project;

public class ProjectDaoJdbcImpl implements ProjectDao{

	@Override
	public void addProject(Project project) throws PersistenceException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			String SQL = "INSERT INTO PROJECT (ProjectId, ProjectName, ClientName) VALUES (?,?,?)";
			
			try {
				connection = DBUtil.getConnection();
				preparedStatement = connection.prepareStatement(SQL);
				preparedStatement.setInt(1, project.getProjectId());
				preparedStatement.setString(2, project.getProjectName());
				preparedStatement.setString(3, project.getClientName());
				
				preparedStatement.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new PersistenceException("Unable to add project",e);
			}finally {
				DBUtil.releaseStatement(preparedStatement);
				DBUtil.releaseConnection(connection);
			}
	}

	@Override
	public void assignProjectManager(int projId, int mgrId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addEmployee(int projId, int empId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Project> listProjects() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

//	@Override
//	public void assignProjectManager(int projId, int mgrId) {
//		// TODO Auto-generated method stub
//		Project project=null;
//		Employee manager=null;
//		
//		Iterator<Project> iterator = projects.iterator();
//		
//		while(iterator.hasNext()){
//			Project project2 = iterator.next();
//			if(project2.getProjectId() == projId){
//				project = project2;
//			}
//		}
//		
//		Iterator<Employee> iterator2 = employeeDao.getEmployees().iterator();
//		
//		while(iterator2.hasNext()){
//			Employee employee = iterator2.next();
//			if(employee.getId() == mgrId && employee.getDesignation().equals("Manager")){
//				manager = employee;
//			}
//		}
//		
//		if(manager!=null){
//			project.setManager(manager);
//		}
//	}
//
//	@Override
//	public void addEmployee(int projId, int empId) {
//		// TODO Auto-generated method stub
//		Project project=null;
//		Employee employee=null;
//		
//		Iterator<Project> iterator = projects.iterator();
//		
//		while(iterator.hasNext()){
//			Project project2 = iterator.next();
//			if(project2.getProjectId() == projId){
//				project = project2;
//			}
//		}
//		
//		Iterator<Employee> iterator2 = employeeDao.getEmployees().iterator();
//		
//		while(iterator2.hasNext()){
//			Employee employee2 = iterator2.next();
//			if(employee2.getId() == empId && !employee2.getDesignation().equals("Manager")){
//				employee = employee2;
//			}
//		}
//		
//		if(employee!= null){
//			List<Employee> staff=project.getStaff();
//			staff.add(employee);
//			project.setStaff(staff);
//		}
//		
//	}
//
//	@Override
//	public List<Project> listProjects() {
//		// TODO Auto-generated method stub
//		return projects;
//	}
	
}
