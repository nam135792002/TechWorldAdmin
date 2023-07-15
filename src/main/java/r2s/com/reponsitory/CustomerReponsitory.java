package r2s.com.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import r2s.com.models.CustomerEntity;

@Repository
public interface CustomerReponsitory extends JpaRepository<CustomerEntity, Integer>{

}
