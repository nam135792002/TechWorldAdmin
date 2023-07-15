package r2s.com.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ShoppingCart")
public class ShoppingCartEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer idShopping;
	@OneToOne
	@JoinColumn(name = "customer_id", referencedColumnName = "id")
	private CustomerEntity customerEntity;
	
	public ShoppingCartEntity() {
		
	}

	public Integer getIdCartShopping() {
		return idShopping;
	}

	public void setIdCartShopping(Integer idCategory) {
		this.idShopping = idCategory;
	}

	public CustomerEntity getCustomerEntity() {
		return customerEntity;
	}

	public void setCustomerEntity(CustomerEntity customerEntity) {
		this.customerEntity = customerEntity;
	}
	
}
