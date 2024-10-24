package gr.aueb.softeng.view.SignUp.SignUpOwner;

import java.util.HashMap;

import gr.aueb.softeng.view.SignUp.SignUpOwner.SignUpOwnerView;

public class SignUpOwnerViewStub implements SignUpOwnerView {
    private String name, surname,  username,  telephone, email,iban,tin,password;
    private String errorTitle, errorMessage, successMessage;
    private int errorCount, goBackIsPressed;

    public SignUpOwnerViewStub()
    {
        name = surname = username  = telephone = email = iban = tin = password = errorTitle = errorMessage= successMessage = "";
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

    public void setIban(String iban) {
        this.iban = iban;
    }

    public void setTin(String tin) {
        this.tin = tin;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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

    @Override
    public HashMap<String, String> getOwnerDetails() {
        HashMap<String,String> details = new HashMap<>();
        details.put("name",name);
        details.put("surname",surname);
        details.put("username",username);
        details.put("email",email);
        details.put("telephone",telephone);
        details.put("iban",iban);
        details.put("tin",tin);
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
        successMessage = "Account Created Successfully";
    }
}
