package com.microservice.wastemanagerauthorization.servicies;

import com.microservice.wastemanagerauthorization.dto.WasteManagerAuthorizationDTO;
import com.microservice.wastemanagerauthorization.entities.WasteManagerAuthorization;

import java.util.List;
import java.util.Optional;

public interface IWasteManagerAuthorizationService {
    WasteManagerAuthorization findById(Long id);
    List<WasteManagerAuthorization> findAll();
    Optional<WasteManagerAuthorization> update(WasteManagerAuthorization wasteManager);
    WasteManagerAuthorization save(WasteManagerAuthorizationDTO wasteManagerDTO);

}
