package r2s.com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import r2s.com.dto.AdminDTO;
import r2s.com.models.AdminEntity;
import r2s.com.models.RoleEntity;
import r2s.com.service.AdminService;
import r2s.com.service.CategoryService;
import r2s.com.service.CustomerService;
import r2s.com.service.OrderService;
import r2s.com.service.ProductService;
import r2s.com.service.RoleService;

@Controller
public class DashboardController {
	
	private final static Logger logger = Logger.getLogger(DashboardController.class);
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	AdminService adminService;
	
	@Autowired
	RoleService roleService;
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	OrderService orderService;
	
	@RequestMapping("/dashboard")
	ModelAndView dashboardPage(Authentication authentication) {
		logger.info("load into dashbord");
		ModelAndView mv = new ModelAndView("Dashboard");
		long countCategory = categoryService.count();
		mv.addObject("countCategory", countCategory);
		List<AdminEntity> listAdmin = adminService.findAll();
		List<AdminDTO> listAdminDTO = new ArrayList<>();
		for (AdminEntity adminEntity : listAdmin) {
			AdminDTO adminDTO = new AdminDTO();
			adminDTO = adminDTO.convertAdminDTO(adminEntity);
			List<RoleEntity> roleList = roleService.findRolesByAdminId(adminDTO.getIdAdmin());
			if (authentication != null && authentication.getAuthorities().stream()
	                .anyMatch(auth -> auth.getAuthority().equals("ROLE_ADMIN"))) {
				adminDTO.setRoleName(roleList.get(0).getRoleName());
				listAdminDTO.add(adminDTO);
	        } else {
	        	String role = roleList.get(0).getRoleName();
	        	if(role.equals("ROLE_EMPLOYEE")) {
	        		adminDTO.setRoleName(role);
					listAdminDTO.add(adminDTO);
	        	}
	        }
			
		}
		mv.addObject("listAdminDTO", listAdminDTO);
		long countAdmin = roleService.countAdmin();
		long countEmployee = roleService.countEmployee();
		long countCustomer = customerService.count();
		long countProduct = productService.count();
		long countOrder = orderService.count();
		mv.addObject("countCustomer", countCustomer);
		mv.addObject("countAdmin", countAdmin);
		mv.addObject("countEmployee", countEmployee);
		mv.addObject("countProduct", countProduct);
		mv.addObject("countOrder", countOrder);
		return mv;
	}
	
	@RequestMapping("/category")
	ModelAndView categoryPage(HttpServletRequest request) {
		logger.info("load into category page");
		ModelAndView mv = new ModelAndView("Category");
		long countCategory = categoryService.count();
		mv.addObject("countCategory", countCategory);
		String status = request.getParameter("status");
	    request.setAttribute("status", status);
		return mv;
	}
	
	@RequestMapping("/admin")
	ModelAndView adminPage() {
		logger.info("load into admin page");
		ModelAndView mv = new ModelAndView("Admin");
		long countUser = roleService.count();
		mv.addObject("countUser", countUser);
		return mv;
	}
	
	@RequestMapping("/customer")
	ModelAndView customerPage() {
		logger.info("load into customer page");
		ModelAndView mv = new ModelAndView("Customer");
		long countCustomer = customerService.count();
		mv.addObject("countCustomer", countCustomer);
		return mv;
	}
	
	@RequestMapping("/product")
	ModelAndView productPage() {
		ModelAndView mv = new ModelAndView("Product");
		long countProduct = productService.count();
		mv.addObject("countProduct", countProduct);
		logger.info("load into product page");
		return mv;
	}
	
	@RequestMapping("/order")
	ModelAndView orderPage(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("Order");
		logger.info("load into order page");
		long countOrder = orderService.count();
		mv.addObject("countOrder", countOrder);
		int countNewOrder = orderService.countOrdersWithStatus(1);
		int countPackingOrder = orderService.countOrdersWithStatus(2);
		int countDeliveryOrder = orderService.countOrdersWithStatus(3);
		int countSuccessOrder = orderService.countOrdersWithStatus(4);
		mv.addObject("countNewOrder", countNewOrder);
		mv.addObject("countPackingOrder", countPackingOrder);
		mv.addObject("countDeliveryOrder", countDeliveryOrder);
		mv.addObject("countSuccessOrder", countSuccessOrder);
		String status = request.getParameter("status");
	    request.setAttribute("status", status);
		return mv;
	}
}
