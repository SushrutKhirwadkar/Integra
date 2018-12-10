package com.soch.Integra.exception;

public class APMException extends Exception{
	
	private String errorMsg;
	
	public APMException(String errorMsg)
	{
		this.errorMsg = errorMsg;
	}
	
	public String getErrorMessage()
	{
		return errorMsg;
	}
}
