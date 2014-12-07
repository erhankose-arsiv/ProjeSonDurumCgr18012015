package org.tutev.cagri.web.base;

import java.util.List;
import java.util.Locale;

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
public class BaseDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional(propagation = Propagation.REQUIRED)
	public void save(Object object) {
		try {
			getSession().save(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void update(Object object) {
		try {
			getSession().update(object);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(Object object) {
		try {
			getSession().delete(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Transactional(readOnly = true)
	public List getAll( Class cls) {
		Criteria criteria = getSession().createCriteria(cls);
//		criteria.add(Restrictions.eq("state", Boolean.TRUE));
		return criteria.list();
	}

//	@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
//	public QueryResult getAll(Criteria criteria, OrderData orderData,int firstRecord, int pageSize) {
//		criteria.add(Restrictions.eq("state", true));
//
//		QueryResult qr = new QueryResult();
//		criteria.setProjection(Projections.rowCount());
//		qr.setCount(((Long) criteria.uniqueResult()).intValue());
//
//		criteria.addOrder(Order.asc("id"));
//		criteria.setProjection(null);
//		criteria.setResultTransformer(Criteria.ROOT_ENTITY);
//		qr.setList(criteria.setFirstResult(firstRecord).setMaxResults(pageSize).list());
//
//		return qr;
//	}
	
	
	public Object getAllbyOrder(Class cls, String column) {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(cls);
		criteria.addOrder(Order.asc(column));
		return criteria.list();
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void saveOrUpdate(Object object) {
		try {
			getSession().saveOrUpdate(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Transactional(readOnly = true)
	public List getByCriteria(Criteria criteria) {
		return criteria.list();
	}

	@Transactional(readOnly = true)
	public Object getById(Long id, Class cls) {
		Criteria criteria = getSession().createCriteria(cls);
//		criteria.add(Restrictions.eq("state", Boolean.TRUE));
		criteria.add(Restrictions.eq("id", id));
		return criteria.uniqueResult();
	}

	public Session getSession() {
		Locale.setDefault(Locale.ENGLISH);
		return getSessionFactory().getCurrentSession();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
