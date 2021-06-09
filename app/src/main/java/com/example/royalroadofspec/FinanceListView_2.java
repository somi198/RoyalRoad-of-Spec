package com.example.royalroadofspec;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class FinanceListView_2 extends AppCompatActivity {
    //금융업 클릭 시 나타나는 직업 리스트
    static  String[] FINANCE_LIST = {"은행원", "투자 분석가", "증권 중개인"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finance_listview_2);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, FINANCE_LIST);

        ListView listView = (ListView) findViewById(R.id.listview4);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String strText = (String) parent.getItemAtPosition(position);
                //TODO
                if(strText == FINANCE_LIST[0]){     //은행원 클릭 시 이동
                    Intent myIntent = new Intent(getApplicationContext(), details_of_selected_field_3_banker.class);
                    startActivity(myIntent);
                }
                if(strText == FINANCE_LIST[1]){     //투자 분석가 클릭 시 이동
                    Intent myIntent = new Intent(getApplicationContext(), Preparing_3.class);
                    startActivity(myIntent);
                }
                if(strText == FINANCE_LIST[2]){     //증권 중개인 클릭 시 이동
                    Intent myIntent = new Intent(getApplicationContext(), Preparing_3.class);
                    startActivity(myIntent);
                }
            }
        });

    }
}