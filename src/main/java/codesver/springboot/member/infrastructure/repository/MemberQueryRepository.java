package codesver.springboot.member.infrastructure.repository;

import codesver.springboot.member.infrastructure.model.entity.MemberEntity;
import codesver.springboot.member.infrastructure.model.entity.QMemberEntity;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberQueryRepository {

    private final JPAQueryFactory query;

    public List<MemberEntity> searchMembers(Set<Long> memberIds, Set<String> usernames, Set<String> emails) {
        QMemberEntity member = QMemberEntity.memberEntity;

        return query.selectFrom(member)
                .where(member.memberId.in(memberIds), member.username.in(usernames), member.email.in(emails))
                .fetch();
    }
}
