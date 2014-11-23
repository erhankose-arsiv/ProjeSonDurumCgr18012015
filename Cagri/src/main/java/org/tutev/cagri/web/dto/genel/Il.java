package org.tutev.cagri.web.dto.genel;

import java.io.Serializable;

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
@Table(name="GNL_IL")
public class Il implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6348290517025301487L;
	Long id;
	String tanim;
	Ulke ulke;
	String kod;
	
	
	@Id
	@SequenceGenerator(allocationSize=1,initialValue=1,name="IL_ID_SEQ",sequenceName="IL_ID_SEQ")
	@GeneratedValue(generator="IL_ID_SEQ",strategy=GenerationType.SEQUENCE)
	@Column(name="ID")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="TANIM",length=50)
	public String getTanim() {
		return tanim;
	}
	public void setTanim(String tanim) {
		this.tanim = tanim;
	}
	
	@Column(name="KOD",length=50)
	public String getKod() {
		return kod;
	}
	public void setKod(String kod) {
		this.kod = kod;
	}
	
	@JoinColumn(name="ULKE_ID")
	@ManyToOne(fetch=FetchType.LAZY,optional=true)
	public Ulke getUlke() {
		return ulke;
	}
	public void setUlke(Ulke ulke) {
		this.ulke = ulke;
	}

}
