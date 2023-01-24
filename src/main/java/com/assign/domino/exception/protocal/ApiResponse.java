package com.assign.domino.exception.protocal;

public class ApiResponse<T> {
	private T data;

	private ApiResponse() {
	}

	public ApiResponse(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}
}