package org.tutev.cagri.web.dto.genel;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="GNL_DIL")
public class Dil implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6122778850161806635L;
	Long id;
	String tanim;
	String kod;
	
	
	@Id
	@SequenceGenerator(allocationSize=1,initialValue=1,name="DIL_ID_SEQ",sequenceName="DIL_ID_SEQ")
	@GeneratedValue(generator="DIL_ID_SEQ",strategy=GenerationType.SEQUENCE)
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
	
}
