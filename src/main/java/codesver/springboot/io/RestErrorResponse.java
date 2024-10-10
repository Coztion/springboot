package codesver.springboot.io;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor(staticName = "of")
public class RestErrorResponse {

    private int code;
    private String name;
    private String message;
}
