package ticketing.provide.controller.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ticketing.provide.controller.dao.AtsProvideServiceDao;
@Service
public class AtsProvideServiceImpl implements AtsProvideService{

	@Autowired
	AtsProvideServiceDao atsProvideServiceDao;
	@Override
	@Transactional(value="guestTransactionManager")
	public String GetXIDGuestKeys(String name) {
	String xid =	atsProvideServiceDao.GetXIDGuestKeys(name);
		return xid;
	}
	@Override
	@Transactional(value="guestTransactionManager")
	public String GetEvDetails(String xid) {
		
		return atsProvideServiceDao.GetEvDetails(xid);
	}

}
