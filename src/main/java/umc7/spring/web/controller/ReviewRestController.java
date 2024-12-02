package umc7.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc7.spring.apiPayload.ApiResponse;
import umc7.spring.converter.ReviewConverter;
import umc7.spring.domain.Review;
import umc7.spring.service.reviewService.ReviewCommandService;
import umc7.spring.validation.annotation.ExistMember;
import umc7.spring.web.dto.ReviewRequestDTO;
import umc7.spring.web.dto.ReviewResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewRestController {
    private final ReviewCommandService reviewCommandService;

    @PostMapping("/")
    public ApiResponse<ReviewResponseDTO.ReviewResultDto> createReview(@RequestBody @Valid ReviewRequestDTO.ReviewDto request,
                                                                       @ExistMember @RequestParam(name = "memberId") Long memberId) {
        Review review = reviewCommandService.createReview(request, memberId);
        return ApiResponse.onSuccess(ReviewConverter.toReviewResultDTO(review));
    }
}

