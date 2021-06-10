package com.example.myapplication.view.login;

import com.example.myapplication.domain.ManagementUser;
import com.example.myapplication.domain.User;
import com.example.myapplication.memorydao.UserDAO;
import com.example.myapplication.util.PasswordProtector;
import com.example.myapplication.util.UserInfoUtil;

public class LoginPresenter {
    LoginView view;
    UserDAO userDAO;


    public LoginPresenter(LoginView view, UserDAO userDAO) {
        this.view = view;
        this.userDAO = userDAO;
    }

    void onLogin() {
        if (view.getEmail().isEmpty() || view.getPassword().isEmpty()) {
            view.showEmptyFieldsDetected();
            return;
        }

        if (!UserInfoUtil.isEmail(view.getEmail())) {
            view.showInvalidEmail();
            return;
        }

        String encryptedPassword = PasswordProtector.md5(view.getPassword());
        User user = userDAO.getUserFromCredentials(view.getEmail(), encryptedPassword);

        if(user instanceof ManagementUser) {
            view.showAdminLogin();
        }
        else if (user == null) {
            view.showFailedLogin();
        } else  {
            view.showSuccessLogin();
        }

    }

    void onCreateAnAccount() {
        view.onCreateAnAccount();
    }

    void detach() {
        view = null;
    }

}
