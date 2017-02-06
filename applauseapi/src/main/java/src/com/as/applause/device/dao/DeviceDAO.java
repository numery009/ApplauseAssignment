package src.com.as.applause.device.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import src.com.as.applause.HibernateConnector;
import src.com.as.applause.device.vo.Device;

public class DeviceDAO {
	static {

		HibernateConnector.getSessionFactory();
	}
	
	/*
	 * This code fetch all the Device information from the database
	 */
	@SuppressWarnings("unchecked")
	public List<Device> getAllDevice() {
		List<Device> deviceList = null;
		Session session=null;
		try {
			session = HibernateConnector.getSessionFactory()
					.openSession();
			deviceList = session.createCriteria(Device.class)
					.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
					.list();			
		} catch (HibernateException ex) {
			System.out.println(ex);
			//throw new HibernateException(ex);
		}
		finally{
			session.close();
		}
		return deviceList;
	}
}
