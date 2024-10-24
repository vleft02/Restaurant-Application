package gr.aueb.softeng.view.Login;

public class LoginViewStub implements LoginView{

    private String errorTitle,errorMessage,username,password,successMessage;
    private int signUpPressed, signUpPersonelPressed, signUpOwnerPressed, errorCount;

    public LoginViewStub()
    {
        errorTitle = errorMessage = username = password = successMessage = "";
        signUpPressed = signUpPersonelPressed = signUpOwnerPressed = errorCount = 0;
    }
    public void setUsername(String userName){
        this.username = userName;
    }
    public void setPassword(String passWord)
    {
        this.password = passWord;
    }

    public int getErrorCount() {
        return errorCount;
    }

    public int getSignUpPressed() {
        return signUpPressed;
    }
    public int getSignUpPersonelPressed()
    {
        return signUpPersonelPressed;
    }
    public int getSignUpOwnerPressed()
    {
        return signUpOwnerPressed;
    }
    public String getErrorTitle()
    {
        return errorTitle;
    }
    public String getErrorMessage()
    {
        return errorMessage;
    }
    public String getSuccessMessage()
    {
        return successMessage;
    }

    @Override
    public String ExtractUsername() {
        return username;
    }

    @Override
    public String ExtractPassword() {
        return password;
    }

    @Override
    public void showCustomerFoundMessage(int id) {
        successMessage = "Redirecting to Customer with id: " + id;
    }

    @Override
    public void showChefFoundMessage(int id) {
        successMessage = "Redirecting to Chef with id: " + id;
    }

    @Override
    public void showOwnerFoundMessage(int id) {
        successMessage = "Redirecting to Owner with id: " + id;
    }

    @Override
    public void signup() {
        signUpPressed++;
    }

    @Override
    public void signupPersonel() {
        signUpPersonelPressed++;
    }

    @Override
    public void signupOwner() {
        signUpOwnerPressed++;
    }

    @Override
    public void showErrorMessage(String title, String message) {
        errorTitle = title;
        errorMessage = message;
        errorCount++;
    }

}
