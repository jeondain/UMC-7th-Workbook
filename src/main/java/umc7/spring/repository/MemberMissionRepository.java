package umc7.spring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import umc7.spring.domain.Member;
import umc7.spring.domain.Mission;
import umc7.spring.domain.enums.MissionStatus;
import umc7.spring.domain.mapping.MemberMission;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {
    @Query("SELECT mm FROM MemberMission mm " +
            "JOIN Mission m ON mm.mission.id = m.id " +
            "WHERE mm.member = :member AND mm.status = :status")
    Page<Mission> findChallengingMissionsByMember(
            @Param("member") Member member,
            @Param("status") MissionStatus status,
            PageRequest pageRequest
    );
}
