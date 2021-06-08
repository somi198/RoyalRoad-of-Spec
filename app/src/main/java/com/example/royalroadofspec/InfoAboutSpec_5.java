package com.example.royalroadofspec;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;

public class InfoAboutSpec_5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_about_spec_5);

        TabHost tabHost = (TabHost) findViewById(R.id.tabhost);
        tabHost.setup();

        TabHost.TabSpec tabjob = tabHost.newTabSpec("EMPLOYMENT");
        tabjob.setContent(R.id.tab_job);
        tabjob.setIndicator("취업 정보");
        tabHost.addTab(tabjob);

        TabHost.TabSpec tabspec = tabHost.newTabSpec("SPEC");
        tabspec.setContent(R.id.tab_spec);
        tabspec.setIndicator("스펙 정보");
        tabHost.addTab(tabspec);

        tabHost.setCurrentTab(0);
    }

    public void KoreaEmploymentSite_go(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.moel.go.kr/index.do"));
        startActivity(intent);
    }


    public void employmentSite1_go(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.saramin.co.kr/zf_user/"));
        startActivity(intent);
    }

    public void employmentSite2_go(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.jobkorea.co.kr/"));
        startActivity(intent);
    }


    public void employmentCommunity1_go(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://m.cafe.daum.net/breakjob"));
        startActivity(intent);
    }

    public void employmentCommunity2_go(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://m.cafe.naver.com/specup"));
        startActivity(intent);
    }

    public void employmentCommunity3_go(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://cafe.naver.com/dokchi"));
        startActivity(intent);
    }


    public void specInfoSite1_go(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://linkareer.com/"));
        startActivity(intent);
    }

    public void specInfoSite2_go(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.campuspick.com/"));
        startActivity(intent);
    }

    public void specInfoSite3_go(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.wevity.com/"));
        startActivity(intent);
    }
}
