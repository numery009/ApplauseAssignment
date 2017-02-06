package src.com.as.applause.error.error;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import src.com.as.applause.error.vo.ErrorMessage;

@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

	@Override
	public Response toResponse(Throwable exception) {

		ErrorMessage errorMessage = new ErrorMessage(exception.getMessage(),
				500, "http://www.vogella.com/tutorials/REST/article.html");

		return Response.status(Status.INTERNAL_SERVER_ERROR)
				.entity(errorMessage).build();

	}

}
