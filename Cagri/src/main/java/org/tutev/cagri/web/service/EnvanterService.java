package org.tutev.cagri.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tutev.cagri.web.base.BaseDao;
import org.tutev.cagri.web.dto.envanter.Envanter;

@Service("envanterService")
public class EnvanterService {

	
	@Autowired
	private transient BaseDao baseDao;
	
	private boolean save(Envanter env) {
		try{
			if(env.getEklenmeTarihi()!=null){
				baseDao.save(env);
				return true;
			}
			return false;
		}catch(Exception e){
			
			return false;
		}
	}

	public List<Envanter> getAll() {
		try{	
			List<Envanter> envanterList=(List<Envanter>)baseDao.getAll(Envanter.class);
			return envanterList;
		}catch(Exception e){
			
			return null;
		}
	}
	
	
}
