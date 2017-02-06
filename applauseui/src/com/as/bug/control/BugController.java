package com.as.bug.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.as.bug.constant.ValidationConstant;
import com.as.bug.service.BugService;
import com.as.bug.validation.BugCriteriaValidation;
import com.as.bug.vo.BugCriteria;
import com.as.utility.SearchCriteria;

@WebServlet("/bug/getallbugs")
public class BugController extends HttpServlet {
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// System.out.println((request.getParameter("allDevice")));
		String errors = "";
		List<BugCriteria> bugCriterias = new ArrayList<BugCriteria>();
		if ((request.getParameter("allDevice") != null)
				&& ((request.getParameter("allCountry") != null))) {
			BugCriteria bugCriteria = new BugCriteria();
			bugCriteria.setStatus(SearchCriteria.ALL.toString());
			bugCriterias.add(bugCriteria);

			/*
			 * errors = BugCriteriaValidation
			 * .validateBugCriteriaSearchByDeviceByCountry(bugCriterias);
			 */
		} else if ((request.getParameter("allCountry") != null)) {
			String deviceList = request.getParameter("totalSelectedDeviceId");
			String[] totalDevice = deviceList.split("\r\n");
			for (int i = 0; i < totalDevice.length; i++) {
				BugCriteria bugCriteria = new BugCriteria();
				String[] deviceInfo = totalDevice[i].split("-");
				if (deviceInfo[0].trim() != "") {
					bugCriteria.setDeviceId(Integer.parseInt(deviceInfo[0]
							.trim()));
					bugCriteria.setDescription(deviceInfo[1].trim());
				}
				bugCriteria.setStatus(SearchCriteria.OnlyByDevice.toString());
				bugCriterias.add(bugCriteria);

			}
			errors = BugCriteriaValidation
					.validateBugCriteriaSearchByDevice(bugCriterias);

		} else if ((request.getParameter("allDevice")) != null) {
			String countryList = request
					.getParameter("totalSelectedCountryName");
			String[] totalCountry = countryList.split("\r\n");

			for (int i = 0; i < totalCountry.length; i++) {
				BugCriteria bugCriteria = new BugCriteria();
				bugCriteria.setCountry(totalCountry[i].trim());
				bugCriteria.setStatus(SearchCriteria.OnlyByCountry.toString());
				bugCriterias.add(bugCriteria);
			}

			errors = BugCriteriaValidation
					.validateBugCriteriaSearchByCountry(bugCriterias);

		} else {
			String deviceList = request.getParameter("totalSelectedDeviceId");
			String[] totalDevice = deviceList.split("\r\n");
			for (int i = 0; i < totalDevice.length; i++) {
				BugCriteria bugCriteria = new BugCriteria();
				String[] deviceInfo = totalDevice[i].split("-");
				if (deviceInfo[0].trim() != "") {
					bugCriteria.setDeviceId(Integer.parseInt(deviceInfo[0]
							.trim()));
					bugCriteria.setDescription(deviceInfo[1].trim());
				}
				bugCriteria.setStatus(SearchCriteria.OnlyByDeviceByCountry
						.toString());
				bugCriterias.add(bugCriteria);
			}

			String countryList = request
					.getParameter("totalSelectedCountryName");
			String[] totalCountry = countryList.split("\r\n");
			for (int i = 0; i < totalCountry.length; i++) {
				BugCriteria bugCriteria = new BugCriteria();
				bugCriteria.setCountry(totalCountry[i].trim());
				bugCriterias.add(bugCriteria);
			}
			errors = BugCriteriaValidation
					.validateBugCriteriaSearchByDeviceByCountry(bugCriterias);

		}
		if ((errors.equals(ValidationConstant.MANDATORY_FIELD_COUNTRY))
				|| (errors.equals(ValidationConstant.MANDATORY_FIELD_DEVICE))) {
			request.setAttribute("errors", errors);
			request.getRequestDispatcher("../index.jsp").forward(request,
					response);
		} else {
			BugService bugService = new BugService();
			List<BugCriteria> bugCriteriaList = bugService
					.getBugProcessing(bugCriterias);
			request.setAttribute("bugCriteriaList", bugCriteriaList);
			request.getRequestDispatcher("../index.jsp").forward(request,
					response);
		}
	}
}
