package umc7.spring.domain.mapping;

import jakarta.persistence.*;
import lombok.*;
import umc7.spring.domain.Member;
import umc7.spring.domain.Mission;
import umc7.spring.domain.Store;
import umc7.spring.domain.common.BaseEntity;
import umc7.spring.domain.enums.MissionStatus;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberMission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private MissionStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id")
    private Mission mission;
}
