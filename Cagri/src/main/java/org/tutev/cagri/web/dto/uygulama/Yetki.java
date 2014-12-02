package org.tutev.cagri.web.dto.uygulama;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.tutev.cagri.web.dto.genel.Kullanici;

@Entity
@Table(name = "AUTH_YETKI")
public class Yetki implements Serializable {

	private static final long serialVersionUID = -115329842183478917L;

	Long id;
	String yetkiTanim;
	List<Kullanici> kullaniciList;

	@Id
	@SequenceGenerator(allocationSize = 1, initialValue = 1, name = "YETKI_ID_SEQ", sequenceName = "YETKI_ID_SEQ")
	@GeneratedValue(generator = "YETKI_ID_SEQ", strategy = GenerationType.SEQUENCE)
	@Column(name = "ID")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "yetkiList")
	public List<Kullanici> getKullaniciList() {
		return kullaniciList;
	}

	public void setKullaniciList(List<Kullanici> kullaniciList) {
		this.kullaniciList = kullaniciList;
	}

	@Column(name = "TANIM", length = 150, nullable = false)
	public String getYetkiTanim() {
		return yetkiTanim;
	}

	public void setYetkiTanim(String yetkiTanim) {
		this.yetkiTanim = yetkiTanim;
	}

}
