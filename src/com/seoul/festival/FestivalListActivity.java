package com.seoul.festival;

import java.lang.ref.WeakReference;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.seoul.festival.common.*;

public class FestivalListActivity extends Activity implements OnItemClickListener{

	private String[] itemList;
	
	private String[] linkList;
	
	private ListView listview;
	private ArrayAdapter<String> arrayAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.more);
		listview = (ListView) findViewById(R.id.list_more);
		listview.setOnItemClickListener(this);

		Thread thread = new Thread(new Runnable() {
			public void run() {
				URLConn urlConn = new URLConn("http://openapi.seoul.go.kr:8088/44516e725a617469393879447a4367/xml/SearchConcertDetailService/1/20/");
				itemList = urlConn.getAPI("TITLE");
				if( itemList != null && itemList[0] != "nothing"){
					linkList = urlConn.getAPI("ORG_LINK");

				}
				handler.sendEmptyMessage(0);
			}
		});
		thread.start();
	}
	
	static class MyInnerHandler extends Handler{
    	WeakReference<FestivalListActivity> mFrag;

    	MyInnerHandler(FestivalListActivity aFragment) {
    		mFrag = new WeakReference<FestivalListActivity>(aFragment);
    	}
    	@Override
		public void handleMessage(Message msg) {
    		FestivalListActivity theFrag = mFrag.get();
    		theFrag.arrayAdapter = new ArrayAdapter<String>(theFrag.getBaseContext(), android.R.layout.simple_list_item_1, theFrag.itemList);
    		theFrag.listview.setAdapter(theFrag.arrayAdapter);

    	}
    }
    MyInnerHandler handler = new MyInnerHandler(this);

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int position, long id) {
		Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(linkList[position]));
		startActivity(intent);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		android.os.Process.killProcess(android.os.Process.myPid());
	}
	
}
