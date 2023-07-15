package r2s.com.reponsitory;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import r2s.com.models.OrderEntity;

@Repository
public interface OrderReponsitory extends JpaRepository<OrderEntity, Integer>{
	
	@Query("SELECT COUNT(*) FROM OrderEntity o WHERE o.orderStatusEntity.idStatus = :idStatus")
    int countOrdersWithStatus(@Param("idStatus") int idStatus);
	
	@Query("SELECT o FROM OrderEntity o WHERE o.orderStatusEntity.idStatus = :idStatus")
    List<OrderEntity> findOrderByStatus(@Param("idStatus") int idStatus);
	
	@Query("SELECT o FROM OrderEntity o WHERE o.customerEntity.idCustomer = :idCustomer")
    List<OrderEntity> findOrderByCustomer(@Param("idCustomer") int idCustomer);
	
	@Modifying
	@Query("DELETE FROM OrderEntity pp WHERE pp.idOrder = :idOrder")
	void deleteOrderById(@Param("idOrder") int idOrder);
	
	@Modifying
	@Query("DELETE FROM OrderEntity pp WHERE pp.customerEntity.idCustomer = :idCustomer")
	void deleteOrderByCustomer(@Param("idCustomer") int idCustomer);
}
