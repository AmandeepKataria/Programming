package com.lee;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
@Path("/order")
public class HelloWorldRestServieImpl implements HelloWorldRestService{
	
	@POST
	public HelloResponse hello(HelloRequest request) {
		return new HelloResponse(request.getName());
	}

}
