package com.microservice.wastemanager.services;

import com.microservice.wastemanager.dto.WasteManagerDTO;
import com.microservice.wastemanager.entities.WasteManager;
import com.microservice.wastemanager.http.response.WasteManagerByAddressResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Optional;

public interface IWasteManagerService {
    WasteManager findById(Long id);
    List<WasteManager> findAll();
    Optional<WasteManager> update(WasteManager wasteManager);
    WasteManager create(WasteManagerDTO wasteManagerDTO);

//    WasteManagerByAddressResponse findAddressByidWasteManager(Long wasteManagerId);
}
