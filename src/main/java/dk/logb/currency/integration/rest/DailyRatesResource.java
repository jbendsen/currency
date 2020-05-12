package dk.logb.currency.integration.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.logging.Logger;

import dk.logb.currency.service.CurrencyService;

@Path("/rates")
public class DailyRatesResource {
	Logger log = Logger.getLogger(DailyRatesResource.class.getName());
	
	@Inject
	CurrencyService service;
	
	@GET
	@Produces(value = MediaType.APPLICATION_JSON)
	
	public Response getRates() {
		log.info("getRates() - nemlig!");
		return Response
        .status(200)
        .header("Access-Control-Allow-Origin", "*")
        .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
        .header("Access-Control-Allow-Credentials", "true")
        .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
        .header("Access-Control-Max-Age", "1209600")
        .entity(service.getRates())
        .build();
				
	}	
}
