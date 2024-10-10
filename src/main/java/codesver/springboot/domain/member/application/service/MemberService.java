package codesver.springboot.domain.member.application.service;

import codesver.springboot.domain.member.application.model.command.MemberSearchCommand;
import codesver.springboot.domain.member.domain.Members;

public interface MemberService {
    Members getMembers(MemberSearchCommand searchCommand);
}
