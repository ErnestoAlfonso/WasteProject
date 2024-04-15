package com.microservice.wastemanager.dto;

import jakarta.persistence.Column;
import jakarta.ws.rs.ConstrainedTo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {
    private Long id;
    private String direction;
    private Long version = 0L;

    private Boolean isEnabled = Boolean.TRUE;
    private Date createdDate;
    private Date lastModifiedDate;
}
