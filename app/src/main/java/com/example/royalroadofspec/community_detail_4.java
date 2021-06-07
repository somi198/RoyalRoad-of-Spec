package com.example.royalroadofspec;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;

public class community_detail_4 extends AppCompatActivity {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.  HH:mm");
    boolean click = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community_detail_4);
        Button LikeButton = (Button) findViewById(R.id.LikeButton);
        Button ChatButton = (Button) findViewById(R.id.ChatButton);


        Intent intent = getIntent();

        TextView title = (TextView) findViewById(R.id.detail_title);
        TextView content = (TextView) findViewById(R.id.detail_content);
        TextView name = (TextView) findViewById(R.id.detail_name);
        TextView category = (TextView) findViewById(R.id.detail_category);
        TextView date = (TextView) findViewById(R.id.detail_date);


        title.setText(intent.getStringExtra("title"));
        content.setText(intent.getStringExtra("content"));
        name.setText(intent.getStringExtra("userName"));
        category.setText(intent.getStringExtra("category"));
        date.setText(intent.getStringExtra("date"));


        LikeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (click == false) {
                    Drawable fullheart = (Drawable) getResources().getDrawable(R.drawable.baseline_favorite_black_48);
                    LikeButton.setBackground(fullheart);
                    click = true;
                } else {
                    Drawable emptyheart = (Drawable) getResources().getDrawable(R.drawable.baseline_favorite_border_black_48);
                    LikeButton.setBackground(emptyheart);
                    click = false;
                }
            }
        });

        ChatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();

            }
        });

    }
}