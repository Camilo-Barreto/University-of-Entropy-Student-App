package com.example.a31008527_springcoursework.RecyclerviewItems;


import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.a31008527_springcoursework.R;

public class NewsViewHolder extends RecyclerView.ViewHolder {

    TextView a_title_txtview, a_source_txtview;
    ImageView article_image_view;
    public NewsViewHolder(@NonNull View itemView) {
        super(itemView);

        a_title_txtview = itemView.findViewById(R.id.article_title);
        a_source_txtview = itemView.findViewById(R.id.article_source);
        article_image_view = itemView.findViewById(R.id.article_image_view);
    }
}
