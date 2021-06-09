package com.example.royalroadofspec;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class ITListView_2 extends AppCompatActivity {
    //IT 클릭 시 나타나는 직업 리스트
    static  String[] IT_LIST = {"프론트엔드 개발자", "정보보안 전문가", "데이터베이스 관리자"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.it_listview_2);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, IT_LIST);

        ListView listView = (ListView) findViewById(R.id.listview2);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String strText = (String) parent.getItemAtPosition(position);
                //TODO
                if(strText == IT_LIST[0]){      //프론트엔드 개발자 클릭 시 이동
                    Intent myIntent = new Intent(getApplicationContext(), details_of_selected_field_3.class);
                    startActivity(myIntent);
                }
                if(strText == IT_LIST[1]){      //정보보안 전문가 클릭 시 이동
                    Intent myIntent = new Intent(getApplicationContext(), Preparing_3.class);
                    startActivity(myIntent);
                }
                if(strText == IT_LIST[2]){      //데이터베이스 관리자 클릭 시 이동
                    Intent myIntent = new Intent(getApplicationContext(), Preparing_3.class);
                    startActivity(myIntent);
                }
            }
        });

    }
}
