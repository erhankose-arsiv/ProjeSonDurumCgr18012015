package org.tutev.cagri.web.dto.personel;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.tutev.cagri.web.dto.Base;

@Entity
@Table(name="DTO_PERSONEL")
public class Personel extends Base{
	private static final long serialVersionUID = 1L;

	private Long id;
	private Long tc;
	private String adi;
	private String soyadi;
	private Date dogumTarihi;
	private String gorevi;
	private Long vergiNumarasi;
	private String eposta;
	private Date iseBaslamaTarihi;
	private Date istenAyrilmaTarihi;
	private int maas;
	private String cinsiyet;
	private String medeniHali;
	

	@Id
	@SequenceGenerator(allocationSize=1,initialValue=1,name="PERSONEL_ID_SEQ",sequenceName="PERSONEL_ID_SEQ")
	@GeneratedValue(generator="PERSONEL_ID_SEQ",strategy=GenerationType.SEQUENCE)
	@Column(name="ID")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="TC")
	public Long getTc() {
		return tc;
	}
	public void setTc(Long tc) {
		this.tc = tc;
	}
	
	@Column(name="AD")
	public String getAdi() {
		return adi;
	}
	public void setAdi(String adi) {
		this.adi = adi;
	}
	
	@Column(name="Soyad")
	public String getSoyadi() {
		return soyadi;
	}
	public void setSoyadi(String soyadi) {
		this.soyadi = soyadi;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name="DOGUM_TARÝH")
	public Date getDogumTarihi() {
		return dogumTarihi;
	}
	public void setDogumTarihi(Date dogumTarihi) {
		this.dogumTarihi = dogumTarihi;
	}
	
	@Column(name="GOREV")
	public String getGorevi() {
		return gorevi;
	}
	public void setGorevi(String gorevi) {
		this.gorevi = gorevi;
	}
	
	@Column(name="VERGÝNUMARASI")
	public Long getVergiNumarasi() {
		return vergiNumarasi;
	}
	public void setVergiNumarasi(Long vergiNumarasi) {
		this.vergiNumarasi = vergiNumarasi;
	}
	
	@Column(name="EPOSTA")
	public String getEposta() {
		return eposta;
	}
	public void setEposta(String eposta) {
		this.eposta = eposta;
	}
	
	@Column(name="BASLAMA_TARÝHÝ")
	public Date getIseBaslamaTarihi() {
		return iseBaslamaTarihi;
	}
	public void setIseBaslamaTarihi(Date iseBaslamaTarihi) {
		this.iseBaslamaTarihi = iseBaslamaTarihi;
	}
	
	@Column(name="AYRÝLMA_TARÝHÝ")
	public Date getIstenAyrilmaTarihi() {
		return istenAyrilmaTarihi;
	}
	public void setIstenAyrilmaTarihi(Date istenAyrilmaTarihi) {
		this.istenAyrilmaTarihi = istenAyrilmaTarihi;
	}
	
	@Column(name="MAAS")
	public int getMaas() {
		return maas;
	}
	public void setMaas(int maas) {
		this.maas = maas;
	}
	
	@Column(name="CÝNSÝYET")
	public String getCinsiyet() {
		return cinsiyet;
	}
	public void setCinsiyet(String cinsiyet) {
		this.cinsiyet = cinsiyet;
	}
	
	@Column(name="MEDENÝHAL")
	public String getMedeniHali() {
		return medeniHali;
	}
	public void setMedeniHali(String medeniHali) {
		this.medeniHali = medeniHali;
	}
	
	
}
