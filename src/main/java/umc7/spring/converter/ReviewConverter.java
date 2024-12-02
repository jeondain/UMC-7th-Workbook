package umc7.spring.converter;

import umc7.spring.domain.Member;
import umc7.spring.domain.Review;
import umc7.spring.domain.Store;
import umc7.spring.web.dto.ReviewRequestDTO;
import umc7.spring.web.dto.ReviewResponseDTO;

import java.time.LocalDateTime;

public class ReviewConverter {
    public static ReviewResponseDTO.ReviewResultDto toReviewResultDTO (Review review){
        return ReviewResponseDTO.ReviewResultDto.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Review toReviewDTO (ReviewRequestDTO.ReviewDto request, Member member, Store store){
        return Review.builder()
                .member(member)
                .store(store)
                .title(request.getTitle())
                .score(request.getScore())
                .body(request.getBody())
                .build();
    }
}
