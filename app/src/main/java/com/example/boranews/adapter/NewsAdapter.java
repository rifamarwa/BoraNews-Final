package com.example.boranews.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.boranews.R;
import com.example.boranews.holder.NewsViewHolder;
import com.example.boranews.model.NewsArticle;
import com.example.boranews.utils.TimeUnits;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Azhar Rivaldi on 22-12-2019.
 */

/* Edited by Rifa Marwa on 19-07-2021 */

public class NewsAdapter extends RecyclerView.Adapter<NewsViewHolder> {

    Context context;
    ArrayList<NewsArticle> androidList;
    private static NewsAdapter.onSelectData onSelectData;

    public NewsAdapter(Context context, ArrayList<NewsArticle> androidList) {
        this.context = context;
        this.androidList = androidList;
    }

    public interface onSelectData {
        void onSelected(NewsArticle mdlNews);
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_berita, parent, false);
        return new  NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder viewHolder, int position) {
//        holder.tvName.setText(articles.get(position).getTitle().toString());
//        holder.tvDesCription.setText(articles.get(position).toString());
//        Picasso.get().load(articles.get(position).getUrlToImage()).into(holder.ivNews);

        final NewsArticle berita = androidList.get(position);

        Glide.with(context)
                .load(berita.getUrlToImage())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.ic_launcher_background)
                //.transform(new CenterInside(), new RoundedCorners(30))
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(30)))
                .into(viewHolder.image);

        viewHolder.title.setText(berita.getTitle());
        viewHolder.source.setText(berita.getSource().getName());
        viewHolder.publishedAt.setText(TimeUnits.getTimeAgo(berita.getPublishedAt()));
        viewHolder.cvNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onSelectData.onSelected(berita);
            }
        });
    }

    @Override
    public int getItemCount() {
        return androidList.size();
    }

}

//    public List<NewsArticle> androidList;
//    private Context mContext;
//    private NewsAdapter.onSelectData onSelectData;
//
//    public interface onSelectData {
//        void onSelected(NewsArticle mdlNews);
//    }
//
//    public NewsAdapter(Context context, List<NewsArticle> android, NewsAdapter.onSelectData onSelectData) {
//        this.mContext = context;
//        this.androidList = android;
//        this.onSelectData = onSelectData;
//    }
//
//    @NonNull
//    @Override
//    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
//        View view = LayoutInflater.from(mContext).inflate(R.layout.list_item_berita, viewGroup, false);
//        return new NewsViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(NewsViewHolder viewHolder, int i) {
//
//        final NewsArticle berita = androidList.get(i);
//
//        Glide.with(mContext)
//                .load(berita.getUrlToImage())
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
//                .placeholder(R.drawable.ic_launcher_background)
//                //.transform(new CenterInside(), new RoundedCorners(30))
//                .apply(RequestOptions.bitmapTransform(new RoundedCorners(30)))
//                .into(viewHolder.image);
//
//        viewHolder.title.setText(berita.getTitle());
//        viewHolder.source.setText(berita.getSource().getName());
//        viewHolder.publishedAt.setText(TimeUnits.getTimeAgo(berita.getPublishedAt()));
//        viewHolder.cvNews.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                onSelectData.onSelected(berita);
//            }
//        });
//    }
//
//    @Override
//    public int getItemCount() {
//        return androidList.size();
//    }

