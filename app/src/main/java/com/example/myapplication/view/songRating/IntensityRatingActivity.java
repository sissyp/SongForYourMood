package com.example.myapplication.view.songRating;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.myapplication.App;
import com.example.myapplication.InvalidDataException;
import com.example.myapplication.R;
import com.example.myapplication.databinding.LayoutActivityIntensityRatingBinding;
import com.example.myapplication.view.favouriteGenres.favouriteGenresActivity;
import com.example.myapplication.view.menu.MenuActivity;

public class IntensityRatingActivity extends AppCompatActivity implements IntensityRatingView{

    LayoutActivityIntensityRatingBinding binding;
    IntensityRatingPresenter presenter;
    String element1;
    String element2;
    int counter;
    int counter1;
    String song;
    String mood;
    String activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Intensity Question");
        binding = DataBindingUtil.setContentView(this, R.layout.layout_activity_intensity_rating);
        presenter = new IntensityRatingPresenter(this, App.memoryInitializer.getSongDAO(),App.memoryInitializer.getSongRatingDAO());
        Bundle extras = getIntent().getExtras();
        counter = extras.getInt("counter");
        mood = extras.getString("mood");
        activity = extras.getString("activity");
        song = extras.getString("song");
        element1 = extras.getString("element1");
        element2 = extras.getString("element2");
        String text = "           \n         You are currently rating: " + song +"\n         Pick an intensity for this one";
        binding.textView.setText(text);

        setClickListeners();
    }

    private void setClickListeners() {
        binding.lowBtn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                try {
                    presenter.onClickIntensityRating("low",song,mood,activity);
                } catch (InvalidDataException e) {
                    e.printStackTrace();
                }

            }

        });

        binding.mediumBtn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                try {
                    presenter.onClickIntensityRating("medium",song,mood,activity);
                } catch (InvalidDataException e) {
                    e.printStackTrace();
                }

            }
        });

        binding.highBtn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                try {
                    presenter.onClickIntensityRating("high",song,mood,activity);
                } catch (InvalidDataException e) {
                    e.printStackTrace();
                }

            }
        });
    }


    @Override
    public void handleIntensityRating() {
        if (counter == 1 ){
            Intent intent = new Intent(IntensityRatingActivity.this, MoodRatingActivity.class);
            intent.putExtra("element2", element2);
            counter1 = counter ++;
            intent.putExtra("counter", 2);
            startActivity(intent);
        }
        else if(counter == 2){
            Intent intent = new Intent(IntensityRatingActivity.this, favouriteGenresActivity.class);
            int counter1 = counter ++;
            intent.putExtra("counter", 3);
            startActivity(intent);
        }
        else if(counter == 3){
            Intent intent = new Intent(IntensityRatingActivity.this, MoodRatingActivity.class);
            intent.putExtra("element2", element2);
            counter1 = counter ++;
            intent.putExtra("counter", 4);
            startActivity(intent);
        }
        else{
            Intent intent = new Intent(IntensityRatingActivity.this, MenuActivity.class);
            startActivity(intent);
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detach();
    }

}
