package r2s.com.service;

import java.util.List;
import java.util.Optional;

import r2s.com.models.OrderEntity;

public interface OrderService {
	OrderEntity save(OrderEntity orderEntity);
	Optional<OrderEntity> findById(int id);
	long count();
	int countOrdersWithStatus(int idStatus);
	List<OrderEntity> findAll();
	List<OrderEntity> findOrderByStatus(int idStatus);
	void deleteOrderById(int idOrder);
	List<OrderEntity> findOrderByCustomer(int idCustomer);
	void deleteOrderByCustomer(int idCustomer);
}
