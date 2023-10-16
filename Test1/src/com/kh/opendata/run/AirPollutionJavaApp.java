package com.kh.opendata.run;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class AirPollutionJavaApp {

	public static final String serviceKey = "UNmnLkcNtzgMKivBzvyb3TdrsqmthwquJWOHYpkKXK6aXtSdhG1gbTQ6EOqATL5t3ApCJ2hySkej4pCTXuaAZg%3D%3D";
	
	public static void main(String[] args) throws IOException {
		
		String url = "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty";
		url += "?serviceKey=" + " 서비스키";
		url += "&sidoName=" + URLEncoder.encode("서울","UTF-8");
		url += "&returnType=json";
		
		URL requestUrl = new URL(url);
		HttpURLConnection urlConnection = (HttpURLConnection)requestUrl.openConnection();
		urlConnection.setRequestMethod("GET");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
		String line = null;
		while((line = br.readLine()) != null) {
			System.out.println(line);
		}
		br.close();
		urlConnection.disconnect();
		
	}

}
