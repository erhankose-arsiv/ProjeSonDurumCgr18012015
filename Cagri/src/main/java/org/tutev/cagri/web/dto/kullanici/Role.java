package org.tutev.cagri.web.dto.kullanici;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.tutev.cagri.web.dto.Base;

@Entity
@Table(name = "AUTH_ROLE")
public class Role extends Base {

	private static final long serialVersionUID = 340785780484402664L;
	Long id;
	String roleName;
	List<User> users;
	
	public Role(){}

	public Role(Long id, String roleName, List<User> users) {
		super();
		this.id = id;
		this.roleName = roleName;
		this.users = users;
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

	@Column(name = "rolename", length = 50)
	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@ManyToMany(mappedBy = "roles")
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
    @Override
    public boolean equals(Object other) {
        return (other instanceof Role) && (id != null) ? id.equals(((Role) other).id)  : (other == this);
    }
}
