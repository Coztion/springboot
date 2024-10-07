package codesver.springboot.member.infrastructure.repository;

import codesver.springboot.member.infrastructure.model.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberJpaRepository extends JpaRepository<MemberEntity, Long> {}
