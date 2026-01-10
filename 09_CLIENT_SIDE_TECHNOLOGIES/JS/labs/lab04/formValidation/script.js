var form = document.getElementById("form");
var nameInput = document.getElementById("name");
var nameError = nameInput.nextElementSibling;
var isvalidAge ;
var isvalidEmail ;
var isvalidName ;
nameInput.addEventListener("change", function() {  
    if (!nameInput.value) {
        isvalidName = false;
        nameError.textContent = "Name is required!";
    } else if (/\d/.test(nameInput.value)) { 
        isvalidName = false;
        nameError.textContent = "No numbers allowed!";
        nameInput.value= "";
    } else {
        nameError.textContent = "";  
        isvalidName = true
    }
})
var ageInput = document.getElementById("age");
var ageError = ageInput.nextElementSibling;
ageInput.addEventListener("change",function() {
    if(!ageInput.value) {
        isvalidAge = false;
        ageError.textContent = "Age is required!";
    } else if(!isFinite(ageInput.value)) {
        isvalidAge = false;
        ageError.textContent = "No Letters allowed!";
        ageInput.value= "";
    } else {
        ageError.textContent = "";
        isvalidAge = true;
    }
})

var emailInput = document.getElementById("email");
var emailError = emailInput.nextElementSibling;
emailInput.addEventListener("change", function() {
    if (!emailInput.value) {
        isvalidEmail = false;
        emailError.textContent = "Email is required!";
    } else if (!/^[\w.-]+@[\w.-]+\.\w+$/.test(emailInput.value)) {
        isvalidEmail = false;
        emailError.textContent = "Invalid email format!";
        emailInput.value = "";
    } else {
        emailError.textContent = "";
        isvalidEmail = true;
    }
})

form.addEventListener("submit", function(e){
    if (!nameInput.value) {
        nameError.textContent = "Name is required!";
        isvalidName = false;
    }
    if (!ageInput.value) {
        ageError.textContent = "Age is required!";
        isvalidAge = false;
    }
    if (!emailInput.value) {
        emailError.textContent = "Email is required!";
        isvalidEmail = false;
    }
    
    if(!isvalidEmail || !isvalidName || !isvalidAge) {
        e.preventDefault();
    }
})