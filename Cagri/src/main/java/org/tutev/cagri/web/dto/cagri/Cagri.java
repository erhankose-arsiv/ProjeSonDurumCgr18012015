package org.tutev.cagri.web.dto.cagri;

import java.util.Date;

import javax.persistence.CascadeType;
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

import org.hibernate.annotations.Index;
import org.tutev.cagri.web.dto.Base;
import org.tutev.cagri.web.dto.firma.Firmalar;
import org.tutev.cagri.web.dto.genel.Adres;
import org.tutev.cagri.web.dto.genel.Il;
import org.tutev.cagri.web.dto.genel.Ilce;
import org.tutev.cagri.web.dto.genel.Kullanici;
import org.tutev.cagri.web.dto.genel.ParaBirim;
import org.tutev.cagri.web.dto.personel.Personel;

@Entity
@Table(name="CGR_CAGRI")
public class Cagri extends Base {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1717263007061985016L;
	private Long id;
	private Date gelisTarihi;
	private Date atanmaTarihi;
	private Firmalar cagriSahibiFirma;
	private Personel ilgiliPersonel;
	private Personel capersonel;
	private Il il;
	private Ilce ilce;
	private Adres adres;
	private String cagriBildirim;

	private String cagriNo;
	private String musteriCagriReferans;
	private String tedarikciCagriReferans;
	private String cagriOzet;
	private String aciklama;
	private String cozumAciklama;
	
	private String durumAciklama;
	private String durumAciklamaEski;
	private CagriKategori cagriKategori1;
	private CagriKategori cagriKategori2;
	private CagriKategori cagriKategori3;
	private CagriKategori cagriKategori4;
	private CagriGelisTipEnm cagriGelisTip;
	private Date planliIsTarihi;

//	private SkartKategori skartKategori1;
//	private Envanter envanter;
	private String envanterReferansNo;

	private Boolean ucretli;
	private Date acilisTarihi;
	private Date kapanisTarihi;
	private Date cozumTarihi;
	private Kullanici kullanici;
//	private OrganizasyonBolum atananOrganizasyonBolum;
	private Personel cagriSahibiPersonel;
	private Personel atananPersonel;
	private Personel atananPersonelEski;
	private Boolean onayli;

	private CagriTarihce sonCagriTarihce;

	private Double mudahaleSuresiToplam;
	private Double cozumSuresiToplam;
	private Double konsinyeSuresiToplam;	
	private Double mudahaleSuresiKalan;
	private Double cozumSuresiKalan;
	
	private Boolean cagriSahibineMailBildirimi=Boolean.FALSE;

	private ParaBirim paraBirim;
	private Double birimFiyat;

