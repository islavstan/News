package com.islavdroid.news;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.islavdroid.news.model.ApiClient;
import com.islavdroid.news.model.NewsCompany;
import com.islavdroid.news.model.Source;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    NewsCompanyAdapter newsCompanyAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView =(RecyclerView)findViewById(R.id.recycler_view);
        newsCompanyAdapter=new NewsCompanyAdapter();
        recyclerView.setAdapter(newsCompanyAdapter);
        LinearLayoutManager linearLayoutManager =new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        //подключаемся по url
        final SourcePoint apiService = ApiClient.getNews().create(SourcePoint.class);
        Call<NewsCompany> call =apiService.getCompany();
        call.enqueue(new Callback<NewsCompany>() {
            @Override
            public void onResponse(Call<NewsCompany> call, Response<NewsCompany> response) {
                NewsCompany newsCompany =response.body();
                List<Source> sourceList = newsCompany.getSourceList();
                newsCompanyAdapter.addPokemonToList(sourceList);
            }

            @Override
            public void onFailure(Call<NewsCompany> call, Throwable t) {

            }
        });
    }
}
