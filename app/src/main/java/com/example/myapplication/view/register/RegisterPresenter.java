package com.example.myapplication.view.register;

import com.example.myapplication.domain.User;
import com.example.myapplication.memorydao.UserDAO;
import com.example.myapplication.util.PasswordProtector;
import com.example.myapplication.util.UserInfoUtil;

public class RegisterPresenter {
    RegisterView view;
    UserDAO userDAO;

    public RegisterPresenter(RegisterView view, UserDAO userDAO) {
        this.view = view;
        this.userDAO = userDAO;
    }

    public void onRegister() {
        if (view.getEmail().isEmpty() || view.getUsername().isEmpty() || view.getPassword().isEmpty() || view.getFirstName().isEmpty() || view.getLastName().isEmpty()) {
            view.showEmptyFieldsDetected();
            return;
        }

        if (!UserInfoUtil.isEmail(view.getEmail())) {
            view.showInvalidEmail();
            return;
        }

        if (userDAO.isEmailTaken(view.getEmail())) {
            view.showEmailAlreadyExists();
            return;
        }

        String encryptedPassword = PasswordProtector.md5(view.getPassword());
        User user = new User(view.getFirstName(),view.getLastName(), view.getEmail(),view.getUsername(),encryptedPassword,view.getGenrePreference(),view.getBandPreference());

        userDAO.register(user);
        view.onSuccessfulRegister();
    }

    void detach() {
        view = null;
    }
}
