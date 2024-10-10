package codesver.springboot.exception;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ErrorCode {
    FORBIDDEN(403),
    NOT_FOUND(404),
    INTERNAL_SERVER_ERROR(500),
    BUSINESS_CLIENT(416),
    BUSINESS_SERVER(516);

    private final int errorCode;

    public int getCode() {
        return errorCode;
    }

    public String getName() {
        return this.name();
    }
}
