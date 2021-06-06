package com.example.royalroadofspec;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TabHost;
import android.app.ActionBar;
import android.app.TabActivity;

@SuppressWarnings("deprecation")

public class InfoAboutSpec extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_about_spec);

        Button button = (Button) findViewById(R.id.newActivity);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), community_space_4.class);
                startActivity(intent);
            }
        });


        TabHost tabHost = getTabHost();


        TabHost.TabSpec tabEmploy = tabHost.newTabSpec("EMPLOYMENT").setIndicator("취업");
        tabEmploy.setContent(R.id.employmentTab);
        tabHost.addTab(tabEmploy);

        TabHost.TabSpec tabSpec = tabHost.newTabSpec("SPEC").setIndicator("스펙");
        tabSpec.setContent(R.id.specTab);
        tabHost.addTab(tabSpec);

        tabHost.setCurrentTab(0);

    }

    public void KoreaEmploymentSiteGo(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.moel.go.kr/index.do"));
        startActivity(intent);
    }

    public void employmentSite1Go(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.saramin.co.kr/zf_user/"));
        startActivity(intent);
    }

    public void employmentSite2Go(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.work.go.kr/seekWantedMain.do"));
        startActivity(intent);
    }

    public void employmentSite3Go(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.jobkorea.co.kr/"));
        startActivity(intent);
    }

    public void employmentInfoCommunity1Go(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://m.cafe.daum.net/breakjob"));
        startActivity(intent);
    }

    public void employmentInfoCommunity2Go(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://cafe.naver.com/dokchi"));
        startActivity(intent);
    }

    public void employmentInfoCommunity3Go(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://m.cafe.naver.com/specup"));
        startActivity(intent);
    }

    public void specInfoSite1Go(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://linkareer.com/"));
        startActivity(intent);
    }

    public void specInfoSite2Go(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.campuspick.com/"));
        startActivity(intent);
    }

    public void specInfoSite3Go(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.wevity.com/"));
        startActivity(intent);
    }
}
