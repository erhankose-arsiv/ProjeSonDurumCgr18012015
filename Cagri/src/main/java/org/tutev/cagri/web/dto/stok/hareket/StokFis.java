package org.tutev.cagri.web.dto.stok.hareket;

import java.util.Date;

import javax.persistence.Entity;

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

import org.tutev.cagri.web.dto.Base;


@Entity
@Table(name = "STOK_FIS")
public class StokFis extends Base implements Serializable {

	private Long id;
	private Long fisNo;
	private Date tarih;
	private BigDecimal tutar;
	private String aciklama;

	public StokFis(Long id, Long fisNo, Date tarih, BigDecimal tutar, String aciklama) {

		this.id = id;
		this.fisNo = fisNo;
		this.tarih = tarih;
		this.tutar = tutar;
		
	}

	@Id
	@SequenceGenerator(allocationSize = 1, initialValue = 1, sequenceName = "STOK_FIS_SEQ", name = "STOK_FIS_SEQ")
	@GeneratedValue(generator = "STOK_FIS_SEQ", strategy = GenerationType.SEQUENCE)
	@Column(name = "STOK_FIS_ID")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "FIS_NO")
	public Long getFisNo() {
		return fisNo;
	}

	public void setFisNo(Long fisNo) {
		this.fisNo = fisNo;
	}

	@Column(name = "TARIH")
	public Date getTarih() {
		return tarih;
	}

	public void setTarih(Date tarih) {
		this.tarih = tarih;
	}

	@Column(name = "TUTAR")
	public BigDecimal getTutar() {
		return tutar;
	}

	public void setTutar(BigDecimal tutar) {
		this.tutar = tutar;
	}

	@Column(name = "ACIKLAMA")
	public String getAciklama() {
		return aciklama;
	}

	public void setAciklama(String aciklama) {
		this.aciklama = aciklama;
	}

}