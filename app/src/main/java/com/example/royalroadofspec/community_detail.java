package com.example.royalroadofspec;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.text.SimpleDateFormat;

public class community_detail extends AppCompatActivity {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.  HH:mm");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community_detail);


        Intent intent = getIntent();

        TextView title = (TextView) findViewById(R.id.detail_title);
        TextView name = (TextView) findViewById(R.id.detail_name);
        TextView board = (TextView) findViewById(R.id.detail_board);


        title.setText(intent.getStringExtra("title"));
        name.setText(intent.getStringExtra("name"));
        board.setText(intent.getStringExtra("board"));

    }
}