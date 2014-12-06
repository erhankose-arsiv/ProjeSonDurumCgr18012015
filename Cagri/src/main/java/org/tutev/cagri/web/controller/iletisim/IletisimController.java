package org.tutev.cagri.web.controller.iletisim;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.tutev.cagri.web.dto.iletisim.Iletisim;
import org.tutev.cagri.web.service.iletisim.IletisimService;


@Controller("iletisimController")
@Scope(value="request")
public class IletisimController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private IletisimService iletisimService;
	
	Iletisim iletisim;
	List<Iletisim> iletisimList;
	
	@PostConstruct
	private void init() {		
		iletisimList=iletisimService.getAll();
	}

	public List<Iletisim> getIletisimList() {
		return iletisimList;
	}

	public void setIletisimList(List<Iletisim> iletisimList) {
		this.iletisimList = iletisimList;
	}
	

}
