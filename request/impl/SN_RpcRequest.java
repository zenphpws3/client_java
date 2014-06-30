package com.dogstar.shakenext.apiclient.request.impl;

import android.util.Log;

import com.dogstar.shakenext.apiclient.SN_Params;
import com.dogstar.shakenext.apiclient.org.phprpc.*;
import com.dogstar.shakenext.apiclient.request.SN_Request;

public class SN_RpcRequest implements SN_Request {
	protected String _rpcResult = null;
	protected int _msTimeout = 3000;
	
	public String call(SN_Params params) throws Exception {
		String url = params.getUrl();
		Log.v("SN_RpcRequest url", url);
		PHPRPC_Client client = new PHPRPC_Client(url); 
		client.setTimeout(this._msTimeout);
		SN_ZenWebService service = (SN_ZenWebService)client.useService(SN_ZenWebService.class);
		return service.response();
	}
	
	public void setTimeout(int timeoutMillis) {
		this._msTimeout = (timeoutMillis > 0 && timeoutMillis < 600000) ? timeoutMillis : this._msTimeout;
	}
}
