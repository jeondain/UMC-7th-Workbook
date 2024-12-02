package umc7.spring.web.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc7.spring.validation.annotation.ExistStore;

public class ReviewRequestDTO {

    @Getter
    public static class ReviewDto {
        @NotNull
        String title;
        @Min(1)
        @Max(5)
        Float score;
        String body;
        @ExistStore
        Long storeId;
    }
}
