package r2s.com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import r2s.com.models.CategoryEntity;
import r2s.com.reponsitory.CategoryReponsitory;

@Service
public class CategoryServiceImp implements CategoryService{
	
	@Autowired
	private CategoryReponsitory categoryReponsitory;

	@Override
	public CategoryEntity save(CategoryEntity category) {
		return categoryReponsitory.save(category);
	}

	@Override
	public List<CategoryEntity> findAll() {
		return categoryReponsitory.findAll();
	}

	@Override
	public Optional<CategoryEntity> findById(int id) {
		return categoryReponsitory.findById(id);
	}

	@Override
	public void deleteById(int id) {
		categoryReponsitory.deleteById(id);
	}

	@Override
	public long count() {
		return categoryReponsitory.count();
	}
	
}
