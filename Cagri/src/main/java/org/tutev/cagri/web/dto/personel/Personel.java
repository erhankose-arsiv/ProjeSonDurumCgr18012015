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
	private int personel_tc;
	private String personel_adi;
	private String personel_soyadi;
	private Date personel_dogumtarihi;
	private String personel_gorevi;
	private String personel_vergiNumarasi;
	private String personel_eposta;
	private Date personel_iseBaslamaTarihi;
	private Date personel_istenAyrilmaTarihi;
	private int personel_maas;
	private String personel_cinsiyet;
	private String personel_medeniHali;
	

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
	public int getPersonel_tc() {
		return personel_tc;
	}
	public void setPersonel_tc(int personel_tc) {
		this.personel_tc = personel_tc;
	}
	
	@Column(name="ADI")
	public String getPersonel_adi() {
		return personel_adi;
	}
	public void setPersonel_adi(String personel_adi) {
		this.personel_adi = personel_adi;
	}
	
	@Column(name="SOYADI")
	public String getPersonel_soyadi() {
		return personel_soyadi;
	}
	public void setPersonel_soyadi(String personel_soyadi) {
		this.personel_soyadi = personel_soyadi;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name="DOGUM_TARIH")
	public Date getPersonel_dogumtarihi() {
		return personel_dogumtarihi;
	}
	public void setPersonel_dogumtarihi(Date personel_dogumtarihi) {
		this.personel_dogumtarihi = personel_dogumtarihi;
	}
	
	@Column(name="GOREVI")
	public String getPersonel_gorevi() {
		return personel_gorevi;
	}
	public void setPersonel_gorevi(String personel_gorevi) {
		this.personel_gorevi = personel_gorevi;
	}
	
	@Column(name="VERGINUMARASI")
	public String getPersonel_vergiNumarasi() {
		return personel_vergiNumarasi;
	}
	public void setPersonel_vergiNumarasi(String personel_vergiNumarasi) {
		this.personel_vergiNumarasi = personel_vergiNumarasi;
	}
	
	@Column(name="EPOSTA")
	public String getPersonel_eposta() {
		return personel_eposta;
	}
	public void setPersonel_eposta(String personel_eposta) {
		this.personel_eposta = personel_eposta;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name="BASLAMATARIHI")
	public Date getPersonel_iseBaslamaTarihi() {
		return personel_iseBaslamaTarihi;
	}
	public void setPersonel_iseBaslamaTarihi(Date personel_iseBaslamaTarihi) {
		this.personel_iseBaslamaTarihi = personel_iseBaslamaTarihi;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name="AYRILMATARIHI")
	public Date getPersonel_istenAyrilmaTarihi() {
		return personel_istenAyrilmaTarihi;
	}
	public void setPersonel_istenAyrilmaTarihi(Date personel_istenAyrilmaTarihi) {
		this.personel_istenAyrilmaTarihi = personel_istenAyrilmaTarihi;
	}
	
	@Column(name="MAAS")
	public int getPersonel_maas() {
		return personel_maas;
	}
	public void setPersonel_maas(int personel_maas) {
		this.personel_maas = personel_maas;
	}
	
	@Column(name="CINSIYET")
	public String getPersonel_cinsiyet() {
		return personel_cinsiyet;
	}
	public void setPersonel_cinsiyet(String personel_cinsiyet) {
		this.personel_cinsiyet = personel_cinsiyet;
	}
	
	@Column(name="MEDENI_HAL")
	public String getPersonel_medeniHali() {
		return personel_medeniHali;
	}
	public void setPersonel_medeniHali(String personel_medeniHali) {
		this.personel_medeniHali = personel_medeniHali;
	}
	

}
