package com.as.tester.vo;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="testers")																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																							
@XmlAccessorType(XmlAccessType.FIELD)
public class Testers {
	@XmlElement(name="tester")
	private List<Tester> testerList;

	public List<Tester> getTesterList() {
		return testerList;
	}

	public void setTesterList(List<Tester> testerList) {
		this.testerList = testerList;
	}

}
