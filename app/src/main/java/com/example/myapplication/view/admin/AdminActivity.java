package com.example.myapplication.view.admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.myapplication.R;
import com.example.myapplication.databinding.LayoutAdminActionsBinding;

public class AdminActivity extends AppCompatActivity implements AdminView {

    LayoutAdminActionsBinding binding;
    AdminPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Menu");
        binding = DataBindingUtil.setContentView(this, R.layout.layout_admin_actions);
        presenter = new AdminPresenter(this);

        setClickListeners();
    }

    private void setClickListeners() {

        binding.addSongBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onClickAddSong();
            }
        });

        binding.removeSongBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onClickRemoveSong();
            }
        });
    }

    @Override
    public void handleAddSong() {
        startActivity(new Intent(AdminActivity.this, AddSongActivity.class));
    }

    @Override
    public void handleRemoveSong() {
        startActivity(new Intent(AdminActivity.this, RemoveSongActivity.class));
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detach();
    }
}
