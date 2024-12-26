package umc7.spring.service.memberMissionService;

import org.springframework.data.domain.Page;
import umc7.spring.domain.Mission;

public interface MemberMissionQueryService {
    Page<Mission> getChallengingMissionList(Long memberId, Integer page);
}
