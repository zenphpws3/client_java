package com.dogstar.shakenext.apiclient.formatter.impl;

import com.dogstar.shakenext.apiclient.SN_Response;
import com.dogstar.shakenext.apiclient.formatter.SN_Formatter;

public class SN_NoneFormatter implements SN_Formatter {
	public SN_Response parse(String result) throws Exception {
		throw new Exception("Try to parse with none formatter");
	}
}
