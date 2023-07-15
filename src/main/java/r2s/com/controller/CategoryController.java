package r2s.com.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import r2s.com.dto.CategoryDTO;
import r2s.com.models.CategoryEntity;
import r2s.com.models.ProductEntity;
import r2s.com.service.CartItemService;
import r2s.com.service.CategoryService;
import r2s.com.service.OrderDetailService;
import r2s.com.service.PhotoProductService;
import r2s.com.service.ProductService;

@Controller
@RequestMapping("/category")
public class CategoryController {
	private final static Logger logger = Logger.getLogger(CategoryController.class);
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private PhotoProductService photoProductService;
	
	@Autowired
	CartItemService cartItemService;
	
	@Autowired
	OrderDetailService orderDetailService;
	
	@RequestMapping(value = "/add_category", method = RequestMethod.POST)
	public String addCategory(@ModelAttribute("newCategory") CategoryDTO newCategory, HttpServletRequest request) {
		try {
			CategoryDTO categoryDTO = new CategoryDTO();
			CategoryEntity categoryEntity = categoryDTO.convertCategoryEntity(newCategory);
			categoryService.save(categoryEntity);
			logger.info("add category success");
			request.setAttribute("status", "success");
		} catch (Exception e) {
			logger.info("add category failed");
			logger.error(e);
			request.setAttribute("status", "failed");
		}
		return "redirect:/category?status="+request.getAttribute("status");
	}
	
	@RequestMapping("/list_category")
	public ModelAndView listCategory(HttpServletRequest request) {
		logger.info("load into list_category");
		ModelAndView mv = new ModelAndView("ListCategory");
		List<CategoryEntity> listCategoryEntity = categoryService.findAll();
		List<CategoryDTO> listCategoryDTO = new ArrayList<>();
		for (CategoryEntity categoryEntity : listCategoryEntity) {
			CategoryDTO categoryDTO = new CategoryDTO();
			categoryDTO = categoryDTO.convertCategoryDTO(categoryEntity);
			listCategoryDTO.add(categoryDTO);
		}
		String status = request.getParameter("status");
	    request.setAttribute("status", status);
		mv.addObject("listCategoryDTOs", listCategoryDTO);
		return mv;
	}
	
	@RequestMapping("/edit")
	public ModelAndView editCategory(@RequestParam("idCategory") int idCategory, HttpServletRequest request) {
	    logger.info("load into edit_category");
	    Optional<CategoryEntity> optionalCategoryEntity = categoryService.findById(idCategory);
	    CategoryEntity categoryEntity = optionalCategoryEntity.get();
	    CategoryDTO categoryDTO = new CategoryDTO();
	    categoryDTO = categoryDTO.convertCategoryDTO(categoryEntity);
	    ModelAndView mv = new ModelAndView("ListCategory");
	    mv.addObject("category", categoryDTO);
	    System.out.println(categoryDTO.getNameCategory());
	    List<CategoryEntity> listCategoryEntity = categoryService.findAll();
		List<CategoryDTO> listCategoryDTO = new ArrayList<>();
		for (CategoryEntity categoryEntityTmp : listCategoryEntity) {
			CategoryDTO categoryDTOTmp = new CategoryDTO();
			categoryDTO = categoryDTOTmp.convertCategoryDTO(categoryEntityTmp);
			listCategoryDTO.add(categoryDTO);
		}
		mv.addObject("listCategoryDTOs", listCategoryDTO);
		request.setAttribute("status", "openPopUp");
	    return mv;
	}
	
	@RequestMapping(value = "/edit/save_edit", method = RequestMethod.POST)
	public String saveEditCategory(@ModelAttribute("newCategory") CategoryDTO categoryDTO, HttpServletRequest request) {
		try {
			CategoryEntity categoryEntity = new CategoryEntity();
			CategoryDTO categoryDTOTmp = new CategoryDTO();
			categoryEntity = categoryDTOTmp.convertCategoryEntity(categoryDTO);
			categoryService.save(categoryEntity);
			logger.info("edit category success");
			request.setAttribute("status", "success");
		} catch (Exception e) {
			logger.info("edit category failed");
			logger.error(e);
			request.setAttribute("status", "failed");
		}
		return "redirect:/category/list_category?status="+request.getAttribute("status");
	}
	
	@RequestMapping("/delete")
	public String deleteCategory(@RequestParam("idCategory") int idCategory) {
		try {
			Optional<CategoryEntity> optionalCategoryEntity = categoryService.findById(idCategory);
		    CategoryEntity categoryEntity = optionalCategoryEntity.get();
		    List<ProductEntity> listProduct = productService.findProductByCategory(categoryEntity.getIdCategory());
		    if(!listProduct.isEmpty()) {
		    	for (ProductEntity productEntity : listProduct) {
			    	photoProductService.deleteByProductId(productEntity.getIdProduct());
				}
		    	for (ProductEntity productEntity : listProduct) {
		    		cartItemService.deleteItemByProduct(productEntity.getIdProduct());
				}
		    	for (ProductEntity productEntity : listProduct) {
		    		orderDetailService.deleteOrderDetailByProduct(productEntity.getIdProduct());
				}
				productService.deleteProductByCategory(categoryEntity.getIdCategory());
		    }
			categoryService.deleteById(idCategory);
			logger.info("delete category success!");
		} catch (Exception e) {
			logger.info("delete category failed");
			logger.error(e);
		}
		return "redirect:/category/list_category";
	}
}
