package codesver.springboot.common.exception;

import codesver.springboot.common.util.MessageTranslator;
import codesver.springboot.common.util.ApplicationContextProvider;
import lombok.Getter;

@Getter
public class RestException extends RuntimeException {

    private final ErrorCode errorCode;

    public RestException(ErrorCode errorCode, String message) {
        super(formatMessage(message));
        this.errorCode = errorCode;
    }

    public RestException(ErrorCode errorCode, String message, String... labels) {
        super(formatMessage(message, labels));
        this.errorCode = errorCode;
    }

    private static String formatMessage(String message) {
        MessageTranslator translator = getMessageTranslator();
        return translator.getMessage(message);
    }

    private static String formatMessage(String message, String... labels) {
        MessageTranslator translator = getMessageTranslator();
        return translator.getMessage(message, labels);
    }

    private static MessageTranslator getMessageTranslator() {
        return ApplicationContextProvider.getBean(MessageTranslator.class);
    }
}
