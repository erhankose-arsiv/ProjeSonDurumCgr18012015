package org.tutev.cagri.web.service.iletisim;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tutev.cagri.web.base.BaseDao;
import org.tutev.cagri.web.dto.iletisim.Iletisim;
import org.tutev.cagri.web.service.CagriService;


@Service("iletisimService")
public class IletisimService {
	Logger LOGGER =Logger.getLogger(CagriService.class);
	
	
	@Autowired
	private transient BaseDao baseDao;
	
	public List<Iletisim> getAll() {
		try{	
			List<Iletisim> iletisimList=(List<Iletisim>)baseDao.getAll(Iletisim.class);
			return iletisimList;
		}catch(Exception e){
			LOGGER.error(e);
			return null;
		}
	}
}
