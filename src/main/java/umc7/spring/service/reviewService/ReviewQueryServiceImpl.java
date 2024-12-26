package umc7.spring.service.reviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc7.spring.apiPayload.code.exception.handler.MemberHandler;
import umc7.spring.apiPayload.code.exception.handler.StoreHandler;
import umc7.spring.apiPayload.code.status.ErrorStatus;
import umc7.spring.domain.Member;
import umc7.spring.domain.Review;
import umc7.spring.domain.Store;
import umc7.spring.repository.MemberRepository;
import umc7.spring.repository.ReviewRepository;
import umc7.spring.repository.StoreRepository;

@Service
@RequiredArgsConstructor
public class ReviewQueryServiceImpl implements  ReviewQueryService {

    private final ReviewRepository reviewRepository;

    private final StoreRepository storeRepository;

    private final MemberRepository memberRepository;

    @Override
    public Page<Review> getReviewList(Long storeId, Integer page) {

        Store store = storeRepository.findById(storeId) .orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));
        Page<Review> storePage = reviewRepository.findAllByStore(store, PageRequest.of(page, 10));

        return storePage;
    }

    @Override
    public Page<Review> getMyReviewList(Long memberId, Integer page) {

        Member member = memberRepository.findById(memberId) .orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));
        Page<Review> memberPage = reviewRepository.findAllByMember(member, PageRequest.of(page, 10));

        return memberPage;
    }
}
