package org.tutev.cagri.web.dto.uygulama;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="MENU")
public class Menu implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Long id;
	String adi;
	int gosterimSirasi;
	
	@Id
	@SequenceGenerator(allocationSize=1,initialValue=1,name="MENU_ID_SEQ",sequenceName="MENU_ID_SEQ")
	@GeneratedValue(generator="MENU_ID_SEQ",strategy=GenerationType.SEQUENCE)
	@Column(name="ID")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="AD",length=150,nullable=false)
	public String getAdi() {
		return adi;
	}
	public void setAdi(String adi) {
		this.adi = adi;
	}
	
	@Column(name="SIRA",nullable=false)
	public int getGosterimSirasi() {
		return gosterimSirasi;
	}
	
	
	public void setGosterimSirasi(int gosterimSirasi) {
		this.gosterimSirasi = gosterimSirasi;
	}
}
