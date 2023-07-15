package r2s.com.reponsitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;
import r2s.com.models.RoleEntity;

@Repository
public interface RoleReponsitory extends JpaRepository<RoleEntity, Integer> {
    @Query(value = "SELECT re FROM RoleEntity re WHERE re.adminEntity.idAdmin = :userId")
    public List<RoleEntity> findRolesByAdminId(@Param("userId") int userId);
    
    @Query(value = "SELECT COUNT(*) FROM RoleEntity re WHERE re.roleName = 'ROLE_ADMIN'")
    Long countAdminRoles();

    @Query(value = "SELECT COUNT(*) FROM RoleEntity re WHERE re.roleName = 'ROLE_EMPLOYEE'")
    Long countEmployeeRoles();
    
}

