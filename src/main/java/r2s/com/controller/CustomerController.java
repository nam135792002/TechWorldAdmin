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

import r2s.com.dto.CustomerDTO;
import r2s.com.models.CustomerEntity;
import r2s.com.models.OrderEntity;
import r2s.com.models.ShoppingCartEntity;
import r2s.com.service.CartItemService;
import r2s.com.service.CustomerService;
import r2s.com.service.OrderDetailService;
import r2s.com.service.OrderService;
import r2s.com.service.ShoppingCartService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	private final static Logger logger = Logger.getLogger(CustomerController.class);
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	OrderDetailService orderDetailService;
	
	@Autowired
	ShoppingCartService shoppingCartService;
	
	@Autowired
	CartItemService cartItemService;
	
	@RequestMapping("/add_customer")
	String addCustomer(HttpServletRequest request) {
		String status = request.getParameter("status");
	    request.setAttribute("status", status);
		return "AddCustomer";
	}
	
	@RequestMapping(value = "/add_customer/save_add", method = RequestMethod.POST)
	String AddSaveCustomer(@ModelAttribute("newCustomer") CustomerDTO customerDTO, HttpServletRequest request) {
		try {
			System.out.println(customerDTO.getNameCustomer());
			CustomerDTO customerDTOTmp = new CustomerDTO();
			CustomerEntity customerEntity = customerDTOTmp.convertCustomerEntity(customerDTO);
			customerService.save(customerEntity);
			logger.info("add customer success");
			request.setAttribute("status", "success");
		} catch (Exception e) {
			logger.info("add customer failed");
			logger.error(e);
			request.setAttribute("status", "failed");
		}
		return "redirect:/customer/add_customer?status=" + request.getAttribute("status");
	}
	
	@RequestMapping("/list_customer")
	ModelAndView listCustomer(HttpServletRequest request) {
		logger.info("load into list");
		ModelAndView mv = new ModelAndView("ListCustomer");
		List<CustomerDTO> listCustomerDTO = new ArrayList<>();
		List<CustomerEntity> listCustomer = customerService.findAll();
		for (CustomerEntity customerEntity : listCustomer) {
			CustomerDTO customerDTO = new CustomerDTO();
			customerDTO = customerDTO.convertCustomerDTO(customerEntity);
			listCustomerDTO.add(customerDTO);
		}
		mv.addObject("listCustomerDTO", listCustomerDTO);
		String status = request.getParameter("status");
	    request.setAttribute("status", status);
		return mv;
	}
	
	@RequestMapping("/edit")
	ModelAndView editCustomer(@RequestParam("idCustomer") int idCustomer) {
		logger.info("load into edit customer");
		ModelAndView mv = new ModelAndView("EditCustomer");
		Optional<CustomerEntity> customerOptional = customerService.findById(idCustomer);
		CustomerDTO customerDTO = new CustomerDTO();
		customerDTO = customerDTO.convertCustomerDTO(customerOptional.get());
		mv.addObject("customerDTO", customerDTO);
		return mv;
	}
	
	@RequestMapping(value = "edit/save_edit", method = RequestMethod.POST)
	String editSaveCustomer(@ModelAttribute("editCustomer") CustomerDTO customerDTO, HttpServletRequest request) {
		try {
			CustomerDTO customerDTOTmp = new CustomerDTO();
			CustomerEntity customerEntity = customerDTOTmp.convertCustomerEntity(customerDTO);
			customerService.save(customerEntity);
			logger.info("edit customer success");
			request.setAttribute("status", "success");
		} catch (Exception e) {
			logger.info("edit customer failed");
			logger.error(e);
			request.setAttribute("status", "failed");
		}
		return "redirect:/customer/list_customer?status=" + request.getAttribute("status");
	}
	
	@RequestMapping("/delete")
	String deleteCustomer(@RequestParam("idCustomer") int idCustomer) {
		logger.info("delete customer page");
		List<OrderEntity> listOrder = orderService.findOrderByCustomer(idCustomer);
		if(!listOrder.isEmpty()) {
			orderDetailService.deleteOrderDetailById(listOrder.get(0).getIdOrder());
			orderService.deleteOrderByCustomer(idCustomer);
		}
		List<ShoppingCartEntity> listCart = shoppingCartService.findCartByCustomer(idCustomer);
		if(!listCart.isEmpty()) {
			cartItemService.deleteItemByCartid(listCart.get(0).getIdCartShopping());
			shoppingCartService.deleteOrderByCustomer(idCustomer);
		}
		customerService.deleteById(idCustomer);
		return "redirect:/customer/list_customer";
	}
}
