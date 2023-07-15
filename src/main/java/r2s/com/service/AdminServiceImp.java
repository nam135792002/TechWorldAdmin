package r2s.com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import r2s.com.models.AdminEntity;
import r2s.com.reponsitory.AdminReponsitory;

@Service
public class AdminServiceImp implements AdminService{

	@Autowired
	private AdminReponsitory adminReponsitory;

	@Override
	public AdminEntity save(AdminEntity admin) {
		return adminReponsitory.save(admin);
	}

	@Override
	public List<AdminEntity> findAll() {
		return adminReponsitory.findAll();
	}

	@Override
	public Optional<AdminEntity> findById(int id) {
		return adminReponsitory.findById(id);
	}

	@Override
	public void deleteById(int id) {
		adminReponsitory.deleteById(id);
	}

	@Override
	public List<AdminEntity> findAdminByUsername(String username) {
		return adminReponsitory.findAdminByUsername(username);
	}

}
