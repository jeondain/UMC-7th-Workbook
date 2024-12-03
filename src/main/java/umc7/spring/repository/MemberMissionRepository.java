package umc7.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc7.spring.domain.mapping.MemberMission;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {
}
