package r2s.com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import r2s.com.models.CustomerEntity;
import r2s.com.reponsitory.CustomerReponsitory;

@Service
public class CustomerServiceImp implements CustomerService{

	@Autowired
	private CustomerReponsitory customerReponsitory;
	
	@Override
	public CustomerEntity save(CustomerEntity customer) {
		return customerReponsitory.save(customer);
	}

	@Override
	public List<CustomerEntity> findAll() {
		return customerReponsitory.findAll();
	}

	@Override
	public Optional<CustomerEntity> findById(int id) {
		return customerReponsitory.findById(id);
	}

	@Override
	public void deleteById(int id) {
		customerReponsitory.deleteById(id);
	}

	@Override
	public long count() {
		return customerReponsitory.count();
	}

}
