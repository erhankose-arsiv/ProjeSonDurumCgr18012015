package org.tutev.cagri.web.controller.cagri;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
	List<Cagri> cagriList;
	
	@PostConstruct
	private void init() {		
		cagriList=cagriService.getAll();
		cagri=new Cagri();
	}
	
	public void save() {
		
		System.out.println(getCagri().getGelisTarihi());

	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public List<Cagri> getCagriList() {
		return cagriList;
	}
	
	public void setCagriList(List<Cagri> cagriList) {
		this.cagriList = cagriList;
	}
	
	
	public Cagri getCagri() {
		return cagri;
	}
	
	public void setCagri(Cagri cagri) {
		this.cagri = cagri;
	}
	

}
