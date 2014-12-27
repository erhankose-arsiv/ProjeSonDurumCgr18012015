package org.tutev.cagri.ws;

import org.tutev.cagri.web.dto.cagri.Cagri;

public class CagriServiceResponse {

	public CagriServiceResponse(String hata, Boolean sonuc) {
		this.hata = hata;
		this.islemSonuc = sonuc;
	}

	
	public CagriServiceResponse(String hata, Boolean sonuc, Cagri cagri) {
		this.hata = hata;
		this.islemSonuc = sonuc;
		this.cagri=new WSCagri();
		this.cagri.cagriAciklama=cagri.getAciklama();
		this.cagri.cagriAdres=" ";
		this.cagri.cagriAtananPersonel="Taner TEST";
		this.cagri.cagriGelisTarihi=cagri.getGelisTarihi();
		this.cagri.cagriId=cagri.getId();
		this.cagri.cagriNo=cagri.getCagriNo();
		this.cagri.cagriOzet=cagri.getCagriOzet();
	}
	
	public CagriServiceResponse() {

	}

	Boolean islemSonuc;
	String hata;
	WSCagri cagri;
	public Boolean getIslemSonuc() {
		return islemSonuc;
	}

	public void setIslemSonuc(Boolean islemSonuc) {
		this.islemSonuc = islemSonuc;
	}

	public String getHata() {
		return hata;
	}

	public void setHata(String hata) {
		this.hata = hata;
	}

	public WSCagri getCagri() {
		return cagri;
	}

	public void setCagri(WSCagri cagri) {
		this.cagri = cagri;
	}
	
	
}
