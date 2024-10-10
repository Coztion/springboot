package codesver.springboot.domain.member.application.service;

import codesver.springboot.domain.member.application.model.command.MemberSearchCommand;
import codesver.springboot.domain.member.domain.Members;

public interface MemberService {
    Members searchMembers(MemberSearchCommand searchCommand);
}
