package codesver.springboot.common.util;

import java.util.List;
import lombok.experimental.SuperBuilder;
import org.springframework.util.CollectionUtils;

@SuperBuilder
public class IterableOf<T> {

    protected List<T> values;

    public List<T> values() {
        return values;
    }

    public T value() {
        if (isEmpty()) throw new RuntimeException();

        if (values.size() > 1) {
            throw new RuntimeException();
        }

        return values.stream().findFirst().orElse(null);
    }

    public boolean isEmpty() {
        return CollectionUtils.isEmpty(values);
    }

    public boolean hasValue() {
        return !CollectionUtils.isEmpty(values);
    }
}
