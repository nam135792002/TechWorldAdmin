<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <link rel="stylesheet" href="/TechWorldAdmin/URLToReachResourcesFolder/css/style.css">
    <link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.0/css/line.css">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <title>Admin - Order Management</title>
    <style type="text/css">
    	.box{
		    height: 150px;
		    text-align: center;
		    justify-content: center;
		}
    </style>
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
                <sec:authorize access="!hasRole('ROLE_EMPLOYEE')">
				    <li>
				        <a href="<%=request.getContextPath()%>/admin">
				            <i class="fa-regular fa-user"></i>
				            <span class="link-name">Admin</span>
				        </a>
				    </li>
				</sec:authorize>
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
                    <i class="fa-regular fa-user"></i>
                    <span class="link-name" style="font-size: 15px">Hi, ${user.username}!</span>
                </a></li>
            
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
        </div>        

        <div class="dash-content">
            <div class="overview">
                <div class="title">
                    <i class="uil uil-tachometer-fast-alt"></i>
                    <span class="text">WELCOME TO ORDER MANAGEMENT</span>
                </div>

                <div class="boxes">
                    <div class="box box1">
                        <a href="<%=request.getContextPath()%>/order/list_order?list=listOrder">
                            <i class="fa-solid fa-list"></i>
                        </a>
                        <span class="text">List</span>
                    </div>

                    <div class="box box2">
                        <span class="text">Total Order</span>
                        <span class="number">${countOrder}</span>
                    </div>

                    <div class="box box3">
                        <a href="<%=request.getContextPath()%>/order/list_order?list=listNew">
                            <i class="fa-solid fa-newspaper"></i>
                        </a>
                        <span class="text">New Order: ${countNewOrder}</span>
                    </div>

                    <div class="box box4">
                        <a href="<%=request.getContextPath()%>/order/list_order?list=listPack">
                            <i class="fa-solid fa-boxes-packing"></i>
                        </a>
                        <span class="text">Successful Packaging: ${countPackingOrder}</span>
                    </div>

                    <div class="box box5">
                        <a href="<%=request.getContextPath()%>/order/list_order?list=listDelivery">
                            <i class="fa-solid fa-truck"></i>
                        </a>
                        <span class="text">Delivering Order: ${countDeliveryOrder}</span>
                    </div>

                    <div class="box box6">
                        <a href="<%=request.getContextPath()%>/order/list_order?list=listSuccess">
                            <i class="fa-solid fa-check"></i>
                        </a>
                        <span class="text">Successful Delivery Order: ${countSuccessOrder}</span>
                    </div>
                    
                </div>
            </div>
        </div>
    </section>
    <script src="/TechWorldAdmin/URLToReachResourcesFolder/js/validator.js"></script>
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<script type="text/javascript">
		var status = document.getElementById("status").value;
		if (status === "success") {
			swal("Congrats", "Update order's status again successfully", "success");
		}
		if (status === "failed") {
			swal("Sorry", "Update order's status again Failed", "error");
		}
	</script>
</body>
</html>