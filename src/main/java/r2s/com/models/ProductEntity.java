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
@Table(name = "product")
public class ProductEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer idProduct;
	@Column(name = "code_product")
	private String codeProduct;
	@Column(name = "name_product")
	private String nameProduct;
	@Column(name = "unit_price")
	private int unitPrice;
	@Column(name = "discription")
	private String discription;
	@Column(name = "quantity")
	private int quantity;
	@ManyToOne
	@JoinColumn(name = "category_id", referencedColumnName = "id")
	private CategoryEntity categoryEntity;
	
	public ProductEntity() {
		
	}

	public Integer getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(Integer idProduct) {
		this.idProduct = idProduct;
	}

	public String getCodeProduct() {
		return codeProduct;
	}

	public void setCodeProduct(String codeProduct) {
		this.codeProduct = codeProduct;
	}

	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	public int getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public CategoryEntity getCategoryEntity() {
		return categoryEntity;
	}

	public void setCategoryEntity(CategoryEntity categoryEntity) {
		this.categoryEntity = categoryEntity;
	}
	
}
