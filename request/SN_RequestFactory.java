package com.dogstar.shakenext.apiclient.request;

import com.dogstar.shakenext.apiclient.request.impl.SN_HttpRequest;
import com.dogstar.shakenext.apiclient.request.impl.SN_NoneRequest;
import com.dogstar.shakenext.apiclient.request.impl.SN_RpcRequest;


public class SN_RequestFactory {
	public static SN_Request create(String type) {
		if (type == null) {
			type = "none";
		}
		type = type.toLowerCase();
		
		if (type.equals("http")) {
			return new SN_HttpRequest();
		} else if (type.equals("rpc")) {
			return new SN_RpcRequest();
		} else if (type.equals("soap")) {
			//TODO
		}
		
		return new SN_NoneRequest();
	}
}
