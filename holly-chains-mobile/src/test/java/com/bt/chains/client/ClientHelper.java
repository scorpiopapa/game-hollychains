package com.bt.chains.client;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

public final class ClientHelper {

	public static <T> HttpEntity<T> getHttpEntity(T object) {
		HttpEntity<T> entity = new HttpEntity<T>(object, getHeaders());
		return entity;
	}

	public static <T> HttpEntity<T> getHttpEntity(Class<T> clz) {
		HttpEntity<T> entity = new HttpEntity<T>(getHeaders());
		return entity;
	}
	
	public static HttpHeaders getHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		headers.add("key", "value");
		return headers;
	}
}
