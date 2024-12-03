package umc7.spring.service.memberMissionService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc7.spring.apiPayload.code.exception.handler.MemberHandler;
import umc7.spring.apiPayload.code.exception.handler.MissionHandler;
import umc7.spring.apiPayload.code.status.ErrorStatus;
import umc7.spring.converter.MissionConverter;
import umc7.spring.domain.Member;
import umc7.spring.domain.Mission;
import umc7.spring.domain.mapping.MemberMission;
import umc7.spring.repository.MemberMissionRepository;
import umc7.spring.repository.MemberRepository;
import umc7.spring.repository.MissionRepository;
import umc7.spring.web.dto.MissionRequestDTO;

@Service
@RequiredArgsConstructor
public class MemberMissionCommandServiceImpl implements MemberMissionCommandService {
    private final MemberMissionRepository memberMissionRepository;

    private final MissionRepository missionRepository;

    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public MemberMission challengeMission(MissionRequestDTO.ChallengeMissionDto request, Long memberId) {

        Member member = memberRepository.findById(memberId).orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));
        Mission mission = missionRepository.findById(request.getMissionId()).orElseThrow(() -> new MissionHandler(ErrorStatus.MISSION_NOT_FOUND));
        MemberMission newMemberMission = MissionConverter.toMemberMissionDTO(request, member, mission);

        return memberMissionRepository.save(newMemberMission);
    }
}