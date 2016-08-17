package com.adobe.rest;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/")
public class ApplicationResource extends ResourceConfig {
	
	public ApplicationResource(){
		packages("com.adobe");
	}
}
