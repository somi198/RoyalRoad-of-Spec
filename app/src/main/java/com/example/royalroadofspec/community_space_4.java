package com.example.royalroadofspec;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;



@SuppressWarnings("deprecation")

public class community_space_4 extends AppCompatActivity {

    private DatabaseReference mDatabase;
    private FirebaseDatabase mFirebase;
    private ChildEventListener mChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community_space_4);

        mDatabase = FirebaseDatabase.getInstance().getReference();



        FloatingActionButton writeButton = (FloatingActionButton) findViewById(R.id.fab);

        // 탭 매뉴 만들기
        TabHost tabHost = (TabHost) findViewById(R.id.BoardTabHost);
        tabHost.setup();

        TabHost.TabSpec ts1 = tabHost.newTabSpec("INFORMATION");
        ts1.setContent(R.id.content1);
        ts1.setIndicator("정보게시판");
        tabHost.addTab(ts1);

        TabHost.TabSpec ts2 = tabHost.newTabSpec("QUESTION");
        ts2.setContent(R.id.content2);
        ts2.setIndicator("질문게시판");
        tabHost.addTab(ts2);


        //ListView
        ListView InfoView;
        ListView QaView;
        ListBoardAdapter_4 InfoAdapter;
        ListBoardAdapter_4 QaAdapter;

        InfoAdapter = new ListBoardAdapter_4();
        QaAdapter = new ListBoardAdapter_4();

        InfoView = (ListView) findViewById(R.id.infoList);
        QaView = (ListView) findViewById(R.id.questionList);
        InfoView.setAdapter(InfoAdapter);
        QaView.setAdapter(QaAdapter);

        readBoard(InfoAdapter, QaAdapter);
        readBoardList();


        InfoView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ListBoardItem_4 item = (ListBoardItem_4) parent.getItemAtPosition(position);

                String titleStr = item.getTitle();
                String contentStr = item.getContent();
                String nameStr = item.getUserName();
                String categoryStr = item.getCategory();
                String dateStr = item.getDate();
                Integer likeStr = item.getLikes();
                Integer chatStr = item.getComments();


                Intent intent = new Intent(getApplicationContext(), community_detail_4.class);

                intent.putExtra("title", titleStr);
                intent.putExtra("content", contentStr);
                intent.putExtra("userName", nameStr);
                intent.putExtra("category", categoryStr+" >");
                intent.putExtra("date", dateStr);
                intent.putExtra("likes", likeStr);
                intent.putExtra("comments", chatStr);

                startActivity(intent);

            }
        });

        QaView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ListBoardItem_4 item = (ListBoardItem_4) parent.getItemAtPosition(position);

                String titleStr = item.getTitle();
                String contentStr = item.getContent();
                String nameStr = item.getUserName();
                String categoryStr = item.getCategory();
                String dateStr = item.getDate();
                Integer likeStr = item.getLikes();
                Integer chatStr = item.getComments();


                Intent intent = new Intent(getApplicationContext(), community_detail_4.class);

                intent.putExtra("title", titleStr);
                intent.putExtra("content", contentStr);
                intent.putExtra("userName", nameStr);
                intent.putExtra("category", categoryStr+" >");
                intent.putExtra("date", dateStr);
                intent.putExtra("likes", likeStr);
                intent.putExtra("comments", chatStr);

                startActivity(intent);
            }
        });



        writeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), write_space_4.class);
                startActivity(intent);
                //Toast.makeText(getActivity(), "button1: 글을 작성합니다.", Toast.LENGTH_SHORT).show();
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


    private void readBoard(ListBoardAdapter_4 InfoAdapter, ListBoardAdapter_4 QaAdapter){

        mDatabase.child("boards").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot boardSnapshot : snapshot.getChildren()
                ){

                    String titleStr = boardSnapshot.child("title").getValue(String.class);
                    String nameStr = boardSnapshot.child("userName").getValue(String.class);
                    String contentStr = boardSnapshot.child("content").getValue(String.class);
                    String categoryStr = boardSnapshot.child("category").getValue(String.class);
                    String dateStr = boardSnapshot.child("date").getValue(String.class);
                    Integer likeStr = boardSnapshot.child("likes").getValue(Integer.class);
                    Integer commentStr = boardSnapshot.child("comments").getValue(Integer.class);

                    if(categoryStr.equals("정보게시판")){
                        InfoAdapter.addItem(titleStr, contentStr, nameStr, categoryStr, dateStr, likeStr, commentStr);
                    }
                    else if(categoryStr.equals("질문게시판")){
                        QaAdapter.addItem(titleStr, contentStr, nameStr, categoryStr, dateStr, likeStr, commentStr);
                    }
                    Log.i("TAG: value is ",titleStr+"/"+nameStr);
                }
                InfoAdapter.notifyDataSetChanged();
                QaAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w("FireBaseData", "loadPost:onCancelled", error.toException());

            }
        });
    }


    // Action Bar에 메뉴를 생성한다
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.list_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:  //좋아요 순으로 클릭한 경우
                Toast.makeText(this, "좋아요순으로 게시물을 정렬합니다.", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item2:  //날짜 순으로 클릭한 경우
                Toast.makeText(this, "날짜순으로 게시물을 정렬합니다.", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return true;
        }
    }
}