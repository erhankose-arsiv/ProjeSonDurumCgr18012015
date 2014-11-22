package org.tutev.cagri.web.dto.genel;

public class Dil {

	Long id;
	String tanim;
	Ulke ulke;
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
	public Ulke getUlke() {
		return ulke;
	}
	public void setUlke(Ulke ulke) {
		this.ulke = ulke;
	}
	public String getKod() {
		return kod;
	}
	public void setKod(String kod) {
		this.kod = kod;
	}
	
	
}
