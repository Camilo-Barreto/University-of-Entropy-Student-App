package com.example.a31008527_springcoursework.RecyclerviewItems;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a31008527_springcoursework.R;
import com.kwabenaberko.newsapilib.models.Article;
import com.squareup.picasso.Picasso;

import java.util.List;

public class NewsRecyclerAdapter extends RecyclerView.Adapter<NewsViewHolder> {

    private Context context;
    private List<Article> articlesList;

    public NewsRecyclerAdapter(Context context, List<Article> articlesList) {
        this.context = context;
        this.articlesList = articlesList;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NewsViewHolder(LayoutInflater.from(context).inflate(R.layout.news_recycler_card, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        if (articlesList.size() > position) {
            Article article = articlesList.get(position);
            holder.a_title_txtview.setText(article.getTitle());
            holder.a_source_txtview.setText(article.getSource().getName());

            if (article.getUrlToImage() != null && !article.getUrlToImage().isEmpty()) {
                Log.d("Image URL SUCCESS", article.getUrlToImage());
                Picasso.get().load(article.getUrlToImage())
                        .error(R.drawable.news_placeholder)
                        .placeholder(R.drawable.news_placeholder)
                        .into(holder.article_image_view);
            } else {
                Log.d("Image URL FAILED", "URL is null or empty");
                Picasso.get().load(R.drawable.news_placeholder) // Load a placeholder image
                        .placeholder(R.drawable.news_placeholder)
                        .into(holder.article_image_view);
            }
        }
    }


    public void updateData(List<Article> data) {
        // clear the article list
        articlesList.clear();
        // add new data
        articlesList.addAll(data);
    }

    @Override
    public int getItemCount() {
        return articlesList.size();
    }
}
