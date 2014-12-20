package org.tutev.cagri.web.base;

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
@Table(name= "GNL_EXCEPTION")
public class Exception{
	Long id;
	String mesaj;
	Date tarih;
	
	public Exception() {
	}
	
	public Exception(String mesaj) {
		this.mesaj=mesaj;
	}
	
	@Id
	@SequenceGenerator(allocationSize=1,initialValue=1,name="EXC_ID_SEQ",sequenceName="EXC_ID_SEQ")
	@GeneratedValue(generator="EXC_ID_SEQ",strategy=GenerationType.SEQUENCE)
	@Column(name="ID")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="MESAJ",length=4000)
	public String getMesaj() {
		return mesaj;
	}
	public void setMesaj(String mesaj) {
		this.mesaj = mesaj;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="TARIH")
	public Date getTarih() {
		return tarih;
	}
	public void setTarih(Date tarih) {
		this.tarih = tarih;
	}
	
}
