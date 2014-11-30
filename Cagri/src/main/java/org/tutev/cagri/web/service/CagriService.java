package org.tutev.cagri.web.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tutev.cagri.web.base.BaseDao;
import org.tutev.cagri.web.dto.cagri.Cagri;

@Service("cagriService")
public class CagriService {
	
	Logger LOGGER =Logger.getLogger(CagriService.class);
	
	@Autowired
	private transient BaseDao baseDao;
	
	private boolean save(Cagri cagri) {
		try{
			if(cagri.getGelisTarihi()!=null){
				baseDao.save(cagri);
				return true;
			}
			return false;
		}catch(Exception e){
			LOGGER.error(e);
			return false;
		}
	}

	public List<Cagri> getAll() {
		try{	
			List<Cagri> cagriList=(List<Cagri>)baseDao.getAll(Cagri.class);
			return cagriList;
		}catch(Exception e){
			LOGGER.error(e);
			return null;
		}
	}

}
