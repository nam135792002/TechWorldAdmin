package r2s.com.reponsitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import r2s.com.models.AdminEntity;

@Repository
public interface AdminReponsitory extends JpaRepository<AdminEntity, Integer> {
	@Query(value = "SELECT uc FROM AdminEntity uc WHERE uc.username = :username")
	public List<AdminEntity> findAdminByUsername(@Param("username") String username);
}
