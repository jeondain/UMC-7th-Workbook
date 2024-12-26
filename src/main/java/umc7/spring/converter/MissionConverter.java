package umc7.spring.converter;

import org.springframework.data.domain.Page;
import umc7.spring.domain.Member;
import umc7.spring.domain.Mission;
import umc7.spring.domain.enums.MissionStatus;
import umc7.spring.domain.mapping.MemberMission;
import umc7.spring.web.dto.MissionRequestDTO;
import umc7.spring.web.dto.MissionResponseDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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

    public static MissionResponseDTO.MissionPreviewDto toMissionPreviewDTO (Mission mission){
        return MissionResponseDTO.MissionPreviewDto.builder()
                .missionId(mission.getId())
                .missionSpec(mission.getMissionSpec())
                .reward(mission.getReward())
                .createdAt(mission.getCreatedAt())
                .build();
    }

    public static MissionResponseDTO.MissionPreviewListDto toMissionPreviewListDTO (Page<Mission> missionList){

        List<MissionResponseDTO.MissionPreviewDto> missionPreViewDTOList = missionList.stream()
                .map(MissionConverter::toMissionPreviewDTO).collect(Collectors.toList());

        return MissionResponseDTO.MissionPreviewListDto.builder()
                .isLast(missionList.isLast())
                .isFirst(missionList.isFirst())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .listSize(missionPreViewDTOList.size())
                .missionList(missionPreViewDTOList)
                .build();
    }
}
