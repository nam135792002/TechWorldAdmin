package r2s.com.service;

import java.util.List;
import java.util.Optional;

import r2s.com.models.CustomerEntity;

public interface CustomerService {
	CustomerEntity save(CustomerEntity customer);
	List<CustomerEntity> findAll();
	Optional<CustomerEntity> findById(int id);
	void deleteById(int id);
	long count();
}
