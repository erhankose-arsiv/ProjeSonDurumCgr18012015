package org.tutev.cagri.web.service.firma;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tutev.cagri.web.base.BaseDao;
import org.tutev.cagri.web.dto.firma.Firmalar;

@Service("firmaService")
@Transactional
public class FirmaService {

	Logger LOGGER =Logger.getLogger(FirmaService.class);
	
	@Autowired
	private transient BaseDao baseDao;
	
	private boolean save(Firmalar firmalar) {
		try{
			if(firmalar.getKurulusTarihi()!=null){
				baseDao.save(firmalar);
				return true;
			}
			return false;
		}catch(Exception e){
			LOGGER.error(e);
			return false;
		}
	}

	public List<Firmalar> getAll() {
		try{	
			List<Firmalar> firmaList=(List<Firmalar>)baseDao.getAll(Firmalar.class);
			return firmaList;
		}catch(Exception e){
			LOGGER.error(e);
			return null;
		}
	}
}
