package org.tutev.cagri.web.dto.stok;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "STOK_TURLERI")
@SequenceGenerator(name = "STOK_TUR_ID_SEQ")
public class StokTurleri implements Serializable {

	private long stokTurId;
	private String stokTurAdi;
	private Boolean aktif;

	public StokTurleri(String stokTurAdi, Boolean aktif) {
		this.stokTurAdi = stokTurAdi;
		this.aktif = aktif;
	}

	@Id
	@Column(name = "STOK_TUR_ID")
	@GeneratedValue(generator = "STOK_TUR_ID_SEQ", strategy = GenerationType.SEQUENCE)
	public long getStokTurId() {
		return stokTurId;
	}

	public void setStokTurId(long stokTurId) {
		this.stokTurId = stokTurId;
	}

	@Column(name = "STOK_TUR_ADI", length = 100)
	public String getStokTurAdi() {
		return stokTurAdi;
	}

	public void setStokTurAdi(String stokTurAdi) {
		this.stokTurAdi = stokTurAdi;
	}

	@Column(name = "AKTIF", length = 1)
	public Boolean getAktif() {
		return aktif;
	}

	public void setAktif(Boolean aktif) {
		this.aktif = aktif;
	}
}
