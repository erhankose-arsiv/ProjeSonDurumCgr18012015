package org.tutev.cagri.web.dto.demirbas;

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
@Table(name="DEMIRBAS")
public class Demirbas extends Base {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3871280197810399959L;
	@Id
	@SequenceGenerator(allocationSize=1,initialValue=1,name="DEMIRBAS_ID_SEQ",sequenceName="DEMIRBAS_ID_SEQ")
	@GeneratedValue(generator="DEMIRBAS_ID_SEQ",strategy=GenerationType.SEQUENCE)
	@Column(name="ID")
	Long id;
	
	@Column(name="AD",length=30,nullable=false)
	String ad;
	
	@Column(name="OZELLIKLER",length=200,nullable=true)
	String ozellikler;
	
	@Column(name="ACIKLAMA",length=200,nullable=true)
	String aciklama;
	
	@Column(name="AKTIF",nullable=false)
	boolean aktif;
	
	@Column(name="FATURA_TARIHI",nullable=false)
	@Temporal(TemporalType.TIME)
	Date faturaTarihi;
	
	@Column(name="FATURA_NO",nullable=false)
	int faturaNo;
	
	@Column(name="FIYAT",scale=2,precision=6)
	double fiyat;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public String getOzellikler() {
		return ozellikler;
	}

	public void setOzellikler(String ozellikler) {
		this.ozellikler = ozellikler;
	}

	public String getAciklama() {
		return aciklama;
	}

	public void setAciklama(String aciklama) {
		this.aciklama = aciklama;
	}

	public boolean isAktif() {
		return aktif;
	}

	public void setAktif(boolean aktif) {
		this.aktif = aktif;
	}

	public Date getFaturaTarihi() {
		return faturaTarihi;
	}

	public void setFaturaTarihi(Date faturaTarihi) {
		this.faturaTarihi = faturaTarihi;
	}

	public int getFaturaNo() {
		return faturaNo;
	}

	public void setFaturaNo(int faturaNo) {
		this.faturaNo = faturaNo;
	}

	public double getFiyat() {
		return fiyat;
	}

	public void setFiyat(double fiyat) {
		this.fiyat = fiyat;
	}
	
	
	
}
