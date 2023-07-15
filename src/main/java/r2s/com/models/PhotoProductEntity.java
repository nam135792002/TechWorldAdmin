package r2s.com.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product_photo")
public class PhotoProductEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int idPhoto;
	@Column(name = "photo_name")
	private String namePhoto;
	@Column(name = "photo_data")
	private String image;
	@Column(name = "type_image")
	private String typeImage;
	@ManyToOne
	@JoinColumn(name = "product_id", referencedColumnName = "id")
	private ProductEntity productEntity;
	
	public PhotoProductEntity() {
		
	}

	public int getIdPhoto() {
		return idPhoto;
	}

	public void setIdPhoto(int idPhoto) {
		this.idPhoto = idPhoto;
	}
	
	public ProductEntity getProductEntity() {
		return productEntity;
	}

	public void setProductEntity(ProductEntity productEntity) {
		this.productEntity = productEntity;
	}

	public String getNamePhoto() {
		return namePhoto;
	}

	public void setNamePhoto(String namePhoto) {
		this.namePhoto = namePhoto;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getTypeImage() {
		return typeImage;
	}

	public void setTypeImage(String typeImage) {
		this.typeImage = typeImage;
	}
	
}
