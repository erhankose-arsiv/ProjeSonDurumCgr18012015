package org.tutev.cagri.ws;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;

public class WSCagri {
	
//	@XmlElement(name="incidentId")
	Long cagriId;
	String cagriNo;
	Date cagriGelisTarihi;
	String cagriAdres;
	String cagriAciklama;
	String cagriAtananPersonel;
	String cagriOzet;
	
	public Long getCagriId() {
		return cagriId;
	}
	public void setCagriId(Long cagriId) {
		this.cagriId = cagriId;
	}
	public String getCagriNo() {
		return cagriNo;
	}
	public void setCagriNo(String cagriNo) {
		this.cagriNo = cagriNo;
	}
	public Date getCagriGelisTarihi() {
		return cagriGelisTarihi;
	}
	public void setCagriGelisTarihi(Date cagriGelisTarihi) {
		this.cagriGelisTarihi = cagriGelisTarihi;
	}
	public String getCagriAdres() {
		return cagriAdres;
	}
	public void setCagriAdres(String cagriAdres) {
		this.cagriAdres = cagriAdres;
	}
	public String getCagriAciklama() {
		return cagriAciklama;
	}
	public void setCagriAciklama(String cagriAciklama) {
		this.cagriAciklama = cagriAciklama;
	}
	public String getCagriAtananPersonel() {
		return cagriAtananPersonel;
	}
	public void setCagriAtananPersonel(String cagriAtananPersonel) {
		this.cagriAtananPersonel = cagriAtananPersonel;
	}
	public String getCagriOzet() {
		return cagriOzet;
	}
	public void setCagriOzet(String cagriOzet) {
		this.cagriOzet = cagriOzet;
	}
	
}
