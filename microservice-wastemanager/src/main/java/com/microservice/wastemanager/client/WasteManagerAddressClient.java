package com.microservice.wastemanager.client;

import com.microservice.wastemanager.dto.AddressDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "msvc-wastemanageraddress", url="localhost:8081/api/address")
public interface WasteManagerAddressClient {
    @GetMapping("/search/{id}")
    public Optional<AddressDTO> findById(@PathVariable Long id);
}
