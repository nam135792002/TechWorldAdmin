package r2s.com.service;

import java.util.List;

import r2s.com.models.RoleEntity;

public interface RoleService {
	RoleEntity save(RoleEntity role);
	List<RoleEntity> findRolesByAdminId(int userId);
	void delete(RoleEntity role);
	long count();
	long countAdmin();
	long countEmployee();
}
