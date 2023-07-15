<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/TechWorldAdmin/URLToReachResourcesFolder/css/style.css">
<link rel="stylesheet" href="/TechWorldAdmin/URLToReachResourcesFolder/css/ListCategory.css">
<link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.0/css/line.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
<title>Admin - List Category</title>
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
                    <span class="text">WELCOME TO CATEGORY MANAGEMENT</span>
                </div>
                
                <table>
                    <tr>
                      <th>Category's code</th>
                      <th>Category's name</th>
                      <th>Options</th>
                    </tr>
                    <c:forEach var = "category" items = "${listCategoryDTOs}">
                    	<tr>
	                      <td>${category.codeCategory}</td>
	                      <td>${category.nameCategory}</td>
	                      <td>
	                      	<a href="<%=request.getContextPath()%>/category/edit?idCategory=${category.idCategory}">
	                      		<button class="button button-1" id="add-category-btn">Update</button>
	                      	</a>
	                      	<button class="button button-2" onclick="confirmDelete('${category.idCategory}')">Delete</button>
	                      	
	                      	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
							<script type="text/javascript">
								function confirmDelete(idCategory) {
									swal({
										title: "Are you sure?",
										text: "Once deleted, you will not be able to recover all this category!",
											icon: "warning",
										    buttons: true,
										    dangerMode: true,
									})
									.then((willDelete) => {
										if (willDelete) {
											swal("Poof! Categoey deleted!", {
										    icon: "success",
									})
									.then(() => {
										window.location.href = '<%=request.getContextPath()%>/category/delete?idCategory=' + idCategory;
									});
									} else {
										swal("Category not deleted!");
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
    <c:if test="${status eq 'openPopUp'}">
    	<div class="overlay" id="overlay" style="display: block;">
	        <div class="popup">
	            <span class="delete-icon" id="delete-icon">
	                <i class="fas fa-times"></i>
	            </span>
	            <div class="container">
	                <div class="text">
	                    Edit Category
	                 </div>
	                <form action="edit/save_edit" method="post">
	                	<div class="data" style="display: none;">
	                        <label for="name">Code Category: </label>
	                        <input type="text" id="code" name="idCategory" value="${category.idCategory}" readonly="readonly" style="background-color: antiquewhite;">
	                        <div class="error-message"></div>
	                    </div>
	                    <div class="data">
	                        <label for="name">Code Category: </label>
	                        <input type="text" id="code" name="codeCategory" value="${category.codeCategory}" readonly="readonly" style="background-color: antiquewhite;">
	                        <div class="error-message"></div>
	                    </div>
	                    <div class="data">
	                       <label for="name">Name Category: </label>
	                       <input type="text" id="name" name="nameCategory" value="${category.nameCategory}">
	                       <div class="error-message"></div>
	                    </div>
	                    <div class="btn">
	                       <div class="inner"></div>
	                       <button type="submit">edit</button>
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
	</c:if>
	
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
		  <script type="text/javascript">
		  var status = document.getElementById("status").value;
		  if (status === "success") {
		  	swal("Congrats", "Edit Category Successfully", "success");
		  }
		  if (status === "failed") {
		  	swal("Sorry", "Edit Category Failed", "error");
		  }
	</script>
		
    <script src="/TechWorldAdmin/URLToReachResourcesFolder/js/validator.js"></script>
</body>
</html>