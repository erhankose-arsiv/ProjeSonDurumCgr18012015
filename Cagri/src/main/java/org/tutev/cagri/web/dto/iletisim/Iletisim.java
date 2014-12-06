package org.tutev.cagri.web.dto.iletisim;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "GNL_ILETISIM")
@SequenceGenerator(allocationSize = 1, initialValue = 1, name = "ILETISIM_ID_SEQ", sequenceName = "ILETISIM_ID_SEQ")
public class Iletisim implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long Id;
	private String mesaj;
	private String gndrnKisi;
	private String aliciKisi;
	private Date msjTarih;
	
	public Iletisim(){
		
	}
	
	@Id
	@SequenceGenerator(allocationSize=1,initialValue=1,name="ILETISIM_ID_SEQ",sequenceName="ILETISIM_ID_SEQ")
	@GeneratedValue(generator="ILETISIM_ID_SEQ",strategy=GenerationType.SEQUENCE)
	@Column(name="ID")
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	
	@Column(name="MESAJ",length=200)
	public String getMesaj() {
		return mesaj;
	}
	public void setMesaj(String mesaj) {
		this.mesaj = mesaj;
	}
	
	@Column(name="GNDRN_KISI",length=200)
	public String getGndrnKisi() {
		return gndrnKisi;
	}

	public void setGndrnKisi(String gndrnKisi) {
		this.gndrnKisi = gndrnKisi;
	}
	@Column(name="ALICI_KISI",length=200)
	public String getAliciKisi() {
		return aliciKisi;
	}

	public void setAliciKisi(String aliciKisi) {
		this.aliciKisi = aliciKisi;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name="MESAJ_TARIHI")
	public Date getMsjTarih() {
		return msjTarih;
	}

	public void setMsjTarih(Date msjTarih) {
		this.msjTarih = msjTarih;
	}

	
	
	
}
