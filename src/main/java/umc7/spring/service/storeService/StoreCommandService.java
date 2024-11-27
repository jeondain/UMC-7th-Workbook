package umc7.spring.service.storeService;

import umc7.spring.domain.Store;
import umc7.spring.web.dto.StoreRequestDTO;

public interface StoreCommandService {
    Store addStore(StoreRequestDTO.AddStoreDto request);
}
