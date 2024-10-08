package codesver.springboot.member.domain;

import codesver.springboot.common.model.value.IterableOf;
import java.util.List;
import lombok.experimental.SuperBuilder;

@SuperBuilder
public class Members extends IterableOf<Member> {
    public static Members of(List<Member> members) {
        return Members.builder().values(members).build();
    }
}
