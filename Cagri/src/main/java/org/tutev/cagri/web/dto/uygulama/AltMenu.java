package org.tutev.cagri.web.dto.uygulama;

import java.io.Serializable;

public class AltMenu implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Long id;
	String adi;
	Menu menu;
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
	public Menu getMenu() {
		return menu;
	}
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	public int getGosterimSirasi() {
		return gosterimSirasi;
	}
	public void setGosterimSirasi(int gosterimSirasi) {
		this.gosterimSirasi = gosterimSirasi;
	}
	

}
