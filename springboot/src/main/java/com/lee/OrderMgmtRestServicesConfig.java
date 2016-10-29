package com.lee;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
@ApplicationPath("/services")
public class OrderMgmtRestServicesConfig extends ResourceConfig{
	public OrderMgmtRestServicesConfig(){		
		register(HelloWorldRestServieImpl.class);
	}
}
