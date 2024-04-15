package com.microservice.wastemanager.services;

import com.microservice.wastemanager.dto.AuthorizationDTO;
import com.microservice.wastemanager.entities.WasteManagerAuthorization;
import com.microservice.wastemanager.repositories.WasteManagerAuthorizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WasteManagerAuthorizationServiceImpl implements IWasteManagerAuthorizationService{

    @Autowired
    private WasteManagerAuthorizationRepository repository;
    @Override
    public Optional<WasteManagerAuthorization> findById(Long id) {
        return repository.findById(id);
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
    public WasteManagerAuthorization save(AuthorizationDTO wasteManagerDTO) {
        WasteManagerAuthorization wasteManagerAuthorization = new WasteManagerAuthorization().builder()
                .authorizationNumber(wasteManagerDTO.getAuthorizationNumber())
                .build();

        return  repository.save(wasteManagerAuthorization);
    }

//    @Override
//    public List<WasteManagerAuthorization> findAllByIdWasteManager(Long idWasteManager) {
//        return repository.findAllByIdWasteManager(idWasteManager);
//    }
}
