package com.dogstar.shakenext.apiclient.request.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import android.util.Log;

import com.dogstar.shakenext.apiclient.SN_Params;
import com.dogstar.shakenext.apiclient.request.SN_Request;

public class SN_HttpRequest implements SN_Request{
	protected int _msTimeout = 3000;
	
	public String call(SN_Params params) throws Exception {
		String result = null;
		URL url = null;
		HttpURLConnection connection = null;
		InputStreamReader in = null;
		String requestUrl = params.getUrl();
		Log.v("SN_HttpRequest requestUrl", requestUrl);
		
		url = new URL(requestUrl);
		connection = (HttpURLConnection) url.openConnection();
		connection.setConnectTimeout(this._msTimeout);
		in = new InputStreamReader(connection.getInputStream());
		BufferedReader bufferedReader = new BufferedReader(in);
		StringBuffer strBuffer = new StringBuffer();
		String line = null;
		while ((line = bufferedReader.readLine()) != null) {
			strBuffer.append(line);
		}
		result = strBuffer.toString();
		if (connection != null) {
			connection.disconnect();
		}
		
		if (in != null) {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	public void setTimeout(int timeoutMillis) {
		this._msTimeout = (timeoutMillis > 0 && timeoutMillis < 600000) ? timeoutMillis : this._msTimeout;
	}
}
