package org.tutev.cagri.web.dto.genel;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.tutev.cagri.web.dto.Base;

@Entity
@Table(name="GNL_KISI")
public class Kisi extends Base{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7013127868021865180L;
	Long id;
	String ad;
	String soyad;
	Date dogumTarihi;
	Il il;
	Ilce ilce;
	Kimlik kimlik;
	
	String adSoyad;
	
	@Id
	@SequenceGenerator(allocationSize=1,initialValue=1,name="KISI_ID_SEQ",sequenceName="KISI_ID_SEQ")
	@GeneratedValue(generator="KISI_ID_SEQ",strategy=GenerationType.SEQUENCE)
	@Column(name="ID")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="AD",length=50)
	public String getAd() {
		return ad;
	}
	public void setAd(String ad) {
		this.ad = ad;
	}
	
	@Column(name="SOYAD",length=50)
//	@NamedQuery(query=" from tbl_abc where kisiId=:id")
	public String getSoyad() {
		return soyad;
	}
	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name="DOGUM_TARIHI")
	public Date getDogumTarihi() {
		return dogumTarihi;
	}
	public void setDogumTarihi(Date dogumTarihi) {
		this.dogumTarihi = dogumTarihi;
	}
	
	@JoinColumn(name="IL_ID")
	@ManyToOne(fetch=FetchType.LAZY,optional=true)
	public Il getIl() {
		return il;
	}
	public void setIl(Il il) {
		this.il = il;
	}
	
	@JoinColumn(name="ILCE_ID")
	@ManyToOne(fetch=FetchType.LAZY,optional=true)
	public Ilce getIlce() {
		return ilce;
	}
	public void setIlce(Ilce ilce) {
		this.ilce = ilce;
	}
	
	@JoinColumn(name="KIMLIK_ID")
	@ManyToOne(fetch=FetchType.LAZY,optional=true)
	public Kimlik getKimlik() {
		return kimlik;
	}
	public void setKimlik(Kimlik kimlik) {
		this.kimlik = kimlik;
	}
	
	@Transient
	public String getAdSoyad() {
		return getAd() +" "+ getSoyad();
	}
}
