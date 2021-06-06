package com.example.royalroadofspec;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class selecting_occupation_1 extends AppCompatActivity {

    static String[] JOB_LIST = {"IT", "공무원", "금융업"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecting_occupation1);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, JOB_LIST);

        Button button = (Button) findViewById(R.id.newActivity);
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), selecting_subfield_content_2.class);
                startActivity(intent);
            }
        });

        ListView listView = (ListView) findViewById(R.id.listview1);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String strText = (String) parent.getItemAtPosition(position);
                //TODO
                if(strText == JOB_LIST[0]){
                    Intent myIntent = new Intent(getApplicationContext(), ITListView.class);
                    startActivity(myIntent);
                    //Toast.makeText(getApplicationContext(), "IT 클릭", Toast.LENGTH_SHORT).show();
                }
                if(strText == JOB_LIST[1]){
                    Intent myIntent = new Intent(getApplicationContext(), OfficerListView.class);
                    startActivity(myIntent);
                    //Toast.makeText(getApplicationContext(), "공무원 클릭", Toast.LENGTH_SHORT).show();
                }
                if(strText == JOB_LIST[2]){
                    Intent myIntent = new Intent(getApplicationContext(), FinanceListView.class);
                    startActivity(myIntent);
                    //Toast.makeText(getApplicationContext(), "금융업 클릭", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }


    public void CommunityClicked(View v){ //community 버튼 클릭 시 community 화면으로 이동
        Intent myIntent = new Intent(getApplicationContext(), community_space_4.class);
        startActivity(myIntent);
        //Toast.makeText(getApplicationContext(), "이동", Toast.LENGTH_LONG).show();
    }

    public void EtcClicked(View v){ //community 버튼 클릭 시 community 화면으로 이동
        Intent myIntent = new Intent(getApplicationContext(), Preparing.class); //page5로 변경
        startActivity(myIntent);
        //Toast.makeText(getApplicationContext(), "이동", Toast.LENGTH_LONG).show();
    }
}