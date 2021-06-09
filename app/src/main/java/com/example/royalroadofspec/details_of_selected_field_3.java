package com.example.royalroadofspec;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;
import android.app.ActionBar;
import android.app.TabActivity;

@SuppressWarnings("deprecation")

public class details_of_selected_field_3 extends TabActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_details_of_selected_field3);


            Button button = (Button) findViewById(R.id.newActivity);
            button.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), ITListView_2.class);
                    startActivity(intent);
                }
            });


            TabHost tabHost = getTabHost();


            TabHost.TabSpec tabSpecSong = tabHost.newTabSpec("PRESENT").setIndicator("추천 커리큘럼");
            tabSpecSong.setContent(R.id.tabSong);
            tabHost.addTab(tabSpecSong);

            TabHost.TabSpec tabSpecArtist = tabHost.newTabSpec("STUDYING").setIndicator("공부하기");
            tabSpecArtist.setContent(R.id.tabArtist);
            tabHost.addTab(tabSpecArtist);

            TabHost.TabSpec tabSpecAlbum = tabHost.newTabSpec("QUALIFICATION").setIndicator("스펙 쌓기");
            tabSpecAlbum.setContent(R.id.tabAlbum);
            tabHost.addTab(tabSpecAlbum);

            tabHost.setCurrentTab(0);

        }

        public void botton1(View view) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.inflearn.com/?NaPm=ct%3Dkpdmyfca%7Cci%3Dcheckout%7Ctr%3Dds%7Ctrx%3D%7Chk%3D8085f39aa99f9e8c4f611f14d0dd7116467bbaf4"));
            startActivity(intent);
        }

        public void botton2(View view) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://megaitacademy.com/?n_media=27758&n_query=%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D%ED%95%99%EC%9B%90&n_rank=2&n_ad_group=grp-a001-01-000000020180072&n_ad=nad-a001-01-000000125792784&n_keyword_id=nkw-a001-01-000003533080822&n_keyword=%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D%ED%95%99%EC%9B%90&n_campaign_type=1&n_ad_group_type=1&NaPm=ct%3Dkpdmzolk%7Cci%3D0z80000rNFjuv34Y5v3p%7Ctr%3Dsa%7Chk%3D1333babf7590b2f1d6b24cbf0d6ea1f85aabefaa"));
            startActivity(intent);
        }

        public void botton3(View view) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.koreaitacademy.com/?n_media=27758&n_query=%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D%ED%95%99%EC%9B%90&n_rank=2&n_ad_group=grp-a001-01-000000018276463&n_ad=nad-a001-01-000000135444455&n_keyword_id=nkw-a001-01-000003290012928&n_keyword=%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D%ED%95%99%EC%9B%90&n_campaign_type=1&n_ad_group_type=1&NaPm=ct%3Dkpe7emxk%7Cci%3D0Au0000dj%5Fnu3vuFQLml%7Ctr%3Dsa%7Chk%3Df6ad686572f4e2631c1ffb54534b3e5b2488a2a1"));
            startActivity(intent);
        }

        public void botton4(View view) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.aladin.co.kr/shop/wproduct.aspx?ItemId=204819510"));
            startActivity(intent);
        }

        public void botton5(View view) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.aladin.co.kr/shop/wproduct.aspx?ItemId=134157277"));
            startActivity(intent);
        }

        public void botton6(View view) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.aladin.co.kr/shop/wproduct.aspx?ItemId=138287372"));
            startActivity(intent);
        }

        public void botton7(View view) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/groups/dsckorea/"));
            startActivity(intent);
        }

        public void botton8(View view) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.likelion.net/vietnam"));
            startActivity(intent);
        }

        public void botton9(View view) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.campuspick.com/contest?category=108"));
            startActivity(intent);
        }

        public void botton10(View view) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.oracle.com/java/technologies/"));
            startActivity(intent);
        }

        public void botton11(View view) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dataq.or.kr/www/sub/a_04.do"));
            startActivity(intent);
        }
}
