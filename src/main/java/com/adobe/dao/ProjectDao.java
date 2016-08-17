package com.adobe.dao;

import java.util.List;

import com.adobe.entity.Project;

public interface ProjectDao {
	void addProject(Project project);
	void assignProjectManager(int projId, int mgrId);
	void addEmployee(int projId, int empId);
	List<Project> listProjects();
}
