<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/TechWorldAdmin/URLToReachResourcesFolder/css/style.css">
<link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.0/css/line.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
<title>Admin Dashbord Management</title>
</head>
<body>
	<nav>
        <div class="logo-name">
            <span class="logo_name">TechWorld</span>
        </div>

        <div class="menu-items">
            <ul class="nav-links">
                <li><a href="<%=request.getContextPath()%>/dashboardEmployee">
                    <i class="uil uil-estate"></i>
                    <span class="link-name">Dashboard</span>
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
                    <span class="text">Dashboard</span>
                </div>

                <div class="boxes">
                    <div class="box box1">
                        <i class="fa-solid fa-cart-shopping"></i>
                        <span class="text">Category</span>
                        <span class="number">${countCategory}</span>
                    </div>
                    <div class="box box2">
                        <i class="fa-solid fa-bag-shopping"></i>
                        <span class="text">Product</span>
                        <span class="number">${countProduct}</span>
                    </div>
                    <div class="box box3">
                        <i class="fa-solid fa-tag"></i>
                        <span class="text">Order</span>
                        <span class="number">${countOrder}</span>
                    </div>
                    <div class="box box4">
                        <i class="fa-solid fa-users"></i>
                        <span class="text">Customer</span>
                        <span class="number">${countCustomer}</span>
                    </div>
                    <div class="box box5">
                        <i class="fa-regular fa-user"></i>
                        <span class="text">Admin</span>
                        <span class="number">${countAdmin}</span>
                    </div>
                    <div class="box box6">
                        <i class="fa-solid fa-user"></i>
                        <span class="text">Employee</span>
                        <span class="number">${countEmployee}</span>
                    </div>
                </div>
            </div>

            <div class="activity">
                <div class="title">
                    <i class="uil uil-clock-three"></i>
                    <span class="text">Recent Activity</span>
                </div>

                <table id="customers">
                    <tr>
                      <th>ID</th>
                      <th>Name</th>
                      <th>Email</th>
                      <th>Phone Number</th>
                      <th>Role</th>
                    </tr>
					<c:forEach var = "admin" items = "${listAdminDTO}">
						<tr>
	                      <td>${admin.idAdmin}</td>
	                      <td>${admin.nameAdmin}</td>
	                      <td>${admin.email}</td>
	                      <td>${admin.phoneNumber}</td>
	                      <td>${admin.roleName}</td>
	                    </tr>
					</c:forEach>
                  </table>
            </div>
        </div>
    </section>
    <script src="/TechWorldAdmin/URLToReachResourcesFolder/js/validator.js"></script>
</body>
</html>