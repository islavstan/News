package com.islavdroid.news.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.islavdroid.news.R;
import com.islavdroid.news.modelCompany.Source;
import com.islavdroid.news.modelNews.Article;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by islav on 29.11.2016.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private List<Article> dataset;

    public NewsAdapter() {
        dataset=new ArrayList<>();
    }

    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news,parent,false);
        return new NewsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NewsAdapter.ViewHolder holder, int position) {
        Article article =dataset.get(position);
        holder.author.setText(article.getAuthor());
        holder.title.setText(article.getTitle());
        holder.description.setText(article.getDescription());
        holder.url.setText(article.getUrl());
        holder.date.setText(article.getPublishedAt());

        Picasso.with(holder.author.getContext()).load( article.getImage()).into(holder.photoImage);


    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void addNewsToList(List<Article> articles) {
        dataset.addAll(articles);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView photoImage;
        private TextView author;
        private TextView title;
        private TextView description;
        private TextView url;
        private TextView date;
        public ViewHolder(View itemView) {
            super(itemView);
            photoImage =(ImageView)itemView.findViewById(R.id.image);
            author =(TextView)itemView.findViewById(R.id.author);
            title =(TextView)itemView.findViewById(R.id.title);
            description =(TextView)itemView.findViewById(R.id.description);
            url =(TextView)itemView.findViewById(R.id.url);
            date =(TextView)itemView.findViewById(R.id.date);
        }}}
