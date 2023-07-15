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
@Table(name = "CartItem")
public class CartItemEntity {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer idCartItem;
	@Column(name = "quantity")
	private Integer quantity;
	@ManyToOne
	@JoinColumn(name = "shopping_cart_id", referencedColumnName = "id")
	private ShoppingCartEntity shoppingCartEntity;
	@ManyToOne
	@JoinColumn(name = "product_id", referencedColumnName = "id")
	private ProductEntity productEntity;
	public CartItemEntity() {
		
	}
	public Integer getIdCartItem() {
		return idCartItem;
	}
	public void setIdCartItem(Integer idCartItem) {
		this.idCartItem = idCartItem;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public ShoppingCartEntity getShoppingCartEntity() {
		return shoppingCartEntity;
	}
	public void setShoppingCartEntity(ShoppingCartEntity shoppingCartEntity) {
		this.shoppingCartEntity = shoppingCartEntity;
	}
	public ProductEntity getProductEntity() {
		return productEntity;
	}
	public void setProductEntity(ProductEntity productEntity) {
		this.productEntity = productEntity;
	}
	
}
