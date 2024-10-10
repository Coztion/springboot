package codesver.springboot.domain.member.presentation.model.value;

import codesver.springboot.domain.member.domain.Member;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PublicMember {

    private Long memberId;

    private String username;

    private String email;

    public static PublicMember from(Member member) {
        return PublicMember.builder()
                .memberId(member.getMemberId())
                .username(member.getUsername())
                .email(member.getEmail())
                .build();
    }
}
