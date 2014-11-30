package org.tutev.cagri.web.controller.personel;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.tutev.cagri.web.dto.personel.Personel;
import org.tutev.cagri.web.service.personelService.PersonelService;

@Controller("personelController")
@Scope(value="session")
public class PersonelController implements Serializable {
	private static final long serialVersionUID = 1L;

	Long tc;
	
	@Autowired
	private PersonelService personelService;
	
	Personel  personel;
	List<Personel> personelList;
	
	@PostConstruct
	public void init() {		
		personelList=personelService.getAll();
	}
	
	
	public Long getTc() {
		return tc;
	}


	public void setTc(Long tc) {
		this.tc = tc;
	}


	public List<Personel> getPersonelList() {
		return personelList;
	}


	public void setPersonelList(List<Personel> personelList) {
		this.personelList = personelList;
	}


	
}
