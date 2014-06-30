package com.dogstar.shakenext.apiclient.formatter;

import com.dogstar.shakenext.apiclient.SN_Response;

public interface SN_Formatter {
	public SN_Response parse(String result)  throws Exception;
}
