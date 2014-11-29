package org.tutev.cagri.web.controller.cagri;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.tutev.cagri.web.dto.cagri.Cagri;
import org.tutev.cagri.web.service.CagriService;

@Controller("cagriController")
@Scope(value="session")
public class CagriController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2354524395435334338L;
	
	Date date;
	
	@Autowired
	private CagriService cagriService;
	
	Cagri cagri;
	
	@PostConstruct
	private void init() {		
		date=new Date();

	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	

}
