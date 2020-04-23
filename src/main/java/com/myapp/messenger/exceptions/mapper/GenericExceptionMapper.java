package com.myapp.messenger.exceptions.mapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;

import com.myapp.messenger.model.response.ErrorResponse;

public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

	@Override
	public Response toResponse(Throwable ex) {
		return Response.status(Status.INTERNAL_SERVER_ERROR)
				.entity(new ErrorResponse(ex.getMessage(), 500, "https://github.com/hansdah82/messenger/readme"))
				.build();
	}

}
