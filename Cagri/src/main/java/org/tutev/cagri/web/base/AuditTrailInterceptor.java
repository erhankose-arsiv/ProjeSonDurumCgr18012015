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
		setValue(currentState, propertyNames, "updtr",1);
		setValue(currentState, propertyNames, "updtm", new Date());
		return true;
	}

	public boolean onSave(Object entity, Serializable id, Object[] state,
		String[] propertyNames, Type[] types) {
		setValue(state, propertyNames, "crtr",1);
		setValue(state, propertyNames, "crtm", new Date());
		setValue(state, propertyNames, "state", Boolean.TRUE);
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
