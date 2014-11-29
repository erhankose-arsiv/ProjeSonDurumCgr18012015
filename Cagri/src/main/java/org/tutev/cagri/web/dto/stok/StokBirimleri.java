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
@Table(name = "STOK_BIRIMLERI")
@SequenceGenerator(name = "STOK_BIRIMLERI_ID_SEQ", sequenceName = "STOK_BIRIMLERI_ID_SEQ", allocationSize = 1, initialValue = 1)
public class StokBirimleri implements Serializable {

	private long stokBirimleriId;
	private String birim;
	private Boolean aktif;

	public StokBirimleri(String birim, Boolean aktif) {
		this.birim = birim;
		this.aktif = aktif;
	}

	@Id
	@Column(name = "STOK_BIRIMLERI_ID")
	@GeneratedValue(generator = "STOK_BIRIMLERI_ID_SEQ", strategy = GenerationType.SEQUENCE)
	public long getStokBirimleriId() {
		return stokBirimleriId;
	}

	public void setStokBirimleriId(long stokBirimleriId) {
		this.stokBirimleriId = stokBirimleriId;
	}

	@Column(name = "FIRMA_ADI", length = 400)
	public String getBirim() {
		return birim;
	}

	public void setBirim(String birim) {
		this.birim = birim;
	}

	@Column(name = "AKTIF", length = 1)
	public Boolean getAktif() {
		return aktif;
	}

	public void setAktif(Boolean aktif) {
		this.aktif = aktif;
	}
}
