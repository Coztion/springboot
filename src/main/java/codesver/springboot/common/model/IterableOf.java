package codesver.springboot.common.model;

import java.util.List;

public abstract class IterableOf<T> {

    private List<T> values;

    public List<T> values() {
        return values;
    }
}
