package com.microservice.wastemanagerauthorization.controllers;

import com.microservice.wastemanagerauthorization.dto.WasteManagerAuthorizationDTO;
import com.microservice.wastemanagerauthorization.entities.WasteManagerAuthorization;
import com.microservice.wastemanagerauthorization.servicies.WasteManagerAuthorizationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/authorization")
public class WasteManagerAuthorizationController {

    @Autowired
    private WasteManagerAuthorizationServiceImpl service;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> save(@RequestBody WasteManagerAuthorizationDTO wasteManagerAuthorizationDTO){
        return  ResponseEntity.ok(service.save(wasteManagerAuthorizationDTO));
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody WasteManagerAuthorization wasteManagerAuthorization){
        Optional<WasteManagerAuthorization> wasteManagerAuthorizationOptional = service.update(wasteManagerAuthorization);
        if (wasteManagerAuthorizationOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.CREATED).body(wasteManagerAuthorizationOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(service.findAll());
    }
    @GetMapping("/search/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }
}
