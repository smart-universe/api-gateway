package com.api.apigateway.filters;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ServerWebExchange;

import com.api.apigateway.models.AuthRequest;
import com.api.apigateway.models.AuthResponse;

import reactor.core.publisher.Mono;

@Component
public class AuthenticationFilter extends AbstractGatewayFilterFactory<AuthenticationFilter.Config> {

	public AuthenticationFilter() {
		super(Config.class);
	}

	@Autowired
	private RestTemplate restTemplate;

	private boolean isAuthorizationValid(String authorizationHeader) {
		boolean isValid = true;

		/*
		 * Commenting this one out temproraly will implement this filter later after
		 * this commit AuthRequest body = new AuthRequest(authorizationHeader);
		 * System.out.println();
		 * 
		 * AuthResponse response =
		 * restTemplate.postForObject("lb://auth-service/auth/checkValidity", body,
		 * AuthResponse.class);
		 * 
		 * if (response.isAuthenticated()) { isValid = true; }
		 */
		return isValid;

	}

	private Mono<Void> onError(ServerWebExchange exchange, String err, HttpStatus httpStatus) {
		ServerHttpResponse response = exchange.getResponse();
		response.setStatusCode(httpStatus);

		return response.setComplete();
	}

	@Override
	public GatewayFilter apply(Config config) {
		return (exchange, chain) -> {
			ServerHttpRequest request = exchange.getRequest();

			if (!request.getHeaders().containsKey("Authorization")) {
				return this.onError(exchange, "No Authorization header", HttpStatus.UNAUTHORIZED);
			}
			;

			String authorizationHeader = request.getHeaders().get("Authorization").get(0).substring(7);

			if (!this.isAuthorizationValid(authorizationHeader)) {
				return this.onError(exchange, "Invalid Authorization header", HttpStatus.UNAUTHORIZED);
			}

			return chain.filter(exchange);
		};
	}

	public static class Config {
		// Put the configuration properties
	}
}
