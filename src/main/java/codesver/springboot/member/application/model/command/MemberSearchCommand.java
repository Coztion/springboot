package codesver.springboot.member.application.model.command;

import java.util.Set;
import lombok.*;

@Data
@Builder
public class MemberSearchCommand {

    private Set<Long> memberIds;

    private Set<String> usernames;

    private Set<String> emails;
}
