package org.jingjie.restful.messenger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.jingjie.restful.messenger.model.ErrorMessage;

/**
 * The class is to map DataNotFoundException to RESTFul service.
 * 
 * @author jingjiejiang
 * @history Jun 29, 2017
 */
@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {

	@Override
	public Response toResponse(DataNotFoundException ex) {
		
		ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), 404, "google.com");
		return Response.status(Status.NOT_FOUND)
				.entity(errorMessage)
				.build();
	}
}
