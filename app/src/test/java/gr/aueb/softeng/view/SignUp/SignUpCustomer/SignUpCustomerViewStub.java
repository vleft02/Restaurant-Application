package gr.aueb.softeng.view.SignUp.SignUpCustomer;

import java.util.HashMap;

public class SignUpCustomerViewStub implements SignUpCustomerView{

    private String name, surname,  username,  telephone, email,cardNumber,  cardHolderName, cvv, password;
    private String errorTitle, errorMessage, successMessage;
    private int errorCount, goBackIsPressed;

    public String getErrorTitle() {
        return errorTitle;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String getSuccessMessage() {
        return successMessage;
    }

    public int getErrorCount() {
        return errorCount;
    }

    public int getGoBackIsPressed() {
        return goBackIsPressed;
    }


    public SignUpCustomerViewStub()
    {
        name = surname = username = telephone = email = cardNumber =  cardHolderName = cvv = password = errorTitle = errorMessage = successMessage = "";
        errorCount = goBackIsPressed = 0;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public HashMap<String, String> getDetails() {
        HashMap<String,String> details = new HashMap<>();
        details.put("name",name);
        details.put("surname",surname);
        details.put("username",username);
        details.put("email",email);
        details.put("telephone",telephone);
        details.put("cardNumber",cardNumber);
        details.put("cardHolderName",cardHolderName);
        details.put("cvv",cvv);
        details.put("password",password);
        return details;
    }

    @Override
    public void showErrorMessage(String title, String message) {
        errorCount++;
        errorTitle = title;
        errorMessage = message;
    }

    @Override
    public void goBack() {
        goBackIsPressed++;
    }

    @Override
    public void showAccountCreatedMessage() {
        successMessage = "Account created successfully";
    }
}
