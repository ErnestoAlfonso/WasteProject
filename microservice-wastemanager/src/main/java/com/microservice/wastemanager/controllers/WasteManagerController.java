package com.microservice.wastemanager.controllers;

import com.microservice.wastemanager.dto.WasteManagerDTO;
import com.microservice.wastemanager.entities.WasteManager;
import com.microservice.wastemanager.services.IWasteManagerAuthorizationService;
import com.microservice.wastemanager.services.IWasteManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/manager")
public class WasteManagerController {

    @Autowired
    private IWasteManagerService service;

    @Autowired
    private IWasteManagerAuthorizationService wasteManagerAuthorizationService;


    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> create(@RequestBody WasteManagerDTO wasteManagerDTO){
        return ResponseEntity.ok(service.create(wasteManagerDTO));
    }

    @PutMapping("/update")
    public  ResponseEntity<?> update(@RequestBody WasteManager wasteManager){
        return ResponseEntity.ok(service.update(wasteManager));
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAllAddress(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("all/auth")
    public ResponseEntity<?> findAllAuth(){
        return ResponseEntity.ok(wasteManagerAuthorizationService.findAll());
    }
    @GetMapping("/search/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<WasteManager> wasteManager1 = service.findById(id);
        if (wasteManager1.isPresent()){
            return ResponseEntity.status(HttpStatus.FOUND).body(wasteManager1.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

}
