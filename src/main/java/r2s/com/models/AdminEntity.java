package r2s.com.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "admins")
public class AdminEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer idAdmin;
	@Column(name = "name_admin")
	private String nameAdmin;
	@Column(name = "email")
	private String email;
	@Column(name = "phone_number")
	private String phoneNumber;
	@Column(name = "username")
	private String username;
	@Column(name = "passwords")
	private String password;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "adminEntity", fetch = FetchType.EAGER)
	private Set<RoleEntity> authorities = new HashSet<>();
	
	public AdminEntity() {
		
	}

	public Integer getIdAdmin() {
		return idAdmin;
	}

	public void setIdAdmin(Integer idAdmin) {
		this.idAdmin = idAdmin;
	}

	public String getNameAdmin() {
		return nameAdmin;
	}

	public void setNameAdmin(String nameAdmin) {
		this.nameAdmin = nameAdmin;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Set<RoleEntity> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Set<RoleEntity> authorities) {
		this.authorities = authorities;
	}

	@Override
	public String toString() {
		return "AdminEntity [idAdmin=" + idAdmin + ", nameAdmin=" + nameAdmin + ", email=" + email + ", phoneNumber="
				+ phoneNumber + ", username=" + username + ", password=" + password + "]";
	}
}
