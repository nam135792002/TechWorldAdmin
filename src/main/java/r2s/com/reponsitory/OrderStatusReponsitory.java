package r2s.com.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import r2s.com.models.OrderStatusEntity;

@Repository
public interface OrderStatusReponsitory extends JpaRepository<OrderStatusEntity, Integer>{
	
}
