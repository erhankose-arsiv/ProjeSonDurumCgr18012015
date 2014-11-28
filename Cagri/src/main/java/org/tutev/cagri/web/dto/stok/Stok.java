package org.tutev.cagri.web.dto.stok;

import java.io.Serializable;
import java.math.BigDecimal;

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

import org.tutev.cagri.web.dto.firma.Firmalar;

@Entity
@Table(name = "STOK")
@SequenceGenerator(name = "STOK_ID_SEQ", initialValue = 1, allocationSize = 1, sequenceName = "STOK_ID_SEQ")
public class Stok implements Serializable {
	private long stokId;

	private String stokAdi;
	private String stokAciklamasi;
	private StokTurleri stokTurleri;
	private StokBirimleri stokBirimleri;
	private Firmalar firmalar;
	private BigDecimal fiyati;

	public Stok(String stokAdi, String stokAciklamasi, StokTurleri stokTurleri,
			StokBirimleri stokBirimleri, Firmalar firmalar, BigDecimal fiyati) {
		this.stokAdi = stokAdi;
		this.stokAciklamasi = stokAciklamasi;
		this.stokTurleri = stokTurleri;
		this.stokBirimleri = stokBirimleri;
		this.firmalar = firmalar;
		this.fiyati = fiyati;
	}

	@Id
	@Column(name = "STOK_ID")
	@GeneratedValue(generator = "STOK_ID_SEQ", strategy = GenerationType.SEQUENCE)
	public long getStokId() {
		return stokId;
	}

	public void setStokId(long stokId) {
		this.stokId = stokId;
	}

	@Column(name = "STOK_ADI", length = 100)
	public String getStokAdi() {
		return stokAdi;
	}

	public void setStokAdi(String stokAdi) {
		this.stokAdi = stokAdi;
	}

	@Column(name = "STOK_ACIKLAMASI", length = 400)
	public String getStokAciklamasi() {
		return stokAciklamasi;
	}

	public void setStokAciklamasi(String stokAciklamasi) {
		this.stokAciklamasi = stokAciklamasi;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "STOK_TUR_ID")
	public StokTurleri getStokTurleri() {
		return stokTurleri;
	}

	public void setStokTurleri(StokTurleri stokTurleri) {
		this.stokTurleri = stokTurleri;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "STOK_BIRIMLERI_ID")
	public StokBirimleri getStokBirimleri() {
		return stokBirimleri;
	}

	public void setStokBirimleri(StokBirimleri stokBirimleri) {
		this.stokBirimleri = stokBirimleri;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FIRMA_ID")
	public Firmalar getFirmalar() {
		return firmalar;
	}

	public void setFirmalar(Firmalar firmalar) {
		this.firmalar = firmalar;
	}

	public BigDecimal getFiyati() {
		return fiyati;
	}

	@Column(name = "FIYATI", precision = 10, scale = 2)
	public void setFiyati(BigDecimal fiyati) {
		this.fiyati = fiyati;
	}
}
