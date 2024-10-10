package codesver.springboot.domain.member.presentation.model.request;

import codesver.springboot.domain.member.application.model.command.MemberSearchCommand;
import java.util.Set;

public record MemberSearchRequest(Set<Long> memberIds, Set<String> usernames, Set<String> emails) {
    public MemberSearchCommand toCommand() {
        return MemberSearchCommand.builder()
                .memberIds(memberIds)
                .usernames(usernames)
                .emails(emails)
                .build();
    }
}
