package org.tutev.cagri.web.service;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tutev.cagri.web.base.BaseDao;
import org.tutev.cagri.web.base.OrderData;
import org.tutev.cagri.web.base.OrderType;
import org.tutev.cagri.web.base.QueryResults;
import org.tutev.cagri.web.dto.Sabit;
import org.tutev.cagri.web.dto.cagri.Cagri;

@Service("cagriService")
@Transactional
public class CagriService {

	Logger LOGGER = Logger.getLogger(CagriService.class);

	@Autowired
	private transient BaseDao baseDao;

	public boolean save(Cagri cagri) {
		try {
			if (cagri.getGelisTarihi() != null) {
				baseDao.save(cagri);
				if(cagri.getId()!=null){
					String cgrNo=cagriNoOlustur(cagri.getId().toString());
					SQLQuery query= baseDao.getSession().createSQLQuery(" UPDATE CGR_CAGRI SET CAGRI_NO= '"+cgrNo+"' WHERE ID="+cagri.getId());
					query.executeUpdate();					
					baseDao.getSession().flush();
				}
				return true;
			}
			return false;
		} catch (Exception e) {
			LOGGER.error(e);
			return false;
		}
	}

	private String cagriNoOlustur(String id) {
		String cagriNo="CGR";
		for (int i = 0; i < 6; i++) {
			if(id.length()<=10)
				cagriNo+="0";
		}
		cagriNo+=id;
		
		return cagriNo;
	}

	public boolean delete(Cagri cagri) {
		try {
			baseDao.delete(cagri);
			return true;
		} catch (Exception e) {
			LOGGER.error(e);
			return false;
		}
	}

	public List<Cagri> getAll() {
		try {
			List<Cagri> cagriList = (List<Cagri>) baseDao.getAll(Cagri.class);
			return cagriList;
		} catch (Exception e) {
			LOGGER.error(e);
			return null;
		}
	}
	
	public Cagri getByCagriNo(String cagriNo) {
		try {
			Criteria criteria=baseDao.getSession().createCriteria(Cagri.class);
			criteria.add(Restrictions.eq("cagriNo", cagriNo));
			criteria.add(Restrictions.eq("durum", Boolean.TRUE));
			return (Cagri) criteria.uniqueResult();
		} catch (Exception e) {
			LOGGER.error(e);
			return null;
		}
	}

	public void update(Cagri cagri) {
		try {
			if (cagri.getGelisTarihi() != null) {
				baseDao.update(cagri);
			}
		} catch (Exception e) {
			LOGGER.error(e);
		}
		
	}

	public QueryResults getCagriListesi(Map<String, String> filters,OrderData orderData, int firstRecord, int pageSize) {
		Criteria criteria =baseDao.getSession().createCriteria(Cagri.class);
		if(filters.get("cagriNo")!=null){
			criteria.add(Restrictions.ilike("cagriNo", filters.get("cagriNo"),MatchMode.ANYWHERE));
		}
		
		if(filters.get("ilce.tanim")!=null){
			criteria.createAlias("ilce", "ilc").add(Restrictions.ilike("ilc.tanim", filters.get("ilce.tanim"),MatchMode.ANYWHERE));
		}
		
		if(filters.get("gelisTarihiBitis")!=null){
			criteria.add(Restrictions.le("gelisTarihi", Sabit.stringToDateDDMMYYY(filters.get("gelisTarihiBitis"))));
		}

		if(filters.get("gelisTarihiBaslama")!=null){
			criteria.add(Restrictions.ge("gelisTarihi", Sabit.stringToDateDDMMYYY(filters.get("gelisTarihiBaslama"))));
		}

		return baseDao.getAll(criteria, orderData, firstRecord, pageSize);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
