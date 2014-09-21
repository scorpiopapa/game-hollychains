package com.bt.chains.exception;

import com.joinway.bean.exception.InternalException;

public class RequestException extends InternalException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4045034322694693767L;

	public RequestException(String code, String msg){
		super(msg);
		this.code = Integer.valueOf(code);
	}

	public int getCode() {
		return code;
	}
}
