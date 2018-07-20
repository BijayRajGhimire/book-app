package com.cubic.book.resource.provider;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import com.cubic.book.service.ErrorEntity;
import com.cubic.book.service.exceptions.InvalidDataException;

public class InvalidDataExceptionHandler implements ExceptionMapper<InvalidDataException> {

	
	
	public Response toResponse( final InvalidDataException exception) {
		final ErrorEntity entity = ErrorEntity.builder().errorCode("ERR-100").
				errorDesc(exception.getMessage()).build();
		
		return Response.status(510).entity(entity).build();
	}

	

}
