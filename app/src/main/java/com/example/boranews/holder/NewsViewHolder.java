package com.example.boranews.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.example.boranews.R;
import com.example.boranews.api.NewsRepository;
import com.example.boranews.model.NewsResponse;
import com.google.android.material.card.MaterialCardView;

/**
 * Created by Azhar Rivaldi on 22-12-2019.
 */
public class NewsViewHolder extends RecyclerView.ViewHolder {

    public ImageView image;
    public TextView title;
    public TextView publishedAt;
    public TextView source;
    public CardView cvNews;
    public View view;

    public NewsViewHolder(View view) {
        super(view);

        cvNews = view.findViewById(R.id.cvNews);
        image = view.findViewById(R.id.image);
        title = view.findViewById(R.id.title);
        source = view.findViewById(R.id.source);
        publishedAt = view.findViewById(R.id.publishedAt);
        this.view = view;
    }
}
