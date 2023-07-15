package r2s.com.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import r2s.com.dto.AdminDTO;
import r2s.com.models.AdminEntity;
import r2s.com.models.RoleEntity;
import r2s.com.service.AdminService;
import r2s.com.service.RoleService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	private final static Logger logger = Logger.getLogger(AdminController.class);
	
	@Autowired
	AdminService adminService;
	
	@Autowired
	RoleService roleService;
	
	@RequestMapping("/add_admin")
	String addAdmin(HttpServletRequest request) {
		String status = request.getParameter("status");
	    request.setAttribute("status", status);
		return "AddAdmin";
	}
	
	@RequestMapping(value = "/add_admin/save_add", method = RequestMethod.POST)
	String addSaveAdmin(@ModelAttribute("newAdmin") AdminDTO adminDTO, HttpServletRequest request, Model model) {
		List<AdminEntity> listAdminEnitity = adminService.findAdminByUsername(adminDTO.getUsername());
		if(listAdminEnitity.isEmpty()) {
			try {
				AdminDTO adminDTOTmp = new AdminDTO();
				AdminEntity adminEntity = new AdminEntity();
				
				BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
	        	String encryptedPwd = bcrypt.encode(adminDTO.getPassword());
				
				adminEntity = adminDTOTmp.convertAdminEntity(adminDTO);
				adminEntity.setPassword(encryptedPwd);
				adminEntity = adminService.save(adminEntity);
				
				RoleEntity roleEntity = new RoleEntity();
				
				roleEntity.setRoleName(adminDTO.getRoleName());
				roleEntity.setAdminEntity(adminEntity);
				roleService.save(roleEntity);
				logger.info("add admin success");
				request.setAttribute("status", "success");
			} catch (Exception e) {
				logger.error(e);
				logger.info("add admin failed");
				request.setAttribute("status", "failed");
			}
		}
		else {
			model.addAttribute("admin", adminDTO);
			request.setAttribute("status", "duplicateUsername");
		}
		return "AddAdmin";
	}
	
	@RequestMapping("/list_admin")
	ModelAndView listAdmin(HttpServletRequest request) {
		logger.info("load into list admin");
		ModelAndView mv = new ModelAndView("ListAdmin");
		List<AdminEntity> listAdmin = adminService.findAll();
		List<AdminDTO> listAdminDTO = new ArrayList<>();
		for (AdminEntity adminEntity : listAdmin) {
			AdminDTO adminDTO = new AdminDTO();
			adminDTO = adminDTO.convertAdminDTO(adminEntity);
			List<RoleEntity> roleList = roleService.findRolesByAdminId(adminDTO.getIdAdmin());
			adminDTO.setRoleName(roleList.get(0).getRoleName());
			listAdminDTO.add(adminDTO);
		}
		mv.addObject("listAdminDTO", listAdminDTO);
		String status = request.getParameter("status");
	    request.setAttribute("status", status);
		return mv;
	}
	
	@RequestMapping("/edit")
	ModelAndView editAdmin(@RequestParam("idAdmin") int idAdmin) {
		logger.info("load into edit admin");
		
		ModelAndView mv = new ModelAndView("EditAdmin");
		Optional<AdminEntity> adminOptional = adminService.findById(idAdmin);
		AdminEntity adminEntity = adminOptional.get();
		AdminDTO adminDTO = new AdminDTO();
		adminDTO = adminDTO.convertAdminDTO(adminEntity);
		
		RoleEntity roleEntity = new RoleEntity();
		List<RoleEntity> roleList = roleService.findRolesByAdminId(idAdmin);
		roleEntity = roleList.get(0);
		
		adminDTO.setRoleName(roleEntity.getRoleName());
		mv.addObject("adminDTO", adminDTO);
		return mv;
	}
	
	@RequestMapping(value = "/edit/save_edit", method = RequestMethod.POST)
	String editSaveAdmin(@ModelAttribute("editAdmin") AdminDTO adminDTO, HttpServletRequest request) {
		try {
			System.out.println(adminDTO.getRoleName());
			AdminDTO adminDTOTmp = new AdminDTO();
			AdminEntity adminEntity = new AdminEntity();
			
			adminEntity = adminDTOTmp.convertAdminEntity(adminDTO);
			adminEntity = adminService.save(adminEntity);
			
			RoleEntity roleEntity = new RoleEntity();
			List<RoleEntity> roleOptional = roleService.findRolesByAdminId(adminDTO.getIdAdmin());
			roleEntity = roleOptional.get(0);
			roleEntity.setRoleName(adminDTO.getRoleName());
			roleEntity.setAdminEntity(adminEntity);
			roleService.save(roleEntity);
			logger.info("edit admin success");
			request.setAttribute("status", "success");
		} catch (Exception e) {
			logger.error(e);
			logger.info("edit admin failed");
			request.setAttribute("status", "failed");
		}
		return "redirect:/admin/list_admin?status=" + request.getAttribute("status");
	}
	
	@RequestMapping("/delete")
	String deleteAdmin(@RequestParam("idAdmin") int idAdmin) {
		try {
			RoleEntity roleEntity = new RoleEntity();
			List<RoleEntity> roleOptional = roleService.findRolesByAdminId(idAdmin);
			roleEntity = roleOptional.get(0);
			roleService.delete(roleEntity);
			adminService.deleteById(idAdmin);
			logger.info("delete admin success");
		} catch (Exception e) {
			logger.error(e);
			logger.info("delete admin failed");
		}
		return "redirect:/admin/list_admin";
	}
}
