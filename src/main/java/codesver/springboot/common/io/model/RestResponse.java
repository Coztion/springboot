package codesver.springboot.common.io.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor(staticName = "of")
public class RestResponse<T> {

    private final T resource;
}
