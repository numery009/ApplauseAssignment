package com.as.device.vo;

import java.util.ArrayList;
import java.util.List;


import javax.xml.bind.annotation.XmlRootElement;

import com.as.TesterDevice.vo.TesterDevice;

@XmlRootElement(name = "device")
public class Device {

	private int deviceId;

	private String description;

	List<TesterDevice> testerDeviceList = new ArrayList<TesterDevice>();

	public Device() {
		super();
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

	public List<TesterDevice> getTesterDeviceList() {
		return testerDeviceList;
	}

	public void setTesterDeviceList(List<TesterDevice> testerDeviceList) {
		this.testerDeviceList = testerDeviceList;
	}
}
