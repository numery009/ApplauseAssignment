package com.as.bug.vo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "BUG")
public class Bug {

	private int bugId;

	private int testerDeviceId;

	public Bug() {
		super();
	}

	public int getBugId() {
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
	}

}
