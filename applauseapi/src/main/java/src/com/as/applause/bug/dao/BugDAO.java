package src.com.as.applause.bug.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import src.com.as.applause.HibernateConnector;
import src.com.as.applause.bug.vo.BugCriteria;
import src.com.as.applause.device.vo.Device;
import src.com.as.applause.tester.vo.Tester;

public class BugDAO {
	static {

		HibernateConnector.getSessionFactory();
	}

	/*
	 * This code fetch all the Bug information from the database
	 */
	@SuppressWarnings("unchecked")
	public List<BugCriteria> getAllBug() {
		List<BugCriteria> bugList = null;
		Session session = null;
		try {
			session = HibernateConnector.getSessionFactory().openSession();
			bugList = (List<BugCriteria>) session
					.createSQLQuery(
							"select  d.testerid, d.firstName ,d.lastName, d.country,  c.*,  count(d.testerid) as TotalBugforDevice "
									+ "from bugsnormalize as a "
									+ "left join testerdevice as b "
									+ "on a.testerdeviceid=b.testerdeviceid "
									+ "left join devices as c "
									+ "on c.deviceid=b.deviceid "
									+ "left join testers as d "
									+ "on d.testerId=b.testerid "
									+ "group by c.deviceid,d.testerid "
									+ "order by d.testerid ")
					.addEntity(BugCriteria.class).list();

		} catch (HibernateException ex) {
			System.out.println(ex);
		} finally {
			session.close();
		}
		return bugList;
	}

	/*
	 * This code fetch all the Bug information Criteria by Device from the
	 * database
	 */
	@SuppressWarnings("unchecked")
	public List<BugCriteria> getAllBugbyDevice(List<Device> deviceLst) {
		List<Object[]> bugList = null;
		Session session = null;
		try {
			session = HibernateConnector.getSessionFactory().openSession();
			String queryString = "select  d.testerid, d.firstName ,d.lastName, d.country, c.*,  count(d.testerid) as TotalBugforDevice "
					+ "from bugsnormalize as a "
					+ "left join testerdevice as b "
					+ "on a.testerdeviceid=b.testerdeviceid "
					+ "left join devices as c "
					+ "on c.deviceid=b.deviceid "
					+ "left join testers as d on d.testerId=b.testerid";
			int i = 1;
			while (deviceLst.size() >= i) {
				if (i == 1) {
					queryString = queryString + " where c.deviceid=?";
				} else if (i >= 1) {
					queryString = queryString + " or c.deviceid=?";
				}
				i++;
			}

			queryString = queryString
					+ " group by c.deviceid,d.testerid order by d.testerid";
			Query query = session.createSQLQuery(queryString);
			int j = 0;
			for (Device device : deviceLst) {
				query.setInteger(j, device.getDeviceId());
				j++;
			}
			bugList = query.list();

		}

		catch (HibernateException ex) {
			System.out.println(ex);
		} finally {
			session.close();
		}

		List<BugCriteria> bugListbyDevice = new ArrayList<BugCriteria>();
		for (Object[] entity : bugList) {
			BugCriteria newBugCriteria = new BugCriteria();
			newBugCriteria.setDeviceId(Integer.parseInt(entity[4].toString()));
			newBugCriteria.setFirstName(entity[1].toString());
			newBugCriteria.setLastName(entity[2].toString());
			newBugCriteria.setCountry(entity[3].toString());
			newBugCriteria.setTesterId(Integer.parseInt(entity[0].toString()));
			newBugCriteria.setDescription(entity[5].toString());
			newBugCriteria.setTotalBugforDevice(entity[6].toString());
			bugListbyDevice.add(newBugCriteria);
		}

		return bugListbyDevice;
	}

