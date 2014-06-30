package com.dogstar.shakenext.apiclient.request;

import com.dogstar.shakenext.apiclient.SN_Params;

public interface SN_Request {
	public String call(SN_Params params) throws Exception;
	public void setTimeout(int timeoutMillis);
}
