package codesver.springboot.exception;

import codesver.springboot.io.RestErrorResponse;
import codesver.springboot.util.MessageTranslator;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@RequiredArgsConstructor
public class RestExceptionAdvice {

    private final MessageTranslator translator;

    private static final String INTERNAL_SERVER_ERROR = "message.common.error.internalServerError";

    @ExceptionHandler(RestException.class)
    public RestErrorResponse handleRestException(RestException e) {
        ErrorCode errorCode = e.getErrorCode();
        return RestErrorResponse.of(errorCode.getCode(), errorCode.getName(), e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public RestErrorResponse handleException(Exception e) {
        ErrorCode errorCode = ErrorCode.INTERNAL_SERVER_ERROR;
        return RestErrorResponse.of(
                errorCode.getCode(), errorCode.getName(), translator.getMessage(INTERNAL_SERVER_ERROR));
    }
}
