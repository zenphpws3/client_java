package com.dogstar.shakenext.apiclient.request.impl;

import com.dogstar.shakenext.apiclient.SN_Params;
import com.dogstar.shakenext.apiclient.request.SN_Request;

public class SN_NoneRequest implements SN_Request {
	public String call(SN_Params params) throws Exception {
		throw new Exception("Try to call with none request");
	}

	public void setTimeout(int timeoutMillis) {
	}
}
