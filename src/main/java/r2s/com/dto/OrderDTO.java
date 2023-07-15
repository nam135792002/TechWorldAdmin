package r2s.com.dto;

import java.sql.Timestamp;
import java.util.List;

import r2s.com.models.OrderEntity;

public class OrderDTO {
	private int idOrder;
	private String codeOrder;
	private CustomerDTO customerDTO;
	private Timestamp dateOrder;
	private int total;
	private List<ProductDTO> listProduct;
	private String description;
	private int idOrderStatus;
	public OrderDTO() {
		
	}
	public int getIdOrder() {
		return idOrder;
	}
	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}
	public String getCodeOrder() {
		return codeOrder;
	}
	public void setCodeOrder(String codeOrder) {
		this.codeOrder = codeOrder;
	}
	public CustomerDTO getCustomerDTO() {
		return customerDTO;
	}
	public void setCustomerDTO(CustomerDTO customerDTO) {
		this.customerDTO = customerDTO;
	}
	public Timestamp getDateOrder() {
		return dateOrder;
	}
	public void setDateOrder(Timestamp dateOrder) {
		this.dateOrder = dateOrder;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<ProductDTO> getListProduct() {
		return listProduct;
	}
	public void setListProduct(List<ProductDTO> listProduct) {
		this.listProduct = listProduct;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getIdOrderStatus() {
		return idOrderStatus;
	}
	public void setIdOrderStatus(int idOrderStatus) {
		this.idOrderStatus = idOrderStatus;
	}
	public OrderDTO convertOrderDTO(OrderEntity orderEntity) {
		OrderDTO orderDTO = new OrderDTO();
		orderDTO.setIdOrder(orderEntity.getIdOrder());
		orderDTO.setCodeOrder(orderEntity.getCodeOrder());
		orderDTO.setDateOrder(orderEntity.getOrderDate());
		orderDTO.setTotal(orderEntity.getTotal());
		orderDTO.setDescription(orderEntity.getDescription());
		return orderDTO;
	}
}
