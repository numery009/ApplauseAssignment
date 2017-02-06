package src.com.as.applause.bug.control;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.PathSegment;

import src.com.as.applause.bug.service.BugService;
import src.com.as.applause.bug.vo.BugCriteria;
import src.com.as.applause.device.vo.Device;
import src.com.as.applause.tester.vo.Tester;

@Path("/bug")
@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
public class BugController {
	@GET
	@Path("/getall")
	public List<BugCriteria> getAllBug() {
		BugService bugService = new BugService();
		return bugService.getAllBug();
	}

	@POST
	@Path("/getallbydevice")
	public List<BugCriteria> getAllBugByDevice(List<Device> deviceLst) {
		BugService bugService = new BugService();
		return bugService.getAllBugByDevice(deviceLst);
	}

	@POST
	@Path("/getallbycountry")
	public List<BugCriteria> getAllBugByCountry(List<Tester> testerLst) {
		BugService bugService = new BugService();
		return bugService.getAllBugByCountry(testerLst);
	}

	@POST
	@Path("/getallbydevicebycountry")
	public List<BugCriteria> getAllBugByDevicebyCountry(
			List<BugCriteria> lstBugCriteria) {
		BugService bugService = new BugService();
		List<Device> d = new ArrayList<Device>();
		return bugService.getAllBugbyDevicebyCountry(lstBugCriteria);

	}
}
