package com.as.device.validation;

import com.as.device.vo.Device;
import com.as.tester.constant.ValidationConstant;

public class DeviceValidation {
	public static String validateDeviceSearch(Device device) {
		String errors = "";
		if (device.getDeviceId() == 0) {
			return errors = ValidationConstant.MANDATORY_FIELD;
		}
		return errors;
	}
}
