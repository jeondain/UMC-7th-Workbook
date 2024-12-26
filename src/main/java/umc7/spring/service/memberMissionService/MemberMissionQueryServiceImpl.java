package umc7.spring.service.memberMissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc7.spring.apiPayload.code.exception.handler.MemberHandler;
import umc7.spring.apiPayload.code.status.ErrorStatus;
import umc7.spring.domain.Member;
import umc7.spring.domain.Mission;
import umc7.spring.domain.enums.MissionStatus;
import umc7.spring.repository.MemberMissionRepository;
import umc7.spring.repository.MemberRepository;

@Service
@RequiredArgsConstructor
public class MemberMissionQueryServiceImpl implements MemberMissionQueryService {
    private final MemberMissionRepository memberMissionRepository;

    private final MemberRepository memberRepository;

    @Override
    public Page<Mission> getChallengingMissionList(Long memberId, Integer page) {

        Member member = memberRepository.findById(memberId) .orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));

        Page<Mission> challengingMissionPage = memberMissionRepository.findChallengingMissionsByMember(
                member, MissionStatus.CHALLENGING, PageRequest.of(page, 10)
        );

        return challengingMissionPage;
    }
}
