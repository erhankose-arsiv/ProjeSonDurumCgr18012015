package org.tutev.cagri.web.service;

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

}
