package codesver.springboot.domain.member.application.service;

import codesver.springboot.domain.member.application.model.command.MemberSearchCommand;
import codesver.springboot.domain.member.application.repository.MemberRepository;
import codesver.springboot.domain.member.domain.Members;
import codesver.springboot.domain.member.infrastructure.model.condition.MemberSearchCondition;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberRestService implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    @Transactional(readOnly = true)
    public Members getMembers(MemberSearchCommand searchCommand) {
        MemberSearchCondition condition = MemberSearchCondition.from(searchCommand);
        return memberRepository.searchMembers(condition);
    }
}
