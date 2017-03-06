package net.floodlightcontroller.notification.syslog;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

import org.json.simple.JSONObject;

public class SyslogNotificationHandler {
	//Notification Message를 서버로 보내기 위해 만든 클래스 !!!!!!!!!!!!!
	String server_url = "http://164.125.68.23:8080/log";
	URL url;
	URLConnection con ;
	OutputStreamWriter wr;
	BufferedReader rd;
	JSONObject params;	
	
	public void sendLogMessage(String msg){
		try {
			url = new URL(server_url);
			con = url.openConnection();
			con.setRequestProperty("Content-Type", "application/json");
			con.setDoOutput(true);
			wr = new OutputStreamWriter(con.getOutputStream());
			params = new JSONObject();
			params.put("log", msg);
			wr.write(params.toJSONString());
			wr.flush();
			
			rd = new BufferedReader(new InputStreamReader(con.getInputStream(),"UTF-8"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
