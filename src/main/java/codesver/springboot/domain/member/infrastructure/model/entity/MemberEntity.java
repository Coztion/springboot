package codesver.springboot.domain.member.infrastructure.model.entity;

import codesver.springboot.domain.member.domain.Member;
import jakarta.persistence.*;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
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

    public static MemberEntity fromDomain(Member member) {
        return MemberEntity.builder()
                .memberId(member.getMemberId())
                .username(member.getUsername())
                .password(member.getPassword())
                .build();
    }

    public Member toDomain() {
        return Member.builder()
                .memberId(memberId)
                .username(username)
                .email(email)
                .build();
    }

    public void update(Member member) {
        this.memberId = Objects.requireNonNullElse(member.getMemberId(), memberId);
        this.username = Objects.requireNonNullElse(member.getUsername(), username);
        this.email = Objects.requireNonNullElse(member.getEmail(), email);
    }
}
