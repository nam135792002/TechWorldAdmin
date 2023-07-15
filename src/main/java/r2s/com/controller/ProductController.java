package r2s.com.controller;

import java.util.ArrayList;
import java.util.Base64;
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
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import r2s.com.dto.CategoryDTO;
import r2s.com.dto.ProductDTO;
import r2s.com.models.CategoryEntity;
import r2s.com.models.PhotoProductEntity;
import r2s.com.models.ProductEntity;
import r2s.com.service.CartItemService;
import r2s.com.service.CategoryService;
import r2s.com.service.OrderDetailService;
import r2s.com.service.PhotoProductService;
import r2s.com.service.ProductService;
import r2s.training.util.Constant;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	private final static Logger logger = Logger.getLogger(ProductController.class);
	
	@Autowired
	ProductService productService;
	
	@Autowired
	PhotoProductService photoProductService;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	CartItemService cartItemService;
	
	@Autowired
	OrderDetailService orderDetailService;
	
	@RequestMapping("/add_product")
	ModelAndView addProduct(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("AddProduct");
		List<CategoryEntity> listCategoryEntity = categoryService.findAll();
		List<CategoryDTO> listCategoryDTO = new ArrayList<>();
		for (CategoryEntity categoryEntity : listCategoryEntity) {
			CategoryDTO categoryDTO = new CategoryDTO();
			categoryDTO = categoryDTO.convertCategoryDTO(categoryEntity);
			listCategoryDTO.add(categoryDTO);
		}
		String status = request.getParameter("status");
	    request.setAttribute("status", status);
		mv.addObject("listCategoryDTO", listCategoryDTO);
		logger.info("load into add product");
		return mv;
	}
	
	@RequestMapping(value = "/add_product/save_add", method = RequestMethod.POST)
	public String addSaveProduct(@ModelAttribute("newProduct") ProductDTO newProduct,
	                             @RequestParam("avatarImage") CommonsMultipartFile avatarImage,
	                             @RequestParam("imageMultiple") CommonsMultipartFile[] imageMultiple,
	                             HttpServletRequest request) {
	    try {
	        System.out.println(newProduct.getNameProduct());
	        Optional<CategoryEntity> categoryOptional = categoryService.findById(newProduct.getCategoryDTO().getIdCategory());
	        ProductDTO productDTO = new ProductDTO();
	        ProductEntity productEntity = productDTO.convertProductEntity(newProduct);
	        productEntity.setCategoryEntity(categoryOptional.get());
	        productEntity = productService.save(productEntity);

	        PhotoProductEntity photoAvatar = new PhotoProductEntity();
	        photoAvatar.setProductEntity(productEntity);
	        byte[] imageBytes = avatarImage.getBytes();
	        String base64Image = Base64.getEncoder().encodeToString(imageBytes);
	        photoAvatar.setNamePhoto(avatarImage.getOriginalFilename());
	        photoAvatar.setImage(base64Image);
	        photoAvatar.setTypeImage(Constant.TYPE_IMAGE_AVATAR);
	        photoProductService.save(photoAvatar);

	        for (CommonsMultipartFile commonsMultipartFile : imageMultiple) {
	            PhotoProductEntity photo = new PhotoProductEntity();
	            photo.setNamePhoto(commonsMultipartFile.getOriginalFilename());
	            byte[] imageBytesMultiple = commonsMultipartFile.getBytes();
	            String base64ImageMultiple = Base64.getEncoder().encodeToString(imageBytesMultiple);
	            photo.setImage(base64ImageMultiple);
	            photo.setProductEntity(productEntity);
	            photo.setTypeImage(Constant.TYPE_IMAGE_RELATE);
	            photoProductService.save(photo);
	        }

	        logger.info("add product success");
	        request.setAttribute("status", "success");
	    } catch (Exception e) {
	        logger.info("add product failed");
	        logger.error(e);
	        request.setAttribute("status", "failed");
	    }
	    
	    return "redirect:/product/add_product?status=" + request.getAttribute("status");
	}

	
	@RequestMapping("/list_product")
	public ModelAndView listProduct(HttpServletRequest request) {
	    ModelAndView mv = new ModelAndView("ListProduct");

	    List<ProductEntity> listProduct = productService.findAll();
	    List<ProductDTO> listProductDTO = new ArrayList<>();

	    for (ProductEntity productEntity : listProduct) {
	        ProductDTO productDTO = new ProductDTO().convertProductDTO(productEntity);

	        List<PhotoProductEntity> avatarList = photoProductService.findPhotoAvatar(productDTO.getIdProduct(), Constant.TYPE_IMAGE_AVATAR);
	        if (!avatarList.isEmpty()) {
	            PhotoProductEntity avatar = avatarList.get(0);
	            String base64Avatar = avatar.getImage();
	            productDTO.setBase64Image(base64Avatar);
	        }
	        listProductDTO.add(productDTO);
	    }

	    mv.addObject("listProductDTO", listProductDTO);

	    String status = request.getParameter("status");
	    mv.addObject("status", status);

	    return mv;
	}
	
	@RequestMapping("/edit")
	ModelAndView editProduct(@RequestParam("idProduct") int idProduct, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("EditProduct");
		Optional<ProductEntity> productOptional = productService.findById(idProduct);
		ProductEntity productEntity = productOptional.get();
		ProductDTO productDTO = new ProductDTO();
		productDTO = productDTO.convertProductDTO(productEntity);
		mv.addObject("productDTO", productDTO);
		
		List<CategoryEntity> listCategoryEntity = categoryService.findAll();
		List<CategoryDTO> listCategoryDTO = new ArrayList<>();
		for (CategoryEntity categoryEntity : listCategoryEntity) {
			CategoryDTO categoryDTO = new CategoryDTO();
			categoryDTO = categoryDTO.convertCategoryDTO(categoryEntity);
			listCategoryDTO.add(categoryDTO);
		}
		mv.addObject("listCategoryDTO", listCategoryDTO);
		List<PhotoProductEntity> listPhotoProductEntity = photoProductService.findPhoto(idProduct);
		mv.addObject("listPhotoProductEntity", listPhotoProductEntity);
		String status = request.getParameter("status");
	    mv.addObject("status", status);
		return mv;
	}
	
	@RequestMapping(value = "/edit/save_edit", method = RequestMethod.POST)
	String editSaveProduct(@ModelAttribute("editProduct") ProductDTO productDTO, HttpServletRequest request) {
		try {
			ProductDTO productDTOTmp = new ProductDTO();
			ProductEntity productEntity = new ProductEntity();
			productEntity = productDTOTmp.convertProductEntity(productDTO);
			productService.save(productEntity);
			logger.info("edit product success");
			request.setAttribute("status", "success");
		} catch (Exception e) {
			logger.info("edit product failed");
			logger.error(e);
			request.setAttribute("status", "failed");
		}
		return "redirect:/product/list_product?status=" + request.getAttribute("status");
	}
	
	@RequestMapping("/delete")
	String deleteProduct(@RequestParam("idProduct") int idProduct) {
		try {
			photoProductService.deleteByProductId(idProduct);
			cartItemService.deleteItemByProduct(idProduct);
			orderDetailService.deleteOrderDetailByProduct(idProduct);
			productService.deleteById(idProduct);
			logger.info("delete product success");
		} catch (Exception e) {
			logger.info("delete product failed");
			logger.error(e);
		}
		return "redirect:/product/list_product";
	}
	@RequestMapping("/delete_photo")
	String deleteOnePhoto(@RequestParam("idPhoto") int idPhoto) {
		Optional<PhotoProductEntity> optionalPhotoProductEntity = photoProductService.findById(idPhoto);
		photoProductService.deleteById(idPhoto);
		int idProduct = optionalPhotoProductEntity.get().getProductEntity().getIdProduct();
		return "redirect:/product/edit?idProduct="+idProduct;
	}
	@RequestMapping(value="/edit/photo_avatar", method = RequestMethod.POST)
	String insertAvatar(@RequestParam("idProduct") int idProduct,
						@RequestParam("avatarImage") CommonsMultipartFile avatarImage,
						HttpServletRequest request) {
		try {
			Optional<ProductEntity> optionalProductEntity = productService.findById(idProduct);
			PhotoProductEntity photoAvatar = new PhotoProductEntity();
	        photoAvatar.setProductEntity(optionalProductEntity.get());
	        byte[] imageBytes = avatarImage.getBytes();
	        String base64Image = Base64.getEncoder().encodeToString(imageBytes);
	        photoAvatar.setNamePhoto(avatarImage.getOriginalFilename());
	        photoAvatar.setImage(base64Image);
	        photoAvatar.setTypeImage(Constant.TYPE_IMAGE_AVATAR);
	        photoProductService.save(photoAvatar);
	        request.setAttribute("status", "success");
		} catch (Exception e) {
			request.setAttribute("status", "failed");
		}
		
        return "redirect:/product/edit?idProduct="+idProduct+"&status="+request.getAttribute("status");
	}
	@RequestMapping(value="/edit/photo_relate", method = RequestMethod.POST)
	String insertRelateImage(@RequestParam("idProduct") int idProduct,
							@RequestParam("imageMultiple") CommonsMultipartFile[] imageMultiple,
							HttpServletRequest request) {
		try {
			Optional<ProductEntity> optionalProductEntity = productService.findById(idProduct);
			for (CommonsMultipartFile commonsMultipartFile : imageMultiple) {
	            PhotoProductEntity photo = new PhotoProductEntity();
	            photo.setNamePhoto(commonsMultipartFile.getOriginalFilename());
	            byte[] imageBytesMultiple = commonsMultipartFile.getBytes();
	            String base64ImageMultiple = Base64.getEncoder().encodeToString(imageBytesMultiple);
	            photo.setImage(base64ImageMultiple);
	            photo.setProductEntity(optionalProductEntity.get());
	            photo.setTypeImage(Constant.TYPE_IMAGE_RELATE);
	            photoProductService.save(photo);
	        }
			request.setAttribute("status", "success");
		} catch (Exception e) {
			request.setAttribute("status", "failed");
		}
        return "redirect:/product/edit?idProduct="+idProduct+"&status="+request.getAttribute("status");
	}
}
