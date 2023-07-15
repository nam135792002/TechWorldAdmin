package r2s.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import r2s.com.models.RoleEntity;
import r2s.com.reponsitory.RoleReponsitory;

@Service
public class RoleServiceImp implements RoleService{

	@Autowired
	private RoleReponsitory roleReponsitory;
	
	@Override
	public RoleEntity save(RoleEntity role) {
		return roleReponsitory.save(role);
	}

	@Override
	public List<RoleEntity> findRolesByAdminId(int userId) {
		return roleReponsitory.findRolesByAdminId(userId);
	}

	@Override
	public void delete(RoleEntity role) {
		roleReponsitory.delete(role);
	}

	@Override
	public long count() {
		return roleReponsitory.count();
	}

	@Override
	public long countAdmin() {
		return roleReponsitory.countAdminRoles();
	}

	@Override
	public long countEmployee() {
		return roleReponsitory.countEmployeeRoles();
	}
}
