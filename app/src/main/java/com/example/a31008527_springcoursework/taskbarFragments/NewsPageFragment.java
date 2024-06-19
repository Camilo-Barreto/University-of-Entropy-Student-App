package com.example.a31008527_springcoursework.taskbarFragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a31008527_springcoursework.R;
import com.example.a31008527_springcoursework.RecyclerviewItems.NewsRecyclerAdapter;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import com.google.firebase.BuildConfig;
import com.kwabenaberko.newsapilib.NewsApiClient;
import com.kwabenaberko.newsapilib.models.Article;
import com.kwabenaberko.newsapilib.models.request.EverythingRequest;
import com.kwabenaberko.newsapilib.models.response.ArticleResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class NewsPageFragment extends Fragment {

    RecyclerView recyclerView;
    List<Article> articleList = new ArrayList<>();
    NewsRecyclerAdapter adapter;
    LinearProgressIndicator progressIndicator;
    String news_api_key = com.example.a31008527_springcoursework.BuildConfig.newsApiKey;


    public NewsPageFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_news_page, container, false);

        recyclerView = rootview.findViewById(R.id.news_recycler_view);
        progressIndicator = rootview.findViewById(R.id.progress_bar);

        setRecyclerView();
        getUniversityNews();

        return rootview;
    }

    void setRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        adapter = new NewsRecyclerAdapter(requireContext(), articleList);
        recyclerView.setAdapter(adapter);
    }

    void changeProgress(boolean show) {
        if (show) {
            progressIndicator.setVisibility(View.VISIBLE);
        }
        else {
            progressIndicator.setVisibility(View.INVISIBLE);
        }
    }


    void getUniversityNews() {
        changeProgress(true);
        NewsApiClient newsApiClient = new NewsApiClient(news_api_key);
        newsApiClient.getEverything(
                new EverythingRequest.Builder()
                        .q("university OR college OR higher education OR academic OR campus")
                        .language("en")
                        .sortBy("popularity")
                        .build(),
                new NewsApiClient.ArticlesResponseCallback() {
                    @Override
                    public void onSuccess(ArticleResponse response) {
                        requireActivity().runOnUiThread(() -> {
                            changeProgress(false);
                            articleList = response.getArticles();
                            adapter.updateData(articleList);
                            adapter.notifyDataSetChanged();

                        });
                    }
                    @Override
                    public void onFailure(Throwable throwable) {
                        Log.i("NEWS FAILED", Objects.requireNonNull(throwable.getMessage()));
                    }
                }
        );
    }

}