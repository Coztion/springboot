package codesver.springboot.member.domain;

import java.util.List;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.CollectionUtils;

@Getter
@Setter
@Builder(access = AccessLevel.PRIVATE)
public class Members {

    private List<Member> members;

    public static Members of(List<Member> members) {
        return Members.builder().members(members).build();
    }

    public List<Member> values() {
        return members;
    }

    public Member getMember() {
        if (CollectionUtils.isEmpty(members)) throw new RuntimeException();

        return members.stream().findFirst().orElseThrow(RuntimeException::new);
    }
}
