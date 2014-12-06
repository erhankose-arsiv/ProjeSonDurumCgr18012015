package org.tutev.cagri.web.dto.genel;

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

@Entity
@Table(name="GNL_ILCE")
public class ParaBirim {
	
	Long id;
	String tanim;
	Ulke ulke;
	String kod;
	
	@Id
	@SequenceGenerator(allocationSize=1,initialValue=1,name="PARA_BIRIM_ID_SEQ",sequenceName="PARA_BIRIM_ID_SEQ")
	@GeneratedValue(generator="PARA_BIRIM_ID_SEQ",strategy=GenerationType.SEQUENCE)
	@Column(name="ID")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="TANIM")
	public String getTanim() {
		return tanim;
	}
	public void setTanim(String tanim) {
		this.tanim = tanim;
	}
	
	@JoinColumn(name="ULKE_ID")
	@ManyToOne(fetch=FetchType.LAZY,optional=true)
	public Ulke getUlke() {
		return ulke;
	}
	public void setUlke(Ulke ulke) {
		this.ulke = ulke;
	}
	
	@Column(name="KOD")
	public String getKod() {
		return kod;
	}
	public void setKod(String kod) {
		this.kod = kod;
	}
	
	

}
