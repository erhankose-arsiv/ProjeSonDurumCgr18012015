package org.tutev.cagri.web.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public class Base implements Serializable{


	private static final long serialVersionUID = 7944513417983098893L;
	
	String ekleyen;
	String guncelleyen;
	Date eklemeTarihi;
	Date guncellemeTarihi;
	Boolean durum;
	
	@Column(name="EKLEYEN",length=100)
	public String getEkleyen() {
		return ekleyen;
	}
	public void setEkleyen(String ekleyen) {
		this.ekleyen = ekleyen;
	}
	
	@Column(name="GUNCELLEYEN",length=100)
	public String getGuncelleyen() {
		return guncelleyen;
	}
	public void setGuncelleyen(String guncelleyen) {
		this.guncelleyen = guncelleyen;
	}
	
	@Column(name="EKLEME_TARIHI")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getEklemeTarihi() {
		return eklemeTarihi;
	}
	public void setEklemeTarihi(Date eklemeTarihi) {
		this.eklemeTarihi = eklemeTarihi;
	}
	
	@Column(name="GUNCELLEME_TARIHI")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getGuncellemeTarihi() {
		return guncellemeTarihi;
	}
	public void setGuncellemeTarihi(Date guncellemeTarihi) {
		this.guncellemeTarihi = guncellemeTarihi;
	}
	
	
	@Column(name="DURUM")
	public Boolean getDurum() {
		return durum;
	}
	
	public void setDurum(Boolean durum) {
		this.durum = durum;
	}

}
