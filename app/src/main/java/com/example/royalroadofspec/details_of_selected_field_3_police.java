package com.example.royalroadofspec;

import android.app.TabActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;

@SuppressWarnings("deprecation")

public class details_of_selected_field_3_police extends TabActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_details_of_selected_field3_police);


            Button button = (Button) findViewById(R.id.newActivity);
            button.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), OfficerListView_2.class);
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
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://kimcodi.kr/pmtion/full_pass_2021/pc/index.php"));
            startActivity(intent);
        }

        public void botton2(View view) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://epolice.hackers.com/site/event/2020/0804_0pass_v2/?_C_=404059&utm_source=naver_ad_pc&utm_medium=kwd&utm_campaign=test_subkwdpolice_police_0pass4_210503&_AT=02D5108801870300696F"));
            startActivity(intent);
        }

        public void botton3(View view) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://event.eduwill.net/freebook/C/Freebook_210113?utm_source=naver_ad_pc&utm_medium=cop_sa&utm_campaign=freebook_cop_2021&utm_content=cop_test_detail&utm_term=%EA%B2%BD%EC%B0%B0%EA%B3%B5%EB%AC%B4%EC%9B%90%ED%95%84%EA%B8%B0&n_media=27758&n_query=%EA%B2%BD%EC%B0%B0%EA%B3%B5%EB%AC%B4%EC%9B%90%ED%95%84%EA%B8%B0&n_rank=2&n_ad_group=grp-a001-01-000000019724544&n_ad=nad-a001-01-000000127980168&n_keyword_id=nkw-a001-01-000003474532299&n_keyword=%EA%B2%BD%EC%B0%B0%EA%B3%B5%EB%AC%B4%EC%9B%90%ED%95%84%EA%B8%B0&n_campaign_type=1&n_ad_group_type=1&NaPm=ct%3Dkpkq19mw%7Cci%3D0zi0001PjVLuJM4XWv3C%7Ctr%3Dsa%7Chk%3D75ed001cc8eeb30d28d93aab4527c365bc3afaac"));
            startActivity(intent);
        }

        public void botton4(View view) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.aladin.co.kr/shop/wproduct.aspx?ItemId=266271798"));
            startActivity(intent);
        }

        public void botton5(View view) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.aladin.co.kr/shop/wproduct.aspx?ItemId=265593352"));
            startActivity(intent);
        }

        public void botton6(View view) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.aladin.co.kr/shop/wproduct.aspx?ItemId=269376150"));
            startActivity(intent);
        }

        public void botton7(View view) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.kcg.go.kr/jungbucgh/na/ntt/selectNttInfo.do?nttSn=28121&mi=2641"));
            startActivity(intent);
        }

        public void botton8(View view) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/polinlove2/222211297859"));
            startActivity(intent);
        }

        public void botton9(View view) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.campuspick.com/contest?keyword=%EA%B2%BD%EC%B0%B0"));
            startActivity(intent);
        }

        public void botton10(View view) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.historyexam.go.kr/"));
            startActivity(intent);
        }

        public void botton11(View view) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://exam.toeic.co.kr/"));
            startActivity(intent);
        }
}
