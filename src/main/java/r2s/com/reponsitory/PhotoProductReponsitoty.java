package r2s.com.reponsitory;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import r2s.com.models.PhotoProductEntity;

@Repository
public interface PhotoProductReponsitoty extends JpaRepository<PhotoProductEntity, Integer>{
	@Query(value = "SELECT uc FROM PhotoProductEntity uc WHERE uc.productEntity.idProduct = :idProduct AND uc.typeImage = :string")
	public List<PhotoProductEntity> findPhotoAvatar(@Param("idProduct") int idProduct, @Param("string") String string);
	
	@Query(value = "SELECT uc FROM PhotoProductEntity uc WHERE uc.productEntity.idProduct = :idProduct")
	public List<PhotoProductEntity> findPhoto(@Param("idProduct") int idProduct);
	
	@Modifying
    @Query("DELETE FROM PhotoProductEntity pp WHERE pp.productEntity.idProduct = :idProduct")
    void deleteByProductId(@Param("idProduct") int idProduct);
}
