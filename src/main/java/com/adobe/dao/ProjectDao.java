package com.adobe.dao;

import java.util.List;

import com.adobe.entity.Project;

public interface ProjectDao {
	void addProject(Project project) throws PersistenceException;
	void assignProjectManager(int projId, int mgrId) throws FetchException;
	void addEmployee(int projId, int empId);
	List<Project> listProjects();
}
