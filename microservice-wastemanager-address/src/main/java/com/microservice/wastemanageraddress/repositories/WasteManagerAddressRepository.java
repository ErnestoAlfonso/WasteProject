package com.microservice.wastemanageraddress.repositories;

import com.microservice.wastemanageraddress.entities.WasteManagerAddress;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface WasteManagerAddressRepository extends CrudRepository<WasteManagerAddress, Long> {
}
