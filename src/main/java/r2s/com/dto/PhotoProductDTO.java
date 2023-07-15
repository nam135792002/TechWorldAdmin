package r2s.com.dto;

public class PhotoProductDTO {
	private int idPhoto;
	private String namePhoto;
	private byte[] image;
	private ProductDTO productDTO;
	private String typeImage;
	private String base64Avatar;
	
	public PhotoProductDTO() {
		
	}

	public int getIdPhoto() {
		return idPhoto;
	}

	public void setIdPhoto(int idPhoto) {
		this.idPhoto = idPhoto;
	}

	public String getNamePhoto() {
		return namePhoto;
	}

	public void setNamePhoto(String namePhoto) {
		this.namePhoto = namePhoto;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public ProductDTO getProductDTO() {
		return productDTO;
	}

	public void setProductDTO(ProductDTO productDTO) {
		this.productDTO = productDTO;
	}

	public String getTypeImage() {
		return typeImage;
	}

	public void setTypeImage(String typeImage) {
		this.typeImage = typeImage;
	}

	public String getBase64Avatar() {
		return base64Avatar;
	}

	public void setBase64Avatar(String base64Avatar) {
		this.base64Avatar = base64Avatar;
	}
	
}
