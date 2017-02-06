package src.com.as.applause.tester.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import src.com.as.applause.TesterDevice.vo.TesterDevice;

@Entity(name = "tester")
@Table(name = "TESTERS")
@XmlRootElement(name = "tester")
public class Tester {

	@Id
	@Column(name = "TESTERID")
	private int testerId;
	@Column(name = "FIRSTNAME")
	private String firstName;
	@Column(name = "LASTNAME")
	private String lastName;
	@Column(name = "COUNTRY")
	private String country;
	@Column(name = "LASTLOGIN")
	private Date lastLogin;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "TESTERID")
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
