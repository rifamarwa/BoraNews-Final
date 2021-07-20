package com.example.boranews;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.boranews.adapter.NewsAdapter;
import com.example.boranews.model.NewsArticle;
import com.example.boranews.viewmodels.NewsViewModel;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NewsAdapter.onSelectData {

    RecyclerView rvHeadNews;
    NewsAdapter newsAdapter;
    NewsViewModel newsViewModel;
    ArrayList<NewsArticle> newArticles = new ArrayList<>();
    ProgressDialog progressDialog;
    Toolbar toolbar;
    ImageView searchLogo;
    SearchView searchView;
    TextView judulHeadline, waktuPublish;
    CardView cardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Mohon tunggu");
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Sedang menampilkan data");

        searchLogo = findViewById(R.id.searchLogo);
        rvHeadNews = findViewById(R.id.recyclerView);

        newsViewModel = ViewModelProviders.of(this).get(NewsViewModel.class);
        newsViewModel.initInternationalNews();
        newsViewModel.getNewsRepository().observe(this, newsResponse -> {
            List<NewsArticle> newsArticles = newsResponse.getArticles();
            newArticles.addAll(newsArticles);
            newsAdapter.notifyDataSetChanged();
        });

//        NewsArticle gambar = new NewsArticle(newsViewModel.initIndonesiaNews().);
//        headline = findViewById(R.id.imageBeritaUtama1);
//        headline.setImageResource(new NewsArticle(String urltoImage));


        setupRecyclerView();

        searchLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SearchActivity.class);
                startActivity(i);
            }
        });
//        rvHeadNews.setHasFixedSize(true);
      //  rvHeadNews.setLayoutManager(new LinearLayoutManager(this));
       // cardView.set
       //setupToolbar();
      //  loadJSON();

    }

    private void setupRecyclerView(){
        if(newsAdapter == null)
        {
            newsAdapter = new NewsAdapter(MainActivity.this, newArticles);
            rvHeadNews.setLayoutManager(new LinearLayoutManager(this));
            rvHeadNews.setAdapter(newsAdapter);
        }
    }

    private void setupToolbar() {
        toolbar = findViewById(R.id.toolbarBora);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setSupportActionBar(Toolbar toolbar) {
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSelected(NewsArticle mdlNews) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

//    private void loadJSON() {
//        progressDialog.show();
//        AndroidNetworking.get(NewsApi.GET_TOP_HEADLINES)
//                .setPriority(Priority.HIGH)
//                .build()
//                .getAsJSONObject(new JSONObjectRequestListener() {
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        try {
//                            progressDialog.dismiss();
//                            JSONArray playerArray = response.getJSONArray("articles");
//                            for (int i = 0; i < playerArray.length(); i++) {
//                                JSONObject temp = playerArray.getJSONObject(i);
//                                NewsArticle dataApi = new NewsArticle();
//                                dataApi.setTitle(temp.getString("title"));
//                                dataApi.setUrl(temp.getString("url"));
//                                dataApi.setPublishedAt(temp.getString("publishedAt"));
//                                dataApi.setSource(temp.getSource("name"));
//                                dataApi.setUrlToImage(temp.getString("urlToImage"));
//
//
//                                newArticles.add(dataApi);
//                                showNews();
//                            }
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                            Toast.makeText(MainActivity.this, "Gagal menampilkan data!", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//
//                    @Override
//                    public void onError(ANError anError) {
//                        progressDialog.dismiss();
//                        Toast.makeText(MainActivity.this, "Tidak ada jaringan internet!", Toast.LENGTH_SHORT).show();
//                    }
//                });
//    }
//
//    private void showNews() {
//        newsAdapter = new NewsAdapter(MainActivity.this, newArticles, this);
//        rvHeadNews.setAdapter(newsAdapter);
//    }
//
//    @Override
//    public void onSelected(NewsArticle mdlNews) {
//       // startActivity(new Intent(HeadLineActivity.this, OpenNewsActivity.class).putExtra("url", mdlNews.getUrl()));
//    }
//
//    @Override
//    public void onPointerCaptureChanged(boolean hasCapture) {
//
//    }
}