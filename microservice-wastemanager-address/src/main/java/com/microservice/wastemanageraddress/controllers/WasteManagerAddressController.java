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
    public Optional<WasteManagerAddress> saveAddress(@RequestBody WasteManagerAddress wasteManagerAddress){
        return service.save(wasteManagerAddress);
    }

    @PutMapping("/update")
    public Optional<WasteManagerAddress> updateAddress(@RequestBody WasteManagerAddress wasteManagerAddress, BindingResult bindingResult){
        return service.update(wasteManagerAddress,bindingResult);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAllAddress(){
        return ResponseEntity.ok(service.findAll());
    }
    @GetMapping("/search/{id}")
    public Optional<WasteManagerAddress> findById(@PathVariable Long id){
        return service.findById(id);
    }

//    @GetMapping("/search-by-manager/{wasteManagerId}")
//    public WasteManagerAddress findByIdWasteManager(@PathVariable Long wasteManagerId){
//        return service.findByWaste(wasteManagerId);
//    }

}
