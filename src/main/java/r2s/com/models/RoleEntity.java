package r2s.com.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "authorities")
public class RoleEntity {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer idRole;
	@Column(name = "roleName")
	private String roleName;
	@OneToOne
	@JoinColumn(name = "userId", referencedColumnName = "id" )
	private AdminEntity adminEntity;
	
	public RoleEntity() {
		
	}

	public Integer getIdRole() {
		return idRole;
	}

	public void setIdRole(Integer idRole) {
		this.idRole = idRole;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public AdminEntity getAdminEntity() {
		return adminEntity;
	}

	public void setAdminEntity(AdminEntity adminEntity) {
		this.adminEntity = adminEntity;
	}
	
}
