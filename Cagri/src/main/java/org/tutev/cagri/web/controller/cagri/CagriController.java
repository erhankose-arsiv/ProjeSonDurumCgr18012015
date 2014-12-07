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
@Scope(value = "view")
public class CagriController implements Serializable {

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
		listele();
		il = new Il();
		cagri = new Cagri();
	}

	private void listele() {
		cagriList = cagriService.getAll();
	}

	public void save() {
		if(cagri.getId()!=null){
			cagriService.save(cagri);
			cagri = new Cagri();
			listele();
		}else{
			cagriService.update(cagri);
			cagri = new Cagri();
			listele();
		}
	}

	public void delete() {
		cagriService.delete(cagri);
		listele();

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
		if(this.cagri==null){
			this.cagri=new Cagri();
			
		}
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
