package r2s.com.dto;

import r2s.com.models.CustomerEntity;

public class CustomerDTO {
	private Integer idCustomer;
	private String codeCustomer;
	private String nameCustomer;
	private String email;
	private String phoneNumber;
	private String password;
	private String address;
	
	public CustomerDTO() {
		
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "CustomerDTO [idCustomer=" + idCustomer + ", codeCustomer=" + codeCustomer + ", nameCustomer="
				+ nameCustomer + ", email=" + email + ", phoneNumber=" + phoneNumber + ", password=" + password
				+ ", address=" + address + "]";
	}
	
	public CustomerDTO convertCustomerDTO(CustomerEntity customerEntity) {
		CustomerDTO customDTO = new CustomerDTO();
		customDTO.setIdCustomer(customerEntity.getIdCustomer());
		customDTO.setCodeCustomer(customerEntity.getCodeCustomer());
		customDTO.setNameCustomer(customerEntity.getNameCustomer());
		customDTO.setEmail(customerEntity.getEmail());
		customDTO.setPhoneNumber(customerEntity.getPhoneNumber());
		customDTO.setPassword(customerEntity.getPassword());
		customDTO.setAddress(customerEntity.getAddressCustomer());
		return customDTO;
	}
	
	public CustomerEntity convertCustomerEntity(CustomerDTO customerDTO) {
		CustomerEntity customerEntity = new CustomerEntity();
		customerEntity.setIdCustomer(customerDTO.getIdCustomer());
		customerEntity.setCodeCustomer(customerDTO.getCodeCustomer());
		customerEntity.setNameCustomer(customerDTO.getNameCustomer());
		customerEntity.setEmail(customerDTO.getEmail());
		customerEntity.setPhoneNumber(customerDTO.getPhoneNumber());
		customerEntity.setPassword(customerDTO.getPassword());
		customerEntity.setAddressCustomer(customerDTO.getAddress());
		return customerEntity;
	}
}
