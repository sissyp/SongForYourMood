package com.example.myapplication.view.admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.myapplication.App;
import com.example.myapplication.R;
import com.example.myapplication.databinding.LayoutActivityRemoveSongBinding;
import com.example.myapplication.domain.Song;
import com.example.myapplication.util.AndroidUtil;
import com.example.myapplication.view.statistics.StatisticsListAdapter;

import java.util.List;

public class RemoveSongActivity extends AppCompatActivity implements RemoveSongView{

    LayoutActivityRemoveSongBinding binding;
    RemoveSongPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.layout_activity_remove_song);
        presenter = new RemoveSongPresenter(this, App.memoryInitializer.getSongDAO());

        setUpRecyclerView();
        setClickListeners();
    }

    private void setClickListeners() {
        binding.removeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onRemoveSong();
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
                "Empty or wrong fields detected. \nFill them correctly to remove the song..",
                "OKAY",
                runnable);
    }

    @Override
    public void onSuccessRemove() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(RemoveSongActivity.this, AdminActivity.class));
                finish();
            }
        };
        AndroidUtil.showDialog(this,
                "Song removed!",
                "Song title: " + getSongTitle() ,
                "OKAY",
                runnable);
    }

    private void setUpRecyclerView() {
        binding.songRv.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.loadAllSongs();
    }

    @Override
    public void onFetchSongs(List<Song> songList) {
        binding.songRv.setAdapter(new StatisticsListAdapter(songList, this));
    }

    @Override
    public String getSongTitle(){
        return binding.removeSongEt.getText().toString();
    }

    @Override
    public void setSongTitle(String title) {
        binding.removeSongEt.setText(title);
    }
}
