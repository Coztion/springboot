package codesver.springboot.member.infrastructure.model.condition;

import codesver.springboot.member.application.model.command.MemberSearchCommand;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberSearchCondition {

    private Set<Long> memberIds;

    private Set<String> usernames;

    private Set<String> emails;

    public static MemberSearchCondition from(MemberSearchCommand searchCommand) {
        return MemberSearchCondition.builder()
                .memberIds(Objects.requireNonNullElse(searchCommand.getMemberIds(), Collections.emptySet()))
                .usernames(Objects.requireNonNullElse(searchCommand.getUsernames(), Collections.emptySet()))
                .emails(Objects.requireNonNullElse(searchCommand.getEmails(), Collections.emptySet()))
                .build();
    }
}
