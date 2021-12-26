package com.api.apigateway.models;

public class AuthResponse {
	private boolean isAuthenticated;

	@Override
	public String toString() {
		return "AuthResponse [isAuthenticated=" + isAuthenticated + "]";
	}

	public AuthResponse(boolean isAuthenticated) {
		super();
		this.isAuthenticated = isAuthenticated;
	}

	public boolean isAuthenticated() {
		return isAuthenticated;
	}

	public void setAuthenticated(boolean isAuthenticated) {
		this.isAuthenticated = isAuthenticated;
	}

}
