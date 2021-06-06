package com.example.royalroadofspec;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class BoardsActivity extends AppCompatActivity {

    EditText et_board_title, et_board_content, et_board_userName;
    Button btn_save;

    private DatabaseReference mDatabase;


    private String uid = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boards);

        et_board_title = findViewById(R.id.et_board_title);
        et_board_content = findViewById(R.id.et_board_content);
        et_board_userName = findViewById(R.id.et_board_userName);

        btn_save = findViewById(R.id.btn_save);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        readBoard();

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

                writeNewBoard(getBoardTitle, getBoardContent, getBoardUserName);
            }
        });
    }

    private void writeNewBoard(String title, String content, String userName){
        Board board = new Board(title, content, userName);

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

    private void readBoard(){
        mDatabase.child("boards").child(uid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.getValue(Board.class) != null){
                    Board post = snapshot.getValue(Board.class);
                    Log.w("FireBaseData", "getData"+ post.toString());
                } else {
                    Toast.makeText(BoardsActivity.this, "데이터 없음..", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w("FireBaseData", "loadPost:onCancelled", error.toException());

            }
        });
    }
}