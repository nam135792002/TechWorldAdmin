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

function validateEmail(email) {
    // Regular expression for email validation
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return emailRegex.test(email);
}

function validatePhoneNumber(phoneNumber) {
    // Regular expression for phone number validation
    const phoneNumberRegex = /^(?:\+?84|0)(?:\d{9}|\d{10})$/;
    return phoneNumberRegex.test(phoneNumber);
}

function validateForm() {
    var fullName = document.getElementById('fullName');
    var userName = document.getElementById('userName');
    var email = document.getElementById('email');
    var phoneNumber = document.getElementById('phoneNumber');
    var passWord = document.getElementById('passWord');
    var repeatPassWord = document.getElementById('repeatPassWord');
    var optionRole = document.getElementById('optionRole');

    let isValid = true;

    // Clear previous error messages
    const errorMessages = document.querySelectorAll('.error-message');
    errorMessages.forEach((errorMessage) => {
        errorMessage.textContent = '';
    });

    // Add event listeners to remove 'invalid' class and clear error messages when user starts typing
    optionRole.addEventListener('input', function () {
        removeError(optionRole);
    });

    fullName.addEventListener('input', function () {
        removeError(fullName);
    });

    userName.addEventListener('input', function () {
        removeError(userName);
    });

    email.addEventListener('input', function () {
        removeError(email);
    });

    phoneNumber.addEventListener('input', function () {
        removeError(phoneNumber);
    });

    passWord.addEventListener('input', function () {
        removeError(passWord);
    });

    repeatPassWord.addEventListener('input', function () {
        removeError(repeatPassWord);
    });

    if (fullName.value.trim() === '') {
        displayError(fullName, 'Fullname cannot be empty');
        isValid = false;
    }

    if (userName.value.trim() === '') {
        displayError(userName, 'Username cannot be empty');
        isValid = false;
    }

    if (email.value.trim() === '') {
        displayError(email, 'Email cannot be empty');
        isValid = false;
    } else if (!validateEmail(email.value)) {
        displayError(email, 'Invalid email format');
        isValid = false;
    }

    if (phoneNumber.value.trim() === '') {
        displayError(phoneNumber, 'Phone number cannot be empty');
        isValid = false;
    } else if (!validatePhoneNumber(phoneNumber.value)) {
        displayError(phoneNumber, 'Invalid phone number');
        isValid = false;
    }

    if (passWord.value.trim() === '') {
        displayError(passWord, 'Password cannot be empty');
        isValid = false;
    }

    if (repeatPassWord.value.trim() === '') {
        displayError(repeatPassWord, 'Please confirm your password');
        isValid = false;
    } else if (passWord.value !== repeatPassWord.value) {
        displayError(repeatPassWord, 'Passwords do not match');
        isValid = false;
    }

    if (optionRole.value.trim() === '') {
        displayError(optionRole, 'Please select role');
        isValid = false;
    }

    return isValid;
}
