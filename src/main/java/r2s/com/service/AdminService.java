package r2s.com.service;

import java.util.List;
import java.util.Optional;

import r2s.com.models.AdminEntity;

public interface AdminService {
	AdminEntity save(AdminEntity admin);
	List<AdminEntity> findAll();
	Optional<AdminEntity> findById(int id);
	void deleteById(int id);
	List<AdminEntity> findAdminByUsername(String username);
}
