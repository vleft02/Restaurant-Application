package gr.aueb.softeng.view.Login;

import gr.aueb.softeng.view.View;

public interface LoginView extends View {
    String ExtractUsername();
    String ExtractPassword();
    void signup();
    void showErrorMessage(String title, String message);
}
