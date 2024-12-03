package umc7.spring.service.memberMissionService;

import jakarta.transaction.Transactional;
import umc7.spring.domain.mapping.MemberMission;
import umc7.spring.web.dto.MissionRequestDTO;

public interface MemberMissionCommandService {
    @Transactional
    MemberMission challengeMission(MissionRequestDTO.ChallengeMissionDto request, Long memberId);
}
