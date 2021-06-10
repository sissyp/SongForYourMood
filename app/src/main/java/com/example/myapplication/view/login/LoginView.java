package com.example.myapplication.view.login;

interface LoginView {
    void onSuccessfulLogin();

    void onCreateAnAccount();

    String getEmail();

    void setEmail(String email);

    String getPassword();

    void setPassword(String password);

    void setToolbarTitle(String title);

    void showEmptyFieldsDetected();

    void showFailedLogin();

    void showSuccessLogin();

    void showInvalidEmail();

    void showAdminLogin();

    void onAdminLogin();
}
