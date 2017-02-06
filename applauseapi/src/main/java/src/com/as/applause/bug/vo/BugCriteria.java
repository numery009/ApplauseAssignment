package src.com.as.applause.bug.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@Entity(name = "BUGCRITERIA")
@XmlRootElement
public class BugCriteria implements Serializable{
	/*@Id
	@Column(name = "BUGID")
	private int bugId;
	@Column(name = "TESTERDEVICEID")
	private int testerDeviceId;*/
	@Column(name = "COUNTRY")
	private String country;
	@Id
	@Column(name = "DEVICEID")
	private int deviceId;
	@Column(name = "DESCRIPTION")
	private String description;
	@Id
	@Column(name = "TESTERID")
	private int testerId;
	@Column(name = "FIRSTNAME")
	private String firstName;
	@Column(name = "LASTNAME")
	private String lastName;
	/*@Column(name = "LASTLOGIN")
	private String lastLogIn;*/
	@Column(name = "TOTALBUGFORDEVICE")
	private String totalBugforDevice;
	
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

	public String getTotalBugforDevice() {
		return totalBugforDevice;
	}

	public void setTotalBugforDevice(String totalBugforDevice) {
		this.totalBugforDevice = totalBugforDevice;
	}

}
