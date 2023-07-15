package r2s.com.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import r2s.com.dto.CustomerDTO;
import r2s.com.dto.OrderDTO;
import r2s.com.models.CustomerEntity;
import r2s.com.models.OrderDetailEntity;
import r2s.com.models.OrderEntity;
import r2s.com.models.OrderStatusEntity;
import r2s.com.service.CustomerService;
import r2s.com.service.OrderDetailService;
import r2s.com.service.OrderService;
import r2s.com.service.OrderStatusService;

@Controller
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	@Autowired
	OrderStatusService orderStatusService;
	@Autowired
	OrderDetailService orderDetailService;
	@Autowired
	CustomerService customerService;
	
	@RequestMapping("/list_order")
	ModelAndView listOrder(@RequestParam("list") String list) {
		ModelAndView mv = new ModelAndView("ListOrder");
		List<OrderEntity> listOrder = new ArrayList<>();
		if(list.equals("listOrder")) {
			listOrder = orderService.findAll();
		}else if(list.equals("listNew")) {
			listOrder = orderService.findOrderByStatus(1);
		}else if(list.equals("listPack")) {
			listOrder = orderService.findOrderByStatus(2);
		}else if(list.equals("listDelivery")) {
			listOrder = orderService.findOrderByStatus(3);
		}else if(list.equals("listSuccess")) {
			listOrder = orderService.findOrderByStatus(4);
		}
		mv.addObject("listOrder", listOrder);
		return mv;
	}
	@RequestMapping("/detail")
	ModelAndView orderDetail(@RequestParam("idOrder") int idOrder){
		ModelAndView mv = new ModelAndView("OrderDetail");
		List<OrderStatusEntity> listOrderStatus = orderStatusService.findAll();
		mv.addObject("listOrderStatus", listOrderStatus);
		OrderDTO orderDTO = new OrderDTO();
		Optional<OrderEntity> optionalOrderEntity = orderService.findById(idOrder);
		orderDTO = orderDTO.convertOrderDTO(optionalOrderEntity.get());
		orderDTO.setIdOrderStatus(optionalOrderEntity.get().getOrderStatusEntity().getIdStatus());
		Optional<CustomerEntity> optionalCustomerEntity = customerService.findById(optionalOrderEntity.get().getCustomerEntity().getIdCustomer());
		CustomerDTO customerDTO = new CustomerDTO();
		customerDTO = customerDTO.convertCustomerDTO(optionalCustomerEntity.get());
		orderDTO.setCustomerDTO(customerDTO);
		orderDTO.getCustomerDTO().setAddress(optionalOrderEntity.get().getAddressOrder());
		orderDTO.getCustomerDTO().setEmail(optionalOrderEntity.get().getEmail());
		orderDTO.getCustomerDTO().setPhoneNumber(optionalOrderEntity.get().getPhoneNumber());
		mv.addObject("orderDTO", orderDTO);
		List<OrderDetailEntity> listOrderDetail = orderDetailService.findOrderByOrderId(idOrder);
		mv.addObject("listOrderDetail", listOrderDetail);
		return mv;
	}
	@RequestMapping(value = "detail/save_detail",  method = RequestMethod.POST)
	String orderDetailSave(@ModelAttribute("orderDTO") OrderDTO orderDTO, HttpServletRequest request) {
		try {
			Optional<OrderEntity> optionalOrderEntity = orderService.findById(orderDTO.getIdOrder());
			OrderEntity orderEntity = optionalOrderEntity.get();
			Optional<OrderStatusEntity> optionalOrderStatusEntity = orderStatusService.findById(orderDTO.getIdOrderStatus());
			orderEntity.setOrderStatusEntity(optionalOrderStatusEntity.get());
			orderService.save(orderEntity);
			request.setAttribute("status", "success");
		} catch (Exception e) {
			request.setAttribute("status", "failed");
		}
		return "redirect:/order?status="+request.getAttribute("status");
	}
	
	@RequestMapping("/delete")
	String deleteOrder(@RequestParam("idOrder") int idOrder) {
		orderDetailService.deleteOrderDetailById(idOrder);
		orderService.deleteOrderById(idOrder);
		return "redirect:/order";
	}
}
