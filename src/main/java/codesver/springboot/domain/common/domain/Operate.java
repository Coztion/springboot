package codesver.springboot.domain.common.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public abstract class Operate<T> {

    private T createTargets;

    private T updateTargets;

    private T deleteTargets;
}
