package com.microservice.wastemanager.services;

import com.microservice.wastemanager.dto.AuthorizationDTO;
import com.microservice.wastemanager.entities.WasteManagerAuthorization;

import java.util.List;
import java.util.Optional;

public interface IWasteManagerAuthorizationService {
    Optional<WasteManagerAuthorization> findById(Long id);
    List<WasteManagerAuthorization> findAll();
    Optional<WasteManagerAuthorization> update(WasteManagerAuthorization wasteManager);
    WasteManagerAuthorization save(AuthorizationDTO wasteManagerDTO);

//    List<WasteManagerAuthorization> findAllByIdWasteManager(Long idWasteManager);

}
