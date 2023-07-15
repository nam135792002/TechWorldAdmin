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
<title>Admin - Add Admin</title>
</head>
<body>
	<input type="hidden" id="status" value="${status}">
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
                <li><a href="<%=request.getContextPath()%>/logout">
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
                    <span class="text">WELCOME TO ADMIN MANAGEMENT - ADD ADMIN</span>
                </div>
                
                <div class="content-register">
                  <div class="content">
                      <form action="add_admin/save_add" method="post" onsubmit="return validateForm();">
                        <div class="select-box">
                          <span class="details">Role</span>
                          <select class="w3-select w3-border" name="roleName" id="optionRole">
                            <option value="" disabled selected>Choose your role</option>
                            <option value="ROLE_ADMIN">Admin</option>
                            <option value="ROLE_EMPLOYEE">Employee</option>
                          </select>
                          <div class="error-message"></div>
                        </div>
                        <div class="user-details">
                          <div class="input-box">
                            <span class="details">Full Name</span>
                            <input type="text" placeholder="Enter your name" id="fullName" name="nameAdmin">
                            <div class="error-message"></div>
                          </div>
                          <div class="input-box">
                            <span class="details">Username</span>
                            <input type="text" placeholder="Enter your username" id="userName" name="username">
                            <div class="error-message"></div>
                          </div>
                          <div class="input-box">
                            <span class="details">Email</span>
                            <input type="email" placeholder="Enter your email" id="email" name="email">
                            <div class="error-message"></div>
                          </div>
                          <div class="input-box">
                            <span class="details">Phone Number</span>
                            <input type="text" placeholder="Enter your number" id="phoneNumber" name="phoneNumber">
                            <div class="error-message"></div>
                          </div>
                          <div class="input-box">
                            <span class="details">Password</span>
                            <input type="password" placeholder="Enter your password" id="passWord" name="password">
                            <div class="error-message"></div>
                          </div>
                          <div class="input-box">
                            <span class="details">Confirm Password</span>
                            <input type="password" placeholder="Confirm your password" id="repeatPassWord" name="repeatPassWord">
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
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<script type="text/javascript">
		var status = document.getElementById("status").value;
		if (status === "success") {
			swal("Congrats", "Add User Successfully", "success");
		}
		if (status === "failed") {
			swal("Sorry", "Add User Failed", "error");
		}
	</script>
</body>
</html>