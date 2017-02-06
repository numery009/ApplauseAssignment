package com.as.device.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;

import com.as.device.vo.Device;
import com.as.device.vo.Devices;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class DeviceService {

	public static String baseURLGetAllDevice = "http://localhost:8080/applauseapi/webapi/device/getall";

	/*
	 * Initializing the API's URL in the Jersey Client
	 */
	private static WebResource getResource(String url) {
		Client client = Client.create();
		WebResource webResource = client.resource(url);
		return webResource;
	}

	/*
	 * This is the service level Code of the Get ALL device information in the
	 */
	public List<Device> getAllDevice() {

		WebResource webresource = getResource(baseURLGetAllDevice);
		ClientResponse response = webresource.accept(MediaType.APPLICATION_XML).get(
				ClientResponse.class);
		Devices devices = response.getEntity(Devices.class);

		List<Device> deviceList = new ArrayList<Device>();
		if (devices.getDeviceList() != null) {
			for(Device device:devices.getDeviceList()){
				Device newDevice =new Device();
				newDevice.setDeviceId(device.getDeviceId());
				newDevice.setDescription(device.getDescription());
				deviceList.add(newDevice);
			}
		}
		Device newDevice =new Device();
		newDevice.setDeviceId(0);
		newDevice.setDescription("ALL");
		deviceList.add(newDevice);		
		return deviceList;
	}
}
