package src.com.as.applause.tester.service;

import java.util.List;

import src.com.as.applause.tester.dao.TesterDAO;
import src.com.as.applause.tester.vo.Tester;

public class TesterService {
	public List<Tester> getAllTester(){
		TesterDAO testerDAO =new TesterDAO();
		return testerDAO.getAllTester();
	}
	public List<Tester> getAllCountry(){
		TesterDAO testerDAO =new TesterDAO();
		return testerDAO.getAllCountry();
	}
}
