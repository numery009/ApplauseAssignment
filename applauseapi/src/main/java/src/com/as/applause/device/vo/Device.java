package src.com.as.applause.device.vo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import src.com.as.applause.TesterDevice.vo.TesterDevice;

@Entity(name = "device")
@Table(name = "DEVICES")
@XmlRootElement(name = "device")
public class Device {
	@Id
	@Column(name = "DEVICEID")
	private int deviceId;
	@Column(name = "DESCRIPTION")
	private String description;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "DEVICEID")
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
