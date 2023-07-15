package r2s.com.dto;

import r2s.com.models.AdminEntity;

public class AdminDTO {
	private int idAdmin;
	private String nameAdmin;
	private String email;
	private String phoneNumber;
	private String username;
	private String password;
	private String roleName;
	
	public AdminDTO() {
		
	}

	public int getIdAdmin() {
		return idAdmin;
	}

	public void setIdAdmin(int idAdmin) {
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
	
	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	@Override
	public String toString() {
		return "AdminDTO [idAdmin=" + idAdmin + ", nameAdmin=" + nameAdmin + ", email=" + email + ", phoneNumber="
				+ phoneNumber + ", username=" + username + ", password=" + password + ", roleName=" + roleName + "]";
	}

	public AdminEntity convertAdminEntity(AdminDTO adminDTO) {
		AdminEntity adminEntity = new AdminEntity();
		adminEntity.setIdAdmin(adminDTO.getIdAdmin());
		adminEntity.setNameAdmin(adminDTO.getNameAdmin());
		adminEntity.setPhoneNumber(adminDTO.getPhoneNumber());
		adminEntity.setEmail(adminDTO.getEmail());
		adminEntity.setUsername(adminDTO.getUsername());
		adminEntity.setPassword(adminDTO.getPassword());
		return adminEntity;
	}
	
	public AdminDTO convertAdminDTO(AdminEntity adminEntity) {
		AdminDTO adminDTO = new AdminDTO();
		adminDTO.setIdAdmin(adminEntity.getIdAdmin());
		adminDTO.setNameAdmin(adminEntity.getNameAdmin());
		adminDTO.setPhoneNumber(adminEntity.getPhoneNumber());
		adminDTO.setEmail(adminEntity.getEmail());
		adminDTO.setUsername(adminEntity.getUsername());
		adminDTO.setPassword(adminEntity.getPassword());
		return adminDTO;
	}
}
