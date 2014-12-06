package org.tutev.cagri.web.dto.cagri;

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
@Table(name="CGR_CAGRI_KATEGORI")
public class CagriKategori extends Base{

	private Long id;
	private String kod;
	private String tanim;
	private CagriKategori ustCagriKategori;
	
	
	@Id 
	@SequenceGenerator(allocationSize=1,initialValue=1,name="CAGRI_KATEGORI_ID_SEQ",sequenceName="CAGRI_KATEGORI_ID_SEQ")
	@GeneratedValue(generator="CAGRI_KATEGORI_ID_SEQ",strategy=GenerationType.SEQUENCE)
	@Column(name="ID")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="KOD",length=10)
	public String getKod() {
		return kod;
	}
	public void setKod(String kod) {
		this.kod = kod;
	}
	
	@Column(name="TANIM",length=40)
	public String getTanim() {
		return tanim;
	}
	public void setTanim(String tanim) {
		this.tanim = tanim;
	}
	
	@JoinColumn(name="UST_KATEGORI_ID")
	@ManyToOne(fetch=FetchType.LAZY,optional=true)
	public CagriKategori getUstCagriKategori() {
		return ustCagriKategori;
	}
	public void setUstCagriKategori(CagriKategori ustCagriKategori) {
		this.ustCagriKategori = ustCagriKategori;
	}

}
