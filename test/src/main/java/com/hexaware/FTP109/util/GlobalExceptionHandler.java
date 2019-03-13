package com.hexaware.FTP109.util;
//import javax.ws.rs.Provider;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
* This class provides a ExceptionHandler for all Exception Classes.
*/
@Provider
public class GlobalExceptionHandler implements ExceptionMapper<IllegalArgumentException> {
  /**
   * @param ex reference variable for IllegalArgumentException.
   * @return the integer values for the Response.
   */
  public final Response toResponse(final IllegalArgumentException ex) {
    if (ex instanceof IllegalArgumentException) {
      return Response.status(Response.Status.BAD_REQUEST).entity("{Error: " + ex.getMessage() + "}").build();
    }
    return Response.status(500).entity(ex.getMessage()).build();
  }
}
