package com.seoul.festival;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

public class FestivalActivity extends TabActivity {
	
	private TabHost tabHost;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        tabHost = getTabHost();
        tabHost.addTab(tabHost.newTabSpec("홈").setIndicator("홈", getResources().getDrawable(R.drawable.home)).setContent(new Intent(this,FestivalHomeActivity.class)));
        tabHost.addTab(tabHost.newTabSpec("소개").setIndicator("소개", getResources().getDrawable(R.drawable.profile)).setContent(new Intent(this,FestivalDescActivity.class)));
        tabHost.addTab(tabHost.newTabSpec("행사").setIndicator("행사", getResources().getDrawable(R.drawable.gallery)).setContent(new Intent(this, FestivalListActivity.class)));
        tabHost.addTab(tabHost.newTabSpec("더보기").setIndicator("더보기", getResources().getDrawable(R.drawable.more)).setContent(new Intent(this, FestivalMoreActivity.class)));
        tabHost.setCurrentTab(4);
    }
}