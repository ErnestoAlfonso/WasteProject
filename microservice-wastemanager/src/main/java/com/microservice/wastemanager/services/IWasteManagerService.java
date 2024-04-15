package com.microservice.wastemanager.services;

import com.microservice.wastemanager.dto.AddressDTO;
import com.microservice.wastemanager.dto.WasteManagerDTO;
import com.microservice.wastemanager.entities.WasteManager;
import com.microservice.wastemanager.http.response.AuthorizationByManagerResponse;
import com.microservice.wastemanager.http.response.WasteManagerByAddressResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Optional;

public interface IWasteManagerService {
    Optional<WasteManager> findById(Long idManager);
    List<WasteManager> findAll();
    ResponseEntity<?> update(WasteManager wasteManager);
    ResponseEntity<?> create(WasteManagerDTO wasteManagerDTO);

//    AddressDTO findAddressByidWasteManager(Long wasteManagerId);
}
