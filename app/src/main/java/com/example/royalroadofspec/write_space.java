package com.example.royalroadofspec;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.Button;
import android.widget.EditText;


import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class write_space extends AppCompatActivity {

    SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
    EditText title, content, userName;
    String category;
    String current;
    Integer likes = 0;
    Integer comments = 0;

    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_space);

        title = findViewById(R.id.BoardTitle);
        content = findViewById(R.id.BoardContent);
        userName = findViewById(R.id.UserName);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.category,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                category = parent.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(),category+
                        "이 선택되었습니다.", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

    }

    private void writeNewBoard(String title, String content, String userName, String category, String date, Integer likes, Integer comments){
        Board board = new Board(title, content, userName, category, date, likes, comments);

        mDatabase.child("boards").push().setValue(board)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(write_space.this, "저장 완료", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(write_space.this, "저장 실패", Toast.LENGTH_SHORT).show();
                    }
                });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.save_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.action_upload){
            long now = System.currentTimeMillis();
            Date date = new Date(now);
            current = simpleDate.format(date);

            String getBoardTitle = title.getText().toString();
            String getBoardContent = content.getText().toString();
            String getBoardUserName = userName.getText().toString();


            if(getBoardTitle.equals("")){
                Toast.makeText(write_space.this, "제목을 입력하세요.", Toast.LENGTH_SHORT).show();
            }
            else if(getBoardContent.equals("")){
                Toast.makeText(write_space.this, "내용을 입력하세요.", Toast.LENGTH_SHORT).show();
            }
            else if(getBoardUserName.equals("")){
                Toast.makeText(write_space.this, "사용할 닉네임을 입력하세요.", Toast.LENGTH_SHORT).show();
            }
            else{
                HashMap result = new HashMap<>();

                result.put("title", getBoardTitle);
                result.put("content", getBoardContent);
                result.put("userName", getBoardUserName);
                result.put("category", category);
                result.put("date", current);
                result.put("likes", likes);
                result.put("comments", comments);

                writeNewBoard(getBoardTitle, getBoardContent, getBoardUserName, category, current, likes, comments);
            }
        }
        return super.onOptionsItemSelected(item);
    }
}