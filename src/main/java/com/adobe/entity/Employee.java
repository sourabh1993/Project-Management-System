package com.adobe.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="employee")
@XmlAccessorType(XmlAccessType.FIELD)
public class Employee {
	private int id;
	private String name;
	private String designation;
	private String email;
	
	
	public Employee() {
	}


	/**
	 * @param id
	 * @param name
	 * @param designation
	 * @param email
	 */
	public Employee(int id, String name, String designation, String email) {
		this.id = id;
		this.name = name;
		this.designation = designation;
		this.email = email;
	}


	/**
	 * @return the id
	 */
	public final int getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public final void setId(int id) {
		this.id = id;
	}


	/**
	 * @return the name
	 */
	public final String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public final void setName(String name) {
		this.name = name;
	}


	/**
	 * @return the designation
	 */
	public final String getDesignation() {
		return designation;
	}


	/**
	 * @param designation the designation to set
	 */
	public final void setDesignation(String designation) {
		this.designation = designation;
	}


	/**
	 * @return the email
	 */
	public final String getEmail() {
		return email;
	}


	/**
	 * @param email the email to set
	 */
	public final void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
