package codesver.springboot.domain.member.presentation.model.response;

import codesver.springboot.domain.member.domain.Members;
import codesver.springboot.domain.member.presentation.model.value.PublicMember;
import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MemberSearchResponse {

    private List<PublicMember> members;

    public static MemberSearchResponse from(Members members) {
        return MemberSearchResponse.builder()
                .members(members.values().stream().map(PublicMember::from).toList())
                .build();
    }
}
