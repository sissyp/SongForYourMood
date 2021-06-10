package com.example.myapplication.view.login;

import com.example.myapplication.domain.ManagementUser;
import com.example.myapplication.domain.User;
import com.example.myapplication.memorydao.UserDAO;
import com.example.myapplication.util.PasswordProtector;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class LoginPresenterTest {

    private LoginView loginView;
    private UserDAO userDAO;
    private LoginPresenter presenterUnderTest;

    @Before
    public void setUp() throws Exception {
        loginView = mock(LoginView.class);
        userDAO = mock(UserDAO.class);
        presenterUnderTest = new LoginPresenter(loginView, userDAO);
    }

    @Test
    public void onLoginCallShowEmptyFieldsDetected() {
        when(loginView.getEmail()).thenReturn("");
        presenterUnderTest.onLogin();
        verify(loginView).showEmptyFieldsDetected();
    }

    @Test
    public void onLoginCallShowInvalidEmail() {
        User user = new User("john","smith","johnsmithgmail.com","johny","123",null,null);
        when(loginView.getEmail()).thenReturn(user.getMail());
        when(loginView.getPassword()).thenReturn(user.getPassword());

        presenterUnderTest.onLogin();
        verify(loginView).showInvalidEmail();
    }

    @Test
    public void onLoginCallShowAdminLogin() {
        ManagementUser user = new ManagementUser("johnsmith@gmail.com","johny","123","nice person",1);
        when(loginView.getEmail()).thenReturn(user.getMail());
        when(loginView.getPassword()).thenReturn(user.getPassword());
        when(userDAO.getUserFromCredentials(loginView.getEmail(), PasswordProtector.md5(loginView.getPassword()))).thenReturn(user);

        presenterUnderTest.onLogin();
        verify(loginView).showAdminLogin();
    }

    @Test
    public void onLoginCallShowFailedLogin() {
        User user = new User("john","smith","johnsmith@gmail.com","johny","123",null,null);
        when(loginView.getEmail()).thenReturn(user.getMail());
        when(loginView.getPassword()).thenReturn(user.getPassword());
        when(userDAO.getUserFromCredentials("wrong_user", "123")).thenReturn(user);

        presenterUnderTest.onLogin();
        verify(loginView).showFailedLogin();

    }

    @Test
    public void onLoginCallShowSuccessLogin() {
        User user = new User("john","smith","johnsmith@gmail.com","johny","123",null,null);
        when(loginView.getEmail()).thenReturn(user.getMail());
        when(loginView.getPassword()).thenReturn(user.getPassword());
        when(userDAO.getUserFromCredentials(loginView.getEmail(), PasswordProtector.md5(loginView.getPassword()))).thenReturn(user);

        presenterUnderTest.onLogin();
        verify(loginView).showSuccessLogin();
    }

    @Test
    public void onCreateAnAccount() {
    }

    @Test
    public void detach() {
    }
}