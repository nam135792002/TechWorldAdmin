package r2s.com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import r2s.com.models.ProductEntity;
import r2s.com.reponsitory.ProductReponsitory;

@Service
@Transactional
public class ProductServiceImp implements ProductService{
	
	@Autowired
	private ProductReponsitory productReponsitory;

	@Override
	public ProductEntity save(ProductEntity product) {
		return productReponsitory.save(product);
	}

	@Override
	public List<ProductEntity> findAll() {
		return productReponsitory.findAll();
	}

	@Override
	public Long count() {
		return productReponsitory.count();
	}

	@Override
	public Optional<ProductEntity> findById(int id) {
		return productReponsitory.findById(id);
	}

	@Override
	public void deleteById(int id) {
		productReponsitory.deleteById(id);
	}

	@Override
	public void deleteProductByCategory(int idCategory) {
		productReponsitory.deleteProductByCategory(idCategory);
	}

	@Override
	public List<ProductEntity> findProductByCategory(int idCategory) {
		return productReponsitory.findProductByCategory(idCategory);
	}

	@Override
	public List<ProductEntity> searchProductsByName(String productName) {
		return productReponsitory.searchProductsByName(productName);
	}

}
