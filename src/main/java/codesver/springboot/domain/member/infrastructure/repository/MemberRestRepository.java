package codesver.springboot.domain.member.infrastructure.repository;

import codesver.springboot.domain.member.application.repository.MemberRepository;
import codesver.springboot.domain.member.domain.Member;
import codesver.springboot.domain.member.domain.Members;
import codesver.springboot.domain.member.domain.OperateMembers;
import codesver.springboot.domain.member.domain.SearchMembers;
import codesver.springboot.domain.member.infrastructure.model.entity.MemberEntity;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@RequiredArgsConstructor
public class MemberRestRepository implements MemberRepository {

    private final MemberJpaRepository jpaRepository;
    private final MemberQueryRepository queryRepository;

    @Override
    @Transactional(readOnly = true)
    public Members searchMembers(SearchMembers search) {
        List<MemberEntity> memberEntities =
                queryRepository.searchMembers(search.getMemberIds(), search.getUsernames(), search.getEmails());

        List<Member> members =
                memberEntities.stream().map(MemberEntity::toDomain).toList();

        return Members.of(members);
    }

    @Override
    @Transactional
    public Members operateMembers(OperateMembers operate) {
        queryRepository.deleteMembers(operate.getDeleteMemberIds());

        Map<Long, Member> updateMembers = operate.getUpdateMemberMap();
        List<MemberEntity> updateMemberEntities = queryRepository.searchMembers(
                operate.getUpdateMemberIds(), Collections.emptySet(), Collections.emptySet());
        for (MemberEntity memberEntity : updateMemberEntities) {
            Member member = updateMembers.get(memberEntity.getMemberId());
            memberEntity.update(member);
        }

        List<MemberEntity> createMemberEntities = operate.getCreateMembers().stream()
                .map(MemberEntity::fromDomain)
                .toList();
        createMemberEntities = jpaRepository.saveAll(createMemberEntities);

        List<Member> members = Stream.of(updateMemberEntities, createMemberEntities)
                .flatMap(Collection::stream)
                .map(MemberEntity::toDomain)
                .toList();

        return Members.of(members);
    }
}
