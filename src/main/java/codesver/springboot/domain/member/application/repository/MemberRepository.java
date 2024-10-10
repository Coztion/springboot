package codesver.springboot.domain.member.application.repository;

import codesver.springboot.domain.member.domain.Members;
import codesver.springboot.domain.member.domain.SearchMembers;

public interface MemberRepository {
    Members searchMembers(SearchMembers search);
}
