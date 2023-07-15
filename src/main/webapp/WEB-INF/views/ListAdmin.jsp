<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/TechWorldAdmin/URLToReachResourcesFolder/css/style.css">
<link rel="stylesheet" href="/TechWorldAdmin/URLToReachResourcesFolder/css/ListAdmin.css">
<link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.0/css/line.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
<title>Admin - List Admin</title>
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

            <div class="search-box">
                <i class="uil uil-search"></i>
                <input type="text" placeholder="Search here...">
            </div>
            
        </div>

        <div class="dash-content">
            <div class="overview">
                <div class="title">
                    <i class="uil uil-tachometer-fast-alt"></i>
                    <span class="text">List Admin/Employee</span>
                </div>
            </div>

            <div class="activity">
                <table>
                    <tr>
                      <th>ID</th>
                      <th>Name</th>
                      <th>Email</th>
                      <th>Phone Number</th>
                      <th>Role</th>
                      <th>Options</th>
                    </tr>
					<c:forEach var = "admin" items = "${listAdminDTO}">
						<tr>
	                      <td>${admin.idAdmin}</td>
	                      <td>${admin.nameAdmin}</td>
	                      <td>${admin.email}</td>
	                      <td>${admin.phoneNumber}</td>
	                      <td>${admin.roleName}</td>
	                      <td>
	                      	<a href="<%=request.getContextPath()%>/admin/edit?idAdmin=${admin.idAdmin}">
	                      		<button class="button button-1" id="add-category-btn">Update</button>
	                      	</a>
							<button class="button button-2" onclick="confirmDelete(${admin.idAdmin})">Delete</button>
							<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
							<script type="text/javascript">
							    function confirmDelete(idAdmin) {
							        swal({
							            title: "Are you sure?",
							            text: "Once deleted, you will not be able to recover this user!",
							            icon: "warning",
							            buttons: true,
							            dangerMode: true,
							        }).then((willDelete) => {
							            if (willDelete) {
							                swal("Poof! User deleted!", {
							                    icon: "success",
							                }).then(() => {
							                    window.location.href = '<%=request.getContextPath()%>/admin/delete?idAdmin=' + idAdmin;
							                });
							            } else {
							                swal("User not deleted!");
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
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<script type="text/javascript">
		var status = document.getElementById("status").value;
		if (status === "success") {
			swal("Congrats", "Edit User Successfully", "success");
		}
		if (status === "failed") {
			swal("Sorry", "Edit User Failed", "error");
		}
	</script>
</body>
</html>