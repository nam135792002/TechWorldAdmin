<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/TechWorldAdmin/URLToReachResourcesFolder/css/style.css">
<link rel="stylesheet" href="/TechWorldAdmin/URLToReachResourcesFolder/css/EditProduct.css">
<link rel="stylesheet" href="/TechWorldAdmin/URLToReachResourcesFolder/css/AddProduct.css">
<link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.0/css/line.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
<script src="/TechWorldAdmin/URLToReachResourcesFolder/js/AddCategory.js"></script>
<title>Admin - Edit Product</title>
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
                    <span class="text">WELCOME TO PRODUCT MANAGEMENT - EDIT</span>
                </div>
                <div class="container">
                    <div class="title">Add Product</div>
                    <div class="content">
                      <form action="edit/save_edit" method="post" enctype="multipart/form-data" onsubmit="return validateForm();">
                        <div class="user-details" style="display: flex;align-items: center;justify-content: center;">
                          <div class="input-box">
                            <input type="text" name="codeProduct" value="${productDTO.codeProduct}" readonly="readonly">
                            <div class="error-message"></div>
                          </div>
                        </div>
                        <div class="user-details">
                          <input type="text" name="idProduct" value="${productDTO.idProduct}" style="display: none">
                          <div class="input-box">
                            <span class="details">Name</span>
                            <input type="text" placeholder="Enter product's name" name="nameProduct" id="nameProduct" value="${productDTO.nameProduct}">
                            <div class="error-message"></div>
                          </div>
                          <div class="input-box">
                            <span class="details">Unit price</span>
                            <input type="text" placeholder="Enter product's unit price" name="unitPrice" id="unitPrice" value="${productDTO.unitPrice}">
                            <div class="error-message"></div>
                          </div>
                          <div class="input-box">
                            <span class="details">Category's name</span>
                            <select class="w3-select" name="categoryDTO.idCategory" id="optionProduct">
                                <option value="" disabled selected>Choose category option</option>
                                <c:forEach var="category" items="${listCategoryDTO}">
                                	<option value="${category.idCategory}"
                                		<c:if test="${category.idCategory == productDTO.categoryDTO.idCategory}">
						                    selected
						                </c:if>
                                	>
                                		${category.nameCategory}
                                	</option>
                                </c:forEach>
                            </select>
                            <div class="error-message"></div>
                          </div>
                          <div class="input-box">
                            <span class="details">Quantity</span>
                            <input type="text" placeholder="Enter product's quantity" name="quantity" id="quantityProduct" value="${productDTO.quantity}">
                            <div class="error-message"></div>
                          </div>
                        </div>
                        <div class="area-box">
                          <span class="details">Description</span>
                          <textarea type="text" placeholder="Enter product's description" name="discription" id="descriptionProduct">${productDTO.discription}</textarea>
                          <div class="error-message"></div>
                        </div>
                        <div class="button">
                          <input type="submit" value="Update">
                        </div>
                      </form>
                      
                      <div class="insert-image">
                      	<div class="insert-image-left">
                      		<form action="edit/photo_avatar?idProduct=${productDTO.idProduct}" method="post" enctype="multipart/form-data" onsubmit="return validateFormAvatar();">
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
		                        <div class="button">
                          			<input type="submit" value="Insert">
                        		</div>
                      		</form>
                      	</div>
                      	<div class="insert-image-right">
                      		<form action="edit/photo_relate?idProduct=${productDTO.idProduct}" method="post" enctype="multipart/form-data" onsubmit="return validateFormRelate();">
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
	                          		<input type="submit" value="Insert">
	                        	</div>
	                        </form>
                      	</div>
                      </div>
                      
                      <table id="customers">
						  <tr>
						    <th>Photo Name</th>
						    <th>Type</th>
						    <th>Image</th>
						    <th>Delete</th>
						  </tr>
						  <c:forEach var="image" items="${listPhotoProductEntity}">
							  <tr>
							    <td>${image.namePhoto}</td>
							    <td>${image.typeImage}</td>
							    <td>
							      <img class="myImg" src="data:image/jpeg;base64,${image.image}" width="50" height="150"/>
							      <div class="myModal modal">
							        <span class="close-img">&times;</span>
							        <img class="modal-content img01">
							        <div class="caption"></div>
							      </div>
							    </td>
							    <td id="td-icon">
							    	<i class="fa-solid fa-trash" onclick="confirmDelete(${image.idPhoto})"></i>
							    	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
									<script type="text/javascript">
									    function confirmDelete(idPhoto) {
									        swal({
									            title: "Are you sure?",
									            text: "Once deleted, you will not be able to recover this photo!",
									            icon: "warning",
									            buttons: true,
									            dangerMode: true,
									        }).then((willDelete) => {
									            if (willDelete) {
									                swal("Poof! Photo deleted!", {
									                    icon: "success",
									                }).then(() => {
									                    window.location.href = '<%=request.getContextPath()%>/product/delete_photo?idPhoto=' + idPhoto;
									                });
									            } else {
									                swal("Photo not deleted!");
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
            </div>
        </div>
    </section>
    <script src="/TechWorldAdmin/URLToReachResourcesFolder/js/validator.js"></script>
    <script src="/TechWorldAdmin/URLToReachResourcesFolder/js/AddProduct.js"></script>
    <script>
	  var modals = document.getElementsByClassName('myModal');
	  var images = document.getElementsByClassName('myImg');
	  var modalImages = document.getElementsByClassName("img01");
	  var captionTexts = document.getElementsByClassName("caption");
	
	  for (var i = 0; i < images.length; i++) {
	    images[i].onclick = function() {
	      var modal = this.parentNode.getElementsByClassName('myModal')[0];
	      var modalImg = modal.getElementsByClassName('img01')[0];
	      var captionText = modal.getElementsByClassName('caption')[0];
	
	      modal.style.display = "block";
	      modalImg.src = this.src;
	      captionText.innerHTML = this.alt;
	    }
	  }
	
	  var spans = document.getElementsByClassName("close-img");
	
	  for (var i = 0; i < spans.length; i++) {
	    spans[i].onclick = function() {
	      var modal = this.parentNode;
	      modal.style.display = "none";
	    }
	  }
	</script>
<script src="/TechWorldAdmin/URLToReachResourcesFolder/js/EditProduct.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<script type="text/javascript">
		var status = document.getElementById("status").value;
		if (status === "success") {
			swal("Congrats", "Insert Image Successfully", "success");
		}
		if (status === "failed") {
			swal("Sorry", "Insert Image Failed", "error");
		}
	</script>
</body>
</html>