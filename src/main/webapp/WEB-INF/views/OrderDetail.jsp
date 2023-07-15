<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <link rel="stylesheet" href="/TechWorldAdmin/URLToReachResourcesFolder/css/style.css">
    <link rel="stylesheet" href="/TechWorldAdmin/URLToReachResourcesFolder/css/OrderDetail.css">
    <link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.0/css/line.css">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <title>Admin - Order Detail Management</title>
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

                <div class="order-detail-content">
                	<div class="order-detail-content-left">
                		<div class="content-register">
		                  <div class="content">
		                      <form action="detail/save_detail" method="post">
		                        <div class="select-box">
		                          <span class="details">Status Order</span>
		                          <select class="w3-select w3-border" name="idOrderStatus" id="optionRole">
		                          	<c:forEach var="status" items="${listOrderStatus}">
		                          		<option value="${status.idStatus}" 
							                <c:if test="${status.idStatus == orderDTO.idOrderStatus}">
							                    selected
							                </c:if>
							            >
							                ${status.nameStatus}
							            </option>
		                          	</c:forEach>
		                          </select>
		                        </div>
		                        <div class="user-details">
		                          <input type="text" name="idOrder" value="${orderDTO.idOrder}" style="display: none;">
		                          <div class="input-box">
		                            <span class="details">Code Order</span>
		                            <input type="text" readonly="readonly" id="fullName" name="codeOrder" value="${orderDTO.codeOrder}">
		                          </div>
		                          <div class="input-box">
		                            <span class="details">Fullname</span>
		                            <input type="text" readonly="readonly" id="userName" name="customerDTO.nameCustomer" value="${orderDTO.customerDTO.nameCustomer}">
		                            
		                          </div>
		                          <div class="input-box">
		                            <span class="details">Email</span>
		                            <input type="email" readonly="readonly" id="email" name="customerDTO.email" value="${orderDTO.customerDTO.email}">
		                            
		                          </div>
		                          <div class="input-box">
		                            <span class="details">Phone Number</span>
		                            <input type="text" readonly="readonly" id="phoneNumber" name="customerDTO.phoneNumber" value="${orderDTO.customerDTO.phoneNumber}">
		                            
		                          </div>
		                          <div class="input-box">
		                            <span class="details">Order Date</span>
		                            <input type="text" readonly="readonly" id="passWord" name="dateOrder" value="${orderDTO.dateOrder}">
		                            
		                          </div>
		                          <div class="input-box">
		                            <span class="details">Total</span>
		                            <input type="text" readonly="readonly"  name="total" value="${orderDTO.total}" style="display: none;">
		                            <div class="total-input">
		                            	<p ><fmt:formatNumber value="${orderDTO.total}" pattern="###,###,###"/>VND</p>
		                            </div>
		                            
		                          </div>
		                          <div class="input-box">
		                            <span class="details">Address</span>
		                            <textarea type="text" readonly="readonly" name="customerDTO.address" id="repeatPassWord">${orderDTO.customerDTO.address}</textarea>
		                            
		                          </div>
		                          <div class="input-box">
		                            <span class="details">Description</span>
		                            <textarea type="text" readonly="readonly" id="repeatPassWord" name="description" >${orderDTO.description}</textarea>
		                            
		                          </div>
		                        </div>
		                        <div class="button">
		                          <input type="submit" value="Confirm">
		                        </div>
		                      </form>
		                    </div>
		              ` </div>
                	</div>
                	<div class="order-detail-content-right">
                		<table id="customers">
						  <tr>
						    <th>Product Name</th>
						    <th>Unit Price</th>
						    <th>Quantity</th>
						    <th>Amount</th>
						  </tr>
						  <c:forEach var="orderDetail" items="${listOrderDetail}">
						  	<tr>
							    <td>${orderDetail.producEntity.nameProduct}</td>
							    <td><fmt:formatNumber value="${orderDetail.producEntity.unitPrice}" pattern="###,###,###"/>VND</td>
							    <td>${orderDetail.quantity}</td>
							    <td><fmt:formatNumber value="${orderDetail.producEntity.unitPrice*orderDetail.quantity}" pattern="###,###,###"/>VND</td>
							  </tr>
						  </c:forEach>
						</table>
                	</div>
                </div>
            </div>
        </div>
    </section>
    <script src="/TechWorldAdmin/URLToReachResourcesFolder/js/validator.js"></script>
</body>
</html>