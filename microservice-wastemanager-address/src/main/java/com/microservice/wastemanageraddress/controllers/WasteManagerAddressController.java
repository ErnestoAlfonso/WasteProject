package com.microservice.wastemanageraddress.controllers;

import com.microservice.wastemanageraddress.entities.WasteManagerAddress;
import com.microservice.wastemanageraddress.services.IWasteManagerAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/address")
public class WasteManagerAddressController {
    @Autowired
    private IWasteManagerAddressService service;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> saveAddress(@RequestBody WasteManagerAddress wasteManagerAddress){
        return  ResponseEntity.ok(service.save(wasteManagerAddress));
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateAddress(@RequestBody WasteManagerAddress wasteManagerAddress, BindingResult bindingResult){
        Optional<WasteManagerAddress> wasteManagerAuthorizationOptional = service.update(wasteManagerAddress,bindingResult);
        if (wasteManagerAuthorizationOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.CREATED).body(wasteManagerAuthorizationOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAllAddress(){
        return ResponseEntity.ok(service.findAll());
    }
    @GetMapping("/search/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

//    @GetMapping("/search-by-manager/{wasteManagerId}")
//    public WasteManagerAddress findByIdWasteManager(@PathVariable Long wasteManagerId){
//        return service.findByWaste(wasteManagerId);
//    }

}
