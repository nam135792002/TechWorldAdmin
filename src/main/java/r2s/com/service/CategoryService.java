package r2s.com.service;

import java.util.List;
import java.util.Optional;

import r2s.com.models.CategoryEntity;

public interface CategoryService {
	CategoryEntity save(CategoryEntity category);
	List<CategoryEntity> findAll();
	Optional<CategoryEntity> findById(int id);
	void deleteById(int id);
	long count();
}
