package com.microservice.wastemanagerauthorization.servicies;

import com.microservice.wastemanagerauthorization.dto.WasteManagerAuthorizationDTO;
import com.microservice.wastemanagerauthorization.entities.WasteManagerAuthorization;
import com.microservice.wastemanagerauthorization.repositories.WasteManagerAuthorizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WasteManagerAuthorizationServiceImpl implements IWasteManagerAuthorizationService{

    @Autowired
    private WasteManagerAuthorizationRepository repository;
    @Override
    public WasteManagerAuthorization findById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public List<WasteManagerAuthorization> findAll() {
        return (List<WasteManagerAuthorization>) repository.findAll();
    }

    @Override
    public Optional<WasteManagerAuthorization> update(WasteManagerAuthorization wasteManager) {
        Optional<WasteManagerAuthorization> wasteManagerAuthorization = repository.findById(wasteManager.getId());

        if(wasteManagerAuthorization.isPresent()){
            WasteManagerAuthorization wasteManagerAuthorization1 = wasteManagerAuthorization.orElseThrow();
            wasteManagerAuthorization1.setId(wasteManager.getId());
            wasteManagerAuthorization1.setAuthorizationNumber(wasteManager.getAuthorizationNumber());

            return Optional.of(repository.save(wasteManagerAuthorization1));
        }

        return wasteManagerAuthorization;
    }

    @Override
    public WasteManagerAuthorization save(WasteManagerAuthorizationDTO wasteManagerDTO) {
        WasteManagerAuthorization wasteManagerAuthorization = new WasteManagerAuthorization().builder()
                .authorizationNumber(wasteManagerDTO.getAuthorizationNumber())
                .build();

        return  repository.save(wasteManagerAuthorization);
    }
}
