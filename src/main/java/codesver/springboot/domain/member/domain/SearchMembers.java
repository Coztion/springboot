package codesver.springboot.domain.member.domain;

import java.util.Set;
import lombok.*;

@Getter
@Setter
@Builder
public class SearchMembers {

    private Set<Long> memberIds;

    private Set<String> usernames;

    private Set<String> emails;
}
