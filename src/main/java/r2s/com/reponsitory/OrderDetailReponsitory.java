package r2s.com.reponsitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import r2s.com.models.OrderDetailEntity;

@Repository
public interface OrderDetailReponsitory extends JpaRepository<OrderDetailEntity, Integer>{
	
	@Query("SELECT o FROM OrderDetailEntity o WHERE o.orderEntity.idOrder = :idOrder")
    List<OrderDetailEntity> findOrderByOrderId(@Param("idOrder") int idOrder);
	
	@Modifying
	@Query("DELETE FROM OrderDetailEntity pp WHERE pp.orderEntity.idOrder = :idOrder")
	void deleteOrderDetailById(@Param("idOrder") int idOrder);
	
	@Modifying
	@Query("DELETE FROM OrderDetailEntity pp WHERE pp.producEntity.idProduct = :idProduct")
	void deleteOrderDetailByProduct(@Param("idProduct") int idProduct);
}
