package com.devtraces.arterest.common.exception;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

	INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "INTERNAL_SERVER_ERROR", "예상치 못한 서버 에러가 발생했습니다.");

	private final HttpStatus httpStatus;
	private final String code;
	private final String message;
}
