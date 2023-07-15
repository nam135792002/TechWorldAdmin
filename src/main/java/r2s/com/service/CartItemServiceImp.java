package r2s.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import r2s.com.models.CartItemEntity;
import r2s.com.reponsitory.CartItemReponsitory;

@Service
@Transactional
public class CartItemServiceImp implements CartItemService{
	
	@Autowired
	CartItemReponsitory cartItemReponsitory;

	@Override
	public CartItemEntity save(CartItemEntity cartItemEntity) {
		return cartItemReponsitory.save(cartItemEntity);
	}

	@Override
	public List<CartItemEntity> findProductByCart(int idCart) {
		return cartItemReponsitory.findProductByCart(idCart);
	}

	@Override
	public void deleteItemByCartid(int idShopping) {
		cartItemReponsitory.deleteItemByCartid(idShopping);
	}

	@Override
	public List<CartItemEntity> findItemByProductAndCart(int idCart, int idProduct) {
		return cartItemReponsitory.findItemByProductAndCart(idCart, idProduct);
	}

	@Override
	public void deleteItemByIdCartAndIdProduct(int idShopping, int idProduct) {
		cartItemReponsitory.deleteItemByIdCartAndIdProduct(idShopping, idProduct);
	}

	@Override
	public void deleteItemByProduct(int idProduct) {
		cartItemReponsitory.deleteItemByProduct(idProduct);
	}
	
}
