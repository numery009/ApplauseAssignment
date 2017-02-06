package src.com.as.applause.device.service;

import java.util.List;

import src.com.as.applause.device.dao.DeviceDAO;
import src.com.as.applause.device.vo.Device;


public class DeviceService {
	public List<Device> getAllDevice() {		
		DeviceDAO deviceDAO = new DeviceDAO();
		return  deviceDAO.getAllDevice();
		
	}
}
