package com.dogstar.shakenext.apiclient;

public class SN_Response {
	public enum SN_Response_Status {
		OK, FAIL, WRONG, ERROR, UNKOWN
	}
	
	protected SN_Response_Status _status = SN_Response_Status.UNKOWN;
	protected String _error = "";
	
	protected String _data = "";
	protected String _debug = "";

	public void setStatus(SN_Response_Status status) {
		this._status = status;
	}
	
	public void setStatus(String status) {
		if (status.equals("OK")) {
			this._status = SN_Response_Status.OK;
		} else if (status.equals("FAIL")) {
			this._status = SN_Response_Status.FAIL;
		} else if (status.equals("WRONG")) {
			this._status = SN_Response_Status.WRONG;
		} else if (status.equals("ERROR")) {
			this._status = SN_Response_Status.ERROR;
		} else {
			this._status = SN_Response_Status.UNKOWN;
		}
	}

	public SN_Response_Status getStatus() {
		return this._status;
	}
	
	public void setError(String error) {
		this._error = error;
	}

	public String getError() {
		return this._error;
	}
	
	public void setData(String data) {
		this._data = data;
	}
	
	public String getData() {
		return this._data;
	}
	
	public void setDebug(String debug) {
		this._debug = debug;
	}
	
	public String getDebug() {
		return this._debug;
	}
	
	
}
