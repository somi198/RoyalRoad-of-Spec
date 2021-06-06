package com.example.royalroadofspec;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class BoardsActivity extends AppCompatActivity {

    EditText et_board_title, et_board_content, et_board_userName;
    SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
    String category="정보게시판";
    Button btn_save;
    Integer likes = 0;
    Integer comments = 0;
    long now = System.currentTimeMillis();
    Date date = new Date(now);

    private DatabaseReference mDatabase;
    private FirebaseDatabase mFirebase;
    private ChildEventListener mChild;

    private ListView listView;
    private ArrayAdapter<String> adapter;
    List<Object> boardList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boards);

        et_board_title = findViewById(R.id.et_board_title);
        et_board_content = findViewById(R.id.et_board_content);
        et_board_userName = findViewById(R.id.et_board_userName);

        btn_save = findViewById(R.id.btn_save);

        mDatabase = FirebaseDatabase.getInstance().getReference();


        ListView TestList;
        ListBoardAdapter TestAdapter;
        TestAdapter = new ListBoardAdapter();
        TestList = (ListView) findViewById(R.id.testList);
        TestList.setAdapter(TestAdapter);


        readBoard(TestAdapter);
        readBoardList();


        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getBoardTitle = et_board_title.getText().toString();
                String getBoardContent = et_board_content.getText().toString();
                String getBoardUserName = et_board_userName.getText().toString();

                HashMap result = new HashMap<>();
                result.put("title", getBoardTitle);
                result.put("content", getBoardContent);
                result.put("userName", getBoardUserName);

                writeNewBoard(getBoardTitle, getBoardContent, getBoardUserName, category,simpleDate.format(date), likes, comments);
            }
        });
    }

    private void writeNewBoard(String title, String content, String userName, String category, String date, Integer likes, Integer comments){
        Board board = new Board(title, content, userName, category, date, likes, comments);

        mDatabase.child("boards").push().setValue(board)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(BoardsActivity.this, "저장 완료", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(BoardsActivity.this, "저장 실패", Toast.LENGTH_SHORT).show();
                    }
                });
    }
    private void readBoardList(){
//        mFirebase = FirebaseDatabase.getInstance();
//        mDatabase = mFirebase.getReference("log");
//        mDatabase.child("log").setValue("check")

        mDatabase.addChildEventListener(new ChildEventListener() {

            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                Log.d("FirebaseData","onChildAdded:"+ snapshot.getValue());
//                Board board = snapshot.getValue(Board.class);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                Log.d("FirebaseData","onChildChanged:" + snapshot.getKey());

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    protected void onDestroy() {
        super.onDestroy();
        mDatabase.removeEventListener(mChild);
    }

    private void readBoard(ListBoardAdapter TestAdapter){
        long now = System.currentTimeMillis();
        Date date = new Date(now);

        mDatabase.child("boards").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot boardSnapshot : snapshot.getChildren()){
                    String titleStr = boardSnapshot.child("title").getValue(String.class);
                    String nameStr = boardSnapshot.child("userName").getValue(String.class);

                    TestAdapter.addItem(titleStr, date, nameStr, "4", "8");
                    Log.i("TAG: value is ",titleStr+"/"+nameStr);
                    boardList.add(titleStr);
                }
                TestAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w("FireBaseData", "loadPost:onCancelled", error.toException());

            }
        });
    }
}