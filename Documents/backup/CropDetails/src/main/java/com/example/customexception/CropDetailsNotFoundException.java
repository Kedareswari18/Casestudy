package com.example.customexception;

public class CropDetailsNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ErrCode;
	private String ErrMsg;
	
	
	public CropDetailsNotFoundException() {
		
	}
	
	public CropDetailsNotFoundException(String errCode, String errMsg) {
		super();
		this.ErrCode = errCode;
		this.ErrMsg = errMsg;
	}
	@Override
	public String toString() {
		return "CropDetailsNotFoundException [ErrCode=" + ErrCode + ", ErrMsg=" + ErrMsg + "]";
	}
	public String getErrCode() {
		return ErrCode;
	}
	public void setErrCode(String errCode) {
		this.ErrCode = errCode;
	}
	public String getErrMsg() {
		return ErrMsg;
	}
	public void setErrMsg(String errMsg) {
		this.ErrMsg = errMsg;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	

}
