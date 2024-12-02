package umc7.spring.service.reviewService;

import jakarta.transaction.Transactional;
import umc7.spring.domain.Review;
import umc7.spring.web.dto.ReviewRequestDTO;

public interface ReviewCommandService {
    @Transactional
    Review createReview(ReviewRequestDTO.ReviewDto request, Long memberId);
}
