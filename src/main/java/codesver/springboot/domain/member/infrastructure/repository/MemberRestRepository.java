package codesver.springboot.domain.member.infrastructure.repository;

import codesver.springboot.domain.member.application.repository.MemberRepository;
import codesver.springboot.domain.member.domain.Member;
import codesver.springboot.domain.member.domain.Members;
import codesver.springboot.domain.member.infrastructure.model.condition.MemberSearchCondition;
import codesver.springboot.domain.member.infrastructure.model.entity.MemberEntity;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@RequiredArgsConstructor
public class MemberRestRepository implements MemberRepository {

    private final MemberQueryRepository queryRepository;

    @Override
    @Transactional(readOnly = true)
    public Members searchMembers(MemberSearchCondition condition) {
        List<MemberEntity> memberEntities = queryRepository.searchMembers(
                condition.getMemberIds(), condition.getUsernames(), condition.getEmails());

        List<Member> members =
                memberEntities.stream().map(MemberEntity::toDomain).toList();

        return Members.of(members);
    }
}
