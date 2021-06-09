package com.example.royalroadofspec;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class selecting_occupation_1 extends AppCompatActivity {

    static String[] JOB_LIST = {"IT", "공무원", "금융업"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecting_occupation_1);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, JOB_LIST);

        ListView listView = (ListView) findViewById(R.id.listview1);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String strText = (String) parent.getItemAtPosition(position);
                //TODO
                if(strText == JOB_LIST[0]){     //IT 리스트 클릭시 이동
                    Intent myIntent = new Intent(getApplicationContext(), ITListView_2.class);
                    startActivity(myIntent);
                }
                if(strText == JOB_LIST[1]){     //공무원 리스트 클릭 시 이동
                    Intent myIntent = new Intent(getApplicationContext(), OfficerListView_2.class);
                    startActivity(myIntent);
                }
                if(strText == JOB_LIST[2]){     //금융업 리스트 클릭 시 이동
                    Intent myIntent = new Intent(getApplicationContext(), FinanceListView_2.class);
                    startActivity(myIntent);
                }

            }
        });

    }



}