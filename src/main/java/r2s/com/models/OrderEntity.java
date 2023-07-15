package r2s.com.models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class OrderEntity {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer idOrder;
	@Column(name = "code_order")
	private String codeOrder;
	@Column(name = "order_date")
	private Timestamp orderDate;
	@Column(name = "address_order")
	private String addressOrder;
	@Column(name = "descriptions")
	private String description;
	@Column(name = "total")
	private int total;
	@Column(name = "email")
	private String email;
	@Column(name = "phone_number")
	private String phoneNumber;
	@ManyToOne
	@JoinColumn(name = "status_order_id", referencedColumnName = "id")
	private OrderStatusEntity orderStatusEntity;
	@ManyToOne
	@JoinColumn(name = "customer_id", referencedColumnName = "id")
	private CustomerEntity customerEntity;
	public OrderEntity() {
		
	}
	public Integer getIdOrder() {
		return idOrder;
	}
	public void setIdOrder(Integer idOrder) {
		this.idOrder = idOrder;
	}
	public String getCodeOrder() {
		return codeOrder;
	}
	public void setCodeOrder(String codeOrder) {
		this.codeOrder = codeOrder;
	}
	public Timestamp getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}
	public String getAddressOrder() {
		return addressOrder;
	}
	public void setAddressOrder(String addressOrder) {
		this.addressOrder = addressOrder;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public OrderStatusEntity getOrderStatusEntity() {
		return orderStatusEntity;
	}
	public void setOrderStatusEntity(OrderStatusEntity orderStatusEntity) {
		this.orderStatusEntity = orderStatusEntity;
	}
	public CustomerEntity getCustomerEntity() {
		return customerEntity;
	}
	public void setCustomerEntity(CustomerEntity customerEntity) {
		this.customerEntity = customerEntity;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
}
