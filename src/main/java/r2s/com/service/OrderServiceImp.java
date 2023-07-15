package r2s.com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import r2s.com.models.OrderEntity;
import r2s.com.reponsitory.OrderReponsitory;

@Transactional
@Service
public class OrderServiceImp implements OrderService{

	@Autowired
	OrderReponsitory orderReponsitory;

	@Override
	public OrderEntity save(OrderEntity orderEntity) {
		return orderReponsitory.save(orderEntity);
	}

	@Override
	public Optional<OrderEntity> findById(int id) {
		return orderReponsitory.findById(id);
	}

	@Override
	public long count() {
		return orderReponsitory.count();
	}

	@Override
	public int countOrdersWithStatus(int idStatus) {
		return orderReponsitory.countOrdersWithStatus(idStatus);
	}

	@Override
	public List<OrderEntity> findAll() {
		return orderReponsitory.findAll();
	}

	@Override
	public List<OrderEntity> findOrderByStatus(int idStatus) {
		return orderReponsitory.findOrderByStatus(idStatus);
	}

	@Override
	public void deleteOrderById(int idOrder) {
		orderReponsitory.deleteOrderById(idOrder);
	}

	@Override
	public List<OrderEntity> findOrderByCustomer(int idCustomer) {
		return orderReponsitory.findOrderByCustomer(idCustomer);
	}

	@Override
	public void deleteOrderByCustomer(int idCustomer) {
		orderReponsitory.deleteOrderByCustomer(idCustomer);
	}
}
