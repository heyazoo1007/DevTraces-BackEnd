package com.devtraces.arterest.common.response;

import com.devtraces.arterest.common.exception.ErrorCode;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ApiErrorResponse<T> {
	@JsonProperty("errorCode")
	private String code;
	@JsonProperty("errorMessage")
	private String message;
	private T data;	// TODO: Exception에 Generic(T)를 전달할 방법을 찾지 못함

	public static <T> ApiErrorResponse<T> from(ErrorCode errorCode, T data) {
		return ApiErrorResponse.<T>builder()
			.code(errorCode.getCode())
			.message(errorCode.getMessage())
			.data(data)
			.build();
	}

	public static ApiErrorResponse<?> from(ErrorCode errorCode) {
		return ApiErrorResponse.builder()
			.code(errorCode.getCode())
			.message(errorCode.getMessage())
			.build();
	}
}
