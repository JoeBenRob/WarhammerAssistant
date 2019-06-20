package com.bae.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.bae.business.UserService;

@Path("user")
public class UserController {
	
	@Inject
	private UserService service;
	
	@Path("getAllUser")
	@GET
	@Produces({ "application/json" })
	public String getAllUser() {
		return service.getAllUser();
	}
	
	@Path("/getUser/{id}")
	@GET
	@Produces({ "application/json" })
	public String getAUser(@PathParam("id") int id) {
		return service.getAUser(id);
	}

	@Path("/createUser")
	@POST
	@Produces({ "application/json" })
	public String createUser(String user) {
		return service.addUser(user);
	}

	@Path("/deleteUser/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteUser(@PathParam("id") int id) {
		return service.deleteUser(id);
	}
	
	@Path("/updateUser/{id}")
	@PUT
	@Produces({ "application/json" })
	public String updateUser(@PathParam("id") int id, String user) {
		return service.updateUser(id, user);
	}

	public void setUser(UserService service) {
		this.service = service;
	}
	
}
