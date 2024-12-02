package umc7.spring.service.reviewService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc7.spring.apiPayload.code.exception.handler.MemberHandler;
import umc7.spring.apiPayload.code.exception.handler.StoreHandler;
import umc7.spring.apiPayload.code.status.ErrorStatus;
import umc7.spring.converter.ReviewConverter;
import umc7.spring.domain.Member;
import umc7.spring.domain.Review;
import umc7.spring.domain.Store;
import umc7.spring.repository.MemberRepository;
import umc7.spring.repository.ReviewRepository;
import umc7.spring.repository.StoreRepository;
import umc7.spring.web.dto.ReviewRequestDTO;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements  ReviewCommandService {
    private final ReviewRepository reviewRepository;

    private final StoreRepository storeRepository;

    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public Review createReview(ReviewRequestDTO.ReviewDto request, Long memberId) {

        Member member = memberRepository.findById(memberId).orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));
        Store store = storeRepository.findById(request.getStoreId()).orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));
        Review newReview = ReviewConverter.toReviewDTO(request, member, store);

        return reviewRepository.save(newReview);
    }
}
