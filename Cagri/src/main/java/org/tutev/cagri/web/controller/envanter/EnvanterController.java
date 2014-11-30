package org.tutev.cagri.web.controller.envanter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.tutev.cagri.web.dto.envanter.Envanter;
import org.tutev.cagri.web.service.EnvanterService;



@Controller("envanterController")
@Scope(value="session")
public class EnvanterController implements Serializable{
	
	
	Date date;
	
	@Autowired
	private transient EnvanterService envanterService;

	Envanter envanter;
	List<Envanter> envList;
	
	@PostConstruct
	private void init() {	
		
		envList= envanterService.getAll();
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public EnvanterService getEnvanterService() {
		return envanterService;
	}

	public void setEnvanterService(EnvanterService envanterService) {
		this.envanterService = envanterService;
	}

	public Envanter getEnvanter() {
		return envanter;
	}

	public void setEnvanter(Envanter envanter) {
		this.envanter = envanter;
	}

	public List<Envanter> getEnvList() {
		return envList;
	}

	public void setEnvList(List<Envanter> envList) {
		this.envList = envList;
	}
	
	
}
