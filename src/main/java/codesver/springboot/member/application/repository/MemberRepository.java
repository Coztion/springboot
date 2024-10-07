package codesver.springboot.member.application.repository;

import codesver.springboot.member.domain.Members;
import codesver.springboot.member.infrastructure.model.condition.MemberSearchCondition;

public interface MemberRepository {
    Members searchMembers(MemberSearchCondition condition);
}
