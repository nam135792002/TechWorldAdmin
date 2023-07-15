package r2s.com.dto;

import java.util.List;

import r2s.com.models.ProductEntity;

public class ProductDTO {
	private int idProduct;
	private String codeProduct;
	private String nameProduct;
	private int unitPrice;
	private String discription;
	private int quantity;
	private String base64Image;
	private CategoryDTO categoryDTO;
	List<String> base64ListImage;
	public ProductDTO() {
		
	}

	public int getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
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

	public String getBase64Image() {
		return base64Image;
	}

	public void setBase64Image(String base64Image) {
		this.base64Image = base64Image;
	}
	
	public CategoryDTO getCategoryDTO() {
		return categoryDTO;
	}

	public void setCategoryDTO(CategoryDTO categoryDTO) {
		this.categoryDTO = categoryDTO;
	}

	public List<String> getBase64ListImage() {
		return base64ListImage;
	}

	public void setBase64ListImage(List<String> base64ListImage) {
		this.base64ListImage = base64ListImage;
	}

	public ProductDTO convertProductDTO(ProductEntity productEntity) {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setIdProduct(productEntity.getIdProduct());
		productDTO.setCodeProduct(productEntity.getCodeProduct());
		productDTO.setNameProduct(productEntity.getNameProduct());
		productDTO.setQuantity(productEntity.getQuantity());
		productDTO.setUnitPrice(productEntity.getUnitPrice());
		productDTO.setDiscription(productEntity.getDiscription());
		CategoryDTO categoryDTOTmp = new CategoryDTO();
		productDTO.setCategoryDTO(categoryDTOTmp.convertCategoryDTO(productEntity.getCategoryEntity()));
		return productDTO;
	}
	
	public ProductEntity convertProductEntity(ProductDTO productDTO) {
		ProductEntity productEntity = new ProductEntity();
		productEntity.setIdProduct(productDTO.getIdProduct());
		productEntity.setCodeProduct(productDTO.getCodeProduct());
		productEntity.setNameProduct(productDTO.getNameProduct());
		productEntity.setQuantity(productDTO.getQuantity());
		productEntity.setUnitPrice(productDTO.getUnitPrice());
		productEntity.setDiscription(productDTO.getDiscription());
		CategoryDTO categoryDTOTmp = new CategoryDTO();
		productEntity.setCategoryEntity(categoryDTOTmp.convertCategoryEntity(productDTO.getCategoryDTO()));
		return productEntity;
	}
}
