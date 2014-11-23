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

import org.tutev.cagri.web.dto.Base;

@Entity
@Table(name="GNL_KIMLIK")
public class Kimlik extends Base{

	/**
	 * 
	 */
	private static final long serialVersionUID = -851478863319032773L;
	Long id;
	String babaAdi;
	String anaAdi;
	Date verilisTarihi;
	Il kayitliOlduguIl;
	Ilce kayitliOlduguIlce;
	
	
	@Id
	@SequenceGenerator(allocationSize=1,initialValue=1,name="KIMLIK_ID_SEQ",sequenceName="KIMLIK_ID_SEQ")
	@GeneratedValue(generator="KIMLIK_ID_SEQ",strategy=GenerationType.SEQUENCE)
	@Column(name="ID")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="BABA_ADI",length=50)
	public String getBabaAdi() {
		return babaAdi;
	}
	public void setBabaAdi(String babaAdi) {
		this.babaAdi = babaAdi;
	}
	
	@Column(name="ANA_ADI",length=50)
	public String getAnaAdi() {
		return anaAdi;
	}
	public void setAnaAdi(String anaAdi) {
		this.anaAdi = anaAdi;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name="VERILIS_TARIHI")
	public Date getVerilisTarihi() {
		return verilisTarihi;
	}
	public void setVerilisTarihi(Date verilisTarihi) {
		this.verilisTarihi = verilisTarihi;
	}
	
	@JoinColumn(name="KAYITLI_OLDUGU_IL_ID")
	@ManyToOne(fetch=FetchType.LAZY,optional=true)
	public Il getKayitliOlduguIl() {
		return kayitliOlduguIl;
	}
	public void setKayitliOlduguIl(Il kayitliOlduguIl) {
		this.kayitliOlduguIl = kayitliOlduguIl;
	}
	
	@JoinColumn(name="KAYITLI_OLDUGU_ILCE_ID")
	@ManyToOne(fetch=FetchType.LAZY,optional=true)
	public Ilce getKayitliOlduguIlce() {
		return kayitliOlduguIlce;
	}
	public void setKayitliOlduguIlce(Ilce kayitliOlduguIlce) {
		this.kayitliOlduguIlce = kayitliOlduguIlce;
	}
	
	
	
}
