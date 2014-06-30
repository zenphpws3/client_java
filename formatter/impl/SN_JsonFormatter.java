package com.dogstar.shakenext.apiclient.formatter.impl;

import org.json.JSONObject;

import com.dogstar.shakenext.apiclient.SN_Response;
import com.dogstar.shakenext.apiclient.formatter.SN_Formatter;

public class SN_JsonFormatter implements SN_Formatter {
	public SN_Response parse(String result) throws Exception {
		SN_Response response = new SN_Response();
		
		JSONObject jsonObj = new JSONObject(result);
		response.setStatus(jsonObj.getString("status"));
		response.setData(jsonObj.getString("data"));
		response.setError(jsonObj.getString("error"));
		response.setDebug(jsonObj.getString("debug"));
			
		return response;
	}
}
