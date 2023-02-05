package com.devtraces.arterest.common.exception;

import com.devtraces.arterest.common.response.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestControllerAdvice(annotations = RestController.class)
public class ErrorController {

	@ExceptionHandler(BaseException.class)
	protected ResponseEntity<ApiErrorResponse> handleBaseException(BaseException e) {
		return ResponseEntity
			.status(e.getHttpStatus())
			.body(ApiErrorResponse.from(e.getErrorCode()));
	}

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(RuntimeException.class)
	protected ApiErrorResponse handleRuntimeException(RuntimeException e) {
		log.error(e.getMessage());
		return ApiErrorResponse.from(ErrorCode.INTERNAL_SERVER_ERROR);
	}
}
