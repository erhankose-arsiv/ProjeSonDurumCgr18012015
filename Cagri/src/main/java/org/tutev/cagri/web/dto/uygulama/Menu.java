package org.tutev.cagri.web.dto.uygulama;

import java.io.Serializable;

public class Menu implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Long id;
	String adi;
	int gosterimSirasi;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAdi() {
		return adi;
	}
	public void setAdi(String adi) {
		this.adi = adi;
	}
	public int getGosterimSirasi() {
		return gosterimSirasi;
	}
	
	
	public void setGosterimSirasi(int gosterimSirasi) {
		this.gosterimSirasi = gosterimSirasi;
	}
}
