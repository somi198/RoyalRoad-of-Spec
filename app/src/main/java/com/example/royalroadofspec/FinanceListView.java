package com.example.royalroadofspec;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class FinanceListView extends AppCompatActivity {

    static  String[] FINANCE_LIST = {"은행원", "투자 분석가", "증권 중개인"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finance_listview);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, FINANCE_LIST);

        Button button = (Button) findViewById(R.id.backbutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), selecting_occupation_1.class);
                startActivity(intent);
            }
        });

        ListView listView = (ListView) findViewById(R.id.listview4);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String strText = (String) parent.getItemAtPosition(position);
                //TODO
                if(strText == FINANCE_LIST[0]){
                    Intent myIntent = new Intent(getApplicationContext(), details_of_selected_field_3.class);
                    startActivity(myIntent);
                }
                if(strText == FINANCE_LIST[1]){
                    Intent myIntent = new Intent(getApplicationContext(), Preparing.class);
                    startActivity(myIntent);
                }
                if(strText == FINANCE_LIST[2]){
                    Intent myIntent = new Intent(getApplicationContext(), Preparing.class);
                    startActivity(myIntent);
                }
            }
        });

    }
}
