package org.tutev.cagri.web.dto.firma;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "FIRMALAR", schema = "AKGUNGEN")
@SequenceGenerator(name = "MALZEMELER_SEQ", sequenceName = "AKGUNGEN.MALZEMELER_SEQ", allocationSize = 1)
public class Firmalar implements Serializable {

	private long firmaId;
	private String firmaAdi;
	private String yetkisi;
	private Date kurulusTarihi;

	@Id
	@Column(name = "FIRMA_ID")
	@SequenceGenerator(allocationSize = 1, initialValue = 1, name = "FIRMA_ID_SEQ", sequenceName = "FIRMA_ID_SEQ")
	@GeneratedValue(generator = "FIRMA_ID_SEQ", strategy = GenerationType.SEQUENCE)
	public long getFirmaId() {
		return firmaId;
	}

	public void setFirmaId(long firmaId) {
		this.firmaId = firmaId;
	}

	@Column(name = "FIRMA_ADI", length = 150)
	public String getFirmaAdi() {
		return firmaAdi;
	}

	public void setFirmaAdi(String firmaAdi) {
		this.firmaAdi = firmaAdi;
	}

	@Column(name = "YETKILISI", length = 200)
	public String getYetkisi() {
		return yetkisi;
	}

	public void setYetkisi(String yetkisi) {
		this.yetkisi = yetkisi;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "KURULUS_TARIHI")
	public Date getKurulusTarihi() {
		return kurulusTarihi;
	}

	public void setKurulusTarihi(Date kurulusTarihi) {
		this.kurulusTarihi = kurulusTarihi;
	}
}
