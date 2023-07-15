package r2s.com.service;

import java.util.List;

import r2s.com.models.ShoppingCartEntity;

public interface ShoppingCartService {
	ShoppingCartEntity save(ShoppingCartEntity shoppingCart);
	List<ShoppingCartEntity> findCartByCustomer(int idCustomer);
	void deleteCartById(int idShopping);
	void deleteOrderByCustomer(int idCustomer);
}
