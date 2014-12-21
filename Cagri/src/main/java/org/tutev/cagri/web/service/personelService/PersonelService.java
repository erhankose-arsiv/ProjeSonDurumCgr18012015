package org.tutev.cagri.web.service.personelService;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tutev.cagri.web.base.BaseDao;
import org.tutev.cagri.web.base.OrderData;
import org.tutev.cagri.web.base.QueryResults;
import org.tutev.cagri.web.dto.Sabit;
import org.tutev.cagri.web.dto.cagri.Cagri;
import org.tutev.cagri.web.dto.personel.Personel;
import org.tutev.cagri.web.service.CagriService;

@Service("personelService")
@Transactional
public class PersonelService {
Logger LOGGER =Logger.getLogger(PersonelService.class);
	
	@Autowired
	private transient BaseDao baseDao;
	
	public boolean save(Personel personel) {
		try{
			if(personel.getTc() !=null){
				baseDao.save(personel);
				return true;
			}
			return false;
		}catch(Exception e){
			LOGGER.error(e);
			return false;
		}
	}

	public List<Personel> getAll() {
		try{	
			List<Personel> personelList=(List<Personel>)baseDao.getAll(Personel.class);
			return personelList;
		}catch(Exception e){
			LOGGER.error(e);
			return null;
		}
	}
	public QueryResults getPersonelListesi(Map<String, String> filters,OrderData orderData, int firstRecord, int pageSize) {
		Criteria criteria =baseDao.getSession().createCriteria(Cagri.class);
		if(filters.get("tc")!=null){
			criteria.add(Restrictions.ilike("tc", filters.get("tc"),MatchMode.ANYWHERE));
		}
		return baseDao.getAll(criteria, orderData, firstRecord, pageSize);
	}

	public void update(Personel personel) {
		try {
			if (personel.getId() != null) {
				baseDao.update(personel);
			}
		} catch (Exception e) {
			LOGGER.error(e);
		}

	}

	public boolean delete(Personel personel) {
		try {
			baseDao.delete(personel);
			return true;
		} catch (Exception e) {
			LOGGER.error(e);
			return false;
		}
	}
}
