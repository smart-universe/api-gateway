package com.api.apigateway.models;

public class AuthRequest {

	private String jwt;

	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}

	public AuthRequest(String jwtToken) {
		super();
		this.jwt = jwtToken;
	}

	@Override
	public String toString() {
		return "AuthRequest [jwtToken=" + jwt + "]";
	}

}
