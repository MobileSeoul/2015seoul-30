package com.seoul.festival.common;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

import android.text.Html;
import android.util.Log;

public class URLConn{

	private String api_url;
	private HashMap<String, String[]> url_cache = null;

	public URLConn(String api_url){
		this.api_url = api_url;
	}

	public String selector(String data, String start, String end){
		int t = data.indexOf(start);
		int s_pos = 0;
		if( t != -1){
			s_pos = t + start.length();
		}else{
			return "";
		}
		t = data.indexOf(end,s_pos);
		if( t != -1){
			return data.substring(s_pos,t);
		}else{
			return "";
		}
	}

	public String[] getAPI(String name){
		if( url_cache == null){
			url_cache = new HashMap<String,String[]>();
		}
		String[] item = url_cache.get(api_url);
		String[] result = {""};
		try{
			String start = "<" + name + ">";
			String end = "</" + name + ">";
			if( item == null){
				String[] strs = {api_url};
				URL url;
				HttpURLConnection connection;
				Log.e("tst", api_url);

				String xml = "";
				url = new URL(strs[0]);
				connection = (HttpURLConnection) url.openConnection();
				try {
					if(connection != null) {
						connection.setUseCaches(true);
						connection.setConnectTimeout(5000);
						connection.setReadTimeout(7000);
						connection.setRequestProperty("Connection", "close");

						BufferedInputStream bis = new BufferedInputStream(connection.getInputStream());

						byte[] buf = new byte[4096];
						int len;
						if(bis != null) {
							while((len = bis.read(buf,0,4096)) > 0) {

								xml += (new String(buf,0,len));

							}
							try {
								bis.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
						connection.disconnect();
					}
				} finally {
				}
				if( xml.length() < 6){
					result[0] = "nothing";
					return result;
				}
				item = xml.split("<row>");
				if( item != null && item.length > 0){
					url_cache.put(api_url, item);	
				}else{
					result[0] = "nothing";
					return result;
				}
			}
			int len = item.length;
			String title = "";
			String res = "";
			String temp = "";

			for(int i = 1 ; i < len ; i++){
				title = selector(item[i], start,end);
				res = selector(title,"<![CDATA[","]]>");
				if( res != ""){
					temp = temp + res + "<sep>";
				}else{
					if( title != ""){
						title = Html.fromHtml(title).toString().replace("&#39;", "'");
						temp = temp + title + "<sep>";
					}
				}
			}

			temp = temp.replace("amp;", "");
			if( temp.length() > 5){
				String[] result1 = temp.split("<sep>");
				result = result1;
			}
			else result[0] = "nothing";

		}catch(Exception e){
			e.printStackTrace();
			result = null;
		}
		return result;
	}
}