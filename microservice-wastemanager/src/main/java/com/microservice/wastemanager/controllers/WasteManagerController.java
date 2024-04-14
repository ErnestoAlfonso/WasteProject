package com.microservice.wastemanager.controllers;

import com.microservice.wastemanager.dto.WasteManagerDTO;
import com.microservice.wastemanager.entities.WasteManager;
import com.microservice.wastemanager.services.IWasteManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/manager")
public class WasteManagerController {

    @Autowired
    private IWasteManagerService service;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> create(@RequestBody WasteManagerDTO wasteManagerDTO){
        return ResponseEntity.ok(service.create(wasteManagerDTO));
    }

    @PutMapping("/update")
    public  ResponseEntity<?> update(@RequestBody WasteManager wasteManager){
        Optional<WasteManager> wasteManager1 = service.update(wasteManager);
        if (wasteManager1.isPresent()){
            return ResponseEntity.status(HttpStatus.CREATED).body(wasteManager1.orElseThrow());
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

//    @GetMapping("/search-address/{wasteId}")
//    public ResponseEntity<?> findAddressByWasteId(@PathVariable Long wasteId){
//        return ResponseEntity.ok(service.findAddressByidWasteManager(wasteId));
//    }

}
