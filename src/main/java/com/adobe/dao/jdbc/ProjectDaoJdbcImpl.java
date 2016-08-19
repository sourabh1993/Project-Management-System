package com.adobe.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.adobe.dao.FetchException;
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
	public void assignProjectManager(int projId, int mgrId) throws PersistenceException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String SQL = "UPDATE project set ManagerId = ? where ProjectId = ?";
		
		try {
			connection = DBUtil.getConnection();
			preparedStatement = connection.prepareStatement(SQL);
			preparedStatement.setInt(1, mgrId);
			preparedStatement.setInt(2, projId);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new PersistenceException("Unable to assign manager",e);
		}finally {
			DBUtil.releaseStatement(preparedStatement);
			DBUtil.releaseConnection(connection);
		}
	}

	@Override
	public void addEmployee(int projId, int empId) throws PersistenceException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String SQL = "INSERT INTO staff (ProjectId, StaffId) values(?,?)";
		
		try {
			connection = DBUtil.getConnection();
			preparedStatement = connection.prepareStatement(SQL);
			preparedStatement.setInt(1, projId);
			preparedStatement.setInt(2, empId);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new PersistenceException("Unable to add employee to project",e);
		}finally {
			DBUtil.releaseStatement(preparedStatement);
			DBUtil.releaseConnection(connection);
		}
	}

	@Override
	public List<Project> listProjects() throws FetchException {
		// TODO Auto-generated method stub
		List<Project> projects = new ArrayList<>();
		Connection connection = null;
		Statement statement = null;
		String SQL = "SELECT ProjectId, ProjectName, ClientName, ManagerId from Project";
		
		try {
			connection = DBUtil.getConnection();
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(SQL);
			while (resultSet.next()) {
				Project project = new Project();
				project.setProjectId(resultSet.getInt("ProjectId"));
				project.setProjectName(resultSet.getString("ProjectName"));
				project.setClientName(resultSet.getString("ClientName"));
				
				project.setManager(getEmployeeObject(resultSet.getInt("ManagerId")));
				project.setStaff(getEmployeeList(resultSet.getInt("ProjectId")));
				projects.add(project);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return projects;
		
	}

	private Employee getEmployeeObject(int empId) throws FetchException {
		// TODO Auto-generated method stub
		Employee employee = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String SQL = "SELECT Name,Designation,Email FROM EMPLOYEE where Id = ?";
		
		try {
			
			connection = DBUtil.getConnection();
			preparedStatement = connection.prepareStatement(SQL);
			preparedStatement.setInt(1, empId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				employee = 
						new Employee(empId, resultSet.getString("Name"), resultSet.getString("Designation"), resultSet.getString("Email"));	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new FetchException("unable to get employees", e);
		}finally {
			DBUtil.releaseStatement(preparedStatement);
			DBUtil.releaseConnection(connection);
		}
		
		return employee;
	}
	
	public List<Employee> getEmployeeList(int projId) throws FetchException{
		List<Employee> employees = new ArrayList<Employee>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String SQL = "SELECT StaffId FROM Staff where ProjectId = ?";
		
		try {
			connection = DBUtil.getConnection();
			preparedStatement = connection.prepareStatement(SQL);
			preparedStatement.setInt(1, projId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Employee employee = getEmployeeObject(resultSet.getInt("StaffId"));	
				employees.add(employee);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new FetchException("unable to get employees", e);
		}finally {
			DBUtil.releaseStatement(preparedStatement);
			DBUtil.releaseConnection(connection);
		}
		
		return employees;
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
