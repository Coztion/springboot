package codesver.springboot.domain.member.application.model.command;

import codesver.springboot.domain.member.domain.SearchMembers;
import java.util.Set;
import lombok.*;

@Data
@Builder
public class MemberSearchCommand {

    private Set<Long> memberIds;

    private Set<String> usernames;

    private Set<String> emails;

    public SearchMembers toDomain() {
        return SearchMembers.builder()
                .memberIds(memberIds)
                .usernames(usernames)
                .emails(emails)
                .build();
    }
}
