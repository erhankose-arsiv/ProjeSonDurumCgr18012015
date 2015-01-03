package org.tutev.cagri.web.service.uygulama;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tutev.cagri.web.base.BaseDao;
import org.tutev.cagri.web.dto.genel.Kullanici;
import org.tutev.cagri.web.dto.uygulama.Menu;

@Service("uygulamaService")
@Transactional
public class UygulamaService {
	
	Logger LOGGER =Logger.getLogger(UygulamaService.class);
	
	@Autowired
	private transient BaseDao baseDao;
	
	public Kullanici getUser() {
		Criteria criteria =baseDao.getSession().createCriteria(Kullanici.class);
		criteria.add(Restrictions.eq("username", "admin"));
		return (Kullanici)criteria.uniqueResult();
	}
	
	public List<Menu> getAll() {
		try{	
			List<Menu> menuList=(List<Menu>)baseDao.getAllbyOrder(Menu.class, "gosterimSirasi");
			return menuList;
		}catch(Exception e){
			LOGGER.error(e);
			return null;
		}
	}
}
