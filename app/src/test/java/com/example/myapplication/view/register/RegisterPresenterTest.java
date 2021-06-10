package com.example.myapplication.view.register;

import com.example.myapplication.domain.User;
import com.example.myapplication.memorydao.UserDAO;
import com.example.myapplication.util.PasswordProtector;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class RegisterPresenterTest {

    private RegisterView registerView;
    private UserDAO userDAO;
    private RegisterPresenter presenterUnderTest;

    @Before
    public void setUp() throws Exception {
        registerView = mock(RegisterView.class);
        userDAO = mock(UserDAO.class);
        presenterUnderTest = new RegisterPresenter(registerView, userDAO);
    }

    @Test
    public void onLoginCallShowEmptyFieldsDetected() {
        when(registerView.getEmail()).thenReturn("");
        presenterUnderTest.onRegister();
        verify(registerView).showEmptyFieldsDetected();
    }

    @Test
    public void onLoginCallShowInvalidEmail() {
        User user = new User("john","smith","johnsmithgmail.com","johny","123",null,null);
        when(registerView.getEmail()).thenReturn(user.getMail());
        when(registerView.getPassword()).thenReturn(user.getPassword());
        when(registerView.getFirstName()).thenReturn(user.getFirstName());
        when(registerView.getLastName()).thenReturn(user.getLastName());
        when(registerView.getUsername()).thenReturn(user.getUserName());

        presenterUnderTest.onRegister();
        verify(registerView).showInvalidEmail();
    }

    @Test
    public void onLoginCallEmailAlreadyExists() {
        User user = new User("john","smith","johnsmith@gmail.com","johny","123",null,null);
        userDAO.register(user);

        User user2 = new User("john","smith","johnsmith@gmail.com","johny","123",null,null);
        when(registerView.getEmail()).thenReturn(user2.getMail());
        when(registerView.getPassword()).thenReturn(user2.getPassword());
        when(registerView.getFirstName()).thenReturn(user2.getFirstName());
        when(registerView.getLastName()).thenReturn(user2.getLastName());
        when(registerView.getUsername()).thenReturn(user2.getUserName());
        when(userDAO.isEmailTaken("johnsmith@gmail.com")).thenReturn(true);

        presenterUnderTest.onRegister();
        verify(registerView).showEmailAlreadyExists();
    }


    @Test
    public void onLoginCallOnSuccessfulRegister() {
        User user = new User("john","smith","johnsmith@gmail.com","johny","123",null,null);
        when(registerView.getEmail()).thenReturn(user.getMail());
        when(registerView.getPassword()).thenReturn(user.getPassword());
        when(registerView.getFirstName()).thenReturn(user.getFirstName());
        when(registerView.getLastName()).thenReturn(user.getLastName());
        when(registerView.getUsername()).thenReturn(user.getUserName());
        when(userDAO.getUserFromCredentials(registerView.getEmail(), PasswordProtector.md5(registerView.getPassword()))).thenReturn(user);

        presenterUnderTest.onRegister();
        verify(registerView).onSuccessfulRegister();
    }

    @Test
    public void detach() {
    }
}