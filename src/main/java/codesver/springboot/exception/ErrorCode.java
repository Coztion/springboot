package codesver.springboot.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    FORBIDDEN(403),
    NOT_FOUND(404),
    BUSINESS_CLIENT(416),
    BUSINESS_SERVER(516);

    private final int errorCode;
}
