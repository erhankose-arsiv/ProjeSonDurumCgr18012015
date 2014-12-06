package org.tutev.cagri.web.controller.stok.hareket;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.tutev.cagri.web.dto.cagri.Cagri;
import org.tutev.cagri.web.dto.stok.hareket.StokHareket;
import org.tutev.cagri.web.service.CagriService;
import org.tutev.cagri.web.service.StokHareketService;

@Controller("stokHareketController")
@Scope(value="session")
public class StokHareketController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2354524395435334338L;
	
	Date date;
	
	@Autowired
	private StokHareketService stokHareketService;
	
	StokHareket stokHareket;
	List<StokHareket> stokHareketList;
	
	@PostConstruct
	private void init() {		
		stokHareketList=stokHareketService.getAll();
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public List<StokHareket> getStokHareketList() {
		return stokHareketList;
	}
	
	public void setCagriList(List<Cagri> cagriList) {
		this.stokHareketList = stokHareketList;
	}
	
	

}
