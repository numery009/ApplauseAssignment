package com.as.tester.validation;

import com.as.tester.constant.ValidationConstant;
import com.as.tester.vo.Tester;
import com.as.tester.vo.Testers;

public class TesterValidation {
	public static String validateTesterSearch(Tester tester) {
		String errors = "";

		if (tester.getCountry() == null
				|| tester.getCountry().trim().length() == 0) {
			return errors = ValidationConstant.MANDATORY_FIELD;
		}

		return errors;
	}
}
