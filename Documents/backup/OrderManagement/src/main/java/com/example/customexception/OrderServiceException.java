package com.example.customexception;

public class OrderServiceException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	private String ErrCode;
	private String ErrMsg;
	public String getErrCode(){
		return ErrCode;
	}
	
	
	
	@Override
	public String toString() {
		return "ItemException [ErrCode=" + ErrCode + ", ErrMsg=" + ErrMsg + "]";
	}



	public OrderServiceException(String errCode, String errMsg) {
		super();
		this.ErrCode = errCode;
		this.ErrMsg = errMsg;
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



	public void setErrCode(String errCode) {
		this.ErrCode = errCode;
	}



	public OrderServiceException()
	{
		
	}
	

}
