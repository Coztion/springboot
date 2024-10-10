package codesver.springboot.domain.common.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public abstract class Operate<T> {

    protected T createTargets;

    protected T updateTargets;

    protected T deleteTargets;
}
