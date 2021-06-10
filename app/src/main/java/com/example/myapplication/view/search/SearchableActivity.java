package com.example.myapplication.view.search;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.myapplication.App;
import com.example.myapplication.R;

import com.example.myapplication.databinding.LayoutActivitySearchSongsBinding;
import com.example.myapplication.domain.Song;

import java.util.List;

public class SearchableActivity extends AppCompatActivity implements SearchableView {

    LayoutActivitySearchSongsBinding binding;
    SearchablePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.layout_activity_search_songs);
        presenter = new SearchablePresenter(this, App.memoryInitializer.getSongDAO());
        setUpRecyclerView();
    }

    private void setUpRecyclerView() {
        binding.songRv.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onResume() {
        super.onResume();
        String query;
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            query = null;
        }
        else {
            query= extras.getString("SearchItem");
        }
        presenter.loadAllSongs(query);
    }

    @Override
    public void onFetchSongs(List<Song> songList) {
        binding.songRv.setAdapter(new SearchableListAdapter(songList, this));
    }

    @Override
    public void noResultsFound() {
        String notFound = "No results found... ";
        binding.songNotFound.setText(notFound);
    }
}
