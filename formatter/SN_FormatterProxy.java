package com.dogstar.shakenext.apiclient.formatter;

import com.dogstar.shakenext.apiclient.SN_Response;
import com.dogstar.shakenext.apiclient.SN_Response.SN_Response_Status;

public class SN_FormatterProxy {
	protected SN_Formatter _formatter;
	
	public SN_FormatterProxy(SN_Formatter formatter) {
		this._formatter = formatter;
	}
	
	public SN_Response parse(String result) {
		SN_Response response = new SN_Response();
		try {
			response = this._formatter.parse(result);
		} catch (Exception ex) {
			response.setStatus(SN_Response_Status.ERROR);
			response.setError(ex.getMessage());
		}
		return response;
	}
}
