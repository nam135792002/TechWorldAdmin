package r2s.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import r2s.com.models.ShoppingCartEntity;
import r2s.com.reponsitory.ShoppingCartReponsitory;

@Transactional
@Service
public class ShoppingCartServiceImp implements ShoppingCartService{

	@Autowired
	ShoppingCartReponsitory shoppingCartReponsitory;

	@Override
	public ShoppingCartEntity save(ShoppingCartEntity shoppingCart) {
		return shoppingCartReponsitory.save(shoppingCart);
	}

	@Override
	public List<ShoppingCartEntity> findCartByCustomer(int idCustomer) {
		return shoppingCartReponsitory.findCartByCustomer(idCustomer);
	}

	@Override
	public void deleteCartById(int idShopping) {
		shoppingCartReponsitory.deleteById(idShopping);
	}

	@Override
	public void deleteOrderByCustomer(int idCustomer) {
		shoppingCartReponsitory.deleteOrderByCustomer(idCustomer);
	}
	
}
