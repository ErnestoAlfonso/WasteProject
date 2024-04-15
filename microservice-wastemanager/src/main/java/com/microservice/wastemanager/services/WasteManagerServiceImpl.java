package com.microservice.wastemanager.services;

//import com.microservice.wastemanager.client.WasteManagerAddressClient;
import com.microservice.wastemanager.client.WasteManagerAddressClient;
import com.microservice.wastemanager.dto.AddressDTO;
import com.microservice.wastemanager.dto.WasteManagerDTO;
import com.microservice.wastemanager.entities.WasteManager;
import com.microservice.wastemanager.entities.WasteManagerAuthorization;
import com.microservice.wastemanager.http.response.WasteManagerByAddressResponse;
import com.microservice.wastemanager.repositories.WasteManagerAuthorizationRepository;
import com.microservice.wastemanager.repositories.WasteManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class WasteManagerServiceImpl implements IWasteManagerService{

    @Autowired
    private WasteManagerRepository repository;
    @Autowired
    private WasteManagerAuthorizationRepository wasteManagerAuthorizationRepository;
    @Autowired
    private WasteManagerAddressClient clientAddress;
//    @Autowired
//    private WasteManagerAuthorizationClient clientAuthorization;
//    @Autowired
//    private WasteManagerWasteAuthorizationServiceImpl wasteAuthorizationService;


    @Override
    public Optional<WasteManager> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<WasteManager> findAll() {
        return (List<WasteManager>) repository.findAll();
    }

    @Override
    public ResponseEntity<?> update(WasteManager wasteManager) {
        Optional<WasteManager> optionalWasteManager = repository.findById(wasteManager.getId());
        List<WasteManagerAuthorization> authList = wasteManager.getWasteAuthorizationList();
        List<Long> comparer = new ArrayList<>();

        // Avoid mistakes
        for (WasteManagerAuthorization item : authList){
            comparer.add(item.getId());
            Optional<WasteManagerAuthorization> e = wasteManagerAuthorizationRepository.findById(item.getId());
            if (e.isEmpty()){
                return ResponseEntity.badRequest().body("No existe alguno de los authorization");
            }
        }

        for (Long item : comparer){
            if (Collections.frequency(comparer,item)>1){
                return ResponseEntity.badRequest().body("No se puede añadir mas de una vez el mismo authorization");
            }
        }

        if(optionalWasteManager.isPresent()){
            WasteManager wasteManager1 = optionalWasteManager.orElseThrow();
            wasteManager1.setId(wasteManager.getId());
            wasteManager1.setName(wasteManager.getName());
            wasteManager1.setNif(wasteManager.getNif());
            wasteManager1.setVersion(wasteManager.getVersion());
            wasteManager1.setWasteManagerAddressId(wasteManager.getWasteManagerAddressId());
            wasteManager1.setWasteAuthorizationList(wasteManager.getWasteAuthorizationList());
            wasteManager1.setIsEnabled(wasteManager.getIsEnabled());
            wasteManager1.setCreatedDate(wasteManager.getCreatedDate());
            wasteManager1.setLastModifiedDate(wasteManager.getLastModifiedDate());


            return ResponseEntity.ok(repository.save(wasteManager1));
        }

        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<?> create(WasteManagerDTO wasteManagerDTO) {
        Optional<AddressDTO> optionalAddressDTO = clientAddress.findById(wasteManagerDTO.getWasteManagerAddressId());
        if(optionalAddressDTO.isEmpty()){
            return ResponseEntity.badRequest().body("No existe address con ese id");
        }
            WasteManager wasteManager = new WasteManager().builder()
                    .name(wasteManagerDTO.getName())
                    .nif(wasteManagerDTO.getNif())
                    .version(wasteManagerDTO.getVersion())
                    .wasteManagerAddressId(wasteManagerDTO.getWasteManagerAddressId())
                    .wasteAuthorizationList(wasteManagerDTO.getWasteAuthorizationList())
                    .isEnabled(wasteManagerDTO.getIsEnabled())
                    .createdDate(wasteManagerDTO.getCreatedDate())
                    .lastModifiedDate(wasteManagerDTO.getLastModifiedDate())
                    .build();

        return ResponseEntity.ok(repository.save(wasteManager));
    }


}
