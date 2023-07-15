package r2s.com.reponsitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import r2s.com.models.CartItemEntity;

@Repository
public interface CartItemReponsitory extends JpaRepository<CartItemEntity, Integer>{
	@Query(value = "SELECT uc FROM CartItemEntity uc WHERE uc.shoppingCartEntity.idShopping = :idCart")
	List<CartItemEntity> findProductByCart(@Param("idCart") int idCart);
	
	@Query(value = "SELECT uc FROM CartItemEntity uc WHERE uc.shoppingCartEntity.idShopping = :idCart and uc.productEntity.idProduct = :idProduct")
	List<CartItemEntity> findItemByProductAndCart(@Param("idCart") int idCart, @Param("idProduct") int idProduct);
	
	@Modifying
	@Query("DELETE FROM CartItemEntity pp WHERE pp.shoppingCartEntity.idShopping = :idShopping")
	void deleteItemByCartid(@Param("idShopping") int idShopping);
	
	@Modifying
	@Query("DELETE FROM CartItemEntity pp WHERE pp.shoppingCartEntity.idShopping = :idShopping and pp.productEntity.idProduct = :idProduct")
	void deleteItemByIdCartAndIdProduct(@Param("idShopping") int idShopping, @Param("idProduct") int idProduct);
	
	@Modifying
	@Query("DELETE FROM CartItemEntity pp WHERE pp.productEntity.idProduct = :idProduct")
	void deleteItemByProduct(@Param("idProduct") int idProduct);
}
