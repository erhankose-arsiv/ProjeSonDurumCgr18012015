package org.tutev.cagri.web.dto.cagri;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.tutev.cagri.web.dto.Base;

@Entity
@Table(name="CGR_CAGRI_DURUM")
public class CagriDurum extends Base{

	private Long id;
	private String tanim;
	
	@Id 
	@SequenceGenerator(allocationSize=1,initialValue=1,name="CAGRI_DURUM_ID_SEQ",sequenceName="CAGRI_DURUM_ID_SEQ")
	@GeneratedValue(generator="CAGRI_DURUM_ID_SEQ",strategy=GenerationType.SEQUENCE)
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
	
	
	
}
