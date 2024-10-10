package codesver.springboot.domain.common.domain;

import codesver.springboot.exception.ErrorCode;
import codesver.springboot.exception.RestException;
import java.util.List;
import lombok.experimental.SuperBuilder;
import org.springframework.util.CollectionUtils;

@SuperBuilder
public abstract class Iterable<T> {

    protected List<T> values;

    private static final String VALUE_NOT_FOUND = "message.common.iterable.valueNotFound";
    private static final String MULTI_VALUE_FOUND = "message.common.iterable.multiValueFound";

    public List<T> values() {
        return values;
    }

    public T value() {
        if (isEmpty()) throw new RestException(ErrorCode.BUSINESS_SERVER, VALUE_NOT_FOUND);

        if (values.size() != 1) {
            throw new RestException(ErrorCode.BUSINESS_SERVER, MULTI_VALUE_FOUND);
        }

        return values.stream().findFirst().get();
    }

    public boolean isEmpty() {
        return CollectionUtils.isEmpty(values);
    }
}
