package r2s.com.service;

import java.util.List;

import r2s.com.models.OrderDetailEntity;

public interface OrderDetailService {
	OrderDetailEntity save(OrderDetailEntity orderDetailEntity);
	List<OrderDetailEntity> findOrderByOrderId(int idOrder);
	void deleteOrderDetailById(int idOrder);
	void deleteOrderDetailByProduct(int idProduct);
}
