package org.tutev.cagri.web.base;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;


class AuditTrailInterceptor extends EmptyInterceptor {

	private static final long serialVersionUID = -4139135162099210748L;

	
	public boolean onFlushDirty(Object entity, Serializable id,
		Object[] currentState, Object[] previousState,
		String[] propertyNames, Type[] types) {
		setValue(currentState, propertyNames, "guncelleyen",1);
		setValue(currentState, propertyNames, "guncellemeTarihi", new Date());
		return true;
	}

	@Override
	public boolean onSave(Object entity, Serializable id, Object[] state,
		String[] propertyNames, Type[] types) {
		setValue(state, propertyNames, "ekleyen",1);
		setValue(state, propertyNames, "eklemeTarihi", new Date());
		setValue(state, propertyNames, "durum", Boolean.TRUE);
		return true;
	}

	private void setValue(Object[] currentState, String[] propertyNames,
		String propertyToSet, Object value) {
		int index = Arrays.asList(propertyNames).indexOf(propertyToSet);
		if (index >= 0) {
			currentState[index] = value;
		}
	}
}
