<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/TechWorldAdmin/URLToReachResourcesFolder/css/style.css">
<link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.0/css/line.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
<title>Admin - Order List</title>
<style type="text/css">
	.button {
	    border: none;
	    padding: 15px 20px;
	    text-align: center;
	    text-decoration: none;
	    display: inline-block;
	    margin: 4px 2px;
	    cursor: pointer;
	    font-size: 15px;
	    border-radius: 7px;
	}
	
	.button-1{
	    background-color: #4CAF50; /* Green */
	}
	
	.button-2{
	    background-color: red;
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
            <div class="activity">
                <div class="title">
                    <i class="uil uil-clock-three"></i>
                    <span class="text">List Order</span>
                </div>

                <table id="customers">
                    <tr>
                      <th>Code Order</th>
                      <th>Address Order</th>
                      <th>Total</th>
                      <th>Order's Status</th>
                      <th>Phone Number</th>
                      <th>Option</th>
                    </tr>
					<c:forEach var = "order" items = "${listOrder}">
						<tr>
	                      <td>${order.codeOrder}</td>
	                      <td>${order.addressOrder}</td>
	                      <td><fmt:formatNumber value="${order.total}" pattern="###,###,###"/>VND</td>
	                      <td>${order.orderStatusEntity.nameStatus}</td>
	                      <td>${order.phoneNumber}</td>
	                      <td>
							<a href="<%=request.getContextPath()%>/order/detail?idOrder=${order.idOrder}">
	                      		<button class="button button-1" id="add-category-btn">Detail</button>
	                      	</a>
							<button class="button button-2" onclick="confirmDelete(${order.idOrder})">Delete</button>
							<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
							<script type="text/javascript">
							    function confirmDelete(idOrder) {
							        swal({
							            title: "Are you sure?",
							            text: "Once deleted, you will not be able to recover this order!",
							            icon: "warning",
							            buttons: true,
							            dangerMode: true,
							        }).then((willDelete) => {
							            if (willDelete) {
							                swal("Poof! Order deleted!", {
							                    icon: "success",
							                }).then(() => {
							                    window.location.href = '<%=request.getContextPath()%>/order/delete?idOrder=' + idOrder;
							                });
							            } else {
							                swal("Order not deleted!");
							            }
							        });
							    }
							</script>
						  </td>
	                    </tr>
					</c:forEach>
                  </table>
            </div>
        </div>
    </section>
    <script src="/TechWorldAdmin/URLToReachResourcesFolder/js/validator.js"></script>
</body>
</html>