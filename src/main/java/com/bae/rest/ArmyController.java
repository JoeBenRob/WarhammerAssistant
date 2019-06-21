package com.bae.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.bae.business.ArmyService;
import com.bae.business.UnitService;

@Path("army")
public class ArmyController {
	
	@Inject
	private ArmyService service;
	
	@Path("getAllArmy")
	@GET
	@Produces({ "application/json" })
	public String getAllArmy() {
		return service.getAllArmy();
	}
	
	@Path("/getArmy/{id}")
	@GET
	@Produces({ "application/json" })
	public String getAnArmy(@PathParam("id") int id) {
		return service.getAnArmy(id);
	}

	@Path("/createArmy")
	@POST
	@Produces({ "application/json" })
	public String createArmy(String army) {
		return service.addArmy(army);
	}

	@Path("/deleteArmy/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteArmy(@PathParam("id") int id) {
		return service.deleteArmy(id);
	}
	
	@Path("/updateArmy/{id}")
	@PUT
	@Produces({ "application/json" })
	public String updateArmy(@PathParam("id") int id, String army) {
		return service.updateArmy(id, army);
	}

	public void setArmy(ArmyService service) {
		this.service = service;
	}

}
