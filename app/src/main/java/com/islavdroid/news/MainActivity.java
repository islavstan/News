package com.islavdroid.news;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.islavdroid.news.adapters.NewsCompanyAdapter;
import com.islavdroid.news.api.ApiClient;
import com.islavdroid.news.modelCompany.NewsCompany;
import com.islavdroid.news.modelCompany.Source;
import com.islavdroid.news.point.NewsCompanyPoint;

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
        final NewsCompanyPoint apiService = ApiClient.getNews().create(NewsCompanyPoint.class);
        Call<NewsCompany> call =apiService.getCompany();
        call.enqueue(new Callback<NewsCompany>() {
            @Override
            public void onResponse(Call<NewsCompany> call, Response<NewsCompany> response) {
                NewsCompany newsCompany =response.body();
                List<Source> sourceList = newsCompany.getSourceList();
                newsCompanyAdapter.addCompanyToList(sourceList);
            }

            @Override
            public void onFailure(Call<NewsCompany> call, Throwable t) {

            }
        });
    }
}
