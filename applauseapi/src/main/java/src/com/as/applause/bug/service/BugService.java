package src.com.as.applause.bug.service;

import java.util.ArrayList;
import java.util.List;

import src.com.as.applause.bug.dao.BugDAO;
import src.com.as.applause.bug.vo.BugCriteria;
import src.com.as.applause.device.vo.Device;
import src.com.as.applause.tester.vo.Tester;

public class BugService {
	public List<BugCriteria> getAllBug() {
		BugDAO bugDAO = new BugDAO();
		return bugDAO.getAllBug();
	}

	public List<BugCriteria> getAllBugByDevice(List<Device> deviceLst) {
		BugDAO bugDAO = new BugDAO();
		return bugDAO.getAllBugbyDevice(deviceLst);
	}

	public List<BugCriteria> getAllBugByCountry(List<Tester> testerLst) {
		BugDAO bugDAO = new BugDAO();
		return bugDAO.getAllBugbyCountry(testerLst);
	}

	public List<BugCriteria> getAllBugbyDevicebyCountry(
			List<BugCriteria> bugCriteriaLst) {
		BugDAO bugDAO = new BugDAO();

		List<Device> deviceLst = new ArrayList<Device>();
		for (BugCriteria bugCriteria : bugCriteriaLst) {
			Device device = new Device();
			device.setDeviceId(bugCriteria.getDeviceId());
			deviceLst.add(device);
		}

		List<Tester> testerLst = new ArrayList<Tester>();
		for (BugCriteria bugCriteria : bugCriteriaLst) {
			Tester tester = new Tester();
			tester.setCountry(bugCriteria.getCountry());
			testerLst.add(tester);
		}

		return bugDAO.getAllBugbyDevicebyCountry(testerLst, deviceLst);
	}
}
