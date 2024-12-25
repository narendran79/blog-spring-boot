package com.example.Blog.GlobalException;

import org.springframework.stereotype.Component;

@Component
public class ApiError {

	private String error;
	
	protected ApiError() {
		super();
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
	
}
