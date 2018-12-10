package com.soch.Integra.dto;

public class APMBaseResponse {
	
	private Integer responseCode;
	private  String responseString;
	public Integer getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(Integer responseCode) {
		this.responseCode = responseCode;
	}
	public String getResponseString() {
		return responseString;
	}
	public void setResponseString(String responseString) {
		this.responseString = responseString;
	}


}
