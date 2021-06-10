package com.example.myapplication.view.favouriteGenres;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.myapplication.R;
import com.example.myapplication.databinding.LayoutActivityFavouriteGenresBinding;
import com.example.myapplication.domain.Genre;
import com.example.myapplication.util.AndroidUtil;
import com.example.myapplication.view.songRating.MoodRatingActivity;

import java.util.List;


public class favouriteGenresActivity extends AppCompatActivity implements favouriteGenresView {
    LayoutActivityFavouriteGenresBinding binding;
    favouriteGenresPresenter presenter;
    int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.layout_activity_favourite_genres);
        presenter = new favouriteGenresPresenter(this);
        Bundle extras = getIntent().getExtras();
        counter = extras.getInt("counter");

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
                "Looks like you forgot to complete all fields or you didn't choose one of the genres given ",
                "GOT IT",
                runnable);
    }

    @Override
    public void onSuccessfullyCompletedProcess(final String genre1, final String genre2) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if(counter == 3 || counter == 4) {
                    Intent intent = new Intent(favouriteGenresActivity.this, MoodRatingActivity.class);
                    intent.putExtra("element1", genre1);
                    intent.putExtra("element2", genre2);
                    int counter1 = counter ++;
                    intent.putExtra("counter", 3);
                    startActivity(intent);
                    finish();
                }


            }
        };
        AndroidUtil.showDialog(this,
                "Well done",
                "Let's proceed to the next step!" ,
                "OKAY",
                runnable);
    }

    private void setUpRecyclerView() {
        binding.genreRv.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.loadAllGenres();
    }

    @Override
    public void onFetchGenres(List<Genre> genreList) {
        binding.genreRv.setAdapter(new favouriteGenresListAdapter(genreList, this));
    }

    @Override
    public String getGenreTitle1(){
        return binding.genre1Et.getText().toString();
    }

    @Override
    public String getGenreTitle2(){
        return binding.genre2Et.getText().toString();
    }

    @Override
    public void setGenreTitle1(String title) {
        binding.genre1Et.setText(title);
    }

    @Override
    public void setGenreTitle2(String title) {
        binding.genre2Et.setText(title);
    }
}
