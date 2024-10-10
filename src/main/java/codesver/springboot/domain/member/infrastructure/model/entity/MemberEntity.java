package codesver.springboot.domain.member.infrastructure.model.entity;

import codesver.springboot.domain.member.domain.Member;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "member")
public class MemberEntity {

    @Id
    @Column(name = "member_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Column(name = "username", unique = true, nullable = false, updatable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    public Member toDomain() {
        return Member.builder()
                .memberId(memberId)
                .username(username)
                .email(email)
                .build();
    }
}
