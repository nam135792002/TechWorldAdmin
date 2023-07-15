package r2s.com.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class CategoryEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer idCategory;
	@Column(name = "code_category")
	private String codeCategory;
	@Column(name = "name_category")
	private String nameCategory;
	
	public CategoryEntity() {
		// TODO Auto-generated constructor stub
	}
	
	public Integer getIdCategory() {
		return idCategory;
	}
	
	public void setIdCategory(Integer idCategory) {
		this.idCategory = idCategory;
	}
	
	public String getCodeCategory() {
		return codeCategory;
	}
	
	public void setCodeCategory(String codeCategory) {
		this.codeCategory = codeCategory;
	}
	
	public String getNameCategory() {
		return nameCategory;
	}
	
	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}
	
}
