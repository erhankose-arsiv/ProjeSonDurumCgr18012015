package org.tutev.cagri.web.dto.envanter;

import java.io.Serializable;
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

import org.tutev.cagri.web.dto.stok.StokTurleri;


@Entity
@Table(name = "ENVANTER")
@SequenceGenerator(name = "ENVANTER_ID_SEQ", initialValue = 1, allocationSize = 1, sequenceName = "ENVANTER_ID_SEQ")
public class Envanter implements Serializable{
	
	private long envanterId;

	private String envanterAdi;
	private String envanterAciklamasi;
	private int envanterTuru;
	Date eklenmeTarihi;
	
	public Envanter ()
	{
		
	}
	
	
	
	
	public Envanter(long envanterId, String envanterAdi,
			String envanterAciklamasi, int envanterTuru, Date eklenmeTarihi) {
		super();
		this.envanterId = envanterId;
		this.envanterAdi = envanterAdi;
		this.envanterAciklamasi = envanterAciklamasi;
		this.envanterTuru = envanterTuru;
		this.eklenmeTarihi = eklenmeTarihi;
	}




	@Id
	@Column(name = "ENVANTER_ID")
	@GeneratedValue(generator = "ENVANTER_ID_SEQ", strategy = GenerationType.SEQUENCE)
	public long getEnvanterId() {
		return envanterId;
	}

	public void setEnvanterId(long envanterId) {
		this.envanterId = envanterId;
	}

	@Column(name = "ENVANTER_ADI", length = 100)
	public String getEnvanterAdi() {
		return envanterAdi;
	}

	public void setEnvanterAdi(String envanterAdi) {
		this.envanterAdi = envanterAdi;
	}

	@Column(name = "ENVANTER_ACIKLAMA", length = 100)
	public String getEnvanterAciklamasi() {
		return envanterAciklamasi;
	}

	public void setEnvanterAciklamasi(String envanterAciklamasi) {
		this.envanterAciklamasi = envanterAciklamasi;
	}

	@Column(name = "ENVANTER_TURU")
	public int getEnvanterTuru() {
		return envanterTuru;
	}

	public void setEnvanterTuru(int envanterTuru) {
		this.envanterTuru = envanterTuru;
	}




	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="EKLENME_TARIHI")
	public Date getEklenmeTarihi() {
		return eklenmeTarihi;
	}




	public void setEklenmeTarihi(Date eklenmeTarihi) {
		this.eklenmeTarihi = eklenmeTarihi;
	}
	
	
	
	
	

}
