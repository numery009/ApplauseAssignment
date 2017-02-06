package com.as.bug.service;

import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

import com.as.bug.vo.BugCriteria;
import com.as.bug.vo.BugCriterias;
import com.as.device.vo.Device;
import com.as.device.vo.Devices;
import com.as.tester.constant.ValidationConstant;
import com.as.tester.validation.TesterValidation;
import com.as.tester.vo.Tester;
import com.as.tester.vo.Testers;
import com.as.utility.SearchCriteria;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class BugService {

	public static String baseURLGetAllBUG = "http://localhost:8080/applauseapi/webapi/bug/getall";
	public static String baseURLGetAllBUGByCountry = "http://localhost:8080/applauseapi/webapi/bug/getallbycountry";
	public static String baseURLGetAllBUGByDevice = "http://localhost:8080/applauseapi/webapi/bug/getallbydevice";
	public static String baseURLGetAllBUGByCountryByDevice = "http://localhost:8080/applauseapi/webapi/bug/getallbydevicebycountry";

	/*
	 * Initializing the API's URL in the Jersey Client
	 */
	private static WebResource getResource(String url) {
		Client client = Client.create();
		WebResource webResource = client.resource(url);
		return webResource;
	}

	public List<BugCriteria> getBugProcessing(List<BugCriteria> bugCriteriaLst) {
		List<BugCriteria> bugCriteriaList = null;
		for (BugCriteria bug : bugCriteriaLst) {
			if (bug.getStatus() == SearchCriteria.ALL.toString()) {
				bugCriteriaList = this.getAllBug();
			} else if (bug.getStatus() == SearchCriteria.OnlyByCountry
					.toString()) {
				List<Tester> testerList = new ArrayList<Tester>();
				Testers testers = new Testers();
				for (BugCriteria bugCriteria : bugCriteriaLst) {
					if (bugCriteria.getCountry() != null) {
						Tester tester = new Tester();
						tester.setCountry(bugCriteria.getCountry());
						testerList.add(tester);
					}
				}
				testers.setTesterList(testerList);
				bugCriteriaList = this.getAllBugByCountry(testers);
			} else if (bug.getStatus() == SearchCriteria.OnlyByDevice
					.toString()) {
				List<Device> deviceList = new ArrayList<Device>();
				Devices devices = new Devices();
				for (BugCriteria bugCriteria : bugCriteriaLst) {
					if (bugCriteria.getDeviceId() != 0) {
						Device device = new Device();
						device.setDeviceId(bugCriteria.getDeviceId());
						deviceList.add(device);
					}
				}
				devices.setDeviceList(deviceList);
				bugCriteriaList = this.getAllBugByDevice(devices);
			} else if (bug.getStatus() == SearchCriteria.OnlyByDeviceByCountry
					.toString()) {
				BugCriterias bugCriterias = new BugCriterias();
				bugCriterias.setBugCriteriaList(bugCriteriaLst);
				bugCriteriaList = this.getAllBugByDeviceByountry(bugCriterias);
			}
		}
		return bugCriteriaList;
	}

	/*
	 * This is the service level Code of the Get All Bug information
	 */
	public List<BugCriteria> getAllBug() {
		List<BugCriteria> bugCriteriaList = null;
		WebResource webresource = getResource(baseURLGetAllBUG);
		ClientResponse response = webresource.accept("application/xml").get(
				ClientResponse.class);
		if (response.getStatus() != 200) {
			throw new RuntimeErrorException(null, "Failed : HTTP error code"
					+ response.getStatus());
		} else {
			BugCriterias bugCriterias = response.getEntity(BugCriterias.class);
			if (bugCriterias.getBugCriteriaList() != null) {
				bugCriteriaList = new ArrayList<BugCriteria>();
				for (BugCriteria bug : bugCriterias.getBugCriteriaList()) {
					BugCriteria newBugCriteria = new BugCriteria();
					newBugCriteria.setDeviceId(bug.getDeviceId());
					newBugCriteria.setDescription(bug.getDescription());
					newBugCriteria.setTesterId(bug.getTesterId());
					newBugCriteria.setCountry(bug.getCountry());
					newBugCriteria.setDescription(bug.getDescription());
					newBugCriteria.setFirstName(bug.getFirstName());
					newBugCriteria.setLastName(bug.getLastName());
					newBugCriteria.setTotalBugforDevice(bug
							.getTotalBugforDevice());
					bugCriteriaList.add(newBugCriteria);
				}
			}
		}
		return bugCriteriaList;
	}

	/*
	 * This is the service level Code of the Get All Bug By Country information
	 */
	public List<BugCriteria> getAllBugByCountry(Testers testers) {
		List<BugCriteria> bugCriteriaList = null;
		WebResource webresource = getResource(baseURLGetAllBUGByCountry);
		ClientResponse response = webresource.accept("application/xml").post(
				ClientResponse.class, testers);
		if (response.getStatus() != 200) {
			throw new RuntimeErrorException(null, "Failed : HTTP error code"
					+ response.getStatus());
		} else {

			BugCriterias bugCriterias = response.getEntity(BugCriterias.class);
			if (bugCriterias.getBugCriteriaList() != null) {
				bugCriteriaList = new ArrayList<BugCriteria>();
				for (BugCriteria bug : bugCriterias.getBugCriteriaList()) {
					BugCriteria newBugCriteria = new BugCriteria();
					newBugCriteria.setDeviceId(bug.getDeviceId());
					newBugCriteria.setDescription(bug.getDescription());
					newBugCriteria.setTesterId(bug.getTesterId());
					newBugCriteria.setCountry(bug.getCountry());
					newBugCriteria.setDescription(bug.getDescription());
					newBugCriteria.setFirstName(bug.getFirstName());
					newBugCriteria.setLastName(bug.getLastName());
					newBugCriteria.setTotalBugforDevice(bug
							.getTotalBugforDevice());
					bugCriteriaList.add(newBugCriteria);
				}
			}
		}
		return bugCriteriaList;
	}

	/*
	 * This is the service level Code of the Get All Bug By Device information
	 */
	public List<BugCriteria> getAllBugByDevice(Devices deviceLst) {
		List<BugCriteria> bugCriteriaList = null;
		WebResource webresource = getResource(baseURLGetAllBUGByDevice);
		ClientResponse response = webresource.accept("application/xml").post(
				ClientResponse.class, deviceLst);
		if (response.getStatus() != 200) {
			throw new RuntimeErrorException(null, "Failed : HTTP error code"
					+ response.getStatus());
		} else {
			BugCriterias bugCriterias = response.getEntity(BugCriterias.class);
			if (bugCriterias.getBugCriteriaList() != null) {
				bugCriteriaList = new ArrayList<BugCriteria>();
				for (BugCriteria bug : bugCriterias.getBugCriteriaList()) {
					BugCriteria newBugCriteria = new BugCriteria();
					newBugCriteria.setDeviceId(bug.getDeviceId());
					newBugCriteria.setDescription(bug.getDescription());
					newBugCriteria.setTesterId(bug.getTesterId());
					newBugCriteria.setCountry(bug.getCountry());
					newBugCriteria.setDescription(bug.getDescription());
					newBugCriteria.setFirstName(bug.getFirstName());
					newBugCriteria.setLastName(bug.getLastName());
					newBugCriteria.setTotalBugforDevice(bug
							.getTotalBugforDevice());
					bugCriteriaList.add(newBugCriteria);
				}
			}
		}
		return bugCriteriaList;
	}

	/*
	 * This is the service level Code of the Get All Bug By Device and By
	 * Country information
	 */
	public List<BugCriteria> getAllBugByDeviceByountry(BugCriterias bugCriterias) {
		List<BugCriteria> bugCriteriaList = null;
		WebResource webresource = getResource(baseURLGetAllBUGByCountryByDevice);
		ClientResponse response = webresource.accept("application/xml").post(
				ClientResponse.class, bugCriterias);
		if (response.getStatus() != 200) {
			throw new RuntimeErrorException(null, "Failed : HTTP error code"
					+ response.getStatus());
		} else {
			BugCriterias bugs = response.getEntity(BugCriterias.class);
			if (bugs.getBugCriteriaList() != null) {
				bugCriteriaList = new ArrayList<BugCriteria>();
				for (BugCriteria bug : bugs.getBugCriteriaList()) {
					BugCriteria newBugCriteria = new BugCriteria();
					newBugCriteria.setDeviceId(bug.getDeviceId());
					newBugCriteria.setDescription(bug.getDescription());
					newBugCriteria.setTesterId(bug.getTesterId());
					newBugCriteria.setCountry(bug.getCountry());
					newBugCriteria.setDescription(bug.getDescription());
					newBugCriteria.setFirstName(bug.getFirstName());
					newBugCriteria.setLastName(bug.getLastName());
					newBugCriteria.setTotalBugforDevice(bug
							.getTotalBugforDevice());
					bugCriteriaList.add(newBugCriteria);
				}
			}
		}
		return bugCriteriaList;
	}
}
