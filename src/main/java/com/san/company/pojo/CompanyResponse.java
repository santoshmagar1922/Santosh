package com.san.company.pojo;

public class CompanyResponse {

	private int statusCode;
	private int statusMessage;
	private Object data;

	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public int getStatusMessage() {
		return statusMessage;
	}
	public void setStatusMessage(int statusMessage) {
		this.statusMessage = statusMessage;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
}
