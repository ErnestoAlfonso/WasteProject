package com.microservice.wastemanager.services;

//import com.microservice.wastemanager.client.WasteManagerAddressClient;
import com.microservice.wastemanager.dto.AddressDTO;
import com.microservice.wastemanager.dto.WasteManagerDTO;
import com.microservice.wastemanager.entities.WasteManager;
import com.microservice.wastemanager.http.response.WasteManagerByAddressResponse;
import com.microservice.wastemanager.repositories.WasteManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Optional;

@Service
public class WasteManagerServiceImpl implements IWasteManagerService{

    @Autowired
    private WasteManagerRepository repository;
//    @Autowired
//    private WasteManagerAddressClient client;


    @Override
    public WasteManager findById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public List<WasteManager> findAll() {
        return (List<WasteManager>) repository.findAll();
    }

    @Override
    public Optional<WasteManager> update(WasteManager wasteManager) {
        Optional<WasteManager> optionalWasteManager = repository.findById(wasteManager.getId());

        if(optionalWasteManager.isPresent()){
            WasteManager wasteManager1 = optionalWasteManager.orElseThrow();
            wasteManager1.setId(wasteManager.getId());
            wasteManager1.setName(wasteManager.getName());
            wasteManager1.setNif(wasteManager.getNif());
            wasteManager1.setVersion(wasteManager.getVersion());
            wasteManager1.setWasteManagerAddressId(wasteManager.getWasteManagerAddressId());
            wasteManager1.setIsEnabled(wasteManager.getIsEnabled());
            wasteManager1.setCreatedDate(wasteManager.getCreatedDate());
            wasteManager1.setLastModifiedDate(wasteManager.getLastModifiedDate());


            return Optional.of(repository.save(wasteManager1));
        }

        return optionalWasteManager;
    }

    @Override
    public WasteManager create(WasteManagerDTO wasteManagerDTO) {
        WasteManager wasteManager = new WasteManager().builder()
                .name(wasteManagerDTO.getName())
                .nif(wasteManagerDTO.getNif())
                .version(wasteManagerDTO.getVersion())
                .wasteManagerAddressId(wasteManagerDTO.getWasteManagerAddressId())
                .isEnabled(wasteManagerDTO.getIsEnabled())
                .createdDate(wasteManagerDTO.getCreatedDate())
                .lastModifiedDate(wasteManagerDTO.getLastModifiedDate())
                .build();
        return repository.save(wasteManager);
    }

//    @Override
//    public WasteManagerByAddressResponse findAddressByidWasteManager(Long wasteManagerId) {
//        //Consultar el id de WasteManager
//        WasteManager wasteManager = repository.findById(wasteManagerId).orElseThrow();
//
//        //Obtener el address
//        AddressDTO addressDTO = client.findByIdWasteManager(wasteManagerId);
//        return WasteManagerByAddressResponse.builder()
//                .name(wasteManager.getName())
//                .addressDTO(addressDTO)
//                .build();
//    }
}
