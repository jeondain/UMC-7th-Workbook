package umc7.spring.service.reviewService;

import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import umc7.spring.domain.Review;

public interface ReviewQueryService {
    @Transactional
    Page<Review> getReviewList(Long storeId, Integer page);

    Page<Review> getMyReviewList(Long memberId, Integer page);
}
