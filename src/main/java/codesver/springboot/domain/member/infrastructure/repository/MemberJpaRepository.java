package codesver.springboot.domain.member.infrastructure.repository;

import codesver.springboot.domain.member.infrastructure.model.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberJpaRepository extends JpaRepository<MemberEntity, Long> {}
