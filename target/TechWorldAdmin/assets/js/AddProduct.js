let fileInput = document.getElementById("file-input");
let imageContainer = document.getElementById("images");
let numOfFiles = document.getElementById("num-of-files");

function preview(){
    imageContainer.innerHTML = "";
    numOfFiles.textContent = `${fileInput.files.length} Files Selected`;

    for(i of fileInput.files){
        let reader = new FileReader();
        let figure = document.createElement("figure");
        let figCap = document.createElement("figcaption");
        figCap.innerText = i.name;
        figure.appendChild(figCap);
        reader.onload=()=>{
            let img = document.createElement("img");
            img.setAttribute("src",reader.result);
            figure.insertBefore(img,figCap);
        }
        imageContainer.appendChild(figure);
        reader.readAsDataURL(i);
    }
}

let avatarInput = document.getElementById("avatarImage");
let avatarContainer = document.getElementById("one-image");
let numOfAvatarFiles = document.getElementById("one-files");

avatarInput.addEventListener("change", function() {
  avatarContainer.innerHTML = "";
  numOfAvatarFiles.textContent = "1 File Selected";

  if (avatarInput.files && avatarInput.files[0]) {
    let reader = new FileReader();
    let figure = document.createElement("figure");
    let figCap = document.createElement("figcaption");
    figCap.innerText = avatarInput.files[0].name;
    figure.appendChild(figCap);

    reader.onload = function() {
      let img = document.createElement("img");
      img.setAttribute("src", reader.result);
      figure.insertBefore(img, figCap);
    };

    avatarContainer.appendChild(figure);
    reader.readAsDataURL(avatarInput.files[0]);
  }
});

function displayError(inputField, errorMessage) {
  inputField.classList.add('invalid');
  const errorElement = inputField.nextElementSibling;
  if (errorElement) {
      errorElement.textContent = errorMessage;
  }
}

function removeError(inputField) {
  inputField.classList.remove('invalid');
  const errorElement = inputField.nextElementSibling;
  if (errorElement) {
      errorElement.textContent = '';
  }
}

function removeErrorImage(inputField) {
  inputField.classList.remove('invalid');
  const errorElement = inputField.nextElementSibling;
  if (errorElement && inputField.files.length > 0) {
    errorElement.textContent = '';
  }
}

function validateForm() {
  var nameProduct = document.getElementById('nameProduct');
  var unitPrice = document.getElementById('unitPrice');
  var optionProduct = document.getElementById('optionProduct');
  var quantityProduct = document.getElementById('quantityProduct');
  var descriptionProduct = document.getElementById('descriptionProduct');
  var avatarImage = document.getElementById('avatarImage');
  var imageMultiple = document.getElementById('file-input');

  let isValid = true;

  // Clear previous error messages
  const errorMessages = document.querySelectorAll('.error-message');
  errorMessages.forEach((errorMessage) => {
      errorMessage.textContent = '';
  });

  // Add event listeners to remove 'invalid' class and clear error messages when user starts typing
  nameProduct.addEventListener('input', function () {
      removeError(nameProduct);
  });
  unitPrice.addEventListener('input', function () {
      removeError(unitPrice);
  });
  optionProduct.addEventListener('input', function () {
      removeError(optionProduct);
  });
  quantityProduct.addEventListener('input', function () {
      removeError(quantityProduct);
  });
  descriptionProduct.addEventListener('input', function () {
      removeError(descriptionProduct);
  });
  avatarImage.addEventListener('input', function () {
      removeErrorImage(avatarImage);
  });
  imageMultiple.addEventListener('input', function () {
      removeErrorImage(imageMultiple);
  });

  if (nameProduct.value.trim() === '') {
      displayError(nameProduct, 'Product\'s name cannot be empty');
      isValid = false;
  }
  if (unitPrice.value.trim() === '') {
      displayError(unitPrice, 'Product\'s unit price cannot be empty');
      isValid = false;
  }else if (!/^[1-9]\d*$/.test(unitPrice.value.trim())) {
    displayError(unitPrice, 'Unit price must be a positive integer');
    isValid = false;
  }
  if (optionProduct.value.trim() === '') {
      displayError(optionProduct, 'Please select category');
      isValid = false;
  }
  if (quantityProduct.value.trim() === '') {
      displayError(quantityProduct, 'Product\'s quantity cannot be empty');
      isValid = false;
  }else if (!/^[1-9]\d*$/.test(quantityProduct.value.trim())) {
    displayError(quantityProduct, 'Quantity must be a positive integer');
    isValid = false;
  }
  if (descriptionProduct.value.trim() === '') {
      displayError(descriptionProduct, 'Product\'s description cannot be empty');
      isValid = false;
  }
  if (avatarImage.files.length === 0) {
      displayError(avatarImage, 'Please select image');
      isValid = false;
  }
  if (imageMultiple.files.length === 0) {
      displayError(imageMultiple, 'Please select image');
      isValid = false;
  }

  return isValid;
}