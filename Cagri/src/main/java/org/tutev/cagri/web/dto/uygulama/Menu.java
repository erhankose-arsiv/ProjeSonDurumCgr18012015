package org.tutev.cagri.web.dto.uygulama;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "UYG_MENU")
public class Menu implements Serializable {

	private static final long serialVersionUID = 1L;

	Long id;
	String adi;
	int gosterimSirasi;
	List<AltMenu> altMenuList;
	List<Yetki> yetkiList;

	@JoinTable(name = "AUTH_MENU_YETKI", joinColumns = { @JoinColumn(name = "MENU_ID", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "YETKI_ID", nullable = false, updatable = false) })
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	public List<Yetki> getYetkiList() {
		return yetkiList;
	}

	public void setYetkiList(List<Yetki> yetkiList) {
		this.yetkiList = yetkiList;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "menu", fetch = FetchType.EAGER)
	@OrderBy("gosterimSirasi ASC")
	public List<AltMenu> getAltMenuList() {
		return altMenuList;
	}

	public void setAltMenuList(List<AltMenu> altMenuList) {
		this.altMenuList = altMenuList;
	}

	@Id
	@SequenceGenerator(allocationSize = 1, initialValue = 1, name = "MENU_ID_SEQ", sequenceName = "MENU_ID_SEQ")
	@GeneratedValue(generator = "MENU_ID_SEQ", strategy = GenerationType.SEQUENCE)
	@Column(name = "ID")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "AD", length = 150, nullable = false)
	public String getAdi() {
		return adi;
	}

	public void setAdi(String adi) {
		this.adi = adi;
	}

	@Column(name = "SIRA", nullable = false, unique = true)
	public int getGosterimSirasi() {
		return gosterimSirasi;
	}

	public void setGosterimSirasi(int gosterimSirasi) {
		this.gosterimSirasi = gosterimSirasi;
	}
}
