package umc7.spring.converter;

import umc7.spring.domain.Region;
import umc7.spring.domain.Store;
import umc7.spring.web.dto.StoreRequestDTO;
import umc7.spring.web.dto.StoreResponseDTO;

import java.time.LocalDateTime;

public class StoreConverter {
    public static StoreResponseDTO.AddStoreResponseDTO toAddStoreResponseDTO(Store store){
        return StoreResponseDTO.AddStoreResponseDTO.builder()
                .storeId(store.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Store toStoreDTO(StoreRequestDTO.AddStoreDto request, Region region){
        return Store.builder()
                .name(request.getName())
                .address(request.getName())
                .region(region)
                .build();
    }
}
