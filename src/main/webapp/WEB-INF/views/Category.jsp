<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/TechWorldAdmin/URLToReachResourcesFolder/css/style.css">
<link rel="stylesheet" href="/TechWorldAdmin/URLToReachResourcesFolder/css/category.css">
<link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.0/css/line.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
<script src="/TechWorldAdmin/URLToReachResourcesFolder/js/AddCategory.js"></script>
<title>Admin - Category Management</title>
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
                    <i class="fa-solid fa-user"></i>
                    <span class="link-name">Customer</span>
                </a></li>
                <li><a href="<%=request.getContextPath()%>/category">
                    <i class="fa-solid fa-cart-shopping"></i>
                    <span class="link-name">Category</span>
                </a></li>
                <li><a href="<%=request.getContextPath()%>/product">
                    <i class="uil uil-comments"></i>
                    <span class="link-name">Product</span>
                </a></li>
                <li><a href="<%=request.getContextPath()%>/order">
                    <i class="uil uil-share"></i>
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
                    <span class="text">WELCOME TO CATEGORY MANAGEMENT</span>
                </div>
                
                <div class="boxes">
                    <div class="box box1">
                        <label id="add-category-btn">
                            <i class="fa-solid fa-plus"></i>
                        </label>
                        <span class="text">Add Category</span>
                    </div>
                    <div class="box box2">
                        <a href="category/list_category">
                            <i class="fa-solid fa-list"></i>
                        </a>
                        <span class="text">List</span>
                    </div>
                    <div class="box box3">
                        <span class="text">Total Category</span>
                        <span class="number">${countCategory}</span>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <div class="overlay" id="overlay">
        <div class="popup">
            <span class="delete-icon" id="delete-icon">
                <i class="fas fa-times"></i>
            </span>
            <div class="container">
                <div class="text">
                    Add Category
                 </div>
                <form action="category/add_category" method="post" onsubmit="return validateForm();">
                    <div class="data">
                       <label for="name">Name Category: </label>
                       <input type="text" id="name" name="nameCategory" placeholder="Category name..">
                       <div class="error-message"></div>
                    </div>
                    <div class="btn">
                       <div class="inner"></div>
                       <button type="submit">add</button>
                    </div>
                 </form>
            </div>
        </div>
    </div>

    <script>
        const addCategoryBtn = document.getElementById("add-category-btn");
        const overlay = document.getElementById("overlay");
        const deleteIcon = document.getElementById("delete-icon");
        const categoryNameInput = document.getElementById("name");

        addCategoryBtn.addEventListener("click", () => {
            overlay.style.display = "block";
        });

        deleteIcon.addEventListener("click", () => {
            overlay.style.display = "none";
            categoryNameInput.value = "";
        });
    </script>
    <script src="/TechWorldAdmin/URLToReachResourcesFolder/js/validator.js"></script>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<script type="text/javascript">
		var status = document.getElementById("status").value;
		if (status === "success") {
			swal("Congrats", "Add Category Successfully", "success");
		}
		if (status === "failed") {
			swal("Sorry", "Add Category Failed", "error");
		}
	</script>
</body>
</html>