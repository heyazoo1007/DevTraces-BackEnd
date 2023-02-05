package com.devtraces.arterest.common.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ApiSuccessResponse<T> {

	public static final ApiSuccessResponse<?> NO_DATA_RESPONSE = new ApiSuccessResponse<>();

	private T data;

	public static <T> ApiSuccessResponse<T> from(T data) {
		return new ApiSuccessResponse<>(data);
	}
}
