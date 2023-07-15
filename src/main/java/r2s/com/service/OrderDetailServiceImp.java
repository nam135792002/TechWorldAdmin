package r2s.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import r2s.com.models.OrderDetailEntity;
import r2s.com.reponsitory.OrderDetailReponsitory;

@Transactional
@Service
public class OrderDetailServiceImp implements OrderDetailService{
	
	@Autowired
	OrderDetailReponsitory orderDetailReponsitory;

	@Override
	public OrderDetailEntity save(OrderDetailEntity orderDetailEntity) {
		return orderDetailReponsitory.save(orderDetailEntity);
	}

	@Override
	public List<OrderDetailEntity> findOrderByOrderId(int idOrder) {
		return orderDetailReponsitory.findOrderByOrderId(idOrder);
	}

	@Override
	public void deleteOrderDetailById(int idOrder) {
		orderDetailReponsitory.deleteOrderDetailById(idOrder);;
	}

	@Override
	public void deleteOrderDetailByProduct(int idProduct) {
		orderDetailReponsitory.deleteOrderDetailByProduct(idProduct);
	}
	
	
}
