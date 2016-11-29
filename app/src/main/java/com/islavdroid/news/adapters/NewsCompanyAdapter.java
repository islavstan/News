package com.islavdroid.news.adapters;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.islavdroid.news.NewsActivity;
import com.islavdroid.news.R;
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
    public void onBindViewHolder(final ViewHolder holder, int position) {
         final Source p =dataset.get(position);
        holder.nameTextView.setText(p.getName());
        holder.descriptionTextView.setText(p.getDescription());
        Picasso.with(holder.nameTextView.getContext()).load( p.getUrlToLogos().getPictureUrl()).into(holder.photoImage);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(holder.nameTextView.getContext(), NewsActivity.class);
                intent.putExtra("companyName",p.getId());
                holder.nameTextView.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void addCompanyToList(List<Source> sourceList) {
        dataset.addAll(sourceList);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView photoImage;
        private CardView cardView;
        private TextView nameTextView;
        private TextView descriptionTextView;
        public ViewHolder(View itemView) {
            super(itemView);
            cardView=(CardView)itemView.findViewById(R.id.cardView);
            photoImage =(ImageView)itemView.findViewById(R.id.image);
            nameTextView =(TextView)itemView.findViewById(R.id.name);
            descriptionTextView =(TextView)itemView.findViewById(R.id.description);

        }


    }
}
