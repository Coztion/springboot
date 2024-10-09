package codesver.springboot.common.message;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Message {
    BUSINESS_ERROR("message.common.business.exception");

    private final String messageCode;
}
