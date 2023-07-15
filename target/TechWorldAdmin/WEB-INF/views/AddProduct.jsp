<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/TechWorldAdmin/URLToReachResourcesFolder/css/style.css">
<link rel="stylesheet" href="/TechWorldAdmin/URLToReachResourcesFolder/css/AddProduct.css">
<link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.0/css/line.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
<script src="/TechWorldAdmin/URLToReachResourcesFolder/js/AddCategory.js"></script>
<title>Admin - Add Product</title>
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
                    <span class="link-name">Admin</span>
                </a></li>

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
                    <span class="text">WELCOME TO PRODUCT MANAGEMENT - ADD</span>
                </div>
                <div class="container">
                    <div class="title">Add Product</div>
                    <div class="content">
                      <form action="add_product/save_add" method="post" enctype="multipart/form-data" onsubmit="return validateForm();">
                        <div class="user-details">
                          <div class="input-box">
                            <span class="details">Name</span>
                            <input type="text" placeholder="Enter product's name" name="nameProduct" id="nameProduct">
                            <div class="error-message"></div>
                          </div>
                          <div class="input-box">
                            <span class="details">Unit price</span>
                            <input type="text" placeholder="Enter product's unit price" name="unitPrice" id="unitPrice">
                            <div class="error-message"></div>
                          </div>
                          <div class="input-box">
                            <span class="details">Category's name</span>
                            <select class="w3-select" name="categoryDTO.idCategory" id="optionProduct">
                                <option value="" disabled selected>Choose category option</option>
                                <c:forEach var="category" items="${listCategoryDTO}">
                                	<option value="${category.idCategory}">${category.nameCategory}</option>
                                </c:forEach>
                            </select>
                            <div class="error-message"></div>
                          </div>
                          <div class="input-box">
                            <span class="details">Quantity</span>
                            <input type="text" placeholder="Enter product's quantity" name="quantity" id="quantityProduct">
                            <div class="error-message"></div>
                          </div>
                        </div>
                        <div class="area-box">
                          <span class="details">Description</span>
                          <textarea type="text" placeholder="Enter product's description" name="discription" id="descriptionProduct"></textarea>
                          <div class="error-message"></div>
                        </div>

                        <div class="upload-box">
                            <span class="details">Product's avatar</span>
                            <input type="file" id="avatarImage" accept="image/png, image/jpeg" name="avatarImage">
                            <div class="error-message"></div>
                            <label for="avatarImage">
                                <i class="fas fa-upload"></i> &nbsp; Choose A Photo
                            </label>
                            <p id="one-files">No Files Chosen</p>
                            <div id="one-image"></div>
                        </div>

                        <div class="upload-box">
                            <span class="details">Related product's images</span>
                            <input type="file" id="file-input" accept="image/png, image/jpeg" onchange="preview()" multiple name="imageMultiple">
                            <div class="error-message"></div>
                            <label for="file-input">
                                <i class="fas fa-upload"></i> &nbsp; Choose Many Photo
                            </label>
                            <p id="num-of-files">No Files Chosen</p>
                            <div id="images"></div>
                        </div>

                        <div class="button">
                          <input type="submit" value="ADD">
                        </div>

                      </form>
                    </div>
                  </div>
            </div>
        </div>
    </section>
    <script src="/TechWorldAdmin/URLToReachResourcesFolder/js/validator.js"></script>
    <script src="/TechWorldAdmin/URLToReachResourcesFolder/js/AddProduct.js"></script>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<script type="text/javascript">
		var status = document.getElementById("status").value;
		if (status === "success") {
			swal("Congrats", "Add Product Successfully", "success");
		}
		if (status === "failed") {
			swal("Sorry", "Add product Failed", "error");
		}
	</script>
</body>
</html>