package com.example.myapplication.view.favouriteBands;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.domain.Band;

import java.util.List;

public class favouriteBandsListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    List<Band> data;
    Context context;

    public favouriteBandsListAdapter(List<Band> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item_band, parent, false);
        return new favouriteBandsListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, int position) {
        final Band band= data.get(position);
        favouriteBandsListAdapter.ViewHolder customHolder = (favouriteBandsListAdapter.ViewHolder) holder;

        TextView bandTitleTV = customHolder.rootView.findViewById(R.id.band_tv);

        bandTitleTV.setText(band.getName());

        bandTitleTV.setTextColor(Color.parseColor("#FFFFFF"));

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        View rootView;

        public ViewHolder(View itemView) {
            super(itemView);
            rootView = itemView;
        }
    }
}
