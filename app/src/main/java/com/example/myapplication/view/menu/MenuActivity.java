package com.example.myapplication.view.menu;

import com.example.myapplication.databinding.LayoutActivityMenuBinding;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import com.example.myapplication.R;
import com.example.myapplication.view.moodQuestion.MoodQuestionActivity;
import com.example.myapplication.view.musicSession.MusicSessionActivity;
import com.example.myapplication.view.search.SearchableActivity;
import com.example.myapplication.view.statistics.StatisticsActivity;

public class MenuActivity extends AppCompatActivity implements MenuView , SearchView.OnQueryTextListener{
    LayoutActivityMenuBinding binding;
    MenuPresenter presenter;
    SearchView searchListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Menu");
        binding = DataBindingUtil.setContentView(this, R.layout.layout_activity_menu);
        presenter = new MenuPresenter(this);
        searchListView = (SearchView) findViewById(R.id.search);

        setClickListeners();
    }

    private void setClickListeners() {
        binding.search.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onClickSearch();
            }
        });

        binding.musicSessionBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onClickMusicSession();
            }
        });

        binding.statisticsBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onClickStatistics();
            }
        });
    }

    @Override
    public void handleMusicSession() {
        startActivity(new Intent(MenuActivity.this, MoodQuestionActivity.class));
    }

    @Override
    public void handleSearch() {
        Intent intent = new Intent(MenuActivity.this, SearchableActivity.class);
        intent.putExtra("SearchItem", searchListView.getQuery().toString());
        startActivity(intent);
    }


    @Override
    public void handleStatistics() {
        startActivity(new Intent(MenuActivity.this, StatisticsActivity.class));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detach();
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }
}
