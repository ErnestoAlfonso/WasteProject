package com.microservice.wastemanageraddress.services;

import com.microservice.wastemanageraddress.entities.WasteManagerAddress;
import com.microservice.wastemanageraddress.repositories.WasteManagerAddressRepository;
import jakarta.persistence.Column;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class WasteManagerAddressServiceImpl implements  IWasteManagerAddressService{

    @Autowired
    private WasteManagerAddressRepository repository;
    @Override
    public Optional<WasteManagerAddress> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<WasteManagerAddress> findAll() {
        return (List<WasteManagerAddress>) repository.findAll();
    }

    @Override
    public Optional<WasteManagerAddress> update(WasteManagerAddress wasteManagerAddress, BindingResult bindingResult) {
        Optional<WasteManagerAddress> optionalWasteManagerAddress = repository.findById(wasteManagerAddress.getId());

        if(optionalWasteManagerAddress.isPresent()){
            WasteManagerAddress wasteManagerAddress1 = optionalWasteManagerAddress.orElseThrow();
            wasteManagerAddress1.setId(wasteManagerAddress.getId());
            wasteManagerAddress1.setDirection(wasteManagerAddress.getDirection());
            wasteManagerAddress1.setVersion(wasteManagerAddress.getVersion());
            wasteManagerAddress1.setIsEnabled(wasteManagerAddress.getIsEnabled());
            wasteManagerAddress1.setCreatedDate(wasteManagerAddress.getCreatedDate());
            wasteManagerAddress1.setLastModifiedDate(wasteManagerAddress.getLastModifiedDate());


            return Optional.of(repository.save(wasteManagerAddress1));
        }

        return optionalWasteManagerAddress;
    }

    @Override
    public WasteManagerAddress save(WasteManagerAddress wasteManagerAddress) {
        return repository.save(wasteManagerAddress);
    }

}
