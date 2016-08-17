package com.adobe.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="project")
@XmlAccessorType(XmlAccessType.FIELD)
public class Project {

	int projectId;
	String projectName;
	String clientName;
	Employee manager;
	List<Employee> staff;
	
	/**
	 * 
	 */
	public Project() {
	}


	


	/**
	 * @param projectId
	 * @param projectName
	 * @param clientName
	 * @param manager
	 * @param staff
	 */
	public Project(int projectId, String projectName, String clientName, Employee manager, List<Employee> staff) {
		this.projectId = projectId;
		this.projectName = projectName;
		this.clientName = clientName;
		this.manager = manager;
		this.staff = staff;
	}





	/**
	 * @return the projectId
	 */
	public final int getProjectId() {
		return projectId;
	}


	/**
	 * @param projectId the projectId to set
	 */
	public final void setProjectId(int projectId) {
		this.projectId = projectId;
	}


	/**
	 * @return the projectName
	 */
	public final String getProjectName() {
		return projectName;
	}


	/**
	 * @param projectName the projectName to set
	 */
	public final void setProjectName(String projectName) {
		this.projectName = projectName;
	}


	/**
	 * @return the clientName
	 */
	public final String getClientName() {
		return clientName;
	}


	/**
	 * @param clientName the clientName to set
	 */
	public final void setClientName(String clientName) {
		this.clientName = clientName;
	}



	/**
	 * @return the staff
	 */
	public final List<Employee> getStaff() {
		return staff;
	}


	/**
	 * @param staff the staff to set
	 */
	public final void setStaff(List<Employee> staff) {
		this.staff = staff;
	}


	/**
	 * @return the manager
	 */
	public final Employee getManager() {
		return manager;
	}


	/**
	 * @param manager the manager to set
	 */
	public final void setManager(Employee manager) {
		this.manager = manager;
	}
	
	
}
