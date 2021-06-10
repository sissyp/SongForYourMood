package com.example.myapplication.view.admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.myapplication.App;
import com.example.myapplication.InvalidDataException;
import com.example.myapplication.R;
import com.example.myapplication.databinding.LayoutActivityAddSongBinding;
import com.example.myapplication.util.AndroidUtil;


public class AddSongActivity extends AppCompatActivity implements AddSongView {

    LayoutActivityAddSongBinding binding;
    AddSongPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Add Song");
        binding = DataBindingUtil.setContentView(this, R.layout.layout_activity_add_song);
        presenter = new AddSongPresenter(this, App.memoryInitializer.getSongDAO());
        setClickListeners();
    }

    private void setClickListeners() {
        binding.addSongBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onAddSong();
            }
        });
    }


    @Override
    public void onSuccessfulAddition() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(AddSongActivity.this, AdminActivity.class));
                finish();
            }
        };
        AndroidUtil.showDialog(this,
                "Song Added!",
                "Song title: " + getSongTitle() ,
                "OKAY",
                runnable);
    }

    @Override
    public void showEmptyOrWrongFieldsDetected() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {

            }
        };
        AndroidUtil.showDialog(this,
                "Song addition failed",
                "Empty or wrong fields detected. \nFill them to add the song..",
                "OKAY",
                runnable);
    }

    @Override
    public void showSongAlreadyExists() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {

            }
        };
        AndroidUtil.showDialog(this,
                "Song Addition failed",
                "Song already exists!",
                "OKAY",
                runnable);
    }


    @Override
    public int getId() {
        return Integer.parseInt(String.valueOf(binding.idEt.getText()));
    }

    @Override
    public void setId(int id) {
        binding.idEt.setText(id);
    }

    @Override
    public String getSongTitle(){
        return binding.titleEt.getText().toString();
    }

    @Override
    public void setSongTitle(String title) {
        binding.titleEt.setText(title);
    }

    @Override
    public String getGenre() {
        return binding.genreEt.getText().toString();
    }

    @Override
    public void setGenre(String genre) {
        binding.genreEt.setText(genre);
    }

    @Override
    public int getProductionYear() {
        return Integer.parseInt(binding.productionYearEt.getText().toString());
    }

    @Override
    public void setProductionYear(int productionYear) {
        binding.productionYearEt.setText(productionYear);
    }

    @Override
    public String getBandName() {
        return binding.bandNameEt.getText().toString();
    }

    @Override
    public void setBandName(String bandName) {
        binding.bandNameEt.setText(bandName);
    }

    @Override
    public int getNumberOfBandMembers() {
        return Integer.parseInt(binding.numberOfMembersEt.getText().toString());
    }

    @Override
    public void setNumberOfBandMembers(int numberOfMembers) {
        binding.numberOfMembersEt.setText(numberOfMembers);
    }

    @Override
    public String getBandGenre() {
        return binding.bandGenreEt.getText().toString();
    }

    @Override
    public void setBandGenre(String bandGenre) {
        binding.bandGenreEt.setText(bandGenre);
    }

    @Override
    public String getLink() {
        return binding.linkEt.getText().toString();
    }

    @Override
    public void setLink(String link) {
        binding.linkEt.setText(link);
    }

}
