package r2s.com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import r2s.com.dto.UserDetailsDTO;
import r2s.com.models.AdminEntity;
import r2s.com.service.AdminService;

@Controller
public class LoginController {
	
	private final static Logger logger = Logger.getLogger(LoginController.class);
	
	@Autowired
	AdminService adminService;
	
	@RequestMapping(value={"/login","/"})
	public ModelAndView login(@RequestParam(value = "error",required = false) String error, HttpServletRequest request) {
		logger.info("load into login page");
		ModelAndView model = new ModelAndView("Login");
		if (error != null) {
			logger.info("login failed");
			request.setAttribute("status", "failed");
		}
		return model;
	}
	
	@RequestMapping("/save_login")
	public String saveLogin(HttpSession session) {
		UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) SecurityContextHolder
				.getContext().getAuthentication();

		AdminEntity loggedInUser = ((UserDetailsDTO)authentication.getPrincipal()).getUserDetails();
		session.setAttribute("user", loggedInUser);
		return "redirect:/dashboard";
	}
	
}
