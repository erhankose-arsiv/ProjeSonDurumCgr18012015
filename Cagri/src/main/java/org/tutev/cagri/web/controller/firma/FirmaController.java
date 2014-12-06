package org.tutev.cagri.web.controller.firma;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.tutev.cagri.web.dto.firma.Firmalar;
import org.tutev.cagri.web.service.firma.FirmaService;

@Controller("firmaController")
@Scope(value="session")
public class FirmaController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -631145089825443045L;
	
	Date date;
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Autowired
	private FirmaService firmaService;
	

	public Firmalar getFirmalar() {
		return firmalar;
	}

	public void setFirmalar(Firmalar firmalar) {
		this.firmalar = firmalar;
	}

	public List<Firmalar> getFirmaList() {
		return firmaList;
	}

	public void setFirmaList(List<Firmalar> firmaList) {
		this.firmaList = firmaList;
	}

	Firmalar firmalar;
	List<Firmalar> firmaList;

	@PostConstruct
	private void init(){
		firmaList = firmaService.getAll();
	}
}
