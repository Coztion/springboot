package codesver.springboot.domain.member.application.repository;

import codesver.springboot.domain.member.domain.Members;
import codesver.springboot.domain.member.infrastructure.model.condition.MemberSearchCondition;

public interface MemberRepository {
    Members searchMembers(MemberSearchCondition condition);
}
