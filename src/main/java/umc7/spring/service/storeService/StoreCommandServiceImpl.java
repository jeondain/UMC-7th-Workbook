package umc7.spring.service.storeService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc7.spring.converter.StoreConverter;
import umc7.spring.domain.Region;
import umc7.spring.domain.Store;
import umc7.spring.repository.RegionRepository;
import umc7.spring.repository.StoreRepository;
import umc7.spring.web.dto.StoreRequestDTO;

@Service
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService {
    private final StoreRepository storeRepository;

    private final RegionRepository regionRepository;

    @Override
    @Transactional
    public Store addStore(StoreRequestDTO.AddStoreDto request) {

        Region region = regionRepository.findByName(request.getName());
        Store newStore = StoreConverter.toStoreDTO(request, region);

        return storeRepository.save(newStore);
    }
}
