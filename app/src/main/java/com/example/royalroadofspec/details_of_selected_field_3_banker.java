package com.example.royalroadofspec;

import android.app.TabActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;

@SuppressWarnings("deprecation")

public class details_of_selected_field_3_banker extends TabActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_details_of_selected_field3_banker);


            Button button = (Button) findViewById(R.id.newActivity);
            button.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(),FinanceListView_2.class);
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
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.thebigstudy.com/00_study/?utm_source=%ED%8C%8C%EC%9B%8C%EB%A7%81%ED%81%AC&utm_medium=%EC%97%B0%EA%B2%B0URL_%EC%9D%80%ED%96%89/%EC%B7%A8%EC%97%85%EC%9D%B8%EA%B0%95&utm_campaign=%EC%98%A8%EC%98%A4%ED%94%84%EB%9D%BC%EC%9D%B8%EA%B0%95%EC%9D%98%EB%A9%94%EC%9D%B8&n_media=27758&n_query=%EC%9D%80%ED%96%89%EC%9D%B8%EA%B0%95&n_rank=1&n_ad_group=grp-a001-01-000000012184564&n_ad=nad-a001-01-000000099618092&n_keyword_id=nkw-a001-01-000002250121006&n_keyword=%EC%9D%80%ED%96%89%EC%9D%B8%EA%B0%95&n_campaign_type=1&n_ad_group_type=1&NaPm=ct%3Dkpkrki28%7Cci%3D0yW00026mpLuV1804L2%5F%7Ctr%3Dsa%7Chk%3D2bb056b769764351454877f208a9fa0badbf427f"));
            startActivity(intent);
        }

        public void botton2(View view) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://public.hackers.com/event/?k=finance&_C_=147096&utm_source=naver_ad_pc&utm_medium=kwd&utm_campaign=pub_fn_ingang_financeallinone190318&_AT=0003010A00C0028F71E3"));
            startActivity(intent);
        }

        public void botton3(View view) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.topbanker.co.kr/?NaPm=ct%3Dkpkrivf4%7Cci%3D0zi0000UmpLuOcq1if2B%7Ctr%3Dsa%7Chk%3D741514ca6f504762bccee007e69b94485dc65f8c"));
            startActivity(intent);
        }

        public void botton4(View view) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.aladin.co.kr/shop/wproduct.aspx?ItemId=266535183"));
            startActivity(intent);
        }

        public void botton5(View view) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.aladin.co.kr/shop/wproduct.aspx?ItemId=270556958"));
            startActivity(intent);
        }

        public void botton6(View view) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.aladin.co.kr/shop/wproduct.aspx?ItemId=270302822"));
            startActivity(intent);
        }

        public void botton7(View view) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.smarthanafn.com/"));
            startActivity(intent);
        }

        public void botton8(View view) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://docs.google.com/forms/d/1dYrrTZ3wIyRKxxHMM_e7XARw0IAzFdyWDt1Zfy1rFmI/viewform?edit_requested=true"));
            startActivity(intent);
        }

        public void botton9(View view) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.campuspick.com/activity?keyword=%EA%B8%88%EC%9C%B5"));
            startActivity(intent);
        }

        public void botton10(View view) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.kbi.or.kr/platformWeb/Qual.do?cmd=openPage&pageName=qualInfo&p_iQlfn=04"));
            startActivity(intent);
        }

        public void botton11(View view) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.kbi.or.kr/platformWeb/Qual.do?cmd=openPage&pageName=qualInfo&p_iQlfn=07"));
            startActivity(intent);
        }
}
