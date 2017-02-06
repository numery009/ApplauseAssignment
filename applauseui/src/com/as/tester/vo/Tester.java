package com.as.tester.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import javax.xml.bind.annotation.XmlRootElement;

import com.as.TesterDevice.vo.TesterDevice;


@XmlRootElement(name = "tester")
public class Tester {


	private int testerId;
	
	private String firstName;
	
	private String lastName;
	
	private String country;
	
	private Date lastLogin;


	List<TesterDevice> testerDeviceList = new ArrayList<TesterDevice>();

	public Tester() {
		super();
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

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}
	
	public List<TesterDevice> getTesterDeviceList() {
		return testerDeviceList;
	}

	public void setTesterDeviceList(List<TesterDevice> testerDeviceList) {
		this.testerDeviceList = testerDeviceList;
	}
}
