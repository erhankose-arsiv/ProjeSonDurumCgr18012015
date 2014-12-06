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
import org.tutev.cagri.web.dto.personel.Personel;

@Entity
@Table(name="CGR_CAGRI_TARIHCE")
public class CagriTarihce extends Base{
	private Long id;
	private Cagri cagri;
	private CagriDurum cagriDurum;
	private Personel atananPersonel;
	private String kullaniciAdiSoyadi;
	private String aciklama;
	private String durumAciklama;
	private Double gecenSure;
	private Date bitisTarihi;
	private Date hesaplamaTarihi;
	
	
	@Id 
	@SequenceGenerator(allocationSize=1,initialValue=1,name="CAGRI_TARIHCE_ID_SEQ",sequenceName="CAGRI_TARIHCE_ID_SEQ")
	@GeneratedValue(generator="CAGRI_TARIHCE_ID_SEQ",strategy=GenerationType.SEQUENCE)
	@Column(name="ID")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@JoinColumn(name="CAGRI_ID")
	@ManyToOne(fetch=FetchType.LAZY,optional=true)
	public Cagri getCagri() {
		return cagri;
	}
	public void setCagri(Cagri cagri) {
		this.cagri = cagri;
	}
	
	@JoinColumn(name="DURUM_ID")
	@ManyToOne(fetch=FetchType.LAZY,optional=true)
	public CagriDurum getCagriDurum() {
		return cagriDurum;
	}
	public void setCagriDurum(CagriDurum cagriDurum) {
		this.cagriDurum = cagriDurum;
	}
	
	@JoinColumn(name="PERSONEL_ID")
	@ManyToOne(fetch=FetchType.LAZY,optional=true)
	public Personel getAtananPersonel() {
		return atananPersonel;
	}
	public void setAtananPersonel(Personel atananPersonel) {
		this.atananPersonel = atananPersonel;
	}
	
	@Column(name="KULLANICI_AD_SOYAD")
	public String getKullaniciAdiSoyadi() {
		return kullaniciAdiSoyadi;
	}
	public void setKullaniciAdiSoyadi(String kullaniciAdiSoyadi) {
		this.kullaniciAdiSoyadi = kullaniciAdiSoyadi;
	}
	
	@Column(name="ACIKLAMA",length=400)
	public String getAciklama() {
		return aciklama;
	}
	public void setAciklama(String aciklama) {
		this.aciklama = aciklama;
	}
	
	@Column(name="DURUM_ACIKLAMA",length=400)
	public String getDurumAciklama() {
		return durumAciklama;
	}
	public void setDurumAciklama(String durumAciklama) {
		this.durumAciklama = durumAciklama;
	}
	
	@Column(name="GECEN_SURE")
	public Double getGecenSure() {
		return gecenSure;
	}
	public void setGecenSure(Double gecenSure) {
		this.gecenSure = gecenSure;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="BITIS_TARIHI")
	public Date getBitisTarihi() {
		return bitisTarihi;
	}
	public void setBitisTarihi(Date bitisTarihi) {
		this.bitisTarihi = bitisTarihi;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="HESAPLAMA_TARIHI")
	public Date getHesaplamaTarihi() {
		return hesaplamaTarihi;
	}
	public void setHesaplamaTarihi(Date hesaplamaTarihi) {
		this.hesaplamaTarihi = hesaplamaTarihi;
	}
	
	
}
