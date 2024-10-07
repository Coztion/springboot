package codesver.springboot.member.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Member {

    private Long memberId;

    private String username;

    private String password;

    private String email;
}
