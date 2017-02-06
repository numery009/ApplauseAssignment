package src.com.as.applause.tester.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import src.com.as.applause.tester.service.TesterService;
import src.com.as.applause.tester.vo.Tester;

@Path("/tester")
@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
public class TesterController {
	@GET
	@Path("/getall")
	public List<Tester> getAllTest() {		
		TesterService testerService =new TesterService();
		return testerService.getAllTester();
	}
	@GET
	@Path("/getallcountry")
	public List<Tester> getAllCountry() {		
		TesterService testerService =new TesterService();
		return testerService.getAllCountry();
	}
}
