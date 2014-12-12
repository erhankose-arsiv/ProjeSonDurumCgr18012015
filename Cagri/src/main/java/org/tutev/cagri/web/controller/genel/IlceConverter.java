package org.tutev.cagri.web.controller.genel;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.tutev.cagri.web.dto.genel.Ilce;
import org.tutev.cagri.web.service.GenericService;

@Controller("ilceConverter")
@Scope(value = "request")
public class IlceConverter implements Converter {

	@Autowired
	private transient GenericService genericService;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		if (value != null && value.trim().length() > 0) {
			try {
				Ilce ilce= genericService.getIlceById(Long.parseLong(value));
				return ilce;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		} else {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if (value != null) {
			try {
				return String.valueOf(((Ilce) value).getId());
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		} else {
			return null;
		}
	}
}
