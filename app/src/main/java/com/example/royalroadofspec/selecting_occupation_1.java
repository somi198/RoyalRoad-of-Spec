package com.example.royalroadofspec;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class selecting_occupation_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecting_occupation1);

        Button button = (Button) findViewById(R.id.newActivity);
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), selecting_subfield_content_2.class);
                startActivity(intent);
            }
        });

    }

    public void SearchClicked(View v){ //검색 버튼 클릭 시 2번째 화면으로 이동
        Intent myIntent = new Intent(getApplicationContext(), selecting_subfield_content_2.class);
        startActivity(myIntent);
        //Toast.makeText(getApplicationContext(), "이동", Toast.LENGTH_LONG).show();
    }

    public void CommunityClicked(View v){ //community 버튼 클릭 시 community 화면으로 이동
        Intent myIntent = new Intent(getApplicationContext(), community_space_4.class);
        startActivity(myIntent);
        //Toast.makeText(getApplicationContext(), "이동", Toast.LENGTH_LONG).show();
    }

    public void EtcClicked(View v){ //community 버튼 클릭 시 community 화면으로 이동
        Intent myIntent = new Intent(getApplicationContext(), InfoAboutSpec.class); //page5로 변경
        startActivity(myIntent);
        //Toast.makeText(getApplicationContext(), "이동", Toast.LENGTH_LONG).show();
    }
}