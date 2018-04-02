package edu.matc.restdemo;

import javax.ws.rs.*;
import javax.xml.ws.Response;


@Path("/hello")
public class HelloWorld {
    // The Java method will process HTTP GET requests
    @GET
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces("text/plain")
    public Response getMessage() {
        // Return a simple message
        String output = "Hello World";
        return Response.status(200).entity(output).build();
    }

}