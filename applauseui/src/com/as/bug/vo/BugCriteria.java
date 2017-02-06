package com.as.bug.vo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BugCriteria {

/*	private int bugId;

	private int testerDeviceId;*/

	private String country;

	private int deviceId;

	private String description;

	private int testerId;

	private String firstName;

	private String lastName;

	private String totalBugforDevice;
	
	/*private String lastLogIn;*/

	private String status;
	
	public BugCriteria() {
		super();
	}

	/*public int getBugId() {
		return bugId;
	}

	public void setBugId(int bugId) {
		this.bugId = bugId;
	}

	public int getTesterDeviceId() {
		return testerDeviceId;
	}

	public void setTesterDeviceId(int testerDeviceId) {
		this.testerDeviceId = testerDeviceId;
	}*/

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getTesterId() {
		return testerId;
	}

	public void setTesterId(int testerId) {
		this.testerId = testerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	/*public String getLastLogIn() {
		return lastLogIn;
	}

	public void setLastLogIn(String lastLogIn) {
		this.lastLogIn = lastLogIn;
	}*/

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTotalBugforDevice() {
		return totalBugforDevice;
	}

	public void setTotalBugforDevice(String totalBugforDevice) {
		this.totalBugforDevice = totalBugforDevice;
	}
}
