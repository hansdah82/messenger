package com.myapp.messenger.web.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.myapp.messenger.model.entity.Profile;
import com.myapp.messenger.service.ProfileService;

@Path("/profiles")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProfileResource {

	private ProfileService service;

	public ProfileResource() {
		service = new ProfileService();
	}

	@GET
	public List<Profile> getProfiles() {
		return service.getAllProfile();
	}

	@POST
	public Profile create(Profile profile) {
		return service.createProfile(profile);
	}
	
	@GET
	@Path("/{username}")
	public Profile getProfile(@PathParam("username") String username) {
		return service.getProfile(username);
	}

}
