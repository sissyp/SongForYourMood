package com.example.myapplication.view.favouriteBands;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.myapplication.App;
import com.example.myapplication.R;
import com.example.myapplication.databinding.LayoutActivityFavouriteBandsBinding;
import com.example.myapplication.domain.Band;
import com.example.myapplication.util.AndroidUtil;
import com.example.myapplication.view.songRating.MoodRatingActivity;


import java.util.List;

public class favouriteBandsActivity extends AppCompatActivity implements favouriteBandsView {

    LayoutActivityFavouriteBandsBinding binding;
    favouriteBandsPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.layout_activity_favourite_bands);
        presenter = new favouriteBandsPresenter(this, App.memoryInitializer.getSongDAO());

        setUpRecyclerView();
        setClickListeners();
    }

    private void setClickListeners() {
        binding.continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onProcessCompleted();
            }
        });
    }

    @Override
    public void showEmptyOrWrongFieldsDetected() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {

            }
        };
        AndroidUtil.showDialog(this,
                "Action failed!",
                "Looks like you forgot to complete all fields or you didn't choose one of the bands given ",
                "GOT IT",
                runnable);
    }

    @Override
    public void onSuccessfullyCompletedProcess(final String band1, final String band2) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(favouriteBandsActivity.this, MoodRatingActivity.class);
                intent.putExtra("element1", band1);
                intent.putExtra("element2", band2);
                intent.putExtra("counter",1);

                startActivity(intent);
                finish();
            }
        };
        AndroidUtil.showDialog(this,
                "Well done",
                "Let's proceed to the next step!" ,
                "OKAY",
                runnable);
    }

    private void setUpRecyclerView() {
        binding.bandRv.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.loadAllBands();
    }

    @Override
    public void onFetchBands(List<Band> bandList) {
        binding.bandRv.setAdapter(new favouriteBandsListAdapter(bandList, this));
    }

    @Override
    public String getBandTitle1(){
        return binding.band1Et.getText().toString();
    }

    @Override
    public String getBandTitle2(){
        return binding.band2Et.getText().toString();
    }

    @Override
    public void setBandTitle1(String title) {
        binding.band1Et.setText(title);
    }

    @Override
    public void setBandTitle2(String title) {
        binding.band2Et.setText(title);
    }
}
