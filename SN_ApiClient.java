package com.dogstar.shakenext.apiclient;

import com.dogstar.shakenext.apiclient.SN_Response.SN_Response_Status;
import com.dogstar.shakenext.apiclient.formatter.SN_Formatter;
import com.dogstar.shakenext.apiclient.formatter.SN_FormatterFactory;
import com.dogstar.shakenext.apiclient.formatter.SN_FormatterProxy;
import com.dogstar.shakenext.apiclient.request.SN_Request;
import com.dogstar.shakenext.apiclient.request.SN_RequestFactory;
import com.dogstar.shakenext.apiclient.request.SN_RequestProxy;

public class SN_ApiClient {
	protected static int DEFAULT_RETRY_TIMES = 3;
	protected static int DEFAULT_TIMEOUT_MS = 3000;
	
	protected static SN_ApiClient _instance = null;
	
	private SN_ApiClient() {
	}
	
	public static SN_ApiClient getInstance() {
		SN_ApiClient._load_instance();
		return SN_ApiClient._instance;
	}
	
	public SN_Response request(SN_Params params) {
		return this.request(params, SN_ApiClient.DEFAULT_TIMEOUT_MS, SN_ApiClient.DEFAULT_RETRY_TIMES);
	}
	
	public SN_Response request(SN_Params params, int timeoutMillis) {
		return this.request(params, SN_ApiClient.DEFAULT_TIMEOUT_MS);
	}
	
	public SN_Response request(SN_Params params, int timeoutMillis, int retryTimes) {
		SN_Response response = new SN_Response();
		
		try{
			
			SN_Request request = SN_RequestFactory.create(params.get("p"));
			request.setTimeout(timeoutMillis);
			
			SN_RequestProxy requestProxy = new SN_RequestProxy(request);
			requestProxy.setRetryTimes(retryTimes);
			
			String result = requestProxy.call(params);
			
			SN_Formatter formatter = SN_FormatterFactory.create(params.get("f"));
			SN_FormatterProxy formatterProxy = new SN_FormatterProxy(formatter);
					
			response = formatterProxy.parse(result);
			
		} catch (Exception ex) {
			ex.printStackTrace();
			response.setStatus(SN_Response_Status.ERROR);
			response.setError(ex.getMessage());
		}
		
		return response;
	}
	
	protected static void _load_instance() {
		if (SN_ApiClient._instance == null) {
			SN_ApiClient._instance = new SN_ApiClient();
		}
	}
	
}
