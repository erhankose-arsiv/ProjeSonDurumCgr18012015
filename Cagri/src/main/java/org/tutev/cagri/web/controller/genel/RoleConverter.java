package org.tutev.cagri.web.controller.genel;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.tutev.cagri.web.dto.kullanici.Role;
import org.tutev.cagri.web.service.GenericService;

@Controller("roleConverter")
@Scope("request")
public class RoleConverter implements Converter {
	
	@Autowired
	private GenericService genericService;

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		if (arg2 != null && !arg2.equals("")) {
			Role role = (Role) genericService.getRoleById(Long.parseLong(arg2));
			return role;
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		if (arg2 != null) {
			Role role = (Role) arg2;
			return String.valueOf(role.getId());
		}
		return "";
	}
}
