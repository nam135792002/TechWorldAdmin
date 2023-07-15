package r2s.com.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "order_status")
public class OrderStatusEntity {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer idStatus;
	@Column(name = "nameStatus")
	private String nameStatus;
	public OrderStatusEntity() {
		
	}
	public Integer getIdStatus() {
		return idStatus;
	}
	public void setIdStatus(Integer idStatus) {
		this.idStatus = idStatus;
	}
	public String getNameStatus() {
		return nameStatus;
	}
	public void setNameStatus(String nameStatus) {
		this.nameStatus = nameStatus;
	}
	
}
