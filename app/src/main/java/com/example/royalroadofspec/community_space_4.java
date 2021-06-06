package com.example.royalroadofspec;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.IDNA;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Date;

@SuppressWarnings("deprecation")

public class community_space_4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community_space4);

        Button button = (Button) findViewById(R.id.newActivity);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), BoardsActivity.class);
                startActivity(intent);
            }
        });

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

        //게시판 글 추가
        long now = System.currentTimeMillis();
        Date date = new Date(now);

        //ListView
        ListView InfoView;
        ListView QaView;
        ListBoardAdapter InfoAdapter;
        ListBoardAdapter QaAdapter;

        InfoAdapter = new ListBoardAdapter();
        QaAdapter = new ListBoardAdapter();

        InfoView = (ListView) findViewById(R.id.infoList);
        QaView = (ListView) findViewById(R.id.questionList);
        InfoView.setAdapter(InfoAdapter);
        QaView.setAdapter(QaAdapter);

        InfoAdapter.addItem("S기업 현직자가 말해주는 꿀팁 마구마구마구 대방출",date, "공부왕", "4", "8");
        InfoAdapter.addItem("면접 유경험자 해주는 조언",date,"abc123", "3", "2");
        InfoAdapter.addItem("실무에서는 어떤 일?",date,"user3", "2", "0");

        QaAdapter.addItem("정보처리기사 자격증은 어떻게 따나요?",date, "컴공생", "3", "0");
        QaAdapter.addItem("공부하는 방법을 모르겠습니다.",date,"자격증초보", "1", "5");
        QaAdapter.addItem("학원 추천받아요",date,"somi", "2", "1");



        InfoView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ListBoardItem item = (ListBoardItem) parent.getItemAtPosition(position);

                String titleStr = item.getTitle();
                String timeStr = item.getTime();
                String nameStr = item.getName();
                String likeStr = item.getLike();
                String chatStr = item.getChat();


                Intent intent = new Intent(getApplicationContext(), community_detail.class);

                intent.putExtra("title", titleStr);
                intent.putExtra("time", timeStr);
                intent.putExtra("name", nameStr);
                intent.putExtra("like", likeStr);
                intent.putExtra("chat", chatStr);
                intent.putExtra("board", "정보게시판 >");
                startActivity(intent);

            }
        });

        QaView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ListBoardItem item = (ListBoardItem) parent.getItemAtPosition(position);

                String titleStr = item.getTitle();
                String timeStr = item.getTime();
                String nameStr = item.getName();
                String likeStr = item.getLike();
                String chatStr = item.getChat();


                Intent intent = new Intent(getApplicationContext(), community_detail.class);

                intent.putExtra("title", titleStr);
                intent.putExtra("time", timeStr);
                intent.putExtra("name", nameStr);
                intent.putExtra("like", likeStr);
                intent.putExtra("chat", chatStr);
                intent.putExtra("board", "질문게시판 >");
                startActivity(intent);
            }
        });



        writeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), write_space.class);
                startActivity(intent);
                //Toast.makeText(getActivity(), "button1: 글을 작성합니다.", Toast.LENGTH_SHORT).show();
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