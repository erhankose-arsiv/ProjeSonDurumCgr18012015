package org.tutev.cagri.web.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Iletisim implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4864602373754311866L;
	String tel1;
	String tel2;
	String eposta1;
	String eposta2;
	
	@Column(name="TEL1",length=13)
	public String getTel1() {
		return tel1;
	}
	public void setTel1(String tel1) {
		this.tel1 = tel1;
	}
	
	@Column(name="TEL2",length=13)
	public String getTel2() {
		return tel2;
	}
	public void setTel2(String tel2) {
		this.tel2 = tel2;
	}
	
	@Column(name="EPOSTA1",length=60)
	public String getEposta1() {
		return eposta1;
	}
	public void setEposta1(String eposta1) {
		this.eposta1 = eposta1;
	}

	@Column(name="EPOSTA2",length=60)
	public String getEposta2() {
		return eposta2;
	}
	public void setEposta2(String eposta2) {
		this.eposta2 = eposta2;
	}
	
	
}
