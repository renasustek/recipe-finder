//Let's define some variables to represent the form data
//At the beginning, the form is empty, and therefore, not valid

//Data to send
var formData = {
    username: "",
    email: "",
    password: "",
    buyer: false,
    seller: false
}

//This data would not be sent
var formValid = false;
var repPassword = "";
var tosCheckBox = false;

//Function to read the form
function readForm() {
    //ToDo: This function should read the form inputs, and assign their
    //values to the variables defined above; 
    //See Lecture slides on JS inputs
    //You can get elements by ID: https://developer.mozilla.org/en-US/docs/Web/API/Document/getElementById
    //You can get elements by tag name: https://developer.mozilla.org/en-US/docs/Web/API/Document/getElementsByTagName 
    //Read username, email, password, repPassword, and tosCheckBox fields

    //Read the buyer and seller checkboxes 
    var buyerCheckBox = document.getElementById("buyer");
    if (buyerCheckBox.checked)
        formData.buyer = true;

    var sellerCheckBox = document.getElementById("seller");
    if (sellerCheckBox.checked)
        formData.seller = true;
}

//Function to validate the form
function validateForm() {
    formValid = false;
    //ToDo: Fill in the conditions to check the validity of the form.
    //For example, you need to check if any of the text fields are empty
    //You can also follow HTML5 validation here: https://developer.mozilla.org/en-US/docs/Learn/Forms/Form_validation
    //and see if you can use the validity field - for example, username.validity 
    //to check if the form input is valid
    if (false) {/*ToDo: Add the correct condition to check no text field is empty*/
        alert("Please fill in all text fields.");
    } else if (false) {/*ToDo: Add the correct condition to check email is of correct form*/
        alert("Invalid e-mail address. Please enter your e-mail again.");
    } else if (false) {/*ToDo: Add the correct password condition*/
        alert("Password is too short. Please select another password");
    } else if (false) {/*ToDo: Check if passwords match*/
        alert("Passwords do not match. Please retry");
    } else if (!formData.buyer && !formData.seller) {
        alert("Please check at least one checkbox to be a seller or a buyer.")
    } else if (false) { /*ToDo: Add Condition to check Term and Conditions checked*/
        alert("Please agree to the Terms and Conditions, and Privacy Policy.")
    } else {
        formValid = true;
    }
}

//Function to write the Registration success on the page
function createNewParagraph(content) {
    var text = document.createTextNode(content);
    var paragraph = document.createElement("p");
    paragraph.appendChild(text);

    var element = document.getElementById("hiddenSection");
    element.appendChild(paragraph);
}

//Function  to submit the form, this should be called by the Register button
//on click
function submitForm() {
    readForm();
    validateForm();
    if (formValid) {
        var formText = formData.username + " registered as:\n"
            + formData.buyer ? "- buyer\n" : ""
                + formData.seller ? "-seller" : "";

        createNewParagraph(formText);
    }
}
