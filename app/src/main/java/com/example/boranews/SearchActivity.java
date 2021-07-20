package com.example.boranews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.boranews.adapter.NewsAdapter;
import com.example.boranews.model.NewsArticle;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {

    androidx.appcompat.widget.SearchView searchView;
    private ArrayList<NewsArticle> newsArticleArrayList;
    NewsAdapter newsAdapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        recyclerView = (findViewById(R.id.recyclerView));


        searchView = findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                ArrayList<NewsArticle> newsArticle = new ArrayList<>();
                for(NewsArticle data : newsArticleArrayList){
                    String name = data.getTitle();
                    if(name.contains(newText)){
                        newsArticle.add(data);
                    }
                }
                setupRecyclerView();
                return true;
            }
        });
    }

    private void setupRecyclerView(){
        if(newsAdapter == null)
        {
            newsAdapter = new NewsAdapter(SearchActivity.this, newsArticleArrayList);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(newsAdapter);
        }
    }
}