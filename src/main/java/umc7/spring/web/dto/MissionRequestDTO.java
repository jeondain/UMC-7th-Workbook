package umc7.spring.web.dto;

import lombok.Getter;
import umc7.spring.validation.annotation.ExistMission;

public class MissionRequestDTO {

    @Getter
    public static class ChallengeMissionDto{
        @ExistMission
        private Long missionId;
    }
}
