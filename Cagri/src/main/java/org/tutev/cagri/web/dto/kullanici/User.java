package org.tutev.cagri.web.dto.kullanici;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.tutev.cagri.web.dto.Base;
import org.tutev.cagri.web.dto.genel.Kisi;

@Entity
@Table(name = "AUTH_USER")
public class User extends Base{

	private static final long serialVersionUID = -7701182540860228145L;
	
	Long id;
	String username;
	String password;
	List<Role> roles;
	UserStatus status;
	Kisi kisi;
	
	public User(){}

	public User(Long id, String username, String password, List<Role> roles,
			UserStatus status, Kisi kisi) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.roles = roles;
		this.status = status;
		this.kisi = kisi;
	}
	
	

	@Id
    @SequenceGenerator(allocationSize = 1, initialValue = 1, sequenceName = "ID_SEQ", name = "ID_SEQ")
    @GeneratedValue(generator = "ID_SEQ", strategy = GenerationType.SEQUENCE)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "USERNAME", length = 50)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "PASSWORD", length = 100)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@ManyToMany
	@JoinTable(name="UsersAndRoles",
			joinColumns=@JoinColumn(name="user_id", referencedColumnName="id"),
			inverseJoinColumns=@JoinColumn(name="role_id", referencedColumnName="id"))
	
	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "STATUS")
	public UserStatus getStatus() {
		return status;
	}

	public void setStatus(UserStatus status) {
		this.status = status;
	}
	
	@ManyToOne
    @JoinColumn(name = "KISI_ID")
	public Kisi getKisi() {
		return kisi;
	}

	public void setKisi(Kisi kisi) {
		this.kisi = kisi;
	}
	
}
