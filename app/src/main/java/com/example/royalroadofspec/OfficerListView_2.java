package com.example.royalroadofspec;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class OfficerListView_2 extends AppCompatActivity {
    //공무원 클릭 시 나타나는 직업 리스트
    static  String[] OFFICER_LIST = {"경찰직", "행정직", "군공무원"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.officer_listview_2);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, OFFICER_LIST);

        ListView listView = (ListView) findViewById(R.id.listview3);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String strText = (String) parent.getItemAtPosition(position);
                //TODO
                if(strText == OFFICER_LIST[0]){     //경찰직 클릭 시 이동
                    Intent myIntent = new Intent(getApplicationContext(), details_of_selected_field_3_police.class);
                    startActivity(myIntent);
                }
                if(strText == OFFICER_LIST[1]){     //행정직 클릭 시 이동
                    Intent myIntent = new Intent(getApplicationContext(), Preparing_3.class);
                    startActivity(myIntent);
                }
                if(strText == OFFICER_LIST[2]){     //군공무원 클릭 시 이동동
                   Intent myIntent = new Intent(getApplicationContext(), Preparing_3.class);
                    startActivity(myIntent);
                }
            }
        });

    }
}
