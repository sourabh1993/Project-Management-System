package com.adobe.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.adobe.dao.FetchException;
import com.adobe.dao.PersistenceException;
import com.adobe.dao.ProjectDao;
import com.adobe.dao.jdbc.ProjectDaoJdbcImpl;
import com.adobe.entity.Project;

@Path("/projects")
public class ProjectService {
	private ProjectDao projectDao = new ProjectDaoJdbcImpl();
	
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Project> getProjects() {
		try {
			return projectDao.listProjects();
		} catch (FetchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response addProjects(Project project) {
		try {
			projectDao.addProject(project);
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Response.ok().entity("Project added").build();
	}
	
	@PUT
	@Path("{pid}/manager/{mgrid}")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response assignManager(@PathParam("pid") int projId, @PathParam("mgrid") int mgrId){
		try {
			projectDao.assignProjectManager(projId, mgrId);
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Response.ok().entity("Manager Assigned").build();
	}
	
	@PUT
	@Path("{pid}/employee/{empid}")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response addEmployee(@PathParam("pid") int projId, @PathParam("empid") int empId){
		try {
			projectDao.addEmployee(projId, empId);
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Response.ok().entity("Employee Added").build();
	}
}
