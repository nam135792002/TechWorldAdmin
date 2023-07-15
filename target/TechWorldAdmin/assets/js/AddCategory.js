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

function validateForm() {
    var name = document.getElementById('name');

    let isValid = true;

    // Clear previous error messages
    const errorMessages = document.querySelectorAll('.error-message');
    errorMessages.forEach((errorMessage) => {
        errorMessage.textContent = '';
    });

    // Add event listeners to remove 'invalid' class and clear error messages when user starts typing
    name.addEventListener('input', function () {
        removeError(name);
    });

    if (name.value.trim() === '') {
        displayError(name, 'Category\'s name cannot be empty');
        isValid = false;
    }

    return isValid;
}