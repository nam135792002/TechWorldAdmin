package r2s.com.reponsitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import r2s.com.models.ProductEntity;

@Repository
public interface ProductReponsitory extends JpaRepository<ProductEntity, Integer>{
	
	@Query(value = "SELECT uc FROM ProductEntity uc WHERE uc.categoryEntity.idCategory = :idCategory")
	public List<ProductEntity> findProductByCategory(@Param("idCategory") int idCategory);
	
	@Query("SELECT p FROM ProductEntity p WHERE p.nameProduct LIKE %:productName%")
    List<ProductEntity> searchProductsByName(@Param("productName") String productName);
	
	@Modifying
	@Query("DELETE FROM ProductEntity pp WHERE pp.categoryEntity.idCategory = :idCategory")
	void deleteProductByCategory(@Param("idCategory") int idCategory);
}
