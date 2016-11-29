package com.islavdroid.news;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.islavdroid.news.modelCompany.Source;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;



public class NewsCompanyAdapter extends RecyclerView.Adapter<NewsCompanyAdapter.ViewHolder> {

    private List<Source> dataset;

    public NewsCompanyAdapter() {
        dataset=new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news_company,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Source p =dataset.get(position);
        holder.nameTextView.setText(p.getName());
        holder.descriptionTextView.setText(p.getDescription());
        Picasso.with(holder.nameTextView.getContext()).load( p.getUrlToLogos().getPictureUrl()).into(holder.photoImage);


    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void addPokemonToList(List<Source> sourceList) {
        dataset.addAll(sourceList);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView photoImage;
        private TextView nameTextView;
        private TextView descriptionTextView;
        public ViewHolder(View itemView) {
            super(itemView);
            photoImage =(ImageView)itemView.findViewById(R.id.image);
            nameTextView =(TextView)itemView.findViewById(R.id.name);
            descriptionTextView =(TextView)itemView.findViewById(R.id.description);
        }
    }
}
