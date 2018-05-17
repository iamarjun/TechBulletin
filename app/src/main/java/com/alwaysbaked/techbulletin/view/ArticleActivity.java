package com.alwaysbaked.techbulletin.view;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alwaysbaked.techbulletin.R;
import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

public class ArticleActivity extends AppCompatActivity {

    private ImageView backdrop;
    private TextView articleBody;
    private TextView articleTitle;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);

        Intent intent = getIntent();

        backdrop = findViewById(R.id.backdrop);
        Glide.with(this).load(intent.getStringExtra("Article Image URL")).into(backdrop);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        articleTitle = findViewById(R.id.articleTitle);
        articleTitle.setText(intent.getStringExtra("Article Headline"));

        articleBody = findViewById(R.id.articleBody);
        articleBody.setText(intent.getStringExtra("Article Description"));

    }
}
