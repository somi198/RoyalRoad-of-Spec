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

    static  String[] OFFICER_LIST = {"경찰직", "행정직", "군공무원"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.officer_listview_2);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, OFFICER_LIST);

        Button button = (Button) findViewById(R.id.backbutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), selecting_occupation_1.class);
                startActivity(intent);
            }
        });

        ListView listView = (ListView) findViewById(R.id.listview3);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String strText = (String) parent.getItemAtPosition(position);
                //TODO
                if(strText == OFFICER_LIST[0]){
                    Intent myIntent = new Intent(getApplicationContext(), details_of_selected_field_3.class);
                    startActivity(myIntent);
                }
                if(strText == OFFICER_LIST[1]){
                    Intent myIntent = new Intent(getApplicationContext(), Preparing_3.class);
                    startActivity(myIntent);
                }
                if(strText == OFFICER_LIST[2]){
                    Intent myIntent = new Intent(getApplicationContext(), Preparing_3.class);
                    startActivity(myIntent);
                }
            }
        });

    }
}
