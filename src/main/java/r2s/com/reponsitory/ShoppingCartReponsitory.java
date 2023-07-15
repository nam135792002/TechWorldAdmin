package r2s.com.reponsitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import r2s.com.models.ShoppingCartEntity;

@Repository
public interface ShoppingCartReponsitory extends JpaRepository<ShoppingCartEntity,Integer>{
	@Query(value = "SELECT uc FROM ShoppingCartEntity uc WHERE uc.customerEntity.idCustomer = :idCustomer")
	public List<ShoppingCartEntity> findCartByCustomer(@Param("idCustomer") int idCustomer);
	
	@Modifying
	@Query("DELETE FROM ShoppingCartEntity pp WHERE pp.customerEntity.idCustomer = :idCustomer")
	void deleteOrderByCustomer(@Param("idCustomer") int idCustomer);
}
