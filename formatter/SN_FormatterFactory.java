package com.dogstar.shakenext.apiclient.formatter;

import com.dogstar.shakenext.apiclient.formatter.impl.SN_JsonFormatter;
import com.dogstar.shakenext.apiclient.formatter.impl.SN_NoneFormatter;
import com.dogstar.shakenext.apiclient.formatter.impl.SN_XmlFormatter;


public class SN_FormatterFactory {
	public static SN_Formatter create(String type) {
		if (type == null) {
			type = "none";
		}
		
		type = type.toLowerCase();
		
		if (type.equals("json")) {
			return new SN_JsonFormatter();
		} else if (type.equals("xml")) {
			return new SN_XmlFormatter();
		}
		
		return new SN_NoneFormatter();
	}
}
