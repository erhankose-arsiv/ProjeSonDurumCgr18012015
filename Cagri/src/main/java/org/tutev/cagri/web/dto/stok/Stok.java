package org.tutev.cagri.web.dto.stok;

import java.io.Serializable;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "STOK")
public class Stok implements Serializable {
	private long stokId;
	private String stokAdi;
	private String stokAciklamasi;
	private StokTurleri stokTurleri;
	private StokBirimleri stokBirimleri;
	private BigDecimal fiyati;

	public long getStokId() {
		return stokId;
	}

	public void setStokId(long stokId) {
		this.stokId = stokId;
	}

	public String getStokAdi() {
		return stokAdi;
	}

	public void setStokAdi(String stokAdi) {
		this.stokAdi = stokAdi;
	}

	public String getStokAciklamasi() {
		return stokAciklamasi;
	}

	public void setStokAciklamasi(String stokAciklamasi) {
		this.stokAciklamasi = stokAciklamasi;
	}

	public StokTurleri getStokTurleri() {
		return stokTurleri;
	}

	public void setStokTurleri(StokTurleri stokTurleri) {
		this.stokTurleri = stokTurleri;
	}

	public StokBirimleri getStokBirimleri() {
		return stokBirimleri;
	}

	public void setStokBirimleri(StokBirimleri stokBirimleri) {
		this.stokBirimleri = stokBirimleri;
	}

	public BigDecimal getFiyati() {
		return fiyati;
	}

	public void setFiyati(BigDecimal fiyati) {
		this.fiyati = fiyati;
	}

}
