package com.example.royalroadofspec;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar bar = getSupportActionBar(); //메인화면 상단바 없애기
        bar.hide();

        Button button = (Button) findViewById(R.id.newActivity);
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), selecting_occupation_1.class);
                startActivity(intent);
            }
        });
    }

    public void CommunityClicked(View v){ //community 버튼 클릭 시 community 화면으로 이동
        Intent myIntent = new Intent(getApplicationContext(), community_space_4.class);
        startActivity(myIntent);
    }

    public void EtcClicked(View v){ //community 버튼 클릭 시 etc 화면으로 이동
        Intent myIntent = new Intent(getApplicationContext(), InfoAboutSpec_5.class);
        startActivity(myIntent);
    }
}