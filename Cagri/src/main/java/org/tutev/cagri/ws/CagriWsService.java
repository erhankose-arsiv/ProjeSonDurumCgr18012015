package org.tutev.cagri.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tutev.cagri.web.dto.cagri.Cagri;
import org.tutev.cagri.web.service.CagriService;

@Service("webService")
public class CagriWsService{

	@Autowired
	private transient CagriService  cagriService;
	
	public CagriServiceResponse cagriSorgula(String cagriNo,String kullaniciAdi,String sifre){
		
		if(kullaniciAdi==null || sifre==null || kullaniciAdi.trim().isEmpty() || sifre.trim().isEmpty()){
			return new CagriServiceResponse("Kullanýcý Adý veya Þifre Boþ Olmamalýdýr", Boolean.FALSE);
		}
		
		Cagri cagri= cagriService.getByCagriNo(cagriNo);
		
		if(cagri==null){
			return new CagriServiceResponse("Ýlgili Çaðrý Bulunamadý",Boolean.TRUE);
		}
		
		return new CagriServiceResponse(null, Boolean.TRUE,cagri);
	}
	
	
}
