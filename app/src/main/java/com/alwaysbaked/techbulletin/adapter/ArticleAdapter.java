package com.alwaysbaked.techbulletin.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alwaysbaked.techbulletin.R;
import com.alwaysbaked.techbulletin.model.Article;
import com.alwaysbaked.techbulletin.presenter.ArticleContract;
import com.alwaysbaked.techbulletin.presenter.ArticlePresenter;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.MyViewHolder> {

    private Context context;
    private List<Article> articles;
    private ArticlePresenter presenter;

    public ArticleAdapter(Context context, List<Article> articles, ArticlePresenter presenter) {
        this.context = context;
        this.articles = articles;
        this.presenter = presenter;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.article_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        //Picasso.get().load(articles.get(position).getUrlToImage()).into(holder.displayPicture);
        holder.headlines.setText(articles.get(position).getTitle());
        holder.timestamp.setText(articles.get(position).getPublishedAt());
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView displayPicture;
        TextView headlines;
        TextView timestamp;
        ViewGroup viewGroup;

        MyViewHolder(View itemView) {
            super(itemView);
            //displayPicture = itemView.findViewById(R.id.imageViewDisplayPicture);
            headlines = itemView.findViewById(R.id.textViewHeadline);
            timestamp = itemView.findViewById(R.id.textViewTimestamp);
            viewGroup = itemView.findViewById(R.id.articleItemList);
            viewGroup.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            Article article = articles.get(this.getAdapterPosition());
            presenter.onArticleClick(article);

        }
    }
}
