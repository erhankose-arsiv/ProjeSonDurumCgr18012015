package org.tutev.cagri.web.controller;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.faces.context.FacesContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller("messageProvider")
@Scope("singleton")
public class MessageProvider implements Serializable {

	public ResourceBundle getBundle() {
		try{
			FacesContext context = FacesContext.getCurrentInstance();
			Locale locale = new Locale("tr", "TR");
			if (context.getApplication().getResourceBundle(context, "labels")== null) {
				return ResourceBundle.getBundle("org.tutev.cagri.web.asdfgresources.trlabels",locale);
			}
			else {
				return context.getApplication().getResourceBundle(context, "labels");
			}
		}catch (Exception e) {
			return null;
		}
	}

	public String getValue(String key) {
		String result = null;
		try {
			result = getBundle().getString(key);
		} catch (Exception e) {
			result = "???" + key + "??? not found";
		}
		return result;
	}

	public String getValueWithParam(String key, String params[]) {
		String result = null;
		try {
			result = MessageFormat.format(getBundle().getString(key),(Object)params);
		} catch (MissingResourceException e) {
			result = "???" + key + "??? not found";
		}
		return result;
	}

}

