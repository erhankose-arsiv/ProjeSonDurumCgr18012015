package org.tutev.cagri.web.service;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.tutev.cagri.web.base.BaseDao;
import org.tutev.cagri.web.dto.cagri.Cagri;
import org.tutev.cagri.web.dto.genel.Il;

@Controller("dataController")
@Scope(value="singleton")
public class DataService implements Serializable {
	
	Logger LOGGER =Logger.getLogger(DataService.class);
	
	@Autowired
	private transient BaseDao baseDao;
	

	List<Il> ilList;

	@PostConstruct
	public void init() {
		try{
			ilList=(List<Il>) baseDao.getAll(Il.class);
			LOGGER.info("Singleton DataServis Yüklendi");
		}catch(Exception e){
			LOGGER.info(e.getStackTrace());
		}
	}
	
	public List<Il> getIlList() {
		return ilList;
	}

}
