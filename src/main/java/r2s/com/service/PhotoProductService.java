package r2s.com.service;

import java.util.List;
import java.util.Optional;

import r2s.com.models.PhotoProductEntity;

public interface PhotoProductService {
	PhotoProductEntity save(PhotoProductEntity photoProduct);
	List<PhotoProductEntity> findPhotoAvatar(int id, String avatar);
	void deleteByProductId(int idProduct);
	public List<PhotoProductEntity> findPhoto(int idProduct);
	void deleteById(int id);
	Optional<PhotoProductEntity> findById(int id);
}
