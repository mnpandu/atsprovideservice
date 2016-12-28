package ticketing.provide.controller.dao;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.sf.json.JSON;
import net.sf.json.xml.XMLSerializer;
import ticketing.provide.controller.model.GuestModel;
import ticketing.provide.controller.model.TicketingModel;

@Repository
public class AtsProvideServiceDaoImpl implements AtsProvideServiceDao {
	@Autowired
	SessionFactory sessionFactory;
	@Override
	public String GetXIDGuestKeys(String swid) {
		String xid = null;
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Criteria cr = session.createCriteria(GuestModel.class);
			cr.add(Restrictions.eq("guestIdValue", swid));
			List guestModel = cr.list();

			for (Iterator iterator = guestModel.iterator(); iterator.hasNext();) {
				GuestModel employee = (GuestModel) iterator.next();
				xid = employee.getXid();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return xid;

	}
	@Override
	public String GetEvDetails(String xid) {
 
	//	List evlist = new ArrayList();
		String cannonicalData = "";
		try {
			Session session = this.sessionFactory.getCurrentSession();
			
		//	String[] a = xid.split(",");
			
			/*for(int i=0;i<a.length;i++)
			{
				Criteria cr = session.createCriteria(TicketingModel.class);
				String b =a[i].trim();
			
			cr.add(Restrictions.eq("canonnicalId",b));
			List<TicketingModel> evtModel = cr.list();
			for (Iterator iterator = evtModel.iterator(); iterator.hasNext();) {
				TicketingModel ev = (TicketingModel) iterator.next();
				
//				FileInputStream fis = new FileInputStream(name);
//	            String xml = IOUtils.toString(fis); 
	          //  JSON objJson = new XMLSerializer().read(ev.getCanonnicalData()); 
	            
				evlist.add(ev.getCanonnicalData());				
			}
			}*/
			
			Criteria cr = session.createCriteria(TicketingModel.class);
			cr.add(Restrictions.eq("canonnicalId",xid));
			List<TicketingModel> evtModel = cr.list();
			/*for (Iterator iterator = evtModel.iterator(); iterator.hasNext();) {
				TicketingModel ev = (TicketingModel) iterator.next();
				cannonicalData = ev.getCanonnicalData();
			}*/
			
			cannonicalData =	evtModel.get(0).getCanonnicalData();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return cannonicalData;
	}

}
