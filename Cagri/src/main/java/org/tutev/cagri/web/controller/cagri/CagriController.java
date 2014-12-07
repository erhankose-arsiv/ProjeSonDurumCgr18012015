package org.tutev.cagri.web.controller.cagri;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.tutev.cagri.web.dto.cagri.Cagri;
import org.tutev.cagri.web.dto.genel.Il;
import org.tutev.cagri.web.service.CagriService;

@Controller("cagriController")
@Scope(value="view")
public class CagriController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2354524395435334338L;
	
	Date date;
	
	@Autowired
	private transient CagriService cagriService;
	
	Cagri cagri;
	List<Cagri> cagriList;
	Il il;
	
	@PostConstruct
	private void init() {	
		FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		cagriList=cagriService.getAll();
		il=new Il();
		cagri=new Cagri();
	}
	
	public void save() {
		
		System.out.println(cagri.getGelisTarihi());
		System.out.println(il.getTanim());

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
	
	public Il getIl() {
		return il;
	}
	
	public void setIl(Il il) {
		this.il = il;
	}

}
