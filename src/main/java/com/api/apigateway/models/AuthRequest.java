package com.api.apigateway.models;

public class AuthRequest {

	private String jwtToken;

	public String getJwtToken() {
		return jwtToken;
	}

	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}

	public AuthRequest(String jwtToken) {
		super();
		this.jwtToken = jwtToken;
	}

	@Override
	public String toString() {
		return "AuthRequest [jwtToken=" + jwtToken + "]";
	}

}
