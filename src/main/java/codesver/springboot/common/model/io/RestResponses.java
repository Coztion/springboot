package codesver.springboot.common.model.io;

import java.util.List;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor(staticName = "of")
public class RestResponses<T> {

    private final List<T> resources;
}
