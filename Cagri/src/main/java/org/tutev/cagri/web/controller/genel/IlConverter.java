package org.tutev.cagri.web.controller.genel;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.tutev.cagri.web.dto.genel.Il;
import org.tutev.cagri.web.service.GenericService;

@Controller("ilConverter")
@Scope(value = "request")
public class IlConverter implements Converter {

	@Autowired
	private transient GenericService genericService;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		if (value != null && value.trim().length() > 0) {
			try {
				Il il= genericService.getIlById(Long.parseLong(value));
				return il;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
//				throw new ConverterException(new FacesMessage(
//						FacesMessage.SEVERITY_ERROR, "Conversion Error",
//						"Not a valid Il."));
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
				return String.valueOf(((Il) value).getId());
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		} else {
			return null;
		}
	}
}
