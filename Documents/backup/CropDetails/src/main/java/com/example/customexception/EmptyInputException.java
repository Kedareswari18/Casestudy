package com.example.customexception;

public class EmptyInputException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ErrCode;
	private String ErrMsg;
	
	
	
	
	public EmptyInputException(String errCode, String errMsg) {
		super();
		ErrCode = errCode;
		ErrMsg = errMsg;
	}
	
	public EmptyInputException() {
		
	}
		
	
	
	@Override
	public String toString() {
		return "EmptyInputException [ErrCode=" + ErrCode + ", ErrMsg=" + ErrMsg + "]";
	}
	public String getErrCode() {
		return ErrCode;
	}
	public void setErrCode(String errCode) {
		ErrCode = errCode;
	}
	public String getErrMsg() {
		return ErrMsg;
	}
	public void setErrMsg(String errMsg) {
		ErrMsg = errMsg;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

}
