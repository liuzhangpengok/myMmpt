package com.mingkai.mmpt.dto;

import java.io.Serializable;


public class CommonResp<T> implements Serializable{
	private static final long serialVersionUID = 1L;
	public static final String SUCCESS_CODE = "0";
	public static final String COMMON_FAIL_CODE = "-1";
	public static final String PARAMETER_CODE = "-2";
	/**
	 * 0-成功，其他失败
	 */
	private String errorCode;
	private String errorMsg;
	private T respObject;
	/**
	 * 0-成功，其他失败
	 */
	public String getErrorCode() {
		return errorCode;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	/**
	 * 0-成功，其他失败
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public T getRespObject() {
		return respObject;
	}
	public void setRespObject(T respObject) {
		this.respObject = respObject;
	}

	public boolean isSuccess(){
		return CommonResp.SUCCESS_CODE.equals(this.getErrorCode());
	}

}
