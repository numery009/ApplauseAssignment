package src.com.as.applause.TesterDevice.vo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import src.com.as.applause.bug.vo.Bug;

@Entity(name = "testerdevice")
@Table(name = "TESTERDEVICE")
@XmlRootElement(name = "testerdevice")
public class TesterDevice {
	@Column(name = "TESTERID")
	private int testerId;
	@Column(name = "DEVICEID")
	private int deviceId;
	@Id
	@Column(name = "TESTERDEVICEID")
	private int testerDeviceId;
	public TesterDevice() {
		super();		
	}
	@OneToMany
	@JoinColumn(name = "TESTERDEVICEID")
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