	/*
	 * This code fetch all the Bug information Criteria by Country from the
	 * database
	 */
	@SuppressWarnings("unchecked")
	public List<BugCriteria> getAllBugbyCountry(List<Tester> testerLst) {
		List<Object[]> bugList = null;
		Session session = null;
		try {
			session = HibernateConnector.getSessionFactory().openSession();
			String queryString = "select  d.testerid, d.firstName ,d.lastName, d.country, c.*,  count(d.testerid) as TotalBugforDevice "
					+ "from bugsnormalize as a "
					+ "left join testerdevice as b "
					+ "on a.testerdeviceid=b.testerdeviceid "
					+ "left join devices as c "
					+ "on c.deviceid=b.deviceid "
					+ "left join testers as d on d.testerId=b.testerid ";
			int i = 1;
			while (testerLst.size() >= i) {
				if (i == 1) {
					queryString = queryString + " where d.country=?";
				} else if (i >= 1) {
					queryString = queryString + " or d.country=?";
				}
				i++;
			}
			queryString = queryString
					+ " group by c.deviceid,d.testerid order by d.testerid";
			Query query = session.createSQLQuery(queryString);
			int j = 0;
			for (Tester ts : testerLst) {
				query.setString(j, ts.getCountry());
				j++;
			}
			bugList = query.list();

		} catch (HibernateException ex) {
			System.out.println(ex);
		} finally {
			session.close();
		}

		List<BugCriteria> bugListbyDevice = new ArrayList<BugCriteria>();
		for (Object[] entity : bugList) {
			BugCriteria newBugCriteria = new BugCriteria();
			newBugCriteria.setDeviceId(Integer.parseInt(entity[4].toString()));
			newBugCriteria.setFirstName(entity[1].toString());
			newBugCriteria.setLastName(entity[2].toString());
			newBugCriteria.setCountry(entity[3].toString());
			newBugCriteria.setTesterId(Integer.parseInt(entity[0].toString()));
			newBugCriteria.setDescription(entity[5].toString());
			newBugCriteria.setTotalBugforDevice(entity[6].toString());
			bugListbyDevice.add(newBugCriteria);
		}

		return bugListbyDevice;
	}

	/*
	 * This code fetch all the Bug information Criteria by Device and Criteria
	 * by Country from the database
	 */
	@SuppressWarnings("unchecked")
	public List<BugCriteria> getAllBugbyDevicebyCountry(List<Tester> testerLst,
			List<Device> deviceLst) {
		List<Object[]> bugList = null;
		Session session = null;
		try {
			session = HibernateConnector.getSessionFactory().openSession();
			String queryString = "select  d.testerid, d.firstName ,d.lastName, d.country,  c.*,  count(d.testerid) as TotalBugforDevice "
					+ "from bugsnormalize as a "
					+ "left join testerdevice as b "
					+ "on a.testerdeviceid=b.testerdeviceid "
					+ "left join devices as c "
					+ "on c.deviceid=b.deviceid "
					+ "left join testers as d on d.testerId=b.testerid";
			int i = 1;
			while (testerLst.size() >= i) {
				if (i == 1) {
					queryString = queryString + " where (d.country=?";
				} else if (i >= 1) {
					queryString = queryString + " or d.country=?";
				}
				i++;
			}

			int k = 1;
			while (deviceLst.size() >= k) {
				if (k == 1) {
					queryString = queryString + ") And (c.deviceid=?";
				} else if (i >= 1) {
					queryString = queryString + " or c.deviceid=?";
				}
				k++;
			}

			queryString = queryString + ")";

			queryString = queryString
					+ " group by c.deviceid,d.testerid order by d.testerid";

			Query query = session.createSQLQuery(queryString);
			int j = 0;
			for (Tester tester : testerLst) {
				query.setString(j, tester.getCountry());
				j++;
			}
			for (Device device : deviceLst) {
				query.setInteger(j, device.getDeviceId());
				j++;
			}

			bugList = query.list();

		} catch (HibernateException ex) {
			System.out.println(ex);
		} finally {
			session.close();
		}

		List<BugCriteria> bugListbyDevice = new ArrayList<BugCriteria>();
		for (Object[] entity : bugList) {
			BugCriteria newBugCriteria = new BugCriteria();
			newBugCriteria.setDeviceId(Integer.parseInt(entity[4].toString()));
			newBugCriteria.setFirstName(entity[1].toString());
			newBugCriteria.setLastName(entity[2].toString());
			newBugCriteria.setCountry(entity[3].toString());
			newBugCriteria.setTesterId(Integer.parseInt(entity[0].toString()));
			newBugCriteria.setDescription(entity[5].toString());
			newBugCriteria.setTotalBugforDevice(entity[6].toString());
			bugListbyDevice.add(newBugCriteria);
		}

		return bugListbyDevice;
	}
}
