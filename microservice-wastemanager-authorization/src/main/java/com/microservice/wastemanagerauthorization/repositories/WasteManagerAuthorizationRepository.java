package com.microservice.wastemanagerauthorization.repositories;

import com.microservice.wastemanagerauthorization.entities.WasteManagerAuthorization;
import org.springframework.data.repository.CrudRepository;

public interface WasteManagerAuthorizationRepository extends CrudRepository<WasteManagerAuthorization,Long> {
}
