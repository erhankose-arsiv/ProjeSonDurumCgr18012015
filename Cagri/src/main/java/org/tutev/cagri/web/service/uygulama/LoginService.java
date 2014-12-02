package org.tutev.cagri.web.service.uygulama;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.tutev.cagri.web.base.BaseDao;
import org.tutev.cagri.web.dto.genel.Kullanici;

@Service("loginService")
public class LoginService {

	Logger LOGGER = Logger.getLogger(LoginService.class);

	@Autowired
	private transient BaseDao baseDao;

	@Autowired
	private transient SessionFactory sessionFactory;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public Kullanici getKullaniciByUsernamePassword(String username, String password) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Kullanici.class);
		criteria.add(Restrictions.eq("username", username));
		criteria.add(Restrictions.eq("password", password));
		return (Kullanici) criteria.uniqueResult();
	}
}
