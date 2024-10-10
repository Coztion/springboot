package codesver.springboot.domain.member.domain;

import codesver.springboot.domain.common.domain.Iterable;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.experimental.SuperBuilder;

@SuperBuilder
public class Members extends Iterable<Member> {
    public static Members of(List<Member> members) {
        return Members.builder().values(members).build();
    }

    public Set<Long> getMemberIds() {
        return values.stream().map(Member::getMemberId).collect(Collectors.toSet());
    }
}
