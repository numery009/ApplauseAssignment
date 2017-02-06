package src.com.as.applause.device.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;



import src.com.as.applause.device.service.DeviceService;
import src.com.as.applause.device.vo.Device;


@Path("/device")
@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
public class DeviceController {
	@GET
	@Path("/getall")
	public List<Device> getAllDevice() {		
		DeviceService deviceService = new DeviceService();
		return deviceService.getAllDevice();
		/*return Response.status(Status.OK)
				.entity(deviceList)
				.build();*/
		//return deviceService.getAllDevice();
	}
}
