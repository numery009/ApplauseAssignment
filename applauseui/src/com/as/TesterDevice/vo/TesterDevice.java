package com.as.TesterDevice.vo;

import java.util.ArrayList;
import java.util.List;


import javax.xml.bind.annotation.XmlRootElement;

import com.as.bug.vo.Bug;


@XmlRootElement(name = "testerdevice")
public class TesterDevice {
	
	private int testerId;
	
	private int deviceId;
	
	private int testerDeviceId;
	public TesterDevice() {
		super();		
	}

	List<Bug> bugList = new ArrayList<Bug>();
	
	public int getTesterId() {
		return testerId;
	}

	public void setTesterId(int testerId) {
		this.testerId = testerId;
	}

	public int getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}

	public int getTesterDeviceId() {
		return testerDeviceId;
	}

	public void setTesterDeviceId(int testerDeviceId) {
		this.testerDeviceId = testerDeviceId;
	}

	public List<Bug> getBugList() {
		return bugList;
	}

	public void setBugList(List<Bug> bugList) {
		this.bugList = bugList;
	}
}
