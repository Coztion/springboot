package codesver.springboot.common.io.model;

import java.util.List;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor(staticName = "of")
public class RestResponses<T> {

    private final List<T> resources;
}
