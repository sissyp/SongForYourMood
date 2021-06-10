package com.example.myapplication.view.register;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.myapplication.App;
import com.example.myapplication.R;
import com.example.myapplication.databinding.LayoutActivityRegisterBinding;
import com.example.myapplication.domain.BandPreference;
import com.example.myapplication.domain.GenrePreference;
import com.example.myapplication.util.AndroidUtil;
import com.example.myapplication.view.favouriteBands.favouriteBandsActivity;
import com.example.myapplication.view.login.LoginActivity;
import com.example.myapplication.view.menu.MenuActivity;

public class RegisterActivity extends AppCompatActivity implements RegisterView{

    LayoutActivityRegisterBinding binding;
    RegisterPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Register");
        binding = DataBindingUtil.setContentView(this, R.layout.layout_activity_register);
        presenter = new RegisterPresenter(this, App.memoryInitializer.getUserDAO());
        setClickListeners();
    }

    private void setClickListeners() {
        binding.signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onRegister();
            }
        });
    }

    @Override
    public void onSuccessfulRegister() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(RegisterActivity.this, favouriteBandsActivity.class));
                finish();
            }
        };
        AndroidUtil.showDialog(this,
                "Register successfully",
                "Congratulations " + getUsername() + ",\nYou can now use the app",
                "OKAY",
                runnable);
    }

    @Override
    public String getEmail() {
        return binding.emailEt.getText().toString();
    }

    @Override
    public void setEmail(String email) {
        binding.emailEt.setText(email);
    }

    @Override
    public String getUsername() {
        return binding.usernameEt.getText().toString();
    }

    @Override
    public void setUsername(String username) {
        binding.usernameEt.setText(username);
    }

    @Override
    public String getPassword() {
        return binding.passwordEt.getText().toString();
    }

    @Override
    public void setPassword(String password) {
        binding.passwordEt.setText(password);
    }

    @Override
    public String getFirstName() {
        return binding.firstnameEt.getText().toString();
    }

    @Override
    public void setFirstName(String firstName) {
        binding.firstnameEt.setText(firstName);
    }

    @Override
    public String getLastName() {
        return binding.lastnameEt.getText().toString();
    }

    @Override
    public void setLastName(String lastName) {
        binding.lastnameEt.setText(lastName);
    }

    @Override
    public GenrePreference getGenrePreference() {
        return null;
    }

    @Override
    public void setGenrePreference(GenrePreference genrePreference) {

    }

    @Override
    public BandPreference getBandPreference() {
        return null;
    }

    @Override
    public void setBandPreference(BandPreference bandPreference) {

    }


    @Override
    public void showEmptyFieldsDetected() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {

            }
        };
        AndroidUtil.showDialog(this,
                "Register failed",
                "Empty fields detected. \nFill them to register..",
                "OKAY",
                runnable);
    }

    @Override
    public void showEmailAlreadyExists() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {

            }
        };
        AndroidUtil.showDialog(this,
                "Register failed",
                "Email is taken. In case of forgetting your password contact with our team",
                "OKAY",
                runnable);
    }

    @Override
    public void showInvalidEmail() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {

            }
        };
        AndroidUtil.showDialog(this,
                "Invalid Email",
                "Invalid email detected. Please use your email",
                "OKAY",
                runnable);
    }
}
