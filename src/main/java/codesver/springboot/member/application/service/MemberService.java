package codesver.springboot.member.application.service;

import codesver.springboot.member.application.model.command.MemberSearchCommand;
import codesver.springboot.member.domain.Members;

public interface MemberService {
    Members getMembers(MemberSearchCommand searchCommand);
}
