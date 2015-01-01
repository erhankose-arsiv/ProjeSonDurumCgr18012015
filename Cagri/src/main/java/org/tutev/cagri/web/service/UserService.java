package org.tutev.cagri.web.service;

import java.util.Date;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;
import org.tutev.cagri.web.base.BaseDao;
import org.tutev.cagri.web.base.OrderData;
import org.tutev.cagri.web.base.QueryResults;
import org.tutev.cagri.web.dto.kullanici.Role;
import org.tutev.cagri.web.dto.kullanici.User;
import org.tutev.cagri.web.dto.kullanici.UserStatus;

@Repository("userService")
@Transactional
public class UserService {
	
	@Autowired
	BaseDao baseDao;
	
	public void save(User user) {
		for (Role rol : user.getRoles()) {
			baseDao.save(rol);
		}
		user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
		user.setStatus(UserStatus.ACTIVE);
		baseDao.save(user);
	}
	
	@Transactional
	public QueryResults getUserListesi(Map<String, String> filters, OrderData orderData, int firstRecord, int pageSize) {
		Criteria criteria = baseDao.getSessionFactory().openSession().createCriteria(User.class);
		if (filters.get("selectedBaslangýcTarihi") != null) {
			criteria.add(Restrictions.ge("dogumTarihi",new Date(filters.get("selectedBaslangýcTarihi"))));
		}
		if (filters.get("selectedBitisTarihi") != null) {
			criteria.add(Restrictions.le("dogumTarihi",new Date(filters.get("selectedBitisTarihi"))));
		}
		
		if (filters.get("selectedBitisTarihi5") != null) {
			criteria.add(Restrictions.or(Restrictions.eq("ad", "aa"),Restrictions.ilike("soyad", "test")));
		}
		return baseDao.getAll(criteria, orderData, firstRecord, pageSize);
	}
	
	@Transactional
	public User findUserByName(String username) {
		Criteria criteria = baseDao.getSessionFactory().openSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("username", username));		
		return (User) criteria.uniqueResult();
	}
}
