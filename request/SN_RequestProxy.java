package com.dogstar.shakenext.apiclient.request;

import com.dogstar.shakenext.apiclient.SN_Params;

import android.util.Log;

public class SN_RequestProxy {
	protected SN_Request _request;
	protected int _retryTimes = 3;
	
	public SN_RequestProxy(SN_Request request) {
		this._request = request;
	}
	
	public String call(SN_Params params) {
		Log.v("[SN_HttpRequest retryTimes]", "" + this._retryTimes);
		String result = null;
		
		for (int i = 0; i < this._retryTimes; i ++) {
			try {
				result = this._request.call(params);
				break;
			/*} catch (SocketTimeoutException ex) {
				
			*/} catch (Exception ex) {
				ex.printStackTrace();
				continue;
			}
		}
		
		return result;
	}
	
	public void setRetryTimes(int retryTimes) {
		this._retryTimes = retryTimes > 0 ? retryTimes : this._retryTimes;
	}
}