	private Integer lokasyonaGidisSayisi;
	
	
		
	
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
	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL,optional=true)
	public Il getIl() {
		return il;
	}
	public void setIl(Il il) {
		this.il = il;
	}
	
	@JoinColumn(name="ILCE_ID")
	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL,optional=true)
	public Ilce getIlce() {
		return ilce;
	}
	public void setIlce(Ilce ilce) {
		this.ilce = ilce;
	}
	
	@JoinColumn(name="ADRES_ID")
	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL,optional=true)
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
	
	
	@Index(name="CGR_IND_CAGRINO")
	@Column(name="CAGRI_NO",length=15)
	public String getCagriNo() {
		return cagriNo;
	}
	public void setCagriNo(String cagriNo) {
		this.cagriNo = cagriNo;
	}
	
	@Column(name="CAGRI_REF_NO",length=15)
	public String getMusteriCagriReferans() {
		return musteriCagriReferans;
	}
	public void setMusteriCagriReferans(String musteriCagriReferans) {
		this.musteriCagriReferans = musteriCagriReferans;
	}
	
	@Column(name="CAGRI_TED_REF_NO",length=15)
	public String getTedarikciCagriReferans() {
		return tedarikciCagriReferans;
	}
	public void setTedarikciCagriReferans(String tedarikciCagriReferans) {
		this.tedarikciCagriReferans = tedarikciCagriReferans;
	}
	
	@Column(name="CAGRI_OZET",length=4000)
	public String getCagriOzet() {
		return cagriOzet;
	}
	public void setCagriOzet(String cagriOzet) {
		this.cagriOzet = cagriOzet;
	}
	
	@Column(name="ACIKLAMA",length=4000)
	public String getAciklama() {
		return aciklama;
	}
	public void setAciklama(String aciklama) {
		this.aciklama = aciklama;
	}
	
	@Column(name="COZUM_ACIKLAMA",length=4000)
	public String getCozumAciklama() {
		return cozumAciklama;
	}
	public void setCozumAciklama(String cozumAciklama) {
		this.cozumAciklama = cozumAciklama;
	}
	
	@Column(name="DURUM_ACIKLAMA",length=200)
	public String getDurumAciklama() {
		return durumAciklama;
	}
	public void setDurumAciklama(String durumAciklama) {
		this.durumAciklama = durumAciklama;
	}
	
	@Column(name="DURUM_ACIKLAMA_ESKI",length=4000)
	public String getDurumAciklamaEski() {
		return durumAciklamaEski;
	}
	public void setDurumAciklamaEski(String durumAciklamaEski) {
		this.durumAciklamaEski = durumAciklamaEski;
	}
	
	@JoinColumn(name="KATEGORI_ID1")
	@ManyToOne(fetch=FetchType.LAZY,optional=true)
	public CagriKategori getCagriKategori1() {
		return cagriKategori1;
	}
	public void setCagriKategori1(CagriKategori cagriKategori1) {
		this.cagriKategori1 = cagriKategori1;
	}
	
	@JoinColumn(name="KATEGORI_ID2")
	@ManyToOne(fetch=FetchType.LAZY,optional=true)
	public CagriKategori getCagriKategori2() {
		return cagriKategori2;
	}
	public void setCagriKategori2(CagriKategori cagriKategori2) {
		this.cagriKategori2 = cagriKategori2;
	}
	
	@JoinColumn(name="KATEGORI_ID3")
	@ManyToOne(fetch=FetchType.LAZY,optional=true)
	public CagriKategori getCagriKategori3() {
		return cagriKategori3;
	}
	public void setCagriKategori3(CagriKategori cagriKategori3) {
		this.cagriKategori3 = cagriKategori3;
	}
	
	@JoinColumn(name="KATEGORI_ID4")
	@ManyToOne(fetch=FetchType.LAZY,optional=true)
	public CagriKategori getCagriKategori4() {
		return cagriKategori4;
	}
	public void setCagriKategori4(CagriKategori cagriKategori4) {
		this.cagriKategori4 = cagriKategori4;
	}
	
	@Column(name="GELIS_TIP")
	public CagriGelisTipEnm getCagriGelisTip() {
		return cagriGelisTip;
	}
	public void setCagriGelisTip(CagriGelisTipEnm cagriGelisTip) {
		this.cagriGelisTip = cagriGelisTip;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="PLANLI_IS_TARIHI")
	public Date getPlanliIsTarihi() {
		return planliIsTarihi;
	}
	public void setPlanliIsTarihi(Date planliIsTarihi) {
		this.planliIsTarihi = planliIsTarihi;
	}
	
	@Column(name="ENV_REF_NO")
	public String getEnvanterReferansNo() {
		return envanterReferansNo;
	}
	public void setEnvanterReferansNo(String envanterReferansNo) {
		this.envanterReferansNo = envanterReferansNo;
	}
	
	@Column(name="UCRETLI")
	public Boolean getUcretli() {
		return ucretli;
	}
	public void setUcretli(Boolean ucretli) {
		this.ucretli = ucretli;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ACILIS_TARIHI")
	public Date getAcilisTarihi() {
		return acilisTarihi;
	}
	public void setAcilisTarihi(Date acilisTarihi) {
		this.acilisTarihi = acilisTarihi;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="KAPANIS_TARIHI")
	public Date getKapanisTarihi() {
		return kapanisTarihi;
	}
	public void setKapanisTarihi(Date kapanisTarihi) {
		this.kapanisTarihi = kapanisTarihi;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="COZUM_TARIHI")
	public Date getCozumTarihi() {
		return cozumTarihi;
	}
	public void setCozumTarihi(Date cozumTarihi) {
		this.cozumTarihi = cozumTarihi;
	}
	
	@JoinColumn(name="KULLANICI_ID")
	@ManyToOne(fetch=FetchType.LAZY,optional=true)
	public Kullanici getKullanici() {
		return kullanici;
	}
	public void setKullanici(Kullanici kullanici) {
		this.kullanici = kullanici;
	}
	
	@JoinColumn(name="PERSONEL_ID")
	@ManyToOne(fetch=FetchType.LAZY,optional=true)
	public Personel getCagriSahibiPersonel() {
		return cagriSahibiPersonel;
	}
	public void setCagriSahibiPersonel(Personel cagriSahibiPersonel) {
		this.cagriSahibiPersonel = cagriSahibiPersonel;
	}
	
	
	@JoinColumn(name="ATANAN_PERSONEL_ID")
	@ManyToOne(fetch=FetchType.LAZY,optional=true)
	public Personel getAtananPersonel() {
		return atananPersonel;
	}
	public void setAtananPersonel(Personel atananPersonel) {
		this.atananPersonel = atananPersonel;
	}
	
	@JoinColumn(name="ATANAN_ESKI_PERSONEL_ID")
	@ManyToOne(fetch=FetchType.LAZY,optional=true)
	public Personel getAtananPersonelEski() {
		return atananPersonelEski;
	}
	public void setAtananPersonelEski(Personel atananPersonelEski) {
		this.atananPersonelEski = atananPersonelEski;
	}
	
	@Column(name="ONAYLI")
	public Boolean getOnayli() {
		return onayli;
	}
	public void setOnayli(Boolean onayli) {
		this.onayli = onayli;
	}
	
	@JoinColumn(name="SON_TARIHCE_ID")
	@ManyToOne(fetch=FetchType.LAZY,optional=true)
	public CagriTarihce getSonCagriTarihce() {
		return sonCagriTarihce;
	}
	public void setSonCagriTarihce(CagriTarihce sonCagriTarihce) {
		this.sonCagriTarihce = sonCagriTarihce;
	}
	
	@Column(name="MUDAHALE_SURESI_TOPLAM")
	public Double getMudahaleSuresiToplam() {
		return mudahaleSuresiToplam;
	}
	public void setMudahaleSuresiToplam(Double mudahaleSuresiToplam) {
		this.mudahaleSuresiToplam = mudahaleSuresiToplam;
	}
	
	@Column(name="COZUM_SURESI_TOPLAM")
	public Double getCozumSuresiToplam() {
		return cozumSuresiToplam;
	}
	public void setCozumSuresiToplam(Double cozumSuresiToplam) {
		this.cozumSuresiToplam = cozumSuresiToplam;
	}
	
	@Column(name="KONSINYE_SURESI_TOPLAM")
	public Double getKonsinyeSuresiToplam() {
		return konsinyeSuresiToplam;
	}
	public void setKonsinyeSuresiToplam(Double konsinyeSuresiToplam) {
		this.konsinyeSuresiToplam = konsinyeSuresiToplam;
	}
	
	@Column(name="MUDAHALE_SURESI_KALAN")
	public Double getMudahaleSuresiKalan() {
		return mudahaleSuresiKalan;
	}
	public void setMudahaleSuresiKalan(Double mudahaleSuresiKalan) {
		this.mudahaleSuresiKalan = mudahaleSuresiKalan;
	}
	
	@Column(name="COZUM_SURESI_KALAN")
	public Double getCozumSuresiKalan() {
		return cozumSuresiKalan;
	}
	public void setCozumSuresiKalan(Double cozumSuresiKalan) {
		this.cozumSuresiKalan = cozumSuresiKalan;
	}
	
	@Column(name="MAIL_BILDIRIM")
	public Boolean getCagriSahibineMailBildirimi() {
		return cagriSahibineMailBildirimi;
	}
	public void setCagriSahibineMailBildirimi(Boolean cagriSahibineMailBildirimi) {
		this.cagriSahibineMailBildirimi = cagriSahibineMailBildirimi;
	}
	
	@JoinColumn(name="PARA_BIRIM_ID")
	@ManyToOne(fetch=FetchType.LAZY,optional=true)
	public ParaBirim getParaBirim() {
		return paraBirim;
	}
	public void setParaBirim(ParaBirim paraBirim) {
		this.paraBirim = paraBirim;
	}
	
	@Column(name="BIRIM_FIYAT")
	public Double getBirimFiyat() {
		return birimFiyat;
	}
	public void setBirimFiyat(Double birimFiyat) {
		this.birimFiyat = birimFiyat;
	}
	
	@Column(name="GIDIS_SAYISI")
	public Integer getLokasyonaGidisSayisi() {
		return lokasyonaGidisSayisi;
	}
	public void setLokasyonaGidisSayisi(Integer lokasyonaGidisSayisi) {
		this.lokasyonaGidisSayisi = lokasyonaGidisSayisi;
	}
	


}
