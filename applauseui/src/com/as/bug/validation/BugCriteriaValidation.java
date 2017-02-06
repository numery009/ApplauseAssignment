package com.as.bug.validation;

import java.util.List;

import com.as.bug.vo.BugCriteria;
import com.as.bug.constant.ValidationConstant;

public class BugCriteriaValidation {
	// //////////////////////////////////////////////////////////
	// // Bug Criteria Validation has to check ..................
	// //////////////////////////////////////////////////////////

	public static String validateBugCriteriaSearchByCountry(
			List<BugCriteria> bugCriteriaLst) {

		String errors = "";
		for (BugCriteria bugCriteria : bugCriteriaLst) {
			if (bugCriteria.getCountry() == null
					|| bugCriteria.getCountry().trim().length() == 0) {
				errors = ValidationConstant.MANDATORY_FIELD_COUNTRY;
			}
		}
		return errors;
	}

	public static String validateBugCriteriaSearchByDevice(
			List<BugCriteria> bugCriteriaLst) {

		String errors = "";
		for (BugCriteria bugCriteria : bugCriteriaLst) {
			if (bugCriteria.getDeviceId() == 0) {
				errors = ValidationConstant.MANDATORY_FIELD_DEVICE;
			}
		}
		return errors;
	}

	public static String validateBugCriteriaSearchByDeviceByCountry(
			List<BugCriteria> bugCriteriaLst) {

		String errors = "";
		for (BugCriteria bugCriteria : bugCriteriaLst) {
			if (bugCriteria.getCountry() == null
					|| bugCriteria.getCountry().trim().length() == 0) {
				errors = ValidationConstant.MANDATORY_FIELD_COUNTRY;
			} else {
				errors = "";
				break;
			}
		}
		if (errors == "") {
			for (BugCriteria bugCriteria : bugCriteriaLst) {
				if (bugCriteria.getDeviceId() == 0) {
					errors = ValidationConstant.MANDATORY_FIELD_DEVICE;
				} else {
					errors = "";
					break;
				}
			}
		}
		return errors;
	}

}
