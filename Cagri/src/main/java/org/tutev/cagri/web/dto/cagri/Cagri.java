package org.tutev.cagri.web.dto.cagri;

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

import org.tutev.cagri.web.dto.Base;
import org.tutev.cagri.web.dto.firma.Firmalar;
import org.tutev.cagri.web.dto.genel.Adres;
import org.tutev.cagri.web.dto.genel.Il;
import org.tutev.cagri.web.dto.genel.Ilce;
import org.tutev.cagri.web.dto.personel.Personel;

@Entity
@Table(name="CGR_CAGRI")
public class Cagri extends Base {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1717263007061985016L;
	Long id;
	Date gelisTarihi;
	Date atanmaTarihi;
	Firmalar cagriSahibiFirma;
	Personel ilgiliPersonel;
	Personel capersonel;
	Il il;
	Ilce ilce;
	Adres adres;
	String cagriBildirim;
		
	
	@Id 
	@SequenceGenerator(allocationSize=1,initialValue=1,name="CAGRI_ID_SEQ",sequenceName="CAGRI_ID_SEQ")
	@GeneratedValue(generator="CAGRI_ID_SEQ",strategy=GenerationType.SEQUENCE)
	@Column(name="ID")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="GELIS_TARIHI")
	public Date getGelisTarihi() {
		return gelisTarihi;
	}
	public void setGelisTarihi(Date gelisTarihi) {
		this.gelisTarihi = gelisTarihi;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ATANMA_TARIHI")
	public Date getAtanmaTarihi() {
		return atanmaTarihi;
	}
	public void setAtanmaTarihi(Date atanmaTarihi) {
		this.atanmaTarihi = atanmaTarihi;
	}
	
	@JoinColumn(name="CAGRI_SAHIBI_FIRMA_ID")
	@ManyToOne(optional=true)
	public Firmalar getCagriSahibiFirma() {
		return cagriSahibiFirma;
	}
	public void setCagriSahibiFirma(Firmalar cagriSahibiFirma) {
		this.cagriSahibiFirma = cagriSahibiFirma;
	}
	
	@JoinColumn(name="ILGILI_PERSONEL_ID")
	@ManyToOne(fetch=FetchType.LAZY,optional=true)
	public Personel getIlgiliPersonel() {
		return ilgiliPersonel;
	}
	public void setIlgiliPersonel(Personel ilgiliPersonel) {
		this.ilgiliPersonel = ilgiliPersonel;
	}
	
	@JoinColumn(name="CAGRI_ALICI_PERSONEL_ID")
	@ManyToOne(fetch=FetchType.LAZY,optional=true)
	public Personel getCapersonel() {
		return capersonel;
	}
	public void setCapersonel(Personel capersonel) {
		this.capersonel = capersonel;
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
	
	@JoinColumn(name="ADRES_ID")
	@ManyToOne(fetch=FetchType.LAZY,optional=true)
	public Adres getAdres() {
		return adres;
	}
	public void setAdres(Adres adres) {
		this.adres = adres;
	}
	
	@Column(name="CAGRI_BILDIRIM",length=200)
	public String getCagriBildirim() {
		return cagriBildirim;
	}
	public void setCagriBildirim(String cagriBildirim) {
		this.cagriBildirim = cagriBildirim;
	}
	
	
	
	

}
