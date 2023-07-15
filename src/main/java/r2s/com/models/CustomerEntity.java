package r2s.com.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class CustomerEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer idCustomer;
	@Column(name = "code_customer")
	private String codeCustomer;
	@Column(name = "name_customer")
	private String nameCustomer;
	@Column(name = "email")
	private String email;
	@Column(name = "phone_number")
	private String phoneNumber;
	@Column(name = "passwords")
	private String password;
	@Column(name = "address_cuatomer")
	private String addressCustomer;
	
	public CustomerEntity() {
		
	}

	public Integer getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(Integer idCustomer) {
		this.idCustomer = idCustomer;
	}

	public String getCodeCustomer() {
		return codeCustomer;
	}

	public void setCodeCustomer(String codeCustomer) {
		this.codeCustomer = codeCustomer;
	}

	public String getNameCustomer() {
		return nameCustomer;
	}

	public void setNameCustomer(String nameCustomer) {
		this.nameCustomer = nameCustomer;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddressCustomer() {
		return addressCustomer;
	}

	public void setAddressCustomer(String addressCustomer) {
		this.addressCustomer = addressCustomer;
	}

	@Override
	public String toString() {
		return "CustomerEntity [idCustomer=" + idCustomer + ", codeCustomer=" + codeCustomer + ", nameCustomer="
				+ nameCustomer + ", email=" + email + ", phoneNumber=" + phoneNumber + ", password=" + password
				+ ", addressCustomer=" + addressCustomer + "]";
	}
	
}
