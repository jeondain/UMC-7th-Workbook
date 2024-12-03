package umc7.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc7.spring.apiPayload.ApiResponse;
import umc7.spring.converter.MissionConverter;
import umc7.spring.domain.mapping.MemberMission;
import umc7.spring.service.memberMissionService.MemberMissionCommandService;
import umc7.spring.service.missionService.MissionCommandService;
import umc7.spring.validation.annotation.ExistMember;
import umc7.spring.web.dto.MissionRequestDTO;
import umc7.spring.web.dto.MissionResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionRestController {

    private final MissionCommandService missionCommandService;
    private final MemberMissionCommandService memberMissionCommandService;

    @PostMapping("/")
    public ApiResponse<MissionResponseDTO.ChallengeMissionResultDto> challenge(@RequestBody @Valid MissionRequestDTO.ChallengeMissionDto request,
                                                                         @ExistMember @RequestParam(name = "memberId") Long memberId) {
        MemberMission memberMission = memberMissionCommandService.challengeMission(request, memberId);
        return ApiResponse.onSuccess(MissionConverter.toMemberMissionResultDTO(memberMission));
    }
}