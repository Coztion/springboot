package codesver.springboot.common.message;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MessageTranslator {

    private final MessageSource messageSource;

    public String getMessage(Message message) {
        return messageSource.getMessage(message.getMessageCode(), null, LocaleContextHolder.getLocale());
    }

    public String getMessage(Message message, String[] labels) {
        return messageSource.getMessage(message.getMessageCode(), labels, LocaleContextHolder.getLocale());
    }

    public String getMessage(String messageCode) {
        return messageSource.getMessage(messageCode, null, LocaleContextHolder.getLocale());
    }

    public String getMessage(String messageCode, String[] labels) {
        return messageSource.getMessage(messageCode, labels, LocaleContextHolder.getLocale());
    }
}
