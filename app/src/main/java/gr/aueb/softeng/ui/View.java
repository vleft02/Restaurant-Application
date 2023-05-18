package gr.aueb.softeng.ui;

public interface View {
    void open();

    void close();

    void showError(String message);

    void showInfo(String message);
}
