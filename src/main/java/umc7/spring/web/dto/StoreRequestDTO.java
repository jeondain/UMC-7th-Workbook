package umc7.spring.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc7.spring.validation.annotation.ExistRegion;

public class StoreRequestDTO {

    @Getter
    public static class AddStoreDto {
        @NotBlank
        String name;
        @NotNull
        String address;
        @NotNull
        @ExistRegion
        String regionName;
    }
}
