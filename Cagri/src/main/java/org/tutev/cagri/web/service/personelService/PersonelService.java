package org.tutev.cagri.web.service.personelService;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tutev.cagri.web.base.BaseDao;
import org.tutev.cagri.web.dto.cagri.Cagri;
import org.tutev.cagri.web.dto.personel.Personel;
import org.tutev.cagri.web.service.CagriService;

@Service("personelService")
public class PersonelService {
Logger LOGGER =Logger.getLogger(PersonelService.class);
	
	@Autowired
	private transient BaseDao baseDao;
	
	private boolean save(Personel personel) {
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

}
