package dk.logb.currency.integration.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.logging.Logger;

import dk.logb.currency.model.DailyRatesList;
import dk.logb.currency.service.CurrencyService;

@Path("/rates")
public class DailyRatesResource {
	Logger log = Logger.getLogger(DailyRatesResource.class.getName());
	
	@Inject
	CurrencyService service;
	
	@GET
	@Produces(value = MediaType.APPLICATION_JSON)
	public DailyRatesList getRates() {
		log.info("getRates()");
		return service.getRates();		
	}	
}
