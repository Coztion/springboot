package codesver.springboot.domain.member.domain;

import codesver.springboot.domain.common.domain.Iterable;
import java.util.List;
import lombok.experimental.SuperBuilder;

@SuperBuilder
public class Members extends Iterable<Member> {
    public static Members of(List<Member> members) {
        return Members.builder().values(members).build();
    }
}
