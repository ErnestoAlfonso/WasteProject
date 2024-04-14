package com.microservice.wastemanager.repositories;

import com.microservice.wastemanager.dto.WasteManagerDTO;
import com.microservice.wastemanager.entities.WasteManager;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WasteManagerRepository extends CrudRepository<WasteManager,Long> {
}
