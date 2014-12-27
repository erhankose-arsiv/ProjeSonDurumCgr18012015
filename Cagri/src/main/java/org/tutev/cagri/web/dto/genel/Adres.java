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

import org.tutev.cagri.web.dto.Base;
import org.tutev.cagri.web.dto.genel.enm.AdresTip;

@Entity
@Table(name="GNL_ADRES")
public class Adres extends Base {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7240126492881621882L;
	Long id;
	Il il ;
	Ilce ilce;
	String adresSerbest;
	AdresTip adresTip;
	
	@Id
	@SequenceGenerator(allocationSize=1,initialValue=1,name="ADRES_ID_SEQ",sequenceName="ADRES_ID_SEQ")
	@GeneratedValue(generator="ADRES_ID_SEQ",strategy=GenerationType.SEQUENCE)
	@Column(name="ID")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@JoinColumn(name="IL_ID")
	@ManyToOne(fetch=FetchType.LAZY,optional=true)
	public Il getIl() {
		return il;
	}
	public void setIl(Il il) {
		this.il = il;
	}
	
	@JoinColumn(name="ILCE_ID")
	@ManyToOne(fetch=FetchType.LAZY,optional=true)
	public Ilce getIlce() {
		return ilce;
	}
	public void setIlce(Ilce ilce) {
		this.ilce = ilce;
	}
	
	@Column(length=500,name="ADRES_TANIM")
	public String getAdresSerbest() {
		return adresSerbest;
	}
	public void setAdresSerbest(String adresSerbest) {
		this.adresSerbest = adresSerbest;
	}
	
	@Column(name="ADRES_TIP")
	public AdresTip getAdresTip() {
		return adresTip;
	}
	public void setAdresTip(AdresTip adresTip) {
		this.adresTip = adresTip;
	}
	@Override
	public String toString() {
		return "Adres [adresSerbest=" + adresSerbest + ", adresTip=" + adresTip
				+ "]";
	}
	
	
}
