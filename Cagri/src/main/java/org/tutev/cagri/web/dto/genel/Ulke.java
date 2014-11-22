package org.tutev.cagri.web.dto.genel;

import java.io.Serializable;

public class Ulke implements Serializable{
	
	Long id;
	String tanim;
	String kod;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTanim() {
		return tanim;
	}
	public void setTanim(String tanim) {
		this.tanim = tanim;
	}
	public String getKod() {
		return kod;
	}
	public void setKod(String kod) {
		this.kod = kod;
	}
	
	

}
