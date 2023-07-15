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
@Table(name = "order_detail")
public class OrderDetailEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer idOrderDetail;
	@Column(name = "quantity")
	private int quantity;
	@ManyToOne
	@JoinColumn(name = "order_id", referencedColumnName = "id")
	private OrderEntity orderEntity;
	@ManyToOne
	@JoinColumn(name = "product_id", referencedColumnName = "id")
	private ProductEntity producEntity;
	public OrderDetailEntity() {
		
	}
	public Integer getIdOrderDetail() {
		return idOrderDetail;
	}
	public void setIdOrderDetail(Integer idOrderDetail) {
		this.idOrderDetail = idOrderDetail;
	}
	public OrderEntity getOrderEntity() {
		return orderEntity;
	}
	public void setOrderEntity(OrderEntity orderEntity) {
		this.orderEntity = orderEntity;
	}
	public ProductEntity getProducEntity() {
		return producEntity;
	}
	public void setProducEntity(ProductEntity producEntity) {
		this.producEntity = producEntity;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
