package r2s.com.service;

import java.util.List;

import r2s.com.models.CartItemEntity;

public interface CartItemService {
	CartItemEntity save(CartItemEntity cartItemEntity);
	List<CartItemEntity> findProductByCart(int idCart);
	void deleteItemByCartid(int idShopping);
	List<CartItemEntity> findItemByProductAndCart(int idCart, int idProduct);
	void deleteItemByIdCartAndIdProduct(int idShopping, int idProduct);
	void deleteItemByProduct(int idProduct);
}
