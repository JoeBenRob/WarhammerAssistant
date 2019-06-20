package com.bae.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.bae.business.AllegianceService;
import com.bae.business.UnitService;

@Path("allegiance")
public class AllegianceController {
	
	@Inject
	private AllegianceService service;
	
	@Path("getAllAllegiance")
	@GET
	@Produces({ "application/json" })
	public String getAllAllegiance() {
		return service.getAllAllegiance();
	}
	
	@Path("/getAllegiance/{id}")
	@GET
	@Produces({ "application/json" })
	public String getAnAllegiance(@PathParam("id") int id) {
		return service.getAnAllegiance(id);
	}

	@Path("/createAllegiance")
	@POST
	@Produces({ "application/json" })
	public String createAllegiance(String allegiance) {
		return service.addAllegiance(allegiance);
	}

	@Path("/deleteAllegiance/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteAllegiance(@PathParam("id") int id) {
		return service.deleteAllegiance(id);
	}
	
	@Path("/updateAllegiance/{id}")
	@PUT
	@Produces({ "application/json" })
	public String updateAllegiance(@PathParam("id") int id, String allegiance) {
		return service.updateAllegiance(id, allegiance);
	}

	public void setAllegiance(AllegianceService service) {
		this.service = service;
	}
	
}
