package com.islavdroid.news;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.islavdroid.news.adapters.NewsAdapter;
import com.islavdroid.news.api.ApiClient;
import com.islavdroid.news.modelNews.Article;
import com.islavdroid.news.modelNews.News;
import com.islavdroid.news.point.NewsPoint;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    NewsAdapter newsAdapter;
    private final String key = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        Intent intent = getIntent();
        String companyName =intent.getStringExtra("companyName");
        recyclerView =(RecyclerView)findViewById(R.id.recycler_view);
        newsAdapter=new NewsAdapter();
        recyclerView.setAdapter(newsAdapter);
        LinearLayoutManager linearLayoutManager =new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        final NewsPoint apiService = ApiClient.getNews().create(NewsPoint.class);
        Call<News> call =apiService.getNews(companyName,key);
        call.enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {
                News news =response.body();
                List<Article>articles=news.getArticleList();
                newsAdapter.addNewsToList(articles);
            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {

            }
        });

    }
}
