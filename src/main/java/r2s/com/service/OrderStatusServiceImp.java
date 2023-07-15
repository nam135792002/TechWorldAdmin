package r2s.com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import r2s.com.models.OrderStatusEntity;
import r2s.com.reponsitory.OrderStatusReponsitory;

@Service
public class OrderStatusServiceImp implements OrderStatusService{
	
	@Autowired
	OrderStatusReponsitory orderStatusReponsitory;

	@Override
	public List<OrderStatusEntity> findAll() {
		return orderStatusReponsitory.findAll();
	}

	@Override
	public Optional<OrderStatusEntity> findById(int id) {
		return orderStatusReponsitory.findById(id);
	}
	
	
}
