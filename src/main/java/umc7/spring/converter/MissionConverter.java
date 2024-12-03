package umc7.spring.converter;

import umc7.spring.domain.Member;
import umc7.spring.domain.Mission;
import umc7.spring.domain.enums.MissionStatus;
import umc7.spring.domain.mapping.MemberMission;
import umc7.spring.web.dto.MissionRequestDTO;
import umc7.spring.web.dto.MissionResponseDTO;

import java.time.LocalDateTime;

public class MissionConverter {

    public static MissionResponseDTO.ChallengeMissionResultDto toMemberMissionResultDTO (MemberMission memberMission){
        return MissionResponseDTO.ChallengeMissionResultDto.builder()
                .memberMissionId(memberMission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static MemberMission toMemberMissionDTO (MissionRequestDTO.ChallengeMissionDto request, Member member, Mission mission){
        return MemberMission.builder()
                .member(member)
                .mission(mission)
                .status(MissionStatus.CHALLENGING)
                .build();
    }
}
