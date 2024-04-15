package com.microservice.wastemanager.repositories;

import com.microservice.wastemanager.entities.WasteManagerAuthorization;
import org.springframework.data.repository.CrudRepository;

public interface WasteManagerAuthorizationRepository extends CrudRepository<WasteManagerAuthorization,Long> {
//    List<WasteManagerAuthorization> findAllByIdWasteManager(Long idWasteManager);
}
