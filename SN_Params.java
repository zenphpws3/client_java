package com.dogstar.shakenext.apiclient;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SN_Params {
	protected String _host = "";
	protected int _port = 80;
	
	protected Map<String, String> _data;
	
	
	private SN_Params() {
		this._data = new HashMap<String, String>();
	}

	public static SN_Params newInsance() {
		SN_Params params =  new SN_Params();
		
		//默认的情况下，以下初始化应和服务器保持一致
		params.withProtocol("http");
		params.withFormat("json");
		
		return params;
	}
	
	public static SN_Params newInsance(String host) {
		SN_Params params = SN_Params.newInsance();
		
		params.withHost(host);
		
		return params;
	}

	public String getUrl() {
		return this._host + ":" + this._port + "/index.php?" + this._createQuery();
	}
	
	public SN_Params set(String key, String value) {
		if (this._isUserParams(key)) {
			this.setQuery(key, value);
		}
		return this;
	}
	
	public SN_Params withHost(String host) {
		this._host = host!= null ? host.trim() : this._host;
		return this;
	}
	
	public SN_Params withPort(int port) {
		this._port = port > 0 ? port : this._port;
		return this;
	}
	
	public SN_Params withProtocol(String protocol) {
		this.setQuery("p", protocol);
		return this;
	}
	
	public SN_Params withLang(String lang) {
		this.setQuery("l",lang);
		return this;
	}
	
	public SN_Params withAction(String action) {
		this.setQuery("a", action);
		return this;
	}
	
	public SN_Params withController(String controller) {
		this.setQuery("c", controller);
		return this;
	}
	
	public SN_Params withFormat(String format) {
		this.setQuery("f", format);
		return this;
	}
	
	public SN_Params withKey(String key) {
		this.setQuery("k", key);
		return this;
	}
	
	public SN_Params withTime() {
		this.setQuery("t", System.currentTimeMillis() + "");
		return this;
	}
	
	public SN_Params withToken(String token) {
		this.setQuery("z", token);
		return this;
	}
	
	public String get(String key) {
		return (key != null && key.length() > 0 && this._data.containsKey(key)) ?  this._data.get(key) : null;
	}
	
	protected void setQuery(String key, String value) {
		if (key != null && key.length() > 0) {
			this._data.put(key, value);
		}
	}
	
	protected String _createQuery() {
		Iterator it = this._data.entrySet().iterator();
		String query = "";
		while (it.hasNext()) {
			Map.Entry<String, String> entry = (Map.Entry<String, String>) it.next();
			query += entry.getKey() + "=" + entry.getValue() + "&";
		}
		return query.length() > 0 ? query.substring(0, query.length() - 1) : query;
	}
	
	protected boolean _isUserParams(String key) {
		return key != null && key.length() > 1;
	}
	
}
