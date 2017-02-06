package src.com.as.applause.bug.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity(name = "BUG")
@Table(name = "BUGSNORMALIZE")
@XmlRootElement(name = "BUG")
public class Bug {

	@Id
	@Column(name = "BUGID")
	private int bugId;
	@Column(name = "TESTERDEVICEID")
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
