package codesver.springboot.common.model.io;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor(staticName = "of")
public class RestResponse<T> {

    private final T resource;
}
