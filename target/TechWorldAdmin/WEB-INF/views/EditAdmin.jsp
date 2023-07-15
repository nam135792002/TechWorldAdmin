<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/TechWorldAdmin/URLToReachResourcesFolder/css/style.css">
<link rel="stylesheet" href="/TechWorldAdmin/URLToReachResourcesFolder/css/register.css">
<script src="/TechWorldAdmin/URLToReachResourcesFolder/js/RegisterAdmin.js"></script>
<link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.0/css/line.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
<title>Admin - Edit Admin</title>
<style type="text/css">
	.content-register{
	  height: 90vh;
	}
	
	.user-details .input-box select{
	  height: 45px;
	  width: 100%;
	  outline: none;
	  font-size: 16px;
	  border-radius: 5px;
	  padding-left: 15px;
	  border: 1px solid #ccc;
	  border-bottom-width: 2px;
	  transition: all 0.3s ease;
	  background-color: var(--panel-color);
	  color: var(--text-color);
	}
	
	.user-details .input-box select:focus,
	.user-details .input-box select:valid{
	  border-color: #9b59b6;
	}
</style>
</head>
<body>
	<nav>
        <div class="logo-name">
            <span class="logo_name">TechWorld</span>
        </div>

        <div class="menu-items">
            <ul class="nav-links">
                <li><a href="<%=request.getContextPath()%>/dashboard">
                    <i class="uil uil-estate"></i>
                    <span class="link-name">Dashboard</span>
                </a></li>
                <li><a href="<%=request.getContextPath()%>/admin">
                    <i class="fa-regular fa-user"></i>
                    <span class="link-name">Admin</span>
                </a></li>
                <li><a href="<%=request.getContextPath()%>/customer">
                    <i class="fa-solid fa-users"></i>
                    <span class="link-name">Customer</span>
                </a></li>
                <li><a href="<%=request.getContextPath()%>/category">
                    <i class="fa-solid fa-cart-shopping"></i>
                    <span class="link-name">Category</span>
                </a></li>
                <li><a href="<%=request.getContextPath()%>/product">
                    <i class="fa-solid fa-bag-shopping"></i>
                    <span class="link-name">Product</span>
                </a></li>
                <li><a href="<%=request.getContextPath()%>/order">
                    <i class="fa-solid fa-tag"></i>
                    <span class="link-name">Order</span>
                </a></li>
            </ul>
            
            <ul class="logout-mode">
                <li><a href="#">
                    <i class="uil uil-signout"></i>
                    <span class="link-name">Logout</span>
                </a></li>

                <li class="mode">
                    <a href="#">
                        <i class="uil uil-moon"></i>
                    <span class="link-name">Dark Mode</span>
                </a>

                <div class="mode-toggle">
                  <span class="switch"></span>
                </div>
            </li>
            </ul>
        </div>
    </nav>

    <section class="dashboard">
        <div class="top">
            <i class="uil uil-bars sidebar-toggle"></i>

            <div class="search-box">
                <i class="uil uil-search"></i>
                <input type="text" placeholder="Search here...">
            </div>
            
        </div>

        <div class="dash-content">
            <div class="overview">
                <div class="title">
                    <i class="uil uil-tachometer-fast-alt"></i>
                    <span class="text">WELCOME TO ADMIN MANAGEMENT - EDIT ADMIN</span>
                </div>
                
                <div class="content-register">
                  <div class="content">
                      <form action="edit/save_edit" method="post" onsubmit="return validateForm();">
						  <div class="user-details">
						  	<div class="input-box">
						      <span class="details">ID</span>
						      <input type="text" name="idAdmin" value="${adminDTO.idAdmin}" readonly="readonly">
						      <div class="error-message"></div>
						    </div>
						    <div class="input-box">
							    <span class="details">Role</span>
							    <select class="w3-select w3-border" name="roleName" id="optionRole">
							        <option value="" disabled>Choose your role</option>
							        <option value="Admin" ${adminDTO.roleName == 'Admin' ? 'selected' : ''}>Admin</option>
							        <option value="Employee" ${adminDTO.roleName == 'Employee' ? 'selected' : ''}>Employee</option>
							    </select>
							    <div class="error-message"></div>
							</div>

						    <div class="input-box">
						      <span class="details">Full Name</span>
						      <input type="text" placeholder="Enter your name" id="fullName" name="nameAdmin" value="${adminDTO.nameAdmin}">
						      <div class="error-message"></div>
						    </div>
						    <div class="input-box">
						      <span class="details">Username</span>
						      <input type="text" placeholder="Enter your username" id="userName" name="username" value="${adminDTO.username}">
						      <div class="error-message"></div>
						    </div>
						    <div class="input-box">
						      <span class="details">Email</span>
						      <input type="email" placeholder="Enter your email" id="email" name="email" value="${adminDTO.email}">
						      <div class="error-message"></div>
						    </div>
						    <div class="input-box">
						      <span class="details">Phone Number</span>
						      <input type="text" placeholder="Enter your number" id="phoneNumber" name="phoneNumber" value="${adminDTO.phoneNumber}">
						      <div class="error-message"></div>
						    </div>
						    <div class="input-box">
						      <span class="details">Password</span>
						      <input type="password" placeholder="Enter your password" id="passWord" name="password" value="${adminDTO.password}">
						      <div class="error-message"></div>
						    </div>
						    <div class="input-box">
						      <span class="details">Confirm Password</span>
						      <input type="password" placeholder="Confirm your password" id="repeatPassWord" name="repeatPassWord" value="${adminDTO.password}">
						      <div class="error-message"></div>
						    </div>
						  </div>
						  <div class="button">
						    <input type="submit" value="Register">
						  </div>
						</form>
                    </div>
              ` </div>

            </div>
        </div>
    </section>
    <script src="/TechWorldAdmin/URLToReachResourcesFolder/js/validator.js"></script>
</body>
</html>