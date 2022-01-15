package com.api.apigateway.models;

import java.io.Serializable;

public class AuthResponse implements Serializable {

	private boolean isValidated;

	private static final long serialVersionUID = 1L;

	private int resultCode;

	private String resultMessage;

	public AuthResponse() {
		super();

	}

	public AuthResponse(boolean isValidated, int resultCode, String resultMessage) {
		super();
		this.isValidated = isValidated;
		this.resultCode = resultCode;
		this.resultMessage = resultMessage;
	}

	public boolean isValidated() {
		return isValidated;
	}

	public void setValidated(boolean isValidated) {
		this.isValidated = isValidated;
	}

	public int getResultCode() {
		return resultCode;
	}

	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultMessage() {
		return resultMessage;
	}

	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}

	@Override
	public String toString() {
		return "AuthResponse [isValidated=" + isValidated + ", resultCode=" + resultCode + ", resultMessage="
				+ resultMessage + "]";
	}

}
