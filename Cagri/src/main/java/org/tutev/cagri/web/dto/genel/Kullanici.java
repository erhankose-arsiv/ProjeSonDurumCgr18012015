package org.tutev.cagri.web.dto.genel;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.tutev.cagri.web.dto.Base;
import org.tutev.cagri.web.dto.Iletisim;
import org.tutev.cagri.web.dto.uygulama.Yetki;

@Entity
@Table(name = "AUTH_KULLANICI")
public class Kullanici extends Base {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3803182076558009777L;
	Long id;
	String username;
	String password;
	Kisi kisi;
	Iletisim iletisim;
	List<Yetki> yetkiList;

	@JoinTable(name = "AUTH_KULLANICI_YETKI", joinColumns = { @JoinColumn(name = "KULLANICI_ID", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "YETKI_ID", nullable = false, updatable = false) })
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	public List<Yetki> getYetkiList() {
		return yetkiList;
	}

	public void setYetkiList(List<Yetki> yetki) {
		this.yetkiList = yetki;
	}

	@Id
	@SequenceGenerator(allocationSize = 1, initialValue = 1, name = "KULLANICI_ID_SEQ", sequenceName = "KULLANICI_ID_SEQ")
	@GeneratedValue(generator = "KULLANICI_ID_SEQ", strategy = GenerationType.SEQUENCE)
	@Column(name = "ID")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "USERNAME", length = 60, unique = true)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "PASSWORD", length = 60)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@JoinColumn(name = "KISI_ID")
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	public Kisi getKisi() {
		return kisi;
	}

	public void setKisi(Kisi kisi) {
		this.kisi = kisi;
	}

	@Embedded
	public Iletisim getIletisim() {
		return iletisim;
	}

	public void setIletisim(Iletisim iletisim) {
		this.iletisim = iletisim;
	}

}
