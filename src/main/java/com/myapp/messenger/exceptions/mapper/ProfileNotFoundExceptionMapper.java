package com.myapp.messenger.exceptions.mapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.myapp.messenger.exceptions.ProfileNotFoundException;
import com.myapp.messenger.model.response.ErrorResponse;

@Provider
public class ProfileNotFoundExceptionMapper implements ExceptionMapper<ProfileNotFoundException> {

	@Override
	public Response toResponse(ProfileNotFoundException ex) {
		return Response.status(Status.NOT_FOUND)
				.entity(new ErrorResponse(ex.getMessage(), 404, "https://github.com/hansdah82/messenger/readme"))
				.build();
	}

}
