package codesver.springboot.domain.member.domain;

import codesver.springboot.domain.common.domain.Operate;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class OperateMembers extends Operate<Members> {

    public List<Member> getCreateMembers() {
        return createTargets.values();
    }

    public Map<Long, Member> getUpdateMemberMap() {
        return updateTargets.values().stream().collect(Collectors.toMap(Member::getMemberId, Function.identity()));
    }

    public Set<Long> getUpdateMemberIds() {
        return updateTargets.getMemberIds();
    }

    public Set<Long> getDeleteMemberIds() {
        return deleteTargets.getMemberIds();
    }
}
