package org.tutev.cagri.web.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tutev.cagri.web.base.BaseDao;
import org.tutev.cagri.web.dto.cagri.Cagri;
import org.tutev.cagri.web.dto.stok.hareket.StokHareket;


@Service("stokHareketService")
public class StokHareketService {
	
	Logger LOGGER =Logger.getLogger(StokHareketService.class);
	
	@Autowired
	private transient BaseDao baseDao;
	
	private boolean save(StokHareket stokHareket) {
		try{
			if(stokHareket.getTarih()!=null){
				baseDao.save(stokHareket);
				return true;
			}
			return false;
		}catch(Exception e){
			LOGGER.error(e);
			return false;
		}
	}

	public List<StokHareket> getAll() {
		try{	
			List<StokHareket> stokHareketList=(List<StokHareket>)baseDao.getAll(StokHareket.class);
			return stokHareketList;
		}catch(Exception e){
			LOGGER.error(e);
			return null;
		}
	}

}
