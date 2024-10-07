package codesver.springboot.member.application.service;

import codesver.springboot.member.application.model.command.MemberSearchCommand;
import codesver.springboot.member.application.repository.MemberRepository;
import codesver.springboot.member.domain.Members;
import codesver.springboot.member.infrastructure.model.condition.MemberSearchCondition;
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
