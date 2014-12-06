package org.tutev.cagri.web.base;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository("baseDao")
// @Service("baseDao")
public class BaseDao {

	@Autowired
	private transient SessionFactory sessionFactory;

	public Session getSessionFactory() {

		return sessionFactory.getCurrentSession();
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void save(Object o) {
		getSessionFactory().save(o);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void update(Object o) {
		getSessionFactory().update(o);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void delete(Object o) {
		getSessionFactory().update(o);

	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public Object getById(Long id, Class cls) {
		Session session = getSessionFactory();
		Criteria criteria = session.createCriteria(cls);
		criteria.add(Restrictions.eq("id", id));
		return criteria.uniqueResult();
	}

	public Object getAll(Class cls) {
		Session session = getSessionFactory();
		Criteria criteria = session.createCriteria(cls);
		return criteria.list();
	}

	public Object getAllbyOrder(Class cls, String column) {
		Session session = getSessionFactory();
		Criteria criteria = session.createCriteria(cls);
		criteria.addOrder(Order.asc(column));
		return criteria.list();
	}
}
