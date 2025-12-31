package com.stan.springbootcourse.http;

import lombok.Data;

@Data
public class StanHttpResponse {


	private int responseCode;
	private String responseBodyAsString;

	public int getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}

	public String getResponseBodyAsString() {
		return responseBodyAsString;
	}

	public void setResponseBodyAsString(String responseBodyAsString) {
		this.responseBodyAsString = responseBodyAsString;
	}
}
