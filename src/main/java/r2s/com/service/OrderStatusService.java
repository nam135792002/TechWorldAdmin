package r2s.com.service;

import java.util.List;
import java.util.Optional;

import r2s.com.models.OrderStatusEntity;

public interface OrderStatusService {
	List<OrderStatusEntity> findAll();
	Optional<OrderStatusEntity> findById(int id);
}
