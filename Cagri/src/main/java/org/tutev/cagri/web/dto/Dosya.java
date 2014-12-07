package org.tutev.cagri.web.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name= "GNL_DOSYA")
public class Dosya extends Base{
	Long id;
	Byte[] dosya;
	DosyaTipEnm dosyaTip;
	String aciklama;
	
	
	@Id 
	@SequenceGenerator(allocationSize=1,initialValue=1,name="DOSYA_ID_SEQ",sequenceName="DOSYA_ID_SEQ")
	@GeneratedValue(generator="DOSYA_ID_SEQ",strategy=GenerationType.SEQUENCE)
	@Column(name="ID")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Lob
	@Column(name="DOSYA")
	public Byte[] getDosya() {
		return dosya;
	}
	public void setDosya(Byte[] dosya) {
		this.dosya = dosya;
	}
	
	@Column(name="DOSYA_TIP")
	public DosyaTipEnm getDosyaTip() {
		return dosyaTip;
	}
	public void setDosyaTip(DosyaTipEnm dosyaTip) {
		this.dosyaTip = dosyaTip;
	}
	
	@Column(name="ACIKLAMA",length=400)
	public String getAciklama() {
		return aciklama;
	}
	public void setAciklama(String aciklama) {
		this.aciklama = aciklama;
	}
	

}
