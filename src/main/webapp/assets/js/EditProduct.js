function validateFormAvatar(){
	var avatarImage = document.getElementById('avatarImage');
	let isValid = true;
	const errorMessages = document.querySelectorAll('.error-message');
	  errorMessages.forEach((errorMessage) => {
	      errorMessage.textContent = '';
	  });
	  avatarImage.addEventListener('input', function () {
	      removeErrorImage(avatarImage);
	  });
	  if (avatarImage.files.length === 0) {
	      displayError(avatarImage, 'Please select image');
	      isValid = false;
	  }
	  return isValid;
}

function validateFormRelate(){
	var imageMultiple = document.getElementById('file-input');
	let isValid = true;
	const errorMessages = document.querySelectorAll('.error-message');
	  errorMessages.forEach((errorMessage) => {
	      errorMessage.textContent = '';
	  });
	  imageMultiple.addEventListener('input', function () {
	      removeErrorImage(imageMultiple);
	  });
	  if (imageMultiple.files.length === 0) {
	      displayError(imageMultiple, 'Please select image');
	      isValid = false;
	  }
	  return isValid;
}