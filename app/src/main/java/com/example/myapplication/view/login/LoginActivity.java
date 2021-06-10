package com.example.myapplication.view.login;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import com.example.myapplication.App;
import com.example.myapplication.R;
import com.example.myapplication.databinding.LayoutActivityLoginBinding;
import com.example.myapplication.util.AndroidUtil;
import com.example.myapplication.view.admin.AdminActivity;
import com.example.myapplication.view.menu.MenuActivity;
import com.example.myapplication.view.register.RegisterActivity;


public class LoginActivity extends AppCompatActivity implements LoginView{
    LayoutActivityLoginBinding binding;
    LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setToolbarTitle("Log in");
        binding = DataBindingUtil.setContentView(this, R.layout.layout_activity_login);

        presenter = new LoginPresenter(this, App.memoryInitializer.getUserDAO());

        setUpClickListeners();
    }

    private void setUpClickListeners() {
        binding.signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onLogin();
            }
        });

        binding.createAccountTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onCreateAnAccount();
            }
        });
    }

    @Override
    public void onSuccessfulLogin() {
        startActivity(new Intent(LoginActivity.this, MenuActivity.class));
        finish();
    }

    @Override
    public void onCreateAnAccount() {
        startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
    }

    @Override
    public void onAdminLogin() {
        startActivity(new Intent(LoginActivity.this, AdminActivity.class));
        finish();
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
    public String getPassword() {
        return binding.passwordEt.getText().toString();
    }

    @Override
    public void setPassword(String password) {
        binding.passwordEt.setText(password);
    }


    @Override
    public void setToolbarTitle(String title) {
        setTitle(title);
    }

    @Override
    public void showEmptyFieldsDetected() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
            }
        };
        AndroidUtil.showDialog(this,
                "Empty fields",
                "Please insert email and password to login",
                "OKAY",
                runnable);
    }

    @Override
    public void showFailedLogin() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
            }
        };
        AndroidUtil.showDialog(this,
                "Couldn't login",
                "Wrong username or password. \nPlease try again",
                "OKAY",
                runnable);
    }

    @Override
    public void showSuccessLogin() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(LoginActivity.this, MenuActivity.class));
                finish();
            }
        };
        AndroidUtil.showDialog(this,
                "Successful login",
                "Welcome back !",
                "Enter the app",
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
                "Invalid email",
                "Email is not valid",
                "OKAY",
                runnable);
    }

    @Override
    public void showAdminLogin() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(LoginActivity.this, AdminActivity.class));
                finish();
            }
        };
        AndroidUtil.showDialog(this,
                "Successful login",
                "Welcome back admin!",
                "Enter the app",
                runnable);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detach();
    }
}
