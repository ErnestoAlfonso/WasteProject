package com.microservice.wastemanageraddress.services;

import com.microservice.wastemanageraddress.entities.WasteManagerAddress;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Optional;

public interface IWasteManagerAddressService {
    Optional<WasteManagerAddress> findById(Long id);
    List<WasteManagerAddress> findAll();

    Optional<WasteManagerAddress> update(WasteManagerAddress wasteManagerAddress, BindingResult bindingResult);
    Optional<WasteManagerAddress> save(WasteManagerAddress wasteManagerAddress);

}
