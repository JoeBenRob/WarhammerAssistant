package com.bae.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.bae.business.UnitService;


@Path("unit")
public class UnitController {
	
	@Inject
	private UnitService service;
	
	@Path("getAllUnit")
	@GET
	@Produces({ "application/json" })
	public String getAllUnit() {
		return service.getAllUnit();
	}
	
	@Path("/getUnit/{id}")
	@GET
	@Produces({ "application/json" })
	public String getAUnit(@PathParam("id") int id) {
		return service.getAUnit(id);
	}

	@Path("/createUnit")
	@POST
	@Produces({ "application/json" })
	public String createUnit(String user) {
		return service.addUnit(user);
	}

	@Path("/deleteUser/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteUnit(@PathParam("id") int id) {
		return service.deleteUnit(id);
	}
	
	@Path("/updateUnit/{id}")
	@PUT
	@Produces({ "application/json" })
	public String updateUnit(@PathParam("id") int id, String unit) {
		return service.updateUnit(id, unit);
	}

	public void setUnit(UnitService service) {
		this.service = service;
	}
	
}
