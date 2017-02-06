package src.com.as.applause.tester.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import src.com.as.applause.HibernateConnector;
import src.com.as.applause.bug.vo.BugCriteria;
import src.com.as.applause.tester.vo.Tester;

public class TesterDAO {
	static {

		HibernateConnector.getSessionFactory();
	}
	
	/*
	 * This code fetch all the Device information from the database
	 */
	@SuppressWarnings("unchecked")
	public List<Tester> getAllTester() {
		List<Tester> testerList = null;		
		Session session=null;
		try {
			session = HibernateConnector.getSessionFactory()
					.openSession();
			testerList = session.createCriteria(Tester.class)
					.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
					.list();			
		} catch (HibernateException ex) {
			System.out.println(ex);
		}
		finally{
			session.close();
		}
		return testerList;
	}
	
	@SuppressWarnings("unchecked")
	public List<Tester> getAllCountry() {
		List<String> countryList = null;
		Session session=null;
		try {
			session = HibernateConnector.getSessionFactory()
					.openSession();
			countryList = session
					.createSQLQuery("select distinct(Country) from testers")
					.list();
			
		} catch (HibernateException ex) {
			System.out.println(ex);
		}
		finally{
			session.close();
		}
		List<Tester> testerList=new ArrayList<Tester>();
		for (String entity : countryList) {
			Tester newTester =new Tester();
			newTester.setCountry(entity.toString());
			testerList.add(newTester);
		}
		
		return testerList;
	}

	

}
