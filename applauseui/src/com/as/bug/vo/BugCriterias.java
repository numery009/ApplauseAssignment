package com.as.bug.vo;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="bugCriterias")
@XmlAccessorType(XmlAccessType.FIELD)
public class BugCriterias {
	@XmlElement(name="bugCriteria")
	private List<BugCriteria> bugCriteriaList;

	public List<BugCriteria> getBugCriteriaList() {
		return bugCriteriaList;
	}

	public void setBugCriteriaList(List<BugCriteria> bugCriteriaList) {
		this.bugCriteriaList = bugCriteriaList;
	}

}
