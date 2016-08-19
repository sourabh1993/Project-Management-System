package com.adobe.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.adobe.dao.EmployeeDao;
import com.adobe.dao.FetchException;
import com.adobe.dao.PersistenceException;
import com.adobe.entity.Employee;

public class EmployeeDaoJdbcImpl implements EmployeeDao {

	@Override
	public void addEmployee(Employee employee) throws PersistenceException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String SQL = "INSERT INTO EMPLOYEE (Id,Name,Designation,Email) VALUES (?,?,?,?)";
		
		try {
			connection = DBUtil.getConnection();
			preparedStatement = connection.prepareStatement(SQL);
			preparedStatement.setInt(1, employee.getId());
			preparedStatement.setString(2, employee.getName());
			preparedStatement.setString(3, employee.getDesignation());
			preparedStatement.setString(4, employee.getEmail());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new PersistenceException("Unable to add product",e);
		}finally {
			DBUtil.releaseStatement(preparedStatement);
			DBUtil.releaseConnection(connection);
		}
	}
	
	public List<Employee> getEmployees() throws FetchException{
		List<Employee> employees = new ArrayList<Employee>();
		Connection connection = null;
		Statement statement = null;
		String SQL = "SELECT Id,Name,Designation,Email FROM Employee";
		
		try {
			connection = DBUtil.getConnection();
			System.out.println("Result received");
			statement = connection.createStatement();
			System.out.println("Result received");
			ResultSet resultSet = statement.executeQuery(SQL);
			System.out.println("Result received");
			while (resultSet.next()) {
				System.out.println("inside result loop");
				Employee employee = 
						new Employee(resultSet.getInt("Id"), resultSet.getString("Name"), resultSet.getString("Designation"), resultSet.getString("Email"));
				employees.add(employee);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new FetchException("unable to get products", e);
		}finally {
			DBUtil.releaseStatement(statement);
			DBUtil.releaseConnection(connection);
		}
		
		return employees;
	}
	
}
