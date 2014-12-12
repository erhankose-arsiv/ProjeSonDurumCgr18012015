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
@Table(name="GNL_ILCE")
public class Ilce implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6384692525787974914L;
	Long id;
	String tanim;
	Il il;
	String kod;
	
	
	@Id
	@SequenceGenerator(allocationSize=1,initialValue=1,name="ILCE_ID_SEQ",sequenceName="ILCE_ID_SEQ")
	@GeneratedValue(generator="ILCE_ID_SEQ",strategy=GenerationType.SEQUENCE)
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
	
	
	@JoinColumn(name="IL_ID")
	@ManyToOne(fetch=FetchType.LAZY,optional=true)
	public Il getIl() {
		return il;
	}
	public void setIl(Il il) {
		this.il = il;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (!(obj instanceof Ilce))
			return false;

		if (this != null && this.id != null) {
			Ilce other = (Ilce) obj;
			if (!this.id.equals(other.id))
				return false;
			return true;
		} else {
			return false;
		}
	}
}
